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

def topic_topic(a,b):
    Stringa=a.replace(" ","%20");
    Stringb=b.replace(" ","%20");
    url='http://academic.research.microsoft.com/Search?query='+Stringa;
    content = urllib2.urlopen(url).read()
    soupa = BeautifulSoup(content, "html.parser")
    for row in soupa.find_all('span',attrs={"class" : "item-count"}):
        n1=int(row.txt.replace("(","").replace(")",""));
    url='http://academic.research.microsoft.com/Search?query='+Stringb;
    content = urllib2.urlopen(url).read()
    soupb = BeautifulSoup(content, "html.parser")
    for row in soupb.find_all('span',attrs={"class" : "item-count"}):
        n2=int(row.txt.replace("(","").replace(")",""));
    url='http://academic.research.microsoft.com/Search?query='+Stringa+'%20'+Stringb;
    content = urllib2.urlopen(url).read()
    soupab = BeautifulSoup(content, "html.parser")
    for row in soup.find_all('span',attrs={"class" : "item-count"}):
        n3=int(row.txt.replace("(","").replace(")",""));
    ngd=Distance(n1,n2,n3);
    return ngd;

String1="Data Mining";
i=0;
with open('C:/Users/Kartik/Documents/BTP/acmmap.txt') as fp:
    for line in fp:
        String2= line.split(" ",1)[1];
        String2=String2.rstrip('\n');
        print String1, String2;
        n1=topic_topic(String1,String2)
        print n1
        print "ith call = "+str(i);
        i=i+1;
        if i==300:
            break;
        String1=String2;