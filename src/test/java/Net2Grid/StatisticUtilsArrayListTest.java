package Net2Grid;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.junit.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a unit test set for the StatisticUtilsArrayList class.
 *
 * @author Angelos Vasileiadis
 * @version 1.00, Date: 17.12.2018
 */
public class StatisticUtilsArrayListTest
{

    //Declaring auxiliary variables to be used
    private StatisticUtilsArrayList myClass;
    private StatisticUtilsArrayList myClassZero;
    private double result;
    private double resultZero;
    private static final double tolerance = 10E-10;

    /**
     * This method is executed once before the tests, initializing the auxiliary variables with the proper values needed
     * for the testing procedure.
     */
    @Before
    public void setUp() throws Exception
    {
        ArrayList<Double> myClassArrayList = new ArrayList<>();
        ArrayList<Double> myClassZeroArrayList = new ArrayList<>();
        for (int i = 1; i < 11 ; i++){
            myClassArrayList.add((double)i);
            myClassZeroArrayList.add((double)0);
        }
        myClass = new StatisticUtilsArrayList(myClassArrayList);
        myClassZero = new StatisticUtilsArrayList(myClassZeroArrayList);
    }

    /**
     * This method is used for testing the FindMin method of the class.
     */
    @Test
    public void findMin()
    {
        result = myClass.findMin();
        resultZero = myClassZero.findMin();
        assertEquals(1, result);
        assertEquals(0, resultZero);
    }

    /**
     * This method is used for testing the FindMax method of the class.
     */
    @Test
    public  void findMax()
    {
        result = myClass.findMax();
        resultZero = myClassZero.findMax();
        assertEquals(10,result);
        assertEquals(0, resultZero);
    }

    /**
     * This method is used for testing the FindMean method of the class.
     */
    @Test
    public void findMean()
    {
        result = myClass.findMean();
        resultZero = myClassZero.findMean();
        assertEquals(5.5,result);
        assertEquals(0, resultZero);
    }

    /**
     * This method is used for testing the FindMedian method of the class.
     */
    @Test
    public void findMedian()
    {
        result = myClass.findMedian();
        resultZero = myClassZero.findMedian();
        assertEquals(5.5, result);
        assertEquals(0, resultZero);
    }

    /**
     * This method is used for testing the FindStd method of the class.
     */
    @Test
    public void findStd()
    {
        result =myClass.findStd();
        resultZero = myClassZero.findStd();
        assertEquals(3.027650354097, result, tolerance);
        assertEquals(0, resultZero);
    }

    /**
     * This method is used for testing the behaviour of the StatisticUtilsArrayList class in case a void ArrayList<Double> is given as an input.
     * Should throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void ifVoidInputIsGivenThrowException()
    {
        StatisticUtilsArrayList myClassVoid = new StatisticUtilsArrayList(new ArrayList<>());

    }

    /**
     * This method is used for testing the behaviour of the StatisticUtilsArrayList class in case a void array is given as an input.
     * Should throw NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void ifNullInputIsGivenThrowException()
    {
        ArrayList<Double> nullInput = null;
        StatisticUtilsArrayList myClassNull = new StatisticUtilsArrayList(nullInput);
    }

    /**
     * This method is used for testing the getter method for the inputData variable of StatisticUtilsArrayList class.
     * Should throw NullPointerException
     */
    @Test(expected = NullPointerException.class)
    public void testGetInputDataWhenInputIsVoid()
    {
        StatisticUtilsArrayList myClassGetInputDataWhenInputIsVoid = new StatisticUtilsArrayList();
        myClassGetInputDataWhenInputIsVoid.getInputData();
    }

    /**
     * This method is used for testing the getter method for the getStats variable of StatisticUtilsArrayList class.
     * Should throw NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void testGetStatsWhenInputIsVoid()
    {
        StatisticUtilsArrayList myClassGetStatsWhenInputIsVoid = new StatisticUtilsArrayList();
        myClassGetStatsWhenInputIsVoid.getInputData();
    }

    /**
     * This method is used for testing the setter method for the inputData variable of StatisticUtilsArrayList class.
     */
    @Test
    public void setInputData()
    {

        // first check that the result of the getter and the newly created array tempResult are not the same
        double[] tempResult = new double[]{1,2,3,4,5};
        assertNotEquals(tempResult, myClass.getInputData());

        // call the setter to refresh the stats variable with the new array argument
        myClass.setInputData(tempResult);

        //check that the new inputData variable was succesfully returned. Can safely assume that the setter method works correctly
        assertArrayEquals(tempResult, myClass.getInputData());
    }

