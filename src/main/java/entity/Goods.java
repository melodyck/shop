package entity;

public class Goods {
    private int gid;
    private double price;
    private String gname;
    private int bir;
    private int lid;
    private String description;

    public Goods() {
    }

    public Goods(int gid, double price, String gname, int bir, int lid, String descriptioin) {
        this.gid = gid;
        this.price = price;
        this.gname = gname;
        this.bir = bir;
        this.lid = lid;
        this.description = descriptioin;
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
        return bir;
    }

    public void setBid(int bir) {
        this.bir = bir;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
