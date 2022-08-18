import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class indexFrames extends JFrame{
	public indexFrames(){
		setSize(1200,800);
		setLocationRelativeTo(null);
		setTitle("PM2.5");
		setLayout(new BorderLayout());
		
		Screen f = new Screen("m2.jpg");
	    JPanel buttonPanel =new JPanel(new FlowLayout(FlowLayout.CENTER,100,0));
	    
	    Font font=new Font("Pixeloid Sans",Font.BOLD,20);
		
	     
	     //Button
	     JButton start=new JButton("<START>");
	     JButton exit=new JButton("<EXIT>");
	     JButton credit=new JButton("<CREDIT>");
	     setButton(start,font);  
	     setButton(exit,font);
	     setButton(credit,font);
	     
	     //Button add to panel
	     buttonPanel.setBackground(new Color(222,184,135));
	     buttonPanel.add(start);
	     buttonPanel.add(credit);
	     buttonPanel.add(exit);
	     
	     f.add(buttonPanel,BorderLayout.SOUTH);
	     
	     
	     //setAction
	     start.addActionListener(new ActionListener() 
	     {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				f.setVisible(false);
				myFrame mfrmae=new myFrame();
				mfrmae.setVisible(true);
			}
	     });
	     
	     credit.addActionListener(new ActionListener() 
	     {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				f.setVisible(false);
				Credit c = new Credit();
			}
	     });
	     exit.addActionListener(new ActionListener() 
	     {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
	     });

	     f.setVisible(true);
	}
	void setButton(JButton b,Font f)
	{
		 b.setBackground(new Color(222,184,135));
	     b.setBorderPainted(false);
	     b.setFont(f);	
	     b.setForeground(new Color(169,83,0));
	     b.setPreferredSize(new Dimension(200,50));
	   
	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}//indexFrames class

class Screen extends JFrame{
	 Screen(String image1)
	  {
		     setSize(1200, 800);
		     setLayout(new BorderLayout());
			 setLocationRelativeTo(null);
			 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 setTitle("PM2.5 SIMULATION");
			 setBackground(new Color(222,184,135));
		     //Panel
		    
		     //Image Add
		     try 
		     {
		    	 JLabel text=new JLabel();
		    	 text.setText("PM2.5");
		    	 ImageIcon image=new ImageIcon(getClass().getResource(image1));
		        JLabel B=new JLabel(image);
		        add(B,BorderLayout.CENTER);
		     
		     }
		     catch (Exception e) {System.out.println("Not Found");}
			
	  }
}

class Credit {
  Credit()
  {
	Screen f=new Screen("oop.jpg");
	JPanel bigPanel=new JPanel();
	JPanel inWest=new JPanel();
	JPanel bigWest=new JPanel();
	JPanel bigEast=new JPanel();
	JPanel bigNort=new JPanel();
	
	
	bigWest.setBackground(new Color(222,184,135));
	bigEast.setBackground(new Color(222,184,135));
	bigNort.setBackground(new Color(222,184,135));
	bigPanel.setBackground(new Color(222, 184, 135));
	inWest.setBackground(new Color(222, 184, 135));
    
	bigWest.setPreferredSize(new Dimension(120,0));
	bigEast.setPreferredSize(new Dimension(200,0));
	
	Font font=new Font("Pixeloid Sans",Font.BOLD,20);
	JButton BTM=new JButton("<--Black to Menu");
	BTM.setFont(font);
	BTM.setForeground(new Color(169,83,0));
	BTM.setBackground(new Color(222,184,135));
	inWest.add(BTM,BorderLayout.WEST);
	bigPanel.add(inWest);
	
	f.add(bigPanel,BorderLayout.SOUTH);
	f.add(bigNort,BorderLayout.NORTH);
	f.add(bigEast,BorderLayout.EAST);
	f.add(bigWest,BorderLayout.WEST);
	
    //setAction
    BTM.addActionListener(new ActionListener() 
    {
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			f.setVisible(false);
			indexFrames index = new indexFrames();
		}
    });
	f.setVisible(true);	 
  }
}