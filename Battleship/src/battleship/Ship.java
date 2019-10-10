package battleship;

public class Ship {
	
	

	private String name;
	private int health;
	private int[] coords = new int[1];
	private int anchorCheck;
	private int yCheck;
	private int xCheck;

	
	public Ship(String aName, int aHealth, int anchorCheck, int yCheck, int xCheck)
	{
		name =  aName;
		health = aHealth;
		this.anchorCheck = anchorCheck;
		this.yCheck = yCheck;
		this.xCheck = xCheck;
		
	}

	public Ship(String aName, int aHealth)
	{
		name =  aName;
		health = aHealth;	
	}
	
	public void setCoords(int[] aCoords)
	{
		coords = aCoords;
	}
	
	public int getHealth() 
	{
		return health;
	}
	
	public String getName() 
	{
		return name;
	}

	public int[] getCoords() 
	{
		return coords;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public Ship(String aName, int aHealth, int coordsLength){
		name = aName;
		health = aHealth;
		coords = new int[coordsLength];
	}	
	
	
	public int getAnchorCheck() {
		return anchorCheck;
	}

	public int getyCheck() {
		return yCheck;
	}

	public int getxCheck() {
		return xCheck;
	}
}
