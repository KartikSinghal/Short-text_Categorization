import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;


public class fullgraphfinalcreation {

	public static void main(String args[]) throws IOException{
		BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\edgesnew.txt"));
		BufferedReader in2 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\edgesidentity.txt"));
		BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\hedges.txt"));
		BufferedWriter out2 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\hedgeweight.txt"));
		BufferedWriter out3 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\hedgeidentity.txt"));
		HashMap<String,String> main=new LinkedHashMap<String,String>();
		String line1;
		int i,j=0;
		String token;
		Double weight;
		while((line1=in1.readLine())!=null){
			i=0;
			StringTokenizer st=new StringTokenizer(line1,",");
			while(st.hasMoreTokens()){
				token=st.nextToken();
				if(!(token=="")){
					if(!main.containsKey(token))
					main.put(token, String.valueOf(j));
					i++;
					j++;
				}
			}
			weight=(double) (1/(double)(i));
			out2.write(String.valueOf(weight));
			out2.newLine();
			out2.flush();
		}
		in1 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\edgesnew.txt"));
		i=0;
		while((line1=in1.readLine())!=null){
			StringTokenizer st=new StringTokenizer(line1,",");
			while(st.hasMoreTokens()){
				token=st.nextToken();
				if(!(token=="")){
					out1.write(main.get(token));
					out1.write(",");
					out1.flush();
				}
			}
			out1.newLine();
			out1.flush();
		}
		out1.close();
		out2.close();
		out3.close();
		BufferedReader in4 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\hedgesmain.txt"));
		BufferedWriter out4 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\BTP_data_main\\hedge_tuples.txt"));
		String line4;
		int k=0;
		while((line4=in4.readLine())!=null){
			StringTokenizer st2=new StringTokenizer(line4,",");
			while(st2.hasMoreTokens()){
				token=st2.nextToken();
				if(!(token=="")){
					out4.write(String.valueOf(k)+","+token);
					out4.newLine();
					out4.flush();
				}
			}
			k++;
		}
		
	}
}
