package application.greedy;

import application.greedy.models.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
class GreedyService {

    List<Integer> greedyLines(List<Line> lines){
        List<Line> commonLines = new ArrayList<>();
        lines.sort(Comparator.comparing(Line::getL).thenComparing(Line::getR));
        commonLines.add(lines.get(0));
        lines.forEach(line -> {
                    Line currLine = commonLines.get(commonLines.size() - 1);
                    if (line.getL() > currLine.getL() && line.getL() <= currLine.getR()) {
                        currLine.setL(line.getL());
                        if (line.getR() < currLine.getR()) {
                            currLine.setR(line.getR());
                        }
                    } else if (line.getL() > currLine.getR()) {
                        commonLines.add(line);
                    }
                });
        return commonLines.stream()
                .map(Line::getR)
                .collect(Collectors.toList());
    }

     double greedyContinuousBackpack(ContinuousBackpack backpack){

        int capacity = backpack.getCapacity();
        double totalCost = 0;
        backpack.getItems().sort(Comparator.comparing(Item::getPrice).reversed());
        for (Item item: backpack.getItems()) {
            if (item.getValue() < capacity){
                capacity -= item.getValue();
                totalCost += (double) item.getCost();
            }else if (capacity == 0){
                break;
            }else{
                totalCost+= item.getPrice() * ((double) capacity );
                capacity = 0;
            }
        }
        return totalCost;
    }

    List<Integer> getAddends(long n){
        long k = (long) (Math.sqrt((double) (1 + 8 * n)) - 1)/2;

        return IntStream.concat(IntStream.range(1,(int)k), IntStream.of((int) (k + n - k*(k+1)/2)))
                .boxed()
                .collect(Collectors.toList());
    }

    String huffmanEncoding(String inputStr){

        Map<Character,Node> charNodeMap = new HashMap<>();
        java.util.PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Long> entry : inputStr.chars()
                .mapToObj((int value) -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()) {
            LeafNode node1 = new LeafNode(entry.getKey(), entry.getValue());
            nodePriorityQueue.add(node1);
            charNodeMap.put(node1.getSymbol(), node1);
        }

        if (nodePriorityQueue.size()==1){
            nodePriorityQueue.add(new LeafNode(0));
        }

        int sum = 0;
        while (nodePriorityQueue.size() > 1) {
            Node first = nodePriorityQueue.poll();
            Node second  = nodePriorityQueue.poll();
            Node node = new InternalNode(first, second);
            sum += node.getSum();
            nodePriorityQueue.add(node);
        }
        Node root = nodePriorityQueue.poll();

        root.buildCode("");
        StringBuilder builder = new StringBuilder();
        builder.append(charNodeMap.size())
                .append(" ")
                .append(sum)
                .append("\n");

        charNodeMap.forEach((key, value1) -> builder.append(key)
                .append(" : ")
                .append(value1.getCode())
                .append("\n"));

        inputStr.chars().mapToObj((int value) -> (char) value)
                .map(charNodeMap::get)
                .map(Node::getCode)
                .forEach(builder::append);

        return builder.toString();
    }

    String huffmanDecoding(Map<String,String> map, String inputStr){
        String tempStr = "";
        StringBuilder builder = new StringBuilder();
        for (char c:inputStr.toCharArray()) {
            tempStr += c;
            if (map.containsKey(tempStr)){
                builder.append(map.get(tempStr));
                tempStr = "";
            }
        }
        return builder.toString();
    }

    String priorityQueue(List<Command> commands)
    {
        List<Integer> queue = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (Command command : commands) {
            if (command.getType().equals(CommandType.INSERT)) {
                queue.add(command.getValue());
                ShiftUp(queue.size(), queue);
            } else if (command.getType().equals(CommandType.EXTRACTMAX)) {
                builder.append(queue.get(0))
                    .append("\n");
                swap(0, queue.size() - 1, queue);
                queue.remove(queue.size() - 1);
                ShiftDown(1, queue);
            }
        }
        return builder.toString();
    }



    private void ShiftUp(int index, List<Integer> queue){
        int parentIndex = index==1?1:(int)Math.round((index-1)/2.) ;
        if (queue.get(index-1) > queue.get(parentIndex-1)){
            swap(index-1,parentIndex-1, queue);
            ShiftUp(parentIndex, queue);
        }
    }

    private static void ShiftDown(int index, List<Integer> queue){
        int leftChildIndex = (index - 1) * 2 + 2;
        int rightChildIndex = (index - 1) * 2 + 3;
        //no exists only one child
        if (leftChildIndex == queue.size() && rightChildIndex > queue.size()){
            if (queue.get(index - 1) < queue.get(leftChildIndex - 1)){
                swap(index - 1,leftChildIndex - 1, queue);
                ShiftDown(leftChildIndex - 1, queue);
            }
        }
        if (leftChildIndex < queue.size()){
            if (queue.get(leftChildIndex-1) > queue.get(rightChildIndex-1)){
                if (queue.get(index-1) < queue.get(leftChildIndex-1)){
                    swap(index-1,leftChildIndex-1, queue);
                    ShiftDown(leftChildIndex, queue);
                }
            }else{
                if (queue.get(index-1) < queue.get(rightChildIndex-1)){
                    swap(index-1,rightChildIndex-1, queue);
                    ShiftDown(rightChildIndex, queue);
                }
            }
        }
    }

    private static void swap(int i,int j, List<Integer> queue){
        int temp = queue.get(i);
        queue.set(i,queue.get(j));
        queue.set(j,temp);
    }

}
