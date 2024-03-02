
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import model.Fruit;
import model.Order;
import view.Menu;


public class FruitManagement extends Menu {

    Scanner sc = new Scanner(System.in);
    ArrayList<Fruit> fruitList = new ArrayList<>();
    Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();

    public FruitManagement(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createFruit(fruitList);
                break;
            case 2:
                viewOrder(ht);
                break;
            case 3:
                buyItem(fruitList, ht);
                break;
            case 4:
                System.exit(0);
        }
    }
    
    public void createFruit(ArrayList<Fruit> fruitList){
        while (true) {            
            System.out.print("Enter fruit ID: ");
            String id = Validation.checkInputString();
            if (!Validation.checkIdExist(fruitList, id)) {
                System.out.println("ID exsit!!!");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            System.out.print("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            fruitList.add(new Fruit(id, fruitName, price, quantity, origin));
            if (!Validation.checkInputYN()) {
                return;
            }
        }
    }
    
    public void displayFruit(ArrayList<Fruit> fruitList){
        if (!fruitList.isEmpty()) {
            int countItem = 1;
            System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
            for (Fruit fruit : fruitList) {
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());    
            }
        }
        else{
            System.out.println("List fruit is empty!!");
        }
    }
    
    public void displayListOrder(ArrayList<Order> orderList) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : orderList) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(), order.getQuantity(), order.getPrice(), order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }
    
    public void viewOrder(Hashtable<String, ArrayList<Order>> ht) {
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> orderList = ht.get(name);
            displayListOrder(orderList);
        }
    }
    
    public void buyItem(ArrayList<Fruit> fruitList, Hashtable<String, ArrayList<Order>> ht) {
    if (fruitList.isEmpty()) {
        System.err.println("List item is empty!!");
        return;
    }

    ArrayList<Order> orderList = new ArrayList<>();
    while (true) {
        displayFruit(fruitList);
        System.out.print("Enter item: ");
        int item = Validation.checkInputIntLimit(1, fruitList.size());
        
        //item > 0:check xem item co > 0 hay khong
        //item <= fruitList.size() dam bao item khong vuot qua so luong phan tu trong dsach
        //fruitList.get(item - 1).getQuantity() > 0 kiem tra so luong cua item duoc chon fruitList.get(item - 1) co lon hon 0 hay khong
        if (item > 0 && item <= fruitList.size() && fruitList.get(item - 1).getQuantity() > 0) {
            Fruit fruit = fruitList.get(item - 1);
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);

            if (!Validation.checkItemExist(orderList, fruit.getFruitId())) {
                updateOrder(orderList, fruit.getFruitId(), quantity);
            } else {
                orderList.add(new Order(fruit.getFruitId(), fruit.getFruitName(), quantity, fruit.getPrice()));
            }

            if (!Validation.checkInputYN()) {
                break;
            }
        } else {
            System.err.println("Invalid item. Please choose again.");
        }
    }

    displayListOrder(orderList);
    System.out.print("Enter name: ");
    String name = Validation.checkInputString();
    ht.put(name, orderList);
    System.err.println("Add successful");
}

    
    public void updateOrder(ArrayList<Order> orderList, String fruitID, int quantity){
        for (Order order : orderList) {
            if(order.getFruitId().equalsIgnoreCase(fruitID)){
                order.setQuantity(order.getQuantity()+quantity);
                return;
            }
        }
    }
    
}
