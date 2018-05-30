package application.greedy;

import application.greedy.models.ContinuousBackpack;
import application.greedy.models.Item;
import application.greedy.models.Line;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
class GreedyService {

    List<Integer> greedyLines(List<Line> lines){
        List<Line> commonLines = new ArrayList<>();
        lines.sort(Comparator.comparing(Line::getL).thenComparing(Line::getR));
        commonLines.add(lines.get(0));
        lines.forEach(line -> {
                    Line currLine = commonLines.get(commonLines.size() - 1);
                    if (line.getL() > currLine.getL() && line.getL() <= currLine.getR()) {
                        currLine.setL(line.getL());
                        if (line.getR() < currLine.getR()) {
                            currLine.setR(line.getR());
                        }
                    } else if (line.getL() > currLine.getR()) {
                        commonLines.add(line);
                    }
                });
        return commonLines.stream()
                .map(Line::getR)
                .collect(Collectors.toList());
    }

     double greedyContinuousBackpack(ContinuousBackpack backpack){

        int capacity = backpack.getCapacity();
        double totalCost = 0;
        backpack.getItems().sort(Comparator.comparing(Item::getPrice).reversed());
        for (Item item: backpack.getItems()) {
            if (item.getValue() < capacity){
                capacity -= item.getValue();
                totalCost += (double) item.getCost();
            }else if (capacity == 0){
                break;
            }else{
                totalCost+= item.getPrice() * ((double) capacity );
                capacity = 0;
            }
        }
        return totalCost;
    }

    List<Integer> getAddends(long n){
        long k = (long) (Math.sqrt((double) (1 + 8 * n)) - 1)/2;

        return IntStream.concat(IntStream.range(1,(int)k), IntStream.of((int) (k + n - k*(k+1)/2)))
                .boxed()
                .collect(Collectors.toList());
    }

}
