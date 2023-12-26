
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Instantiates a new Score indicator.
     *
     * @param score the score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }
    /**
     * Draw on.
     *
     * @param d the surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(370, 15, "Score: " + Integer.toString(this.score.getValue()), 15);
    }
    /**
     * Time Passed.
     * does nothing
     */
    public void timePassed() {
        //
    }
}
