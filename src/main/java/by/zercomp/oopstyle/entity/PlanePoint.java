package by.zercomp.oopstyle.entity;

public class PlanePoint {

    private double x;
    private double y;

    public PlanePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distFromCenter() {
        return Math.hypot(x, y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 113;
        int result = 1;
        result = prime * result + (int) (x * 100);
        return prime * result + (int) (y * 100);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        PlanePoint other = (PlanePoint) o;
        int xEq = Double.compare(this.x, other.getX());
        int yEq = Double.compare(this.y, other.getY());
        return xEq == 0 && yEq == 0;
    }

    @Override
    public String toString() {
        return new StringBuilder("Point {\n").append("\tx:").append(this.x)
                .append(", \n\ty:").append(this.y).append("\n}").toString();
    }
}
