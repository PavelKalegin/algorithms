import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public final class DynamicProgramming {
    public static void run() {
        task2();
    }

    private static void task1()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            reader.readLine();
            int[] values = new int[3];
            Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(
                            value -> {
                                values[2] = value +  Math.max(values[0], values[1]);
                                values[0] = values[1];
                                values[1] = values[2];
                            }
                    );
            System.out.println(values[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void task2()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            int input = Integer.parseInt(reader.readLine());
            StringBuilder builder = new StringBuilder();
            int[][] arr = new int[input + 1][2]; //1st - value, 2nd - count operations,3rd - operation( 0 - x+1, 1 - 2x, 2 - 3x)

            for (int i = 1; i <= input ; i++) {
                // +1
                if (i + 1 <= input){
                    if  ((arr[i][0]+1) < arr[i+1][0] || arr[i+1][0] == 0){
                        arr[i+1][0] = arr[i][0] + 1;
                        arr[i+1][1] = 0;
                    }
                }
                // 2x
                if (i * 2 <= input){
                    if ((arr[i][0] + 1) < arr[2*i][0] || arr[2*i][0] == 0){
                        arr[2*i][0] = arr[i][0] + 1;
                        arr[2*i][1] = 1;
                    }
                }
                // 3x
                if (i * 3 <= input){
                    if ((arr[i][0] + 1) < arr[3*i][0] || arr[3*i][0] == 0){
                        arr[3*i][0] = arr[i][0] + 1;
                        arr[3*i][1] = 2;
                    }
                }
            }
            System.out.println(arr[input][0]);
            int index = input;
            while (index !=0){
                builder.insert(0,index + " ");
                switch (arr[index][1]){
                    case 2: index = index/3;break;
                    case 1: index = index/2;break;
                    case 0: index--;
                }
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

