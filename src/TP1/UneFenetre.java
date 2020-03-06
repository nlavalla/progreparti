package TP1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener
{
    
   

    private final int LARG=500, HAUT=250;
    int NBRLIG=5;
    Thread laTache[];
    UnMobile lesMobiles[];
    JButton bouton[];
    SemaphoreGeneral sem = new SemaphoreGeneral(0);
    //JButton reprise =new JButton("reprise");
    
    
    
    public UneFenetre()
    {
    	super("Mobile");
    	/*sonMobile= new UnMobile(LARG,HAUT);
    	setContentPane(sonMobile);
    	
    	laTache1= new Thread(sonMobile);
    	laTache1.start();
    	sonarret1.addActionListener(this);
    	add(sonarret1);
    	reprise.addActionListener(this);
    	add(reprise);
    	*/
    	Container leConteneur = getContentPane();
    	leConteneur.setLayout (new GridLayout(NBRLIG, 2));
    	 laTache= new Thread[NBRLIG];
         lesMobiles=new UnMobile[NBRLIG];
         bouton=new JButton[NBRLIG];
    	for (int i=0; i<NBRLIG;i++){
    		lesMobiles[i]=new UnMobile(LARG,HAUT,sem);
    		leConteneur.add(lesMobiles[i]);
    		laTache[i]= new Thread(lesMobiles[i]);
    		bouton[i]=new JButton("M/A");
    		leConteneur.add(bouton[i]);
    		bouton[i].addActionListener(this);
    	}
    	
    	for (int i=0; i<NBRLIG;i++){
    		laTache[i].start();
    	}

    	setSize(1000,600);
		setVisible(true);
		setLocation(200,300);
	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread 
    }
    public void actionPerformed(ActionEvent parEvt) {
    	for (int i=0; i<=NBRLIG;i++){
    	if(parEvt.getSource()==bouton[i]){
			if (lesMobiles[i].getActivite()){
				laTache[i].suspend();
				lesMobiles[i].setActivite(false);
			}

			else if(! lesMobiles[i].getActivite()){
				laTache[i].resume();
				lesMobiles[i].setActivite(true);
			}
    	}
		
	}

    }
}
