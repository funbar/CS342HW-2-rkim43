import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {

	
	@Test
	public void generatedMinesTest() {
		Grid T5 = new Grid();
		
		T5.generateMines();
		int mines = 0;
		for(int i = 0; i<10; i++)
		{
			for(int j = 0; j<10; j++)
			{
				
				if(T5.grid[i][j]== 50)
					mines++;
			}
		}
		int expectedMines = 10; 
		assertEquals(expectedMines,mines);
	}

	
	//Tests the size of the grid(rows)
	@Test
	public void buildGridTest() {
		Grid T6 = new Grid();
	
		T6.buildGrid();
		int rows = T6.grid.length;
		int expectedMines = 10; 
		assertEquals(expectedMines,rows);
	}
	
	
	//Tests the size of the grid(columns)
	@Test
	public void buildGridTest2() {
		Grid T7 = new Grid();
		int col = T7.grid[0].length;
		int expectedMines = 10; 
		
		assertEquals(expectedMines,col);
	}
	
	
	//Tests the number of mines that are hidden adjacent to 
	//the current position
	@Test
	public void checkAroundMinesTest() {
		Grid T8 = new Grid();
		int mine = 50;		
		T8.grid[2][2] = mine;
		T8.grid[3][3] = mine;
		T8.checkAroundMines();
		int expected = 2;
		assertEquals(expected,T8.grid[2][3]);
	}
	
	
}
	
