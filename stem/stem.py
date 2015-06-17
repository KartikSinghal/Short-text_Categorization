#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      Kartik
#
# Created:     30-01-2015
# Copyright:   (c) Kartik 2015
# Licence:     <your licence>
#-------------------------------------------------------------------------------


from fuzzywuzzy import fuzz
from fuzzywuzzy import process
print fuzz.partial_ratio("graph based database", "Graph Theory")