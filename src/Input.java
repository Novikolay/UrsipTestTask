import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    List<Integer> numbers = new ArrayList<>();
    Scanner scanner;
    String str;
    int num;

    public void addToNumbers(int num) {
        numbers.add(num);
    }

    public void isInteger(String str) {
        try {
            num = Integer.parseInt(str);
            System.out.println("You entered: " + num);
            addToNumbers(num);
        } catch (NumberFormatException | NullPointerException ex) {
            System.out.println("You entered not a number!");
        }
    }

    public void checkNum(Scanner scanner) {
        str = scanner.next();
        if (!closeInput(scanner)) {
            isInteger(str);
            inputNum();
        }
    }

    public boolean closeInput(Scanner scanner){
        if(str.equals("S") || str.equals("s")) {
            endInput(scanner);
            return true;
        }
        return false;
    }

    public Scanner startInput() {
        scanner = new Scanner(System.in);
        System.out.println("Please, enter a new version number (or `S` for skip): ");
        return scanner;
    }

    public void endInput(Scanner scanner) {
        scanner.close();
        Generator generator = new Generator();
        System.out.println("Generated result: " + generator.generateNum(numbers));
    }

    public void inputNum() {
        scanner = startInput();
        checkNum(scanner);
    }

}
