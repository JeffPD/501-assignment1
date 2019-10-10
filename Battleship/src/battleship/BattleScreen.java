package battleship;

import java.awt.*;
import javax.swing.*;

import battleship.Graphics.Display;

import java.awt.event.*;
import java.util.*;




public class BattleScreen
{

	private static JPanel panelForGameBattle = new JPanel();

	private JPanel gridForAI = new JPanel();
	private JPanel gridForPlayer = new JPanel();
	private JPanel shipsForAI = new JPanel();
	private JPanel shipsForPlayer = new JPanel();
	private JButton [] buttonsForAIGrid = new JButton [101];
	

	private int[] buttonsHit = new int[100];
	private static int numOfButtonsHit = 0;
	private int[] labelsHit = new int[100];
	private int numOfLabelsHit = 0;

	private JLabel carrierAI = new JLabel();
	private JLabel battleshipAI = new JLabel();
	private JLabel submarineAI = new JLabel();
	private JLabel cruiserAI = new JLabel();
	private JLabel destroyerAI = new JLabel();
	
	



	private Random ran = new Random();


	public void setWindow()
	{
		
		Display.getFrame().removeKeyListener(MainGame.getInput());

		
		panelForGameBattle.setLayout(new GridLayout(2,2,10,10));
		gridForAI.setLayout(new GridLayout(10,10,1,1));
		gridForPlayer.setLayout(new GridLayout(10,10,1,1));
		shipsForAI.setLayout(new GridLayout(5,1,0,0));
		shipsForPlayer.setLayout(new GridLayout(5,1,0,0));

		shipsForAI.setBackground(Color.DARK_GRAY);
		shipsForPlayer.setBackground(Color.DARK_GRAY);
		gridForAI.setBackground(Color.DARK_GRAY);
		gridForPlayer.setBackground(Color.BLACK);
		panelForGameBattle.setBackground(Color.DARK_GRAY);


		printsShipsCoords();





		buttonSetup();
		labelSetup();
		shipSetup();
		setButtonEvent();
		Display.getFrame().add(panelForGameBattle);
		panelForGameBattle.add(gridForAI);
		panelForGameBattle.add(shipsForAI);
		panelForGameBattle.add(gridForPlayer);
		panelForGameBattle.add(shipsForPlayer);
		Display.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Display.getFrame().setVisible(true);
		Display.getFrame().setResizable(false);
	}

	public void buttonSetup()
	{
		for (int i=1;i<=100;i++){
			

			buttonsForAIGrid[i] = new JButton("");
		}

		for (int i=1;i<=100;i++){
			gridForAI.add(buttonsForAIGrid[i]);
		}
	}

	public void labelSetup()
	{
		for (int i=1;i<=100;i++){
			MainGame.getLabelsForPlayerGridSetup()[i] = new JLabel();
			MainGame.getLabelsForPlayerGridSetup()[i].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
		}

		for(int i = 0;i<MainGame.getHumanPlayer().getCarrier().getCoords().length;i++)
		{
			MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getCarrier().getCoords()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
		}
		for(int i = 0;i<MainGame.getHumanPlayer().getBattleship().getCoords().length;i++)
		{
			MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getBattleship().getCoords()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
		}
		for(int i = 0;i<MainGame.getHumanPlayer().getSubmarine().getCoords().length;i++)
		{
			MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getSubmarine().getCoords()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
		}
		for(int i = 0;i<MainGame.getHumanPlayer().getCruiser().getCoords().length;i++)
		{
			MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getCruiser().getCoords()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
		}
		for(int i = 0;i<MainGame.getHumanPlayer().getDestroyer().getCoords().length;i++)
		{
			MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getDestroyer().getCoords()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
		}
		for (int i=1;i<=100;i++){
			gridForPlayer.add(MainGame.getLabelsForPlayerGridSetup()[i]);
    	}
	}

	public void shipSetup()
	{
		MainGame.getBattleship().setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\4Ship.png"));
		MainGame.getSubmarine().setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\3Ship.png"));
		MainGame.getCruiser().setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\3Ship.png"));
		MainGame.getDestroyer().setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\2Ship.png"));
		MainGame.getCarrier().setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\5Ship.png"));

		battleshipAI.setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\4Ship.png"));
		submarineAI.setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\3Ship.png"));
		cruiserAI.setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\3Ship.png"));
		destroyerAI.setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\2Ship.png"));
		carrierAI.setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\5Ship.png"));

		shipsForAI.add(MainGame.getCarrier());
		shipsForAI.add(MainGame.getBattleship());
		shipsForAI.add(MainGame.getSubmarine());
		shipsForAI.add(MainGame.getCruiser());
		shipsForAI.add(MainGame.getDestroyer());

		shipsForPlayer.add(carrierAI);
		shipsForPlayer.add(battleshipAI);
		shipsForPlayer.add(submarineAI);
		shipsForPlayer.add(cruiserAI);
		shipsForPlayer.add(destroyerAI);


	}

