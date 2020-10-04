package test;
import java.io.FileReader;  
import com.opencsv.CSVReader; //To read perform some operation on the .CSV file. 
public class TestCV { 
	public static void main (String []args)
	{
		CSVReader reader = null;  
		String str[]=new String[50];//To store all the service id value 
		String strx[]=new String[10];//To store Unique value of service id 
		int []count =new int [10];//To store the count.
		int k=0;
		try  
		{  
		//parsing a CSV file into CSVReader class constructor  
		reader = new CSVReader(new FileReader("G:\\logs.csv"));  
		String [] nextLine;  
		//reads one line at a time  
		while ((nextLine = reader.readNext()) != null)  
		{  
		
		for(String token : nextLine)  
		{  
			if(token.length()!=0)
			{
			int index=token.indexOf("serviceId")+13;
			int index2=index+6;
			str[k]=token.substring(index, index2);
			k++;
			}
		}
		} 
		str[k]=null; 
		int a=0;
		strx[a]=str[0];  
		//To identify the unique service count value. 
	    for (int x=1; str[x]!=null; x++)  
	    { 
	       int y = 0; 
	        for (y = 0; y < x; y++) 
	            if (str[x].equalsIgnoreCase(str[y]) ) 
	                break; 
	        if (x == y) 
	        {
	        	a++;
	            strx[a]=str[x]; 
	        }
	    } 
		strx[++a]=null;
		int f=0;
		//To find the count
		for(int d=0;strx[d]!=null;d++)
		{
			for(int e=0;str[e]!=null;e++)
			{
				if(strx[d].equalsIgnoreCase(str[e]))
				{
					count[f]++;
				}
			}
			f++;
		}
		// To print result
			for(int e=0;strx[e]!=null;e++)
			{
			System.out.print(str[e]+" = ");
			System.out.println(count[e]);
			}
		}  
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
	}   
}
