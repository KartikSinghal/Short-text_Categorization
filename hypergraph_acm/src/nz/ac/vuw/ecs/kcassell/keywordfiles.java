package nz.ac.vuw.ecs.kcassell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class keywordfiles {
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\LabelValues - Copy.txt"));
		BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\miscindexcorrect.txt"));
		BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\keywords\\Paper5.txt"));
		ArrayList<Integer> misc=new ArrayList<Integer>();
		StringTokenizer stmisc=null;
		String linemisc=in1.readLine();
		stmisc=new StringTokenizer(linemisc,",");
		while(stmisc.hasMoreTokens()){
			misc.add(Integer.parseInt(stmisc.nextToken()));
		}
		int i=0;
		System.out.println(misc);
		String line1="";
		String line2="";
		String line3="";
		String line4="";
		//String line5="";
		String temp1="";
		String temp2="";
		String temp3="";
		String temp4="";
		//String temp5="";
		Double n;
		line1=in.readLine();
		line2=in.readLine();
		line3=in.readLine();
		line4=in.readLine();
		//line5=in.readLine();
		StringTokenizer st1=null;
		StringTokenizer st2=null;
		StringTokenizer st3=null;
		StringTokenizer st4=null;
		//StringTokenizer st5=null;
		st1=new StringTokenizer(line1,",");
		st2=new StringTokenizer(line2,",");
		st3=new StringTokenizer(line3,",");
		st4=new StringTokenizer(line4,",");
		//st5=new StringTokenizer(line5,",");
		System.out.println(st1.countTokens());
		while(st1.hasMoreTokens()){
			temp1=st1.nextToken();
			temp2=st2.nextToken();
			temp3=st3.nextToken();
			temp4=st4.nextToken();
			//temp5=st5.nextToken();
			System.out.println(i);
			if(!misc.contains(i)){
			out1.write(temp1+","+temp2+","+temp3+","+temp4);
			out1.newLine();}
			i++;
		}
		out1.close();
	}
}