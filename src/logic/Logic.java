package logic;

/**
 * Created by eugen on 09.03.2017.
 */
public class Logic {
    private double[] x;
    private double[] y;

    public int countSteps(double start, double finish, double step) {
        return (int) Math.round((finish - start) / step + 1);
    }

    public double f(double x) {
        return Math.sin(x);
    }

    public double[] calcX(double start, double finish, double step) {
        double[] x = new double[countSteps(start,finish,step)];
        for (int i = 0; i < x.length; i++) {
            x[i] = start + i*step;
        }

        return  x;
    }

    public double[] calcY(double[] x) {
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = f(x[i]);
        }
        return y;
    }
}
