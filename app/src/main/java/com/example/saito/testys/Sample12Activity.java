package com.example.saito.testys;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Sample12Activity extends AppCompatActivity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static int MP = LinearLayout.LayoutParams.MATCH_PARENT;

    private final static String TAG_WRITE = "write";
    private final static String TAG_READ = "read";
    private final static String TAG_CLEAR = "clear";
    private final static String DB_NAME = "testDB.db";
    private final static String DB_TABLE = "testDB";
    private final static int DB_VERSION = 1;

    private EditText editText_company;
    private EditText editText_price;
    private TextView textView;
    private DBHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.LTGRAY);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        editText_company = new EditText(this);
        editText_company.setText("");
        editText_company.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        layout.addView(editText_company);

        editText_price = new EditText(this);
        editText_price.setText("");
        editText_price.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        layout.addView(editText_price);

        layout.addView(makeButton("書き込み", TAG_WRITE));
        layout.addView(makeButton("読み込み", TAG_READ));
        layout.addView(makeButton("データクリア", TAG_CLEAR));

        textView = new TextView(this);
        textView.setText("");
        textView.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        layout.addView(textView);



    }


    private Button makeButton(String text, String tag){
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));

        return button;
    }

    @Override
    public void onClick(View v) {
        String tag = (String)v.getTag();

        if( TAG_WRITE.equals(tag)){
            try {

                if( helper == null )
                    helper = new DBHelper(this);

                if( db == null )
                    db = helper.getWritableDatabase();

                String str_com = editText_company.getText().toString();
                String str_price = editText_price.getText().toString();
                writeDB(db, str_com, Integer.valueOf(str_price));
                editText_company.setText("書き込み成功");

            } catch (Exception e){
                editText_company.setText("書き込み失敗");
            }
        } else if (TAG_READ.equals(tag)){
            try {
                readDB();
                editText_company.setText("読み込み成功");

            } catch (Exception e){
                editText_company.setText("読み込み失敗");
            }
        } else if (TAG_CLEAR.equals(tag)){
            try {
                clearAllDB();
                editText_company.setText("全データ削除成功");
            } catch (Exception e){
                editText_company.setText("全データ削除失敗");

            }
        }
    }

    private void writeDB(SQLiteDatabase db, String com, int price) throws Exception {

        ContentValues values = new ContentValues();

        values.put("company", com);
        values.put("stockprice", price);

        db.insert(DB_TABLE, null, values);

    }

    private void readDB() throws Exception {

        if( helper == null )
            helper = new DBHelper(this);

        if( db == null )
            db = helper.getReadableDatabase();

        Cursor cursor = db.query(
                DB_TABLE, new String[]{"company", "stockprice"},
                null, null,null, null, null
        );

        cursor.moveToFirst();
        StringBuilder sbuilder = new StringBuilder();

        for( int i = 0; i < cursor.getCount(); i++ ){
            sbuilder.append(cursor.getString(0));
            sbuilder.append(": ");
            sbuilder.append(cursor.getInt(1));
            sbuilder.append("\n");
            cursor.moveToNext();
        }

        cursor.close();
        textView.setText(sbuilder.toString());
    }

    private void clearAllDB() throws Exception{
        if ( helper == null ){
            return ;
        }

        if( db == null ) {
            db = helper.getReadableDatabase();
        }

        db.delete(DB_TABLE, null, null);
        textView.setText("");
    }

    @Override
    // キー操作
    // onKeyDownはboolなのでなんらかのbool結果を返す必要がある
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 戻るボタンをタップ

            if( db != null ) {
                db.delete(DB_TABLE, null, null);
            }

            this.finish();      // このActivityを終了させる
            return true;
        }
        return false;
    }

}
