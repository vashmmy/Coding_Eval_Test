package Net2Grid;

import java.util.ArrayList;

/**
 * This class is used as the implementation of the ascending minimum algorithm. For documentation about the algorithm,
 * visit the following link <url>https://softwarelearner.blogspot.com/2011/04/minima-in-sliding-window.html</url>.
 *
 * @author Angelos Vasileiadis
 * @version 1.00, Date: 18.12.2018
 */
public class AscendingMinima {

    /**
     * This variable is used for storing any new value that we want to import to the initial array.
     */
    private Double newValue;

    /**
     * This variable is a list of Doubles, that stores the initial array (for whom we want to compute the ascending minima array).
     */
    private ArrayList<Double> myData;

    /**
     * This variable is an auxiliary list of Integers, that stores the indexes of the elements of myData List. Each new import to myData List,
     * adds a respectively incremented index value which is stored in myIndexes.
     */
    private ArrayList<Integer> myIndexes;

    /**
     * This variable is used to store the ascending minima ArrayList<Double>.
     */
    private ArrayList<Double> ama;

    /**
     * This variable is an auxiliary list of Integers, that stores the indexes of the ascendig minima array.
     */
    private ArrayList<Integer> ama_index;
    /**
     * This is the void constructor of the class. It is used for initialization purposes. If an instance is created
     * through this constructor, it it obsolete for setMyData() method to be called by the user in the future.
     */
    public AscendingMinima()
    {

        // Initialize the private variables
        myData = new ArrayList<>();
        myIndexes = new ArrayList<>();
        ama = new ArrayList<>();
        ama_index = new ArrayList<>();
    }

