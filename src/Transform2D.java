public class Transform2D {

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array)
    {
        double[] copy = new double[array.length];
        for (int i = 0; i < copy.length; i++)
            copy[i] = array[i];
        return copy;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha)
    {
        for (int i  = 0; i < x.length; i++){
            x[i] *= alpha;
            y[i] *= alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy)
    {
        for (int i  = 0; i < x.length; i++){
            x[i] += dx;
            y[i] += dy;
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta){
        for (int i = 0; i < x.length; i++)
        {
            double xPrime = x[i]*Math.cos(Math.toRadians(theta)) - y[i]*Math.sin(Math.toRadians(theta));
            double yPrime = y[i]*Math.cos(Math.toRadians(theta)) + x[i]*Math.sin(Math.toRadians(theta));
            x[i] = xPrime;
            y[i] = yPrime;
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args){
        // Rotates polygon 45 degrees.
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };
        double theta = 45.0;
        StdDraw.setPenRadius(0.0125);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);
        rotate(x, y, theta);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);
    }
}


