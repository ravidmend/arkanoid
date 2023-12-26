
/**
 * The type Point.
 */
public class Point {
    private double x;
    private double y;
    private static final double COMPARISON_THRESHOLD = 0.00001;

    /**
     * Instantiates a new Point.
     *
     * @param x the x of point
     * @param y the y of point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Distance double.
     *
     * @param other the other
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        return (Math.sqrt(Math.pow(this.x - other.getX(), 2) + Math.pow(this.y - other.getY(), 2)));
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        return ((doubleEquals(this.x, other.getX())) && (doubleEquals(this.y, other.getY())));
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return (this.x);
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return (this.y);
    }

    /**
     * Double equals boolean.
     *
     * @param a the a
     * @param b the b
     * @return true if it's the same number
     */
    public static boolean doubleEquals(double a, double b) {
        return  Math.abs(a - b) < Point.COMPARISON_THRESHOLD;
    }
}

