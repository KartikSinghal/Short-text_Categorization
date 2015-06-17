import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;


public class acmconverttohedge {
	public static void main(String args[]) throws IOException{
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\edgesnew.txt"));
		BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\hedgesmain.txt"));
		HashMap<String,String> main=new LinkedHashMap<String,String>();
		String line1="", out="", line3="";
		StringTokenizer st1=null;
		StringTokenizer st2=null;
		String finals;
		String temp;
		int flag=0,i=0,j=0,m=0;
		while((line1=in.readLine())!=null){
		st1=new StringTokenizer(line1,",");
		while(st1.hasMoreTokens()){
			temp=st1.nextToken();
			if(!main.containsKey(temp))
				{
					main.put(temp, String.valueOf(i));
					i++;
				}
			
			else
				m++;
				
		}
		}
		System.out.println(i);
		System.out.println(m);
		
		in.close();
		in = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\edgesnew.txt"));
		while((line1=in.readLine())!=null){
			st1=new StringTokenizer(line1,",");
			while(st1.hasMoreTokens()){
				temp=st1.nextToken();
				if(main.containsKey(temp)){
					out1.write(main.get(temp)+",");
				}
			}
			out1.newLine();
			out1.flush();
		}
		in.close();
		out1.close();
		BufferedReader in2 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\acmmap.txt"));
		BufferedWriter out2 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\acmmapunique.txt"));
		while((line1=in2.readLine())!=null){
			st1=new StringTokenizer(line1," ");
				temp=st1.nextToken();
				if(main.containsKey(temp)){
					out2.write(main.get(temp));
					while(st1.hasMoreTokens())
					out2.write(" "+st1.nextToken());
				}
				else{
					out2.write(temp+" "+st1.nextToken());
				}
			
			out2.newLine();
			out2.flush();
		}
	}
	
}
