import java.util.ArrayList;

public class Calculator {

    //Список операндов
    public static ArrayList<Integer> numbersArr(String exp) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] arr =  exp.replaceAll(" ", "").split("[+*/\\-]");
            for (int i = 0; i < arr.length; i++) {
                int number = Integer.parseInt(arr[i]);
                if (number >= 1 && number <= 10) list.add(number);
                else throw new NumberFormatException();
            }
        return list;
    }

    //Определение знака операции
    public static char whatTheSign(String exp) {
        char sign = 0;
        for (char x : exp.toCharArray()) {
            if (x == '+' || x == '-' || x == '*' || x == '/') {
                sign = x;
                break;
            }
        }
        return sign;
    }

    //Калькулятор
    public static int calculate(ArrayList<Integer> list, char sign) {
        if (list.size() < 2) throw new NumberFormatException();
        int result = 0;
        switch (sign) {
            case '+':
                result = list.get(0) + list.get(1);
                break;
            case '-':
                result = list.get(0) - list.get(1);
                break;
            case '*':
                result = list.get(0) * list.get(1);
                break;
            case '/':
                result = list.get(0) / list.get(1);
                break;
        }

        return result;
    }
}
