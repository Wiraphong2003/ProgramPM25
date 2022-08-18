import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.DimensionUIResource;
public class myFrame extends JFrame{
	Color n = null;
	JTextField filePath;
	JButton open,submit,royalRain,naRain,delete,submit_prat,randomPop,StoproyalRain;
	JTextField inputP;
	static boolean isStop = false;
	String stdTxt3, sFile = "0";
	// ReadFiles RF=new ReadFiles();
	String[][] info;
	int[][] INTINFO;
    Color red = new Color(247,56,34);
    Color green = new Color(51,255,141);
    Color yenllow = new Color(249,246,16);
    Color oreng = new Color(254,171,5);
    Color WHITE  = new Color(255,255,255);
    JButton backtoMenu=new JButton("Black to menu");
    JButton button[][] = new JButton[10][20];
    ImageIcon img ;
    JLabel dispay,text1,text2,text3,text4,text5,text6;
    JPanel data,PArea;
		int dataRandom, sustAmount, setText2_pop, settxt4_PD, info_j, info_i, index_Idata, index_Jdata;
    float pherNotGD;
	File selectedFile ;
	public myFrame() {
		setSize(1200,800);
		setLocationRelativeTo(null);
		setTitle("PM2.5");
		setLayout(new BorderLayout());
		PArea = new JPanel();
		PArea.setLayout(new BorderLayout());
		JPanel 		BTA=		new JPanel(new BorderLayout());
		JPanel 		buttonPanel=new JPanel(new GridLayout(10,20));
		
		JPanel P_WEST = new JPanel();
		JPanel P_EAST = new JPanel();
		JPanel P_SOUTH = new JPanel();
		JPanel P_NORTH = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0));
		JLabel name=new JLabel("PM2.5 SIMULATION");
		
		name.setForeground(new Color(222,184,55));
		P_WEST.setBackground(new Color(187, 118, 64 ));
		P_EAST.setBackground(new Color(187, 118, 64));
		P_SOUTH.setBackground(new Color(187, 118, 64));
		P_NORTH .setBackground(new Color(187, 118, 64));
		buttonPanel.setBackground(new Color(187, 118, 64));
		P_NORTH.add(name);
		
		BTA.add(buttonPanel,BorderLayout.CENTER);
		BTA.add(P_NORTH,BorderLayout.NORTH);
		BTA.add(P_SOUTH,BorderLayout.SOUTH);
		BTA.add(P_WEST,BorderLayout.WEST);
		BTA.add(P_EAST,BorderLayout.EAST);
		PArea.add(BTA,BorderLayout.CENTER);
		
		
		JPanel P_WEST2 = new JPanel();
		JPanel P_EAST2 = new JPanel();
		JPanel P_SOUTH2 = new JPanel();
		JPanel P_NORTH2 = new JPanel();
		
		setPanel(P_WEST2,50,0);
		setPanel(P_EAST2,50,0);
		setPanel(P_SOUTH2,0,50);
		setPanel(P_NORTH2,0,50);
		P_SOUTH.add(backtoMenu);
		
		PArea.add(P_WEST,BorderLayout.WEST);
		PArea.add(P_EAST,BorderLayout.EAST);
		PArea.add(P_SOUTH,BorderLayout.SOUTH);
		PArea.add(P_NORTH,BorderLayout.NORTH);
		
		JPanel P_PreS = new JPanel(new BorderLayout());
		P_PreS.setBackground(new Color(165, 165, 165 ));
		P_PreS.setPreferredSize(new Dimension(300,800));
		
		img = new ImageIcon(getClass().getResource("img2.jpg"));
		dispay = new JLabel(img);
		
		JPanel east	=	new JPanel();	east.setPreferredSize(new DimensionUIResource(0, 0));
		JPanel textR=	new JPanel(new BorderLayout());
		JPanel buttonP=	new JPanel(new FlowLayout(FlowLayout.CENTER,12,5));
		
		data = new JPanel(new BorderLayout());
		data.setBackground(new Color(165, 165, 165 ));
		P_PreS.add(data,BorderLayout.NORTH);
		buttonP.setBackground(new Color(165, 165, 165 ));
	    royalRain=new JButton("Artificial Rain");
	    StoproyalRain= new JButton("Stop");
	    StoproyalRain.setVisible(false);
		naRain=new JButton("Natural rain");
		
		data.add(dispay,BorderLayout.NORTH);
		buttonP.add(royalRain);
		buttonP.add(StoproyalRain);
		buttonP.add(naRain);
		textR.add(buttonP,BorderLayout.NORTH);
		
		JPanel openFile=new JPanel(new FlowLayout(FlowLayout.CENTER,12,5));
		openFile.setBackground(new Color(165, 165, 165 ));
		filePath = new JTextField();
		filePath.setPreferredSize(new Dimension(220,20));
		open = new JButton("Open file");
		//open.setPreferredSize(new Dimension(200,20));
		
		
		delete = new JButton("Delete");
		submit_prat = new JButton("Submit");
		openFile.add(filePath);
		openFile.add(open);
		openFile.add(delete);
		openFile.add(submit_prat);
		JLabel JBNULL = new JLabel("               ");
		JBNULL.setPreferredSize(new Dimension(200, 20)); //////////////
		openFile.add(JBNULL);
	
		inputP=new JTextField("input poulation ");
		inputP.setPreferredSize(new Dimension(200, 20));
		submit=new JButton("submit");
		submit.setPreferredSize(new Dimension(100,20));
		randomPop = new JButton("Random");
		randomPop.setPreferredSize(new Dimension(100,20));
		openFile.add(inputP);
		openFile.add(submit);
		openFile.add(randomPop);
		textR.add(openFile,BorderLayout.CENTER);
		JPanel BGS=new JPanel();
		BGS.setBackground(new Color(165, 165, 165 ));
		BGS.setPreferredSize(new Dimension(250, 150));
		P_PreS.add(textR,BorderLayout.CENTER);
		P_PreS.add(BGS,BorderLayout.SOUTH);
		
		JPanel detail=new JPanel();
		detail.setPreferredSize(new Dimension(300,200));
		detail.setBackground(new Color(165, 165, 165 ));
		detail.setLayout(null);
		
		text1 = new JLabel("Detail");
		Font F1 = new Font("Comic sans MS",Font.BOLD,25);
		text1.setFont(F1);
		text1.setBounds(100,-100,250,250);
		text1.setForeground(new Color(255,255,255));
		detail.add(text1);
		JLabel Line = new JLabel("_________________________________");
		Line.setBounds(12,-80,250,250);
		Line.setForeground(new Color(255,255,255));
		detail.add(Line);
		
		text2 = new JLabel("Populace: " + getTxt2_pop());
		text2.setBounds(10,-60,250,250);
		text2.setForeground(new Color(255,255,255));
		detail.add(text2);
		
		text3 = new JLabel("Dust amount : " + gettxt3_dust());
		text3.setBounds(10,-40,250,250);
		text3.setForeground(new Color(255,255,255));
		detail.add(text3);
		
		text4 = new JLabel("Good Populace : " + count_popgood());
		text4.setBounds(10,-20,250,250);
		text4.setForeground(new Color(255,255,255));
		detail.add(text4);
		
		text5 = new JLabel("Not Good Populace : " + getNGPopulace());
		text5.setBounds(10,0,250,250);
		text5.setForeground(new Color(255,255,255));
		detail.add(text5);
		
		text6 = new JLabel("Not Good Populace : " + getpherNotGD() + "%");
		text6.setBounds(10,20,250,250);
		text6.setForeground(new Color(255,255,255));
		detail.add(text6);
		
		data.add(detail,BorderLayout.CENTER);
		
		backtoMenu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			    setVisible(false);
				indexFrames index = new indexFrames();
			}
	     });
		
        open.addActionListener(new  ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				String str,sub;
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					 selectedFile = jfc.getSelectedFile();
					System.out.println(selectedFile.getAbsolutePath());
					str =selectedFile.getAbsolutePath();
					sub = str.substring(str.length()-4, str.length());
					System.out.println(sub);
					if (sub.equalsIgnoreCase(".txt")) {
						filePath.setText(selectedFile.getAbsolutePath());
						setFiles(str);
					}else {
						filePath.setText("Not a TXT file, please select a new file.");
						System.err.println("Not txt");
						setFiles(null);
					}
				}		
			}
		 });
        
        delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		filePath.setText("");
        	}
        });
        
		submit_prat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
				String array[][] = new String[10][20];
        		System.out.println("SP:  "+getFiles());
				int i = 0, k = 1;
				try {
					String fileName = getFiles();
					if (getFiles() == null) {
						System.out.println("Null getFile");
					} else {
						File myObj = new File(fileName);
						Scanner myReader = new Scanner(myObj);
						while (myReader.hasNextLine()) {
							String data = myReader.nextLine();
							String data1[] = data.split("\t");
							for (; i < k; i++) {
								for (int j = 0; j < 20; j++) {
									array[i][j] = data1[j];
									setDataINFO(array, i, j);
									System.out.println(i + "\t" + j + "\t" + array[i][j]);
									setColor();
								}
							}
							k++;

						}
						myReader.close();
					}
				} catch (FileNotFoundException err) {
					System.out.println("An error occurred.");
					ErrorButton erb = new ErrorButton();
					erb.setVisible(true);
				}
        	}
        });
		
        submit.addActionListener(new  ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				try {
 				int number=Integer.parseInt(inputP.getText());
 				//text2.setText("populace: "+number);
 				setTxt2_Pop(number);
 				text2.setText("populace: "+getTxt2_pop());
 				text4.setText("Good Populace : "+count_popgood());
 				text5.setText("Not Good Populace : "+getNGPopulace());
 				text6.setText("Not Good Populace : "+getpherNotGD()+"%");
 				System.out.println("N "+getTxt2_pop());
 				setColor();
 				
				} catch (Exception e2) {
					System.out.println("ERROR submit");
				}
 			}
 		});
        
        randomPop.addActionListener(new  ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				Random rand = new Random();
 				 try {
 					String[] s=inputP.getText().split("-");
 					int	min = Integer.parseInt(s[0]);
 					int max = Integer.parseInt(s[1]);
 					int range = max - min + 1;
 					int Nranddom = (int)(Math.random() * range) + min;

 					setTxt2_Pop(Nranddom);
 					text2.setText("populace: "+getTxt2_pop());
 					text4.setText("Good Populace : "+count_popgood());
 					text5.setText("Not Good Populace : "+getNGPopulace());
 					text6.setText("Not Good Populace : "+getpherNotGD()+"%");
 					System.out.println("RD: "+getTxt2_pop());
 					
				} catch (Exception e2) {
					System.out.println("ERROR RANDOM");
				}
 			}
 		});
       
        naRain.addActionListener(new  ActionListener(){
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				Narain();
  			}
  		});
 
        royalRain.addActionListener(new  ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {        	
                 
                 isStop = true;
                 
                 royalRain.setVisible(false);
                 StoproyalRain.setVisible(true);
                 
                 if (isStop) {
        			buttonSet(); 		
        		 } 
                 StoproyalRain.addActionListener(new  ActionListener(){
           			@Override
          			public void actionPerformed(ActionEvent e) {
           				royalRain.setVisible(true);
           				StoproyalRain.setVisible(false);
           				isStop = false;	
          			}
          		});
                 
            }
        });
        
       //color set button
      		for (int i = 0; i < 10; i++) {
      			for(int j=0;j<20;j++){	

						if (getpherNotGD() < 0) {
							n = WHITE;
						} else if (getpherNotGD() <= 50) {
							n = green;
						} else if (getpherNotGD() <= 100) {
							n = yenllow;
						} else if (getpherNotGD() <= 150) {
							n = oreng;
						} else if (getpherNotGD() <= 250) {
							n = red;
						} else {
							n = WHITE;
						}
	
      				button[i][j] = new JButton();
					button[i][j].setBackground(n);
      				buttonPanel.add(button[i][j]);
      				final Integer I=new Integer(i);
      				final Integer J=new Integer(j); 
						ErrorButton BER = new ErrorButton();
      				button[i][j].addActionListener(new  ActionListener(){
      					@Override
      					public void actionPerformed(ActionEvent e) {
								try {
									index_Idata = I;
									index_Jdata = J;
									text3.setText("Dust amount : " + getDATAINFO());
									text4.setText("Good Populace : " + getTxt2_pop());
									text5.setText("Not Good Populace : " + getNGPopulace());
									text6.setText("Not Good Populace : " + getpherNotGD() + "%");
									System.out.println("DUST: " + getDATAINFO() + "\n");
									System.out.println("index I J " + index_Idata + "\t" + index_Jdata);
								} catch (Exception ee) {
									System.out.println("Avtion Button Error");

								}

      					}
      				});
      			}
      		}

	add(P_PreS,BorderLayout.EAST);
	add(PArea,BorderLayout.CENTER);
	}//con

	void buttonSet()
	{
	    //isStop=false;
	    //if(!isStop)
	    //{
	    for(int i=0;i<10;i++)
	    {
	        for(int j=0;j<20 ;j++)
	        {
	            final Integer I=new Integer(i);
	                  
	                   final Integer J = new Integer(j);
	                        button[i][j].addActionListener(new  ActionListener(){
	                          @Override
	                          public void actionPerformed(ActionEvent e1) {
	                              int num;
	                              num=Integer.parseInt(info[I][J])*50/100;
	                              info[I][J]=""+num;
	                           if(I-1>=0)
	                           {
	                               num=Integer.parseInt(info[I-1][J])*30/100;
	                               info[I-1][J]=""+num;
	                               
	                               
	                           }
	                           if(J+1<=20-1)
	                           {
	                               num=Integer.parseInt(info[I][J+1])*30/100;
	                               info[I][J+1]=""+num;
	                           }
	                           if(I+1<=10-1)
	                           {
	                               num=Integer.parseInt(info[I+1][J])*30/100;
	                               info[I+1][J]=""+num;
	                           }
	                           if(J-1>=0)
	                           {
	                               num=Integer.parseInt(info[I][J-1])*30/100;
	                               info[I][J-1]=""+num;
	                           }
	                           if(I-1>=0 && J-1>=0)
	                           {
	                               num=Integer.parseInt(info[I-1][J-1])*30/100;
	                               info[I-1][J-1]=""+num;
	                           }
	                           if(I-1>=0 && J+1<=20-1)
	                           {
	                               num=Integer.parseInt(info[I-1][J+1])*30/100;
	                               info[I-1][J+1]=""+num;
	                           }
	                           if(I+1<=10-1 && J-1>=0)
	                           {
	                               num=Integer.parseInt(info[I+1][J-1])*30/100;
	                               info[I+1][J-1]=""+num;
	                           }
	                           if(I+1<=10-1 && J+1<=20-1)
	                           {
	                               num=Integer.parseInt(info[I+1][J+1])*30/100;
	                               info[I+1][J+1]=""+num;
	                               
	                               
	                           }              
	                           setColor();
	                           //isStop=false;
	                       }
	                   }); 
	        	}
	    	}
	    //} /if
	}
         
	void setDataINFO(String array[][], int i, int j) {
		this.index_Idata = i;
		this.index_Jdata = j;
		info = array;
	}

	String getDATAINFO() {
		try {
			return this.info[index_Idata][index_Jdata];
		} catch (Exception e) {
			System.out.println("ERROR getDATAINFO()");
		}
		return sFile;

	}
	float getpherNotGD() {
		float result = 0f;
		int Pop =	getTxt2_pop();
		int NGP = getNGPopulace();
		result=	(float)NGP /Pop*100f;
		System.out.println("% Not good :"+result);
		return result;
	}
	int getNGPopulace() {
		int Pop =	getTxt2_pop(); // 5000
		int Dust = gettxt3_dust();
		float NGPop,x;
		int N=0;
		if (Dust<50) {
			x=9f/100;
		}
		else if (Dust <100) {
			x=19f/100;
		}
		else if(Dust <150) {
			x=29f/100;
		}
		else if(Dust <250) {
			x = 50f/100;
		}
		else {
			x=0;
		}
		NGPop = (float)Pop*x;
		N = (int)NGPop;
		// System.out.println("NGPOP: "+NGPop);
		System.out.println("NGPOP_int: "+N);
		return N;
	}
	int count_popgood() { 
		int result=0;
		result = getTxt2_pop() - getNGPopulace();
		return result;
	}
	
	void settxt3_dust(String std) {
		this.stdTxt3 = std;
	}
	int gettxt3_dust() {
		int N = Integer.parseInt(getDATAINFO());
		return N;
	}
	
	void setTxt2_Pop(int N) {
		this.setText2_pop = N;
	}
	int getTxt2_pop() {
		return setText2_pop;
	}
	
	void setFiles(String s) {
		this.sFile = s;
	}
	String getFiles() {
		return this.sFile;
	}
	void setdataRandom(int N) {
		this.dataRandom = N;
	}
	int getdataRandom() {
		return this.dataRandom;
	}
	void setPanel(JPanel P,int w,int h)
	{
		P.setBackground(new Color(222,184,135));
		P.setPreferredSize(new Dimension(w,h));
	}
	void Narain(){ 
		try {	
  				for(int i=0;i<10;i++)
  				{
  					for(int j=0;j<20;j++)
  					{
  						int num=Integer.parseInt(info[i][j])*50/100;
  						if(num<0)
  						{
  							num=0;
  						}
  						info[i][j]=""+num;
  					 
  						setColor();	
  					}
  				}
  				
		} catch (Exception e2) {
 			System.out.println("ERROR");
 		}
	}
	
	void setColor()
	{
		try {	
			for(int i=0;i<10;i++)
				{
					for(int j=0;j<20;j++)
					{
						if (Integer.parseInt(info[i][j])>=0 && Integer.parseInt(info[i][j])<=250) {
							if(Integer.parseInt(info[i][j])<=50)
							{
								button[i][j].setBackground(green);
							}
							else if(Integer.parseInt(info[i][j])<=100)
							{
								button[i][j].setBackground(yenllow);
							}
							else if (Integer.parseInt(info[i][j])<=150)
							{
								button[i][j].setBackground(oreng);
							}
							else if (Integer.parseInt(info[i][j])<=250)
							{
								button[i][j].setBackground(red);
							}
							else {
								button[i][j].setBackground(WHITE);
							}		
						}
					}
				}	
	} catch (Exception e2) {
			System.out.println("ERROR");
		}
	}
}//myFrame

class ErrorButton extends JFrame {
	ErrorButton() {
		setSize(200, 100);
		setLocationRelativeTo(null);
		JPanel P1 = new JPanel();
		JLabel L1 = new JLabel("      Button Not Data     ");
		JButton B1 = new JButton("clore");
		P1.add(L1);
		P1.add(B1);
		add(P1);
		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
