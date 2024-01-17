
import controller.FruitManagement;


public class main {
    public static void main(String[] args) {
        String mChon[] = {"Create Fruit", "View orders", "Shopping (for buyer)", "Exit"};
        FruitManagement studentManagement = new FruitManagement("FRUIT SHOP SYSTEM", mChon);
        studentManagement.run();
    }
}
