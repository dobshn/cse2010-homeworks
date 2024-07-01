package cse2010.hw2;

public class Entry {
    private int row;
    private int col;
    private double value;

    public Entry(int row, int col, double value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public Entry(Entry other) {
        this.row = other.row;
        this.col = other.col;
        this.value = other.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry entry)) return false;
        return row == entry.row &&
                col == entry.col &&
                Double.compare(entry.value, value) == 0;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ", " + value + ")";
    }
}
