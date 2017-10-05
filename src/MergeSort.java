import java.io.*;

class MergeSort {
    private static int[] input;
    private static int[] temp;
    private static long count;

    static void run() {

        try(BufferedReader reader  = new BufferedReader(new FileReader("input.txt"))){

            int size = Integer.parseInt(reader.readLine());
            input = new int[size];
            temp = new int[size];
            String[] tokens = reader.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                input[i] = Integer.parseInt(tokens[i]);
            }
            mergeSort(0,size);
            System.out.println(count);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void mergeSort(int l, int r){
        if (r<=(l+1)) return;
        //a[l..r-1] -> a[l..m-1] a[m..r-1]
        int m = (l+r)>>1;
        mergeSort(l,m);
        mergeSort(m,r);
        merge(l,m,r);
    }

    private static void merge(int l, int m, int r){
        //input[l..m-1] input[m..r-1] -> temp[l..r-1] ->a[l..r-1]
        int i = l;
        int j = m;
        for (int k = l; k < r; k++) {
            if(j==r || (i<m && input[i] <= input[j])){
                temp[k] = input[i];
                i++;
            }else{
                count += m -i;
                temp[k] = input[j];
                j++;

            }

        }
        System.arraycopy(temp,l,input,l,r-l);

    }
}
