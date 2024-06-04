package com.example.roado;

public class fviewmodel {
    String type,qty,phn,add,amount;
fviewmodel()
{

}
    public fviewmodel(String type, String qty, String phn, String add,String amount) {
        this.type = type;
        this.qty = qty;
        this.phn = phn;
        this.add = add;
        this.amount = amount;

    }


    public String getamount() {
        return amount;
    }

    public void setamount(String amount) {
        this.amount = amount;
    }

    public String getqty() {
        return qty;
    }

    public void setqty(String qty) {
        this.qty = qty;
    }

    public String getphn() {
        return phn;
    }

    public void setphn(String phn) {
        this.phn = phn;
    }

    public String getadd() {
        return add;
    }

    public void setadd(String add) {
        this.add = add;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }
}
