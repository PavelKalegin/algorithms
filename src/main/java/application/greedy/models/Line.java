package application.greedy.models;

public class Line {
    private int l,r;
    Line(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public Line() {
    }

    public int getL() {
        return l;
    }
    public int getR() {
        return r;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setR(int r) {
        this.r = r;
    }
}
