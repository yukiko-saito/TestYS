package com.example.saito.testys;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Sample08Activity extends AppCompatActivity {

    private static final int MENU_ITEM0 = 0;
    private static final int MENU_ITEM1 = 1;
    private static final int MENU_ITEM2 = 2;
    private static final int MENU_ITEM3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        MenuItem item0 = menu.add( 0, MENU_ITEM0, 0, "アイテム0");
        item0.setIcon(android.R.drawable.ic_menu_camera);
//        item0.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem item1 = menu.add(0, MENU_ITEM1, 0, "アイテム1");
        item1.setIcon(android.R.drawable.ic_menu_call);
        item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem item2 = menu.add(0, MENU_ITEM2, 0, "アイテム2");
        item2.setIcon(android.R.drawable.ic_menu_add);
        item2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem item3 = menu.add(0, MENU_ITEM3, 0, "アイテム3");
        item3.setIcon(android.R.drawable.ic_menu_delete);
//        item3.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemId = item.getItemId();

        if( itemId == MENU_ITEM0){
            toast("アイテム0を押した");
        } else if( itemId == MENU_ITEM1){
            toast("アイテム1を押した");
        } else if( itemId == MENU_ITEM2){
            toast("アイテム2を押した");
        } else if( itemId == MENU_ITEM3) {
            toast("アイテム3を押した");
        }

        return true;
    }

    private void toast( String text ){
        if( text == null ) text = "";
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
