package Net2Grid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a unit test set for the StatisticUtilArrayListJS class.
 *
 * @author Angelos Vasileiadis
 * @version 1.00, Date: 21.12.2018
 */
public class StatisticUtilsArrayListJSTest {

    // Declaring auxiliary variables to be used
    private ArrayList<Double> inputData;
    private  StatisticUtilsArrayListJS myClass;
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

        // Instanciating inputData with known values to create an object
        inputData= new ArrayList<>();
        for (int i = 1; i < 11 ; i++){ inputData.add((double)i); }
        myClass = new StatisticUtilsArrayListJS(inputData);
    }

    /**
     * This method is used for testing the getter method for the inputData variable of StatisticUtilsArrayListJS class.
     */
    @Test
    public void getInputData() {

        // We expect the result of the getter and the inpuData's value to be equal, cause myClass instance was created with the same arraylist.
        assertEquals(inputData, myClass.getInputData());
    }

    /**
     * This method is used for testing the setter method for the inputData variable of StatisticUtilsArrayListJS class.
     */
    @Test
    public void setInputData() {

        // First check that the result of the getter and the newly created arraylist tempResult, are not the same
        ArrayList<Double> tempResult = new ArrayList<>();
        tempResult.add(1.0);
        tempResult.add(2.0);
        tempResult.add(3.0);
        tempResult.add(4.0);
        tempResult.add(5.0);
        assertNotEquals(tempResult, myClass.getInputData());

        // Call the setter to refresh the stats variable with the new arraylist argument
        myClass.setInputData(tempResult);

        // Check that the new inputData variable was succesfully returned. Can safely assume that the setter method works correctly
        assertEquals(tempResult, myClass.getInputData());
    }

    /**
     * This method is used for testing the findMin method of the StatisticUtilsArrayListJS class.
     */
    @Test
    public void findMin() { assertEquals( 1, myClass.findMin()); }

    /**
     * This method is used for testing the findMax method of the StatisticUtilsArrayListJS class.
     */
    @Test
    public void findMax() { assertEquals(10,myClass.findMax()); }

    /**
     * This method is used for testing the findMean method of the StatisticUtilsArrayListJS class.
     */
    @Test
    public void findMean() { assertEquals(5.5, myClass.findMean()); }

    /**
     * This method is used for testing the findMedian method of the StatisticUtilsArrayListJS class.
     */
    @Test
    public void findMedian() { assertEquals( 5.5,myClass.findMedian());}

    /**
     * This method is used for testing the findStandardDeviation method of the StatisticUtilsArrayListJS class.
     */
    @Test
    public void findStandardDeviation() { assertEquals( 3.027650354097, myClass.findStandardDeviation() , tolerance); }

    /**
     * This method is used for testing the behaviour of the StatisticUtilsArrayListJS class in case a void arraylist is given as an input.
     * Should throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void ifVoidInputIsGivenThrowException() {
        StatisticUtilsArrayListJS myClassVoid = new StatisticUtilsArrayListJS(new ArrayList< >());
    }

    /**
     * This method is used for testing the getter method for the inputData variable of StatisticUtilsArrayListJS class.
     * Should throw NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void getInputDataWhenInputIsVoid() {
        StatisticUtilsArrayListJS myClassGetInputDataWhenInputIsVoid = new StatisticUtilsArrayListJS();
        myClassGetInputDataWhenInputIsVoid.getInputData();
    }

    /**This method is used to assign null to all variables that were declared in the setUp() method.
     *
     * @throws Exception if it is not properly deleted.
     */
    @After
    public void tearDown() throws Exception{
        inputData = null;
        myClass = null;
    }

}