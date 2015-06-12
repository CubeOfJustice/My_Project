package com.example.rom4ick.list;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_Manual extends Fragment {
    Fragment_Manager fm;
    CheckListPreferences clp;
    Context context;

    public Fragment_Manual(Fragment_Manager fm, CheckListPreferences clp, Context context){
        this.fm=fm;
        this.clp=clp;
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_manual, null);
        Button btnNext = (Button) v.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment_Log fragment_log = new Fragment_Log(fm, clp, context);
                fm.replaceFragment(fragment_log);
            }
        });
        return v;
    }
}
