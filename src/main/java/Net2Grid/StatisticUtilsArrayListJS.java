package Net2Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StatisticUtilsArrayListJS {

    /**
     * This variable is responsible for the computation of the metrics internally, given an ArrayList<Double>
     */
    ArrayList<Double> inputData;

    /**
     * This is the void constructor method of the class, used for initialization purposes.
     */
    public StatisticUtilsArrayListJS(){ }

    /**
     * This is the main constructor method of the class, used for initialization purposes. It takes the given ArrayList<Double>as an
     * input, and stores it in the variable inputData.
     *
     * @param inputData The ArrayList of the given data to compute the metrics.
     */
    public StatisticUtilsArrayListJS(ArrayList<Double> inputData) {

        // If the argument ArrayList is void, throw IllegalArgumentException
        if (inputData.size() == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        // Initialize the private variable inputData and store in it, the contents of the given ArrayList
        this.inputData = inputData;
    }

    /**
     * This is the getter method for the inputData variable.
     *
     * @return the inputData variable.
     */
    public ArrayList<Double> getInputData() {

        // In case of null inputData variable, throw NullPointerException
        if (inputData == null){
            throw new NullPointerException("Input ArrayList is Null. Cannot Return inputData");
        }
        return inputData;
    }

    /**
     * This is the setter method for inputData variable.
     * @param inputData The ArrayList<Double> to be assigned to inputData variable.
     */
    public void setInputData(ArrayList<Double> inputData) { this.inputData = inputData; }

    /**
     * This is the method to find the minimum of the given array of the given ArrayList.
     *
     * @return The minimum value of the given ArrayList.
     */
    public double findMin() { return inputData.stream().mapToDouble(i -> i).summaryStatistics().getMin(); }

    /**
     * This is the method to find the maximum of the given array of the given ArrayList.
     *
     * @return The maximum value of the given ArrayList.
     */
    public double findMax(){ return inputData.stream().mapToDouble(i -> i).summaryStatistics().getMax(); }

    /**
     * This is the method to find the mean of the given array of the given ArrayList.
     *
     * @return The mean value of the given array of the given ArrayList.
     */
    public double findMean(){ return inputData.stream().mapToDouble(i -> i).summaryStatistics().getAverage(); }

    /**
     * This is the method to find the median of the given array of the given ArrayList.
     *
     * @return The median value of the given ArrayList.
     */
    public double findMedian(){

        /* Java Streams API does not offer the direct extraction of the standardDeviation. So we return the value manually.
           Sort the array to find the middle value */
        double[] sortedInputData = inputData.stream().mapToDouble(i -> i).sorted().toArray();

        /* If the length of the inputData array is even, return the mean of the two middle values,
           else find the middle value*/
        if (sortedInputData.length % 2 == 0 ){
            return (sortedInputData[(sortedInputData.length/2) - 1] + sortedInputData[(sortedInputData.length/2)]) / 2 ;
        }else{
            return sortedInputData[sortedInputData.length/2];
        }
    }

    /**
     * This is the method to find the standard deviation of the given array of doubles.
     *
     * @return The standard deviation value of the given array of doubles.
     */
    public double findStandardDeviation(){

        /* Java Streams API does not offer the direct extraction of the standardDeviation. So we return the value manually.
           applying the standard deviation formulae */
        return  Math.sqrt(inputData.stream().mapToDouble(i -> Math.pow(i - (inputData.stream().mapToDouble(j -> j).summaryStatistics().getAverage()),2)).sum()/(inputData.size()-1));
    }
}
