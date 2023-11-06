package life.light.dev;

public class Cell {
    int x;
    int y;
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Cell cell) {
        return cell.x == x && cell.y == y;
    }
}
