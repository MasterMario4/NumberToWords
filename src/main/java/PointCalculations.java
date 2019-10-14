public class PointCalculations {
    static double calculateDistance(Point p1, Point p2) {
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();

        return Math.sqrt(Math.pow((x2 - x1), 2)
                + Math.pow((y2 - y1), 2));
    }

    static double calculateDistance3D(Point3D p1, Point3D p2) {
        double x1 = p1.getX();
        double x2 = p2.getX();

        double y1 = p1.getY();
        double y2 = p2.getY();

        double z1 = p1.getZ();
        double z2 = p2.getZ();

        return Math.sqrt(Math.pow((x2 - x1), 2)
                + Math.pow((y2 - y1), 2)
                + Math.pow((z2 - z1), 2));
    }

    static double calculateArea2D(Point p1, Point p2, Point p3) {
        double a = calculateDistance(p1, p2);
        double b = calculateDistance(p2, p3);
        double c = calculateDistance(p3, p1);

        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    static double calculateArea3D(Point3D p1, Point3D p2, Point3D p3) {
        double a = calculateDistance3D(p1, p2);
        double b = calculateDistance3D(p2, p3);
        double c = calculateDistance3D(p3, p1);

        double p = 0.5 * (a + b + c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    static void calculatePyramid(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        System.out.println("Długości boków:");
        System.out.println(calculateDistance3D(p1, p2));
        System.out.println(calculateDistance3D(p1, p3));
        System.out.println(calculateDistance3D(p1, p4));
        System.out.println(calculateDistance3D(p2, p3));
        System.out.println(calculateDistance3D(p2, p4));
        System.out.println(calculateDistance3D(p3, p4));
        System.out.println("---------------------");
        System.out.println("Pola powierzchni wszystkich ścian:");
        System.out.println(calculateArea3D(p1, p2, p3));
        System.out.println(calculateArea3D(p1, p2, p4));
        System.out.println(calculateArea3D(p1, p3, p4));
        System.out.println(calculateArea3D(p2, p3, p4));
        System.out.println("---------------------");
        System.out.println("Pole powierzchni bryły: ");
        double s
                = calculateArea3D(p1, p2, p3)
                + calculateArea3D(p1, p2, p4)
                + calculateArea3D(p1, p3, p4)
                + calculateArea3D(p2, p3, p4);

        System.out.println(s);
    }


}
