package lab2;

public abstract class GeometricFigure {
    protected double length;
    protected double width;
    private static int counter = 0;

    public GeometricFigure(double length, double width) {
        this.length = length;
        this.width = width;
        counter++;
    }

    public GeometricFigure() {

    }

    public void showInformation() {
        System.out.println("This is an undefined geometric figure.");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
    }


    public abstract double calculateArea();

    public abstract double calculateVolume();

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public static int getCounter() {
        return counter;
    }

    protected void setRadius(double radius) {
    }
}
