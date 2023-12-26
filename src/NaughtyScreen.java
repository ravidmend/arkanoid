
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * The type Pause screen.
 */
public class NaughtyScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k the k
     */
    public NaughtyScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * Do one frame.
     *
     * @param d     the d
     * @param s     the s
     * @param score the score
     */
    public void doOneFrame(DrawSurface d, String s, Counter score) {
        d.setColor(Color.RED);
        d.drawText(10, d.getHeight() / 2, "You Naughty Naughty ;)", 32);
        d.drawText(10, 32 + d.getHeight() / 2, "You entered only letters and non existing levels", 32);
        d.drawText(10, 64 + d.getHeight() / 2, "Therefore, So Long And Goodnight", 32);
        d.drawText(10, 96 + d.getHeight() / 2, "(press space to close the window)", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    public boolean shouldStop() {
        return this.stop;
    }
}