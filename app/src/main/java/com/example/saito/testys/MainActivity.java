package com.example.saito.testys;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hogeページへの遷移
        Button hogeButton = (Button) findViewById(R.id.button1);
        hogeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SampleActivity.class);
                startActivity(intent);
            }
        });

    }



    private void Btn1ClickEvent(View v){
        /*
        final PrintCount printCount = new PrintCount();
        for( int i = 0; i < 3; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    printCount.read();
                }
            }).start();
        }
        */
    }

    class PrintCount {
        private int count;
        public void read() {
            synchronized (this) {
                count++;
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {

                }
                System.out.println("read count = " + count);
            }
        }
    }
}
