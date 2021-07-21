import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Runner {
    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();

        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String line;
        while((line = systemIn.readLine()) != null) {
           CommandHandler.handleCommand(line, robot);
        }
    }
}
