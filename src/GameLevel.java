
import biuoop.DrawSurface;
import java.awt.Color;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * The type GameLevel.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Paddle paddle;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    //private Counter score;
    //private GUI gui = new GUI("BBC", 800, 600);
    private AnimationRunner runner;
    private boolean running = true;
    private KeyboardSensor keyboard;
    private LevelInformation level;

    /**
     * Instantiates a new GameLevel.
     *
     * @param level the level
     * @param ks    the ks
     * @param ar    the ar
     */
    public GameLevel(LevelInformation level, KeyboardSensor ks, AnimationRunner ar) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.level = level;
        this.paddle = this.level.getPaddle();
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.runner = ar;
        this.keyboard = this.getRunner().getGui().getKeyboardSensor();
        this.getPaddle().setKeyboard(this.keyboard);
    }

    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize.
     * Initialize a new game: create the Blocks and Ball
     * and add them to the game.
     *
     * @param score the score
     */
    public void initialize(Counter score) {
        Color[] arrayOfColors = {Color.RED, Color.PINK, Color.ORANGE, Color.MAGENTA, Color.CYAN, Color.GREEN};
        this.addSprite(this.level.getBackground());
        this.paddle.addToGame(this);
        //create balls
        for (int i = 0; i < this.level.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 450, 5, Color.WHITE, this.environment);
            // set velocity
            ball.setVelocity(this.level.initialBallVelocities().get(i));
            //add listeners to the balls
            ball.addHitListener(new BallRemover(this, this.remainingBalls));
            this.remainingBalls.increase(1);
            //add them to the game
            ball.addToGame(this);
        }
        //create the blocks
        for (int i = 0; i < this.level.blocks().size(); i++) {
            Block b = new Block(this.level.blocks().get(i).getCollisionRectangle());
            b.addToGame(this);
            b.addHitListener(new BlockRemover(this, this.remainingBlocks));
            b.addHitListener(new ScoreTrackingListener(score));
            this.remainingBlocks.increase(1);
        }
        //make the blocks at the side of the screen
        Block upperB = new Block(new Rectangle(new Point(-100, -180), 1000, 200, Color.GRAY));
        upperB.addToGame(this);
        //
        Block lowerB = new Block(new Rectangle(new Point(-100, 580), 1000, 200, Color.GRAY));
        lowerB.addToGame(this);
        // add the hit listener
        lowerB.addHitListener(new BallRemover(this, this.remainingBalls));
        //
        Block leftB = new Block(new Rectangle(new Point(-180, -100), 200, 800, Color.GRAY));
        leftB.addToGame(this);
        //
        Block rightB = new Block(new Rectangle(new Point(780, -100), 200, 800, Color.GRAY));
        rightB.addToGame(this);
        this.addSprite(new ScoreIndicator(score));
        this.runner.run(new CountdownAnimation(2, 3, this.sprites), this.level.levelName(), score);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.environment.getObjectsInTheGame().remove(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSpriteList().remove(s);
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
     * Should stop boolean.
     *
     * @return the boolean
     */
    public boolean shouldStop() {
        return (!this.running);
    }
    /**
     * Do one frame.
     *
     * @param d     the d
     * @param s     the s
     * @param score the score
     */
    public void doOneFrame(DrawSurface d, String s, Counter score) {
        Sleeper sleeper = new Sleeper();
        Sprite background = this.sprites.getSpriteList().get(0);
        background.drawOn(d);
        this.sprites.getSpriteList().remove(background);
        //draw the levels background
        if (this.level.levelName().equals("Cool Level 1")) {
            d.setColor(Color.BLUE);
            d.drawCircle(400, 170, 140);
            d.drawCircle(400, 170, 110);
            d.drawCircle(400, 170, 80);
            d.drawLine(400, 30, 400, 140);
            d.drawLine(400, 200, 400, 310);
            d.drawLine(260, 170, 370, 170);
            d.drawLine(430, 170, 540, 170);
        } else if (this.level.levelName().equals("Cool Level 2")) {
            d.setColor(Color.ORANGE);
            d.fillCircle(100, 100, 60);
            d.setColor(Color.YELLOW);
            d.fillCircle(100, 100, 40);
            d.setColor(Color.YELLOW);
            for (int i = 0; i < 90; i++) {
                d.drawLine(80 + i / 3, 100 - i / 12, 22 + i * 8, 298);
            }
        } else if (this.level.levelName().equals("Cool Level 3")) {
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
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        this.sprites.getSpriteList().add(0, background);
        //
        d.setColor(Color.BLACK);
        d.drawText(600, 15, "Level Name: " + this.level.levelName(), 15);
        d.drawText(30, 15, "Remaining Blocks: " + Integer.toString(this.remainingBlocks.getValue()), 15);
        d.drawText(220, 15, "Remaining Balls: " + Integer.toString(this.remainingBalls.getValue()), 15);
        //
        if (this.remainingBlocks.getValue() == 0) {
            score.increase(100);
            this.running = false;
        } else if (this.remainingBalls.getValue() == 0) {
            this.running = false;
            this.runner.run(new EndScreen(this.keyboard, score, false), this.level.levelName(), score);
            //
            this.runner.getGui().close();
            //
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard), this.level.levelName(), score);
        }
    }

    /**
     * Gets runner.
     *
     * @return the runner
     */
    public AnimationRunner getRunner() {
        return (this.runner);
    }
}