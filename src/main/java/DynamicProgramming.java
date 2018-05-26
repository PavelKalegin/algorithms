import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public final class DynamicProgramming {
    public static void run() {
        task1();
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
}

