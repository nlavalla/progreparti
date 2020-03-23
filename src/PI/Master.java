package PI;
	import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
	import java.util.concurrent.Callable;
	import java.util.concurrent.ExecutionException;
	import java.util.concurrent.ExecutorService;
	import java.util.concurrent.Executors;
	import java.util.concurrent.Future;

	

	/**
	 * Creates workers to run the Monte Carlo simulation
	 * and aggregates the results.
	 */
	class Master {
	  public void doRun(int totalCount, int numWorkers) throws InterruptedException, ExecutionException 
	  {
		  
		  long startTime =System.currentTimeMillis();
	    // Create a collection of tasks
	    List<Callable<Long>> tasks = new ArrayList<Callable<Long>>();
	    for (int i = 0; i < numWorkers; ++i) 
	    {
	      tasks.add(new Worker(totalCount));
	    }
	    
	    // Run them and receive a collection of Futures
	    ExecutorService exec = Executors.newFixedThreadPool(numWorkers);
	    List<Future<Long>> results = exec.invokeAll(tasks);
	    long total = 0;
	    
	    // Assemble the results.
	    for (Future<Long> f : results)
	    {
	      // Call to get() is an implicit barrier.  This will block
	      // until result from corresponding worker is ready.
	      total += f.get();
	    }
	    double pi = 4.0 * total / totalCount / numWorkers;
		  long stopTime =System.currentTimeMillis();
	    System.out.println("\n Pi : " + pi);
	    System.out.println("Error : " + Math.abs((pi-Math.PI)/Math.PI)+"\n");
	    System.out.println("Ntot  : " + totalCount*numWorkers+"\n");
	    System.out.println("Avaliable processors  : " + numWorkers+"\n");
	    System.out.println("Time Duration(ms)  : " + (stopTime-startTime)+"\n");
	  
	        
	        
	    

	    exec.shutdown();
	  }
	}


	



