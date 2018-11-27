package com.example.saito.testys;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Sample06Activity extends AppCompatActivity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static String BR = System.getProperty("line.separator");
    private final static String TAG_MESSAGE = "0";
    private final static String TAG_MESSAGE_2 = "02";
    private final static String TAG_YESNO = "1";
    private final static String TAG_TEXT = "2";
    private final static String TAG_IMAGE = "3";
    private final static String TAG_CHKBOX = "4";

    private final static int RADIO0_ID = 0;
    private final static int RADIO1_ID = 1;

    private CheckBox checkBox01;
    private CheckBox checkBox02;
    private CheckBox checkBox03;
    private CheckBox checkBox04;
    private Button button;
    private RadioGroup radioGroup;
    private Spinner spinner;

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        textView = new TextView(this);
        textView.setText("これはテキストビューのテスト");
        textView.setTextSize(16.0f);
        textView.setTextColor(Color.rgb(0,0,255));
        textView.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));

        checkBox01 = new CheckBox(this);
        checkBox01.setText("チェックボックス1");
        checkBox01.setChecked(true);
        checkBox01.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        checkBox02 = new CheckBox(this);
        checkBox02.setText("チェックボックス2");
        checkBox02.setChecked(true);
        checkBox02.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        checkBox03 = new CheckBox(this);
        checkBox03.setText("チェックボックス3");
        checkBox03.setChecked(true);
        checkBox03.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        checkBox04 = new CheckBox(this);
        checkBox04.setText("チェックボックス4");
        checkBox04.setChecked(true);
        checkBox04.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));

        layout.addView(textView);
        layout.addView(makeButton("メッセージダイアログを表示", TAG_MESSAGE));
        layout.addView(makeButton2("メッセージダイアログを表示_v2", TAG_MESSAGE_2));
        layout.addView(makeButton("YesNoダイアログを表示", TAG_YESNO));
        layout.addView(makeButton("テキストダイアログを表示", TAG_TEXT));
        layout.addView(makeButton(res2bmp(this, R.drawable.illust_bear), TAG_IMAGE));

        button = new Button(this);
        button.setText("結果表示");
        button.setTag(TAG_CHKBOX);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        layout.addView(button);
        layout.addView(checkBox01);
        layout.addView(checkBox02);
        layout.addView(checkBox03);
        layout.addView(checkBox04);

        RadioButton radio0 = new RadioButton(this);
        radio0.setId(RADIO0_ID);
        radio0.setText("ラジオボタン0");
        radio0.setTextColor(Color.RED);

        RadioButton radio1 = new RadioButton(this);
        radio1.setId(RADIO1_ID);
        radio1.setText("ラジオボタン1");
        radio1.setTextColor(Color.BLUE);

        radioGroup = new RadioGroup(this);
        radioGroup.addView(radio0);
        radioGroup.addView(radio1);
        radioGroup.check(0);
        radioGroup.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));

        layout.addView(radioGroup);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        String[] strs = {"RED","BLUE","YELLOW","PINK","WHITE"};
        for( int i = 0; i < strs.length; i++){
            adapter.add(strs[i]);
        }
        spinner = new Spinner(this);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        layout.addView(spinner);

    }

    public Bitmap res2bmp(Context context, int resID){
        return BitmapFactory.decodeResource(context.getResources(), resID);
    }

    private Button makeButton(String text, String tag){
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        return button;
    }

    private Button makeButton2(String text, String tag){
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        return button;
    }

    private ImageButton makeButton(Bitmap bmp, String tag){
        ImageButton button = new ImageButton(this);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setImageBitmap(bmp);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC,WC));
        return button;
    }

    public void onClick(View view){
        String tag = (String)view.getTag();

        if( TAG_MESSAGE.equals(tag))
            MessageDialog.show(this, "メッセージダイアログ", "ボタンを押しました");
        else if( TAG_MESSAGE_2.equals(tag)) {
            MessageDialog.show(this, "メッセージダイアログ_v2", "ボタンを押しました");
            this.setTextView("メッセージダイアログ_v2を押しました");
        } else if( TAG_YESNO.equals(tag))
            YesNoDialog.show(this, "Yes/Noダイアログ","Yes/Noを選択");
        else if( TAG_TEXT.equals(tag))
            TextDialog.show(this, "テキストダイアログ","テキストを入力");
        else if( TAG_IMAGE.equals(tag))
            MessageDialog.show(this, "","イメージボタンを押した");
        else if( TAG_CHKBOX.equals(tag))
            toast(
                "checkbox01>" + checkBox01.isChecked() + BR +
                "checkbox02>" + checkBox02.isChecked() + BR +
                "checkbox03>" + checkBox03.isChecked() + BR +
                "checkbox04>" + checkBox04.isChecked() + BR +
                "radioButton>" + radioGroup.getCheckedRadioButtonId() + BR +
                "spinner>" + spinner.getSelectedItem() );
    }

    private void toast(String text) {
        if( text == null ) text = "";
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void setTextView(String message){
        textView.setText(message);
    }

    public static class MessageDialog extends DialogFragment {
        public static void show(
                Activity activity, String title, String text
        ) {
            MessageDialog f = new MessageDialog();
            Bundle args = new Bundle();
            args.putString("title", title);
            args.putString("text", text);
            f.setArguments(args);
            f.show(activity.getFragmentManager(), "messageDialog");

        }

        @Override
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setTitle(getArguments().getString("title"));
            ad.setMessage(getArguments().getString("text"));

            ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }

            });

            return ad.create();


        }
    }

    public static class YesNoDialog extends DialogFragment {
        public static void show(Activity activity, String title, String text
        ) {
            YesNoDialog f = new YesNoDialog();
            Bundle args = new Bundle();

            args.putString("title", title);
            args.putString("text", text);
            f.setArguments(args);
            f.show(activity.getFragmentManager(), "YesNoDialog");
        }

        @Override
        public Dialog onCreateDialog(Bundle bundle){
            DialogInterface.OnClickListener listener =
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        if( which == DialogInterface.BUTTON_POSITIVE )
                            MessageDialog.show(getActivity(),"","YES");
                        else if (which == DialogInterface.BUTTON_NEGATIVE)
                            MessageDialog.show(getActivity(),"","NO");
                    }
                };
            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setTitle(getArguments().getString("title"));
            ad.setMessage(getArguments().getString("text"));
            ad.setPositiveButton("Yes", listener);
            ad.setNegativeButton("No", listener);

            return ad.create();
        }
    }

    public static class TextDialog extends DialogFragment {
        private EditText editText;

        public static void show(
                Activity activity, String title, String text
        ){
            TextDialog f = new TextDialog();
            Bundle args = new Bundle();
            args.putString("title", title);
            args.putString("text", text);
            f.setArguments(args);
            f.show(activity.getFragmentManager(), "textDialog");

        }

        @Override
        public Dialog onCreateDialog(Bundle bundle){
            DialogInterface.OnClickListener listener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MessageDialog.show(getActivity(), "", editText.getText().toString());
                    }
                };

            editText = new EditText(getActivity());

            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setTitle(getArguments().getString("title"));
            ad.setMessage(getArguments().getString("text"));
            ad.setView(editText);
            ad.setPositiveButton("OK", listener);
            ad.setNegativeButton("NG", null);

            if( bundle != null) editText.setText(bundle.getString("editText", ""));

            return ad.create();
        }

        @Override
        public void onSaveInstanceState(Bundle bundle){
            super.onSaveInstanceState(bundle);
            bundle.putString("editText", editText.getText().toString());
        }
    }

    @Override
    // キー操作
    // onKeyDownはboolなのでなんらかのbool結果を返す必要がある
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 戻るボタンをタップ
            this.finish();      // このActivityを終了させる
            return true;
        }
        return false;
    }

}
