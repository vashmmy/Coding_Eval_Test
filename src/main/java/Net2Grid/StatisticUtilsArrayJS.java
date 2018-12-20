package Net2Grid;

import java.util.Arrays;

/**
 * This class is used as an auxiliary class, providing statistical metrics to the user, in the case of a given array of doubles
 * (double[] array). These metrics are: minimum, maximum, mean, median and standard deviation.
 * This class utilizes Java streams for the computation of me metrics mentioned above.
 *
 * @author Angelos Vasileiadis
 * @version 1.0, Date: 13.12.2018
 */
public class StatisticUtilsArrayJS {

    /**
     * This variable is responsible for storing the values of the given array of doubles, to an array of type double[].
     */
    private double[] inputData;

    /**
     * This is the void constructor method of the class, used for initialization purposes.
     */
    public StatisticUtilsArrayJS(){ }

    /**
     * This is the main constructor method of the class, used for initialization purposes. It takes the given array of doubles as an
     * input, stores it the variable inputData and creates the variable stats.
     *
     * @param inputData The array  of the given data to compute the metrics.
     */
    public StatisticUtilsArrayJS(double[] inputData){

        // Check if input is void
        if (inputData.length == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        // Check if input is null
        if (inputData == null){
            throw new NullPointerException("Input Array Is Null");
        }

        // Store the argument into the variable input
        this.inputData = inputData;
    }

    /**
     * This is the setter method for the inputData variable.
     *
     * @param inputData The double[] array to be assinged to inputData variable.
     */
    public void setInputData(double[] inputData){
        this.inputData = inputData;
    }

    /**
     * This is the getter method for the inputData variable.
     *
     * @return the inputData variable.
     */
    public double[] getInputData(){

        // In case of null inputData variable, throw NullPointerException.
        if (this.inputData == null){
            throw new NullPointerException("Input Array was Void. Cannot return inputData");
        }
        return this.inputData;
    }

    /**
     * This is the method to find the minimum of the given array of doubles.
     *
     * @return The minimum value of the given array of doubles.
     */
    public double findMin(){
        return Arrays.stream(inputData).summaryStatistics().getMin();
    }

    /**
     * This is the method to find the maximum of the given array of doubles.
     *
     * @return The maximum value of the given array of doubles.
     */
    public double findMax(){
        return Arrays.stream(inputData).summaryStatistics().getMax();
    }

    /**
     * This is the method to find the mean of the given array of doubles.
     *
     * @return The mean value of the given array of doubles.
     */
    public double findMean(){
        return Arrays.stream(inputData).summaryStatistics().getAverage();
    }

    /**
     * This is the method to find the median of the given array of doubles.
     *
     * @return The median value of the given array of doubles.
     */
    public double findMedian(){

        /* Java Streams API does not offer the direct extraction of the standardDeviation. So we return the value manually.
           Sort the array to find the middle value */
        double[] sortedInputData = Arrays.stream(inputData).sorted().toArray();

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
           Apply the standard deviation formulae and return the result */
        double sum = 0;
        double average = Arrays.stream(inputData).summaryStatistics().getAverage();
        for (double elem : inputData){ sum += Math.pow((elem - average) , 2); }
        return Math.sqrt( sum / (inputData.length-1));
    }
}
