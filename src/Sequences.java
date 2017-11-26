import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Sequences {

    static void run(){
        task1();
    }

    private static void task1(){
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            int size = Integer.parseInt(reader.readLine());
            int[] input = new int[size];
            int[] buffer = new int[size];
            String[] inputStr = reader.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                input[i] = Integer.parseInt(inputStr[i]);
            }

            for (int i = 0; i < size; i++) {
                buffer[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (input[i]%input[j]==0  && buffer[j] + 1  > buffer[i]){
                        buffer[i] = buffer[j] + 1;
                    }
                }
            }
            System.out.println(Arrays.stream(buffer).max().getAsInt());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void task2(){
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            int size = Integer.parseInt(reader.readLine());
            int[] input = new int[size];
            int[] buffer = new int[size];
            String[] inputStr = reader.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                input[i] = Integer.parseInt(inputStr[i]);
            }

            for (int i = 0; i < size; i++) {
                buffer[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (input[i]%input[j]==0  && buffer[j] + 1  > buffer[i]){
                        buffer[i] = buffer[j] + 1;
                    }
                }
            }
            System.out.println(Arrays.stream(buffer).max().getAsInt());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
