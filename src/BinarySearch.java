import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class BinarySearch {
    static void run(){
        try(Scanner scanner = new Scanner(new File("input.txt"))) {
            int[] arr = new int[scanner.nextInt()];
            for (int i=0;i<arr.length;i++){
                arr[i] = scanner.nextInt();
            }
            int size = scanner.nextInt();
            StringBuilder builder = new StringBuilder("");
            for (int i=0;i<size;i++){
                builder.append(findIndex(arr,scanner.nextInt())+ " ");
            }
            System.out.println(builder.toString());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int findIndex(int arr[],int value){
        int startI = 0;
        int endI = arr.length-1;
        int mid;
        while (startI<=endI){
            mid = startI + (endI-startI)/2;
            if (value  < arr[mid]){
                endI = mid-1;
            }else if (value > arr[mid]) {
                startI = mid + 1;
            }else if (value == arr[mid]){
                return mid+1;
            }
        }
        return -1;
    }

}
