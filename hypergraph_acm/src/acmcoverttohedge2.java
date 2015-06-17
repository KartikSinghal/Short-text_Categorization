import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class acmcoverttohedge2 {

	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\acmmap.txt"));
		BufferedReader in2 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\edgesnew.txt"));
		BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\hedgesmain.txt"));
		BufferedWriter out2 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\miscindex.txt"));
		StringTokenizer st1=null;
		Map<String,Integer> main=new HashMap<String,Integer>();
		String line1="";
		int i=0;
		int j=0;
		while((line1=in.readLine())!=null){
			st1=new StringTokenizer(line1," ");
			line1=st1.nextToken();
			if(!line1.contains("m"))
			{main.put(line1, i);
			i++;}
			else{
				out2.write(line1+",");
			}
			j++;
		}
		System.out.println(main.size());
		String temp="";
		while((line1=in2.readLine())!=null){
			st1=new StringTokenizer(line1,",");
			while(st1.hasMoreTokens()){
				temp=st1.nextToken();
				if(!temp.contains("m")){
					out1.write(String.valueOf(main.get(temp)));
					out1.write(",");
				}
			}
			out1.newLine();
			i++;
		}
		out1.flush();
		out1.close();
		out2.close();
	}
}
