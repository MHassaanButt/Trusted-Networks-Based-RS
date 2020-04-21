
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.jar.Pack200.Packer;
import java.util.stream.Stream;

import javax.swing.JOptionPane;
import javax.swing.Spring;
public class LevelsForTrusting {
	static int Row = 0;
	static public String OutFile = "E:\\Lab Task\\Data (REC System) Paper\\Intelligent Recomender system\\code\\WorkSpace\\WorkSpace(Final)\\FilmTrust(Fill 1)\\filmtrust\\result fill 1.csv";

	public static HashMap<Long, List<Long>> map_1 = new HashMap<Long, List<Long>>();
	public static HashMap<Long, List<Long>> map_2 = new HashMap<Long, List<Long>>();
	public static HashMap<Long, List<Long>> map_3 = new HashMap<Long, List<Long>>();
	public static HashMap<Long, List<Long>> map_4 = new HashMap<Long, List<Long>>();
	public static HashMap<Long, List<Long>> map_5 = new HashMap<Long, List<Long>>();
	static long[][] InputArray;			// MAin Array where both columns data is load (double array)
	static String[][] InputArrayString = new String[10000][10000];
	static String[][] InputArrayString2 = new String[10000][10000];
	static List<CommonType> Common13=new ArrayList<CommonType>();
	static List<CommonType> Common24=new ArrayList<CommonType>();
	static List<CommonType> Common35=new ArrayList<CommonType>();
	static List<CommonType> Common14_24=new ArrayList<CommonType>();
	static int temp;
	static long[] FirstColumn;			// After removing duplication FirstColumn
	static long[] SecondColumn;			// After removing duplication SecondColumn
	static long[] FirstColumnArray;     // Before removing duplication FirstColumn
	static	long[] SecondColumnArray;	// Before removing duplication SecondColumn
	static int ValFoundT;               // Trusting values is found (use as flag)
	static int ValFoundNT;				// NotTrusting values is found (use as flag)
	static int CountT;					// Counter for Trusting values
	static int CountNT;					// Counter for NotTrusting values
	static int _Trusting=0;				// variable for trusting
	public static long[] Trusting; 		// Before removing duplication values trusting array
	static long[] TrustingArray;		// After removing duplication values trusting array
	static int Not_Trusting=0;			// variable for Not_Trusting
	public static long[] NotTrusting;   // Before removing duplication values NotTrusting array
	static long[] NotTrustingArray;		// After removing duplication values trusting array
	// for level two methods variables
	public static long[] ForLevelTwoTrusting;   // LevelTwo Trusting Array without removing duplication	
	static long[] LevelTwo;					    // LevelTwo final array which is used further and having no duplicate value
	static int secondlayercount=0;				// Counter for SecondLayerElements
	// for level three methods variables
	public static long[] ForLevelThreeTrusting;	// LevelThree Trusting Array without removing duplication	
	static long[] LevelThree;					// LevelThree final array which is used further and having no duplicate value
	static int thirdlayercount=0;				// Counter for ThirdLayerElements
	// for level four methods and variables
	public static long[] ForLevelFourTrusting;	// LevelFour Trusting Array without removing duplication
	static long[] LevelFour;					// LevelFour final array which is used further and having no duplicate value
	static int fourthlayercount=0;				// Counter for FourthLayerElements
	// for level five methods and variables
	public static long[] ForLevelFiveTrusting;	// LevelFive Trusting Array without removing duplication
	static long[] LevelFive;					// LevelFive final array which is used further and having no duplicate value
	static int fifthlayercount=0;				// Counter for FifthLayerElements
	public static long[] ForLevelSixTrusting;	// LevelFive Trusting Array without removing duplication
	static long[] LevelSix;					// LevelFive final array which is used further and having no duplicate value
	static int Sixthlayercount=0;	
	public static ArrayList<Long> se = new ArrayList<>();
	public static ArrayList<Long> se1 = new ArrayList<>();
	public static long [] selement;
	public static long [] selement1;
	public static long [] selement24;
	public static long [] selement1_24;
	public static long [] selement35;
	public static long [] selement1_35;
	public static long [] selement14_1;
	public static long [] selement1_14_1;
	public static long [] selement14_2;
	public static long [] selement1_14_2;
	//  logic 1-4
	//public static long [] selement14_34_1;
	public static long [] selement14_34;
	public static long [] selement14_23;
	public static long [] selement14_12;
	//   1-5
	public static long [] selement15_12;
	public static long [] selement15_23;
	public static long [] selement15_34;
	public static long [] selement15_45;
	// level 2-5
	public static long [] selement25_45;
	public static long [] selement25_34;
	public static long [] selement25_23;
	static HashMap<Long, List<Long>> mapss = new HashMap<Long, List<Long>>();
	// csv file 
	public static List<Long> qwlist; 
	public static List<Long> qwlist1;
	
	// temp test
	
	public static String [] TempStore1;
	public static String [] TempSingle1;
	
	public static String [] TempStore2;
	public static String [] TempSingle2;
	
	public static void main(String arg[])  {
		
		ReadCsv();								// Method for reading .CSV DataSet file and storing data in Array in the form of column 
		CheckingTrustingArray();				// Check those elements which trust other elements and stored in Trusting
		PrintingTrustingArray();				// Printing Elements which trust other elements after removing duplication (TrustingArray in which they stored)
		CheckingNotTrustingArray();				// Check those elements which are not trusting other elements and stored in NotTrusting
		PrintingNotTrustingArray();				// Printing Elements which are not trusting other elements after removing duplication (NotTrustingArray in which they stored)
		PrintingFirstLayerArray();				// This is same as PrintingTrustingArray() because our first Layer is trusting array
		CheckingSecondLayerArray();				// In this method we check that first layer elements further trusting on these elements and stored in the ForLevelTwoTrusting
		PrintingSecondLayerArray();				// we remove duplication and printing final Array of SecondLayer (LevelTwo)
        CheckingThirdLayerArray();				// In this method we check that Second layer elements further trusting on these elements and stored in the ForLevelThreeTrusting
        PrintingThirdLayerArray();         		// we remove duplication and printing final Array of ThirdLayer (LevelThree)
        CheckingFourthLayerArray();				// In this method we check that Third layer elements further trusting on these elements and stored in the ForLevelFourTrusting
        PrintingFourthLayerArray();				// we remove duplication and printing final Array of FourthLayer (LevelFour)
        CheckingFifthLayerArray();				// In this method we check that fourth layer elements further trusting on these elements and stored in the ForLevelFiveTrusting
        PrintingFifthLayerArray();				// we remove duplication and printing final Array of FifthLayer (LevelFive)

        HandlingNonTrusting();					// like 4 is handling and same like all values
        CommonElements1_3();					// common paths b/w 1-3 layer
        CommonElements2_4();					// common paths b/w 2-4 layer
        CommonElements3_5();					// common paths b/w 3-5 layer
        CommonElements1_4();					// common paths b/w 1-4 layer
        CommonElements2_5();					// common paths b/w 2-5 layer
        CommonElements1_5();					// common paths b/w 1-5 layer
          MissingValuesLayer1();
          MissingValuesLayer2();
          MissingValuesLayer3();
          MissingValuesLayer4();
          MissingValuesLayer5();
	}  // note: output can not b display all in complier so comment few last methods to view output of starting methods
	// Missing Values resolving within layer
	
	
	
