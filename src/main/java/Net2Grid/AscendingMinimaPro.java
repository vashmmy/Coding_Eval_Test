package Net2Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

/**
 * This class is used as the implementation of the ascending minimum algorithm. For documentation about the algorithm,
 * visit the following link <url>https://softwarelearner.blogspot.com/2011/04/minima-in-sliding-window.html</url>.
 *
 * @author Angelos Vasileiadis
 * @version 1.00, Date: 18.12.2018
 */
public class AscendingMinimaPro {

    /**
     * This variable is used for storing any new value that we want to import to the initial array.
     */
    private Double newValue;

    /**
     * This variable is a list of Doubles, that stores the initial array (for whom we want to compute the ascending minima array).
     */
    private ArrayList<Double> myData;

    /**
     * This variable is an auxiliary list of Integers, that stores the indexes of the elements of myData List. Each new import to myData List,
     * adds a respectively incremented index value which is stored in myIndexes.
     */
    private ArrayList<Integer> myIndexes;

    /**
     * This variable is used to store the ascending minima ArrayList<Double>.
     */
    private ArrayList<Double> ama;

    /**
     * This variable is an auxiliary list of Integers, that stores the indexes of the ascendig minima array.
     */
    private ArrayList<Integer> ama_index;

    /**
     * This is the void constructor of the class. It is used for initialization purposes. If an instance is created
     * through this constructor, it it obsolete for setMyData() method to be called by the user in the future.
     */
    public AscendingMinimaPro() {

        // Initialize the private variables
        myData = new ArrayList<>();
        myIndexes = new ArrayList<>();
        ama = new ArrayList<>();
        ama_index = new ArrayList<>();
    }

    /**
     * This is the constructor of the class, in case of input data as type of List<Double>.
     * @param inputData is the List<Double> to compute its ascending minima array.
     */
    public AscendingMinimaPro(ArrayList<Double> inputData){

        // If the argument ArrayList is void, throw IllegalArgumentException
        if (inputData.size() == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        myData = inputData;
        computeMinima();
    }

    /**
     * This is the getter method for myData ArrayList variable.
     * @return the myData variable.
     */
    public ArrayList<Double> getMyData(){ return myData; }

    /**
     * This is the setter method for myData ArrayList variable
     * @param myData the value to be assigned to myData private variable of the class
     */
    public void setMyData(ArrayList<Double> myData){ this.myData = myData; }

    /**
     * This is the getter method for newValue Double variable.
     * @return the newValue variable.
     */
    public Double getNewValue(){ return newValue; }

    /**
     * This is the setter method for newValue Double variable
     * @param newValue the value to be assigned to myValue private variable of the class
     */
    public void setNewValue(Double newValue) { this.newValue = newValue; }


    public void computeMinima(){

    }



}
