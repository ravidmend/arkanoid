
/**
 * The type Velocity.
 */
public class Velocity {
    private double dx;
    private double dy;
    private static final int MAX_SPEED = 30;

    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        if (dx > MAX_SPEED) {
            this.dx = MAX_SPEED;
        }
        if (dy > MAX_SPEED) {
            this.dy = MAX_SPEED;
        }
    }

    /**
     * Apply to point.
     * add dx and dy to the point p
     *
     * @param p the p
     * @return new point in the wanted place
     */
    public Point applyToPoint(Point p) {
        return (new Point(p.getX() + this.getDx(), p.getY() + this.getDy()));
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return (this.dx);
    }

    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return (this.dy);
    }

    /**
     * Sets dx.
     *
     * @param dx the dx
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * Sets dy.
     *
     * @param dy the dy
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * From angle and speed velocity.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity by dx and dy
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(angle * Math.PI / 180);
        double dy = speed * Math.cos(angle * Math.PI / 180);
        if (dx > MAX_SPEED) {
            dx = MAX_SPEED;
        }
        if (dy > MAX_SPEED) {
            dy = MAX_SPEED;
        }
        return new Velocity(dx, dy);
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public double getSpeed() {
        return (Math.sqrt(Math.pow(this.getDx(), 2) + Math.pow(this.getDy(), 2)));
    }
}