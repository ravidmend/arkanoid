
/**
 * The type Line.
 */
public class Line {
    private Point start;
    private Point end;
    private static final double COMPARISON_THRESHOLD = 0.00001;

    /**
     * Instantiates a new Line.
     *
     * @param x1 x of start point
     * @param y1 y of start point
     * @param x2 x of end point
     * @param y2 y of end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        this.start = start;
        this.end = end;
    }
    /**
     * Is intersecting boolean.
     * checks if 2 line are intersecting
     *
     * @param other the other
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        //I take the borders of the lines for future calculating and making things easier
        double thisMinX = Math.min(this.start.getX(), this.end.getX());
        double thisMaxX = Math.max(this.start.getX(), this.end.getX());
        double thisMinY = Math.min(this.start.getY(), this.end.getY());
        double thisMaxY = Math.max(this.start.getY(), this.end.getY());
        double otherMinX = Math.min(other.start().getX(), other.end().getX());
        double otherMaxX = Math.max(other.start().getX(), other.end().getX());
        double otherMinY = Math.min(other.start().getY(), other.end().getY());
        double otherMaxY = Math.max(other.start().getY(), other.end().getY());
        //if both lines are x=constant kind of line
        if ((doubleEquals(this.end.getX(), this.start.getX()))
                && (doubleEquals(other.end().getX(), other.start().getX()))) {
            if (doubleEquals(this.end.getX(), other.end().getX())) {
                //we check if the intersection is actually in the line
                return (((thisMinY <= otherMinY) && (otherMinY <= thisMaxY))
                        || ((thisMinY <= otherMaxY) && (otherMaxY <= thisMaxY)));
            }
            return (false);
            //if one of them is x=constant type
        } else if (doubleEquals(this.end.getX(), this.start.getX())) {
            double otherM = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());
            double targetY = this.end.getX() * otherM - other.end().getX() * otherM + other.end().getY();
            return ((thisMinY <= targetY) && (targetY <= thisMaxY) && (otherMinY <= targetY) && (targetY <= otherMaxY));
        } else if (doubleEquals(other.end().getX(), other.start().getX())) {
            double thisM = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            double targetY = other.end().getX() * thisM - this.end.getX() * thisM + this.end.getY();
            //we check if the intersection is actually in the line
            return ((thisMinY <= targetY) && (targetY <= thisMaxY) && (otherMinY <= targetY) && (targetY <= otherMaxY));
        }
        //if it not the type above then there is incline
        double thisM = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        double otherM = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());
        if (doubleEquals(thisM, otherM)) {
            if (doubleEquals(-this.end.getX() * thisM + this.end.getY(),
                    -other.end().getX() * otherM + other.end().getY())) {
                //we check if the intersection is actually in the line
                return (((thisMinX <= otherMinX) && (otherMinX <= thisMaxX))
                        || ((thisMinX <= otherMaxX) && (otherMaxX <= thisMaxX)));
            }
            return (false);
        }
        //if the lines are connected and touching in only one point
        if (this.start.equals(other.start()) || this.start.equals(other.end()) || this.end.equals(other.start())
                || this.end.equals(other.end())) {
            return true;
        }
        //we get the intersection point of the lines by some math
        double interX = (this.end.getX() * thisM - other.end().getX() * otherM + other.end().getY() - this.end.getY())
                / (thisM - otherM);
        double interY = thisM * interX - this.end.getX() * thisM + this.end.getY();
        //we check if the intersection is actually in the line
        return ((thisMinX <= interX) && (interX <= thisMaxX) && (thisMinY <= interY) && (interY <= thisMaxY)
                && (otherMinX <= interX) && (interX <= otherMaxX) && (otherMinY <= interY) && (interY <= otherMaxY));
    }

    /**
     * Length double.
     *
     * @return the length of the line
     */
    public double length() {
        return (Math.sqrt(Math.pow(this.start.getX() - this.end.getX(), 2)
                + Math.pow(this.start.getY() - this.end.getY(), 2)));
    }

    /**
     * Middle point.
     *
     * @return the middle point of the line
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return (new Point(midX, midY));
    }

    /**
     * Start point.
     *
     * @return the start point of the line
     */
    public Point start() {
        return (this.start);
    }

    /**
     * End point.
     *
     * @return the end point of the line
     */
    public Point end() {
        return (this.end);
    }

