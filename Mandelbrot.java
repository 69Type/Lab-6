import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    public static final int MAX_ITERATIONS = 20000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        int i = 0;

        double zreal = 0;
        double zimaginary = 0;

        while (i < MAX_ITERATIONS && zreal * zreal + zimaginary * zimaginary < 4) {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginarypdated = 2 * zreal * zimaginary + y;
            zreal = zrealUpdated;
            zimaginary = zimaginarypdated;

            i++;
        }

        if (i == MAX_ITERATIONS) {
            return -1;
        }

        return i;
    }


    public String toString(){
        return "Mandelbrot";
    }

}