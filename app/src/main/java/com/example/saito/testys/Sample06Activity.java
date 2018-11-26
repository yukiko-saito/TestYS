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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Sample06Activity extends AppCompatActivity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static String TAG_MESSAGE = "0";
    private final static String TAG_MESSAGE_2 = "02";
    private final static String TAG_YESNO = "1";
    private final static String TAG_TEXT = "2";
    private final static String TAG_IMAGE = "3";

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

        layout.addView(textView);
        layout.addView(makeButton("メッセージダイアログを表示", TAG_MESSAGE));
        layout.addView(makeButton2("メッセージダイアログを表示_v2", TAG_MESSAGE_2));
        layout.addView(makeButton("YesNoダイアログを表示", TAG_YESNO));
        layout.addView(makeButton("テキストダイアログを表示", TAG_TEXT));
        layout.addView(makeButton(res2bmp(this, R.drawable.illust_bear), TAG_IMAGE));

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
}
