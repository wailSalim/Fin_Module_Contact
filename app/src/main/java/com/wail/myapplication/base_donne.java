package com.wail.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class base_donne extends SQLiteOpenHelper {
    public base_donne(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table if not exists utilisateur (ID INTEGER PRIMARY KEY AUTOINCREMENT,nom text,login text,password text,phone text )");
            db.execSQL("insert  into utilisateur(nom,login,password,phone)  values('wail 3alim','wail@','1111','0642632920')");
        db.execSQL("insert  into utilisateur(nom,login,password,phone)  values('adam','ad@','0000','0642632920')");

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int getcount(){
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor c=db.rawQuery("select * from utilisateur", null);
        int count = c.getCount();
        return count;
    }
    public ArrayList<utulisateur> list = new ArrayList<>();

    public ArrayList<utulisateur> getPersonne() {
//        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr = db.rawQuery("select * from utilisateur", null);
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            int id = cr.getInt(cr.getColumnIndexOrThrow("ID"));
            String nom = cr.getString(cr.getColumnIndexOrThrow("nom"));
            String login = cr.getString(cr.getColumnIndexOrThrow("login"));
            String pass = cr.getString(cr.getColumnIndexOrThrow("password"));
            String phone = cr.getString(cr.getColumnIndexOrThrow("phone"));
            utulisateur u=new utulisateur(nom,login,pass,phone);
            list.add(u);
            cr.moveToNext();
        }
        cr.close();
        db.close();
        return list;
    }
    public String mainlogin(String login, String password)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String[] userinfo = new String[]{login,password};
        Cursor c=db.rawQuery("select * from utilisateur where login = ? and password = ? ",userinfo);
        int count = c.getCount();
        c.moveToFirst();
        if (c!=null && count>0)
        {
            c.close();
            return "yes";
        }
        else{
            return "no";}}
    public void insertInfoUtilisateur(utulisateur p) {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("nom", p.nom_complet);
            cv.put("login", p.login);
            cv.put("password", p.pass);
            cv.put("phone", p.phone);
            db.insert("utilisateur", null, cv);
            db.close();
        }
        // modifier ModifierUtilisateur

    public void ModifierUtilisateur(utulisateur p,String log) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("login", p.login);
            cv.put("pass", p.pass);
            cv.put("nom", p.nom_complet);
            cv.put("phone", p.phone);
//            db.update("utilisateur", cv, "login like ?",new String[]{log});
            db.update("utilisateur",cv,"login like ?",new String[]{log});
            db.close();
        }

        //Suprimer uti
        public void Suprimer(String log) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete("utilisateur", "login=?", new String[]{log});
        }
        public ArrayList<utulisateur> getProph(String n) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cr;
        cr = db.rawQuery("select * from utilisateur where login like ? ", new String[]{n});
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            int id = cr.getInt(cr.getColumnIndexOrThrow("ID"));
            String name = cr.getString(cr.getColumnIndexOrThrow("nom"));
            String login = cr.getString(cr.getColumnIndexOrThrow("login"));
            String pass = cr.getString(cr.getColumnIndexOrThrow("password"));
            String phone = cr.getString(cr.getColumnIndexOrThrow("phone"));
            utulisateur ps = new utulisateur(name,login,pass,phone);
            ps.id = id;
            list.add(ps);
            cr.moveToNext();
        }
        cr.close();
        db.close();
        return list;
    }


    }