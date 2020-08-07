import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[]args) throws Exception {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        String expression = Enter.enter();

        try {
            if (Roman.isRomanDigitsExpression(expression, map)) {
                String romanExpression = Roman.replaceRoman(expression, map);
                int result = Calculator.calculate(Calculator.numbersArr(romanExpression), Calculator.whatTheSign(romanExpression));
                System.out.println(Roman.convertResultToRoman(result));
            }
            else System.out.println(Calculator.calculate(Calculator.numbersArr(expression), Calculator.whatTheSign(expression)));
        } catch (NumberFormatException e) {
            System.out.println("You entered a wrong number or operation!");
        }
    }
}

