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

public class Fragment_Main extends Fragment {
    Fragment_Manager fm;
    CheckListPreferences clp;
    Context context;

    public Fragment_Main(Fragment_Manager my_f_m, CheckListPreferences my_p_m, Context context){
        this.fm=my_f_m;
        this.clp=my_p_m;
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment__main, null);
        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment_Manual fragment_manual=new Fragment_Manual(fm, clp, context);
                fm.replaceFragment(fragment_manual);
            }
        });
        return v;
    }
}
