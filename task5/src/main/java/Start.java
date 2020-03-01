import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Start extends Stage {
    final CountDownLatch StartLine;

    public Start(int CountCars) {
        this.length = 0;
        this.description = "Старт";
        StartLine = new CountDownLatch(CountCars);
    }
    @Override
    public void go(Car c) {

        try {
            try {
                this.WriteLnMsg(c.getName() + " готовится");
                Thread.sleep(500 + (int)(Math.random() * 800));
                this.WriteLnMsg(c.getName() + " готов");

                if (StartLine.getCount()==1) {
                    //Когда все машины выстроились перед финишем объявляем старт;
                    this.WriteLnMsg("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                }
                StartLine.countDown();
                StartLine.await();


            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


