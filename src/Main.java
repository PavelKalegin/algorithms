public class Main {
    public static void main(String[] args){
        //Factorials.run();
        //GreedyAlg.run();
        //Huffman.run();
        //PriorityQueue.run();
        //BinarySearch.run();
        //MergeSort.run();
        //QuickSort3.run();

        long starTime = System.currentTimeMillis();
        Sequences.run();
        long finishTime = System.currentTimeMillis();
        System.out.println("\n" + (finishTime-starTime) + " ms");
    }
}
