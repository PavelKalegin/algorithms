package application.dymnacprogramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

class Sequences {

    static void run(){
        task2();
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
    //longest not-increasing sub-sequence
    private static void task2(){
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            int size = Integer.parseInt(reader.readLine());
            int[] length = new int[size];
            int[] path = new int[size];
            int upperBound = 0;
            Arrays.fill(path, -1);

            int[] input = Stream.of(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int i = 0; i < size ; i++) {
                int tempIndex = upperBound;
                while(tempIndex > 0 && input[i] > input[length[tempIndex - 1]])
                {
                    tempIndex--;
                }
                length[tempIndex] = i;
                if (tempIndex == upperBound){
                    upperBound++;
                }
                if (tempIndex > 0){
                    path[i] = length[--tempIndex];
                }
            }

            System.out.println(upperBound);

            int index = length[upperBound -1];

            StringBuilder builder = new StringBuilder();
            while (path[index] != -1){
                builder.insert( 0,(index + 1) + " ");
                index = path[index];
            }
            builder.insert(0, (index + 1) + " ");
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
