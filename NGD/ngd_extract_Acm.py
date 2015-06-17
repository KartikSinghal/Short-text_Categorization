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

def bs(a):
    Stringa=a.replace(" ","%20")
    url='http://academic.research.microsoft.com/Search?query='+Stringa;
    content = urllib2.urlopen(url).read()
    soup1 = BeautifulSoup(content, "html.parser")
    if soup1.find_all('span',attrs={"class" : "item-count"}):
        for row in soup1.find_all('span',attrs={"class" : "item-count"}):
            n1=int(row.text.replace("(","").replace(")",""));
    else:
        return -1;
    return n1;

i=0;
j=0;
keywordlist=[];
nodelist=[];
print 'Program initialized'
fcounter=open('C:/Users/Kartik/Documents/BTP/BTP_data_main/Counter1.txt','w');
fwrite=open('C:/Users/Kartik/Documents/BTP/BTP_data_main/WithoutcommaValues.txt','w');
with open('C:/Users/Kartik/Documents/BTP/abstract_data/keywords.txt') as fkeywords:
    for String1 in fkeywords:
        String1=String1.rstrip('\n');
        keywordlist.append(String1);
        i=i+1;
print keywordlist;
k=0;
l=0;
error=0;
while l<len(keywordlist):
    String2=keywordlist[l];
    print String2;
    l=l+1;
            #print String1, String2;
    try:
        n=bs(String2)
        fwrite.write(String2+' '+str(n));
        fwrite.write('\n');
        if l%1000==0:
            fwrite.flush();
            time.sleep(900);
        if l%5==0:
            print String2;
            print str(l)+'nodes processed for keyword '
    except Exception, e:
        print str(e);
        print String2;
        l=l-1;
        error=error+1;
        fwrite.flush();
        fcounter.write(str(k)+','+str(l)+','+str(error));
        fcounter.write(str(e));
        fcounter.write('\n');
        fcounter.flush();
fwrite.close()
fcounter.close()
