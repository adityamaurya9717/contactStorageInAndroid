package com.example.contact_storage;

public class DataAuthenication {

    public String Myname="",Myemail="";
    String Myphone="";
    public DataAuthenication(String name,String  phone,String email){
        this.Myemail=email;
        this.Myname=name;
        this.Myphone=phone;

    }
    public Boolean getName(){
        if(Myname.length()==0 ||Myname.equals("") || Myname.equals(null)){

            return  false;
        }
        else{
            return true;
        }
    }

    public Boolean getphoneNumber(){
        if(String.valueOf(Myphone).equals("")){
            return false;

        }
        else {
            return true;
        }
    }
    public Boolean getEmail(){

        if(Myemail.length()==0 ||Myemail.equals("")|| Myemail.equals(null)){

            return false;
        }
        else{return true;}
    }

}
