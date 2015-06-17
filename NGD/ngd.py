#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kartik
#
# Created:     04-11-2014
# Copyright:   (c) Kartik 2014
# Licence:     <your licence>
#-------------------------------------------------------------------------------
import time
import math
import glob
import sys,urllib

time_Count=0
extracted_author=[]
extracted_topic=[]
extracted_A_T=[]
extracted_A_A=[]
extracted_T_T=[]

def Reads(name):
    f1 = open(name,'r')
    S1=str(f1.readlines())
    #f1.close
    error='We did not find any result related to'
    ind=S1.find(error)
    if ind>0:
        return 0.01

def Distance(x,y,xy):
    fx=math.log(x)
    fy=math.log(y)
    fxy=math.log(xy)
    M=math.log(15000000)
    NGD=(max(fx,fy)-fxy)/(M-min(fx,fy))
    return NGD

def Vals_topic_topic(a,b):
    global time_Count
    file1='C:/Users/Kartik/Documents/BTP/Bing/html_a/topic_'+a.replace(" ","_").replace(':','_').replace('*','_')+'.html'
    file2='C:/Users/Kartik/Documents/BTP/Bing/html_b/topic_'+ b.replace(" ","_").replace(':','_').replace('*','_')+'.html'
    file3='C:/Users/Kartik/Documents/BTP/Bing/html_a_b/topic_'+a.replace(" ","_").replace(':','_').replace('*','_')+'_'+ b.replace(" ","_").replace('*','_').replace(':','_')+'.html'
    if a not in extracted_topic:
        Query1='http://academic.research.microsoft.com/Search?query='+a
        #print Query1
        URL1='wget --user-agent Chrome '+Query1+' -O '+file1
        if time_Count==5:
            time.sleep(10)
            time_Count=0

        urllib.urlretrieve(Query1[0:],file1)
        time_Count=time_Count+1
        #os.system("wget "+URL1)
        extracted_topic.append(a)
    #print Query1
    if b not in extracted_topic:
        Query2='http://academic.research.microsoft.com/Search?query='+b
        URL2='wget --user-agent Chrome '+Query2+' -O '+file2
        if time_Count==5:
            time.sleep(10)
            time_Count=0
        urllib.urlretrieve(Query2[0:],file2)
        time_Count=time_Count+1
        #os.system("wget "+URL2)
        extracted_topic.append(b)
    #print Query2
    if a+'_'+b not in extracted_T_T:
        Query3='http://academic.research.microsoft.com/Search?query='+a+' '+b
        URL3='wget --user-agent Chrome '+Query3+' -O '+file3
        if time_Count==5:
            time.sleep(10)
            time_Count=0
        urllib.urlretrieve(Query3[0:],file3)
        time_Count=time_Count+1
        #os.system("wget "+URL3)
        extracted_T_T.append(a+'_'+b)
    #print Query3

    f1 = open(file1,'r')
    f2 = open(file2,'r')
    f3 = open(file3,'r')

    S1=str(f1.readlines())
    #f3.close()
    key='Publications <span class="item-count">('
    key_len=len(key)

    start=S1.find(key)+key_len
    stop=S1.find(')</span> </a>',start)
    try:
        val1=float((S1[start:stop]).replace(",",""))
        #print val1
    except ValueError:
        val1=Reads(file1)
    S1=str(f2.readlines())
    #f3.close()
    key='Publications <span class="item-count">('
    key_len=len(key)

    start=S1.find(key)+key_len
    stop=S1.find(')</span> </a>',start)
    try:
        val2=float((S1[start:stop]).replace(",",""))
        #print val2
    except ValueError:
        val2=Reads(file2)
    S1=str(f3.readlines())
    #f3.close()
    key='Publications <span class="item-count">('
    key_len=len(key)

    start=S1.find(key)+key_len
    stop=S1.find(')</span> </a>',start)
    try:
        val3=float((S1[start:stop]).replace(",",""))
        #print val3
    except ValueError:
        val3=Reads(file3)
    f1.close()
    f2.close()
    f3.close()
    return (val1,val2,val3)

def Answer_topic_topic(a,b):
    #print a,b
    if a==b:
        #print a+"="+b
        return 0
    (x,y,xy)=Vals_topic_topic(a,b)
    #print x,y,xy
    return Distance(x,y,xy)

# When I call this it runs
"""n1=Answer_topic_topic("GENERAL", "Biographies autobiographies")
print n1"""
# When I run this loop it is giving an error
String1="Data Mining";
i=0;
with open('C:/Users/Kartik/Documents/BTP/acmmap.txt') as fp:
    for line in fp:
        String2= line.split(" ",1)[1];
        String2=String2.rstrip('\n');
        print String1, String2;
        n1=Answer_topic_topic(String1,String2)
        #print String1, String2;
        print n1
        print "ith call = "+str(i);
        i=i+1;
        if i==300:
            break;
        String1=String2;