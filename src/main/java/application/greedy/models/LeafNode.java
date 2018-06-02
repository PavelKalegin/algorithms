package application.greedy.models;

public class LeafNode extends Node{


    private char symbol;

    @Override
    public void buildCode(String code) {
        super.buildCode(code);
    }

    public LeafNode(char symbol, long sum) {
        super(sum);
        this.symbol = symbol;
    }
    public LeafNode(int sum){
        super(sum);
    }

    public char getSymbol() {
        return symbol;
    }
}
