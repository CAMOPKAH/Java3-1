import java.io.ObjectInputStream;
import java.util.ArrayList;

public class homework4_1 {

    public static ArrayList<String> List = new ArrayList<>();
    public static int CountThreadPrint=5;
    public static volatile char LastChar=' ';
    public static Object MON= new Object();

    public static void main(String[] args) {
         Thread A = new Thread(()->{
             try {
             for (int i = 0; i < CountThreadPrint; i++) {

                 synchronized (MON) {
                     while (!(LastChar == ' ' || LastChar == 'C')) {

                             MON.wait();
                     }

                     LastChar='A';
                     System.out.print(LastChar);
                     MON.notifyAll();
                 }


                 Thread.sleep(100);

             }
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

         });

        Thread B = new Thread(()->{
            try {
                for (int i = 0; i < CountThreadPrint; i++) {

                    synchronized (MON) {
                        while (!(LastChar == 'A')) {

                            MON.wait();
                        }

                        LastChar='B';
                        System.out.print(LastChar);
                        MON.notifyAll();
                    }


                    Thread.sleep(100);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread C = new Thread(()->{

            try {
                for (int i = 0; i < CountThreadPrint; i++) {

                    synchronized (MON) {
                        while (!(LastChar == 'B')) {

                            MON.wait();
                        }

                        LastChar='C';
                        System.out.print(LastChar);
                        MON.notifyAll();
                    }


                    Thread.sleep(100);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

         A.start();
         B.start();
         C.start();

    }
}
