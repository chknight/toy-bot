import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        Robot robot = new Robot();
        Scanner scanner= new Scanner(System.in);    //System.in is a standard input stream

        while (true) {
            String command = scanner.nextLine();
            CommandHandler.handleCommand(command, robot);
        }
    }
}
