package com.example.rom4ick.list;

import android.util.Log;

/**
 * Created by rom4ick on 30.05.2015.
 */
public class Model {

    private static final String TAG = "myLogs";
    public String name;
    public String ex;
    public String data;
    public boolean check;

    public Model(String _name, String _ex, String _data, boolean _check){
        Log.v(TAG, "Model: Model()");
        name=_name;
        ex=_ex;
        data=_data;
        check=_check;
    }


}
