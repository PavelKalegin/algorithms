package application.greedy.models;

public abstract class Node implements Comparable<Node>{

    private final long sum;
    private String code;


    public long getSum() {
        return sum;
    }

    public String getCode() {
        return code;
    }

    public void buildCode(String code){
        this.code = code;
    }
    Node(long sum) {
        this.sum = sum;
    }
    @Override
    public int compareTo(Node o) {
        return Long.compare(getSum(), o.getSum());
    }
}
