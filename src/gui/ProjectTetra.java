package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import base.*;

import roles.*;
import starMap.*;
import surface.*;

public class ProjectTetra extends JPanel implements MouseListener {

	private final int NUM_IMAGES = 8;
	private final int CELL_SIZE = 30;

	private final int rows = 20;
	private final int cols = 30;

	private final int EMPTY = 0;
	private final int RIVER = 1;
	private final int HEROBASE = 2;
	private final int VADERBASE = 3;
	private final int ROVER = 4;
	private final int HERO = 5;
	private final int VADER = 6;
	private final int MAPBASE = 7;

	private Image[] img;
	private Timer timer;
	private int step = 0;

	private int[][] field;
	private Location[][] loc;
	LocationStateFactory factory = new LocationStateFactory();

	private Base mapBase;
	private Base heroBase;
	private Base vaderBase;

	private final int[] MAPBASE_LOC = { 10, 15 };
	private final int[] HEROBASE_LOC = { 0, 2 };
	private final int[] VADERBASE_LOC = { VaderBase.X_VADER_BASE,
			VaderBase.Y_VADER_BASE };

	private StarMapInterface starMap1;
	private StarMapInterface starMap2;
	private StarMapInterface starMap3;
	private StarAtlas starAtlas;

	private TRover rover1;
	private TRover rover2;
	private THero hero1;
	private TVader vader1;
	private final int[] ROVER1_LOC = { 1, 4 };
	private final int[] ROVER2_LOC = { 3, 6 };
	private final int[] VADER_LOC = { 12, 12 };

	public ProjectTetra() {

		img = new Image[NUM_IMAGES];

		// load image to img array

		for (int i = 0; i < NUM_IMAGES; i++) {
			img[i] = (new ImageIcon(this.getClass().getResource(i + ".png")))
					.getImage();
		}

		loc = new Location[rows][cols];
		// setDoubleBuffered(true);

		initGame();
		
		addMouseListener(this);
		

	}

