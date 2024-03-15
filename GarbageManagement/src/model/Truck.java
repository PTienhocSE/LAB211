/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author phuct
 */
public class Truck {
     private int curLoad, totalTime, totalField, curPoint;

    
    public Truck(int curLoad, int totalTime, int totalField, int curPoint) {
        this.curLoad = curLoad;
        this.totalTime = totalTime;
        this.totalField = totalField;
        this.curPoint = curPoint;
    }

    public Truck() {
    this.curLoad = 0;
    this.totalTime = 0;
    this.totalField = 0;
    this.curPoint = 0;
    }


    public int getCurLoad() {
        return curLoad;
    }

    public void setCurLoad(int curLoad) {
        this.curLoad = curLoad;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalField() {
        return totalField;
    }

    public void setTotalField(int totalField) {
        this.totalField = totalField;
    }

    public int getCurPoint() {
        return curPoint;
    }

    public void setCurPoint(int curPoint) {
        this.curPoint = curPoint;
    }

    @Override
    public String toString() {
        return "Truck{" + "curLoad=" + curLoad + ", totalTime=" + totalTime + ", totalField=" + totalField + ", curPoint=" + curPoint + '}';
    }
      
}
