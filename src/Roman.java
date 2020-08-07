import java.util.Map;

public class Roman {

    //Првоерка выражения на содержание ТОЛЬКО римских чисел и оператора
    public static boolean isRomanDigitsExpression(String exp, Map<String, Integer> map) {
        boolean isRoman = false;
        String[] arr = exp.replaceAll(" ", "").split("[+*/\\-]");
        for (String x : arr) {
            if (!map.containsKey(x)) {
                isRoman = false;
                break;
            }
            isRoman = true;
        }
        return isRoman;
    }

    //Метод, заменяющий в выражении римские числа на арабские
    public static String replaceRoman(String exp, Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        String[] arr = exp.replaceAll(" ", "").split("[+*/\\-]");
        for (String x : arr) {
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                if (x.equals(pair.getKey())) sb.append(pair.getValue());
            }
            sb.append(Calculator.whatTheSign(exp));
        }
        return sb.toString();
    }

    /*
    В методе, конвертирующем результат из int в число из римских цифр, не затрагивал числа выше 100,
    так как по условию задачи операнды не могут быть больше 10.
    */
    public static String convertResultToRoman(int res) {
        StringBuilder sb = new StringBuilder();
        int hundCount = res / 100;
        sb.append(C(hundCount));
        int tenCount = res / 10;
        sb.append(X(tenCount));
        int sticksCount = res % 10;
        sb.append(I(sticksCount));
        return sb.toString();
    }

    //Сотня
    private static String C(int count) {
        if (count != 0) return "C";
        else return "";
    }

    //Десятки
    private static String X(int count) {
        String x = null;
        if (count == 9) x = "XC";
        else if (count != 0 && count < 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) sb.append("X");
            x = sb.toString();
        }
        else if (count > 5 && count < 9) {
            StringBuilder sb = new StringBuilder("L");
            for (int i = 0; i < count - 5; i++) sb.append("X");
            x = sb.toString();
        }
        else if (count == 5) x = "L";
        else if (count == 4) x = "XL";
        else x = "";
        return x;
    }

    //Единицы
    private static String I(int count) {
        String x = null;
        if (count == 9) x = "IX";
        else if (count != 0 && count < 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) sb.append("I");
            x = sb.toString();
        }
        else if (count > 5 && count < 9) {
            StringBuilder sb = new StringBuilder("V");
            for (int i = 0; i < count - 5; i++) sb.append("I");
            x = sb.toString();
        }
        else if (count == 5) x = "V";
        else if (count == 4) x = "IV";
        else x = "";
        return x;
    }
}
