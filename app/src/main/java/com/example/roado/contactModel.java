package com.example.roado;

public class contactModel {
    String  name,type,phn,location,charge,discription;

    contactModel(){

    }
    public contactModel(String name, String type, String phn, String location, String charge, String discription) {
        this.name = name;
        this.type = type;
        this.phn = phn;
        this.location = location;
        this.charge = charge;
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
