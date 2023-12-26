
import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * Do one frame.
     *
     * @param d     the d
     * @param s     the s
     * @param score the score
     */
    void doOneFrame(DrawSurface d, String s, Counter score);

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    boolean shouldStop();
}