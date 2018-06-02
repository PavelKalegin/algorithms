package application.greedy;

import application.greedy.models.Command;
import application.greedy.models.ContinuousBackpack;
import application.greedy.models.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("app/greedy")
@SuppressWarnings("unused")
public class GreedyRestController
{
    @Autowired
    private GreedyService greedyService;

    /**
     *Input example:
     * [
     *    {
     * 		"l":4,
     * 		"r":7
     *    },
     *    {
     * 		"l":1,
     * 		"r":3
     *    }
     * ]
     */
    @PostMapping("/lines")
    public List<Integer> getCommonPoints(@RequestBody List<Line> lines)
    {
        return greedyService.greedyLines(lines);
    }

    /**
     * Input example:
     * {
     * 	"capacity":50,
     * 	"items":
     * 	[
     * 	    {"cost":60,
     * 		"value":20},
     *      {"cost":100,
     * 		"value":50}
     * 	]
     * }
     */
    @PostMapping("/backpack")
    public double getMaxCost(@RequestBody ContinuousBackpack backpack)
    {
        return greedyService.greedyContinuousBackpack(backpack);
    }

    @GetMapping("/addends/{number}")
    public List<Integer> getAddends(@PathVariable long number)
    {
        return greedyService.getAddends(number);
    }

    @PostMapping("/huffman/encoding")
    public String encoding(@RequestBody String inputStr){
        return greedyService.huffmanEncoding(inputStr);
    }

    @PostMapping("/huffman/decoding/{inputStr}")
    public String decoding(@RequestBody Map<String, String> codingMap, @PathVariable String inputStr){
        return greedyService.huffmanDecoding(codingMap, inputStr);
    }

    @PostMapping("/priorityqueue")
    public String priorityQueue(@RequestBody List<Command> commands){
        return greedyService.priorityQueue(commands);
    }

}
