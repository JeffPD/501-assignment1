package battleship.Graphics;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display {
	
	private static JFrame gameScreen;
	private String name;
	private int width;
	private int height;
	
	
	private JPanel panelForGameBattle = new JPanel();
	


	private JPanel gridForAI = new JPanel();
	private JPanel gridForPlayer = new JPanel();
	private JPanel shipsForAI = new JPanel();
	private JPanel shipsForPlayer = new JPanel();
	private JButton [] buttonsForAIGrid = new JButton [101];
	

	private int[] buttonsHit = new int[100];
	private int numOfButtonsHit = 0;
	private int[] labelsHit = new int[100];
	private int numOfLabelsHit = 0;
	private int numOfPlayerShipsDestroyed = 0;
	private int numOfAiShipsDestroyed = 0;


	private JLabel carrierAI = new JLabel();
	private JLabel battleshipAI = new JLabel();
	private JLabel submarineAI = new JLabel();
	private JLabel cruiserAI = new JLabel();
	private JLabel destroyerAI = new JLabel();


	
	
	
	
	public Display(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	public Display(){
		
	}
	
	private void createDisplay() {
		gameScreen = new JFrame(name);
		gameScreen.setSize(width, height);
		gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen.setResizable(false);
		gameScreen.setLocationRelativeTo(null);
		gameScreen.setVisible(true);

		
	}
	
	public static JFrame getFrame() {
		return gameScreen;
	}
	
	public JPanel getPanelForGameBattle() {
		return panelForGameBattle;
	}

	public void setPanelForGameBattle(JPanel panelForGameBattle) {
		this.panelForGameBattle = panelForGameBattle;
	}

	public JPanel getGridForAI() {
		return gridForAI;
	}

	public void setGridForAI(JPanel gridForAI) {
		this.gridForAI = gridForAI;
	}

	public JPanel getGridForPlayer() {
		return gridForPlayer;
	}

	public void setGridForPlayer(JPanel gridForPlayer) {
		this.gridForPlayer = gridForPlayer;
	}

	public JPanel getShipsForAI() {
		return shipsForAI;
	}

	public void setShipsForAI(JPanel shipsForAI) {
		this.shipsForAI = shipsForAI;
	}

	public JPanel getShipsForPlayer() {
		return shipsForPlayer;
	}

	public void setShipsForPlayer(JPanel shipsForPlayer) {
		this.shipsForPlayer = shipsForPlayer;
	}

	public JButton[] getButtonsForAIGrid() {
		return buttonsForAIGrid;
	}

	public void setButtonsForAIGrid(JButton[] buttonsForAIGrid) {
		this.buttonsForAIGrid = buttonsForAIGrid;
	}

	public int[] getButtonsHit() {
		return buttonsHit;
	}

	public void setButtonsHit(int[] buttonsHit) {
		this.buttonsHit = buttonsHit;
	}

	public int getNumOfButtonsHit() {
		return numOfButtonsHit;
	}

	public void setNumOfButtonsHit(int numOfButtonsHit) {
		this.numOfButtonsHit = numOfButtonsHit;
	}

	public int[] getLabelsHit() {
		return labelsHit;
	}

	public void setLabelsHit(int[] labelsHit) {
		this.labelsHit = labelsHit;
	}

	public int getNumOfLabelsHit() {
		return numOfLabelsHit;
	}

	public void setNumOfLabelsHit(int numOfLabelsHit) {
		this.numOfLabelsHit = numOfLabelsHit;
	}

	public int getNumOfPlayerShipsDestroyed() {
		return numOfPlayerShipsDestroyed;
	}

	public void setNumOfPlayerShipsDestroyed(int numOfPlayerShipsDestroyed) {
		this.numOfPlayerShipsDestroyed = numOfPlayerShipsDestroyed;
	}

	public int getNumOfAiShipsDestroyed() {
		return numOfAiShipsDestroyed;
	}

	public void setNumOfAiShipsDestroyed(int numOfAiShipsDestroyed) {
		this.numOfAiShipsDestroyed = numOfAiShipsDestroyed;
	}

	public JLabel getCarrierAI() {
		return carrierAI;
	}

	public void setCarrierAI(JLabel carrierAI) {
		this.carrierAI = carrierAI;
	}

	public JLabel getBattleshipAI() {
		return battleshipAI;
	}

	public void setBattleshipAI(JLabel battleshipAI) {
		this.battleshipAI = battleshipAI;
	}

	public JLabel getSubmarineAI() {
		return submarineAI;
	}

	public void setSubmarineAI(JLabel submarineAI) {
		this.submarineAI = submarineAI;
	}

	public JLabel getCruiserAI() {
		return cruiserAI;
	}

	public void setCruiserAI(JLabel cruiserAI) {
		this.cruiserAI = cruiserAI;
	}

	public JLabel getDestroyerAI() {
		return destroyerAI;
	}

	public void setDestroyerAI(JLabel destroyerAI) {
		this.destroyerAI = destroyerAI;
	}


	
}
