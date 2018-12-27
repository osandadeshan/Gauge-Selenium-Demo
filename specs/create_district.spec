# Create District Specification

Project Name    : Gauge-UI-Automation-Demo
Developer       : Kushani Karunarathne
Version         : 1.0.0
Date            : 12/23/2018
Time            : 9:41 AM
Description     : This is an executable specification file which covers the login scenarios.


table: ./resources/test_data/csv/create_district.csv



## Create District Scenario

* Login as the Virtuoso Admin
* Page title equals to the "Home Page Title" in "Test Data" excel sheet
* On District Creation page
* Create a new district 

   |District Name  |Address  |Email Domain  |Realam  |FirstName  |LastName  |EMP No  |
   |---------------|---------|--------------|--------|-----------|----------|--------|
   |<District Name>|<Address>|<Email Domain>|<Realam>|<FirstName>|<LastName>|<EMP No>|

* Scroll to the district from district name saved in data store

_______________________________
* Sign out from the application
