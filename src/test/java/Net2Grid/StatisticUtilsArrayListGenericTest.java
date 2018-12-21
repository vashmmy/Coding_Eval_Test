package Net2Grid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a unit test set for the StatisticUtilArrayListGeneric class.
 *
 * @author Angelos Vasileiadis
 * @version 1.00, Date: 21.12.2018
 */
public class StatisticUtilsArrayListGenericTest {

    // Declaring auxiliary variables to be used
    private ArrayList<Double> inputDataDouble;
    private ArrayList<Integer> inputDataInteger;
    private ArrayList<Float> inputDataFloat;
    private ArrayList<Long> inputDataLong;
    private StatisticUtilsArrayListGeneric myClassDouble;
    private StatisticUtilsArrayListGeneric myClassInteger;
    private StatisticUtilsArrayListGeneric myClassFloat;
    private StatisticUtilsArrayListGeneric myClassLong;
    private static final double tolerance = 10E-10;

    /**
     * This method is executed once before the tests, initializing the auxiliary variables with the proper values needed
     * for the testing procedure.
     */
    @Before
    public void setUp() throws Exception{

        // Initializing 4 different data-type arraylist, to test all cases
        inputDataDouble = new ArrayList<>();
        inputDataInteger = new ArrayList<>();
        inputDataFloat = new ArrayList<>();
        inputDataLong = new ArrayList<>();

        // Filling the the arraylists which will act as arguments of the class
        for (int i = 1 ; i < 11 ; i++){
            inputDataDouble.add((double) i );
            inputDataInteger.add( i );
            inputDataFloat.add((float) i );
            inputDataLong.add((long) i );
        }

        // Initializing 4 different instances of the class, for different data-type input
        myClassDouble = new StatisticUtilsArrayListGeneric(inputDataDouble);
        myClassInteger = new StatisticUtilsArrayListGeneric(inputDataInteger);
        myClassFloat= new StatisticUtilsArrayListGeneric(inputDataFloat);
        myClassLong = new StatisticUtilsArrayListGeneric(inputDataLong);
    }

    /**
     * This method is used for testing the setter method for the inputData variable of StatisticUtilArrayListGeneric class.
     */
    @Test
    public void setInputData() {

        // First check that the result of the getter and the newly created arraylists tempResults, are not the same
        ArrayList<Double> tempResultDouble = new ArrayList<>();
        ArrayList<Integer> tempResultInteger = new ArrayList<>();
        ArrayList<Float> tempResultFloat = new ArrayList<>();
        ArrayList<Long> tempResultLong = new ArrayList<>();

        tempResultDouble.add(1.0);tempResultDouble.add(2.0);tempResultDouble.add(3.0);tempResultDouble.add(4.0);tempResultDouble.add(5.0);
        tempResultInteger.add(1);tempResultInteger.add(2);tempResultInteger.add(3);tempResultInteger.add(4);tempResultInteger.add(5);
        tempResultFloat.add(1.0f);tempResultFloat.add(2.0f);tempResultFloat.add(3.0f);tempResultFloat.add(4.0f);tempResultFloat.add(5.0f);
        tempResultLong.add(1L);tempResultLong.add(2L);tempResultLong.add(3L);tempResultLong.add(4L);tempResultLong.add(5L);

        assertNotEquals(tempResultDouble, myClassDouble.getInputData());
        assertNotEquals(tempResultInteger, myClassInteger.getInputData());
        assertNotEquals(tempResultFloat, myClassFloat.getInputData());
        assertNotEquals(tempResultLong, myClassLong.getInputData());

        // Call the setter to refresh the stats variable with the new arraylist argument
        myClassDouble.setInputData(tempResultDouble);
        myClassInteger.setInputData(tempResultInteger);
        myClassFloat.setInputData(tempResultFloat);
        myClassLong.setInputData(tempResultLong);


        // Check that the new inputData variable was succesfully returned. Can safely assume that the setter method works correctly
        assertEquals(tempResultDouble, myClassDouble.getInputData());
        assertEquals(tempResultInteger, myClassInteger.getInputData());
        assertEquals(tempResultFloat, myClassFloat.getInputData());
        assertEquals(tempResultLong, myClassLong.getInputData());

    }

