package Net2Grid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a unit test set for the StatisticUtilArrayJS class.
 *
 * @author Angelos Vasileiadis
 * @version 1.00, Date: 20.12.2018
 */
public class StatisticUtilsArrayJSTest {

    // Declaring auxiliary variables to be used
    private double[]inputData;
    StatisticUtilsArrayJS myClass;
    private static final double tolerance = 10E-10;

    /**
     * This method is executed once before the tests, initializing the auxiliary variables with the proper values needed
     * for the testing procedure.
     */
    @Before
    public void setUp(){
        inputData = new double[]{1,2,3,4,5,6,7,8,9,10};
        myClass = new StatisticUtilsArrayJS(inputData);
    }

     /**
     * This method is used for testing the setter method for the inputData variable of StatisticUtilsArrayJS class.
     */
    @Test
    public void setInputData() {

        // First check that the result of the getter and the newly created array tempResult are not the same
        double[] tempResult = new double[]{1,2,3,4,5};
        assertNotEquals(tempResult, myClass.getInputData());

        // Call the setter to refresh the stats variable with the new array argument
        myClass.setInputData(tempResult);

        // Check that the new inputData variable was succesfully returned. Can safely assume that the setter method works correctly
        assertArrayEquals(tempResult, myClass.getInputData());
    }

    /**
     * This method is used for testing the setter method for the stats variable of StatisticUtilsArrayJS class.
     */
    @Test
    public void getInputData() {

        // We expect the result of the getter and the new array to be equal, cause myClass instance was created with the same array.
        assertArrayEquals(inputData, myClass.getInputData());
    }

    /**
     * This method is used for testing the findMin method of the StatisticUtilsArrayJS class.
     */
    @Test
    public void findMin() {
        assertEquals( 1, myClass.findMin());
    }

    /**
     * This method is used for testing the findMax method of the StatisticUtilsArrayJS class.
     */
    @Test
    public void findMax() {
        assertEquals(10,myClass.findMax());
    }

    /**
     * This method is used for testing the findMean method of the StatisticUtilsArrayJS class.
     */
    @Test
    public void findMean() {
        assertEquals(5.5, myClass.findMean());
    }

    /**
     * This method is used for testing the findMedian method of the StatisticUtilsArrayJS class.
     */
    @Test
    public void findMedian() {
        assertEquals( 5.5,myClass.findMedian());
    }

    /**
     * This method is used for testing the findStandardDeviation method of the StatisticUtilsArrayJS class.
     */
    @Test
    public void findStandardDeviation() {
        assertEquals( 3.027650354097, myClass.findStandardDeviation() , tolerance);
    }

    /**
     * This method is used for testing the behaviour of the StatisticUtilsArrayJS class in case a void array is given as an input.
     * Should throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void ifVoidInputIsGivenThrowException()
    {
        StatisticUtilsArrayJS myClassVoid = new StatisticUtilsArrayJS(new double[]{});
    }

    /**
     * This method is used for testing the getter method for the inputData variable of StatisticUtilsArray class.
     * Should throw NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void getInputDataWhenInputIsVoid()
    {
        StatisticUtilsArrayJS myClassGetInputDataWhenInputIsVoid = new StatisticUtilsArrayJS();
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