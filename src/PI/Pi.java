package PI;


/**
 * Approximates PI using the Monte Carlo method.  Demonstrates
 * use of Callables, Futures, and thread pools.
 */
public class Pi 
{
  public static void main(String[] args) throws Exception 
  {
    // 10 workers, 50000 iterations each
	  for (int i=1;i<16;i=i*2) {
		
		  new Master().doRun(i, 1600);
		
	}
	}
}