	private void initGame() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				loc[i][j] = new RectangleLocation(i, j);
				loc[i][j].setState(factory.factory(new EmptyState()));

			}
		}
	}

	private void addBase() {
		starMap1 = new StarMap();
		starMap2 = new StarMap();
		starMap3 = new StarMap();
		starAtlas = new StarAtlas();
		
		starMap1.getHeader().setID("starMap1");
		starMap2.getHeader().setID("starMap2");
		starMap3.getHeader().setID("starMap3");
		starMap1.setDirections("Directions to Planet Earth from Tetra");
		starMap2.setDirections("Directions to Planet Mars from Tetra");
		starMap3.setDirections("Directions to Planet Mercury from Tetra");

		starAtlas.add(starMap1);
		starAtlas.add(starMap2);
		starAtlas.add(starMap3);
		starAtlas.getHeader().setID("starAtlas");

		mapBase = new MapBase(starAtlas);

		int x = MAPBASE_LOC[0];
		int y = MAPBASE_LOC[1];
		Location mapBaseloc = loc[x][y];
		mapBaseloc.setBase(mapBase);
		mapBaseloc.setState(factory.factory(new MapBaseState()));

		System.out.println("Add Map base!");

	}

	private void addRover() {
		TRoverFactory roverFactory = new TRoverFactory();
		rover1 = roverFactory.maleFactory();
		rover2 = roverFactory.femaleFactory();

		int x1 = ROVER1_LOC[0];
		int y1 = ROVER1_LOC[1];
		Location rover1Loc = loc[x1][y1];

		int x2 = ROVER2_LOC[0];
		int y2 = ROVER2_LOC[1];

		Location rover2Loc = loc[x2][y2];
		rover1.setInitLocation(rover1Loc);
		rover2.setInitLocation(rover2Loc);
		rover1Loc.setState(factory.factory(new TRoverState()));
		rover2Loc.setState(factory.factory(new TRoverState()));

		System.out.println(" Add Rovers!");

	}

	private void addHeroBase() {
		heroBase = new HeroBase();
		int x = HEROBASE_LOC[0];
		int y = HEROBASE_LOC[1];

		Location heroBaseloc = loc[x][y];

		heroBaseloc.setBase(heroBase);
		heroBaseloc.setState(factory.factory(new THeroBaseState()));

		System.out.println("Add Hero Base!");
	}

	private void addVaderBase() {
		vaderBase = new VaderBase();
		int x = VADERBASE_LOC[0];
		int y = VADERBASE_LOC[1];
		Location vaderBaseloc = loc[x][y];
		VaderBase.loc=loc[x][y];

		vaderBaseloc.setBase(vaderBase);
		vaderBaseloc.setState(factory.factory(new TVaderBaseState()));

		System.out.println("Add VaderBase and Rivers");

		Location river1 = loc[x - 1][y];
		Location river2 = loc[x + 1][y];
		Location river3 = loc[x][y + 1];
		Location river4 = loc[x][y - 1];

		river1.setState(factory.factory(new RiverState()));
		river2.setState(factory.factory(new RiverState()));
		river3.setState(factory.factory(new RiverState()));
		river4.setState(factory.factory(new RiverState()));

	}

	private void addHero() {
		THeroFactory heroFactory = new THeroFactory();
		hero1 = heroFactory.femaleFactory();
		int x = HEROBASE_LOC[0];
		int y = HEROBASE_LOC[1];
		Location heroLoc = loc[x][y];
		hero1.setId("Super Woman");
		hero1.setHeroBase((HeroBase) heroBase);
		hero1.setCurrentLocation(heroLoc);
		hero1.setVaderBase(vaderBase);
		hero1.setEncryptStragety(new ReverseEncrypt());
		hero1.setHeroBaseLocation(heroLoc);

		System.out.println("Add a Female Hero");

	}

	private void addVader() {
		TVaderfactory vaderFactory = new TVaderfactory();

		vader1 = vaderFactory.maleFactory();
		int x = VADER_LOC[0];
		int y = VADER_LOC[1];
		Location vaderLoc = loc[x][y];
		vader1.setCurrentLocation(vaderLoc);

		System.out.println("Add a male Vader");

	}

	private void moveHero() {

		int targetX = hero1.getCurrentLocation().getAxisX() + 1;
		int targetY = hero1.getCurrentLocation().getAxisY();
		hero1.moveTo(loc[targetX][targetY]);

		System.out.println("Hero, MOVE!");
	}

	private void moveRover() {

		int targetX = rover1.getCurrentLocation().getAxisX() + 1;
		int targetY = rover1.getCurrentLocation().getAxisY();

		rover1.moveTo(loc[targetX][targetY]);
		rover2.moveTo(loc[targetX][targetY]);

		System.out.println("Rovers, Move!");

	}

	private void moveVader() {
		int targetX = vader1.getCurrentLocation().getAxisX();
		int targetY = vader1.getCurrentLocation().getAxisY() - 1;

		vader1.moveTo(loc[targetX][targetY]);

		System.out.println("Vaders, Move 1 step down!");

	}
	
	private void flyHero(){
		int targetX=hero1.getCurrentLocation().getAxisX()+5;
		int targetY=hero1.getCurrentLocation().getAxisY()+7;
		
		hero1.flyTo(loc[targetX][targetY]);
		
		System.out.println("Hero, Fly!");
		
	}
	
	private void flyVader(){
		int targetX=VADERBASE_LOC[0];
		int targetY=VADERBASE_LOC[1];
		
		vader1.flyTo(loc[targetX][targetY]);
		
		System.out.println("Vader, Fly back to Vader base!");
	}
	
	private void vaderFlyOut(){
		int targetX=vader1.getCurrentLocation().getAxisX()+1;
		int targetY1=vader1.getCurrentLocation().getAxisY();
		int targetY2=vader1.getCurrentLocation().getAxisY()+5;
		
		
		vader1.moveTo(loc[targetX][targetY1]);
		
		vader1.flyTo(loc[targetX][targetY2]);
		
		System.out.println("Vader, Fly out from Vader base!");
	}
	
	private void vaderTryToMoveToHeroLoc(){
		int targetX=hero1.getCurrentLocation().getAxisX();
		int targetY=hero1.getCurrentLocation().getAxisY();
		vader1.moveTo(loc[targetX][targetY]);
		
		System.out.println("Vader, move to a cell already has someone");
	}
	
	
	private void vaderGotoMapBase(){
	    int targetX=MAPBASE_LOC[0];
	    int targetY=MAPBASE_LOC[1];
	    int startX=vader1.getCurrentLocation().getAxisX();
	    int startY=vader1.getCurrentLocation().getAxisY();
	    
	    for(int i=startX+1;i<=targetX;i++){
	    	vader1.moveTo(loc[i][startY]);
	    };
	    
	    for (int i=startY+1;i<=targetY-1;i++){
	    	vader1.moveTo(loc[targetX][i]);
	    }
	    
	    
	    System.out.println("Vader, move to MapBase step by step!");
	    
	    
	}
	
	private void vaderEnterMapBase(){
		int targetX=MAPBASE_LOC[0];
		int targetY=MAPBASE_LOC[1];
		
		System.out.println("Vader, enter the mapbase!");
		
		vader1.moveTo(loc[targetX][targetY]);
	}
	
	private void vaderRetrace(){
		vader1.retrace();
		
		System.out.println("Vader, retrace back!");
	}
	
	private void vaderFlyToAnotherPlace(){
		int targetX=vader1.getCurrentLocation().getAxisX()+5;
		int targetY=vader1.getCurrentLocation().getAxisY()+8;
		
		vader1.flyTo(loc[targetX][targetY]);
		
		System.out.println("Vader said: I am gone!");
		
		
	}
	
	private void heroGotoMapBase(){
		int targetX=MAPBASE_LOC[0];
		int targetY=MAPBASE_LOC[1];
		int startX=hero1.getCurrentLocation().getAxisX();
		int startY=hero1.getCurrentLocation().getAxisY();
		
		for(int i=startX+1;i<=targetX;i++){
			hero1.moveTo(loc[i][startY]);
			
		}
		
		for(int j=startY+1;j<=targetY-1;j++){
			hero1.moveTo(loc[targetX][j]);
		}
		
		System.out.println("Hero, move to MapBase step by step!");
	}
	
	private void heroEnterMapBase(){
		int targetX=MAPBASE_LOC[0];
		int targetY=MAPBASE_LOC[1];
		
		hero1.moveTo(loc[targetX][targetY]);
		
		System.out.println("Hero, enter the MapBase!");
	}
	
	private void displayClonedMap(){
		
		System.out.println("Displays clone Map!");
		heroBase.getStarMap().display();
	}
	
	private void displayOriginalMap(){
		System.out.println("Display orginal Map in MapBase! ");
		mapBase.getStarMap().display();
	}
	

	public void paint(Graphics g) {
		int cell = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cell = loc[i][j].getState().getStateNum();

				g.drawImage(img[cell], (j * CELL_SIZE), (i * CELL_SIZE), this);
			}
		}

	}

	

	private void printStep(int StepNum) {
		System.out.println("********" + "Step " + StepNum + " ********");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		step += 1;

		printStep(step);

		switch (step) {
		case 1:
			addBase();
			break;
		case 2:
			addRover();
			break;
		case 3:
			addHeroBase();
			break;
		case 4:
			addVaderBase();
			break;
		case 5:
			addHero();
			break;
		case 6:
			addVader();
			break;
		case 7:
			moveHero();
			break;
		case 8:
			moveRover();
			break;
		case 9:
			moveVader();
			break;
		case 10:
			flyHero();
			break;
		case 11:
			flyVader();
			break;
		case 12:
			vaderFlyOut();
			break;
		case 13: 
			vaderTryToMoveToHeroLoc();
			break;
		case 14: 
			vaderGotoMapBase();
			break;
		case 15:
			vaderEnterMapBase();
			break;
		case 16:
			vaderRetrace();
			break;
		case 17:
			vaderFlyToAnotherPlace();;
			break;
		case 18:
			heroGotoMapBase();
			break;
		case 19:
			heroEnterMapBase();
			break;
		case 20:
			displayClonedMap();
			break;
		case 21:
			displayOriginalMap();
			break;
		default: {
			System.out.println("No more actions!");
			//timer.stop();
		}
			break;

		}

		repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
