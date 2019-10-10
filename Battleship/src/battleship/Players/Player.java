package battleship.Players;



//import javax.swing.ImageIcon;

import battleship.Ship;


public abstract class Player {
	
	

	protected Ship destroyer  = new Ship("Destroyer", 2 , 90 , 10 , 9);
	protected Ship submarine = new Ship("Submarine", 3 , 80, 9 , 8);
	protected Ship cruiser = new Ship("Cruiser", 3 , 80 , 9, 8);
	protected Ship battleship = new Ship("Battleship", 4 , 70 , 8 , 7);
	protected Ship carrier  = new Ship ("Carrier", 5 , 60 , 6 , 6);
	
	
	protected int numOfShipsDestroyed = 0;
	


	

	public void CheckWhenAShipIsDestroyed()
	{
		if(carrier.getHealth() == 0)
		{
			//method call to GUI to show destroyed ship JLabel
			System.out.println("Carrier has been destroyed");
			numOfShipsDestroyed ++;
			carrier.setHealth(-1);
			
		}
		if(battleship.getHealth() == 0)
		{
			//method call to GUI to show destroyed ship JLabel
			System.out.println("Battleship has been destroyed");
			numOfShipsDestroyed ++;
			battleship.setHealth(-1);
		}
		if(cruiser.getHealth() == 0)
		{
			//method call to GUI to show destroyed ship JLabel
			System.out.println("Cruiser has been destroyed");
			numOfShipsDestroyed ++;
			cruiser.setHealth(-1);
		}
		if(submarine.getHealth() == 0)
		{
			//method call to GUI to show destroyed ship JLabel
			System.out.println("Submarine has been destroyed");
			numOfShipsDestroyed ++;
			submarine.setHealth(-1);
		}
		if(destroyer.getHealth() == 0)
		{
			//method call to GUI to show destroyed ship JLabel
			System.out.println("Destroyer has been destroyed");
			numOfShipsDestroyed ++;
			destroyer.setHealth(-1);
		}
		checkLoss();
		
	}
	
	public boolean HitShip(int num , Player enemy) {
		for (int i = 0; i < enemy.getCarrier().getCoords().length;i++)
		{
			if(num == enemy.carrier.getCoords()[i])
			{
				enemy.carrier.setHealth(enemy.carrier.getHealth() - 1);
				return(true);
			}
		}
		for (int i = 0; i < enemy.battleship.getCoords().length;i++)
		{
			if(num == enemy.battleship.getCoords()[i])
			{
				enemy.battleship.setHealth(enemy.battleship.getHealth() - 1);
				return(true);
			}
		}
		for (int i = 0; i < enemy.cruiser.getCoords().length;i++)
		{
			if(num == enemy.cruiser.getCoords()[i])
			{
				enemy.cruiser.setHealth(enemy.cruiser.getHealth() - 1);
				return(true);
			}
		}
		for (int i = 0; i < enemy.submarine.getCoords().length;i++)
		{
			if(num == enemy.submarine.getCoords()[i])
			{
				enemy.submarine.setHealth(enemy.submarine.getHealth() - 1);
				return(true);
			}
		}
		for (int i = 0; i < enemy.destroyer.getCoords().length;i++)
		{
			if(num == enemy.destroyer.getCoords()[i])
			{
				enemy.destroyer.setHealth(enemy.destroyer.getHealth() - 1);
				return(true);
			}
		}
		return(false);
	}
	
	public Ship getDestroyer() {
		return destroyer;
	}


	public Ship getSubmarine() {
		return submarine;
	}


	public Ship getCruiser() {
		return cruiser;
	}


	public Ship getBattleship() {
		return battleship;
	}


	public Ship getCarrier() {
		return carrier;
	}

	
	
	public int getNumOfShipsDestroyed() {
		return numOfShipsDestroyed;
	}


	public abstract void checkLoss();
	
}
