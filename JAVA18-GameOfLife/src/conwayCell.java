/*
 * This program is part of my learning Java series
 * This one shows an algorithm for a cell in Conways Game Of Life
 * 
 * Find the blog here,
 * http://testsheepnz.blogspot.com/2016/09/java-18-conways-game-of-life-example.html
 * 
 * For more information - please reread.
 * 
 * Mike Talks, Sept 2016
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class conwayCell {

	//Attributes
	private boolean isAlive;
	private int numLiveNeighbours;
	
	//Methods - getters
	public boolean getIsAlive ()
	{
		return isAlive;
	}
	
	public int getNumLiveNeighbours ()
	{
		return numLiveNeighbours;
	}

	//Methods - setters
	public void setIsAlive (boolean status)
	{
		isAlive = status;
	}
	
	public void setNumLiveNeighbours (int num)
	{
		numLiveNeighbours = num;
	}
	
	
	/*
	 * Any live cell with fewer than two live neighbours dies, as if caused by under-population.
	 * Any live cell with two or three live neighbours lives on to the next generation.
	 * Any live cell with more than three live neighbours dies, as if by over-population.
	 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	 */
	
	public void applyConwaysLaw ()
	{
		if ((isAlive == true && numLiveNeighbours < 2) 
				|| (isAlive == true && numLiveNeighbours > 3) )
		{
			isAlive = false;
			System.out.println("Cell dies");
		}
		
		if (isAlive == false && numLiveNeighbours ==3)
		{
			isAlive = true;
			System.out.println("Cell regenerates");		
		}
	}
	
	public void cellStatus()
	{
		if (isAlive == true)
			System.out.println("Cell alive");
		else
			System.out.println("Cell dead");
		
		System.out.println("Cell has " + numLiveNeighbours + " live neigbours");
	}

	@Test
	public void aliveOneNeighbour()
	{
		conwayCell cell = new conwayCell();
		cell.setIsAlive(true);
		cell.setNumLiveNeighbours(1);
		assertTrue("Cell should be alive", cell.getIsAlive());
		
		cell.applyConwaysLaw();
		
		assertFalse("Cell should be dead", cell.getIsAlive());
	}

	@Test
	public void aliveThreeNeighbours()
	{
		conwayCell cell = new conwayCell();
		cell.setIsAlive(true);
		cell.setNumLiveNeighbours(3);
		assertTrue("Cell should be alive", cell.getIsAlive());
		
		cell.applyConwaysLaw();
		
		assertTrue("Cell should be alive", cell.getIsAlive());
	}

	@Test
	public void deadThreeNeighbours()
	{
		conwayCell cell = new conwayCell();
		cell.setIsAlive(false);
		cell.setNumLiveNeighbours(3);
		assertFalse("Cell should be dead", cell.getIsAlive());
		
		cell.applyConwaysLaw();
		
		assertTrue("Cell should be alive", cell.getIsAlive());
	}
	
}

