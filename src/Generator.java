import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        try (PrintWriter printWriter = new PrintWriter("input.txt")){
            int n = 50000;
            int m = 50000;
            Random random = new Random();
            printWriter.println(n + " " + m);
            for (int i = 0; i < n ; i++) {
                int r = Math.abs(random.nextInt());
                int l = Math.abs(random.nextInt());
                printWriter.println(Math.min(l,r) + " " + Math.max(l,r));
            }
            for (int i= 0; i<m;i++){
                printWriter.print(Math.abs(random.nextInt()) + " ");
            }
            printWriter.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
