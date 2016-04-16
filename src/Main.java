import java.util.Scanner;

/**
 * Created by Evgeniy on 16.04.2016.
 */
public class Main {

    private static Integers i = new Integers();
    private static Strings s = new Strings();
    public static Thread ts = new Thread(s);
    public static Thread ti = new Thread(i);
    public static Scanner sc = new Scanner(System.in);
    public static String com = "";
    public static boolean isRunning = true;
    public static boolean autoRevive = false;



    public static void main(String[] args) {
        ts.start();
        ti.start();
        System.out.println("Program starts...\nType /help to see all commands");

        while (isRunning){
            System.out.println("----------------------||----------------------");
            System.out.print("Enter command: ");
            com = sc.next();
            checkCommand();
            autoRevive();
        }

        s.end();
        i.end();
        sc.close();
        System.out.println("Exit!");
    }

    private static void autoRevive() {
        if (autoRevive){
            if (!ts.isAlive())
                revive("String");
            else if (!ti.isAlive())
                revive("Integer");
        }
    }

    private static void checkCommand() {
        switch (com.toLowerCase()){

            case "/exit":
                break;

            case "/help":
                System.out.println("/help - list of all commands");
                System.out.println("/exit - exit the program");
                System.out.println("/int <Integer> - pass next int to Integers thread");
                System.out.println("/str <String> - pass next string to Strings thread");
                System.out.println("/stats - all threads 'alive' status");
                System.out.println("/revive <'Integer','String'> - restarts named Thread");
                System.out.println("/auto_revive - switches auto revive thread option");
                break;

            case "/int":
                if (!ti.isAlive()){
                    System.out.println("ERROR - Integer thread is dead!");
                    break;
                }

                String iarg = sc.next();
                i.setNum(iarg);

                break;

            case "/str":
                if (!ts.isAlive()){
                    System.out.println("ERROR - String thread is dead!");
                    break;
                }

                String sarg = sc.next();
                s.setStr(sarg);
                break;

            case "/stats":
                System.out.println("Integer thread alive status: " + ti.isAlive() );
                System.out.println("String thread alive status: " + ts.isAlive());
                break;

            case "/revive":
                revive(sc.next());
                break;

            case "/auto_revive":
                autoRevive = !autoRevive;
                System.out.println("Auto Revive option is now: " + autoRevive);
                break;

            default:
                System.out.println("ERROR - Unknown command!");
                break;
        }
    }

    private static void revive(String string) {
        switch (string.toLowerCase()){
            case "integer":
                if (ti.isAlive()){
                    System.out.println("ERROR - Integer thread is still alive!");
                    break;
                }
                i = new Integers();
                ti = new Thread(i);
                ti.start();
                if(ti.isAlive())
                    System.out.println("Integer thread is revived!");

                break;
            case "string":
                if (ts.isAlive()){
                    System.out.println("ERROR - String thread is still alive!");
                    break;
                }
                s = new Strings();
                ts = new Thread(s);
                ts.start();
                if (ts.isAlive())
                    System.out.println("Integer thread is revived!");
                break;
        }
    }
}
