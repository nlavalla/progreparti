package TP1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelFils extends JPanel implements ActionListener {
	
	JButton bouton=new JButton("Envoie");
	UnMobile sonMobile;
    private final int LARG=500, HAUT=250;
	public PanelFils (){
		
		bouton.addActionListener(this);
		sonMobile= new UnMobile(LARG,HAUT);
    	Thread laTache= new Thread(sonMobile);
    	laTache.start();
    	JButton bouton=new JButton("Envoie");
    	add(sonMobile);
		add(bouton);

		
	}
	public void actionPerformed (ActionEvent parEvt)
	{
		if(parEvt.getSource()==bouton)
			System.out.println("tutu");
	}
	
}
