package TP1;

public abstract class Semaphore {

    protected int valeur=0;

    protected Semaphore (int valeurInitiale){
	valeur = valeurInitiale>0 ? valeurInitiale:0;
    }

    public synchronized void Wait(){
	try {
	    while(valeur<=0){
		wait();
        }
	    valeur--;
	    
	} catch(InterruptedException e){}
    }

    public synchronized void Signal(){
	if(++valeur > 0) notifyAll();
    }
}
