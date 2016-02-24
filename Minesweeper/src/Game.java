import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener{
	// there are 10 mines in our game every time, so we need to keep track of this.
	private int mines_left = 10;
	//private int mine_exists = 1;
	private int timer = 0;
	private Grid gameGrid = new Grid();
	private JFrame frame;
	private final int rows    = 10;
	private final int columns = 10;
	private Grid gridIntBoard;
	
	
	// Declaring a 2d array for our JButtons.
	private JButton grid[][] = new JButton[rows][columns];
	
	// Constructor for our Game class.
	public Game() 
	{
		// board of ints
		gridIntBoard = new Grid();
		JPanel gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(10, 10));
		// Panel for the scoreboard.
		JPanel scoreBoard = new JPanel();
		scoreBoard.setLayout(new GridLayout(1, 3));
		
		// **
		grid = new JButton[rows][columns];
		for(int i = 0 ; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				grid[i][j] = new JButton();
				grid[i][j].addMouseListener(this);
				gameBoard.add(grid[i][j]);
 			}
		}
		
		// must be initialized first
		JMenuBar menuBar = new JMenuBar();
		// the keyword that the user sees
		JMenu gameMenu = new JMenu("Game");
		// VK_G pretty much means alt + G
		gameMenu.setMnemonic(KeyEvent.VK_G);
		
		// extension of the "Game" Menu tab
		JMenuItem exitMenuItem = new JMenuItem(new MenuItemListener("Exit", KeyEvent.VK_X));
		JMenuItem aboutMenuItem = new JMenuItem(new MenuItemListener("About", KeyEvent.VK_A));
		JMenuItem topTenMenuItem = new JMenuItem(new MenuItemListener("Top Ten", KeyEvent.VK_T));
		JMenuItem resetMenuItem = new JMenuItem(new MenuItemListener("Reset", KeyEvent.VK_R));
		JMenuItem helpMenuItem = new JMenuItem(new MenuItemListener("Help", KeyEvent.VK_L));
		
		// reset, top ten, exit
		// help, about
		// Another option at the top for "Help"
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_L);
			
		
		/*
		 * I actually tried to separate the menuBar from the constructor and call it from a method
		 * but it was giving me problems. I primarily wanted to keep the constructor clean.
		 */
		// adding everything to the actual bar. kind of like a struct and setting members
		menuBar.add(gameMenu);
		gameMenu.add(resetMenuItem);
		gameMenu.add(topTenMenuItem);
		gameMenu.add(exitMenuItem);
		helpMenu.add(helpMenuItem);
		helpMenu.add(aboutMenuItem);
		
		menuBar.add(helpMenu);

	// The "window" at the very top
		frame = new JFrame("Minesweeper");
		// controls size of entire grid.
		frame.setSize(500,  500);
		// allows the program to respond when user wants to close the frame.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
		frame.setJMenuBar(menuBar);
		frame.add(gameBoard);
		
		gridIntBoard.buildGrid();
		System.out.println(gridIntBoard.getGrid());
		
		/*
		 * use new ImageIcon ("image path in project") to add pictures instead of text
		 */
		
	}
	
	
	public void gameStart()
	{
		Grid gridBoard = new Grid();
		
		gridBoard.buildGrid();
	}
		
	private void menuBar()
	{
		/*
		 * TODO new JMenu object instance here.
		 */
	}
	
	private void gameInfoGUI()
	{
		/*
		 * # of mines, time elapsed and smiley face to reset/show information
		 * is implemented here
		 */
	}
	
	private void gameOver(){
		/*
		 * Need to display all mines to the user once the game is 
		 * won or lost.
		 */
		int gridNewIntBoard[][] = gridIntBoard.getGrid();
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				if(gridNewIntBoard[i][j] == 50)
				{
					// setIcon for images
					//System.out.println("GAME OVER");
					grid[i][j].setText("M");
					
				}			
			}
		}
	}
	
	
	private void topScores()
	{
		/*
		 * List of top scores - top 10
		 */
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// BUTTON1 = left click
		if(arg0.getButton() == arg0.BUTTON1)
		{
			for(int i = 0; i< rows; i++)
			{
				for(int j = 0; j < columns; j++)
				{
					if(grid[i][j] == arg0.getSource())
					{
						int gridNewIntBoard[][] = gridIntBoard.getGrid();
						
						/* checks to see if button is ? or M */
						
						if(gridNewIntBoard[i][j] == '?')
						{
							continue;
						}
						
						if(gridNewIntBoard[i][j] == 50)
						{
							System.out.println("EYYYYY");
							grid[i][j].setText("M");
							gameOver();
						}
						if(gridNewIntBoard[i][j] == 1)
						{
							// setIcon for images
							System.out.println("One");
							grid[i][j].setText("1");
							//grid[i][j].setBackground("GRAY");
						}
						if(gridNewIntBoard[i][j] == 2)
						{
							// setIcon for images
							System.out.println("Two");
							grid[i][j].setText("2");
						}
						if(gridNewIntBoard[i][j] == 3)
						{
							// setIcon for images
							System.out.println("Three");
							grid[i][j].setText("3");						
						}
						if(gridNewIntBoard[i][j] == 4)
						{
							// setIcon for images
							System.out.println("Four");
							grid[i][j].setText("4");
						}
						if(gridNewIntBoard[i][j] == 5)
						{
							// setIcon for images
							System.out.println("Five");
							grid[i][j].setText("5");
							
						}
						if(gridNewIntBoard[i][j] == 6)
						{
							// setIcon for images
							System.out.println("Six");
							grid[i][j].setText("6");
							
						}
						if(gridNewIntBoard[i][j] == 7)
						{
							// setIcon for images
							System.out.println("Seven");
							grid[i][j].setText("7");
							
						}
						if(gridNewIntBoard[i][j] == 8)
						{
							// setIcon for images
							System.out.println("Eight");
							grid[i][j].setText("8");
							
						}
						if(gridNewIntBoard[i][j] == 9)
						{
							// setIcon for images
							System.out.println("Nine");
							grid[i][j].setText("9");
							
						}
						
					}
				}
			}		
		}	
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
