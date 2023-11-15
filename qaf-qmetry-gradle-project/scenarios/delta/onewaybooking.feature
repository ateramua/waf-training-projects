Feature: Booking Page Validation

Scenario Outline: Validate One Way Booking

Given User is on Delta Booking Page 
	When user selects one way trip
#	When User clicks on Trip type dropdown
#		And User selects trip type '<trip>'
#	When User clicks on From Link
#And User enters departure airport '<dAirPort>'
#And User selects departure airport '<dAirPort>' from search results 
#And User clicks on To link
#And User enters destination airport 'DCA'
#And User selects destination airport from search results
#And User selects trip type 'oneway'
#And User selects departure date '02/05/2022'
#And User selects number of passenger '2'
#And User clicks on search button
#Then list of flights should generate

Examples: {'groups':[login],'dataFile':'resources/uat/delta/data/onewaybooking.json'}

Scenario Outline: Validate user is able to book a one way flight 
	Given User is on Kayak Booking Page
	

Examples: {'groups':[kayakLogin],'dataFile':'resources/uat/delta/data/onewaybooking.json'}
