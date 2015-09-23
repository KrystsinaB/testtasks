package com.epam.test;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayManager sortList = new ArrayManager();
        // Work with number arrays;
        // create an array with a range provided via console
        int array[] = new int[sortList.enterArrayRange()];
        // fill his array with random int data
        sortList.fillArrayWithRandomData(array);
        // show the array in console
        System.out.println("Default array");
        sortList.showArrayInConsol(array);
        // Create a file for input data and populate it with array created in steps 1-2.
        FileManager arraysFromFiles = new FileManager();
        arraysFromFiles.createInputFile(array, "d://input.txt");
        // Read input file into string
        String stringFromFile = arraysFromFiles.readArrayFromFileInString("d://input.txt");
        // create an array for storing values from file. This is an equal array with one cretaed in steps 1-2, but it's created separately for cases, when input file is created manually, not from pre-populated array
        int [] intArrayFromFileString = new int [arraysFromFiles.numberOfBlanksInString(stringFromFile)];
        // fill an array with data - variant when read char by char from read string from input file, join chars between blanks into 1 string and parse them in numbers
        arraysFromFiles.createIntArrayFromStringReadFromFile(intArrayFromFileString, stringFromFile);
        // bubble sorting for int array - realization 1
        sortList.bubbleDescendingSorting(intArrayFromFileString);
        // show the sorted array
        System.out.println("Bubble 1 Sorted array read from file as a int array ");
        sortList.showArrayInConsol(intArrayFromFileString);
        // fill an array with data using split function
        arraysFromFiles.makeArrayUsingSplit(intArrayFromFileString, stringFromFile);
        // bubble sorting for int array - realization 2
        sortList.bubbleSorting(intArrayFromFileString);
        // show the sorted array
        System.out.println("Bubble 2 Sorted array created using split ");
        sortList.showArrayInConsol(intArrayFromFileString);
        //Find a max value in an array
        System.out.println("Max value in array " + arraysFromFiles.maxValueInArray(intArrayFromFileString));
        //Find a min value in an array
        System.out.println("Min value in array "+arraysFromFiles.minValueInArray(intArrayFromFileString));
    }
}
