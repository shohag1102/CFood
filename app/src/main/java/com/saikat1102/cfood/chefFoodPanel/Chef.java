package com.saikat1102.cfood.chefFoodPanel;

public class Chef {

    private String  ConfirmPassword, Emailid, Fname, House, Lname, Mobile, Password;

    // Press Alt+Insert


    public Chef(String confirmPassword, String emailid, String fname, String lname, String mobile, String password) {
        ConfirmPassword = confirmPassword;
        Emailid = emailid;
        Fname = fname;
        Lname = lname;
        Mobile = mobile;
        Password = password;
    }

    public Chef() {
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getEmailid() {
        return Emailid;
    }

    public void setEmailid(String emailid) {
        Emailid = emailid;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getHouse() {
        return House;
    }

    public void setHouse(String house) {
        House = house;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}