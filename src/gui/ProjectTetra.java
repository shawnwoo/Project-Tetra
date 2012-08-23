package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class ProjectTetra extends JPanel implements ActionListener {

	private final int NUM_IMAGES = 8;
	private final int CELL_SIZE = 30;

	private final int rows = 5;
	private final int cols = 10;

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
	private int step=0;

	private int[][] field;
	private Location[][] loc;
	LocationStateFactory factory = new LocationStateFactory();

	
	private Base mapBase;
	private Base heroBase;
	private Base vaderBase;
	
	private final int[] MAPBASE_LOC={1,1};
	
	private StarMapInterface starMap1;
	private StarMapInterface starMap2;
	private StarMapInterface starMap3;
	private StarAtlas starAtlas;
	
	private TRover rover1;
	private TRover rover2;
	private final int[] ROVER1_LOC={1,4};
	private final int[] ROVER2_LOC={3,6};
	
	public ProjectTetra() {

		img = new Image[NUM_IMAGES];

		// load image to img array

		for (int i = 0; i < NUM_IMAGES; i++) {
			img[i] = (new ImageIcon(this.getClass().getResource(i + ".png")))
					.getImage();
		}
		
		loc=new Location[rows][cols];
		//setDoubleBuffered(true);
		
		initGame();
        
	

		newGame();
		timer=new Timer(2500,this);
		timer.start();

	}

	private void initGame() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				loc[i][j] = new RectangleLocation(i, j);
				loc[i][j].setState(factory.factory(new EmptyState()));

			}
		}
	}
	
	private void addBase(){
		starMap1=new StarMap();
		starMap2=new StarMap();
		starMap3=new StarMap();
		starAtlas=new StarAtlas();
		
	
		starAtlas.add(starMap1);
		starAtlas.add(starMap2);
		starAtlas.add(starMap3);
		
		mapBase=new MapBase(starAtlas);
		Location mapBaseloc=new RectangleLocation(MAPBASE_LOC[0],MAPBASE_LOC[1]);
		mapBaseloc.setBase(mapBase);
		mapBaseloc.setState(factory.factory(new MapBaseState()));
		loc[MAPBASE_LOC[0]][MAPBASE_LOC[1]]=mapBaseloc;
		
		System.out.println("Step1: Add bases!");
		
	}
	
	private void addRover(){
		TRoverFactory roverFactory=new TRoverFactory();
		rover1=(TRover) roverFactory.maleFactory();
		rover2=(TRover) roverFactory.femaleFactory();
		
		Location rover1Loc=new RectangleLocation(ROVER1_LOC[0],ROVER1_LOC[1]);
		Location rover2Loc=new RectangleLocation(ROVER2_LOC[0],ROVER2_LOC[1]);
		
		rover1.setInitLocation(rover1Loc);
		rover2.setInitLocation(rover2Loc);
		rover1Loc.setState(factory.factory(new TRoverState()));
		rover2Loc.setState(factory.factory(new TRoverState()));
		
		loc[ROVER1_LOC[0]][ROVER1_LOC[1]]=rover1Loc;
		loc[ROVER2_LOC[0]][ROVER2_LOC[1]]=rover2Loc;
		
		System.out.println("Step2: Add Rovers!");
		
	}
	

	private void newGame() {
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
        step+=1;
        if(step==1) addBase();
        if(step==2) addRover();
		
               repaint();
               
              
	}
}
