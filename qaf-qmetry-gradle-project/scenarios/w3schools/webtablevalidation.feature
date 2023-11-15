Feature: Github Login

Scenario Outline: Validate user can login with valid credential

	Given user is on w3school home page
		When store values 
#			Then retreive stored values
#		When user stores row '<rowNumber>' data in key '<storedValue>'
#		When user saves row '<rowNumber>' values in hashmap and stores them in a keyy '<storedValue>'
#			Then verfies column value for given column name from map 'storedValue'  
#	 			And Test 
				
	Examples: {'groups':[customerInfo],'dataFile':'resources/uat/w3school/data/customerinfor.json'} 
	
	
Scenario Outline: Validate Header
	Given user is on w3school home page
		When header row '3'
	
	
	Examples: {'groups':[header]} 