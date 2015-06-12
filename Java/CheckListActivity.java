package com.example.rom4ick.list;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheckListActivity extends ActionBarActivity implements OnClickListener{

    private static final String TAG = "myLogs";

    Button newView;
    ListView listView;
    ArrayList<Model>arrayList=new ArrayList<Model>();
    String user;

    ArrayList<String>z = new ArrayList<String>();
    ArrayList<String>o = new ArrayList<String>();
    ArrayList<String>d = new ArrayList<String>();
    ArrayList<String>c = new ArrayList<String>();

    String zadacha="zadacha";
    String opisanie="opisanie";
    String data="data";
    String check="check";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);
        Log.v(TAG, "CheckListActivity: onCreate ");
        Intent intent=getIntent();

        user=intent.getStringExtra("user");
        newView = (Button)findViewById(R.id.newView);
        newView.setOnClickListener(this);
        listView = (ListView) findViewById(R.id.listView);

        restoreList(zadacha,z);
        restoreList(opisanie,o);
        restoreList(data,d);
        restoreList(check,c);

        boolean ch=false;

        if(z!=null) {
            for (int i = 0; i < z.size(); i++) {
                if (c.get(i).equals("1")) ch = true;
                if (c.get(i).equals("0")) ch = false;
                arrayList.add(new Model(z.get(i), o.get(i), d.get(i), ch));
                listView.setAdapter(new MyAdapter(this, arrayList,c));
            }
        }
    }

    public void onClick(View v){
        Log.v(TAG, "CheckListActivity: onClick()");
        switch (v.getId()) {
            case R.id.newView:
                Log.v(TAG, "CheckListActivity: newView");
                Intent intent=new Intent(this, ItemActivity.class);
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }
        z.add(data.getStringExtra("Z"));
        o.add(data.getStringExtra("O"));
        d.add(data.getStringExtra("D"));
        c.add(data.getStringExtra("C"));
        boolean ch=false;
        if(data.getStringExtra("C").equals("0")) ch=false;
        if(data.getStringExtra("C").equals("1")) ch=true;

        arrayList.add(new Model(data.getStringExtra("Z"), data.getStringExtra("O"), data.getStringExtra("D"), ch));
        listView.setAdapter(new MyAdapter(this,arrayList,c));
    }

    protected void saveList(String s,ArrayList<String>list){
        Log.d(TAG, "CheckListActivity: saveList()");
        FileOutputStream fos;
        try {
            fos = openFileOutput(user + s + ".txt", Context.MODE_PRIVATE);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return;
        }
        String str;
        for(int i=0; i<list.size(); i++)
        try {
            str=list.get(i)+"\n";
            fos.write(str.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void restoreList(String s,ArrayList<String>list){
        Log.d(TAG, "CheckListActivity: restoreList()");
        FileInputStream fis;
        try {
            fis = openFileInput(user+s+".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ;
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String str;
        try {
            while (true){
                str=br.readLine();
                if(str == null){
                    Log.d(TAG, "str == null");
                    break;
                }
                list.add(str);
            }
        }catch (IOException e){
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_list, menu);
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
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "CheckListActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "CheckListActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "CheckListActivity: onPause()");
    }

    @Override
      protected void onStop() {
        super.onStop();
        Log.v(TAG, "regActivity: onStop()");
        saveList(this.zadacha, z);
        saveList(this.opisanie, o);
        saveList(this.data, d);
        saveList(this.check, c);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "CheckListActivity: onDestroy()");
    }

    protected void onRestart(){
        super.onRestart();
        Log.v(TAG, "CheckListActivity: onRestart()");
    }
}