    /**
     * This method is used for testing the second setter method(overloaded method) for the inputData variable of StatisticUtilsArrayList class.
     */
    @Test
    public void setInputDataOverloaded()
    {
        /* first check that the result of the getter and the newly created array tempResult are not the same
           tempArray and tempArrayList have the same contents. */
        ArrayList<Double> tempArrayList = new ArrayList<>();
        tempArrayList.add((double)1); tempArrayList.add((double)2); tempArrayList.add((double)3); tempArrayList.add((double)4); tempArrayList.add((double)5);
        double[] tempArray = new double[5];
        for (int i=0;i<tempArrayList.size();i++){
            tempArray[i] = tempArrayList.get(i);
        }
        assertNotEquals(tempArray, myClass.getInputData());

        // call the setter to refresh the stats variable with the new ArrayList<Double> argument
        myClass.setInputData(tempArrayList);

        //check that the new inputData variable was succesfully returned. Can safely assume that the setter method works correctly
        assertArrayEquals(tempArray, myClass.getInputData());
    }

    /**
     * This method is used for testing the setter method for the stats variable of StatisticUtilsArrayList class.
     */
    @Test
    public void setStats()
    {

        // First check that the result of the getter and the newly created instance tempResult are not the same
        DescriptiveStatistics tempResult = new DescriptiveStatistics(new double[]{1,2,3,4,5});
        assertNotEquals(tempResult, myClass.getStats());

        // Call the setter to refresh the stats variable with the new argument
        myClass.setStats(tempResult);

        // Check that the new stats variable was succesfully returned. Can safely assume that the setter method works correctly
        assertEquals(tempResult, myClass.getStats());
    }

    /**
     * This method is used for testing the getter method for the inputData variable of StatisticUtilsArrayList class.
     */
    @Test
    public void getInputData()
    {

        /* We expect the result of the getter and the new array to be equal, cause myClass instance was created with the same array.
           tempArray and tempArrayList have the same contents. */
        ArrayList<Double> tempArrayList = new ArrayList<>();
        for (int i=1; i<11;i++){tempArrayList.add((double)i);}
        double[] tempArray = new double[10];
        for (int i=0;i<tempArrayList.size();i++){
            tempArray[i] = tempArrayList.get(i);
        }
        assertArrayEquals(tempArray, myClass.getInputData());
    }

    /**
     * This method is used for testing the setter method for the stats variable of StatisticUtilsArrayList class.
     */
    @Test
    public void getStats()
    {

        /* We create the an DescriptiveStatistics instance with the same argument as the myClass object
           knowing that StatisticUtilsArray internally creates a DescriptiveStatistics instance with the same args,
           and we expect the newly created instance's metrics to be equal to the instance's returned from the getter getStats() method metrics */
        DescriptiveStatistics tempResult = new DescriptiveStatistics(new double[]{1,2,3,4,5,6,7,8,9,10});
        assertEquals(tempResult.getMin(), myClass.getStats().getMin(), tolerance);
        assertEquals(tempResult.getMax(), myClass.getStats().getMax(), tolerance);
        assertEquals(tempResult.getMean(), myClass.getStats().getMean(), tolerance);
        assertEquals(tempResult.getPercentile(50), myClass.getStats().getPercentile(50), tolerance);
        assertEquals(tempResult.getStandardDeviation(), myClass.getStats().getStandardDeviation(), tolerance);
    }

    /**This method is used to assign null to all variables that were declare in the setUp() method.
     *
     * @throws Exception if it is not properly deleted.
     */
    @After
    public  void tearDown() throws Exception
    {
        myClass = null;
        myClassZero = null;
    }
}








