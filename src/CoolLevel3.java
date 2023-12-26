
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Cool level 3.
 */
public class CoolLevel3 implements LevelInformation {
    private int numberOfBalls;
    private String levelName;
    private Paddle paddle;

    /**
     * Instantiates a new Cool level 3.
     */
    public CoolLevel3() {
        this.numberOfBalls = 2;
        this.levelName = "Cool Level 3";
        this.paddle = new Paddle(new Block(new Rectangle(new Point(340, 525), 150, 28,
                Color.YELLOW)), 7);
    }
    /**
     * Number of balls int.
     *
     * @return the number of balls
     */
    public int numberOfBalls() {
        //change to 3
        return this.numberOfBalls;
    }

    /**
     * Initial ball velocities list.
     *
     * @return the list, The initial velocity of each ball
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new LinkedList<Velocity>();
        for (int i = 0; i < this.numberOfBalls(); i++) {
            list.add(Velocity.fromAngleAndSpeed(220 - i * 80, 6));
        }
        return list;
    }

    /**
     * Paddle speed int.
     *
     * @return the speed
     */
    public int paddleSpeed() {
        return this.paddle.getSpeed();
    }

    /**
     * Paddle width int.
     *
     * @return the width
     */
    public int paddleWidth() {
        return ((int) this.paddle.getWidth());
    }

    /**
     * Level name string.
     *
     * @return the level name
     */

    public String levelName() {
        return this.levelName;
    }

    /**
     * Gets background.
     *
     * @return a sprite with the background of the level
     */
    public Sprite getBackground() {
        return (new Block(new Rectangle(new Point(0, 0), 800, 600, Color.BLUE)));
    }

    /**
     * Blocks list.
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return the block list
     */
    public List<Block> blocks() {
        List<Block> list = new LinkedList<Block>();
        Color[] arrayOfColors = {Color.RED, Color.PINK, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.GREEN};
        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 12; j++) {
                list.add(new Block(new Rectangle(new Point(300 + j * 40, 120 + i * 25), 40, 25,
                        arrayOfColors[i])));
            }
        }
        return list;
    }

    /**
     * Number of blocks to remove int.
     *
     * @return the number Of Blocks To Remove
     */
    public int numberOfBlocksToRemove() {
        return (blocks().size());
    }
    /**
     * Gets paddle.
     *
     * @return the paddle
     */
    public Paddle getPaddle() {
        return (this.paddle);
    }
}
