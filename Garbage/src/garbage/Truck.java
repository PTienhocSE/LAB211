package garbage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Truck implements GINFO {
    private int curLoad, totalTime, totalField, curPoint;
    private final ArrayList<String> workLogs = new ArrayList<>();
    private final List<GarbagePoint> gps = new ArrayList<>();

    public Truck(int[] gws) {
        for (int i = 0; i < gws.length; i++) {
            gps.add(new GarbagePoint(i + 1, gws[i], "Address " + (i + 1)));
        }
    }

    public void start() {
        while (curPoint < gps.size()) {
            GarbagePoint currentPoint = gps.get(curPoint);
            if (curLoad + currentPoint.getgLoad() <= MAXLOAD) {
                curLoad += currentPoint.getgLoad();
                totalTime += AVG_TIME;
                workLogs.add("Collect at point " + (curPoint + 1) + " in " + currentPoint.getAddr() + " on " + java.time.LocalDateTime.now());
                curPoint++;
            } else {
                goField();
            }
        }
        goHome(); 
    }

    public void goField() {
        totalTime += AVG_HT;
        totalField++;
        curLoad = 0;
        workLogs.add("Go to field after point " + (curPoint > 0 ? curPoint - 1 : curPoint) + " on " + LocalDateTime.now());
    }

    public void goHome() {
    totalTime += AVG_HT;
    int totalSalary = (totalTime * SALARY) / 60;  
    int totalFee = (totalField+1) * FEE;
    int totalCost = totalSalary + totalFee;
    
//    for (String log : workLogs) {
//        System.out.println(log);
//    }
    System.out.println("Tong chi phi la " + totalCost + "đ");
}

}
