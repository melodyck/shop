package entity;

public class Goods {
    private int gid;
    private double price;
    private String gname;
    private int bid;
    private int lid;
    private String descriptioin;

    public Goods() {
    }

    public Goods(int gid, double price, String gname, int bid, int lid, String descriptioin) {
        this.gid = gid;
        this.price = price;
        this.gname = gname;
        this.bid = bid;
        this.lid = lid;
        this.descriptioin = descriptioin;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getDescriptioin() {
        return descriptioin;
    }

    public void setDescriptioin(String descriptioin) {
        this.descriptioin = descriptioin;
    }
}
