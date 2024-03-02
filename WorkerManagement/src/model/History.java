
package model;

/**
 *
 * @author phuct
 */
public class History extends Worker implements Comparable<History>{
    private String date;
    private String status;

    public History() {
    }

    public History(String date, String status) {
        this.date = date;
        this.status = status;
    }

    public History(String date, String status, String id, String name, int age, int salary, String workLocation) {
        super(id, name, age, salary, workLocation);
        this.date = date;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "History{" + "date=" + date + ", status=" + status + '}';
    }

    
    @Override
    public int compareTo(History t) {
        return this.getId().compareTo(t.getId());
    }
}
