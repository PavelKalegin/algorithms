import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

final class Knapsack {
    static void run(){
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String[] inputs = reader.readLine().split(" ");
            int weight = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            int[] weights =   Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] matrix = new int[weight + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= weight; j++) {
                    matrix[j][i] = matrix[j][i-1];
                    if (weights[i - 1] <= j)
                    {
                        matrix[j][i] = Math.max(matrix[j][i], matrix[j - weights[i - 1]][i - 1] + weights[i - 1]);
                    }
                }
            }
            System.out.println(matrix[weight][n]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
