package lab2;

public class Cylinder extends GeometricFigure {
    private double height;
    private double radius;

    public Cylinder(double length, double width, double height, double radius) {
        super(length, width);
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return (2 * Math.PI * radius * radius) + (2 * Math.PI * radius * height);
    }

    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }

    public void showInformation() {
        System.out.println("This is a cylinder.");
        System.out.println("Height: " + height);
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Volume: " + calculateVolume());
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
