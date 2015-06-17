import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class clearfile {

	public static void main(String args[]) throws IOException{
		BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Downloads\\NewDownloads\\hedges.txt"));
		BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Downloads\\NewDownloads\\hedgesnumber.txt"));
		String line1,line2;
		String x;
		int i=-1;
		while((line1=in1.readLine())!=null){
			i++;
			StringTokenizer st=new StringTokenizer(line1,",");
			while(st.hasMoreTokens()){
				out1.write(String.valueOf(i)+","+st.nextToken());
				out1.newLine();
			}
			out1.flush();
		
		}
	}
	
}
