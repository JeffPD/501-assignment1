package battleship.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import battleship.Action.ShipPlacement;



public class Keyboard implements KeyListener {

	private static ShipPlacement shipPlacement;


	
	public Keyboard() {
		shipPlacement = new ShipPlacement();
	}
	
	
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent txt){}
	
	public void keyPressed (KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP)
		{
			shipPlacement.MoveUp();
		}

		else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT)
		{
			shipPlacement.MoveLeft();
		}

		else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN)
		{
			shipPlacement.MoveDown();
		}

		else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT)
		{
			shipPlacement.MoveRight();
		}
		
		else if (keyCode == KeyEvent.VK_P)
		{
			shipPlacement.printLocation();
		}

		else if (keyCode == KeyEvent.VK_ENTER)
		{
			shipPlacement.PlaceShip();
		}
		else if (keyCode == KeyEvent.VK_SPACE)
		{
			shipPlacement.RotateShip();

		}
		
		
	}
}