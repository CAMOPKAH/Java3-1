import java.util.concurrent.Semaphore;

public abstract class Stage {
    protected int length;
    protected String description;
    public Semaphore Sm= new Semaphore(1);
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);

    //Выстраиваем очередь перед печатью, чтобы не менять порядок
    public void WriteLnMsg(String sText) {
        try {
            Sm.acquire();
            System.out.println(sText);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            Sm.release();
        }

    }
}
