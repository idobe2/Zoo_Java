package graphics;


public class Controller implements Observer {

    public void notify(String msg){
        System.out.println("+++++++++++++++++++");
        System.out.println("OWNER got a notification:" +msg);

    }


}
