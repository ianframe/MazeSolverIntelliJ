public class Sierpinski {

    static final double BUFFER = 0.02;
    static int fileNum = 1;

    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length){
        return Math.sqrt(3) / 2 * length;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length){
        double[] xs = {x - length/2, x, x + length/2};
        double[] ys = {y + height(length), y, y + height(length)};
        StdDraw.filledPolygon(xs, ys);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length)
    {
        if (n == 1) {
            filledTriangle(x, y, length);
            StdDraw.save("sierpinski" + fileNum + ".png");
            fileNum++;
        }
        else{
            filledTriangle(x, y, length);
            StdDraw.save("sierpinski" + fileNum + ".png");
            fileNum++;
            StdDraw.setPenColor(StdDraw.RED);
            sierpinski(n-1, x-length/2, y, length/2);
            StdDraw.setPenColor(StdDraw.BLUE);
            sierpinski(n-1, x+length/2, y, length/2);
            StdDraw.setPenColor(StdDraw.GREEN);
            sierpinski(n-1, x, y+Math.sqrt(3)/2*length, length/2);
        }
    }

    private static void outlineTriangle(){
        double[] outlineX = {0, 0.5, 1, 0};
        double[] outlineY = {0, Math.sqrt(3)/2, 0, 0};
        StdDraw.polygon(outlineX, outlineY);
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args){
        outlineTriangle();
        sierpinski(3, 0.5, 0, 0.5);
    }
}