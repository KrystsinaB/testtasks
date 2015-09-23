package com.epam.test;
import java.io.*;

/**
 * Created by Krystsina_Bakatsiuk on 8/26/2015.
 */
public class FileManager {

    public void  createInputFile (int array [], String urlvalue) throws IOException {
        File fileForInputData = new File (urlvalue);
        if (! fileForInputData.exists()) {
            fileForInputData.createNewFile();
        }
        FileWriter fileForFilling = new FileWriter(urlvalue);
        for (int i=0; i<array.length; i++) {
            fileForFilling.write(Integer.toString(array[i])+' ');
        }
        fileForFilling.close();
    }

    public String readArrayFromFileInString (String urlvalue) throws IOException {
        BufferedReader fillWithDataForSorting = new BufferedReader(new FileReader((urlvalue)));
            String line = "";
            for(int value; (value = fillWithDataForSorting.read()) != -1; ) {
                char c = (char) value;
                line += c;
        }
        return line;
    }

    public int numberOfBlanksInString (String stringFromFile) {
        int numberOfBlanks=0;
        for (int i=0; i<stringFromFile.length(); i++) {
            if (stringFromFile.charAt(i) == ' ') {
                numberOfBlanks++;
            }
        }
        return numberOfBlanks;
    }

    public void createIntArrayFromStringReadFromFile(int [] intArrayFromFileString, String stringFromFile) throws IOException {
        int j = 0,i;
        String line="";
        i=0;
        while (i<stringFromFile.length()) {
            if (stringFromFile.charAt(i) != ' ') {
                do {
                line = line+stringFromFile.charAt(i);
                i++;}
                while (stringFromFile.charAt(i) != ' ');
                intArrayFromFileString[j]=Integer.parseInt(line);
                j++;
                line = "";
            }
            else {i++;}
        }
    }

    public void makeArrayUsingSplit (int [] fileArrayInInt, String stringFromFile) throws IOException{

        String [] fileArray = stringFromFile.split(" ");
        int i;
        for (i=0; i < fileArray.length; i++){
            fileArrayInInt [i] = Integer.parseInt(fileArray[i]);
        }
    }

    public int maxValueInArray (int array []){
        int maxValue=array[0];
        for (int i=0; i<array.length; i++) {
            if (maxValue<array[i]) {
                maxValue=array[i];
            }
        }
        return maxValue;
    }

    public int minValueInArray (int array []){
        int minValue=array[0];
        for (int i=0; i<array.length; i++) {
            if (minValue>array[i]) {
                minValue=array[i];
            }
        }
        return minValue;
    }

    public void countLettersInLine (String fileURL) throws IOException {
        String stringFromFile = readArrayFromFileInString(fileURL);
        String [] fileArray = stringFromFile.split(" ");
        System.out.println("array using split");
        ArrayManager sortList = new ArrayManager();
        sortList.showSrtArrayInConsol(fileArray);

        int i,j, k=0;
        for (i=0; i<fileArray.length; i++) {
            for (j = 0; j < fileArray[i].toCharArray().length; j++) {
                if (fileArray[i].toCharArray()[j] == 'a') {
                    k++;
                }
            }
        }
        System.out.println("number of a" + " " + k);
    }
}

