package TP1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import TP1.Semaphore;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;
	boolean activite;
    SemaphoreGeneral sem ;

    UnMobile(int telleLargeur, int telleHauteur, SemaphoreGeneral sem)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	sem=this.sem;
	
	setSize(telleLargeur, telleHauteur);
    }

    public void run()
    {
    activite=true;
    while(true){
    int debSectionCritique=saLargeur/3;
    int finSectionCritique=(saLargeur/3)*2;
   
	for (sonDebDessin=0; sonDebDessin < debSectionCritique; sonDebDessin+= sonPas)
	    {
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
	sem.Wait();
	for (sonDebDessin=debSectionCritique; sonDebDessin <finSectionCritique ; sonDebDessin+= sonPas)
    {
	repaint();
	try{Thread.sleep(sonTemps);}
	catch (InterruptedException telleExcp)
	    {telleExcp.printStackTrace();}
    }
	 sem.Signal();
	for (; sonDebDessin < saLargeur - sonPas; sonDebDessin+= sonPas)
    {
	repaint();
	try{Thread.sleep(sonTemps);}
	catch (InterruptedException telleExcp)
	    {telleExcp.printStackTrace();}
    }
	
	for (; sonDebDessin >0; sonDebDessin=sonDebDessin-sonPas)
    {
		/*if((sonDebDessin>(saLargeur/5)) && sonDebDessin<(saLargeur/5)*2)
			sem.syncWait();
		sem.syncSignal();*/
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
	    	{telleExcp.printStackTrace();}
    }
	
    }
    
	    }
    

    public void paintComponent(Graphics telCG)
    {
	super.paintComponent(telCG);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
    
    public boolean getActivite(){
    return activite;
    }
    public void setActivite(boolean act){
         activite=act;
        }
}