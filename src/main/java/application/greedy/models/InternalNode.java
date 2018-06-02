package application.greedy.models;

public class InternalNode extends Node {
    private Node left,right;

    public InternalNode(Node left, Node right) {
        super(left.getSum() + right.getSum());
        this.left = left;
        this.right = right;
    }

    @Override
    public void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + 0);
        right.buildCode(code + 1);
    }
}

