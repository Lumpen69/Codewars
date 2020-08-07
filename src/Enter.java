import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Enter {

    //Ввод выражения
    public static String enter() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter two arabian or two roman numbers which less than 11 and a sign of operation: ");
        return reader.readLine();
    }
}
