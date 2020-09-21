import java.util.Collections;
import java.util.List;

public class Generator {
    String result = null;
    int lastNum = 0;
    public String generateNum(List<Integer> numbers) {
        sortNumbers(numbers);
        for (Integer number : numbers) {
            if ((lastNum + 1) < number) {
                result = String.valueOf(lastNum + 1);
            } else {
                lastNum = number;
                result = String.valueOf(++number);
            }
        }
        result = changeNum(result);
        return result;
    }

    private String changeNum(String num) {
        switch (num.length()) {
                case 1: num = "00" + num;
                    break;
                case 2: num = "0" + num;
                    break;
                case 3: //nothing
                    break;
                default: System.out.println("Version can not be more 3 chars!");
                    break;
            }
        return num;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

}
