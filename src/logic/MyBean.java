package logic;

/**
 * Created by eugen on 09.03.2017.
 */
public class MyBean {
    private double start;
    private double finish;

    public MyBean(double start, double finish) {
        this.start = start;
        this.finish = finish;
    }

    public double getStart() {
        return start;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public double getFinish() {
        return finish;
    }

    public void setFinish(double finish) {
        this.finish = finish;
    }
}
