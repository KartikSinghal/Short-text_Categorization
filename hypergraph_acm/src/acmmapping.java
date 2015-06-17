import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;


public class acmmapping {
public static void main(String args[]) throws IOException{
	
	BufferedReader in3 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\ccs98.txt"));
	BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\acmmap.txt"));
	HashMap<String,String> main=new LinkedHashMap<String,String>();
	String line1="", out="", line3="";
	int buffer_size=1000;
	StringTokenizer st1=null;
	StringTokenizer st2=null;
	String finals;
	String temp;
	int flag=0,i=0;
	while((line1=in3.readLine())!=null){
		st1=new StringTokenizer(line1," ");
		if(line1.equals("")){
			continue;
		}
		finals=st1.nextToken();
		if(finals.length()==2){
			continue;
		}
		System.out.println(line1+" "+finals.length());
		out1.write(finals+"."+String.valueOf(i));
		while(st1.hasMoreTokens()&&!(temp=st1.nextToken()).contains("(")){
			out1.write(" "+temp);
		}
		out1.newLine();
		out1.flush();
		while(!(line1=in3.readLine()).equals("")){
			System.out.println(line1+" "+finals);
			st2=new StringTokenizer(line1," ");
			i++;
			out1.write(finals+"."+String.valueOf(i));
			while(st2.hasMoreTokens()&&!(temp=st2.nextToken()).contains("(")){
				out1.write(" "+temp);
			}
			out1.newLine();
			out1.flush();
		}
		i=0;
	}
}
}
