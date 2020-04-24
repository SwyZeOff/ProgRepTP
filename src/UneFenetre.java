import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener
{	
	UnMobile sonMobile1, sonMobile2;
	JButton sonBouton1, sonBouton2;
	
	List<Thread> threadList;
	List<UnMobile> listMobiles;
	List<JButton> listJBMobiles;
	List<Boolean> threadsStatus;
    
    private final int LARG=400, HAUT=400;
    
    public UneFenetre()
    {
		super("Le Mobile");
		setSize(LARG, HAUT);
		setVisible(true);
		setResizable(true);
	    final int nbMobiles = 10;
		setBackground(new Color(45,45,225));
		
		Container leConteneur = getContentPane();
		leConteneur.setLayout (new GridLayout(nbMobiles, 2));
		
		threadList = new ArrayList<Thread>();
		listMobiles = new ArrayList<UnMobile>();
		listJBMobiles = new ArrayList<JButton>();
		threadsStatus = new ArrayList<Boolean>();
		
		for(int i = 0; i < nbMobiles; i++)
		{
			listMobiles.add(new UnMobile(LARG/2, HAUT/nbMobiles));
			threadList.add(new Thread(listMobiles.get(i)));
			threadList.get(i).start();
			threadsStatus.add(true);
			JButton button = new JButton("Stopper");
			button.setActionCommand(String.valueOf(i));
			button.addActionListener(this);
			listJBMobiles.add(button);
			leConteneur.add(listMobiles.get(i));
			leConteneur.add(listJBMobiles.get(i));	
		}
    }

	public void actionPerformed(ActionEvent e)
	{	
		String valueString = e.getActionCommand();
		int valueIndex = Integer.parseInt(valueString);
		
		if (threadsStatus.get(valueIndex))
		{
			threadList.get(valueIndex).suspend();
			listJBMobiles.get(valueIndex).setText("Démarrer");
		}
		else
		{
			threadList.get(valueIndex).resume();
			listJBMobiles.get(valueIndex).setText("Stopper");
		}
		threadsStatus.set(valueIndex, !threadsStatus.get(valueIndex));
	}
}
