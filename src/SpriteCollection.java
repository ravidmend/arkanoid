
import java.util.LinkedList;
import biuoop.DrawSurface;
/**
 * The type Sprite collection.
 */
public class SpriteCollection {
    private java.util.List<Sprite> spriteList;
    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.spriteList = new LinkedList<Sprite>();
    }

    /**
     * Gets sprite list.
     *
     * @return the sprite list
     */
    public java.util.List<Sprite> getSpriteList() {
        return (this.spriteList);
    }

    /**
     * Add sprite.
     *
     * @param s the sprite
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * Notify all time passed.
     *  call timePassed() on all sprites.
     */

    public void notifyAllTimePassed() {
        for (int i = 0; i < this.spriteList.size(); i++) {
            this.spriteList.get(i).timePassed();
        }
    }

    /**
     * Draw all on.
     * call drawOn(d) on all sprites.
     * @param d the d
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.spriteList.size(); i++) {
            this.spriteList.get(i).drawOn(d);
        }
    }
}