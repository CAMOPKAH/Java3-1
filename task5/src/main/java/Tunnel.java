import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    final Semaphore Sm;
    public Tunnel(int CountCars) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
         Sm = new Semaphore(CountCars/2);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                this.WriteLnMsg(c.getName() + " готовится к этапу(ждет): " + description);
                Sm.acquire();
                this.WriteLnMsg(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Sm.release();
                this.WriteLnMsg(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


