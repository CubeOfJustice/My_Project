package com.example.rom4ick.list;

/**
 * Created by rom4ick on 30.05.2015.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;



public class CheckListPreferences {

    private static Context context;
    private static CheckListPreferences instance;
    private String PASS="password";
    private static final String TAG = "myLogs";
    SharedPreferences sPref;



    private CheckListPreferences(){
        Log.v(TAG, "CheckListPreference: CheckListPreference()");
    }

    public static CheckListPreferences getInstance() {
        Log.v(TAG, "CheckListPreference: getInstance()");
        if (instance==null)
        {
            instance = new CheckListPreferences();
        }
        return instance;
    }

    public void init(Context context){
        Log.v(TAG, "CheckListPreference: init()");
        this.context = context;
    }

    public void addString(String user, String pas){
        Log.v(TAG, "CheckListPreference: addString()");
        sPref = context.getSharedPreferences(user, 0);
        Editor editor = this.sPref.edit();
        editor.putString(PASS, pas);
        editor.commit();
    }

    public String getString(String user) {
        Log.v(TAG, "CheckListPreference: getString()");
        SharedPreferences prefs = context.getSharedPreferences(user, 0);
        String value = prefs.getString(PASS, "");
        return value;
    }
}
