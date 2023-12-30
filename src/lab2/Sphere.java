package lab2;

public class Sphere extends GeometricFigure {
    private double radius;

    public Sphere() {
        super(15.0, 20.0);
    }
    public Sphere(double length, double width, double radius) {
        super(length, width);
        this.radius = radius;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public double getLength() {
        return super.getLength();
    }
    @Override
    public double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double calculateVolume() {
        return (4 / 3) * Math.PI * radius * radius * radius;
    }

    public double calculateDiameter() {
        return 2 * radius;
    }

    @Override
    public void showInformation() {
        calculateArea();
        System.out.println("This is a sphere.");
        System.out.println("Width: " + width);
        System.out.println("Radius: " + radius);
        System.out.println("Diameter:" + calculateDiameter());
        System.out.println("Area: " + calculateArea());
        System.out.println("Volume: " + calculateVolume());
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
