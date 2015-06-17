import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class acm_graphfinal {
	
public static void main(String args[]) throws IOException{
	BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\edges.txt"));
	BufferedReader in2 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\edgenumber.txt"));
	BufferedReader in3 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Documents\\BTP\\ccs98.txt"));
	BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\edgesnew.txt"));
	BufferedWriter out2 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Documents\\BTP\\edgesidentity.txt"));
	String line1,line2 = null,line3,key;
	HashMap<String,String> main=new LinkedHashMap<String,String>();
	HashMap<String,ArrayList<String>> hedged=new LinkedHashMap<String,ArrayList<String>>();
	String x;
	ArrayList<String> dummy=new ArrayList<String>();
	int i=-1;
	while(((line1=in1.readLine())!=null)&&((line2=in2.readLine())!=null)){
		i++;
			main.put(line2, line1);
	}
	while((line3=in3.readLine())!=null){
		if(!(line3=="")&&(line3.contains("(A.")||line3.contains("(B.")||line3.contains("(C.")||line3.contains("(D.")||line3.contains("(E.")||line3.contains("(F.")||line3.contains("(I.")||line3.contains("(G.")||line3.contains("(H.")||line3.contains("(J.")||line3.contains("(K."))){
			StringTokenizer st=new StringTokenizer(line3," ");
			key=st.nextToken();
			StringTokenizer st1=new StringTokenizer(line3,"(");
			st1.nextToken();
			
				StringTokenizer st2=new StringTokenizer(st1.nextToken(),")");
				StringTokenizer st3=new StringTokenizer(st2.nextToken(),",");
				dummy=new ArrayList<String>();
				while(st3.hasMoreTokens()){
				StringTokenizer st4=new StringTokenizer(st3.nextToken()," ");
				dummy.add(st4.nextToken());					
				}
				hedged.put(key, dummy);
		}
	}
//	for (Entry<String, String> entry : main.entrySet()) {
//		out1.write(entry.getKey()+"-"+entry.getValue());
//		out1.newLine();
//		out1.flush();
//	}
	for (Entry<String, ArrayList<String>> entry : hedged.entrySet()) {
//		/System.out.println(entry.getKey()+"-"+entry.getValue());
		
	}
	String keyhed,temp,temp1="",temp2,tempstring,keystring;
	int j=0;
	ArrayList<String> value=new ArrayList<String>();
	for (Entry<String, ArrayList<String>> entry : hedged.entrySet()) {
		keyhed=entry.getKey();
		value=entry.getValue();
		temp=main.get(keyhed);
		temp1="";
		keystring=keyhed;
		for(j=0;j<value.size();j++){
			keystring=keystring+"-"+value.get(j);
			temp2=main.get(value.get(j));
			if(temp1=="")
				temp1=temp2;
			else
				temp1=temp1+","+temp2;
		}
		temp=temp+","+temp1;
		main.put(keystring, temp);
//		if(keyhed.length()>2){
//			System.out.println(keyhed.substring(0, 1));
//			tempstring=main.get(keyhed.substring(0, 1));
//			tempstring=tempstring+","+temp1;
//			main.put(keyhed.substring(0, 1),tempstring);
//		}
//		if(keyhed.length()>4){
//			tempstring=main.get(keyhed.substring(0, 3));
//			tempstring=tempstring+","+temp1;
//			main.put(keyhed.substring(0, 3),tempstring);
//		}
		
	}
	for (Entry<String, String> entry : main.entrySet()) {
		out1.write(entry.getValue());
		out1.newLine();
		out1.flush();
		out2.write(entry.getKey());
		out2.newLine();
		out2.flush();
		
	}
	
	}
}
