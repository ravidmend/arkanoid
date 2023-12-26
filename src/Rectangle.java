
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.LinkedList;
/**
 * The type Rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Line lineUp;
    private Line lineDown;
    private Line lineLeft;
    private Line lineRight;
    private java.awt.Color color;

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
        this.lineUp = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY());
        this.lineDown = new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY() + this.getHeight());
        this.lineLeft = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight());
        this.lineRight = new Line(this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY() + this.getHeight());
    }

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     * @param color     the color
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
        this.color = color;
        this.lineUp = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY());
        this.lineDown = new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY() + this.getHeight());
        this.lineLeft = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight());
        this.lineRight = new Line(this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY() + this.getHeight());
    }

    /**
     * Intersection points java . util . list.
     * Return a (possibly empty) List of intersection points with the specified line.
     * @param line the line
     * @return the (possibly empty) List of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> list = new LinkedList<Point>();
        //if it's intersecting with the upper line
        if (this.lineUp.isIntersecting(line) && this.lineUp.intersectionWith(line) != null) {
            list.add(this.lineUp.intersectionWith(line));
        }
        //if it's intersecting with the lower line and the point isn't already in the list
        if (this.lineDown.isIntersecting(line) && this.lineDown.intersectionWith(line) != null) {
            if (list.size() == 1 && !(this.lineDown.intersectionWith(line).equals(list.get(0)))) {
                list.add(this.lineDown.intersectionWith(line));
            } else if (list.size() == 0) {
                list.add(this.lineDown.intersectionWith(line));
            }
        }
        //if it's intersecting with the left line and the point isn't already in the list
        if (this.lineLeft.isIntersecting(line) && this.lineLeft.intersectionWith(line) != null) {
            if (list.size() == 1 && !(this.lineLeft.intersectionWith(line).equals(list.get(0)))) {
                list.add(this.lineLeft.intersectionWith(line));
            } else if (list.size() == 0) {
                list.add(this.lineLeft.intersectionWith(line));
            }
        }
        //if it's intersecting with the right line and the point isn't already in the list
        if (this.lineRight.isIntersecting(line) && this.lineRight.intersectionWith(line) != null) {
            if (list.size() == 1 && !(this.lineRight.intersectionWith(line).equals(list.get(0)))) {
                list.add(this.lineRight.intersectionWith(line));
            } else if (list.size() == 0) {
                list.add(this.lineRight.intersectionWith(line));
            }
        }
        return (list);
    }

    /**
     * Draw on.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillRectangle((int) this.getUpperLeft().getX(), (int) this.getUpperLeft().getY(),
                (int) this.getWidth(), (int) this.getHeight());
    }

    /**
     * Gets width.
     *
     * @return Return the width and height of the rectangle
     */
    public double getWidth() {
        return (this.width);
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return (this.height);
    }

    /**
     * Gets upper left.
     *
     * @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return (this.upperLeft);
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return (this.color);
    }

    /**
     * Gets line up.
     *
     * @return the upper line
     */
    public Line getLineUp() {
        return (this.lineUp);
    }

    /**
     * Gets line down.
     *
     * @return the lower line
     */
    public Line getLineDown() {
        return (this.lineDown);
    }

    /**
     * Gets line left.
     *
     * @return the left line
     */
    public Line getLineLeft() {
        return (this.lineLeft);
    }

    /**
     * Gets line right.
     *
     * @return the right line
     */
    public Line getLineRight() {
        return (this.lineRight);
    }

    /**
     * Sets upper left.
     * change the location of the rectangle and update his lines
     * @param p the p
     */
    public void setUpperLeft(Point p) {
        this.upperLeft = p;
        this.lineUp = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY());
        this.lineDown = new Line(this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY() + this.getHeight());
        this.lineLeft = new Line(this.upperLeft.getX(), this.upperLeft.getY(),
                this.upperLeft.getX(), this.upperLeft.getY() + this.getHeight());
        this.lineRight = new Line(this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY(),
                this.upperLeft.getX() + this.getWidth(), this.upperLeft.getY() + this.getHeight());
    }
    /**
     * Point in up line boolean.
     *
     * @param p the p
     * @return true if the point is in the upper line false otherwise
     */
    public boolean doesPointInUpLine(Point p) {
        if (this.lineUp.start().getY() == p.getY()) {
            if ((this.lineUp.start().getX() <= p.getX() && p.getX() <= this.lineUp.end().getX())
                    || (this.lineUp.end().getX() <= p.getX() && p.getX() <= this.lineUp.start().getX())) {
                return (true);
            }
        }
        return (false);
    }

    /**
     * Does point in down line boolean.
     *
     * @param p the p
     * @return true if the point is in the lower line false otherwise
     */
    public boolean doesPointInDownLine(Point p) {
        if (this.lineDown.start().getY() == p.getY()) {
            if ((this.lineDown.start().getX() <= p.getX() && p.getX() <= this.lineDown.end().getX())
                    || (this.lineDown.end().getX() <= p.getX() && p.getX() <= this.lineDown.start().getX())) {
                return (true);
            }
        }
        return (false);
    }

    /**
     * Does point in left line boolean.
     *
     * @param p the p
     * @return true if the point is in the left line false otherwise
     */
    public boolean doesPointInLeftLine(Point p) {
        if (this.lineLeft.start().getX() == p.getX()) {
            if ((this.lineLeft.start().getY() <= p.getY() && p.getY() <= this.lineLeft.end().getY())
                    || (this.lineLeft.end().getY() <= p.getY() && p.getY() <= this.lineLeft.start().getY())) {
                return (true);
            }
        }
        return (false);
    }

    /**
     * Does point in right line boolean.
     *
     * @param p the p
     * @return true if the point is in the right line false otherwise
     */
    public boolean doesPointInRightLine(Point p) {
        if (this.lineRight.start().getX() == p.getX()) {
            if ((this.lineRight.start().getY() <= p.getY() && p.getY() <= this.lineRight.end().getY())
                    || (this.lineRight.end().getY() <= p.getY() && p.getY() <= this.lineRight.start().getY())) {
                return (true);
            }
        }
        return (false);
    }

}