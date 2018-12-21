# Coding Evaluation Test

Author : Vasileiadis Angelos</br>
Version : 1.2 </br>
Date : 21.12.2018  


The *Evaluation Coding Test* is aimed at giving the supervisors the ability to understand an employee's IntelliJ, Git and Maven Infrastructure handling,his coding skills as well as his algorithmic way of thinking.

The project was developed through the [*Maven*](https://maven.apache.org/ "Maven's Homepage") software management tool and was completed in [*Java*](https://www.oracle.com/java/ "Java's Homepage") programming language. The testing procedure was executed through [*JUnit*](https://junit.org/junit5/ "JUnit's Homepage") test framework and maven [*Surefire*](https://maven.apache.org/surefire/maven-surefire-plugin/ "Surefire's Homepage") plugin. The code files are **fully documented, Javadoc and fully tested**. </br>The *Evaluation Coding Test* consists of six classes, as well as their corresponding test classes. </br>The main classes are the following: 

* *StatisticUtilsArray* : The implementation of this class allows the retrieval of some basic statistical features of a given **array**. The data type of the array is **double**. 

* *StatisticUtilsArrayList* : The implementation of this class allows the retrieval of some basic statistical features of a given **ArrayList**. The data type of the ArrayList is **Double**. 

* *StatisticUtilArrayJS* : The implementation of this class allows the retrieval of some basic statistical features of a given **array**, **using Java Streams**. The data type of the array is **double**. 

* *StatisticUtilArrayListJS* : The implementation of this class allows the retrieval of some basic statistical features of a given **ArrayList**, **using Java Streams**. The data type of the array is **Double**.

* *StatisticUtilsArrayListGeneric* : The implementation of this class allows the retrieval of some basic statistical features of a given **ArrayList**. This class uses **Generic Types** and **Java Streams API**. As a result this class can handle **all** numerical data types. 

* *AscendingMinima* : The implementation of this class allows the computation of the *ascending minima* array of a given initial *array* or *ArrayList*, as it is defined from the [***Ascending Minimum Algorithm***](http://richardhartersworld.com/cri/2001/slidingmin.html). The data dype of the *array* is **double** and of the *ArrayList* is **Double**. The class also implements the ability to insert a new number into the initial array and compute the new *ascending minima* array. 

The basic statistical features mentioned above are the following:

   1. Minumum Value
   2. Maximum Value
   3. Median Value
   4. Mean Value
   5. Standard Deviation Value

The main classes can be found [here](https://github.com/vashmmy/Coding_Eval_Test/tree/master/src/main/java/Net2Grid) </br>
The test classes can be found [here](https://github.com/vashmmy/Coding_Eval_Test/tree/master/src/test/java/Net2Grid)

## Updates
### 20.12.2018 

*StatisticUtilArrayJS* was added.

### 21.12.2018

*StatisticUtilArrayListJS* and *StatisticalUtilArrayListGeneric* classes were added.