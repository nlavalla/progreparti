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
	static SemaphoreGeneral sem = new SemaphoreGeneral(2);
    UnMobile(int telleLargeur, int telleHauteur)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;	
	setSize(telleLargeur, telleHauteur);
    }

    public void run()
    {
    activite=true;
    while(true){
    	for (; sonDebDessin < (saLargeur - sonCote) / 3; sonDebDessin += sonPas)
		{
			repaint();
			try{
				Thread.sleep(sonTemps);
			}
			catch (InterruptedException telleExcp)
			{
				telleExcp.printStackTrace();
			}
		}

		sem.Wait();		
		for (; sonDebDessin < 2 * (saLargeur - sonCote) / 3; sonDebDessin += sonPas)
		{
			repaint();
			try{
				Thread.sleep(sonTemps);
			}
			catch (InterruptedException telleExcp)
			{
				telleExcp.printStackTrace();
			}
		}
		sem.Signal();

		for (; sonDebDessin < (saLargeur - 2*sonCote); sonDebDessin += sonPas)
		{
			repaint();
			try{
				Thread.sleep(sonTemps);
			}
			catch (InterruptedException telleExcp)
			{
				telleExcp.printStackTrace();
			}
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