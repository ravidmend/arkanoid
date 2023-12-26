
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Cool level 2.
 */
public class CoolLevel2 implements LevelInformation {
    private int numberOfBalls;
    private String levelName;
    private Paddle paddle;

    /**
     * Instantiates a new Cool level 2.
     */
    public CoolLevel2() {
        this.numberOfBalls = 10;
        this.levelName = "Cool Level 2";
        this.paddle = new Paddle(new Block(new Rectangle(new Point(100, 525), 580, 15,
                Color.YELLOW)), 3);
    }
    /**
     * Number of balls int.
     *
     * @return the number of balls
     */
    public int numberOfBalls() {
        //change to 10
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
            list.add(Velocity.fromAngleAndSpeed(180 + (70 - i * 16), 5));
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
        return (new Block(new Rectangle(new Point(0, 0), 800, 600, Color.WHITE)));
    }

    /**
     * Blocks list.
     * The Blocks that make up this level, each block contains its size, color and location.
     * @return the block list
     */
    public List<Block> blocks() {
        List<Block> list = new LinkedList<Block>();
        Color[] arrayOfColors = {Color.RED, Color.RED, Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW,
                Color.GREEN, Color.GREEN, Color.GREEN, Color.BLUE, Color.BLUE, Color.PINK, Color.PINK, Color.CYAN,
                Color.CYAN};
        for (int i = 0; i < 15; i++) {
            list.add(new Block(new Rectangle(new Point(20 + 50.667 * i, 300), 50.667, 25,
                    arrayOfColors[i])));
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
