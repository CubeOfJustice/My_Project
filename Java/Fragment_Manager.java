package com.example.rom4ick.list;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.provider.CalendarContract;
import android.util.Log;

/**
 * Created by rom4ick on 02.06.2015.
 */
public class Fragment_Manager{

    private static final String TAG="myLog";
    private static Fragment_Manager instance;
    private static Context context;

    FragmentTransaction fragmentTransaction;


    private Fragment_Manager(){
        Log.v(TAG, "Fragment_Manager: Fragment_Manager()");
    }

    public static Fragment_Manager getInstance(){
        Log.v(TAG, "Fragment_Manager: getInstance()");
        if (instance==null)
        {
            instance = new Fragment_Manager();
        }
        return instance;

    }

    public void init(Context context){
        Log.v(TAG, "Fragment_Manager: init()");
        this.context=context;
    }

    public void addFragment(Fragment fragment){
        fragmentTransaction = ((Activity)context).getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.relativelayout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void replaceFragment(Fragment fragment){
        fragmentTransaction = ((Activity)context).getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.relativelayout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
