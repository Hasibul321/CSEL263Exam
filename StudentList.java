import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args)
	 {

		Constant cons = new Constant();

//		Check arguments
	 	 if(args.length!=1)
	 	 {
	 	 	System.out.println(cons.no_arguments);
	 	 }
     	else if(args[0].equals("a")) 
		{
			System.out.println( cons.data);			
			try
			 {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			    String linereader = reader.readLine();
			    String names[] = linereader.split(",");			
			    for(String name : names)
				 {
					  System.out.println(name); 
				}
			} 
			catch (Exception e)
			{

			} 
			System.out.println( cons.datal);
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try
			 {
			   BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			   String linereader = reader.readLine();
			    //System.out.println(r);
			   String names[] =  linereader.split(",");	
			   int size=names.length;
			   Random random  = new Random();
			   int index = Math.abs(random.nextInt()%size) ;
			   System.out.println(names[index]);
			} 
			catch (Exception e)
			{
				
			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");			
			try
			{
			BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
			String t = args[0].substring(1);
	        Date date = new Date();
	        String date_time = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(date_time);
	        String dateformat= dateFormat.format(date);
			writer.write(", "+t+"\nList last updated on "+dateformat);
			writer.close();
			} 
			catch (Exception e)
			{

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			String linereader = reader.readLine();
			String names[] = linereader.split(",");	
			boolean done = false;
			String argument = args[0].substring(1);
			for(int index = 0; index<names.length && !done; index++)
			 {
				if(names[index].equals(argument)) 
				{
					System.out.println("We found it!");
						done=true;
				}
			}
			}
			 catch (Exception e)
			 {

			 } 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
			String linereader = reader.readLine();
			char words[] = linereader.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char character:words)
			{ 
				if(character ==' ') 
				{
					if (!in_word)
					{	
						count++; in_word =true;
				    }
					else 
					{ 
						in_word=false;
					}			
				}
			}
			System.out.println(count +" word(s) found " + words.length);
			} 
			catch (Exception e)
			{
				
			} 
			System.out.println("Data Loaded.");				
		}
		else
		{
			System.out.println("Invalid argument ");
		}
	}
}