    /**
     * Intersection with point.
     * Returns the intersection point if the lines intersect, and null otherwise.
     * @param other the other
     * @return the point
     */
    public Point intersectionWith(Line other) {
        if (!(this.isIntersecting(other))) {
            return (null);
        }
        //I take the borders of the lines for future calculating and making things easier
        double thisMinX = Math.min(this.start.getX(), this.end.getX());
        double thisMaxX = Math.max(this.start.getX(), this.end.getX());
        double thisMinY = Math.min(this.start.getY(), this.end.getY());
        double thisMaxY = Math.max(this.start.getY(), this.end.getY());
        double otherMinX = Math.min(other.start().getX(), other.end().getX());
        double otherMaxX = Math.max(other.start().getX(), other.end().getX());
        double otherMinY = Math.min(other.start().getY(), other.end().getY());
        double otherMaxY = Math.max(other.start().getY(), other.end().getY());
        //if both lines are x=constant kind of line
        if ((doubleEquals(this.end.getX(), this.start.getX()))
                && (doubleEquals(other.end().getX(), other.start().getX()))) {
            if (doubleEquals(this.end.getX(), other.end().getX())) {
                if (doubleEquals(thisMinY, otherMaxY)) {
                    return (new Point(this.end.getX(), thisMinY));
                } else if (doubleEquals(thisMaxY, otherMinY)) {
                    return (new Point(this.end.getX(), thisMaxY));
                }
            }
            return (null);
        // if one of the lines is x=constant kind of line
        } else if (doubleEquals(this.end.getX(), this.start.getX())) {
            double otherM = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());
            double targetY = this.end.getX() * otherM - other.end().getX() * otherM + other.end().getY();
            if ((thisMinY <= targetY && targetY <= thisMaxY) && (otherMinX <= thisMinX && thisMinX <= otherMaxX)) {
                return (new Point(this.end.getX(), targetY));
            }
            return (null);
        // if one of the lines is x=constant kind of line
        } else if (doubleEquals(other.end().getX(), other.start().getX())) {
            double thisM = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            double targetY = other.end().getX() * thisM - this.end.getX() * thisM + this.end.getY();
            if ((otherMinY <= targetY && targetY <= otherMaxY) && (thisMinX <= otherMinX && otherMinX <= thisMaxX)) {
                return (new Point(other.end().getX(), targetY));
            }
            return (null);
        }
        //their M by some math
        double thisM = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        double otherM = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());
        if (doubleEquals(thisM, otherM)) {
            if (doubleEquals(-this.end.getX() * thisM + this.end.getY(),
                    -other.end().getX() * otherM + other.end().getY())) {
                if (doubleEquals(thisMinX, otherMaxX)) {
                    double interY = thisM * thisMinX - this.end.getX() * thisM + this.end.getY();
                    return (new Point(thisMinX, interY));
                } else if (doubleEquals(thisMaxX, otherMinX)) {
                    double interY = thisM * thisMaxX - this.end.getX() * thisM + this.end.getY();
                    return (new Point(thisMaxX, interY));
                }
            }
            return (null);
        }
        //the intersection point by some math
        double interX = (this.end.getX() * thisM - other.end().getX() * otherM + other.end().getY() - this.end.getY())
                / (thisM - otherM);
        double interY = thisM * interX - this.end.getX() * thisM + this.end.getY();
        if ((thisMinX <= interX) && (interX <= thisMaxX) && (thisMinY <= interY) && (interY <= thisMaxY)
                && (otherMinX <= interX) && (interX <= otherMaxX) && (otherMinY <= interY) && (interY <= otherMaxY)) {
            return (new Point(interX, interY));
        }
        return (null);
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return true if the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return (doubleEquals(this.start.getX(), other.start().getX())
                && doubleEquals(this.end.getX(), other.end().getX())
                && doubleEquals(this.start.getY(), other.start().getY())
                && doubleEquals(this.end.getY(), other.end().getY())
                || (doubleEquals(this.start.getX(), other.end().getX())
                && doubleEquals(this.end.getX(), other.start().getX())
                && doubleEquals(this.start.getY(), other.end().getY())
                && doubleEquals(this.end.getY(), other.start().getY())));
    }

    /**
     * Double equals boolean.
     *
     * @param a the a
     * @param b the b
     * @return true if it's the same number
     */
    public static boolean doubleEquals(double a, double b) {
        return  Math.abs(a - b) < Line.COMPARISON_THRESHOLD;
    }

    /**
     * Closest intersection to start of line point.
     * If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the
     * start of the line.
     * @param rect the rectangle
     * @return Closest intersection to start of line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //get the intersection points of the line
        java.util.List<Point> list = rect.intersectionPoints(this);
        //if there are no points
        if (list.size() == 0) {
            return (null);
        //if there is one point
        } else if (list.size() == 1) {
            return (list.get(0));
        //there are 2 points we check to se who is the closest one
        } else {
            double firstDis = this.start().distance(list.get(0));
            double secondDis = this.start().distance(list.get(1));
            if (firstDis < secondDis) {
                return list.get(0);
            } else {
                return list.get(1);
            }
        }
    }
}
