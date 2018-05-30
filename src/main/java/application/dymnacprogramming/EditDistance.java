package application.dymnacprogramming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

final class EditDistance {
    static void run(){
        task();
    }
    private static void task()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))){
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            EditDistanceImpl editDistance = new EditDistanceImpl(str1, str2);
            System.out.println(editDistance.editDistance());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class EditDistanceImpl
{
    private String str1,str2;

    private int[][] d;

    private String getStr1() {
        return str1;
    }

    private String getStr2() {
        return str2;
    }


    EditDistanceImpl(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        d = new int[str1.length() + 1][ str2.length() + 1];
    }

    int editDistance()
    {

        for (int i = 0; i <= getStr1().length() ; i++) {
            for (int j = 0; j <= getStr2().length(); j++) {
                if (i == 0 && j == 0) {
                    d[i][j] = 0;
                } else if (i == 0) {
                    d[i][j] = j;
                } else if (j == 0) {
                    d[i][j] = i;
                } else {
                    int res1 = d[i][j - 1] + 1;
                    int res2 = d[i - 1][j] + 1;
                    int res3 = d[i - 1][j - 1] + (getStr1().charAt(i - 1) == getStr2().charAt(j - 1) ? 0 : 1);
                    d[i][j] = Math.min(Math.min(res1, res2), res3);
                }
            }
        }
        return d[getStr1().length()][getStr2().length()];
    }
}
