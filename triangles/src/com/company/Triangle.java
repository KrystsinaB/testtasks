package com.company;

/**
 * Created by Krystsina_Bakatsiuk on 9/16/2015.
 */
public class Triangle {
    public Points point1  = new Points();
    public Points point2 = new Points();
    public Points point3 = new Points();

    public void enterTrianglePoints () {
        point1.enterCoordatesForPoint();
        point2.enterCoordatesForPoint();
        if (point1.isEqualPoints(point2)==true){
            System.out.println("Points are equal, re-enter point2 coordinates");
            point2.enterCoordatesForPoint();
        }
        point3.enterCoordatesForPoint();
        if ((point1.isEqualPoints(point3))||(point2.isEqualPoints(point3))){
            System.out.println("Point3 is equal with point 1 or 2, re-enter point3 coordinates");
            point3.enterCoordatesForPoint();
        }
        if (point1.isCollinear(point2, point3)==true) {
            do {
                System.out.println("Points are collinear, re-enter all points");
                point1.enterCoordatesForPoint();
                point2.enterCoordatesForPoint();
                point3.enterCoordatesForPoint();
            } while (point1.isCollinear(point2, point3)==true);
        }
    }

    public double areaTriangle () {
        Double p;
        p=0.5*(point1.Interval(point2)+point1.Interval(point3)+point2.Interval(point3));
        return Math.sqrt(p*(p-point1.Interval(point2))*(p-point1.Interval(point3))*(p-point2.Interval(point3)));
    }

    public void showTriangleValues (){
        System.out.println("Triangle area values");
        System.out.println(areaTriangle());
        System.out.println("Value of angle1");
        System.out.println(point1.valueOfAngle(point2, point3));
        System.out.println("Value of angle2");
        System.out.println(point2.valueOfAngle(point1, point3));
        System.out.println("Value of angle3");
        System.out.println(point3.valueOfAngle(point1, point2));
    }
}
