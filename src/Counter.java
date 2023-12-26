
/**
 * The type Counter.
 */
public class Counter {
    private int count;

    /**
     * Instantiates a new Counter.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * Increase.
     * add number to current count.
     * @param number the number
     */
    public void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * Decrease.
     * subtract number from current count.
     * @param number the number
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * Gets value.
     * get current count.
     * @return the value
     */
    public int getValue() {
        return (this.count);
    }
}