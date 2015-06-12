package com.example.rom4ick.list;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
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
public class Fragment_Reg extends Fragment{

    Fragment_Manager my_f_m;
    CheckListPreferences clp;
    Context context;

    public Fragment_Reg(Fragment_Manager my_f_m, CheckListPreferences clp, Context context){
        this.my_f_m=my_f_m;
        this.clp=clp;
        this.context=context;
    }

    EditText editLog;
    EditText editPass;
    EditText editPassCon;
    private static final String TAG = "myLogs";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg, null);
        Log.v(TAG, "regActivity: onCreate()");
        editLog = (EditText)v.findViewById(R.id.editEmail);
        editPass = (EditText) v.findViewById(R.id.editPass1);
        editPassCon = (EditText) v.findViewById(R.id.editPass2);
        Button btnRegister = (Button) v.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v(TAG, "regActivity: regButton");
                if (editLog.getText().length()==0) {
                    Log.v(TAG, "Error");
                    Toast.makeText(context, "Вы не ввели E-mail!", Toast.LENGTH_LONG).show();
                }else
                if (editPass.getText().length()==0) {
                    Log.v(TAG, "regActivity: Error");
                    Toast.makeText(context, "Вы не ввели Password!", Toast.LENGTH_LONG).show();
                }else
                if (editPassCon.getText().length()==0) {
                    Log.v(TAG, "regActivity: Error");
                    Toast.makeText(context, "Вы не ввели повторно Password!", Toast.LENGTH_LONG).show();
                }else
                if (!editPass.getText().toString().equals(editPassCon.getText().toString())) {
                    Log.v(TAG, "regActivity: Error");
                    Toast.makeText(context, "Пароли не совпадают!", Toast.LENGTH_LONG).show();
                }else{
                    Log.v(TAG, "regActivity: Данные сохранены");
                    clp.addString(editLog.getText().toString(), editPass.getText().toString());
                    Toast.makeText(context, "Данные сохранены", Toast.LENGTH_LONG).show();
                    Log.v(TAG, "regActivity: regActivity -> logActivity");
                    Fragment_Log fragment_log=new Fragment_Log(my_f_m, clp, context);
                    my_f_m.replaceFragment(fragment_log);
                }
            }
        });
        return v;
    }
}
