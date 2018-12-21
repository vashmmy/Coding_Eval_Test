package Net2Grid;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * This class is used as an auxiliary class, providing statistical metrics to the user, in the case of a given array of doubles
 * (double[] array). These metrics are: minimum, maximum, mean, median and standard deviation.
 *
 * @author Angelos Vasileiadis
 * @version 1.0, Date: 13.12.2018
 */
public class StatisticUtilsArray
{
    /**
     * This variable is responsible for storing the values of the given array of doubles, to an array of type double[].
     */
    private double[] inputData;

    /**
     * This variable is responsible for the computation of the metrics internally, given an array of doubles as input.
     */
    private DescriptiveStatistics stats;

    /**
     * This is the void constructor method of the class, used for initialization purposes.
     */
    public StatisticUtilsArray() { }

    /**
     * This is the main constructor method of the class, used for initialization purposes. It takes the given array of doubles as an
     * input, stores it the variable inputData and creates the variable stats.
     *
     * @param inputData The array  of the given data to compute the metrics.
     */
    public StatisticUtilsArray(double[] inputData)
    {

        // Store the argument into the variable input
        this.inputData = inputData;

        // Check if input is void
        if (inputData.length == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        // Get a DescriptiveStatistics instance
        stats = new DescriptiveStatistics(this.inputData);
    }

    /**
     * This is the getter method for the inputData variable.
     *
     * @return the inputData variable.
     */
    public double[] getInputData()
    {

        // In case of null inputData variable, throw NullPointerException.
        if (this.inputData == null){
            throw new NullPointerException("Input Array was Void. Cannot return inputData");
        }
        return inputData;
    }

    /**
     * This is the setter method for the inputData variable.
     *
     * @param inputData The double[] array to be assinged to inputData variable.
     */
    public void setInputData(double[] inputData) { this.inputData = inputData; }

    /**
     * This is the getter method for the stats variable.
     *
     * @return The stats variable instance.
     */
    public DescriptiveStatistics getStats()
    {

        // In case of null stats variable, throw NullPointerException
        if (this.inputData == null){
            throw new NullPointerException("Input Array was Void. Cannot return Stats instance");
        }
        return stats;
    }

    /**
     * This is the setter method for the stats variable.
     *
     * @param stats The DescriptiveStatistics instance to be assigned to the stats variable.
     */
    public void setStats(DescriptiveStatistics stats) { this.stats = stats; }

    /**
     * This is the method to find the minimum of the given array of doubles.
     *
     * @return The minimum value of the given array of doubles.
     */
    public double findMin()
    {
        return stats.getMin();
    }

    /**
     * This is the method to find the maximum of the given array of doubles.
     *
     * @return The maximum value of the given array of doubles.
     */
    public double findMax()
    {
        return stats.getMax();
    }

    /**
     * This is the method to find the mean of the given array of doubles.
     *
     * @return The mean value of the given array of doubles.
     */
    public double findMean()
    {
        return stats.getMean();
    }

    /**
     * This is the method to find the median of the given array of doubles.
     *
     * @return The median value of the given array of doubles.
     */
    public double findMedian()
    {
        return  stats.getPercentile(50);
    }

    /**
     * This is the method to find the standard deviation of the given array of doubles.
     *
     * @return The standard deviation value of the given array of doubles.
     */
    public double findStd()
    {
        return  stats.getStandardDeviation();
    }
}

