package com.wail.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Pro extends AppCompatActivity {
    EditText log,nom,pass,phone;
    public base_donne db=new base_donne(Pro.this,"login",null,1);
    public String tmp;
    public utulisateur u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);
        log=findViewById(R.id.nom_Pro);
        nom=findViewById(R.id.log_Pro);
        pass=findViewById(R.id.pas_Pro);
        phone=findViewById(R.id.phone_Pro);
        Button b;
        Bundle extras = getIntent().getExtras();
        tmp= extras.getString("log");
        ArrayList<utulisateur> a = new ArrayList<utulisateur>();
        a=db.getProph(tmp);
        for (utulisateur u:a
             ) {
            log.setText(String.valueOf(u.login));
            nom.setText(String.valueOf(u.nom_complet));
            pass.setText(String.valueOf(u.pass));
            phone.setText(String.valueOf(u.phone));
        }

        b=findViewById(R.id.save);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u=new utulisateur(nom.getText().toString(),log.getText().toString(),pass.getText().toString(),phone.getText().toString());
                db.ModifierUtilisateur(u,tmp);
            }
        });

    }
}