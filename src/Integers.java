/**
 * Created by Evgeniy on 16.04.2016.
 */
public class Integers implements Runnable {

    private boolean isRunning = true;
    private String num = "";

    @Override
    public void run() {
        while (isRunning){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!num.contentEquals("")){
                System.out.println("(Integer) - i goat an " + Integer.parseInt(num) + " !");
                num = "";
            }
        }
        System.out.println("Integer - stop!");
    }


    public int getNum(){
        return Integer.parseInt(num);
    }

    public void setNum(String string){
        this.num = string;
    }

    public void end(){
        this.isRunning = false;
    }
}
