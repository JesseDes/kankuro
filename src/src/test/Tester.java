package test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * 
 * @author Jesse Desmrais
 * Static class that can run and manage unit tests.
 */

public class Tester {

    /**
    * {@inheritDoc}

    * Will crawl through the test package and run all the tests it finds.
    * @return true if all tests pass, and false if a there is a failure.
    */
	public static boolean runAllTests()
	{
		//We do not know the amount of files ahead of time therefore we store in an arraylist
    	ArrayList<Class> testList = new ArrayList<Class>();
    	
    	//Crawls through the test package
    	try (Stream<Path> paths = Files.walk(Paths.get("src/test/"))) {
    	    paths
    	        .filter(Files::isRegularFile)
    	        .forEach((k) -> { 
    	        	 try {
    	        		 //for each file in tester if it is not Tester.java remove the ".java" and find the class that matches the name and add it to the array list
    	        		 if(!k.getFileName().toString().contains("Tester.java"))
    	        			 testList.add(Class.forName("test."+k.getFileName().toString().substring(0, k.getFileName().toString().lastIndexOf("."))));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
    	        });
    	} catch (IOException e) {
			e.printStackTrace();
		} 	
    	
    	//Convert array list to array Java cannot cast Objects as class therefore it must be done manually
    	
    	Class[] testArray = new Class[testList.size()];
    	
    	for(int i =0 ; i < testList.size();i++)
    		testArray[i] = testList.get(i);
    	
    	return runTests(testArray);
    	    	
	}
	
	
    /**
    * {@inheritDoc}
    * <p>
    * Runs all tests provided to the function
    * @param classList: An array of test Class objects
    * @return true if all tests pass and false if there is a single failure
    */	
	public static boolean runTests(Class[] classList)
	{
		JUnitCore junit = new JUnitCore();
    	junit.addListener(new TextListener(System.out));
    	
		Result result = junit.run(classList);
    	
    	return resultReport(result);
	}

    /**
    * {@inheritDoc}
    * <p>
    * outputs the data from a tests Result object
    * @param Result result: A Test's Result Object.
    * @return true if all tests pass and false if there is a single failure
    */	
	public static boolean resultReport(Result result) {
	    System.out.println("Finished. Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms.");
	    
	    return result.getFailureCount() == 0;
	}
}
