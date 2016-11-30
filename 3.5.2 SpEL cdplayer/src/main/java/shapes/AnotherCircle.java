package shapes;

public class AnotherCircle {

    private double length;
    private double square;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "AnotherCircle{" +
                "length=" + length +
                ", square=" + square +
                '}';
    }
}
