/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phuct
 */
public class Garbage {
    private int oid;
    private double gLoad;
    private String addr;

    public Garbage() {
    }

    public Garbage(int oid, double gLoad, String addr) {
        this.oid = oid;
        this.gLoad = gLoad;
        this.addr = addr;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public double getgLoad() {
        return gLoad;
    }

    public void setgLoad(double gLoad) {
        this.gLoad = gLoad;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    
}
