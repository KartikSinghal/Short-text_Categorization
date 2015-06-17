import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;


public class stackimplement {
public static void main(String args[]) throws IOException{
	Stack main=new Stack();
	BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Downloads\\NewDownloads\\ccs98.txt"));
	String line;
	HashMap<String, Integer> alphabet = new HashMap<String, Integer>();
	ArrayList<Integer> multicounter=new ArrayList<Integer>();
	ArrayList<Integer> treecount=new ArrayList<Integer>();
	int i=0;
	main.push(treecount);
	while((line = in1.readLine())!=null){
	  if(line.contains(",")){
		  alphabet.get(line.split(".", 2)[0]);
		  treecount=new ArrayList<Integer>();
		  treecount.add(1);
		  main.push(treecount);
		  if(line.split(".", 2)[1].contains(".")){
			  
		  }
	  }
	  
	}
}
}
