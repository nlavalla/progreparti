package TP1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener
{
    
   

    private final int LARG=500, HAUT=250, NBRLIG=3;
    JButton sonarret1 =new JButton("Arret");
    Thread laTache1;
    UnMobile sonMobile1;
    
    JButton sonarret2 =new JButton("Arret");
    Thread laTache2;
    UnMobile sonMobile2;
    
    JButton sonarret3 =new JButton("Arret");
    Thread laTache3;
    UnMobile sonMobile3;
    
    
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
    	
    	sonMobile1=new UnMobile(LARG, HAUT);
    	sonarret1= new JButton ("Start/Stop");
    	sonarret1.addActionListener(this);
    	leConteneur.add(sonMobile1);
    	leConteneur.add(sonarret1);
    	laTache1= new Thread(sonMobile1);
    	laTache1.start();
    	
    	sonMobile2=new UnMobile(LARG,HAUT);
    	sonarret2= new JButton ("Start/Stop");
    	sonarret2.addActionListener(this);
    	leConteneur.add(sonMobile2);
     	leConteneur.add(sonarret2);
    	laTache2= new Thread(sonMobile2);
    	laTache2.start();
    	
    	sonMobile3=new UnMobile(LARG,HAUT);
    	sonarret3= new JButton ("Start/Stop");
    	sonarret3.addActionListener(this);
    	leConteneur.add(sonMobile3);
     	leConteneur.add(sonarret3);
    	laTache3= new Thread(sonMobile3);
    	laTache3.start();
    	
    	
    	setSize(1000,600);
		setVisible(true);
		setLocation(200,300);
	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
	// afficher la fenetre
	// lancer laThread 
    }
    public void actionPerformed(ActionEvent parEvt) {
    	
    	if(parEvt.getSource()==sonarret1){
			if (sonMobile1.getActivite()){
				laTache1.suspend();
				sonMobile1.setActivite(false);
			}

			else if(! sonMobile1.getActivite()){
				laTache1.resume();
				sonMobile1.setActivite(true);
			}
    	}
		if(parEvt.getSource()==sonarret2){
			if (sonMobile2.getActivite()){
				laTache2.suspend();
				sonMobile2.setActivite(false);
			}

			else if(! sonMobile2.getActivite()){
				laTache2.resume();
				sonMobile2.setActivite(true);
			}

		}
		if(parEvt.getSource()==sonarret3){
			if (sonMobile3.getActivite()){
				laTache3.suspend();
				sonMobile3.setActivite(false);
			}

			else if(! sonMobile3.getActivite()){
				laTache3.resume();
				sonMobile3.setActivite(true);
			}

		}
		
	}

    }
