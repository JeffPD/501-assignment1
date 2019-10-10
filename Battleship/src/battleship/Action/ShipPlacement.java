package battleship.Action;

import javax.swing.ImageIcon;
import battleship.MainGame;
import battleship.Graphics.Display;
import battleship.BattleScreen;


public class ShipPlacement {
	
	private int[] startPosition = {1,11,21,31,41};
	private int tempShipPiece [] = null;
	private int shipCoords [] = null;
	
	private int numOfScreensPassed = 0;
	
	protected static MainGame mainGame;
	
	public ShipPlacement() {
		mainGame = new MainGame();
	}

	public void MoveUp() {
		if(numOfScreensPassed == 2){
			if (mainGame.isVertical() == true) {
				for(int i = 0; i < mainGame.getShipPiece().length;i++)
				{
					if((mainGame.getShipPiece()[0]-10)>=1)
					{
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]-10].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
			
						if (i==(mainGame.getShipPiece().length-1))
						{
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[mainGame.getShipPiece().length-1]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
							for(int c = 0; c < mainGame.getShipPiece().length;c++)
							{
								mainGame.getShipPiece()[c] = (mainGame.getShipPiece()[c]-10);
							}
						}
						placementErrorColor(i);
					}
					
				}
			} else {
				for(int i = 0; i < mainGame.getShipPiece().length;i++)
				{
					if((mainGame.getShipPiece()[i]-10)>=1)
					{
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]-10].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
						mainGame.getShipPiece()[i] = (mainGame.getShipPiece()[i]-10);
						placementErrorColor(i);
					}
				}
			}
		}
		
	}
	
	public void MoveLeft() {
		if (mainGame.isVertical() == true)
		{
			for(int i = 0; i < mainGame.getShipPiece().length;i++)
			{

				if (((mainGame.getShipPiece()[i]-1)<=100) && (mainGame.getShipPiece()[i] != 1) && (mainGame.getShipPiece()[i] != 11) && (mainGame.getShipPiece()[i] != 21) && (mainGame.getShipPiece()[i] != 31) && (mainGame.getShipPiece()[i] != 41) && (mainGame.getShipPiece()[i] != 51) && (mainGame.getShipPiece()[i] != 61) && (mainGame.getShipPiece()[i] != 71) && (mainGame.getShipPiece()[i] != 81) && (mainGame.getShipPiece()[i] != 91))
				{
					MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));

					MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]-1].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
					mainGame.getShipPiece()[i] = (mainGame.getShipPiece()[i]-1);

					placementErrorColor(i);
				}
			}
		}
		else
		{
			for(int i = 0; i < mainGame.getShipPiece().length;i++)
			{
				if((mainGame.getShipPiece()[0]!=1) && (mainGame.getShipPiece()[0]!=11) && (mainGame.getShipPiece()[0]!=21) && (mainGame.getShipPiece()[0]!=31) && (mainGame.getShipPiece()[0]!=41) && (mainGame.getShipPiece()[0]!=51) && (mainGame.getShipPiece()[0]!=61) && (mainGame.getShipPiece()[0]!=71) && (mainGame.getShipPiece()[0]!=81) && (mainGame.getShipPiece()[0]!=91))
				{
					MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]-1].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
					if (i==(mainGame.getShipPiece().length-1))
					{
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[mainGame.getShipPiece().length-1]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
						for(int c = 0; c < mainGame.getShipPiece().length;c++)
						{
							mainGame.getShipPiece()[c] = (mainGame.getShipPiece()[c]-1);
						}
					}
					placementErrorColor(i);
				}
			}
		}
	}
	
	public void MoveDown() {
		if(numOfScreensPassed == 2){
			if (mainGame.isVertical() == true)
			{
				for(int i = 0; i < mainGame.getShipPiece().length;i++)
				{
					if((mainGame.getShipPiece()[i]+10)<=100)
					{
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]+10].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
						


						if (i==(mainGame.getShipPiece().length-1))
						{
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[0]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
							for(int c = 0; c < mainGame.getShipPiece().length;c++)
							{
								mainGame.getShipPiece()[c] = (mainGame.getShipPiece()[c]+10);
							}
						}
						placementErrorColor(i);
					}
				}
			}
			else
			{
				for(int i = 0; i < mainGame.getShipPiece().length;i++)
				{
					if((mainGame.getShipPiece()[i]+10)<=100)
					{
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]+10].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
						mainGame.getShipPiece()[i] = (mainGame.getShipPiece()[i]+10);
						placementErrorColor(i);
					}
				}
			}
		}
		
	}
	
	public void MoveRight() {
		if(numOfScreensPassed == 2){
			if (mainGame.isVertical() == true)
			{
				for(int i = 0; i < mainGame.getShipPiece().length;i++)
				{

					if (((mainGame.getShipPiece()[i]+1)<=100)&& (mainGame.getShipPiece()[i] != 10) && (mainGame.getShipPiece()[i] != 20) && (mainGame.getShipPiece()[i] != 30) && (mainGame.getShipPiece()[i] != 40) && (mainGame.getShipPiece()[i] != 50) && (mainGame.getShipPiece()[i] != 60) && (mainGame.getShipPiece()[i] != 70) && (mainGame.getShipPiece()[i] != 80) && (mainGame.getShipPiece()[i] != 90))
					{
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));

						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]+1].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
						mainGame.getShipPiece()[i] = (mainGame.getShipPiece()[i]+1);
						placementErrorColor(i);
					}
			 	}
			}
			else
			{
				for(int i = 0; i < mainGame.getShipPiece().length;i++)
				{
					if((mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 10) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 20) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 30) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 40) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 50) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 60) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 70) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 80) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 90) && (mainGame.getShipPiece()[mainGame.getShipPiece().length-1] != 100))
					{
						MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]+1].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
						if (i==(mainGame.getShipPiece().length-1))
						{
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[0]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
							for(int c = 0; c < mainGame.getShipPiece().length;c++)
							{

								mainGame.getShipPiece()[c] = (mainGame.getShipPiece()[c]+1);
							}
						}
						placementErrorColor(i);
					}
				}
			}
		}
		
	}
	
	public void PlaceShip() {
		
		
		
		
		if(mainGame.getNumOfShipsPlaced() == 0 && numOfScreensPassed == 2)
		{
			ShipCheck();
			mainGame.setNumOfShipsPlaced(mainGame.getNumOfShipsPlaced() +1);
			mainGame.setVertical(true);
		}
		else if(mainGame.getNumOfShipsPlaced() == 1)
		{
			if(!shipCollisonCheck())
			{
				ShipCheck();
				mainGame.setNumOfShipsPlaced(mainGame.getNumOfShipsPlaced()+1);
				mainGame.setVertical(true);
			}
		}
		else if(mainGame.getNumOfShipsPlaced() == 2)
		{
			if(!shipCollisonCheck())
			{
				ShipCheck();
				mainGame.setNumOfShipsPlaced(mainGame.getNumOfShipsPlaced()+1);
				mainGame.setVertical(true);
			}

		}
		else if(mainGame.getNumOfShipsPlaced() == 3)
		{
			if(!shipCollisonCheck())
			{
				ShipCheck();
				mainGame.setNumOfShipsPlaced(mainGame.getNumOfShipsPlaced()+1);
				mainGame.setVertical(true);
			}

		}
		else if(mainGame.getNumOfShipsPlaced() == 4)
		{
			if(!shipCollisonCheck())
			{
				ShipCheck();
				mainGame.setNumOfShipsPlaced(mainGame.getNumOfShipsPlaced() + 1);
			}

		}
		else if(mainGame.getNumOfShipsPlaced() == 5)
		{
			MainGame.getPanel1().setVisible(false);
			BattleScreen gui = new BattleScreen();
			gui.setWindow();
		}
		
		if(numOfScreensPassed == 0){
			MainGame.getPanelForMenuScreen().setVisible(false);
			Display.getFrame().add(MainGame.getPanelForInstructions());
			numOfScreensPassed ++;
		}
		
		else if(numOfScreensPassed == 1){
			MainGame.getPanelForInstructions().setVisible(false);
		
			Display.getFrame().add(MainGame.getPanel1());
			numOfScreensPassed ++;
		}
		
	}
	

	public void RotateShip() {
		if(numOfScreensPassed == 2){
			if (mainGame.getShipPiece().length>0)
			{
				if (mainGame.isVertical() == true)
				{
					mainGame.setBorderBlock(getBorderBlock(mainGame.getShipPiece()[0]));
					if ((mainGame.getBorderBlock() - mainGame.getShipPiece()[0]) >= mainGame.getShipPiece().length-1)
					{
						for(int i = 1; i < mainGame.getShipPiece().length;i++)
						{
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
							mainGame.getShipPiece()[i]=(mainGame.getShipPiece()[0]+i);
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[0]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));

						}
						for(int i = 0; i < mainGame.getShipPiece().length;i++)
						{
							placementErrorColor(i);
						}

						mainGame.setVertical(false);
					}
				}
				else
				{
					if((((mainGame.getShipPiece()[0])+((mainGame.getShipPiece().length-1)*10)) <= 100))
					{
						for(int i = 1; i < mainGame.getShipPiece().length;i++)
						{
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementWater.png"));
							mainGame.getShipPiece()[i]=(mainGame.getShipPiece()[0]+(i*10));
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
							MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[0]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));


						}
						for(int i = 0; i < mainGame.getShipPiece().length;i++)
						{
							placementErrorColor(i);
						}
						mainGame.setVertical(true);
					}
				}
			}
		}
		
	}
	
	public void printLocation() {
		for(int i = 0; i < mainGame.getShipPiece().length;i++)
		{
			System.out.print(mainGame.getShipPiece()[i]+" ");
		}
		boolean a = shipCollisonCheck();
		System.out.println(a);
		System.out.print("Carrier: ");
		for (int i = 0; i < MainGame.getHumanPlayer().getCarrier().getCoords().length;i++)
		{
			System.out.print(MainGame.getHumanPlayer().getCarrier().getCoords()[i]+" ");
		}
		System.out.println();
		System.out.print("Battleship: ");
		for (int i = 0; i < MainGame.getHumanPlayer().getBattleship().getCoords().length;i++)
		{
			System.out.print(MainGame.getHumanPlayer().getBattleship().getCoords()[i]+" ");
		}
		System.out.println();
		System.out.print("Cruiser: ");
		for (int i = 0; i < MainGame.getHumanPlayer().getCruiser().getCoords().length;i++)
		{
			System.out.print(MainGame.getHumanPlayer().getCruiser().getCoords()[i]+" ");
		}
		System.out.println();
		System.out.print("Submarine: ");
		for (int i = 0; i < MainGame.getHumanPlayer().getSubmarine().getCoords().length;i++)
		{
			System.out.print(MainGame.getHumanPlayer().getSubmarine().getCoords()[i]+" ");
		}
		System.out.println();
		System.out.print("Destroyer: ");
		for (int i = 0; i < MainGame.getHumanPlayer().getDestroyer().getCoords().length;i++)
		{
			System.out.print(MainGame.getHumanPlayer().getDestroyer().getCoords()[i]+" ");
		}
		System.out.println();
	}
	
	public int getBorderBlock(int anchor)
	{
			if(1 <= anchor && anchor <= 10)
			{
				return(10);
			}
			else if(11 <= anchor && anchor <= 20)
			{
				return(20);
			}
			else if(21 <= anchor && anchor <= 30)
			{
				return(30);
			}
			else if(31 <= anchor && anchor <= 40)
			{
				return(40);
			}
			else if(41 <= anchor && anchor <= 50)
			{
				return(50);
			}
			else if(51 <= anchor && anchor <= 60)
			{
				return(60);
			}
			else if(61 <= anchor && anchor <= 70)
			{
				return(70);
			}
			else if(71 <= anchor && anchor <= 80)
			{
				return(80);
			}
			else if(81 <= anchor && anchor <= 90)
			{
				return(90);
			}
			else
			{
				return(100);
			}
	}
	
	public boolean shipCollisonCheck()
	{
		for(int i = 0; i < mainGame.getShipPiece().length;i++)
		{
			for(int c =0; c < MainGame.getHumanPlayer().getDestroyer().getCoords().length;c++)
			{
				if(mainGame.getShipPiece()[i] == MainGame.getHumanPlayer().getDestroyer().getCoords()[c])
				{
					return(true);
				}
			}

			for(int c = 0; c < MainGame.getHumanPlayer().getSubmarine().getCoords().length;c++)
			{
				if(mainGame.getShipPiece()[i] == MainGame.getHumanPlayer().getSubmarine().getCoords()[c])
				{
					return(true);
				}
			}

			for(int c = 0; c < MainGame.getHumanPlayer().getCruiser().getCoords().length;c++)
			{
				if(mainGame.getShipPiece()[i] == MainGame.getHumanPlayer().getCruiser().getCoords()[c])
				{
					return(true);
				}
			}
			for(int c = 0; c < MainGame.getHumanPlayer().getBattleship().getCoords().length;c++)
			{
				if(mainGame.getShipPiece()[i] == MainGame.getHumanPlayer().getBattleship().getCoords()[c])
				{
					return(true);
				}
			}
			for(int c = 0; c < MainGame.getHumanPlayer().getCarrier().getCoords().length;c++)
			{
				if(mainGame.getShipPiece()[i] == MainGame.getHumanPlayer().getCarrier().getCoords()[c])
				{
					return(true);
				}
			}

		}
		return(false);
	}

	public void placementErrorColor(int i)
	{
		if (i == (mainGame.getShipPiece().length-1))
		{
			if(mainGame.getNumOfShipsPlaced()>=1)
			{
				for(int c = 0; c < MainGame.getHumanPlayer().getDestroyer().getCoords().length;c++)
				{
					MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getDestroyer().getCoords()[c]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
				}
			}
			if(mainGame.getNumOfShipsPlaced()>=2)
			{
				for(int c = 0; c < MainGame.getHumanPlayer().getSubmarine().getCoords().length;c++)
				{
					MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getSubmarine().getCoords()[c]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
				}
			}if(mainGame.getNumOfShipsPlaced()>=3)
			{
				for(int c = 0; c < MainGame.getHumanPlayer().getCruiser().getCoords().length;c++)
				{
					MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getCruiser().getCoords()[c]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
				}
			}if(mainGame.getNumOfShipsPlaced()>=4)
			{
				for(int c = 0; c < MainGame.getHumanPlayer().getBattleship().getCoords().length;c++)
				{
					MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getBattleship().getCoords()[c]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
				}
			}if(mainGame.getNumOfShipsPlaced()>=5)
			{
				for(int c = 0; c < MainGame.getHumanPlayer().getCarrier().getCoords().length;c++)
				{
					MainGame.getLabelsForPlayerGridSetup()[MainGame.getHumanPlayer().getCarrier().getCoords()[c]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
				}
			}
			if (shipCollisonCheck())
			{
				for(int a = 0; a < mainGame.getShipPiece().length;a++)
				{
					MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[a]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementError.png"));
				}
			}
		}

	}
	
	public void shipTick()
	{
		String path = "";
		
		if (mainGame.getNumOfShipsPlaced() == 0)
		{
			path = MainGame.getDIR() + "\\res\\images\\2ShipCheck.png";
			MainGame.getDestroyer().setIcon(new ImageIcon(path));
		}
		else if (mainGame.getNumOfShipsPlaced() == 1)
		{
			path = MainGame.getDIR() + "\\res\\images\\3ShipCheck.png";
			MainGame.getSubmarine().setIcon(new ImageIcon(path));
		}
		else if (mainGame.getNumOfShipsPlaced() == 2)
		{
			path = MainGame.getDIR() + "\\res\\images\\3ShipCheck.png";
			MainGame.getCruiser().setIcon(new ImageIcon(path));
		}
		else if (mainGame.getNumOfShipsPlaced() == 3)
		{
			path = MainGame.getDIR() + "\\res\\images\\4ShipCheck.png";
			MainGame.getBattleship().setIcon(new ImageIcon(path));
		}
		else if (mainGame.getNumOfShipsPlaced() == 4)
		{
			path = MainGame.getDIR() + "\\res\\images\\5ShipCheck.png";
			MainGame.getCarrier().setIcon(new ImageIcon(path));
		}
	}
	
	public void coordSetter()
	{
		if (mainGame.getNumOfShipsPlaced() == 0)
		{
			MainGame.getHumanPlayer().getDestroyer().setCoords(mainGame.getShipPiece());
		}
		else if (mainGame.getNumOfShipsPlaced() == 1)
		{
			MainGame.getHumanPlayer().getSubmarine().setCoords(mainGame.getShipPiece());
		}
		else if (mainGame.getNumOfShipsPlaced() == 2)
		{
			MainGame.getHumanPlayer().getCruiser().setCoords(mainGame.getShipPiece());
		}
		else if (mainGame.getNumOfShipsPlaced() == 3)
		{
			MainGame.getHumanPlayer().getBattleship().setCoords(mainGame.getShipPiece());
		}
		else if (mainGame.getNumOfShipsPlaced() == 4)
		{
			MainGame.getHumanPlayer().getCarrier().setCoords(mainGame.getShipPiece());
		}
	}
	
	public void printsShipToPlacementGrid()
	{
		for(int i = 0; i < shipCoords.length;i++)
		{
			MainGame.getLabelsForPlayerGridSetup()[shipCoords[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementShip.png"));
		}

		mainGame.setShipPiece(tempShipPiece);
		for(int i = 0; i < mainGame.getShipPiece().length;i++)
		{
			MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementSelection.png"));
			if(shipCollisonCheck())
			{
				MainGame.getLabelsForPlayerGridSetup()[mainGame.getShipPiece()[i]].setIcon(new ImageIcon(MainGame.getDIR() + "\\res\\images\\ShipPlacementError.png"));
			}
		}
	}

	public void shipStartingPositionPlacer()
	{
		if (mainGame.getNumOfShipsPlaced() == 0)
		{
			tempShipPiece = new int[3];
			System.arraycopy(startPosition, 0, tempShipPiece, 0, 3);
			shipCoords = new int[2];
			
		}
		else if (mainGame.getNumOfShipsPlaced() == 1)
		{
			tempShipPiece = new int[3];
			System.arraycopy(startPosition, 0, tempShipPiece, 0, 3);
			shipCoords = new int[3];
		}
		else if (mainGame.getNumOfShipsPlaced() == 2)
		{
			tempShipPiece = new int[4];
			System.arraycopy(startPosition, 0, tempShipPiece, 0, 4);
			shipCoords = new int[3];
		}
		else if (mainGame.getNumOfShipsPlaced() == 3)
		{
			tempShipPiece = new int[5];
			System.arraycopy(startPosition, 0, tempShipPiece, 0, 5);
			shipCoords = new int[4];
		}
		else if (mainGame.getNumOfShipsPlaced() == 4)
		{
			tempShipPiece = new int [0];
			shipCoords = new int[5];
		}
	}
	
	public void ShipCheck() {

		if (mainGame.getNumOfShipsPlaced() == 0) {
			shipStartingPositionPlacer();
			shipTick();
			coordSetter();
			System.arraycopy(MainGame.getHumanPlayer().getDestroyer().getCoords(), 0, shipCoords, 0, 2);
			
		}else if (mainGame.getNumOfShipsPlaced() == 1){
			shipStartingPositionPlacer();
			shipTick();
			coordSetter();
			System.arraycopy(MainGame.getHumanPlayer().getSubmarine().getCoords(), 0, shipCoords, 0, 3);
			
		}else if (mainGame.getNumOfShipsPlaced() == 2){
			shipStartingPositionPlacer();
			shipTick();
			coordSetter();
			System.arraycopy(MainGame.getHumanPlayer().getCruiser().getCoords(), 0, shipCoords, 0, 3);
			
			
		}else if(mainGame.getNumOfShipsPlaced() == 3) {
			shipStartingPositionPlacer();
			shipTick();
			coordSetter();
			System.arraycopy(MainGame.getHumanPlayer().getBattleship().getCoords(), 0, shipCoords, 0, 4);
			
		}else if(mainGame.getNumOfShipsPlaced() == 4) {
			shipStartingPositionPlacer();
			shipTick();
			coordSetter();
			System.arraycopy(MainGame.getHumanPlayer().getCarrier().getCoords(), 0, shipCoords, 0, 5);
		}
			
		printsShipToPlacementGrid();
	}
	
	public MainGame getMainGame() {
		return mainGame;
	}
	
}
