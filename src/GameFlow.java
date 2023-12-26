
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter();
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner);

            level.initialize(this.score);
            this.animationRunner.run(level, levelInfo.levelName(), this.score);
            /*
            while (level has more blocks and balls) {
                level.run();
            }

            if (no more balls) {
                break;
            }

             */
        }
        if (levels.size() != 0) {
            this.animationRunner.run(new EndScreen(this.keyboardSensor, score, true), null, this.score);
            this.animationRunner.getGui().close();
        } else {
            this.animationRunner.run(new NaughtyScreen(this.keyboardSensor), null, this.score);
            this.animationRunner.getGui().close();
        }
    }
}