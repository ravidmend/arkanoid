
import java.util.LinkedList;

/**
 * The type GameLevel environment.
 */
public class GameEnvironment {
    private java.util.List<Collidable> objectsInTheGame;

    /**
     * Instantiates a new GameLevel environment.
     */
    public GameEnvironment() {
        this.objectsInTheGame = new LinkedList<Collidable>();
    }

    /**
     * Add collidable.
     *
     * @param c the collidable
     */
    public void addCollidable(Collidable c) {
        this.objectsInTheGame.add(c);
    }

    /**
     * Gets closest collision.
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables in this collection, return null
     * Else, return the information about the closest collision that is going to occur.
     * @param trajectory the trajectory
     * @return the info of the closest collision
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Collidable collisionObject = null;
        Point collisionPoint = null;
        Double minDistance = Double.MAX_VALUE;
        //go all over the objects in the game in search for the closest collision
        for (int i = 0; i < this.objectsInTheGame.size(); i++) {
            Point closest = trajectory.closestIntersectionToStartOfLine(this.objectsInTheGame.get(i)
                    .getCollisionRectangle());
            if (closest != null && closest.distance(trajectory.start()) < minDistance) {
                collisionObject = this.objectsInTheGame.get(i);
                collisionPoint = closest;
                //
                minDistance = closest.distance(trajectory.start());
                //
            }
        }
        if ((collisionPoint != null) && (collisionObject != null)) {
            return (new CollisionInfo(collisionPoint, collisionObject));
        }
        return null;
    }

    /**
     * Gets objects in the game.
     *
     * @return the objects in the game
     */
    public java.util.List<Collidable> getObjectsInTheGame() {
        return (this.objectsInTheGame);
    }
}