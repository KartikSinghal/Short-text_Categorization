#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kartik
#
# Created:     11-12-2014
# Copyright:   (c) Kartik 2014
# Licence:     <your licence>
#-------------------------------------------------------------------------------
import time
import math
import glob
import sys
import urllib, urllib2
from bs4 import BeautifulSoup, Comment

def Distance(x,y,xy):
    fx=math.log(x)
    fy=math.log(y)
    fxy=math.log(xy)
    M=math.log(15000000)
    NGD=(max(fx,fy)-fxy)/(M-min(fx,fy))
    return NGD

def bs(a,b):
    Stringa=a.replace(" ","%20")
    Stringb=b.replace(" ","%20")
    url='http://academic.research.microsoft.com/Search?query='+Stringa+'%20'+Stringb;
    content = urllib2.urlopen(url).read()
    soup = BeautifulSoup(content, "html.parser")
    for row in soup.find_all('span',attrs={"class" : "item-count"}):
        n1=int(row.text.replace("(","").replace(")",""));
    url='http://academic.research.microsoft.com/Search?query='+Stringa;
    content = urllib2.urlopen(url).read()
    soup1 = BeautifulSoup(content, "html.parser")
    for row in soup1.find_all('span',attrs={"class" : "item-count"}):
        n2=int(row.text.replace("(","").replace(")",""));
    url='http://academic.research.microsoft.com/Search?query='+Stringb;
    content = urllib2.urlopen(url).read()
    soup2 = BeautifulSoup(content, "html.parser")
    for row in soup2.find_all('span',attrs={"class" : "item-count"}):
        n3=int(row.text.replace("(","").replace(")",""));
    ngd=Distance(n2,n3,n1)
    return ngd;

i=0;
j=0;
print 'Program initialized'
fwrite=open('C:/Users/Kartik/Documents/BTP/Values.txt','w');
with open('C:/Users/Kartik/Documents/BTP/abstract_data/keywords.txt') as fkeywords:
    for String1 in fkeywords:
        String1=String1.rstrip('\n');
        j=j+1;
        fwrite.write('\n');
        try:
            with open('C:/Users/Kartik/Documents/BTP/acmmapunique.txt') as fp:
                for line in fp:
                    String2= line.split(" ",1)[1];
                    String2=String2.rstrip('\n');
                    String2=String2.replace('*','');
                    #print String1, String2;
                    n=bs(String1,String2)
                    #print String1,String2;
                    fwrite.write(str(n)+',');
                    #print n;
                    #fwrite.flush;
                    i=i+1;
                    if i==249:
                        fwrite.flush();
                        time.sleep(900);
                        i=0;
                    if i%20==0:
                        print String1, String2;
                        print str(i)+'nodes processed'
        except Exception, e:
            print str(e);
            print String1, String2;
            fwrite.write();
            fwrite.flush();
            fcounter=open('C:/Users/Kartik/Documents/BTP/Counter.txt','w');
            fcounter.write(str(j)+','+str(i));
            fcounter.close();
fwrite.close()

