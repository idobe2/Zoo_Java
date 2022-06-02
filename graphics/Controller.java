package graphics;


public class Controller implements Observer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public void notify(String msg){
        System.out.println(ANSI_YELLOW + "Controller got a notification: " + msg + ANSI_RESET);
    }


}
