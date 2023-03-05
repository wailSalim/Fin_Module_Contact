package com.wail.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ressit extends AppCompatActivity {
    public String tmp;
    public base_donne db=new base_donne(ressit.this,"contact",null,1);
    ArrayList<utulisateur> arrayList=new ArrayList<utulisateur>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ressit);
        ListView listView;
        Bundle extras = getIntent().getExtras();
        tmp= extras.getString("log");
        listView=findViewById(R.id.lis);
        arrayList.addAll(db.getPersonne());
        prophil adapter=new prophil(this,db.getProph(tmp));
        listView.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.rm,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        listView=findViewById(R.id.ListAffichParDericteur);
        switch (item.getItemId()){
            case R.id.call:
                Toast.makeText(this, "call ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.close:
                Toast.makeText(this, "close ", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.sea:
                Intent intent=new Intent(ressit.this,calcul.class);
                startActivity(intent);
                return true;
            case R.id.mo:
                Intent i=new Intent(ressit.this,Pro.class);
                i.putExtra("log",tmp);
                startActivity(i);
                return true;
            case R.id.su:
                db.Suprimer(tmp);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}