import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class GreedyAlg {
    public static void run(){
        System.out.println("1 - Lines\n2-Things\n3-Number");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1:greedy_lines();break;
            case 2:greedy_stock();break;
            case 3:greedy_number();break;
        }
    }
    private static void greedy_lines(){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lines.add(new Line(scanner.nextInt(),scanner.nextInt()));
        }
        lines.sort(Comparator.comparing(Line::getL).thenComparing(Line::getR));
        //lines.forEach(line -> System.out.println(line.getL()+" "+ line.getR()));
        List<Line> commonLines = new ArrayList<>();
        commonLines.add(lines.get(0));
        lines.forEach(line -> {
            Line currLine = commonLines.get(commonLines.size()-1);
            if (line.getL() > currLine.getL() && line.getL()<=currLine.getR()){
                currLine.setL(line.getL());
                if (line.getR()<currLine.getR()){
                    currLine.setR(line.getR());
                }
            }else if (line.getL() > currLine.getR())
            {
                commonLines.add(line);
            }
        });
        System.out.println(commonLines.size());
        commonLines.forEach(line -> System.out.print(line.getR()+" "));
    }

    private static void greedy_stock(){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int capacity = scanner.nextInt();
        double totalCost = 0;
        List<Thing> things = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            things.add(new Thing(scanner.nextInt(),scanner.nextInt()));
        }
        things.sort(Comparator.comparing(Thing::getPrice).reversed());
        for (Thing thing: things) {
            if (thing.getValue() < capacity){
                capacity -= thing.getValue();
                totalCost += (double) thing.getCost();
            }else if (capacity == 0){
                break;
            }else{
                totalCost+= thing.getPrice() * ((double) capacity );
                capacity = 0;
            }
        }
        System.out.format("%.3f%n",totalCost);
    }

    private static void greedy_number(){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = (long) (Math.sqrt((double) (1 + 8 * n)) - 1)/2;
        System.out.println(k);
        for (long i = 1; i < k ; i++) {
            System.out.print(i+" ");
        }
        System.out.println(k + n - k*(k+1)/2);
    }

}
class Line{
    private int l,r;
    Line(int l, int r) {
        this.l = l;
        this.r = r;
    }
    int getL() {
        return l;
    }
    int getR() {
        return r;
    }

    void setL(int l) {
        this.l = l;
    }

    void setR(int r) {
        this.r = r;
    }
}

class Thing{
    private int value, cost;
    private double price;

    Thing(int cost, int value) {
        this.cost = cost;
        this.value = value;
        this.price = (double)cost/value;
    }

    int getCost() {
        return cost;
    }

    int getValue() {
        return value;
    }

    double getPrice() {
        return price;
    }
}