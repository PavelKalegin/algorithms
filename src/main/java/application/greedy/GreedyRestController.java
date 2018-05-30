package application.greedy;

import application.greedy.models.ContinuousBackpack;
import application.greedy.models.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("app/greedy")
@SuppressWarnings("unused")
public class GreedyRestController
{
    @Autowired
    private GreedyService greedyService;

    @PostMapping("/lines")
    public List<Integer> getCommonPoints(@RequestBody List<Line> lines)
    {
        return greedyService.greedyLines(lines);
    }

    @PostMapping("/backpack")
    public double getMaxCost(@RequestBody ContinuousBackpack backpack)
    {
        return greedyService.greedyContinuousBackpack(backpack);
    }

    @PostMapping("/addends")
    public List<Integer> getAddends(@RequestBody long number)
    {
        return greedyService.getAddends(number);
    }

}
