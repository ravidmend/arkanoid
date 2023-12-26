
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new Block.
     *
     * @param rectangle the rectangle
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new LinkedList<HitListener>();
    }
    /**
     * Gets Collision Rectangle.
     *
     * @return the rectangle
     */
    public Rectangle getCollisionRectangle() {
        return (this.rectangle);
    }

    /**
     * Does point in up line boolean.
     *
     * @param p the point
     * @return if the given point is in the upper line
     */
    public boolean doesPointInUpLine(Point p) {
        return (this.rectangle.doesPointInUpLine(p));
    }

    /**
     * Does point in down line boolean.
     *
     * @param p the point
     * @return if the given point is in the lower line
     */
    public boolean doesPointInDownLine(Point p) {
        return (this.rectangle.doesPointInDownLine(p));
    }

    /**
     * Does point in left line boolean.
     *
     * @param p the point
     * @return if the given point is in the left line
     */
    public boolean doesPointInLeftLine(Point p) {
        return (this.rectangle.doesPointInLeftLine(p));
    }

    /**
     * Does point in right line boolean.
     *
     * @param p the point
     * @return if the given point is in the right line
     */
    public boolean doesPointInRightLine(Point p) {
        return (this.rectangle.doesPointInRightLine(p));
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return (this.rectangle.getColor());
    }

    /**
     * Draw on.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        int width = (int) this.rectangle.getWidth();
        int height = (int) this.rectangle.getHeight();
        int upY = (int) this.rectangle.getUpperLeft().getY();
        int leftX = (int) this.rectangle.getUpperLeft().getX();
        Rectangle r = new Rectangle(new Point(leftX - 1, upY - 1), width + 2, height + 2,
                Color.BLACK);
        r.drawOn(surface);
        this.rectangle.drawOn(surface);
    }
    /**
     * timePassed.
     */
    public void timePassed() {
        //no use
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return (this.rectangle.getUpperLeft());
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return (this.rectangle.getWidth());
    }

    /**
     * Gets hieght.
     *
     * @return the hieght
     */
    public double getHeight() {
        return (this.rectangle.getHeight());
    }

    /**
     * Sets upper left.
     *
     * @param p the point
     */
    public void setUpperLeft(Point p) {
        this.rectangle.setUpperLeft(p);
    }

    /**
     * Add to game.
     *
     * @param game the game
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
        game.addCollidable(this);
    }

    /**
     * Remove from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * Hit velocity.
     *
     * @param hitter          the hitter
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        Velocity v = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        //if the ball hit the upper or lower part of the block we change his vertical direction.
        if ((this.doesPointInUpLine(collisionPoint)) || (this.doesPointInDownLine(collisionPoint))) {
            dy = -dy;
        }
        //if the ball hit the upper or lower part of the block we change his horizontal direction
        if (((this.doesPointInLeftLine(collisionPoint))) || (this.doesPointInRightLine(collisionPoint))) {
            dx = -dx;
        }
        this.notifyHit(hitter);
        return (new Velocity(dx, dy));
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

    /**
     * Notify hit.
     *
     * @param hitter the hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new LinkedList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
