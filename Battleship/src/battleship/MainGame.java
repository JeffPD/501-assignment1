package battleship;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import battleship.Graphics.Display;
import battleship.Graphics.Keyboard;
import battleship.Players.AI;
import battleship.Players.Human;
import battleship.Players.Player;

public class MainGame {
	
	private static JLabel [] labelsForPlayerGridSetup = new JLabel [101];
	
	private static Keyboard input;
	private static Display window = new Display("Battleship", 675, 700);
	private static JPanel panel1 = new JPanel();
	

	private static JPanel panel2 = new JPanel();
	private static JPanel panel3 = new JPanel();
	private static JPanel panelForInstructions = new JPanel();
	private static JPanel panelForMenuScreen = new JPanel();
	private static JPanel panelForWinScreen = new JPanel();
	private static JPanel panelForLoseScreen = new JPanel();

	

	private static JLabel carrier = new JLabel();
	private static JLabel battleship = new JLabel();
	private static JLabel submarine = new JLabel();
	private static JLabel cruiser = new JLabel();
	private static JLabel destroyer = new JLabel();
	
	private static JLabel labelForInstructions = new JLabel();
	private static JLabel labelForMenuScreen = new JLabel();
	private static JLabel labelForWinScreen = new JLabel();
	private static JLabel labelForLoseScreen = new JLabel();
	
	private static final String DIR = System.getProperty("user.dir");
	

	

	private int numOfShipsPlaced = 0;

	private int[] shipPiece ={1,11};
	private boolean vertical = true;
	private int borderBlock = 10;

	private static Player humanPlayer = new Human();
	private static AI aIPlayer = new AI();

	public void start() {
		input = new Keyboard();

		panelForInstructions.setPreferredSize(new Dimension(675,680));	
		panel2.setPreferredSize(new Dimension(450,450));
		panel3.setPreferredSize(new Dimension(200,650));
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new GridLayout(10,10,1,1));
		Display.getFrame().addKeyListener(input);
		for (int i=1;i<=100;i++){
			labelsForPlayerGridSetup[i] = new JLabel();
			labelsForPlayerGridSetup[i].setIcon(new ImageIcon(DIR + "\\res\\images\\ShipPlacementWater.png"));
		}
		for(int i = 0; i < shipPiece.length;i++) {
			labelsForPlayerGridSetup[shipPiece[i]].setIcon(new ImageIcon(DIR + "\\res\\images\\ShipPlacementSelection.png"));
		}
	
		for (int i=1;i<=100;i++) {
			panel2.add(labelsForPlayerGridSetup[i]);
		}
	
		JLabel space1 = new JLabel();
		JLabel space2 = new JLabel();
	
	
		carrier.setIcon(new ImageIcon(DIR + "\\res\\images\\5Ship.png"));
		battleship.setIcon(new ImageIcon(DIR + "\\res\\images\\4Ship.png"));
		submarine.setIcon(new ImageIcon(DIR + "\\res\\images\\3Ship.png"));
		cruiser.setIcon(new ImageIcon(DIR + "\\res\\images\\3Ship.png"));
		destroyer.setIcon(new ImageIcon(DIR + "\\res\\images\\2Ship.png"));
		
		
		labelForMenuScreen.setIcon(new ImageIcon(DIR + "\\res\\images\\MenuScreen.png"));
		labelForInstructions.setIcon(new ImageIcon(DIR + "\\res\\images\\InstructionScreen.png"));
		labelForWinScreen.setIcon(new ImageIcon(DIR + "\\res\\images\\WinScreen.png"));
		labelForLoseScreen.setIcon(new ImageIcon(DIR + "\\res\\images\\LoseScreen.png"));
		
		
	
		panel3.add(space1);
		panel3.add(carrier);
		panel3.add(battleship);
		panel3.add(cruiser);
		panel3.add(submarine);
		panel3.add(destroyer);
		panel3.add(space2);
	
		panelForMenuScreen.add(labelForMenuScreen);
		panelForInstructions.add(labelForInstructions);
		panelForWinScreen.add(labelForWinScreen);
		panelForLoseScreen.add(labelForLoseScreen);
		
		panel3.setLayout(new GridLayout(7,1,0,0));
	
	
		panel1.setBackground(Color.DARK_GRAY);
		panel2.setBackground(Color.BLACK);
		panel3.setBackground(Color.DARK_GRAY);
		Display.getFrame().add(panelForMenuScreen);
	
	
		panel1.add(panel2);
		panel1.add(panel3);
		Display.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Display.getFrame().setVisible(true);
		Display.getFrame().setResizable(false);
	}
	
	public static Keyboard getInput() {
		return input;
	}
	
	

	
	public boolean isVertical() {
		return vertical;
	}
	
	public int[] getShipPiece() {
		return shipPiece;
	}
	

	
	public static JLabel[] getLabelsForPlayerGridSetup() {
		return labelsForPlayerGridSetup;
	}
	
	public int getNumOfShipsPlaced() {
		return numOfShipsPlaced;
	}
	
	public int getBorderBlock() {
		return borderBlock;
	}
	
	public static JLabel getCarrier() {
		return carrier;
	}
	
	public static JLabel getBattleship() {
		return battleship;
	}
	
	public static JLabel getSubmarine() {
		return submarine;
	}
	
	public static JLabel getCruiser() {
		return cruiser;
	}
	
	public static JLabel getDestroyer() {
		return destroyer;
	}
	

	
	public static void setLabelsForPlayerGridSetup(JLabel[] alabelsForPlayerGridSetup) {
		labelsForPlayerGridSetup = alabelsForPlayerGridSetup;
	}

	public void setInput(Keyboard aninput) {
		input = aninput;
	}

	public static void setWindow(Display awindow) {
		window = awindow;
	}

	public void setPanel1(JPanel panel1) {
		MainGame.panel1 = panel1;
	}



	public void setCarrier(JLabel carrier) {
		MainGame.carrier = carrier;
	}

	public void setBattleship(JLabel battleship) {
		MainGame.battleship = battleship;
	}

	public void setSubmarine(JLabel submarine) {
		MainGame.submarine = submarine;
	}

	public void setCruiser(JLabel cruiser) {
		MainGame.cruiser = cruiser;
	}

	public void setDestroyer(JLabel aDestroyer) {
		destroyer = aDestroyer;
	}







	public void setNumOfShipsPlaced(int numOfShipsPlaced) {
		this.numOfShipsPlaced = numOfShipsPlaced;
	}

	public void setShipPiece(int[] shipPiece) {
		this.shipPiece = shipPiece;
	}


	public void setVertical(boolean vertical) {
		this.vertical = vertical;
	}

	public void setBorderBlock(int borderBlock) {
		this.borderBlock = borderBlock;
	}


	public Display getWindow() {
		return window;
	}


	
	public static JPanel getPanel1() {
		return panel1;
	}

	public static JPanel getPanel2() {
		return panel2;
	}

	public static JPanel getPanel3() {
		return panel3;
	}

	public static Player getHumanPlayer() {
		return humanPlayer;
	}
	
	public static AI getAIPlayer() {
		return aIPlayer;
	}
	
	public static String getDIR() {
		return DIR;
	}
	public static JPanel getPanelForInstructions() {
		return panelForInstructions;
	}
	
	public static JPanel getPanelForMenuScreen() {
		return panelForMenuScreen;
	}
	
	public static JPanel getPanelForWinScreen() {
		return panelForWinScreen;
	}
	
	public static JPanel getPanelForLoseScreen() {
		return panelForLoseScreen;
	}
}
