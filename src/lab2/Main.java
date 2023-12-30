package lab2;

public class Main {
    public static void main(String[] args) {
        GeometricFigure figure1 = new Sphere();
        figure1.showInformation();
        figure1.setWidth(5);
        System.out.println(figure1.getWidth());

        GeometricFigure figure2 = new Parallelepiped(4, 6, 7);
        figure2.showInformation();
        System.out.println(((Parallelepiped) figure2).perimeter("The perimeter equals to 23"));
        System.out.println("The perimeter of the base of this parallelepiped is equal to:" + ((Parallelepiped) figure2).perimeter(21));

        GeometricFigure figure3 = new Cylinder(3,1,4, 5);
        figure3.showInformation();

        GeometricFigure figure4 = new InclinedParallelepiped(2, 3, 4, 45);
        figure4.showInformation();
        ((InclinedParallelepiped) figure4).setInclinationAngle(15);
        System.out.println("The inclination angle equals to:" + ((InclinedParallelepiped) figure4).getInclinationAngle());
        System.out.println(((InclinedParallelepiped) figure4).getter());

        System.out.println("Number of geometric figures created: " + GeometricFigure.getCounter());
    }
}
