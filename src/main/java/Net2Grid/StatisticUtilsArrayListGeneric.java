package Net2Grid;

import java.util.ArrayList;

public class StatisticUtilsArrayListGeneric< N extends Number> {

    private ArrayList< N > inputData;

    public StatisticUtilsArrayListGeneric(){ }


    public StatisticUtilsArrayListGeneric(ArrayList < N > inputData){

        super();

        // If the argument ArrayList is void, throw IllegalArgumentException
        if (inputData.size() == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        this.inputData = inputData;
    }

    public void setInputData(ArrayList < N > inputArrayList){

        inputData = inputArrayList;
    }

    public ArrayList< N > getInputData(){

        // In case of null inputData variable, throw NullPointerException
        if (inputData == null){
            throw new NullPointerException("Input ArrayList is Null. Cannot Return inputData");
        }
        return inputData;
    }

    public double findMin(){
        return inputData.stream().mapToDouble(i->i.doubleValue()).summaryStatistics().getMin();
    }

    public double findMax(){
        return inputData.stream().mapToDouble(i->i.doubleValue()).summaryStatistics().getMax();
    }

    public double findMean(){
        return inputData.stream().mapToDouble(i->i.doubleValue()).summaryStatistics().getAverage();
    }

    public double findMedian(){

        /* Java Streams API does not offer the direct extraction of the standardDeviation. So we return the value manually.
           Sort the array to find the middle value */
        double[] sortedInputData = inputData.stream().mapToDouble(i->i.doubleValue()).sorted().toArray();

        /* If the length of the inputData array is even, return the mean of the two middle values,
           else find the middle value*/
        if (sortedInputData.length % 2 == 0 ){
            return (sortedInputData[(sortedInputData.length/2) - 1] + sortedInputData[(sortedInputData.length/2)]) / 2 ;
        }else{
            return sortedInputData[sortedInputData.length/2];
        }
    }

    public double findStandardDeviation(){

        /* Java Streams API does not offer the direct extraction of the standardDeviation. So we return the value manually.
           applying the standard deviation formulae */
        return  Math.sqrt(inputData.stream().mapToDouble(i -> Math.pow(i.doubleValue() - (inputData.stream().mapToDouble(j -> j.doubleValue()).summaryStatistics().getAverage()),2)).sum()/(inputData.size()-1));
    }
}
