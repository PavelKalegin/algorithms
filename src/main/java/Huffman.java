
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class Huffman {


    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Encoding\n2-Decoding");
        switch (scanner.nextInt()){
            case 1:encoding();break;
            case 2:decoding();break;
        }
    }

    private static void encoding(){
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        String tempInputStr = inputStr;
        Map<Character,Node> charNodeMap = new HashMap<>();
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();
        int tempLen;
        Character tempChar;
        while(tempInputStr.length()!=0){
            tempLen = tempInputStr.length();
            tempChar = tempInputStr.charAt(0);
            tempInputStr = tempInputStr.replaceAll(tempChar.toString(),"");
            LeafNode leafNode = new LeafNode(tempChar,tempLen-tempInputStr.length());
            charNodeMap.put(tempChar,leafNode);
            nodePriorityQueue.add(leafNode);
        }

        if (nodePriorityQueue.size()==1){
            nodePriorityQueue.add(new LeafNode(0));
        }

        int sum = 0;
        while (nodePriorityQueue.size() > 1) {
            Node first = nodePriorityQueue.poll();
            Node second  = nodePriorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            nodePriorityQueue.add(node);
        }
        Node root = nodePriorityQueue.poll();

        System.out.println(charNodeMap.size() + " " + sum);
        root.buildCode("");
        StringBuilder builder = new StringBuilder();
        for (char c : inputStr.toCharArray()) {
            builder.append(charNodeMap.get(c).code);
        }
        System.out.println(builder.toString());

    }

    private static void decoding(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0;i<size;i++){
            String line = scanner.nextLine();
            String[] strings =  line.split(": ");
                map.put(strings[1],strings[0]);
        }
        String inputStr = scanner.nextLine();
        String tempStr = "";
        StringBuilder builder = new StringBuilder();
        for (char c:inputStr.toCharArray()) {
            tempStr += c;
            if (map.containsKey(tempStr)){
                builder.append(map.get(tempStr));
                tempStr = "";
            }
        }
        System.out.println(builder.toString());
    }
}

class Node implements Comparable<Node>{
    final int sum;
    String code;

    void buildCode(String code){
        this.code = code;
    }
    Node(int sum) {
        this.sum = sum;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(sum,o.sum);
    }
}

class InternalNode extends Node {
    private Node left,right;

    InternalNode(Node left, Node right) {
        super(left.sum + right.sum);
        this.left = left;
        this.right = right;
    }

    @Override
    void buildCode(String code) {
        super.buildCode(code);
        left.buildCode(code + 0);
        right.buildCode(code + 1);
    }
}

class LeafNode extends Node{
    private char symbol;

    @Override
    void buildCode(String code) {
        super.buildCode(code);
        if (symbol != '\u0000'){
            System.out.println(symbol + ": "+code);
        }
    }

    LeafNode(char symbol, int sum) {
        super(sum);
        this.symbol = symbol;
    }
    LeafNode(int sum){
        super(sum);
    }
}


