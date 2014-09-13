//Author: David McKay
//Date: 9/13/2014

// Trying to help with rock paper scissor with creating my own
//  version. Since seeing other examples can help with GUI programming.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayerStatistic extends JPanel{

	// Instance Variables:
	//---------------------------------------------------------------------------|

	private JLabel winLabel;
	private JTextField winField;

	private JLabel losesLabel;
	private JTextField losesField;

	//---------------------------------------------------------------------------|

	// Class CONSTANTS:
	//---------------------------------------------------------------------------|

	final public static Dimension textFieldDimension = new Dimension( 435, 16 );
	final public static Dimension textAreaDimension = new Dimension( 435, 100);

	final public static Font textFieldFont = new Font("Lucida Console" , Font.PLAIN, 12);
	final public static Font textAreaFont = new Font("Lucida Console" , Font.PLAIN, 12);

	//---------------------------------------------------------------------------|

	// Constructor:
	//---------------------------------------------------------------------------|

	public PlayerStatistic( ){

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

		winLabel = new JLabel( "Total Wins:" );
		winField = new JTextField( "0" );

		losesLabel = new JLabel( "Total Loses:" );
		losesField = new JTextField( "0" );

		winField.setMaximumSize( textFieldDimension );
		winField.setMinimumSize( textFieldDimension );
		winField.setFont( textFieldFont );
      winField.setEditable( false );

		losesField.setMaximumSize( textFieldDimension );
		losesField.setMinimumSize( textFieldDimension );
		losesField.setFont( textFieldFont );
      losesField.setEditable( false );

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
		      .addComponent( winLabel )
		      .addComponent( losesLabel ));

		hGroup.addGroup(layout.createParallelGroup()
		      .addComponent( winField )
		      .addComponent( losesField ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( winLabel )
		      .addComponent( winField ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( losesLabel )
		      .addComponent( losesField ));

		//--------------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}

	//---------------------------------------------------------------------------|

	// Accessor:
	//---------------------------------------------------------------------------|

	public String getWinField( ){

		return( winField.getText() );
	}

	public String getLosesField( ){

		return( losesField.getText() );
	}

	//---------------------------------------------------------------------------|

	// Mutator:
	//---------------------------------------------------------------------------|

	public void setWinField( String text ){
		winField.setText( text );
	}

	public void setLosesField( String text ){
		losesField.setText( text );
	}

	//---------------------------------------------------------------------------|

	// Private Implementation:
	//---------------------------------------------------------------------------|

	public static void main(String[] args){
		JFrame runGUI = new JFrame( );
		JScrollPane scrollPlayerStatistic = new JScrollPane( new PlayerStatistic( ) );
		runGUI.add( scrollPlayerStatistic );
		runGUI.setSize( 810, 980 );
		runGUI.setTitle( "Testing the Automated PlayerStatistic." );
		runGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		runGUI.setVisible( true );
	}

	//---------------------------------------------------------------------------|
}
