
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Cool level 1.
 */
public class CoolLevel1 implements LevelInformation {
    private int numberOfBalls;
    private String levelName;
    private Paddle paddle;

    /**
     * Instantiates a new Cool level 1.
     */
    public CoolLevel1() {
        this.numberOfBalls = 1;
        this.levelName = "Cool Level 1";
        this.paddle = new Paddle(new Block(new Rectangle(new Point(340, 525), 150, 28,
                Color.YELLOW)), 8);
    }
    /**
     * Number of balls int.
     *
     * @return the number of balls
     */
    public int numberOfBalls() {
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
            list.add(Velocity.fromAngleAndSpeed(180, 2));
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
     * Gets paddle.
     *
     * @return the paddle
     */
    public Paddle getPaddle() {
        return (this.paddle);
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
        return (new Block(new Rectangle(new Point(0, 0), 800, 600, Color.BLACK)));
    }

    /**
     * Blocks list.
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return the block list
     */
    public List<Block> blocks() {
        List<Block> list = new LinkedList<Block>();
        for (int i = 0; i < 1; i++) {
            list.add(new Block(new Rectangle(new Point(380, 150), 40, 40, Color.RED)));
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
}
