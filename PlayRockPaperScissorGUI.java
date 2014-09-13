//Author: David McKay
//Date: 9/13/2014

//Not the best looking display,
// just trying to get something,
// created within 10 minutes.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayRockPaperScissorGUI extends JPanel{

	// Instance Variables:
	//---------------------------------------------------------------------------|

	private ComputerTurn computerTurn;
	private PlayerStatistic playerStat;

	private JButton rockButton;
	private JButton paperButton;
	private JButton scissorButton;
   
   private ActionListener playAction;
   
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

	public PlayRockPaperScissorGUI( ){

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

		computerTurn = new ComputerTurn( );
		playerStat = new PlayerStatistic( );

		rockButton = new JButton( "ROCK" );
		paperButton = new JButton( "PAPER" );
		scissorButton = new JButton( "SCISSORS" );
      
      playAction = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            if(e.getSource() instanceof JButton){
               JButton tempButton = (JButton) e.getSource();
               //This will get the turn of the human / robot and make the
               //correct changes!
               turn( tempButton.getText( ), computerTurn.getTurn( ) );
            }
         }
      };
      
      rockButton.addActionListener( playAction );
      paperButton.addActionListener( playAction );
      scissorButton.addActionListener( playAction );
      
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
		      .addComponent( computerTurn )
		      .addComponent( playerStat )
            .addComponent( rockButton )
		      .addComponent( paperButton )
            .addComponent( scissorButton ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( computerTurn ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( playerStat ));

		vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( rockButton ));
      
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( paperButton ));
            
      vGroup.addGroup(layout.createParallelGroup()
		      .addComponent( scissorButton ));

		//--------------------------------------------------------------------------|

		layout.setHorizontalGroup(hGroup);
		layout.setVerticalGroup(vGroup);
	}

	//---------------------------------------------------------------------------|

	// Accessor:
	//---------------------------------------------------------------------------|

	//---------------------------------------------------------------------------|

	// Mutator:
	//---------------------------------------------------------------------------|

	//---------------------------------------------------------------------------|

	// Private Implementation:
	//---------------------------------------------------------------------------|
   
   private void turn( String humanInput, String robotInput ){
      computerTurn.setComputerTurnField( robotInput );
      
      int win = new Integer( playerStat.getWinField( ) );
      int loses = new Integer( playerStat.getLosesField( ) );
      
      // Rock beats Scissors
      // Paper beats Rock
      // Scissors beats paper
      
      if( humanInput.equalsIgnoreCase( "rock" ) && robotInput.equalsIgnoreCase( "scissors" ) ){
         win++;
         
      }else if( humanInput.equalsIgnoreCase( "rock" ) && robotInput.equalsIgnoreCase( "paper" ) ){
         loses++; 
      
      }else if( humanInput.equalsIgnoreCase( "paper" ) && robotInput.equalsIgnoreCase( "rock" ) ){
         win++;
      
      }else if( humanInput.equalsIgnoreCase( "paper" ) && robotInput.equalsIgnoreCase( "scissors" ) ){
         loses++; 
      
      }else if( humanInput.equalsIgnoreCase( "scissors" ) && robotInput.equalsIgnoreCase( "paper" ) ){
         win++; 
      
      }else if( humanInput.equalsIgnoreCase( "scissors" ) && robotInput.equalsIgnoreCase( "rock" ) ){
         loses++; 
      
      }
      
      playerStat.setWinField( "" + win );
      playerStat.setLosesField( "" + loses );
   }
   
	public static void main(String[] args){
		JFrame runGUI = new JFrame( );
		JScrollPane scrollPlayRockPaperScissorGUI = new JScrollPane( new PlayRockPaperScissorGUI( ) );
		runGUI.add( scrollPlayRockPaperScissorGUI );
		runGUI.setSize( 810, 980 );
		runGUI.setTitle( "Testing the Automated PlayRockPaperScissorGUI." );
		runGUI.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		runGUI.setVisible( true );
	}

	//---------------------------------------------------------------------------|
}
