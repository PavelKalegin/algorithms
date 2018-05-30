package application.greedy.models;

import java.util.List;

public class ContinuousBackpack {
    private List<Item> items;
    private int capacity;

    public ContinuousBackpack() {
    }

    public ContinuousBackpack(List<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
