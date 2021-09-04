import java.util.Arrays;
import java.util.List;

public class Problem001 {

    public String kthLargestNumber(String[] nums, int k) {
        List<String> numString = Arrays.asList(nums);
        numString.sort((num1, num2) -> {
            if (num1.length() == num2.length())
                return num1.compareTo(num2);
            if (num1.length() > num2.length())
                return 1;
            return -1;
        });
        System.out.println(numString);
        return numString.get(numString.size() - k);
    }
}