	public static void MissingValuesLayer1() {
		 boolean response = UserPrint();
			
			if(response == true) {
		System.out.println("");
		System.out.println("_____Missing Values between conection of trusted by same value layer 1________");
		
		
		
		System.out.println();

		
		
		ForLevelTwoTrusting = new long [Row];
		List<Long> list;
		for(int chk =0;chk<TrustingArray.length;chk++) {
			list = new ArrayList<Long>();
			for (int row2=0;row2<Row;row2++) 
			{
				if(TrustingArray[chk] == InputArray[row2][0]) {
					list.add(InputArray[row2][1]);
				}
			}
			map_1.put(TrustingArray[chk], list );
		}
		System.out.println("Following are First Layer Elements which futher trust these elements: ");
		System.out.println();
		for(Map.Entry<Long, List<Long>> entry :  map_1.entrySet()) {
			long key = entry.getKey();
			List<Long> value = entry.getValue();
			System.out.println(key + " is trusting following elements: " + value );
			List<Long> arrayOfList = null;
			List<Long> B = null;
			 arrayOfList= value;
			 if(arrayOfList.size()>1) {
			System.out.println(arrayOfList);
			
			for(int a=0; a<arrayOfList.size(); a++) {
				for(int b=a; b<arrayOfList.size(); b++) {
					
					if(a!=b) {
					System.out.println("this is result "+arrayOfList.get(a)+"   "+arrayOfList.get(b));
					try {
						FileWriter fw = new FileWriter(OutFile, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						boolean csvResult = chkCsvData((+arrayOfList.get(a)),(+arrayOfList.get(b)));
						
						
						if (csvResult == true) {
							 pw.println(arrayOfList.get(a) +","+ arrayOfList.get(b) + "," + "1" );
						}
					   
					    
						pw.flush();
						pw.close();
					//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
					}
					catch(Exception E) {
						
						JOptionPane.showMessageDialog(null, "No Saved");
					}
					}
					}
					}
				 }
			}
		System.out.println("Values of this function is Filled in datasets");
			}
				
	
	if(response==false) {
		 System.out.println("Values of this function is not Filled in datasets");
	}
		}
// for layer 2
	public static void MissingValuesLayer2() {
		 boolean response = UserPrint();
			
			if(response == true) {
				System.out.println("");
				System.out.println("_____Missing Values between conection of trusted by same value layer 2________");
				
				
				
				System.out.println();

				
				ForLevelThreeTrusting = new long [Row];
				List<Long> list;			
				for(int chk =0;chk<LevelTwo.length;chk++) {			
					list = new ArrayList<Long>();
					for (int row3=0;row3<Row;row3++) 
					{
						if(LevelTwo[chk] == InputArray[row3][0]) {
							list.add(InputArray[row3][1]);
						}
					}
					map_2.put(LevelTwo[chk], list );
				}
				System.out.println("Following are Second Layer Elements which futher trust these elements: ");
				System.out.println();
				for(Map.Entry<Long, List<Long>> entry :  map_2.entrySet()) {
					long key = entry.getKey();
					List<Long> value = entry.getValue();
					
					System.out.println(key + " is trusting following elements: " + value );
					List<Long> arrayOfList = null;
					List<Long> B = null;
					 arrayOfList= value;
					 if(arrayOfList.size()>1) {
					System.out.println(arrayOfList);
					
					for(int a=0; a<arrayOfList.size(); a++) {
						for(int b=a; b<arrayOfList.size(); b++) {
							
							if(a!=b) {
							System.out.println("this is result "+arrayOfList.get(a)+"   "+arrayOfList.get(b));
							try {
								FileWriter fw = new FileWriter(OutFile, true);
								BufferedWriter bw = new BufferedWriter(fw);
								PrintWriter pw = new PrintWriter(bw);
								
								boolean csvResult = chkCsvData((+arrayOfList.get(a)),(+arrayOfList.get(b)));
								
								
								if (csvResult == true) {
									 pw.println(arrayOfList.get(a) +","+ arrayOfList.get(b) + "," + "1" );
								}
							   
							    
								pw.flush();
								pw.close();
							//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
							}
							catch(Exception E) {
								
								JOptionPane.showMessageDialog(null, "No Saved");
							}
							}
							}
							}
						 }
					}
				System.out.println("Values of this function is Filled in datasets");
					}
						
			
			if(response==false) {
				 System.out.println("Values of this function is not Filled in datasets");
			}
	}
	// end of layer 2 missing values
	
	//3
	// for layer 3
		public static void MissingValuesLayer3() {
			 boolean response = UserPrint();
				
				if(response == true) {
					System.out.println("");
					System.out.println("_____Missing Values between conection of trusted by same value layer 3________");
					
					
					
					System.out.println();

					// code reuse start
					ForLevelFourTrusting = new long [Row];
					List<Long> list;			
					for(int chk =0;chk<LevelThree.length;chk++) {			
						list = new ArrayList<Long>();
						for (int row4=0;row4<Row;row4++) 
						{
							if(LevelThree[chk] == InputArray[row4][0]) {
								list.add(InputArray[row4][1]);
							}
						}
						map_3.put(LevelThree[chk], list );
					}
					System.out.println("Following are Third Layer Elements which futher trust these elements: ");
					System.out.println();
					for(Map.Entry<Long, List<Long>> entry :  map_3.entrySet()) {
						long key = entry.getKey();
						List<Long> value = entry.getValue();
						
						System.out.println(key + " is trusting following elements: " + value );
						List<Long> arrayOfList = null;
						List<Long> B = null;
						 arrayOfList= value;
						 if(arrayOfList.size()>1) {
						System.out.println(arrayOfList);
						
						for(int a=0; a<arrayOfList.size(); a++) {
							for(int b=a; b<arrayOfList.size(); b++) {
								
								if(a!=b) {
								System.out.println("this is result "+arrayOfList.get(a)+"   "+arrayOfList.get(b));
								try {
									FileWriter fw = new FileWriter(OutFile, true);
									BufferedWriter bw = new BufferedWriter(fw);
									PrintWriter pw = new PrintWriter(bw);
									
									boolean csvResult = chkCsvData((+arrayOfList.get(a)),(+arrayOfList.get(b)));
									
									
									if (csvResult == true) {
										 pw.println(arrayOfList.get(a) +","+ arrayOfList.get(b) + "," + "1" );
									}
								   
								    
									pw.flush();
									pw.close();
								//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
								}
								catch(Exception E) {
									
									JOptionPane.showMessageDialog(null, "No Saved");
								}
								}
								}
								}
							 }
						}
					System.out.println("Values of this function is Filled in datasets");
						}
							
				
				if(response==false) {
					 System.out.println("Values of this function is not Filled in datasets");
				}
		}
		// end of layer 3 missing values
		//4
		// for layer 4
		public static void MissingValuesLayer4() {
			 boolean response = UserPrint();
				
				if(response == true) {
					System.out.println("");
					System.out.println("_____Missing Values between conection of trusted by same value layer 4________");
					
					
					
					System.out.println();

					// code reuse start
					ForLevelFiveTrusting = new long [Row];
					List<Long> list;			
					for(int chk =0;chk<LevelFour.length;chk++) {			
						list = new ArrayList<Long>();
						for (int row5=0;row5<Row;row5++) 
						{
							if(LevelFour[chk] == InputArray[row5][0]) {
								list.add(InputArray[row5][1]);
							}
						}
						map_4.put(LevelFour[chk], list );
					}
					System.out.println("Following are Fourth Layer Elements which futher trust these elements: ");
					System.out.println();
					for(Map.Entry<Long, List<Long>> entry :  map_4.entrySet()) {
						long key = entry.getKey();
						List<Long> value = entry.getValue();
						
						System.out.println(key + " is trusting following elements: " + value );
						List<Long> arrayOfList = null;
						List<Long> B = null;
						 arrayOfList= value;
						 if(arrayOfList.size()>1) {
						System.out.println(arrayOfList);
						
						for(int a=0; a<arrayOfList.size(); a++) {
							for(int b=a; b<arrayOfList.size(); b++) {
								
								if(a!=b) {
								System.out.println("this is result "+arrayOfList.get(a)+"   "+arrayOfList.get(b));
								try {
									FileWriter fw = new FileWriter(OutFile, true);
									BufferedWriter bw = new BufferedWriter(fw);
									PrintWriter pw = new PrintWriter(bw);
									
									boolean csvResult = chkCsvData((+arrayOfList.get(a)),(+arrayOfList.get(b)));
									
									
									if (csvResult == true) {
										 pw.println(arrayOfList.get(a) +","+ arrayOfList.get(b) + "," + "1" );
									}
								   
								    
									pw.flush();
									pw.close();
								//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
								}
								catch(Exception E) {
									
									JOptionPane.showMessageDialog(null, "No Saved");
								}
								}
								}
								}
							 }
						}
					System.out.println("Values of this function is Filled in datasets");
						}
							
				
				if(response==false) {
					 System.out.println("Values of this function is not Filled in datasets");
				}
		}
		// end of layer 4 missing values
		//5
		// for layer 5
		public static void MissingValuesLayer5() {
			 boolean response = UserPrint();
				
				if(response == true) {
					System.out.println("");
					System.out.println("_____Missing Values between conection of trusted by same value layer 4________");
					
					
					
					System.out.println();

					// code reuse start
					ForLevelSixTrusting = new long [Row];
					List<Long> list;			
					for(int chk =0;chk<LevelFive.length;chk++) {			
						list = new ArrayList<Long>();
						for (int row5=0;row5<Row;row5++) 
						{
							if(LevelFive[chk] == InputArray[row5][0]) {
								list.add(InputArray[row5][1]);
							}
						}
						map_5.put(LevelFive[chk], list );
					}
					System.out.println("Following are Five Layer Elements which futher trust these elements: ");
					System.out.println();
					for(Map.Entry<Long, List<Long>> entry :  map_5.entrySet()) {
						long key = entry.getKey();
						List<Long> value = entry.getValue();
						
						System.out.println(key + " is trusting following elements: " + value );
						List<Long> arrayOfList = null;
						List<Long> B = null;
						 arrayOfList= value;
						 if(arrayOfList.size()>1) {
						System.out.println(arrayOfList);
						
						for(int a=0; a<arrayOfList.size(); a++) {
							for(int b=a; b<arrayOfList.size(); b++) {
								
								if(a!=b) {
								System.out.println("this is result "+arrayOfList.get(a)+"   "+arrayOfList.get(b));
								try {
									FileWriter fw = new FileWriter(OutFile, true);
									BufferedWriter bw = new BufferedWriter(fw);
									PrintWriter pw = new PrintWriter(bw);
									
									boolean csvResult = chkCsvData((+arrayOfList.get(a)),(+arrayOfList.get(b)));
									
									
									if (csvResult == true) {
										 pw.println(arrayOfList.get(a) +","+ arrayOfList.get(b) + "," + "1" );
									}
								   
								    
									pw.flush();
									pw.close();
								//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
								}
								catch(Exception E) {
									
									JOptionPane.showMessageDialog(null, "No Saved");
								}
								}
								}
								}
							 }
						}
					System.out.println("Values of this function is Filled in datasets");
						}
							
				
				if(response==false) {
					 System.out.println("Values of this function is not Filled in datasets");
				}
		}
		// end of layer 5 missing values
	
	public static void HandlingNonTrusting() 
	{
		 boolean response = UserPrint();
			
			
			if(response == true) {
		System.out.println("");
		System.out.println("___________Testing For Excel________");
		
		
		
		System.out.println();

		
		Scanner scann = null;
		String InputLine = "";
		String File = "E:\\Lab Task\\Data (REC System) Paper\\Intelligent Recomender system\\code\\WorkSpace\\WorkSpace(Final)\\FilmTrust(Fill 1)\\filmtrust\\filmtrust_trust(Orginal Dataset).csv";
		
		
		try 
		{
			TempStore1 = new String[100000];
			TempSingle1 = new String[100000];
			TempStore2 = new String[100000];
			TempSingle2 = new String[100000];
			String[] InArr21;
			int i=0,a=0,b=0,c=0;
			scann = new Scanner(new BufferedReader(new FileReader(File)));
			while(scann.hasNextLine()) 
			{
				
				InputLine = scann.nextLine(); 
				String[] InArr = InputLine.split(",");
				 
				for(int l = 0 ; l < Not_Trusting ; l++) 
				{ 
					 if(NotTrustingArray[l] == Long.parseLong(InArr[1])) 
					 {
						 //System.out.print( InArr[0] + "<-" + InArr[1] + "\n");
						 
						 TempStore1[i] = InArr[0] + "<-" + InArr[1];
						 TempSingle1[i++] = InArr[0];
						 //InArr21 = TempSingle1[i++].split("<-");
						 
						 InputArrayString[a][0] = InArr[0];
						 InputArrayString[a][1] = InArr[1];
						 
						 
						 a++;
					 } 
				}
				 
			}
			
			System.out.println("Test2: " + i );
			
			scann = new Scanner(new BufferedReader(new FileReader(File)));
			int i1 =0;
			int a1=0;
			while(scann.hasNextLine()) 
			{
				
				InputLine = scann.nextLine(); 
				String[] InArr = InputLine.split(",");
				 
				 for(int l = 0 ; l < i ; l++) { 
					 
					 long val1 = Long.parseLong(TempSingle1[l]);
					 long val2 = Long.parseLong(InArr[1]);
					 
					 if(val1 == val2) {
						 //System.out.print( InArr[0] + "<-" + InArr[1] + "\n" ); 
						 TempStore2[i1] = InArr[0] + "<-" + InArr[1];
						 TempSingle2[i1++] = InArr[0];
						 

						 InputArrayString2[a1][0] = InArr[0];
						 InputArrayString2[a1][1] = InArr[1];
						 
						// System.out.print( InputArrayString2[a1][0] +  "->" + InputArrayString2[a1][1] + "\n"); 
						 
						 a1++;
					 }
					 
					
					 
					 
					 
				 }
					
						
					
				 
			}
			
			System.out.println("a: "+a + " " + "a1: " +a1);
		
			for (int k=0;k<a1;k++) {
			
			
				for (int k1=0;k1<a;k1++) {
			
//					long var11 = Long.parseLong(InputArrayString2[k1][1] == null ? "0" : InputArrayString2[k1][1]);
//					long var22 = Long.parseLong(InputArrayString[k][0] == null ? "0" : InputArrayString[k][0]);
					
					long var11 = Long.parseLong(InputArrayString2[k][1]);
					long var22 = Long.parseLong(InputArrayString[k1][0] );
					
					if( var11 == var22 ) {
						System.out.print( InputArrayString2[k][0] +  " -> " + InputArrayString2[k][1] +  " -> " + InputArrayString[k1][1] + "\n"); 
						try {
							FileWriter fw = new FileWriter(OutFile, true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							boolean csvResult = chkCsvData(Long.parseLong(InputArrayString2[k][0]),Long.parseLong( InputArrayString[k1][1]));
							
							
							if (csvResult == true) {
								 pw.println(InputArrayString2[k][0] +","+ InputArrayString[k1][1] + "," + "1" );
							}
						   
						    
							pw.flush();
							pw.close();
						//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
						}
						catch(Exception E) {
							
							JOptionPane.showMessageDialog(null, "No Saved");
						}
					}
				}
				
			}
	
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		System.out.println("Values of this function is Filled in datasets");	
			}
			if(response==false) {
				 System.out.println("Values of this function is not Filled in datasets");
			}
		
		
	}
	
	
	public static void ReadCsv() {
		Scanner scann = null;
		String InputLine = "";
		String File = "E:\\Lab Task\\Data (REC System) Paper\\Intelligent Recomender system\\code\\WorkSpace\\WorkSpace(Final)\\FilmTrust(Fill 1)\\filmtrust\\filmtrust_trust(Orginal Dataset).csv";
		
		try 
		{
			scann = new Scanner(new BufferedReader(new FileReader(File)));
			while(scann.hasNextLine()) {
				InputLine = scann.nextLine(); 
				Row ++;
				}
			String[] col = InputLine.split(",");
			InputArray = new long[Row][col.length];
			Row = 0;
		scann = new Scanner(new BufferedReader(new FileReader(File)));
		while(scann.hasNextLine()) 
		{
				String Line = scann.nextLine();
				String[] InArr = Line.split(",");
				
				for(int x=0; x<InArr.length; x++) 
				{	
					InputArray [Row][x] = Long.parseLong(InArr[x]);	
				}
				Row ++;
			}
		FirstColumnArray= new long[Row]; 
		SecondColumnArray= new long[Row];
		for (int i=0;i<Row;i++) { 
			FirstColumnArray[i] = InputArray[i][0];  
			SecondColumnArray[i] = InputArray[i][1];
								}
		FirstColumnArray = RemoveDuplicate(FirstColumnArray);
		FirstColumn= new long[temp]; 
		for (int i=0;i<temp;i++) { 
		FirstColumn[i] = FirstColumnArray[i];
								 }
		SecondColumnArray = RemoveDuplicate(SecondColumnArray);
		SecondColumn= new long[temp];
		for (int i=0;i<temp;i++) {
			SecondColumn[i] = SecondColumnArray[i]; 
			}
		}
			catch (Exception e) 
		{
				System.out.println(e);
		}
		}
	// Trusting Array Methods
	public static void CheckingTrustingArray() {
		Trusting = new long[Row];
		for(int i = 0; i < FirstColumn.length; i++) {
			for (int Rowt=0;Rowt< Row ;Rowt++) {
				if (InputArray[Rowt][1] == FirstColumn[i]) {
					ValFoundT  = 1;
				}
		}
			if(ValFoundT != 1) {
				Trusting[_Trusting++] = FirstColumn[i];
				CountT ++;
			}
			ValFoundT  = 0;
		}
	}
    public static void PrintingTrustingArray() {
    	Trusting = RemoveDuplicate(Trusting);
		TrustingArray = new long[temp]; 
		for (int i=0;i<temp;i++) { 
			TrustingArray[i] = Trusting[i];
			}
	System.out.println("Following Users are trusting but not trusted by others: ");
	System.out.println();
	for(int l = 0 ; l < _Trusting ; l++) {
		System.out.print(TrustingArray[l]);
		if(l!=_Trusting-1) System.out.print(", ");
	}
	System.out.println();
	System.out.println("__________________________________________________________________");
	System.out.println("Number Of Users which are trusting but not trusted by others " +CountT);
	System.out.println("__________________________________________________________________");
	System.out.println();
}
    // For Not Trusting Array
public static void CheckingNotTrustingArray() {
		
	NotTrusting = new long[Row];
		
	for(int i = 0; i < SecondColumn.length ; i++) 
	{
			for (int RowNT=0;RowNT< Row;RowNT++) 
			{
				if (InputArray[RowNT][0] == SecondColumn[i]) 
				{
					ValFoundNT  = 1;
				}
			}
			if(ValFoundNT != 1) 
			{
				NotTrusting[Not_Trusting++] = SecondColumn[i];
				CountNT ++;
			}
			ValFoundNT  = 0;
		}
	}

	public static void PrintingNotTrustingArray() {
		NotTrusting = RemoveDuplicate(NotTrusting);
		NotTrustingArray = new long[temp]; 
		for (int i=0;i<temp;i++) { 
			NotTrustingArray[i] = NotTrusting[i];
			}
		System.out.println("Following Users are trusted but not trusting others: ");
		System.out.println();
		
		for(int l = 0 ; l < Not_Trusting ; l++) {
			System.out.print(NotTrustingArray[l]);
			if(l!=Not_Trusting-1) System.out.print(", ");
		}
		
		System.out.println();
		System.out.println("__________________________________________________________________");
		System.out.println("Number Of Users which are trusted but not trusting others " +CountNT);
		System.out.println("__________________________________________________________________");
		System.out.println();
	}
	 // First Layer printing 
	//first layer array is same as trusting array
	public static void PrintingFirstLayerArray() {
		System.out.println("These are First Layer Elements: ");
		System.out.println();
		for(int l = 0 ; l < _Trusting ; l++) {
			System.out.print(TrustingArray[l]);
			if(l!=_Trusting-1) System.out.print(", ");
		}
		System.out.println();
		System.out.println();
	}
	// Methods For Second Layer Elements
	public static void CheckingSecondLayerArray() {
		ForLevelTwoTrusting = new long [Row];
		List<Long> list;
		for(int chk =0;chk<TrustingArray.length;chk++) {
			list = new ArrayList<Long>();
			for (int row2=0;row2<Row;row2++) 
			{
				if(TrustingArray[chk] == InputArray[row2][0]) {
					list.add(InputArray[row2][1]);
				}
			}
			map_1.put(TrustingArray[chk], list );
		}
		System.out.println("Following are First Layer Elements which futher trust these elements: ");
		System.out.println();
		for(Map.Entry<Long, List<Long>> entry :  map_1.entrySet()) {
			long key = entry.getKey();
			List<Long> value = entry.getValue();
			Long[] arrayOfList = value.toArray(new Long[value.size()]);
			System.out.println(key + " is trusting following elements: " + value );
			for (int k=0;k<arrayOfList.length;k++) {
				ForLevelTwoTrusting[secondlayercount++] = arrayOfList[k];
			}
			System.out.println();
		}
	}
	   public static void PrintingSecondLayerArray() {
		   ForLevelTwoTrusting = RemoveDuplicate(ForLevelTwoTrusting);
		   LevelTwo= new long[temp];
		   for (int i=0;i<temp;i++) { 
				LevelTwo[i] = ForLevelTwoTrusting[i];
				}
	    	System.out.print("These are Second Layer Elements :  ");
			for (int l=0;l<LevelTwo.length;l++) {
				System.out.print(LevelTwo[l]);
				if(l!=LevelTwo.length-1) System.out.print(", ");
			}
			System.out.println();
			System.out.println();
	    }
	// For Level three methods  
		public static void CheckingThirdLayerArray() {
			ForLevelThreeTrusting = new long [Row];
			List<Long> list;			
			for(int chk =0;chk<LevelTwo.length;chk++) {			
				list = new ArrayList<Long>();
				for (int row3=0;row3<Row;row3++) 
				{
					if(LevelTwo[chk] == InputArray[row3][0]) {
						list.add(InputArray[row3][1]);
					}
				}
				map_2.put(LevelTwo[chk], list );
			}
			System.out.println("Following are Second Layer Elements which futher trust these elements: ");
			System.out.println();
			for(Map.Entry<Long, List<Long>> entry :  map_2.entrySet()) {
				long key = entry.getKey();
				List<Long> value = entry.getValue();
				Long[] arrayOfList = value.toArray(new Long[value.size()]);
				System.out.println(key + " is trusting following elements: " + value );
				for (int k=0;k<arrayOfList.length;k++) {
					ForLevelThreeTrusting[thirdlayercount++] = arrayOfList[k];
				}
				System.out.println();
			}
		}
		   public static void PrintingThirdLayerArray() {
			   ForLevelThreeTrusting = RemoveDuplicate(ForLevelThreeTrusting);
			   LevelThree= new long[temp];
			   for (int i=0;i<temp;i++) { 
					LevelThree[i] = ForLevelThreeTrusting[i];
					}
		    	System.out.print("These are Third Layer Elements :  ");
				for (int l=0;l<LevelThree.length;l++) {
					System.out.print(LevelThree[l]);
					if(l!=LevelThree.length-1) System.out.print(", ");
				}
				System.out.println();
				System.out.println();
		    }
	// for level four trusting methods
		   public static void CheckingFourthLayerArray() {
				ForLevelFourTrusting = new long [Row];
				List<Long> list;			
				for(int chk =0;chk<LevelThree.length;chk++) {			
					list = new ArrayList<Long>();
					for (int row4=0;row4<Row;row4++) 
					{
						if(LevelThree[chk] == InputArray[row4][0]) {
							list.add(InputArray[row4][1]);
						}
					}
					map_3.put(LevelThree[chk], list );
				}
				System.out.println("Following are Third Layer Elements which futher trust these elements: ");
				System.out.println();
				for(Map.Entry<Long, List<Long>> entry :  map_3.entrySet()) {
					long key = entry.getKey();
					List<Long> value = entry.getValue();
					Long[] arrayOfList = value.toArray(new Long[value.size()]);
					System.out.println(key + " is trusting following elements: " + value );
					for (int k=0;k<arrayOfList.length;k++) {
						ForLevelFourTrusting[fourthlayercount++] = arrayOfList[k];
					}
					System.out.println();
				}
			}
			   public static void PrintingFourthLayerArray() {
				   ForLevelFourTrusting = RemoveDuplicate(ForLevelFourTrusting);
				   LevelFour= new long[temp];
				   for (int i=0;i<temp;i++) { 
						LevelFour[i] = ForLevelFourTrusting[i];
						}
			    	System.out.print("These are Fourth Layer Elements :  ");
					for (int l=0;l<LevelFour.length;l++) {
						System.out.print(LevelFour[l]);
						if(l!=LevelFour.length-1) System.out.print(", ");
					}
					System.out.println();
					System.out.println();
			    }
	// level five methods
			   public static void CheckingFifthLayerArray() {
					ForLevelFiveTrusting = new long [Row];
					List<Long> list;			
					for(int chk =0;chk<LevelFour.length;chk++) {			
						list = new ArrayList<Long>();
						for (int row5=0;row5<Row;row5++) 
						{
							if(LevelFour[chk] == InputArray[row5][0]) {
								list.add(InputArray[row5][1]);
							}
						}
						map_4.put(LevelFour[chk], list );
					}
					System.out.println("Following are Fourth Layer Elements which futher trust these elements: ");
					System.out.println();
					for(Map.Entry<Long, List<Long>> entry :  map_4.entrySet()) {
						long key = entry.getKey();
						List<Long> value = entry.getValue();
						Long[] arrayOfList = value.toArray(new Long[value.size()]);
						System.out.println(key + " is trusting following elements: " + value );
						for (int k=0;k<arrayOfList.length;k++) {
							ForLevelFiveTrusting[fifthlayercount++] = arrayOfList[k];
						}
						System.out.println();
					}
				}
				   public static void PrintingFifthLayerArray() {
					   ForLevelFiveTrusting = RemoveDuplicate(ForLevelFiveTrusting);
					   LevelFive= new long[temp];
					   for (int i=0;i<temp;i++) { 
							LevelFive[i] = ForLevelFiveTrusting[i];
							}
				    	System.out.print("These are Fifth Layer Elements :  ");
						for (int l=0;l<LevelFive.length;l++) {
							System.out.print(LevelFive[l]);
							if(l!=LevelFive.length-1) System.out.print(", ");
						}
						System.out.println();
						System.out.println();
				    }
				   // just to find layer5 trusting elemenet on other for missing values logic so we do....
				   public static void CheckingSixthLayerArray() {
						ForLevelSixTrusting = new long [Row];
						List<Long> list;			
						for(int chk =0;chk<LevelFive.length;chk++) {			
							list = new ArrayList<Long>();
							for (int row5=0;row5<Row;row5++) 
							{
								if(LevelFive[chk] == InputArray[row5][0]) {
									list.add(InputArray[row5][1]);
								}
							}
							map_5.put(LevelFive[chk], list );
						}
						System.out.println("Following are Five Layer Elements which futher trust these elements: ");
						System.out.println();
						for(Map.Entry<Long, List<Long>> entry :  map_5.entrySet()) {
							long key = entry.getKey();
							List<Long> value = entry.getValue();
							Long[] arrayOfList = value.toArray(new Long[value.size()]);
							System.out.println(key + " is trusting following elements: " + value );
							for (int k=0;k<arrayOfList.length;k++) {
								ForLevelSixTrusting[Sixthlayercount++] = arrayOfList[k];
							}
							System.out.println();
						}
					}
				   
				   
	// common paths b/w 1-3
	public static void CommonElements1_3(){
		selement = new long [1000000];
		selement1= new long [1000000];
	
	
   System.out.println("Common paths of Elements Between First Layer & Third Layer: ");
   System.out.println("Distance Between Layers is 2");
   System.out.println("Followings are the results: ");
    //   Step 1:
   boolean response = UserPrint();
	
	
	if(response == true) {

     HashMap<Long, List<Long>> map1 = new HashMap<Long, List<Long>>();
    List<Long> alist;
    for(int chk1 =0;chk1<LevelTwo.length;chk1++) 
		{			
			alist = new ArrayList<Long>();
			for (int row3=0;row3<Row;row3++) 
			{
				if(LevelTwo[chk1] == InputArray[row3][0]) 
				{
					alist.add(InputArray[row3][1]);
				}
			}
			map1.put(LevelTwo[chk1], alist );
		}  //layer 2 mapping
			HashMap<Long, List<Long>> map = new HashMap<Long, List<Long>>();
			List<Long> list;
			for(int chk =0;chk<TrustingArray.length;chk++) {
				
				
				list = new ArrayList<Long>();
				for (int row2=0;row2<Row;row2++) 
				{
					
					if(TrustingArray[chk] == InputArray[row2][0]) {
						
						list.add(InputArray[row2][1]);
						
					}
				}
				map.put(TrustingArray[chk], list );
			
			} //Layer 1 mapping
	
			
			System.out.println();
			int smd=0;
			boolean check=false;
			for(Map.Entry<Long, List<Long>> entry :  map.entrySet()) {
				long key = entry.getKey();
				CommonType obj=new CommonType();
				List<Long> value = entry.getValue();
				Long[] arrayOfList = value.toArray(new Long[value.size()]);
				for (int k=0;k<arrayOfList.length;k++) {
				
					List<Long> arr= map1.get(arrayOfList[k]);
					if(arr != null)
					for(int i=0;i<arr.size();i++) {
						obj=new CommonType();
						obj.parent=key;
						obj.child=arr.get(i);
						if(Common13!=null) {
							check=false;
							for(CommonType t:Common13) {
								if(t.parent==obj.parent && t.child==obj.child) {
									t.relational.add(arrayOfList[k]);
									check=true;
								}
							}
							if(!check) {
								obj.relational.add(arrayOfList[k]);
								Common13.add(obj);
							}
						}
					
						smd++;
					}
				}
					}
			for(CommonType type:Common13) {
				
				System.out.print("Parent:"+type.parent+" child:"+type.child+" relation:");
				for(Long l:type.relational) {
					System.out.print( l+" ");
				}
				try {
					FileWriter fw = new FileWriter(OutFile, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					
					boolean csvResult = chkCsvData(type.parent, type.child);
					
					
					if (csvResult == true) {
						 pw.println(type.parent +","+ type.child + "," + "1" );
					}
				   
				    
					pw.flush();
					pw.close();
				//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
				}
				catch(Exception E) {
					
					JOptionPane.showMessageDialog(null, "No Saved");
				}	
				
				System.out.println();
			}
		
	System.out.println("Values of this function is Filled in datasets");	
	}
	if(response==false) {
		 System.out.println("Values of this function is not Filled in datasets");
	}
	}
	// common 2-4
	public static void CommonElements2_4(){
		System.out.print("\n\n\n");
		selement24 = new long [1000000];
		 selement1_24= new long [1000000];
		 
		   System.out.println("Common paths of Elements Between Second Layer & Fourth Layer: ");
		   System.out.println("Distance Between Layers is 2");
		   System.out.println("Followings are the results: ");
		   boolean response = UserPrint();
			
			
			if(response == true) {
			
		   HashMap<Long, List<Long>> map1 = new HashMap<Long, List<Long>>();
			List<Long> alist;
				for(int chk1 =0;chk1<LevelThree.length;chk1++) 
				{			
					alist = new ArrayList<Long>();
					for (int row3=0;row3<Row;row3++) 
					{
						if(LevelThree[chk1] == InputArray[row3][0]) 
						{		
							alist.add(InputArray[row3][1]);	
						}
					}
					map1.put(LevelThree[chk1], alist );
				}// layer 3 mapping 
				
					HashMap<Long, List<Long>> map = new HashMap<Long, List<Long>>();
					List<Long> list;
					for(int chk =0;chk<LevelTwo.length;chk++) {
						list = new ArrayList<Long>();
						for (int row2=0;row2<Row;row2++) 
						{
							if(LevelTwo[chk] == InputArray[row2][0]) {
								list.add(InputArray[row2][1]);
							}
						}
						map.put(LevelTwo[chk], list );
					}// layer 2 mapping 
					System.out.println();
					int smd=0;
					boolean check=false;
					for(Map.Entry<Long, List<Long>> entry :  map.entrySet()) {
						long key = entry.getKey();
						CommonType obj=new CommonType();
						List<Long> value = entry.getValue();
						Long[] arrayOfList = value.toArray(new Long[value.size()]);
						for (int k=0;k<arrayOfList.length;k++) {
						
							List<Long> arr= map1.get(arrayOfList[k]);
							if(arr != null)
							for(int i=0;i<arr.size();i++) {
								obj=new CommonType();
								obj.parent=key;
								obj.child=arr.get(i);
								if(Common24!=null) {
									check=false;
									for(CommonType t:Common24) {
										if(t.parent==obj.parent && t.child==obj.child) {
											t.relational.add(arrayOfList[k]);
											check=true;
										}
									}
									if(!check) {
										obj.relational.add(arrayOfList[k]);
										Common24.add(obj);
									}
								}
							
								smd++;
							}
						}
							}
					for(CommonType type:Common24) {
						
						System.out.print("Parent:"+type.parent+" child:"+type.child+" relation:");
						for(Long l:type.relational) {
							System.out.print( l+" ");
						}
						try {
							FileWriter fw = new FileWriter(OutFile, true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							boolean csvResult = chkCsvData(type.parent, type.child);
							
							
							if (csvResult == true) {
								 pw.println(type.parent +","+ type.child + "," + "1" );
							}
						   
						    
							pw.flush();
							pw.close();
						
						}
						catch(Exception E) {
							
							JOptionPane.showMessageDialog(null, "No Saved");
						}	
						
						System.out.println();
					}
				//write data in csv file 
				
			System.out.println("Values of this function is Filled in datasets");	
			}
			if(response==false) {
				 System.out.println("Values of this function is not Filled in datasets");
			}		}// end 2-4
//	start 3-5
	public static void CommonElements3_5(){
		System.out.print("\n\n\n");
		selement35 = new long [1000000];
		 selement1_35= new long [1000000];
		
		   System.out.println("Common paths of Elements Between Third Layer & Fifth Layer: ");
		   System.out.println("Distance Between Layers is 2");
		   System.out.println("Followings are the results: ");
		   boolean response = UserPrint();
			
			
			if(response == true) {
			
		   HashMap<Long, List<Long>> map1 = new HashMap<Long, List<Long>>();
			List<Long> alist;
				for(int chk1 =0;chk1<LevelFive.length;chk1++) 
				{			
					alist = new ArrayList<Long>();
					for (int row3=0;row3<Row;row3++) 
					{
						if(LevelFive[chk1] == InputArray[row3][0]) 
						{		
							alist.add(InputArray[row3][1]);	
						}
					}
					map1.put(LevelFive[chk1], alist );
				} // layer 5 mapping 
					HashMap<Long, List<Long>> map = new HashMap<Long, List<Long>>();
					List<Long> list;
					for(int chk =0;chk<LevelThree.length;chk++) {
						list = new ArrayList<Long>();
						for (int row2=0;row2<Row;row2++) 
						{
							if(LevelThree[chk] == InputArray[row2][0]) {
								list.add(InputArray[row2][1]);
							}
						}
						map.put(LevelThree[chk], list );
					}// layer 3 mapping
					System.out.println();
					int smd=0;
					boolean check=false;
					for(Map.Entry<Long, List<Long>> entry :  map.entrySet()) {
						long key = entry.getKey();
						CommonType obj=new CommonType();
						List<Long> value = entry.getValue();
						Long[] arrayOfList = value.toArray(new Long[value.size()]);
						for (int k=0;k<arrayOfList.length;k++) {
						
							List<Long> arr= map1.get(arrayOfList[k]);
							if(arr != null)
							for(int i=0;i<arr.size();i++) {
								obj=new CommonType();
								obj.parent=key;
								obj.child=arr.get(i);
								if(Common35!=null) {
									check=false;
									for(CommonType t:Common35) {
										if(t.parent==obj.parent && t.child==obj.child) {
											t.relational.add(arrayOfList[k]);
											check=true;
										}
									}
									if(!check) {
										obj.relational.add(arrayOfList[k]);
										Common35.add(obj);
									}
								}
							
								smd++;
							}
						}
							}
					for(CommonType type:Common35) {
						
						System.out.print("Parent:"+type.parent+" child:"+type.child+" relation:");
						for(Long l:type.relational) {
							System.out.print( l+" ");
						}
						try {
							FileWriter fw = new FileWriter(OutFile, true);
							BufferedWriter bw = new BufferedWriter(fw);
							PrintWriter pw = new PrintWriter(bw);
							
							boolean csvResult = chkCsvData(type.parent, type.child);
							
							
							if (csvResult == true) {
								 pw.println(type.parent +","+ type.child + "," + "1" );
							}
						   
						    
							pw.flush();
							pw.close();
						
						}
						catch(Exception E) {
							
							JOptionPane.showMessageDialog(null, "No Saved");
						}	
						
						System.out.println();
					}
				//write data in csv file 
				
			System.out.println("Values of this function is Filled in datasets");	
			}
			if(response==false) {
				 System.out.println("Values of this function is not Filled in datasets");
			}
				
			}
	// 1-4
	// 1-4
		public static void CommonElements1_4(){	
			System.out.print("\n\n\n");
			selement14_34 = new long [1000000];
			selement14_23 = new long [1000000];
			selement14_12 = new long [1000000];
			 int _selement =  0;
			 int _selement1 = 0;
			 int _selement2 = 0;
			   System.out.println("Common paths of Elements Between First Layer & Fourth Layer: ");
			   System.out.println("Distance Between Layers is 3");
			   System.out.println("Followings are the results: ");
			  System.out.println();
			  boolean response = UserPrint();
				
				
				if(response == true) {
			   for(int l=0; l<LevelFour.length; l++) {
			   List<Long> list;			
				for(int chk =0;chk<LevelThree.length;chk++) {			
					list = new ArrayList<Long>();
					for (int row4=0;row4<Row;row4++) 
					{
						
						if(LevelThree[chk] == InputArray[row4][0]) {
							
							list.add(InputArray[row4][1]);
							
						}
					}
					map_3.put(LevelThree[chk], list );
				
				}
			
				for(Map.Entry<Long, List<Long>> entry3 :  map_3.entrySet()) {
					
					long key3 = entry3.getKey();
					
					 for(Long val1 : entry3.getValue())
					 {
			             if(val1==LevelFour[l])
			             {
			            	
			            	 selement14_34[_selement++]=key3;
			         
			          	}
					 }
				}
				
				for(int chk =0;chk<LevelTwo.length;chk++) {			
					list = new ArrayList<Long>();
					for (int row3=0;row3<Row;row3++) 
					{
						
						if(LevelTwo[chk] == InputArray[row3][0]) {
							
							list.add(InputArray[row3][1]);
							
						}
					}
					map_2.put(LevelTwo[chk], list );
				
				}
			
				for(Map.Entry<Long, List<Long>> entry2 :  map_2.entrySet()) {
					
					long key2 = entry2.getKey();
					
					 for(Long val2 : entry2.getValue())
					 {
						
			             if(val2==selement14_34[l])
			             {
			            	 	selement14_23[_selement1++]=key2;
			            	
			          	}
					 }
				}
				
				for(int chk =0;chk<TrustingArray.length;chk++) {
					
					
					list = new ArrayList<Long>();
					for (int row2=0;row2<Row;row2++) 
					{
						
						if(TrustingArray[chk] == InputArray[row2][0]) {
							
							list.add(InputArray[row2][1]);
							
						}
					}
					map_1.put(TrustingArray[chk], list );
				
				}
				
				
				for(Map.Entry<Long, List<Long>> entry1 :  map_1.entrySet()) {
					
					 long key1 = entry1.getKey();
						 for(Long val1 : entry1.getValue())
						 {
					 if(val1==selement14_23[l])
				             {
				            	
				            	 	selement14_12[_selement2++]=key1;
				            	
				          	}
						 }
						}
				System.out.println();
				System.out.println(selement14_12[l] + " and " +LevelFour[l] + " having common path: " + selement14_23[l] + " " + selement14_34[l] );
				 
				try {
					// String File = "C:\\Users\\hassa\\Documents\\WorkSpace\\Fill Missing Data(Fill 1)\\datasets\\filmtrust\\filmtrust_trust.csv";
					FileWriter fw = new FileWriter(OutFile, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(bw);
					
					boolean csvResult = chkCsvData(selement14_12[l], LevelFour[l]);
					
					
					if (csvResult == true) {
						 pw.println(selement14_12[l] +","+ LevelFour[l] + "," + "1" );
					}
				   
				    
					pw.flush();
					pw.close();
				//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
				}
				catch(Exception E) {
					
					JOptionPane.showMessageDialog(null, "No Saved");
				}	
					}
			   System.out.println("Values of this function is Filled in datasets");	
				}
				if(response==false) {
					 System.out.println("Values of this function is not Filled in datasets");
				}
				}
	// level 1-5
	public static void  CommonElements1_5(){	
	System.out.print("\n\n\n");
	selement15_45 = new long [1000000];
	selement15_34 = new long [1000000];
	selement15_23 = new long [1000000];
	selement15_12 = new long [1000000];
	 int _selement =  0;
	 int _selement1 = 0;
	 int _selement2 = 0;
	 int _selement3 = 0;
	   System.out.println("Common paths of Elements Between First Layer & Fifth Layer: ");
	   System.out.println("Distance Between Layers is 4");
	   System.out.println("Followings are the results: ");
	   System.out.println();
		
		boolean response = UserPrint();
		
	
		if(response == true) {
	   for(int l=0; l<LevelFive.length; l++) {
		   List<Long> list;			
			for(int chk =0;chk<LevelFour.length;chk++) {			
				list = new ArrayList<Long>();
				for (int row5=0;row5<Row;row5++) 
				{
					
					if(LevelFour[chk] == InputArray[row5][0]) {
						
						list.add(InputArray[row5][1]);
						
					}
				}
				map_4.put(LevelFour[chk], list );
			
			}
	
		for(Map.Entry<Long, List<Long>> entry4 :  map_4.entrySet()) {
			
			long key4 = entry4.getKey();
				
				 for(Long val4 : entry4.getValue())
				 {
		             if(val4==LevelFive[l])
		             {
		            	
		            	 selement15_45[_selement++]=key4;
		            	
		          	}
				 }
		}
		
				for(int chk =0;chk<LevelThree.length;chk++) {			
					list = new ArrayList<Long>();
					for (int row4=0;row4<Row;row4++) 
					{
						
						if(LevelThree[chk] == InputArray[row4][0]) {
							
							list.add(InputArray[row4][1]);
							
						}
					}
					map_3.put(LevelThree[chk], list );
				
				}
		
				for(Map.Entry<Long, List<Long>> entry3 :  map_3.entrySet()) {
					
					long key3 = entry3.getKey();
				
					 for(Long val3 : entry3.getValue())
					 {
			             if(val3==selement15_45[l])
			             {
			            	
			            	 selement15_34[_selement1++]=key3;
		
			          	}
					 }
				}
				
				for(int chk =0;chk<LevelTwo.length;chk++) {			
					list = new ArrayList<Long>();
					for (int row3=0;row3<Row;row3++) 
					{
						
						if(LevelTwo[chk] == InputArray[row3][0]) {
							
							list.add(InputArray[row3][1]);
							
						}
					}
					map_2.put(LevelTwo[chk], list );
				
				}
			
				for(Map.Entry<Long, List<Long>> entry2 :  map_2.entrySet()) {
					
					long key2 = entry2.getKey();
					
					 for(Long val2 : entry2.getValue())
					 {
						
			             if(val2==selement15_34[l])
			             {
			            	
			            	 	selement15_23[_selement2++]=key2;
			            	
			          	}
					 }
				}
				
				for(int chk =0;chk<TrustingArray.length;chk++) {
					
					
					list = new ArrayList<Long>();
					for (int row2=0;row2<Row;row2++) 
					{
						
						if(TrustingArray[chk] == InputArray[row2][0]) {
							
							list.add(InputArray[row2][1]);
							
						}
					}
					map_1.put(TrustingArray[chk], list );
				
				}
				
				
				for(Map.Entry<Long, List<Long>> entry1 :  map_1.entrySet()) {
					
					 long key1 = entry1.getKey();
						 for(Long val1 : entry1.getValue())
						 {
					 if(val1==selement15_23[l])
				             {
				            	
				            	 	selement15_12[_selement3++]=key1;
				            	
				          	}
						 }
						}
				System.out.println();
				System.out.println(selement15_12[l] + " and " +LevelFive[l] + " having common path: " + selement15_23[l] + " " + selement15_34[l] + " " +selement15_45[l] );
			
					try {
						
					//	 String File = "C:\\Users\\hassa\\Documents\\WorkSpace\\Fill Missing Data(Fill 1)\\datasets\\filmtrust\\filmtrust_trust.csv";
						FileWriter fw = new FileWriter(OutFile, true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						boolean csvResult = chkCsvData(selement15_12[l], LevelFive[l]);
						
						
						if (csvResult == true) {
							 pw.println(selement15_12[l] +","+ LevelFive[l] + "," + "1" );
						}
					   
					    
						pw.flush();
						pw.close();
					//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
					}
					catch(Exception E) {
						
						JOptionPane.showMessageDialog(null, "No Saved");
					}	
	   }
	   System.out.println("Values of this function is Filled in datasets");	
		}
		if(response==false) {
			 System.out.println("Values of this function is not Filled in datasets");
		}
		}
	
	
	// level 2-5
	public static void CommonElements2_5(){	
		System.out.print("\n\n\n");
		selement25_45 = new long [1000000];
		selement25_34 = new long [1000000];
		
		selement25_23 = new long [1000000];
		 int _selement =  0;
		 int _selement1 = 0;
		 int _selement2 = 0;
		   System.out.println("Common paths of Elements Between Second Layer & Fifth Layer: ");
		   System.out.println("Distance Between Layers is 3");
		   System.out.println("Followings are the results: ");
		   boolean response = UserPrint();
			
			
			if(response == true) {
		   for(int l=0; l<LevelFive.length; l++) {
			   List<Long> list;			
				for(int chk =0;chk<LevelFour.length;chk++) {			
					list = new ArrayList<Long>();
					for (int row5=0;row5<Row;row5++) 
					{
						
						if(LevelFour[chk] == InputArray[row5][0]) {
							
							list.add(InputArray[row5][1]);
							
						}
					}
					map_4.put(LevelFour[chk], list );
				
				}
		
			for(Map.Entry<Long, List<Long>> entry4 :  map_4.entrySet()) {
				
				long key4 = entry4.getKey();
						
					 for(Long val4 : entry4.getValue())
					 {
			             if(val4==LevelFive[l])
			             {
			            	
			            	 selement25_45[_selement++]=key4;
			            
			          	}
					 }
			}
			
			for(int chk =0;chk<LevelThree.length;chk++) {			
				list = new ArrayList<Long>();
				for (int row4=0;row4<Row;row4++) 
				{
					
					if(LevelThree[chk] == InputArray[row4][0]) {
						
						list.add(InputArray[row4][1]);
						
					}
				}
				map_3.put(LevelThree[chk], list );
			
			}
		
			for(Map.Entry<Long, List<Long>> entry3 :  map_3.entrySet()) {
				
				long key3 = entry3.getKey();
				
				 for(Long val3 : entry3.getValue())
				 {
		             if(val3==selement25_45[l])
		             {
		            	
		            	 selement25_34[_selement1++]=key3;
		            	
		          	}
				 }
			}
		
			for(int chk =0;chk<LevelTwo.length;chk++) {			
				list = new ArrayList<Long>();
				for (int row3=0;row3<Row;row3++) 
				{
					
					if(LevelTwo[chk] == InputArray[row3][0]) {
						
						list.add(InputArray[row3][1]);
						
					}
				}
				map_2.put(LevelTwo[chk], list );
			
			}
		
			for(Map.Entry<Long, List<Long>> entry2 :  map_2.entrySet()) {
				
				long key2 = entry2.getKey();
				
				 
				 for(Long val2 : entry2.getValue())
				 {
					
		             if(val2==selement25_34[l])
		             {
		            	
		            	 	selement25_23[_selement2++]=key2;
		            	
		          	}
				 }
			}
			System.out.println();
			System.out.println(selement25_23[l] + " and " +LevelFive[l] + " having common path: " + selement25_34[l] + " " + selement25_45[l]);
			
			try {
			//	 String File = " \"E:\\LAb Task\\Data (REC System) Paper\\WorkSpace\\WorkSpace(Final)\\FilmTrust(Fill 1)\\filmtrust\\filmtrust_trust(Orginal Dataset).csv";
				FileWriter fw = new FileWriter(OutFile, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				boolean csvResult = chkCsvData(selement25_23[l],LevelFive[l]);
				
				
				if (csvResult == true) {
					 pw.println(selement25_23[l] +","+ LevelFive[l] + "," + "1" );
				}
			   
			    
				pw.flush();
				pw.close();
			//	JOptionPane.showMessageDialog(null, "Save Record Successfully");
			}
			catch(Exception E) {
				
				JOptionPane.showMessageDialog(null, "No Saved");
			}	
			
		   }
		   System.out.println("Values of this function is Filled in datasets");	
			}
			if(response==false) {
				 System.out.println("Values of this function is not Filled in datasets");
			}
			}
	
	

	


	public static long[] RemoveDuplicate(long[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j = i+1 ; j < arr.length ; j++) {
				
				if((arr[i] == arr[j]) && arr[i]!=0) {
					arr[j] = 0;
				}
			}
		}
		long[] arr1=new long[arr.length];
		temp = 0;
		for (int i=0;i<arr.length;i++) {
			if(arr[i] != 0) arr1[temp ++ ] = arr[i];
		}
		return arr1;
	}
	
	
	public static String[] removeDuplicates(String []dupArray)
	{
		HashSet<String> mySet = new HashSet<String>(Arrays.asList(dupArray));
		dupArray = new String[mySet.size()];
		mySet.toArray(dupArray);
		return dupArray;
	}
	
	public static long[] printArray(Long []arr) {
		
		System.out.println(Arrays.toString(arr));
		
		return null;
	}
	
	public static boolean UserPrint() {
		
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Do you want to print data in file ->  1: Yes 2:No");
		int i1= sc.nextInt();
		
		switch(i1){
		
		case 1: return true;
		case 2: return false;
			
		}
		
		
		return true;
		
		
		
	}
	
	
	public static boolean chkCsvData(long para1, long para2) {
		
		
		
		
	    try {
	    	 String line = "";
	    	    
	    	 

	    	BufferedReader br = new BufferedReader(new FileReader(OutFile));
	        while ((line = br.readLine()) != null) {

	            // use comma as separator
	            String[] getCSVDataLine = line.split(",");
	            
	            int param1 = Integer.valueOf(getCSVDataLine[0]);
	            int paraa1 = (int) para1;
	            int param2 = Integer.valueOf(getCSVDataLine[1]);
	            int paraa2 = (int) para2;
	          
	            if (param1 ==  paraa1 && param2 == paraa2) {
	            	return false;
	            }
	            
	            if(paraa1 == paraa2) {
	            	return false;
	            }
	            }

	    } 
	    catch(Exception ex) 
	    {
	      JOptionPane.showMessageDialog(null, ex.toString());
	    }
		
		return true;
		
	}
}
class CommonType{
	long parent;
	long child;
	List<Long> relational=new ArrayList<Long>();
	List<Long> rel14_24=new ArrayList<Long>();
}