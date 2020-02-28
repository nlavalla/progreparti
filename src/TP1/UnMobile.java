package TP1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;
	boolean activite;

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
	for (sonDebDessin=0; sonDebDessin < saLargeur - sonPas; sonDebDessin+= sonPas)
	    {
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
	
	for (sonDebDessin=490; sonDebDessin >0; sonDebDessin=sonDebDessin-sonPas)
    {
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