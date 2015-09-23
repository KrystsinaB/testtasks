package com.company;
import java.util.*;

/**
 * Created by Krystsina_Bakatsiuk on 9/16/2015.
 */
public class Points {
    public double abscissa;
    public double ordinates;

    public void enterCoordatesForPoint () {
        boolean err;
        do {
            err = false;
            System.out.print("Enter an abscissa: ");
            Scanner scan = new Scanner(System.in);
            if(scan.hasNextDouble()) {
                abscissa = scan.nextDouble();
            } else {
                System.out.println("Incorrect value");
                err = true;
            }
        } while (err);
        do {
            err = false;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter an ordinates ");
            if(scan.hasNextDouble()) {
                ordinates = scan.nextDouble();
            } else {
                System.out.println("Incorrect value");
                err = true;
            }
        } while (err);
    }

    public double Interval (Points point1) {
        return Math.sqrt( Math.pow(abscissa-point1.abscissa,2) + Math.pow(ordinates-point1.ordinates,2) );

    }

    public boolean isCollinear (Points point1, Points point2) {
        boolean isPointsCollinear;
        double k, r;
        k=(point2.ordinates-point1.ordinates)/(point2.abscissa-point1.abscissa);
        r=point1.ordinates-((point2.ordinates-point1.ordinates)/(point2.abscissa-point1.abscissa))*point1.abscissa;
        if (ordinates==(k*abscissa+r)){
            isPointsCollinear=true;
        }
        else {isPointsCollinear=false;}
        return isPointsCollinear;
    }

    public boolean isEqualPoints (Points point1) {
        boolean isPointsEqual=false;
        if ((abscissa==point1.abscissa)&&(ordinates==point1.ordinates)){
            isPointsEqual=true;
        }
        return isPointsEqual;
    }

    public double valueOfAngle (Points point1, Points point2) {
        return Math.toDegrees(Math.acos((Math.pow(Interval(point1), 2) + Math.pow(Interval(point2), 2) - Math.pow(Math.sqrt( Math.pow(point2.abscissa-point1.abscissa,2) + Math.pow(point2.ordinates-point1.ordinates,2) ), 2)) / (2 * Interval(point1) * Interval(point2))));
    }

    public void showPointLocation (){
        if (abscissa==0) {
            System.out.println("Point belongs to the Ordinate line");
        }
        else {
            if (abscissa<0){
                if (ordinates==0){
                    System.out.println("Point belongs to the abscissa line");
                }
                else {
                    if (ordinates<0) {
                        System.out.println("Point belongs to the third Quarter");
                    }
                    else {System.out.println("Point belongs to the second Quarter");}
                }
            }
            else {
                if (ordinates==0){
                    System.out.println("Point belongs to the abscissa line");
                }
                else {
                    if (ordinates<0) {
                        System.out.println("Point belongs to the fourth Quarter");
                    }
                    else {System.out.println("Point belongs to the first Quarter");}
                }
            }
        }
    }
}
