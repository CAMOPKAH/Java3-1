public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            this.WriteLnMsg(c.getName() + " начал этап: " + description);
            //System.out.println();
            Thread.sleep(length / c.getSpeed() * 1000);
            this.WriteLnMsg(c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
