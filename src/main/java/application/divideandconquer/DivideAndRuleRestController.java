package application.divideandconquer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/divideandrule")
@SuppressWarnings("unused")
public class DivideAndRuleRestController
{

    @Autowired
    private DivideAndRuleService divideAndRuleService;

    /**
     * input example
     *{
     * 	"sortedArray":[1, 5, 8, 12, 13],
     * 	"arr":[8, 1, 23, 1, 11]
     * }
     */
    @PostMapping("/binarysearch")
    List<Integer> binarySearch(@RequestBody Map<String,List<Integer>> inputData)
    {
        return divideAndRuleService.BinarySearch(inputData.get("sortedArray"), inputData.get("arr"));
    }

    /**
     * input example
     * [2, 3, 9, 2, 9]
     */
    @PostMapping("/countofinversion")
    Long getCountOfInversion(@RequestBody int[] input)
    {
        return divideAndRuleService.countOfInversion(input);
    }


}
