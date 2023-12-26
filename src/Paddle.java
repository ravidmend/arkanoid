
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private Block paddle;
    private biuoop.KeyboardSensor keyboard;
    private int speed;

    /**
     * Instantiates a new Paddle.
     *
     * @param paddle   the paddle
     * @param keyboard the keyboard
     * @param speed    the speed
     */
    public Paddle(Block paddle, biuoop.KeyboardSensor keyboard, int speed) {
        this.paddle = paddle;
        this.keyboard = keyboard;
        this.speed = speed;
    }

    /**
     * Instantiates a new Paddle.
     *
     * @param paddle the paddle
     * @param speed  the speed
     */
    public Paddle(Block paddle, int speed) {
        this.paddle = paddle;
        this.speed = speed;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        //makes sure the paddle can't get out of the screen
        if (this.paddle.getUpperLeft().getX() - this.speed < 19) {
            this.paddle.setUpperLeft(new Point(19, this.paddle.getUpperLeft().getY()));
        } else {
            this.paddle.setUpperLeft(new Point(this.paddle.getUpperLeft().getX() - this.speed,
                    this.paddle.getUpperLeft().getY()));
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        //makes sure the paddle can't get out of the screen
        if (this.paddle.getUpperLeft().getX() + this.paddle.getWidth() + this.speed > 781) {
            this.paddle.setUpperLeft(new Point(781 - this.paddle.getWidth(), this.paddle.getUpperLeft().getY()));
        } else {
            this.paddle.setUpperLeft(new Point(this.paddle.getUpperLeft().getX() + this.speed,
                    this.paddle.getUpperLeft().getY()));
        }
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public int getSpeed() {
        return (this.speed);
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return (this.paddle.getWidth());
    }
    /**
     * Time passed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }
    /**
     * Draw on.
     * draws the paddle on given surface
     *
     * @param d the surface
     */
    public void drawOn(DrawSurface d) {
        this.paddle.drawOn(d);
    }
    /**
     * Gets Collision Rectangle.
     *
     * @return the rectangle
     */
    public Rectangle getCollisionRectangle() {
        return (this.paddle.getCollisionRectangle());
    }
    /**
     * hit.
     * return the new velocity of the ball that's collided with it
     * @param hitter          the hitter
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the new velocity of the object that collided with the block
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if (collisionPoint == null) {
            return (currentVelocity);
        } else {
            //it's a fun hit so there is some math to find the velocity
            double angle = 30 * (((int) ((collisionPoint.getX() - this.paddle.getUpperLeft().getX())
                    / (int) ((this.paddle.getCollisionRectangle().getWidth()) / 5))) - 2);
            //if it hits in the middle
            if (angle == 0 || angle == 180) {
                dy = -dy;
                return (new Velocity(dx, dy));
            }
            //if it hits somewhere in the upper line
            if (this.paddle.doesPointInUpLine(collisionPoint)) {
                angle = 180 - angle;
                return (Velocity.fromAngleAndSpeed(angle, currentVelocity.getSpeed()));
            // if the hit is somewhere in th lower line
            } else if (this.paddle.doesPointInDownLine(collisionPoint)) {
                return (Velocity.fromAngleAndSpeed(angle, currentVelocity.getSpeed()));
            //hit on the sides
            } else if ((this.paddle.doesPointInLeftLine(collisionPoint))
                    || ((this.paddle.doesPointInRightLine(collisionPoint)))) {
                dx = -dx;
                return (new Velocity(dx, dy));
            } else {
                return currentVelocity;
            }
        }
    }

    /**
     * Add to game.
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Sets keyboard.
     *
     * @param keyboard the keyboard
     */
    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }
}