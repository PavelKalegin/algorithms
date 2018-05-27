import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

final class PriorityQueue {
    private static ArrayList<Integer> queue = new ArrayList<>();

    static void run(){
        System.out.println("Data will be reading from file input.txt");
        try (Scanner scanner = new Scanner(new File("input.txt"))){
            int countIteration = scanner.nextInt();
            String command;
            queue.clear();
            while (countIteration > 0){
                command = scanner.next();
                if (command.compareTo("Insert")==0){
                    queue.add(scanner.nextInt());
                    ShiftUp(queue.size());
                }else if (command.compareTo("ExtractMax")==0){
                    System.out.println(queue.get(0));
                    swap(0,queue.size()-1);
                    queue.remove(queue.size()-1);
                    ShiftDown(1);
                }
                countIteration--;
            }

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    private static void ShiftUp(int index){
        int parentIndex = index==1?1:(int)Math.round((index-1)/2.) ;
        if (queue.get(index-1) > queue.get(parentIndex-1)){
            swap(index-1,parentIndex-1);
            ShiftUp(parentIndex);
        }
    }

    private static void ShiftDown(int index){
        int leftChildIndex = (index - 1) * 2 + 2;
        int rightChildIndex = (index - 1) * 2 + 3;
        //no exists only one child
        if (leftChildIndex == queue.size() && rightChildIndex > queue.size()){
            if (queue.get(index-1) < queue.get(leftChildIndex-1)){
                swap(index-1,leftChildIndex-1);
                ShiftDown(leftChildIndex-1);
            }
        }
        if (leftChildIndex < queue.size()){
            if (queue.get(leftChildIndex-1) > queue.get(rightChildIndex-1)){
                if (queue.get(index-1) < queue.get(leftChildIndex-1)){
                    swap(index-1,leftChildIndex-1);
                    ShiftDown(leftChildIndex);
                }
            }else{
                if (queue.get(index-1) < queue.get(rightChildIndex-1)){
                    swap(index-1,rightChildIndex-1);
                    ShiftDown(rightChildIndex);
                }
            }
        }
    }

    private static void swap(int i,int j){
        int temp = queue.get(i);
        queue.set(i,queue.get(j));
        queue.set(j,temp);
    }

}
