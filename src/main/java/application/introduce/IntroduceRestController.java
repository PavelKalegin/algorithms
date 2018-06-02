package application.introduce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/introduce")
@SuppressWarnings("unused")
public class IntroduceRestController {

    @Autowired
    private IntroduceService introduceService;

    //region Get
    @GetMapping("/fibonacci/{number}")
    public long getNFibonacci(@PathVariable Integer number)
    {
        return introduceService.getFibonacci(number);
    }

    @GetMapping("/lastDigit/{number}")
    public Integer getLastDigit(@PathVariable Integer number)
    {
        return introduceService.getLastDigit(number);
    }

    @GetMapping("reminderOfDivision/{n}/{m}")
    public long getReminderOfDivision(@PathVariable long n, @PathVariable int m)
    {
        return introduceService.getReminderOfDivision(n, m);
    }

    @GetMapping("biggestCommonDivider/{n}/{m}")
    public long getBiggestCommonDivider(@PathVariable long n, @PathVariable int m)
    {
        return introduceService.getBiggestCommonDivider(n, m);
    }
    //endregion
}
