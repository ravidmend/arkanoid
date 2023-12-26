
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
    }
    /**
     * Do one frame.
     *
     * @param d     the d
     * @param s     the s
     * @param score the score
     */
    public void doOneFrame(DrawSurface d, String s, Counter score) {
        if (s.equals("Game Over. Your score is ")) {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + Integer.toString(score.getValue()),
                    32);
            this.shouldStop();
        } else if (s.equals("You Win! Your score is ")) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + Integer.toString(score.getValue()),
                    32);
            this.shouldStop();
        } else {
            d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
            this.shouldStop();
        }

    }

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    public boolean shouldStop() {
        if (!sensor.isPressed(this.key) && this.isAlreadyPressed) {
            return true;
        }
        if (sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            return false;
        }
        if (!sensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
        return false;
    }
}
