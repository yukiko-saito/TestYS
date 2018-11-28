package com.example.saito.testys;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class Sample11Activity extends AppCompatActivity implements View.OnClickListener{


    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static int MP = LinearLayout.LayoutParams.MATCH_PARENT;

    private final static String TAG_WRITE_NEW = "write_new";
    private final static String TAG_READ_NEW = "read_new";
    private final static String TAG_WRITE_ADD = "write_add";
    private final static String TAG_READ_ADD = "read_add";
    private final static String TAG_TEXT_RESET = "text_reset";
    private final static String TAG_FILE_RESET = "file_reset";


    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        editText = new EditText(this);
        editText.setText("");
        editText.setLayoutParams(new LinearLayout.LayoutParams(MP, WC));
        layout.addView(editText);

        layout.addView(makeButton("新規書き込み", TAG_WRITE_NEW));
        layout.addView(makeButton("新規読み込み", TAG_READ_NEW));
        layout.addView(makeButton("追加書き込み", TAG_WRITE_ADD));
        layout.addView(makeButton("追加読み込み", TAG_READ_ADD));
        layout.addView(makeButton("テキストボックスをリセット", TAG_TEXT_RESET));
        layout.addView(makeButton("ファイルをリセット", TAG_FILE_RESET));

    }

    private Button makeButton(String text, String tag){
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));

        return button;
    }

    public void onClick(View v ){
        String tag = (String)v.getTag();

        if( TAG_WRITE_NEW.equals(tag)){
            try{
                String str = editText.getText().toString();
                data2file( this, str.getBytes(), "test.txt");
                toast("新規書き込み成功");
            } catch( Exception e) {
                editText.setText("新規書き込み失敗");
            }
        } else if( TAG_READ_NEW.equals(tag)){
            try {
                String str = new String( file2data(this, "test.txt"));
                editText.setText(str);
                toast( "新規読み込み成功");
            } catch (Exception e){
                File file = new File("test.txt");
                if( file.exists() )
                    editText.setText("新規読み込み失敗");
                else
                    editText.setText("読み込むファイルが存在しません");
            }
        } else if(TAG_WRITE_ADD.equals(tag)){
            try{
                StringBuffer sbuf = new StringBuffer();
                String str = editText.getText().toString();
                sbuf.append(str);
                str = new String(file2data(this, "test.txt"));
                sbuf.append(str);
                data2file( this, sbuf.toString().getBytes(), "test.txt");
                toast("追加書き込み成功");
            } catch( Exception e) {
                editText.setText("追加書き込み失敗");
            }
        } else if( TAG_READ_ADD.equals(tag)){
            try {
                String str1 = editText.getText().toString();
                String str2 = new String( file2data(this, "test.txt"));
                editText.setText(str1 + str2);
                toast( "追加読み込み成功");
            } catch (Exception e){
                editText.setText("追加読み込み失敗");
            }
        } else if( TAG_TEXT_RESET.equals(tag) ){
            editText.setText("");
            toast( "テキストボックスリセット");
        } else if( TAG_FILE_RESET.equals(tag)){
            try{
                if ( getApplicationContext().deleteFile("test.txt") )
                    toast( "ファイル削除成功");
                else
                    toast("ファイル削除失敗");

            } catch (Exception e){
                toast( "ファイル削除失敗");

            }
        }
    }

    private static void data2file( Context context, byte[] w, String fname) throws Exception {
        OutputStream out = null;

        try {
            out = context.openFileOutput(fname, Context.MODE_PRIVATE);
            out.write(w, 0, w.length);
            out.close();
        } catch (Exception e){
            try {
                if( out != null ) out.close();
            } catch (Exception e2 ){

            }
            throw e;
        }
    }

    private static byte[] file2data( Context context, String fname) throws Exception {
        int size;
        byte[] w = new byte[1024];
        InputStream in = null;
        ByteArrayOutputStream out = null;

        try{
            in = context.openFileInput(fname);

            out = new ByteArrayOutputStream();
            while( true ){
                size = in.read(w);
                if( size <= 0 ) break;
                out.write(w, 0, size);
            }
            out.close();

            in.close();

            return out.toByteArray();
        } catch (Exception e){
            try{
                if( in != null ) in.close();
                if( out != null) out.close();
            } catch(Exception e2){

            }
            throw e;
        }
    }

    private void toast( String text ){
        if( text == null ) text = "";
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}
