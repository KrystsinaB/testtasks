package com.epam.test;

import java.util.Scanner;

/**
 * Created by Krystsina_Bakatsiuk on 8/25/2015.
 */
public class ArrayManager {

    public void fillArrayWithRandomData(int array []) { // filling any array with random numbers from 0 to 100

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
    }

    public void bubbleSorting(int array[]) { // sorting any array using Bubble sorting variant 1
        int element;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j + 1]) {
                    element = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = element;
                }
            }
        }
    }

    public void bubbleDescendingSorting(int array[]) { // sorting any array using Bubble sorting variant 2
        int element;
        for (int i = array.length-1; i>0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    element = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = element;
                }
            }
        }
    }

    public void showArrayInConsol (int array[]){ //printing any array into Consol
        String arrayInString = new String();
        for (int i=0; i<array.length; i++){
            arrayInString = arrayInString + array[i] + " ";
        }
        System.out.println(arrayInString);
    }

    public void showSrtArrayInConsol (String array[]) { //printing any array into Consol
        //String arrayInString = new String();
        for (int i = 0; i < array.length; i++) {
        //    arrayInString = arrayInString + array[i] + " ";
            System.out.println(array[i]);
        }
        System.out.println(array.length);
        //System.out.println(arrayInString);
    }

    public int enterArrayRange () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array range");
        int range=scanner.nextInt();
        return range;
    }
}

