public class Main {
    public static void main(String[] args){
        //Factorials.run();
        //GreedyAlg.run();
        //Huffman.run();
        //PriorityQueue.run();
        //BinarySearch.run();
        //MergeSort.run();
        long starTime = System.currentTimeMillis();
        QuickSort3.run();
        long finishTime = System.currentTimeMillis();
        System.out.println("\n" + (finishTime-starTime) + " ms");
    }
}
