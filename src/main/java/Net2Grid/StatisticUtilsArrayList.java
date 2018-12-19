package Net2Grid;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.ArrayList;

/**
 * This class is used as an auxiliary class, providing statistical metrics to the user, in the case of a given arrayList of data type Double.
 * (ArrayList<Double> array). These metrics are: minimum, maximum, mean, median and standard deviation.
 *
 * @author Angelos Vasileiadis
 * @version 1.0, Date: 13.12.2018
 */

public class StatisticUtilsArrayList
{
    /**
     * This variable is responsible for storing the values of the given ArrayList<Double> to an array of type double[]
     */
    private double[] inputData;

    /**
     * This variable is responsible for the computation of the metrics internally, given an array of doubles as input.
     */
    private DescriptiveStatistics stats;

    /**
     * This is the void constructor method of the class, used for initialization purposes.
     */
    public StatisticUtilsArrayList(){ }

    /**
     * This is the main constructor method of the class, used for initialization purposes. It takes the given ArrayList<Double>as an
     * input, transforms the ArrayList<Double> to double[], stores in the variable inputData and creates the variable stats
     *
     * @param inputData The ArrayList of the given data to compute the metrics.
     */
    public StatisticUtilsArrayList(ArrayList<Double> inputData)
    {

        // If the argument ArrayList is void, throw IllegalArgumentException
        if (inputData.size() == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        // If the argument ArrayList is null, throw IllegalArgumentException
        if (inputData == null){
            throw new NullPointerException("Input Array Is Null");
        }

        // Initialize the private variable inputData and store in it, the contents of the given ArrayList
        this.inputData = new double[inputData.size()];
        for (int i=0;i<inputData.size();i++){
            this.inputData[i] = inputData.get(i);
        }

        // Get a DescriptiveStatistics instance
        stats = new DescriptiveStatistics(this.inputData);
    }

    /**
     * This is the getter method for the inputData variable
     *
     * @return the inputData variable
     */
    public double[] getInputData()
    {

        // In case of null inputData variable, throw NullPointerException
        if (inputData == null){
            throw new NullPointerException("Input Array is Null. Cannot Return inputData");
        }
        return inputData;
    }

    /**
     * This is the setter method for the inputData variable
     *
     * @param inputData The double[] array to be assinged to inputData variable
     */
    public void setInputData(double[] inputData) {
        this.inputData = inputData;
    }

    /**
     * This is a second (overloaded) setter method for inputData variable, in case the new Data are given in ArrayList<Double> format
     * @param inputData The ArrayList<Double> to be assigned to inputData variable
     */
    public void setInputData(ArrayList<Double> inputData)
    {

        // Converting from ArrayList<Data>to array
        this.inputData = new double[inputData.size()];
        for (int i = 0; i < inputData.size(); i++) {
            this.inputData[i] = inputData.get(i);
        }
    }

    /**
     * This is the getter method for the stats variable
     *
     * @return The stats variable instance
     */
    public DescriptiveStatistics getStats()
    {

        // In case of null stats variable, throw NullPointerException
        if (this.inputData == null){
            throw new NullPointerException("Input Array was null. Cannot return Stats instance");
        }
        return stats;
    }

    /**
     * This is the setter method for the stats variable
     *
     * @param stats The DescriptiveStatistics instance to be assigned to the stats variable
     */
    public void setStats(DescriptiveStatistics stats) { this.stats = stats; }

    /**
     * This is the method to find the minimum of the given ArrayList
     *
     * @return The minimum value of the given ArrayList
     */
    public double findMin() { return stats.getMin(); }

    /**
     * This is the method to find the maximum of the given ArrayList
     *
     * @return The maximum value of the given ArrayList
     */
    public double findMax()
    {
        return stats.getMax();
    }

    /**
     * This is the method to find the mean of the given ArrayList
     *
     * @return The mean value of the given ArrayList
     */
    public double findMean()
    {
        return stats.getMean();
    }

    /**
     * This is the method to find the median of the given ArrayList
     *
     * @return The median value of the given ArrayList
     */
    public double findMedian()
    {
        return  stats.getPercentile(50);
    }

    /**
     * This is the method to find the standard deviation of the given ArrayList
     *
     * @return The standard deviation value of the given ArrayList
     */
    public double findStd()
    {
        return  stats.getStandardDeviation();
    }
}

