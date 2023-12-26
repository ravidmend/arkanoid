
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Ball.
 */
public class Ball implements Sprite, HitNotifier {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;
    private static final int DEFAULT_SPEED = 0;

    /**
     * Instantiates a new Ball.
     *
     * @param x               the x of the center point
     * @param y               the y of the center point
     * @param r               the radius
     * @param color           the color
     * @param gameEnvironment the game environment
     */
    public Ball(double x, double y, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.r = Math.abs(r);
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        //default values
        this.setVelocity(DEFAULT_SPEED, DEFAULT_SPEED);
        this.hitListeners = new LinkedList<HitListener>();
    }
    /**
     * Draw on.
     * draws the ball on given surface
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.fillCircle(this.getX(), this.getY(), this.getSize() + 1);
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * Move one step.
     * moving the ball by his velocity
     */
    public void moveOneStep() {
        //this line represents the ball movement without any blocks in the way
        Line trajectory = new Line(this.center.getX(), this.center.getY(), this.center.getX()
                + this.getVelocity().getDx(), this.center.getY() + this.getVelocity().getDy());
        //if the ball doesn't collide with any object
        if (this.gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else {
            Rectangle r = this.gameEnvironment.getClosestCollision(trajectory).collisionObject()
                    .getCollisionRectangle();
            Point p = this.gameEnvironment.getClosestCollision(trajectory).collisionPoint();
            //we get the new velocity of this ball by the hit function in the collision object
            this.setVelocity(this.gameEnvironment.getClosestCollision(trajectory).collisionObject().hit(this,
                    p, this.getVelocity()));
            //if the ball collides with the upper line of the block
            if (r.doesPointInUpLine(p)) {
                this.center = new Point(p.getX(), p.getY() - 2);
            }
            //if the ball collides with the lower line of the block
            if (r.doesPointInDownLine(p)) {
                this.center = new Point(p.getX(), p.getY() + 2);
            }
            //if the ball collides with the left line of the block
            if (r.doesPointInLeftLine(p)) {
                this.center = new Point(p.getX() - 2, p.getY());
            }
            //if the ball collides with the right line of the block
            if (r.doesPointInRightLine(p)) {
                this.center = new Point(p.getX() + 2, p.getY());
            }
        }
    }
    /**
     * Time passed.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return ((int) this.center.getX());
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return ((int) this.center.getY());
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return (this.r);
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return (this.color);
    }

    /**
     * Sets velocity.
     *
     * @param v the v
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return (this.v);
    }

    /**
     * Add to game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
    /**
     * Add Hit Listener.
     *
     * @param hl HitListener
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * Remove Hit Listener.
     *
     * @param hl HitListener
     */

    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
