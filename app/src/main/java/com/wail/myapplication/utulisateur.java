package com.wail.myapplication;

public class utulisateur {

    public  int id;
    public String login;
    public String pass;
    public String nom_complet;
   public String phone;
    public utulisateur(String nom_complet,String login,String pass,String phone){
        this.login = login;
        this.pass = pass;
        this.phone = phone;
        this.nom_complet=nom_complet;
    }

}

