package TP2;

import TP2.Semaphore;


public final class SemaphoreBinaire extends Semaphore {
public SemaphoreBinaire(int valeurInitiale){
	super((valeurInitiale != 0) ? 1:0);
	//System.out.print(valeurInitiale);
}
public final synchronized void syncSignal(){
	System.out.print("\n je sors \n");
	System.out.print(valeur);
	super.syncSignal();
	
	if (valeur>1) valeur = 1;
	
}
public final synchronized void syncWait(){
	System.out.print("\n je rentre \n");
	System.out.print(valeur);
	super.syncWait();
	
}
}

