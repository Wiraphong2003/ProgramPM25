import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFiles {
	String array[][] = new String[10][20];
	File fileparttxt;
	 public ReadFiles() {
		int i=0,k=1;
		
		try {
			  String fileName = "D:\\OOP\\pm2.5\\bin\\pm2.5.txt";
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		    	  String data = myReader.nextLine();
		    	  String data1[]=data.split("\t");
		    	  for(;i<k;i++)
		    	  {
		    		  for(int j=0;j<20;j++)
		    		  {
		    			  array[i][j]=data1[j];
		    		  }
		    	  }
		    	  k++;
		    	  //System.out.println(data);
		  		}
		         myReader.close();  
		    
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	String[][] getData()
	{ 
	   return array;
	}
	void settxt (File s) {
		this.fileparttxt = s;
	}
	File gettxt() {
	return this.fileparttxt;
	}

}
