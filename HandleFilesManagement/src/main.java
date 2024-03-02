
import controller.Programming;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phuct
 */
public class main {
    public static void main(String[] args) {
        String mChon[] = {"Find person info","Copy Text to new file", "Exit"};
        Programming program = new Programming("========== File Processing =========", mChon);
        program.run();
    }
}
