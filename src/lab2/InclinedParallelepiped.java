package lab2;

public class InclinedParallelepiped extends Parallelepiped {
    private double inclinationAngle;

    public InclinedParallelepiped(double length, double width, double height, double inclinationAngle) {
        super(length, width, height);
        this.inclinationAngle = inclinationAngle;
    }

    public double getInclinationAngle() {
        return inclinationAngle;
    }

    public void setInclinationAngle(double inclinationAngle) {
        this.inclinationAngle = inclinationAngle;
    }

    @Override
    public void showInformation() {
        calculateArea();
        System.out.println("This is an inclined parallelepiped.");
        System.out.println("Angle: " + inclinationAngle);
    }

    public String getter() {
        return "Добрый вечер";
    }
}
