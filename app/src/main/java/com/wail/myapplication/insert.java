package com.wail.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class insert extends AppCompatActivity {
       public String lo,pa,pho,Na;
       public utulisateur u;
       public base_donne db=new base_donne(insert.this,"login",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        EditText l,p,N,ph;
        Button b;
        N=findViewById(R.id.nom_Pro);
        l=findViewById(R.id.log_Pro);
        p=findViewById(R.id.pas_Pro);
        ph=findViewById(R.id.phone_Pro);
        lo=l.getText().toString();
        Na=N.getText().toString();
        pa=p.getText().toString();
        pho=ph.getText().toString();
        b=findViewById(R.id.save);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               u=new utulisateur(Na,lo,pa,pho);
               db.insertInfoUtilisateur(u);
               Toast.makeText(insert.this, "enregistre avec succes", Toast.LENGTH_SHORT).show();
           }
       });
    }
}