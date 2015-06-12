package com.example.rom4ick.list;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by rom4ick on 30.05.2015.
 */
public class MyAdapter extends BaseAdapter {

    private static final String TAG = "myLogs";
    Context context;
    ArrayList<Model> arrayList=new ArrayList<Model>();
    ArrayList<String>checked;
    CheckBox checkBox;

    MyAdapter(Context context, ArrayList<Model> arrayList, ArrayList<String>check) {
        super();
        this.context = context;
        if(arrayList!=null) {
            this.arrayList = arrayList;
        }
        this.checked=check;
    }


    @Override
    public int getCount() {
        Log.v(TAG, "MyAdapter: getCount()" + arrayList.size());
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        Log.v(TAG, "MyAdapter: getItem()");
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        Log.v(TAG, "MyAdapter: getItemId()");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v(TAG, "MyAdapter: getView()");
        LayoutInflater inflater = LayoutInflater.from(context);
        if(convertView==null) {
            convertView=inflater.inflate(R.layout.activity_view_list,parent,false);
        }
        Model m=getModel(position);
        TextView textZadacha=(TextView)convertView.findViewById(R.id.textZadacha);
        TextView textOpisanie=(TextView)convertView.findViewById(R.id.textOpisanie);
        TextView textData=(TextView)convertView.findViewById(R.id.textData);
        textZadacha.setText(arrayList.get(position).name);
        textOpisanie.setText(arrayList.get(position).ex);
        textData.setText(arrayList.get(position).data);
        checkBox=(CheckBox)convertView.findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(soccl);
        checkBox.setTag(position);
        checkBox.setChecked(arrayList.get(position).check);
        return convertView;
    }

    private OnCheckedChangeListener soccl= new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (getModel((Integer) buttonView.getTag()).check == isChecked){
                checked.remove((Integer) buttonView.getTag());
                checked.add((Integer) buttonView.getTag(), "1");
            }else {
                checked.remove((Integer) buttonView.getTag());
                checked.add((Integer) buttonView.getTag(), "0");
            }
        }
    };

    Model getModel(int position) {
        return ((Model) getItem(position));
    }
}
