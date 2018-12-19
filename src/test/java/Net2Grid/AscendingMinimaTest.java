package Net2Grid;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a unit test set for the AscendingMinima class.
 *
 * @author Angelos Vasileiadis
 * @version 1.00, Date: 18.12.2018
 */
public class AscendingMinimaTest
{

    //Declaring auxiliary variables to be used
    private double[] initializationArray;
    private ArrayList<Double> initializationArrayList;
    private AscendingMinima myClassArrayInput;
    private AscendingMinima myClassArrayListInput;
    private double[] testArray;
    private ArrayList<Double> testArrayList;
    private ArrayList<Double> testAma;
    private ArrayList<Integer> testAma_index;
    private final double tolerance = 10E-10;

    /**
     * This method is executed once before the tests, initializing the auxiliary variables with the proper values needed
     * for the testing procedure.
     */
    @Before
    public void setUp()
    {

        /* The initializatonArray and initializationArrayList contain the same values, in different data types. In most test methods,
           we check that objects instanciated by each of them work right. They are used as arguments to instanciate two objects. */
        initializationArray = new double[]{9,1,1,3,4,2,6,8,9};
        initializationArrayList = new ArrayList<>(); for(double element: initializationArray){ initializationArrayList.add(element); }

        /* The auxiliary variables testArray and testArrayList are used as "control" array and arraylist.
           They contain the same values. Knowing their contents and their expected outputs, we can check
           whether the methods's responses are correct or not. */
        testArray= new double[]{1,2,3,4,5,6,7,8,9};
        testArrayList = new ArrayList<>(); for(double element: testArray){ testArrayList.add(element); }

        // For the given initializationArray, we know the ama should contain the values below.
        testAma = new ArrayList<>();testAma.add(1.0);testAma.add(2.0);testAma.add(6.0);testAma.add(8.0);testAma.add(9.0);

        // For the given initializationArray, we know the ama_index should contain the values below.
        testAma_index = new ArrayList<>();testAma_index.add(2);testAma_index.add(5);testAma_index.add(6);testAma_index.add(7);testAma_index.add(8);

        // The object myClassArrayInput is instanciated given as constructor argument an array
        myClassArrayInput = new AscendingMinima(initializationArray);

        // The object myClassArrayInputList is instanciated given as constructor argument an ArrayList<Double>
        myClassArrayListInput =new AscendingMinima(initializationArrayList);
    }

    /**
     * This method is used for testing the setter method for the newValue variable of AscendingMinima class,
     * We assume that getNewValue() method works right.
     */
    @Test
    public void setNewValue()
    {

        // Auxiliary dummy variable
        double tempValue = 10.0;

        // Firstly test myClassArrayInput instance
        myClassArrayInput.setNewValue(tempValue);
        assertEquals(myClassArrayInput.getNewValue(), tempValue, tolerance);

        // Secondly test myClassArrayListInput instance
        myClassArrayListInput.setNewValue(tempValue);
        assertEquals(myClassArrayListInput.getNewValue(), tempValue, tolerance);
    }

    /**
     * This method is used for testing the setter method for the myData variable of AscendingMinima class,
     * with a double[] array as argument.
     * We assume that getMyData() method works right.
     */
    @Test
    public void setMyDataDoubleInput()
    {

        // Convert testArray to Object array in order to be able to assert later
        Double[] tempArray = ArrayUtils.toObject(testArray);

        // Firstly test myClassArrayInput instance
        myClassArrayInput.setMyData(testArray);
        assertArrayEquals(myClassArrayInput.getMyData().toArray(), tempArray);

        // Secondly test myClassArrayListInput instance
        myClassArrayListInput.setMyData(testArray);
        assertArrayEquals(myClassArrayListInput.getMyData().toArray(), tempArray);
    }
    /**
     * This method is used for testing the setter method for the myData variable of AscendingMinima class,
     * with an ArrayList<Double> as argument.
     * We assume that getMyData() method works right.
     */
    @Test
    public void setMyDataArrayListInput()
    {

        // Firstly test myClassArrayInput instance
        myClassArrayInput.setMyData(testArrayList);
        assertEquals(myClassArrayInput.getMyData(), testArrayList);

        // Secondly test myClassArrayLintInput instance
        myClassArrayListInput.setMyData(testArrayList);
        assertEquals(myClassArrayListInput.getMyData(), testArrayList);
    }

    /**
     * This method is used for testing the getter method for the newValue variable of AscendingMinima class.
     * We assume that setNewValue() method works right.
     */
    @Test
    public void getNewValue()
    {

        // Auxiliary dummy variable
        double tempValue = 10.0;

        // Firstly test myClassArrayInput instance
        myClassArrayInput.setNewValue(tempValue);
        assertEquals(myClassArrayInput.getNewValue(), tempValue, tolerance);

        // Secondly test myClassArrayListInput instance
        myClassArrayListInput.setNewValue(tempValue);
        assertEquals(myClassArrayListInput.getNewValue(), tempValue, tolerance);
    }

