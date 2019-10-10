package battleship.Players;

import java.util.Random;

import battleship.MainGame;
import battleship.Graphics.Display;
import battleship.BattleScreen;

public class AI extends Player{
	
	private Random ran = new Random();
	private int[] aICoordsChecker = new int[17];
	private int[] tempAICoord;
	private int numOfShipsSet = 0;
	
	
	
	public AI() {
		aIShipCoordsSetter();

	}
	
	
	public void aIShipCoordsSetter() {
		
		
		if (numOfShipsSet == 0) {
			
			tempAICoord = new int[carrier.getHealth()];
			carrier.setCoords(aICoordsGenerator(carrier.getyCheck(), carrier.getxCheck(), carrier.getAnchorCheck(), tempAICoord));
			System.arraycopy(carrier.getCoords(), 0, aICoordsChecker, 0, 5);
			numOfShipsSet ++;
			aIShipCoordsSetter();
			
		} else if (numOfShipsSet == 1) {
						
			tempAICoord = new int[battleship.getHealth()];
			battleship.setCoords(aICoordsGenerator(battleship.getyCheck(), battleship.getxCheck(), battleship.getAnchorCheck(), tempAICoord));
			System.arraycopy(battleship.getCoords(), 0, aICoordsChecker, 5, 4);
			numOfShipsSet ++;
			aIShipCoordsSetter();
			
			
		} else if (numOfShipsSet == 2) {
					
			tempAICoord = new int[cruiser.getHealth()];
			cruiser.setCoords(aICoordsGenerator(cruiser.getyCheck(), cruiser.getxCheck(), cruiser.getAnchorCheck(), tempAICoord));
			System.arraycopy(cruiser.getCoords(), 0, aICoordsChecker, 9, 3);
			numOfShipsSet ++;
			aIShipCoordsSetter();	
			
		} else if (numOfShipsSet == 3) {
				
			tempAICoord = new int[submarine.getHealth()];
			submarine.setCoords(aICoordsGenerator(submarine.getyCheck(), submarine.getxCheck(), submarine.getAnchorCheck(), tempAICoord));
			System.arraycopy(submarine.getCoords(), 0, aICoordsChecker, 12, 3);
			numOfShipsSet ++;
			aIShipCoordsSetter();
			
		} else if (numOfShipsSet == 4) {
			
			tempAICoord = new int[destroyer.getHealth()];
			destroyer.setCoords(aICoordsGenerator(destroyer.getyCheck(), destroyer.getxCheck(), destroyer.getAnchorCheck(), tempAICoord));
			System.arraycopy(destroyer.getCoords(), 0, aICoordsChecker, 15, 2);
			numOfShipsSet ++;
			
		}
		
		
	}
	
	public boolean aICoordsCheck(int[] aiShip) {
		
		for (int i = 0 ; i < aICoordsChecker.length ; i++) {
			
			for (int c = 0; c < aiShip.length ; c ++) {
				
				if (aiShip[c] == aICoordsChecker[i]) {
					return true;
				}
				
			}
		
		}
		
		return false;
		
	}
	
	
	
	public int[] aICoordsGenerator(int yCheck , int xCheck, int anchorCheck, int[] aiShip) {
		boolean m = true;
		while((m) || aICoordsCheck(aiShip))
		{
			m=false;
			int randNum =(ran.nextInt(2));
			if(randNum == 0)
			{
				int y = (ran.nextInt(yCheck));
				y = (y*10);
				int x = 0;
				if(y==anchorCheck)
				{
					if (numOfShipsSet == 0) {
						x = (1+ran.nextInt(9));
					} else {
						x = 0;
					}
				}
				else if(y == 0)
				{
					x = (1+ran.nextInt(9));
				}
				else
				{
					x = (ran.nextInt(10));
				}
				int aIAnchor = (y+x);
				aiShip[0] = aIAnchor;
				for(int i = 1; i < aiShip.length; i++)
				{
					aiShip[i] = (aIAnchor+(i*10));
				}

			}
			else
			{
				int y = (ran.nextInt(10));
				y = (y*10);
				int x = (1+ran.nextInt(xCheck));
				int aIAnchor = (y+x);
				aiShip[0] = aIAnchor;
				for(int i = 1; i < aiShip.length;i++)
				{
					aiShip[i] = (aIAnchor+i);
				}


			}
		}
		
		return aiShip;

	}


	public void checkLoss()
	{
		if (numOfShipsDestroyed == 5)
		{
			BattleScreen.getPanelForGameBattle().setVisible(false);
			Display.getFrame().add(MainGame.getPanelForWinScreen());
			System.out.println("AI Loses");
			System.out.print("Score: ");
			System.out.printf("%.2f",setScore());
		}
	}
	
	public double setScore()
	{	double numerator = 17.0;
		double denominator = BattleScreen.getNumOfButtonsHit();
		double score = ((numerator/denominator)*100);
		return score;
	}

}
