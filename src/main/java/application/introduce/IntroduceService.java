package application.introduce;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Service
final class IntroduceService {

    long getFibonacci(@NotNull Integer number){
        long f1 = 1;
        long f2 = 1;
        if (number > 1) {
            for (int i = 3; i <= number; i++) {
                f2 = f1 + f2;
                f1 = f2 - f1;
            }
        }
        return f2;
    }

    Integer getLastDigit(Integer number){
        int f1 = 1;
        int f2 = 1;
        int temp;
        if (number > 1){
            for (int i=3; i <= number; i++)
            {
                temp = f2;
                f2 = (f1 + f2) % 10;
                f1 = temp;
            }
        }
        return f2;
    }

    long getReminderOfDivision(long n, int m){

        ArrayList<Long> periods = getPeriod(m);
        long period = periods.size();
        int val = (int)(n%period);
        return periods.get(val);
    }

    long getBiggestCommonDivider(long n, long m)
    {
        if (m==0)
            return n;
        if (n==0)
            return m;
        if (m>=n)
        {
            return getBiggestCommonDivider(m%n,n);
        }
            return getBiggestCommonDivider(n%m,m);

    }

    private ArrayList<Long> getPeriod(long m){
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
