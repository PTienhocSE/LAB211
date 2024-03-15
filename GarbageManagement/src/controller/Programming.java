package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.GINFO;
import model.Garbage;
import model.Truck;

public class Programming implements GINFO {
    private final ArrayList<String> workLogs = new ArrayList<>();
    private final List<Garbage> gps = new ArrayList<>();
    private final Truck truck;
    private final Scanner scanner = new Scanner(System.in);

    public Programming() {
        this.truck = new Truck();
    }

    public void start() {
        input();
        int[] gws = new int[gps.size()];
        for (int i = 0; i < gps.size(); i++) {
            gws[i] = (int) gps.get(i).getgLoad();
        }
        truck.setCurPoint(0);
        truck.setCurLoad(0);
        truck.setTotalTime(0);
        truck.setTotalField(0);

        while (truck.getCurPoint() < gps.size()) {
            Garbage currentPoint = gps.get(truck.getCurPoint());
            if (truck.getCurLoad() + currentPoint.getgLoad() <= MAXLOAD) {
                truck.setCurLoad((int) (truck.getCurLoad() + currentPoint.getgLoad()));
                truck.setTotalTime(truck.getTotalTime() + AVG_TIME);
//                workLogs.add("Collect at point " + (truck.getCurPoint() + 1) + " in " + currentPoint.getAddr() + " on " + LocalDateTime.now());
                truck.setCurPoint(truck.getCurPoint() + 1);
            } else {
                goField();
            }
        }
        goHome(); 
    }

    public void input() {
        System.out.println("Nhập khối lượng rác tại mỗi trạm (kg): ");
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            int gLoad = Integer.parseInt(input[i]);
            gps.add(new Garbage(i + 1, gLoad, "Address " + (i + 1)));
        }
    }

    public void goField() {
        truck.setTotalTime(truck.getTotalTime() + AVG_HT);
        truck.setTotalField(truck.getTotalField() + 1);
        truck.setCurLoad(0);
//        workLogs.add("Go to field after point " + (truck.getCurPoint() > 0 ? truck.getCurPoint() - 1 : truck.getCurPoint()) + " on " + LocalDateTime.now());
    }

    public void goHome() {
        truck.setTotalTime(truck.getTotalTime() + AVG_HT);
        int totalSalary = (truck.getTotalTime() * SALARY) / 60;  
        int totalFee = (truck.getTotalField() + 1) * FEE;
        int totalCost = totalSalary + totalFee;
        
        for (String log : workLogs) {
            System.out.println(log);
        }
        System.out.println("Tổng chi phí là " + totalCost + "VND");
    }
}