	public void setButtonEvent()
	{
		
		
		
		
		for (int i=1;i<=100;i++){
			int locationWhereHumanHasFired = i; 
			
			buttonsForAIGrid[i].addActionListener(new ActionListener()
			
			{
				public void actionPerformed(ActionEvent e)
				{
					humanFiring(locationWhereHumanHasFired);
					
				}
			});
		}
	}
	
	public void humanFiring(int locationWhereHumanHasFired){
		
		
		if(!buttonHitCheck(locationWhereHumanHasFired))
		{
			buttonsHit[numOfButtonsHit] = locationWhereHumanHasFired;
			numOfButtonsHit = numOfButtonsHit + 1;
			
			if (MainGame.getHumanPlayer().HitShip(locationWhereHumanHasFired, MainGame.getAIPlayer()))
				{
				
					buttonsForAIGrid[locationWhereHumanHasFired].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipHit.png"));
					setButtonEvent();
					
				}else
				{
					buttonsForAIGrid[locationWhereHumanHasFired].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\WaterHit.png"));
					
					
					
					aIFiring();
				}
			MainGame.getAIPlayer().CheckWhenAShipIsDestroyed();
		}
	}
	
	public void aIFiring(){
		
		
		int locationWhereAIHasFired =(1 + ran.nextInt(100));
		while(labelHitCheck(locationWhereAIHasFired))
		{
			locationWhereAIHasFired =(1 + ran.nextInt(100));
		}
		
		
		
		labelsHit[numOfLabelsHit] = locationWhereAIHasFired;
		numOfLabelsHit = numOfLabelsHit + 1;
		
		if (MainGame.getAIPlayer().HitShip(locationWhereAIHasFired, MainGame.getHumanPlayer()))
			{
				
				MainGame.getLabelsForPlayerGridSetup()[locationWhereAIHasFired].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipHit.png"));
				
				
				
				aIFiring();
			}else
			{

				
				
				MainGame.getLabelsForPlayerGridSetup()[locationWhereAIHasFired].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\WaterHit.png"));

			}
		
		MainGame.getHumanPlayer().CheckWhenAShipIsDestroyed();
		
	}
	
	
	
	
	
	
	
	
	
	
	public boolean labelHitCheck(int labelClicked)
	{
		for(int i = 0;i < labelsHit.length;i++)
		{
			if(labelClicked == labelsHit[i])
			{
				return(true);
			}
		}
		return(false);
	}

	public boolean buttonHitCheck(int buttonClicked)
	{
		for(int i = 0;i < buttonsHit.length;i++)
		{
			if(buttonClicked == buttonsHit[i])
			{
				return(true);
			}
		}
		return(false);
	}




	public void printsShipsCoords()
	{
		
		System.out.print("AI Carrier: ");
		for(int i = 0; i < MainGame.getAIPlayer().getCarrier().getCoords().length; i++)
		{
			System.out.print(MainGame.getAIPlayer().getCarrier().getCoords()[i]+" ");
		}
		System.out.println();
		

		System.out.print("AI Battleship: ");
		for(int i = 0; i < MainGame.getAIPlayer().getBattleship().getCoords().length; i++)
		{
			System.out.print(MainGame.getAIPlayer().getBattleship().getCoords()[i]+" ");
		}
		System.out.println();

		System.out.print("AI Cruiser: ");
		for(int i = 0; i < MainGame.getAIPlayer().getCruiser().getCoords().length; i++)
		{
			System.out.print(MainGame.getAIPlayer().getCruiser().getCoords()[i]+" ");
		}
		System.out.println();

		System.out.print("AI Submarine: ");
		for(int i = 0; i < MainGame.getAIPlayer().getSubmarine().getCoords().length;i++)
		{
			System.out.print(MainGame.getAIPlayer().getSubmarine().getCoords()[i]+" ");
		}
		System.out.println();

		System.out.print("AI Destroyer: ");
		for(int i = 0; i < MainGame.getAIPlayer().getDestroyer().getCoords().length;i++)
		{
			System.out.print(MainGame.getAIPlayer().getDestroyer().getCoords()[i]+" ");
		}
		System.out.println();
	}
	
	public static JPanel getPanelForGameBattle() {
		return panelForGameBattle;
	}
	
	public static int getNumOfButtonsHit() {
		return numOfButtonsHit;
	}

	
}