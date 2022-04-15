import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator {
    public static final int MAX_ITERATIONS = 200;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    @Override
    public int numIterations(double x, double y) {
        int i = 0;

        double zreal = .0;
        double zimaginary = .0;

        while (i < MAX_ITERATIONS && zreal * zreal + zimaginary * zimaginary < 4) {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginaryUpdated = 2 * Math.abs(zreal) * Math.abs(zimaginary) + y;

            zreal = zrealUpdated;
            zimaginary = zimaginaryUpdated;

            i++;
        }

        if (i == MAX_ITERATIONS) {
            return -1;
        }

        return i;
    }

    public String toString(){
        return "BurningShip";
    }
}