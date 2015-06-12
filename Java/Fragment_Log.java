package com.example.rom4ick.list;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by rom4ick on 02.06.2015.
 */
public class Fragment_Log extends Fragment {
    private static final String TAG="myLog";

    Fragment_Manager my_f_m;
    CheckListPreferences clp;
    Context context;


    EditText editLog;
    EditText editPass;


    private String user;
    private String pass;

    public Fragment_Log(Fragment_Manager my_f_m, CheckListPreferences clp, Context context){
        this.my_f_m=my_f_m;
        this.clp=clp;
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_log, null);
        editLog = (EditText) v.findViewById(R.id.editLogIn);
        editPass = (EditText)v.findViewById(R.id.editPassword);
        Button btnLogIn = (Button) v.findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "Fragment_Log: logButton");
                if (editLog.getText().length()==0) {
                    Log.v(TAG, "logActivity: Error");
                    Toast.makeText(context, "Вы не ввели E-mail!", Toast.LENGTH_LONG).show();
                }else {
                    if (editPass.getText().length() == 0) {
                        Log.v(TAG, "Fragment_Log: Error");
                        Toast.makeText(context, "Вы не ввели Password!", Toast.LENGTH_LONG).show();
                    }
                else{
                    user = editLog.getText().toString();
                    pass = clp.getString(user);

                    if (pass.length() == 0) {
                        Log.v(TAG, "Fragment_Log: Error");
                        Toast.makeText(context, "Вы ввели неверный E-mail", Toast.LENGTH_LONG).show();

                    }else {

                if (!pass.equals(editPass.getText().toString())) {
                    Log.v(TAG, "Fragment_Log: Error");
                    Toast.makeText(context, "Вы ввели неверный Password", Toast.LENGTH_LONG).show();

                }else {
                    Intent intent;
                    intent = new Intent(context, CheckListActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }}}}
            }
        });
        Button btnSignUp = (Button) v.findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment_Reg fragment_reg = new Fragment_Reg(my_f_m, clp, context);
                my_f_m.replaceFragment(fragment_reg);
            }
        });
        return v;
    }
}
