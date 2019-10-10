package battleship.Players;



import battleship.MainGame;
import battleship.Graphics.Display;
import battleship.BattleScreen;


public class Human extends Player
{
	

	public void checkLoss()
	{
		if (numOfShipsDestroyed == 5)
		{
			BattleScreen.getPanelForGameBattle().setVisible(false);
			Display.getFrame().add(MainGame.getPanelForLoseScreen());
			System.out.println("Human Loses");
			
		}
	}
	
	
	
	
	
	
	
}
