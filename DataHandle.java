
import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class DataHandle implements DATA {


	public  void inputFile() {
		Scanner  inputStream  = null;

		try {

		   inputStream = new Scanner(new FileInputStream("DataPutHere.txt"));
		   while(inputStream.hasNext()) {
			   DataStruct re = new DataStruct();
			   re.workName  = (String)inputStream.nextLine();
			   String XX = (String)inputStream.nextLine();
			   Scanner reDate = new Scanner(XX);
			   String r1 = (String)reDate.next(); int r2 = (int)reDate.nextInt(),r3 =(int) reDate.nextInt();
			   re.startDate = new DateX(r1,r2,r3);
			   reDate.close();
			    XX =(String) inputStream.nextLine();
			   Scanner reDateX = new Scanner(XX);
			    r1 = (String)reDateX.next();  r2 = (int)reDateX.nextInt(); r3= (int)reDateX.nextInt();
			   re.endDate = new DateX(r1,r2,r3);
			   reDateX.close();
			   re.percent   = (String)inputStream.nextLine();
			   re.status    = (String)inputStream.nextLine();
			   re.Numbering = (String)inputStream.nextLine();
			   re.classX    = (String)inputStream.nextLine();
			   re.work      = (String)inputStream.nextLine();
			   DataHere.add(re);
		   }

		 }
		 catch(Exception e)
	     {
			 out.println(e);
	         out.println("File  workFile.txt was not found");
	         out.println("or could not be opened.");
		 }
		 inputStream.close();
	}

	public void outputFile() {
		PrintWriter  outputStream  = null;

		try {

			outputStream = new PrintWriter(new FileOutputStream("DataPutHere.txt"));
			for(int i =0; i <DataHere.size();i++ ) {
				outputStream.println(DataHere.get(i).workName);
				outputStream.println(DataHere.get(i).startDate.toString());
				outputStream.println(DataHere.get(i).endDate.toString());
				outputStream.println(DataHere.get(i).percent);
				outputStream.println(DataHere.get(i).status);
				outputStream.println(DataHere.get(i).Numbering);
				outputStream.println(DataHere.get(i).classX);
				outputStream.println(DataHere.get(i).work);
			}
			outputStream.close();

		 }
		 catch(Exception e)
	     {
			 out.println(e);
	         out.println("File  workFile.txt was not found");
	         out.println("or could not be opened.");
		 }
	}


}
