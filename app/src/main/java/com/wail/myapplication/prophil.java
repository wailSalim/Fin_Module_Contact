package com.wail.myapplication;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class prophil extends BaseAdapter {
    public Context context;
    LayoutInflater layoutInflater;
    public ArrayList<utulisateur> arrayList;
    public prophil(Context con,ArrayList<utulisateur> arrayList1){

        this.arrayList=arrayList1;
        this.context=con;
        layoutInflater=LayoutInflater.from(con);

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    //    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.activity_prophil,null);
        TextView L,n,p,s,id;

        id=(TextView)convertView.findViewById(R.id.id_dess);
        n=(TextView)convertView.findViewById(R.id.nom_dess);
        L=(TextView)convertView.findViewById(R.id.log_dess);
        p= (TextView)convertView.findViewById(R.id.pas_dess);
        s=(TextView)convertView.findViewById(R.id.phone_dess);
        id.setText(String.valueOf(arrayList.get(position).id));
        n.setText(arrayList.get(position).nom_complet);
        L.setText(arrayList.get(position).login);
        p.setText(arrayList.get(position).pass);
        s.setText(arrayList.get(position).phone);
        return convertView;
    }
}

