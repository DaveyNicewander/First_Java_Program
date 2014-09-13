//Author: David McKay
//Date: 9/13/2014

// Computer Interaction

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ComputerTurn extends JPanel{

	// Instance Variables:
	//---------------------------------------------------------------------------|

	private JLabel computerTurnLabel;
	private JTextField computerTurnField;

	//---------------------------------------------------------------------------|

	// Class CONSTANTS:
	//---------------------------------------------------------------------------|

	final public static Dimension textFieldDimension = new Dimension( 435, 16 );
	final public static Dimension textAreaDimension = new Dimension( 435, 100);

	final public static Font textFieldFont = new Font("Lucida Console" , Font.PLAIN, 12);
	final public static Font textAreaFont = new Font("Lucida Console" , Font.PLAIN, 12);
  
  final public static String ROCK = "rock";
  final public static String PAPER = "paper";
  final public static String SCISSOR = "scissor";
  
	//---------------------------------------------------------------------------|

	// Constructor:
	//---------------------------------------------------------------------------|

	public ComputerTurn( ){

		//Setting the layout:
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);

		//Initializing Group Layout:
		//--------------------------------------------------------------------------|
		// Turn on automatically adding gaps between components
		layout.setAutoCreateGaps(true);

		// Turn on automatically creating gaps between components that touch
		// the edge of the container and the container.
		layout.setAutoCreateContainerGaps(true);

		// Create a sequential group for the horizontal axis.
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

		// Create a sequential group for the vertical axis.
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

		//--------------------------------------------------------------------------|

		//Initializing Object:( Automated )
		//--------------------------------------------------------------------------|

		computerTurnLabel = new JLabel( "" );
		computerTurnField = new JTextField( );

		computerTurnField.setMaximumSize( textFieldDimension );
		computerTurnField.setMinimumSize( textFieldDimension );
		computerTurnField.setFont( textFieldFont );

		//--------------------------------------------------------------------------|

		//Setting the Components in the Group to make a Line: 1 2 ... (Automated)
		//--------------------------------------------------------------------------|

		//Setup the Group Connections Here.
		//Hint: When Implementing it goes like this.

		//	hGrp	hGrp	hGrp	hGrp
		//	1	2	3	4	   verticalGroup
		//	5	6	7	8	   verticalGroup
		//	9	10	11	12	   verticalGroup

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( computerTurnLabel ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( computerTurnField ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( computerTurnLabel )
		      .addComponent( computerTurnField ));

		//--------------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}

	//---------------------------------------------------------------------------|

	// Accessor:
	//---------------------------------------------------------------------------|

	public String getComputerTurnField( ){

		return( computerTurnField.getText() );
	}

	//---------------------------------------------------------------------------|

	// Mutator:
	//---------------------------------------------------------------------------|

	public void setComputerTurnField( String text ){
		computerTurnField.setText( text );
	}

	//---------------------------------------------------------------------------|

	// Private Implementation:
	//---------------------------------------------------------------------------|
  
  public String getTurn( ){
    
    String randomMove [] = { ROCK, PAPER, SCISSOR };
    Random rand = new Random( );
    
    return( randomMove[rand.nextInt(3));
  }
  
	public static void main(String[] args){
		JFrame runGUI = new JFrame( );
		JScrollPane scrollComputerTurn = new JScrollPane( new ComputerTurn( ) );
		runGUI.add( scrollComputerTurn );
		runGUI.setSize( 810, 980 );
		runGUI.setTitle( "Testing the Automated ComputerTurn." );
		runGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		runGUI.setVisible( true );
	}

	//---------------------------------------------------------------------------|
}
