package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class mainTest extends JFrame {
	public mainTest() {

		
		add(new ProjectTetra());
		
		setTitle("Project Tetra");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 182);
		setLocationRelativeTo(null);
	
		setVisible(true);
		setResizable(false);

	}
	public static void main(String[] args){
		new mainTest();
	}
}
