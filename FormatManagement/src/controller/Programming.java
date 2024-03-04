package controller;

import model.Info;

/**
 *
 * @author phuct
 */
public class Programming {
    Validation valid = new Validation();
    Info info = new Info();
    public void run(){
        System.out.print("Phone number: ");
        String phone = valid.checkInputPhone();
        info.setPhone(phone);
        System.out.print("Date: ");
        String date = valid.checkInputDate();
        System.out.print("Email: ");
        String email = valid.checkInputEmail();
        info.setEmail(email);
        System.out.println("Info: " + info.toString());
    }
}
