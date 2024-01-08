package garbage;

public class GarbagePoint {
    private int oid;
    private double gLoad;
    private String addr;

    public GarbagePoint() {
        
    }

    public GarbagePoint(int oid, double gLoad, String addr) {
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

    @Override
    public String toString() {
        return "GarbagePoint{" + "oid=" + oid + ", gLoad=" + gLoad + ", addr=" + addr + '}';
    }
}