
import java.util.LinkedList;
import java.util.List;

/**
 * The type Ass 6 game.
 */
public class Ass6Game {
    /**
     * the game.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AnimationRunner an = new AnimationRunner(60);
        //create the game
        GameFlow game = new GameFlow(an, an.getGui().getKeyboardSensor());
        List<LevelInformation> levels = new LinkedList<LevelInformation>();
        //add level by the args
        for (int i = 0; i < args.length; i++) {
            if (checkNumber(args[i])) {
                if (Integer.parseInt(args[i]) == 1) {
                    levels.add(new CoolLevel1());
                } else if (Integer.parseInt(args[i]) == 2) {
                    levels.add(new CoolLevel2());
                } else {
                    levels.add(new CoolLevel3());
                }
            }
        }
        //if there are no arguments we add 1 2 3 levels
        if (args.length == 0) {
            levels.add(new CoolLevel1());
            levels.add(new CoolLevel2());
            levels.add(new CoolLevel3());
        } else if (args[0].equals("${args}")) {
            levels.add(new CoolLevel1());
            levels.add(new CoolLevel2());
            levels.add(new CoolLevel3());
        }
        game.runLevels(levels);
    }

    /**
     * Check number boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean checkNumber(String str) {
        for (int j = 0; j < str.length(); j++) {
            if (!(('1' <= str.charAt(j) && str.charAt(j) <= '3'))) {
                return false;
            }
        }
        if (!((1 <= Integer.parseInt(str) && Integer.parseInt(str) <= 3))) {
            return false;
        }
        return true;
    }
}