    /**
     * This is the constructor of the class, in case of input data as type of List<Double>.
     * @param inputData is the List<Double> to compute its ascending minima array.
     */
    public AscendingMinima(ArrayList<Double> inputData)
    {

        // If the argument ArrayList is void, throw IllegalArgumentException
        if (inputData.size() == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        // Store inputData to myData and initialize the private variables
        myData = new ArrayList<>(inputData);
        myIndexes = new ArrayList<>();
        ama = new ArrayList<>();
        ama_index = new ArrayList<>();

        //fill myIndexes List with the proper indexes
        for (int i = 0 ; i < inputData.size() ; i++){
            myIndexes.add(i);
        }

        // Call the public method computeAscendingMinimaFirstTime()
        computeAscendingMinimaFistTime();
    }

    /**
     *  This is the constructor of the class. It is used to initiazize the private variable as well as to compute the ascending minima of the inputData.
     * @param inputData is the array to compute its asceding minima array.
     */
    public AscendingMinima(double[] inputData)
    {

        // If the argument ArrayList is void, throw IllegalArgumentException
        if (inputData.length == 0){
            throw new IllegalArgumentException("Input Array Is Void");
        }

        // Initialize the private variables
        myData = new ArrayList<>();
        myIndexes = new ArrayList<>();
        ama = new ArrayList<>();
        ama_index = new ArrayList<>();

        // Save double[] inputData as ArrayList<Double> mydata for better manipulation
        for (int i = 0 ; i < inputData.length; i++ ){ myData.add(inputData[i] ); myIndexes.add(i);}

        // Call the public method computeAscendingMinimaFirstTime()
        computeAscendingMinimaFistTime();
    }

    /**
     * This method is used as a setter of newValue variable but also computes the new ascending minima array, after
     * the insertion of the newValue's value in the myData ArrayList.
     * @param newValue is the value to add to the initial array.
     */
    public void setNewValue(double newValue)
    {
            this.newValue = newValue;

            // Call the public method computeAscendingMinima() to compute the new ama array
            computeAscendingMinima();
    }

    /**
     * This is the setter method for myData List variable, in case the inputData is of type double[].
     * @param inputData is the input double[] to store to myDataArrayList.
     */
    public void setMyData(double[] inputData)
    {

        // Delete all contents of myData that were stored in it so far
        myData.clear();

        // Save double[] inputData as ArrayList<Double> mydata for better manipulation
        for (int i = 0 ; i < inputData.length; i++ ){ myData.add(inputData[i] ); myIndexes.add(i);}

        // Call the public method computeAscendingMinimaFirstTime()
        computeAscendingMinimaFistTime();
    }

    /**
     ** This is the second setter method for myData List variable, in case the inputData is of type List<Double>.
     * @param inputData is the input List to store to myData ArrayList.
     */
    public void setMyData(ArrayList<Double> inputData)
    {
        this.myData = inputData;

        // Fill myIndexes List with the proper indexes
        for (int i = 0 ; i < myData.size() ; i++){
            myIndexes.add(i);
        }

        // Call the public method computeAscendingMinimaFirstTime()
        computeAscendingMinimaFistTime();
    }

    /**
     * This is the getter method for newValue variable.
     * @return the newValue variable.
     */
    public Double getNewValue() {
        return newValue;
    }

    /**
     * This is the getter method for myData List variable.
     * @return the myData variable.
     */
    public ArrayList<Double> getMyData() {
        return myData;
    }

    /**
     * This is the getter method for myIndexes List variable.
     * @return the myIndexes variable.
     */
    public ArrayList<Integer> getMyIndexes() {
        return myIndexes;
    }

    /**
     * This is the getter method of the variable List<Double> ama variable.
     * @return the variable ama, which holds the ascening minima arraylist.
     */
    public ArrayList<Double> getAma()
    {
        return ama;
    }

    /**
     * This is the getter method for ama_index List variable.
     * @return
     */
    public ArrayList<Integer> getAma_index() {
        return ama_index;
    }

    /**
     * This method is used to print out to the console the current content of ArrayList ama.
     */
    public void show_ama()
    {
        System.out.println("The current Ascending Minima Array is : "+ama);
        System.out.println("The current Ascending Minima Array Indexes are : "+ama_index);
    }

    /**
     * This method is used to compute the ascending minima array of a given array. It is called only once, through the constructor of the class.
     */
    public void computeAscendingMinimaFistTime()
    {

        /* This auxiliary variable stores the minimum value of the subarray under examination. It is of type double(not Double),
           for better manipulation of for and while loops. */
        double min = myData.get(0);

        /* This auxiliary variable stores the index of the minimum value of the subarray under examination. It is of type int(not Integer),
           for better manipulation of for and while loops. */
        int min_index = 0;

         // This is a counter variable.
        int i;

        // While the index of the last minimum value found does not point to the last+1 element of the array( aka the last subarray is not empty)
        while (min_index < myData.size())
        {

            // Scan myData ArrayList between the range (min_index,element] and store the minimum value in ama. Save its index as well in ama_index.
            for (i = min_index + 1; i < myData.size(); i++)
            {
                if (myData.get(i) <= min) {
                    min = myData.get(i);
                    min_index = i;
                }
            }
            ama.add(min);
            ama_index.add(min_index);

            // Check marginal case. If min_index points the last value of myData array, break the while loop(we dont need to check another submatrix, we reached the end)
            if (min_index == myData.size() - 1) {
                min_index++;
                break;
            }

            // Now min is the first element of the next subarray to be checked. min_index is also properly updated
            min = myData.get(++min_index);
        }
    }

    /**
     * This method is used to compute the ascending minima array if a newValue variable is inserted into the initial array.
     */
    public void computeAscendingMinima()
    {

        /* If the element that you discard is the first element in the ascending minima and their indexes match
           get rid of that element from the ascending minima. */
        if ( ( ama.get(0)== myData.get(0) ) && ( ama_index.get(0) == myIndexes.get(0) ) ){
            ama.remove(0);
            ama_index.remove(0);
        }

        /* Search from the end of the ascending minima discarding all elements that are >= newValue .
           If you find a element < Value, stop and add the newValue into ama. Update its corresponding index matrix(ama_index). */
        for (int i = ama.size()-1; i >= 0 ; i--){
            if (ama.get(i) >= newValue ){
                ama.remove(i);
                ama_index.remove(i);
            }else {
                ama.add(newValue);
                ama_index.add(myIndexes.get(myIndexes.size()-1) +1 );
                break;
            }
        }

        /* The following line of code will be executed only in the marginal case where all elements of ama were bigger
           than newValue. Then, the ama array was left empty, and we only insert the newValue with its index
           (the value of the last element of myIndexes arraylist). */
        if (ama.isEmpty()){
            ama.add(newValue);
            ama_index.add(myIndexes.get(myIndexes.size()-1) +1 );
        }

        // Discard the first one value of myData and myIndexes Arraylist and update the values and indexes by shifting left all values by one.
        for (int i = 0; i < myData.size()-1 ; i++){
            myData.set(i,myData.get(i+1));
            myIndexes.set(i,myIndexes.get(i+1));
        }

        // Insert the newValue and its index into myData and myIndexes arraylists.
        myData.set(myData.size()-1, newValue);
        myIndexes.set(myIndexes.size()-1, myIndexes.get(myIndexes.size()-1) +1 );
    }
}

