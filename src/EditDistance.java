import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EditDistance {
    static void run(){

    }
    private static void task()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String str1 = reader.readLine();
            String str2 = reader.readLine();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
