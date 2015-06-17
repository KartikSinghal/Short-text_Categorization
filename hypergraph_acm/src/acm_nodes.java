import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class acm_nodes {
	public static void main(String args[]) throws IOException{
		BufferedReader in1 = new BufferedReader(new FileReader("C:\\Users\\Kartik\\Downloads\\NewDownloads\\ccs98.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Downloads\\NewDownloads\\out.txt"));
		BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Downloads\\NewDownloads\\out1.txt"));
		BufferedWriter outweight = new BufferedWriter(new FileWriter("C:\\Users\\Kartik\\Downloads\\NewDownloads\\outweight.txt"));
		String line;
		String jcurrent,jprev,kprev,kcurrent="0";
		int Buffer_Size=1000;
		char iprev='C';
		Map<String,String> main=new HashMap<String,String>();
		jprev="5";
		kprev="0";
		char icurrent;
		ArrayList<String> parentnodes=new ArrayList<String>();;
		ArrayList<String> subparentnodes=new ArrayList<String>();
		int flag;
		String s1,s2 = null,s3 = null,s4 = null,s5;
		int l=0;
		double weight = 0;
		int m;
		while(true){
			flag=0;
			in1.mark(Buffer_Size);
			line=in1.readLine();
			if(line==null){
				break;
			}
			//System.out.println(line);
			if(!line.equals("")){
				StringTokenizer st=new StringTokenizer(line," ");
				s1=st.nextToken();
				//System.out.println(s1);
				if(true){
				StringTokenizer stnode=new StringTokenizer(s1,".");
				if(stnode.hasMoreTokens())
					{s2=stnode.nextToken();
					icurrent=s2.charAt(0);}
				else
					continue;
				//System.out.println(s2);
				
				if(icurrent==iprev){
					if(stnode.hasMoreTokens())
						{s3=stnode.nextToken();
						jcurrent=s3;}
					else
						continue;
					
					if(jcurrent.equals(jprev)){
						if(stnode.hasMoreTokens())
						s4=stnode.nextToken();
						else{
							l=-1;
							System.out.println(icurrent+"."+jcurrent+"."+String.valueOf(l));
							while(!line.equals("")){
								line=in1.readLine();
								//System.out.println(line);
								l++;
								main.put(icurrent+"."+jcurrent+"."+String.valueOf(l), line);
								System.out.println(icurrent+"."+jcurrent+"."+String.valueOf(l));
								out.write(icurrent+"."+jcurrent+"."+String.valueOf(l));
								out.write(",");
								subparentnodes.add(icurrent+"."+jcurrent+"."+String.valueOf(l));
								parentnodes.add(icurrent+"."+jcurrent+"."+String.valueOf(l));
								
							}
						}
						kcurrent=s4;
							l=-1;
							System.out.println(icurrent+"."+jcurrent+"."+kcurrent+"."+String.valueOf(l));
							while(!line.equals("")){
								line=in1.readLine();
								//System.out.println(line);
								l++;
								main.put(icurrent+"."+jcurrent+"."+kcurrent+"."+String.valueOf(l), line);
								System.out.println(icurrent+"."+jcurrent+"."+kcurrent+"."+String.valueOf(l));
								out.write(icurrent+"."+jcurrent+"."+kcurrent+"."+String.valueOf(l));
								out.write(",");
								subparentnodes.add(icurrent+"."+jcurrent+"."+kcurrent+"."+String.valueOf(l));
								parentnodes.add(icurrent+"."+jcurrent+"."+kcurrent+"."+String.valueOf(l));
								
							}
						// weight=1/l;
						 outweight.write(String.valueOf(weight));
						 outweight.newLine();
						 outweight.flush();
						 out.newLine();
						 out.flush();
						 out1.write(icurrent+"."+jcurrent+"."+kcurrent);
						 out1.newLine();
						 out1.flush();
					}
					else{
						//weight=weight/2;
						
						outweight.write(String.valueOf(weight));
						outweight.newLine();
						outweight.flush();
						outweight.write(String.valueOf(weight));
						main.put(icurrent+"."+jcurrent, line);
						jprev=jcurrent;
						for(m=0;m<subparentnodes.size();m++){
							out.write(subparentnodes.get(m));
							out.write(",");
						}
						out.newLine();
						out.flush();
						if(!subparentnodes.isEmpty())
						out1.write(subparentnodes.get(0).charAt(0)+"."+subparentnodes.get(0).charAt(2));
						out1.newLine();
						out1.flush();
						subparentnodes=new ArrayList<String>();
						in1.reset();
					}
				}
				else{
					//weight=weight/2;
					System.out.println(true);
					outweight.write(String.valueOf(weight));
					outweight.newLine();
					outweight.flush();
					main.put(String.valueOf(icurrent), line);
					iprev=icurrent;
					for(m=0;m<parentnodes.size();m++){
						out.write(parentnodes.get(m));
						out.write(",");
					}
					out.newLine();
					if(!parentnodes.isEmpty())
					out1.write(parentnodes.get(0).charAt(0));
					out1.newLine();
					out1.flush();
					out.flush();
					
					parentnodes=new ArrayList<String>();
					in1.reset();
				}
			}
			}
		}
	}
}
