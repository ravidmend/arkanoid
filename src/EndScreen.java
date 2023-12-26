
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Pause screen.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    private boolean didWin;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k      the k
     * @param score  the score
     * @param didWin the did win
     */
    public EndScreen(KeyboardSensor k, Counter score, boolean didWin) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.didWin = didWin;
    }

    /**
     * Do one frame.
     *
     * @param d     the d
     * @param s     the s
     * @param score the score
     */
    public void doOneFrame(DrawSurface d, String s, Counter score) {
        if (!this.didWin) {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + Integer.toString(score.getValue()),
                    32);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = true;
            }
        } else {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + Integer.toString(score.getValue()),
                    32);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = true;
            }
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