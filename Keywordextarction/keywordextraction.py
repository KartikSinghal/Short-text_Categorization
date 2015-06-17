#-------------------------------------------------------------------------------
# Name:        Keyword extraction using AlchemyAPI
# Purpose:
# Author:      Kartik
# Created:     16-09-2014
# Copyright:   (c) Kartik 2014
#-------------------------------------------------------------------------------

from alchemyapi import AlchemyAPI

# Create an AlchemyAPI object.
alchemyapi = AlchemyAPI()

# Enter abstract here
i=0;
fwrite=open('C:/Users/Kartik/Documents/BTP/abstract_data/keywords.txt','w');
with open('C:/Users/Kartik/Documents/BTP/abstract_data/abstracts.txt') as fp:
    for line in fp:
        i=i+1;
        fwrite.write('Paper : '+str(i)+'\n');
        response = alchemyapi.keywords('text', line, {'sentiment': 0})
        if response['status'] == 'OK':
            for keyword in response['keywords']:
                fwrite.write('text: '+','+ keyword['text'].encode('utf-8')+'\n')
                fwrite.write('relevance: '+','+keyword['relevance']+'\n')
                #print('sentiment: ', keyword['sentiment']['type'])
                #if 'score' in keyword['sentiment']:
                    #print('sentiment score: ' + keyword['sentiment']['score'])
                print('')
        else:
            print('Error in keyword extaction call: ', response['statusInfo'])
fwrite.close();