    /**
     * This method is used for testing the getter method for the inputData variable of StatisticUtilArrayListGeneric class.
     */
    @Test
    public void getInputData() {

        // We expect the result of the getter and the inpuData's value to be equal, cause myClass instance was created with the same arraylist.
        assertEquals(inputDataDouble, myClassDouble.getInputData());
        assertEquals(inputDataInteger, myClassInteger.getInputData());
        assertEquals(inputDataFloat, myClassFloat.getInputData());
        assertEquals(inputDataLong, myClassLong.getInputData());
    }

    /**
     * This method is used for testing the findMin method of the StatisticUtilArrayListGeneric class.
     */
    @Test
    public void findMin() {
        assertEquals(1, myClassDouble.findMin());
        assertEquals(1, myClassInteger.findMin());
        assertEquals(1, myClassFloat.findMin());
        assertEquals(1, myClassLong.findMin());
    }

    /**
     * This method is used for testing the findMax method of the StatisticUtilArrayListGeneric class.
     */
    @Test
    public void findMax() {
        assertEquals(10, myClassDouble.findMax());
        assertEquals(10, myClassInteger.findMax());
        assertEquals(10, myClassFloat.findMax());
        assertEquals(10, myClassLong.findMax());
    }

    /**
     * This method is used for testing the findMean method of the StatisticUtilArrayListGeneric class.
     */
    @Test
    public void findMean() {
        assertEquals(5.5, myClassDouble.findMean());
        assertEquals(5.5, myClassInteger.findMean());
        assertEquals(5.5, myClassFloat.findMean());
        assertEquals(5.5, myClassLong.findMean());
    }

    /**
     * This method is used for testing the findMedian method of the StatisticUtilArrayListGeneric class.
     */
    @Test
    public void findMedian() {
        assertEquals(5.5, myClassDouble.findMedian());
        assertEquals(5.5, myClassInteger.findMedian());
        assertEquals(5.5, myClassFloat.findMedian());
        assertEquals(5.5, myClassLong.findMedian());
    }

    /**
     * This method is used for testing the findStandardDeviation method of the StatisticUtilArrayListGeneric class.
     */
    @Test
    public void findStandardDeviation() {
        assertEquals(3.027650354097, myClassDouble.findStandardDeviation(), tolerance);
        assertEquals(3.027650354097, myClassInteger.findStandardDeviation(), tolerance);
        assertEquals(3.027650354097, myClassFloat.findStandardDeviation(), tolerance);
        assertEquals(3.027650354097, myClassLong.findStandardDeviation(), tolerance);
    }

    /**
     * This method is used for testing the behaviour of the StatisticUtilArrayListGeneric class in case a void arraylist is given as an input.
     * Should throw IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void ifVoidInputIsGivenThrowException() {
        StatisticUtilsArrayListGeneric myClassVoid = new StatisticUtilsArrayListGeneric(new ArrayList<>());
    }

    /**
     * This method is used for testing the getter method for the inputData variable of StatisticUtilArrayListGeneric class.
     * Should throw NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void getInputDataWhenInputIsVoid() {
        StatisticUtilsArrayListGeneric myClassGetInputDataWhenInputIsVoid = new StatisticUtilsArrayListGeneric();
        myClassGetInputDataWhenInputIsVoid.getInputData();
    }

    /**This method is used to assign null to all variables that were declared in the setUp() method.
     *
     * @throws Exception if it is not properly deleted.
     */
    @After
    public void tearDown() throws Exception{
        inputDataDouble = null;
        inputDataInteger = null;
        inputDataFloat = null;
        inputDataLong = null;
        myClassDouble = null;
        myClassFloat = null;
        myClassInteger = null;
        myClassLong = null;
    }
}