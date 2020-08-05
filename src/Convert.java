import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStream;
import java.io.PrintStream;
//import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.logging.Formatter;

public class Convert {

	public static void main(String[] args) throws IOException {
		
		String convertToType = "";
		
		//Create the .txt file included in this package
		File textFile = new File("C:\\Users\\Bob Ross\\Desktop\\workspace\\Convertii\\M,HeatherBGDataJune5.txt");
		
		//Get file path
		String textFilePath = textFile.getAbsolutePath();
		
		//Get file extension
		String extension = "";
		
		/////////////////////////////////////////////////
		//convertToCsv(convertToType,filename);
		/////////////////////////////////////////////////
		//convert from TXT to CSV
		
		System.out.println("        ______ _ _        _____                           _ ");           
		System.out.println("	|  ___(_) |      /  __ \\                         | |");           
		System.out.println("	| |_   _| | ___  | /  \\/ ___  _ ____   _____ _ __| |_ ___ _ __"); 
		System.out.println("	|  _| | | |/ _ \\ | |    / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__|");
		System.out.println("	| |   | | |  __/ | \\__/\\ (_) | | | \\ V /  __/ |  | ||  __/ |   ");
		System.out.println("	\\_|   |_|_|\\___|  \\____/\\___/|_| |_|\\_/ \\___|_|   \\__\\hm_|_|  ");
		System.out.println("         Version 1");
		System.out.println("");
			                                                               
		                                                               
		
//////////////////////////////Step 0.) Get current file type ///////////////////////////////////////////////
			    
			    int lastIndexOf = textFilePath.lastIndexOf(".");
			    
			    if (lastIndexOf == -1) 
			    {
			    	extension = ""; // empty extension
			    } 
			    else extension = textFilePath.substring(lastIndexOf);
			    
			    System.out.println("\nStep 0.) Get current file type = " + extension);
			    
			    int extensionIndex = textFile.getName().indexOf(extension);
			    
			    ////////////////////Step 1.) Remove .txt extension and add .csv extension/////////////////
			    
			    convertToType = ".csv";
			    
			    String newFileName = textFile.getName();
			    // System.out.println("newFileName = " + textFile.getName());
			    int extensionLastIndex = newFileName.length();
			
			    
			      StringBuilder str = new StringBuilder("" + newFileName);
			     // System.out.println("newFileName = " + textFile.getName());
			    
			      // replace substring from index #extensionIndex to index #extensionLength
			      str.replace(extensionIndex, extensionLastIndex, convertToType);
			      
			      //System.out.println("str = " + str + "   extensionIndex = " + extensionIndex + "    extensionLastIndex = " + extensionLastIndex);
			      //System.out.println("convertToType = " + convertToType);
			   
			     
			      //Set the newFileName = str
			      newFileName = str.toString();
			      
			      // prints the StringBuilder after replacement
			      System.out.println("\nStep 1.) After replacment of " + textFile.getName() + ", newFileName = " + newFileName);
			    
//////////////////////////////Step 2.) Create a new .csv file....///////////////////////////////////////////
					
				//Create file
				File myObj = new File(newFileName);
				
				String myPath = "";
				
				 try {
					 
				     if ((myObj).createNewFile()) 
				     {
				    	myPath = myObj.getAbsolutePath();
				        System.out.println("\nStep 2.) File created: " + myObj.getName());
				      } 
				      else 
				      {
				        System.out.println("\nStep 2.) File already exists @ " + myObj.getAbsolutePath());
				        myPath = myObj.getAbsolutePath();
				      }
				    } 
				    catch (IOException e) 
				    {
				      System.out.println("\nStep 2.) An error occurred while creating the new file (line #79). ");
				      e.printStackTrace();
				    }
				 
				 

//////////////////////////////Step 3.) Write data from old .txt to new .csv /////////////////////////////////////			 
				
				System.out.println("\nStep 3.) Writing to new file " + myObj.getName() + " at path " + myPath);
				
				//Bucky - Read to file
				//https://www.youtube.com/watch?v=3RNYUKxAgmw
				//Bucky - Write to file
				//https://www.youtube.com/watch?time_continue=15&v=Bws9aQuAcdg&feature=emb_title
				
				////////// First, open and read from the .txt file using Scanner x.
				
				Scanner x = null;
				
				
				try {
						//This is goofy////////////////////////////////////////////////////////////////////
						
					    x = new Scanner(new FileReader(textFilePath));
						//C:\Users\Bob Ross\Desktop\workspace\Convertii\M,HeatherBGDataJune5
					    //"D:\\temp.txt"
				}
				catch(IOException | InputMismatchException ex)
				{
					System.out.println("Step 3.) Scanner Exception thrown - line #113");
				}
				
				
				/////////// Second, write to the .csv file using PrintStream y.
				//There are 5 main variables inside the txt file to read.
				
				//PrintWriter y = null;
				FileOutputStream y0 = null;
				PrintStream y = null;
				
				
				try {
					
					//PrintWriter(Writer out)
					//Creates a new PrintWriter, without automatic line flushing
					
					//y = new PrintWriter("" + newFileName);
					
					//https://www.youtube.com/watch?v=aEgiHFWUJF8
					
					y0 = new FileOutputStream(""+newFileName);
					y = new PrintStream(y0);
			
				
				//Read first 5 lines into comments
				/*for (int i = 0; i<5; i++)*/
					
				String property = System.getProperty("line.separator");
				
				//while (!(x.equals(property))) //This should read an entire line
				//{
					//Read next word
					//String comments = x.next();
					//System.out.printf("%s \n", "#" + comments);
					//System.out.println("");
					
					//Read entire line
					while (x.hasNextLine())
					{
						String comments = x.nextLine();
					
					//System.out.printf("%s \n", "#" + comments);
					
					//write each word to the newFile
					//y.format("%s \n", "# " + comments);
					
						//System.out.print("comments = " + comments );
						//y.print(comments);
						y.println("#" + comments);
					}
					
					
							
				//}
				
				System.out.println("");
				
				String internalDate = ""; /* = x.next(); */
				String internalTime = ""; /* = x.next(); */
				String externalDate = ""; /* = x.next(); */
				String externalTime = ""; /* = x.next(); */
				String bloodsugar = ""; /* = x.next(); */
				
				int lineNumber = 0;
				
				//Read the rest of the file
				while(x.hasNext())
				{
					lineNumber++;
					
					
					//https://stackoverflow.com/questions/12874791/at-java-util-scanner-throwforunknown-source-error
						if (x.hasNext()) {
											internalDate = x.next();
						
						} else {
								System.out.println("Data read error " + lineNumber + " internalTime ");
										}
						if (x.hasNext()) {
											internalTime = x.next();
											
						  } else {
					            System.out.println("Data read error " + lineNumber + " internalTime ");
					             }
						if (x.hasNext()) {
											externalDate = x.next();
											
						} else {
				            System.out.println("Data read error " + lineNumber + " externalDate ");
				        }
						if (x.hasNext()) {
											externalTime = x.next();
											
						} else {
				            System.out.println("Data read error " + lineNumber + " externalTime ");
				        }
						if (x.hasNext()) {
											bloodsugar = x.next();
											
						} else {
				            System.out.println("Data read error " + lineNumber + " bloodsugar ");
				        }
					
					//System.out.printf("%s %s %s %s %s", internalDate, internalTime, externalDate, externalTime, bloodsugar);
					//System.out.println("");
					
					//write to file using printWriter
					y.format("%s %s %s %s %s \n", internalDate, internalTime, externalDate, externalTime, bloodsugar);
					
				}
			}//end try
			catch(Exception e){
					
					System.out.println("Error writing to the new file somewhere in Step 3. Exception caught.");
					
			} //end of try/catch from line #128
			finally
			{
					//close the Scanner & PrintStream & OutputStream
				if (x != null)
				{
					x.close();
				}
				if (y != null)
				{
					y.close();
				}
				if (y0 != null)
				{
					y0.close();
				}
			}
		
		///////////////////////////////////////Step 4.) Display the file to the user //////////////////////////
				System.out.println("\n-----------------------------------------------------------------------");
				System.out.println("\n   Step 4.)" + textFile + " was converted to a " + myObj.getName() + " file.");
				System.out.println("\n-----------------------------------------------------------------------");
				
				//first check if Desktop is supported by Platform or not
				
				// https://www.journaldev.com/864/java-open-file////////////////////////
		
				        if(!Desktop.isDesktopSupported())
				        {
				            System.out.println("Desktop is not supported");
				            return;
				        }
				        else
				        {
				        	Desktop desktop = Desktop.getDesktop();
				        	
				        	//System.out.println("Desktop is supported");
				        	//let's try to open csv file
				        	if(myObj.exists()) 
				        		desktop.open(myObj);
				        }

	
	///////////////////////////////////////Step 5.) Delete this newly created File////////////////////////// 
				        
//				        String input = "";
//				        
//				        Scanner a = new Scanner(System.in);
//				        
//				        
//				        System.out.println("Step 5.) Would you like to delete the newly created csv file? Y/N");
//				        System.out.print(">>");
//				        input = a.next();
//				       //close the scanner
//				        a.close();
//				        
//				        if (input.equals("y") || input.equals("Y"))
//				        {
//				        	//String myObjPath = myObj.getAbsolutePath();
//				        	
//				        	
//				        	if (!(myObj.exists()))
//				        	{
//				        		System.out.println("\nfile: " + myObj.getName() + " Does not exist.");
//				        	}
//				        	else 
//				        	{
//				        	  
//				        		  String inputb = "k";
//				        		  Scanner b = null;
//						        
//				        		  try 
//				        		  {
//				        			  b = new Scanner(System.in);
//				        			  System.out.println("Step 5b.) Please close the excel window displaying file " + myObj.getName()+ " and enter 'x' when done.");
//				        			  System.out.print(">>");
//				        			  
//				        			  if(b.hasNext())
//				        				  inputb = b.next();
//				        			  
//				        			  //close the scanner
//				        			  b.close();
//				        		  }
//				        		  catch(InputMismatchException ex)
//				        		  {
//				        			  System.out.println("Step 5b.) Exception " +  ex);
//				        		  }
//						        
//				        		  if (inputb.equals("x"))
//						          {
//				        			  if (myObj.exists())
//				        			  {
//				        				  	myObj.delete();
//				        			  }
//				        			  if (myObj.exists())
//				        			  {
//				        				  System.out.println("\nFailed to delete the file.");
//				        			  }
//				        			  else
//				        			  {
//				        				  System.out.println("\n.CSV file was deleted.");
//				        			
//				        			  }
//						         
//						        
//				        	  }//end while
//				        	} //end else 
//				        } //if (input.equals("y") || input.equals("Y"))
//				        
//				        //This file refused to delete because I left y0 unclosed.
//				        //Total number of streams in this program are: y, y0, x, a and b.
//				        
}
	
}
