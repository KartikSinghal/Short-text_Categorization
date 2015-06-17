#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kartik
#
# Created:     15-03-2015
# Copyright:   (c) Kartik 2015
# Licence:     <your licence>
#-------------------------------------------------------------------------------

keywordlist=[]
fcounter=open('C:/Users/Kartik/Documents/BTP/BTP_data_main/and_values.txt','w');
with open('C:/Users/Kartik/Documents/BTP/BTP_data_main/and_categories.txt') as fp:
    for String2 in fp:
        String2= String2.split(" ",1)[1];
        String2=String2.rstrip('\n');
        String2=String2.replace('*','');
        keywordlist.append(String2)
l=0;
while l<len(keywordlist):
    String2=keywordlist[l];
    l=l+1;
    if 'and' in String2:
        fcounter.write(String2);
        fcounter.write('\n');
        fcounter.flush();
    elif 'AND' in String2:
        fcounter.write(String2);
        fcounter.write('\n');
        fcounter.flush();