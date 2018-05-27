import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class QuickSort3 {

    static  void run(){
        //BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String[] inputs = reader.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int m = Integer.parseInt(inputs[1]);
            int[] ls = new int[n];
            int[] rs = new int[n];
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                inputs = reader.readLine().split(" ");
                ls[i] = Integer.parseInt(inputs[0]);
                rs[i] = Integer.parseInt(inputs[1]);
            }
            String[] tokens = reader.readLine().split(" ");
            Arrays.sort(ls);//implement quick sort here !!!
            Arrays.sort(rs);//!!!!!

            int value;
            for (int i = 0; i < m; i++) {
                value = Integer.parseInt(tokens[i]);
                int rCount = 0;
                int lCount = 0;
                while (lCount<n && value >= ls[lCount]){
                    lCount++;
                }

                while(rCount <n && value > rs[rCount]){
                    rCount++;
                }
                builder.append(lCount - rCount).append(" ");
            }
            System.out.println(builder.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void QuickSort(int[] arr,int l,int r){
    }

    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }



}

