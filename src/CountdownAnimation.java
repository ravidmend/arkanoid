
import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * The type Countdown animation.
 *  The CountdownAnimation will display the given gameScreen,
 *  for numOfSeconds seconds, and on top of them it will show
 *  a countdown from countFrom back to 1, where each number will
 *  appear on the screen for (numOfSeconds / countFrom) seconds, before
 *  it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private int keeper;
    private SpriteCollection gameScreen;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.keeper = countFrom;
    }
    /**
     * Do one frame.
     *
     * @param d     the d
     * @param s     the s
     * @param score the score
     */
    public void doOneFrame(DrawSurface d, String s, Counter score) {
        Color[] arrayOfColors = {Color.PINK, Color.ORANGE, Color.WHITE, Color.BLACK, Color.RED, Color.YELLOW};
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        //draw level name
        d.setColor(Color.BLACK);
        d.drawText(600, 15, "Level Name: " + s, 15);
        //draw the level background
        if (s.equals("Cool Level 1")) {
            d.setColor(Color.BLUE);
            d.drawCircle(400, 170, 140);
            d.drawCircle(400, 170, 110);
            d.drawCircle(400, 170, 80);
            d.drawLine(400, 30, 400, 140);
            d.drawLine(400, 200, 400, 310);
            d.drawLine(260, 170, 370, 170);
            d.drawLine(430, 170, 540, 170);
        }
        if (s.equals("Cool Level 2")) {
            d.setColor(Color.ORANGE);
            d.fillCircle(100, 100, 60);
            d.setColor(Color.YELLOW);
            d.fillCircle(100, 100, 40);
            d.setColor(Color.YELLOW);
            for (int i = 0; i < 90; i++) {
                d.drawLine(80 + i / 3, 100 - i / 12, 22 + i * 8, 298);
            }
        }
        if (s.equals("Cool Level 3")) {
            d.setColor(Color.BLACK);
            d.fillRectangle(60, 345, 120, 235);
            d.setColor(Color.WHITE);
            d.drawText(98, 353, "The Burj Khalifa", 8);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    d.fillRectangle(70 + 22 * j, 355 + 45 * i, 12, 35);
                }
            }
            d.setColor(Color.DARK_GRAY);
            d.fillRectangle(100, 295, 40, 50);
            d.setColor(Color.LIGHT_GRAY);
            d.fillRectangle(113, 175, 15, 120);
            d.setColor(Color.ORANGE);
            d.fillCircle(120, 160, 15);
            d.setColor(Color.RED);
            d.fillCircle(120, 160, 12);
            d.setColor(Color.WHITE);
            d.fillCircle(120, 160, 5);
        }
        //
        d.setColor(Color.BLACK);
        d.drawText(300, 400, Integer.toString(this.countFrom), 401);
        d.setColor(Color.RED);
        d.drawText(300, 400, Integer.toString(this.countFrom), 400);
        if (this.countFrom != this.keeper) {
            sleeper.sleepFor((int) (1000 * (this.numOfSeconds / this.keeper)));
        }
        this.countFrom = this.countFrom - 1;
    }
    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    public boolean shouldStop() {
        if (this.countFrom == -1) {
            return true;
        }
        return false;
    }
}