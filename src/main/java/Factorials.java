import java.util.ArrayList;
import java.util.Scanner;

public final class Factorials {

    public static void run(){
        System.out.println("1 - Finonaci\n2- Last digit\n3-Rest");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1: getFibonacci();break;
            case 2: getLastDigit();break;
            case 3: getRest();break;
        }
    }

    private static void getFibonacci(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long f1 = 1;
        long f2 = 1;
        if (n<=1){
            System.out.println(f2);
        }else {
            for (int i=3;i<=n;i++){
                f2 = f1+f2;
                f1 = f2 - f1;
            }
            System.out.println(f2);
        }
    }
    private static void getLastDigit(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int f1 = 1;
        int f2 = 1;
        int temp;
        if (n<=1){
            System.out.println(f2);
        }else {
            for (int i=3;i<=n;i++){
                temp = f2;
                f2 = (f1+f2)%10;
                f1 = temp;
            }
            System.out.println(f2);
        }
    }
    private static void getRest(){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        ArrayList<Long> periods = getPeriod(m);
        long period = periods.size();
        int val = (int)(n%period);
        System.out.println(periods.get(val));
    }
    private static ArrayList<Long> getPeriod(long m){
        ArrayList<Long> result = new ArrayList<>();
        result.add((long)0);
        result.add((long)1);
        for (int i = 2;i<m*6;i++ ){
            result.add((result.get(i-1) + result.get(i-2))%m);
            if (result.get(i) == 1 && result.get(i-1)==0){
                result.remove(i);
                result.remove(i-1);
                break;
            }
        }
        return result;
    }
}
