package application.greedy.models;

public class Item {
    private int value, cost;


    Item(int cost, int value) {
        this.cost = cost;
        this.value = value;
    }

    public Item() {
    }

    public int getCost() {
        return cost;
    }

    public int getValue() {
        return value;
    }

    public double getPrice() {
        return (double)cost/value;
    }
}
