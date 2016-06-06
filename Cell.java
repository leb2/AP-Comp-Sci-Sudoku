public class Cell {
    private boolean set;
    private int value;

    public Cell() {
        this(false, 0);
    }

    public Cell(boolean s, int v) {
        if (s) {
            set = true;
            value = v;
        } else if (v > 0 && v <=9) {
            set = false;
            value = v;
        } else {
            set = false;
            value = 0;
        }
    }

    public void setValue(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
