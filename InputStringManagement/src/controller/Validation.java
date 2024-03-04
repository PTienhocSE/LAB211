/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author phuct
 */
public class Validation {
    public boolean isPerfectSquare(int n) {
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            return true;
        }
        return false;
    }
}
