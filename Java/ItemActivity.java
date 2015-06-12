package com.example.rom4ick.list;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ItemActivity extends ActionBarActivity implements View.OnClickListener{
    private static final String TAG="myLogs";

    TextView Z;
    TextView O;
    TextView D;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "ItemActivity: onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Z=(TextView)findViewById(R.id.editZ);
        O=(TextView)findViewById(R.id.editO);
        D=(TextView)findViewById(R.id.editD);
        button=(Button)findViewById(R.id.buttonItem);
        button.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Log.v(TAG, "ItemActivity: onClick()");
        Intent intent = new Intent();
        intent.putExtra("Z", Z.getText().toString());
        intent.putExtra("O", O.getText().toString());
        intent.putExtra("D", D.getText().toString());
        intent.putExtra("C", "0");
        setResult(RESULT_OK,intent);
        finish();
    }
}
