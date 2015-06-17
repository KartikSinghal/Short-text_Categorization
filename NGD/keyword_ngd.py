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


def bs(fwrite,j):
            url='http://academic.research.microsoft.com/RankList?entitytype=8&topDomainID=2&subDomainID=0&last=0&start='+str(j)+'&end='+str(j+99);
            print url
            if (j-1)%1000==0:
                print str(j)+'nodes processed'
            content = urllib2.urlopen(url).read()
            soup = BeautifulSoup(content, "html.parser")
            if soup:
                print 'true'
            i=0
            while(i<100):
                if(i<10):
                    for row in soup.find_all('a',attrs={'id' : 'ctl00_MainContent_ctl0'+str(i)+'_hypName'}):
                        row=str(row)
                        row=row.split(">")[1];
                        row=row.split("<")[0];
                        row=row.rstrip('\n');
                        fwrite.write(row);
                    for row1 in soup.find_all('td',attrs={'id' : 'ctl00_MainContent_ctl0'+str(i)+'_tdPulicationCount'}):
                        row1=str(row1)
                        row1=row1.split(">")[1];
                        row1=row1.split("<")[0];
                        row1=row1.strip();
                        fwrite.write(" ")
                        fwrite.write(row1)
                        fwrite.write('\n');
                else:
                    for row in soup.find_all('a',attrs={'id' : 'ctl00_MainContent_ctl'+str(i)+'_hypName'}):
                        row=str(row)
                        row=row.split(">")[1];
                        row=row.split("<")[0];
                        row=row.rstrip('\n');
                        fwrite.write(row)
                    for row1 in soup.find_all('td',attrs={'id' : 'ctl00_MainContent_ctl'+str(i)+'_tdPulicationCount'}):
                        row1=str(row1)
                        row1=row1.split(">")[1];
                        row1=row1.split("<")[0];
                        row1=row1.strip();
                        fwrite.write(" ")
                        fwrite.write(row1)
                        fwrite.write('\n');
                i=i+1;

fwrite=open('C:/Users/Kartik/Documents/BTP/academia_keywords4.txt','w');
j=30001
while(j<39000):
    bs(fwrite,j);
    j=j+100
