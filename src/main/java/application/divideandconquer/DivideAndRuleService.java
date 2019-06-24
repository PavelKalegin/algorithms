package application.divideandconquer;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
class DivideAndRuleService {

    List<Integer> BinarySearch(List<Integer> sortedArray, List<Integer> arr)
    {
        return arr.stream().
                map(value -> findIndex(sortedArray,value))
                .collect(Collectors.toList());
    }

    private Integer findIndex(List<Integer> arr, int value){
        int startI = 0;
        int endI = arr.size()-1;
        int mid;
        while (startI<=endI){
            mid = startI + (endI-startI)/2;
            if (value  < arr.get(mid)){
                endI = mid-1;
            }else if (value > arr.get(mid)) {
                startI = mid + 1;
            }else if (value == arr.get(mid)){
                return mid+1;
            }
        }
        return -1;
    }

    long countOfInversion(int[] input)
    {
        return (new MergeSortImpl(input)).countOfInversion();
    }
}