    /**
     * This method is used for testing the setter method for the myData variable of AscendingMinima class.
     */
    @Test
    public void getMyData()
    {

        /* We check if the returned arraylist is equal to the same arraylist that was used during the initilization
           of the myClassArrayInput and myClassArrayListInput instances */

        // Firstly test myClassArrayInput instance
        assertEquals(myClassArrayInput.getMyData(), initializationArrayList);

        // Secondly test myClassArrayLintInput instance
        assertEquals(myClassArrayListInput.getMyData(), initializationArrayList);
    }

    /**
     * This method is used for testing the getter method for the myIndexes variable of AscendingMinima class.
     */
    @Test
    public void getMyIndexes()
    {

        // Create the ArrayList<Integer> tempIndexList, which will act as the "control" arraylist.
        ArrayList<Integer> tempIndexList = new ArrayList<>();
        for (int i = 0 ; i < myClassArrayInput.getMyData().size(); i++ ){ tempIndexList.add(i);}

        // Firstly test myClassArrayInput instance
        assertEquals(myClassArrayInput.getMyIndexes(), tempIndexList);

        // Secondly test myClassArrayLintInput instance
        assertEquals(myClassArrayListInput.getMyIndexes(), tempIndexList);
    }

    /**
     * This method is used for testing the getter method for the ama variable of AscendingMinima class.
     */
    @Test
    public void getAma()
    {

        // Firstly test myClassArrayInput instance
        assertEquals(myClassArrayInput.getAma(), testAma);

        // Secondly test myClassArrayListInput instance
        assertEquals(myClassArrayListInput.getAma(), testAma);
    }

    /**
     * This method is used for testing the getter method for the ama_index variable of AscendingMinima class.
     */
    @Test
    public void getAma_index()
    {

        // Firstly test myClassArrayInput instance
        assertEquals(myClassArrayInput.getAma_index(), testAma_index);

        // Secondly test myClassArrayListInput instance
        assertEquals(myClassArrayListInput.getAma_index(), testAma_index);
    }

    /**
     * This method is used for testing the behaviour of the AscendingMinima class in case a void array is given as an input.
     * Should throw IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void ifVoidInputIsGivenThrowException()
    {
        AscendingMinima myClassVoid = new AscendingMinima(new double[]{});
    }

    /**
     * This method is used for testing the behaviour of the AscendingMinima class in case a void array is given as an input.
     * Should throw NullPointerException.
     */
    @Test(expected = NullPointerException.class)
    public void ifNullInputIsGivenThrowException()
    {
        double[] nullInput = null;
        AscendingMinima myClassNull = new AscendingMinima(nullInput);
    }

    /**
     * This method is used for testing the computeAscendingMinimaFirst()Time method of AscendingMinima class.
     */
    @Test
    public void computeAscendingMinimaFistTime()
    {

        /* To check if computeAscendingMinimaFirstTime is functioning right, we just need to call getAma() after
           initializing with a known array and assertingEqual with a its corresponind ama array */

        // Firstly test myClassArrayInput instance
        assertEquals(myClassArrayInput.getAma(), testAma);

        // Secondly test myClassArrayListInput instance
        assertEquals(myClassArrayListInput.getAma(), testAma);
    }

    /**
     * This method is used for testing the computeAscendingMinima() method of AscendingMinima class.
     */
    @Test
    public void computeAscendingMinima()
    {

        /* To check if if computeAscendingMinima() is functioning right, we need to call getAma() after initialing with
           a known array, calling setNewValue and getAma(), and assertingEqual with is its correct corresponding ama array,
           which is already known */

        // Create the value to be imported to the initial array
        double newValue = 6.0;

        // Create the correct final ama arraylist that should be expected
        ArrayList<Double> shouldBeThisAma = new ArrayList<>(){}; shouldBeThisAma.add(1.0); shouldBeThisAma.add(2.0); shouldBeThisAma.add(6.0);

        // Firstly test myClassArrayInput instance
        myClassArrayInput.setNewValue(newValue);
        assertEquals(myClassArrayInput.getAma(), shouldBeThisAma);

        // Secondly test myClassArrayListInput instance
        myClassArrayListInput.setNewValue(newValue);
        assertEquals(myClassArrayListInput.getAma(), shouldBeThisAma);
    }

    /**This method is used to assign null to all variables that were declare in the setUp() method.
     *
     * @throws Exception if it is not properly deleted.
     */
    @After
    public void tearDown()
    {
        initializationArray = null;
        initializationArrayList = null;
        testArray = null;
        testArrayList = null;
        testAma = null;
        testAma_index = null;
        myClassArrayInput = null;
        myClassArrayListInput = null;
    }
}