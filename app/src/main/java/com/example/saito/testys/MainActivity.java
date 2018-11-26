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

        // Sample01ページへの遷移
        // ボタンの取得とクリックリスナーをつける（他にもタッチリスナー、長押しリスナーがあるよ）
        Button sample01Button = findViewById(R.id.button01);
        sample01Button.setOnClickListener(new View.OnClickListener() {

            // クリックしたときの動作
            @Override
            public void onClick(View v) {
                // intentを作る。Activityを新しく始めるときにやる
                // 第一引数はApplicationかContext
                Intent intent = new Intent(getApplicationContext(), Sample01Activity.class);
                // Activity Start
                 startActivity(intent);
            }
        });

        // Sample02ページへの遷移
        // ボタンの取得とクリックリスナーをつける（他にもタッチリスナー、長押しリスナーがあるよ）
        Button sample02Button = findViewById(R.id.button02);
        sample02Button.setOnClickListener(new View.OnClickListener() {

            // クリックしたときの動作
            @Override
            public void onClick(View v) {
                // intentを作る。Activityを新しく始めるときにやる
                // 第一引数はApplicationかContext
                Intent intent = new Intent(getApplicationContext(), Sample02Activity.class);
                // Activity Start
                startActivity(intent);
            }
        });

        // Sample03ページへの遷移
        // ボタンの取得とクリックリスナーをつける（他にもタッチリスナー、長押しリスナーがあるよ）
        Button sample03Button = findViewById(R.id.button03 );
        sample03Button.setOnClickListener(new View.OnClickListener() {

            // クリックしたときの動作
            @Override
            public void onClick(View v) {
                // intentを作る。Activityを新しく始めるときにやる
                // 第一引数はApplicationかContext
                Intent intent = new Intent(getApplicationContext(), Sample03Activity.class);
                // Activity Start
                startActivity(intent);
            }
        });

        // Sample04ページへの遷移
        // ボタンの取得とクリックリスナーをつける（他にもタッチリスナー、長押しリスナーがあるよ）
        Button sample04Button = findViewById(R.id.button04 );
        sample04Button.setOnClickListener(new View.OnClickListener() {

            // クリックしたときの動作
            @Override
            public void onClick(View v) {
                // intentを作る。Activityを新しく始めるときにやる
                // 第一引数はApplicationかContext
                Intent intent = new Intent(getApplicationContext(), Sample04Activity.class);
                // Activity Start
                startActivity(intent);
            }
        });

        // Sample05ページへの遷移
        // ボタンの取得とクリックリスナーをつける（他にもタッチリスナー、長押しリスナーがあるよ）
        Button sample05Button = findViewById(R.id.button05 );
        sample05Button.setOnClickListener(new View.OnClickListener() {

            // クリックしたときの動作
            @Override
            public void onClick(View v) {
                // intentを作る。Activityを新しく始めるときにやる
                // 第一引数はApplicationかContext
                Intent intent = new Intent(getApplicationContext(), Sample05Activity.class);
                // Activity Start
                startActivity(intent);
            }
        });

        // Sample05ページへの遷移
        // ボタンの取得とクリックリスナーをつける（他にもタッチリスナー、長押しリスナーがあるよ）
        Button sample06Button = findViewById(R.id.button06);
        sample06Button.setOnClickListener(new View.OnClickListener() {

            // クリックしたときの動作
            @Override
            public void onClick(View v) {
                // intentを作る。Activityを新しく始めるときにやる
                // 第一引数はApplicationかContext
                Intent intent = new Intent(getApplicationContext(), Sample06Activity.class);
                // Activity Start
                startActivity(intent);
            }
        });
    }

}