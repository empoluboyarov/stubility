/**
 * Created by Evgeniy on 16.04.2016.
 */
public class Strings implements Runnable {

    private boolean isRunning = true;
    private String str = "";


    @Override
    public void run() {
        while (isRunning){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!str.contentEquals("")) {
                System.out.println("(String) - i gaot '" + str + "'!");
                str = "";
            }
        }
        System.out.println("String - stop!");
    }

    public void end (){
        isRunning = false;
    }

    public void setStr(String str){
        this.str = str;
    }

    public String getStr(){
        return str;
    }
}
