package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(checkURL("C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\HTML\\index.html"));
		//System.out.println((new File("C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + "JSON")).exists());
//		File file = new File("C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + "JSON" + "\\TestPosst.txt");
//		file.getParentFile().mkdirs();
		try {
//			FileWriter writer = new FileWriter("C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + "JSON" + "\\TestPosst.txt");
		    String str = "Hello fsdfsfs";
		    BufferedWriter writerData = new BufferedWriter(new FileWriter("C:\\Users\\admind\\Documents\\GitHub\\HTTPProtocol\\HTTPProtocol\\Data\\" + "JSON" + "\\TestPosst.txt"));
		    writerData.write(str);
		    writerData.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
