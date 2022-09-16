# 
#  A data pipeline is responsible for copying, transforming and combining data so it is stored
#  in a convenient location and format for new processes, such as analytics, and reports. 
#
#  This file contains some placeholder functions that simulate:
#       1) Aggregating data to calculate carbon emissions
#       2) Performing the caluclations using the GHG processes
#       3) Storing the results in the gh_coco_sus database so that they can be visualized
#  
#  The objective of this issue is to capture the execution of these functions using the
#  lineage capabilities of Egeria.



#
#  Simulate the aggregation and preparation of data from the gh_coco_ods database. Data is found
#  in the tables coco_locations, supply_order_details, and sites.
#
def prepareSustainabilityData():
    print("We are simulating the acquisition, aggregation and preparation of activity data needed for carbon calculations")
  


#
#   Simulate the computation of carbon equivalent emissions using calculations based on the GHG protocols that
#   can be found at https://ghgprotocol.org/calculation-tools#cross_sector_tools_id.
# 
def calculateCarbonEquivalence(): 
    print("We are simulating the calculation of equivalent carbon emissions")



#
#   Simulate the storage of the results into the coco_sus database to support the reporting and visualization
#   carbon equivalent emissions.
# 
def recordCalculatedEmissions():
    print("We are simulating the storing of the calculated emissions data into the ghg_emissions table in the coco_sus database")   

#
#
#  Your code goes here...
#
#
#  Using Egeria's Restful APIs, you will need to:
#   1) create a catalog entry in Egeria for the source database (coco_ods)
#   2) create a catalog entry in Egeria for the target database (coco_sus)
#   3) document the lineage for the above data pipeline in Egeria
#
#  There are many restful APIs - you can investigate the available APIs at https://169.60.147.206:30080/swagger-ui/index.html
#
#  Some of the APIs that may be helpful can be found at:
#   https://169.60.147.206:30080/swagger-ui/index.html#/Data%20Manager%20OMAS/createDatabase
#   https://169.60.147.206:30080/swagger-ui/index.html#/Data%20Manager%20OMAS/createDatabaseTable
#   https://169.60.147.206:30080/swagger-ui/index.html#/IT%20Infrastructure%20OMAS/setupDataFlow
#
#   Here are a couple of examples on how to issue some rest calls to Egeria - one is a Post and one is a Get.
#
#   assetOnwerSearchForAssets returns assets that match the regular expression in the searchString
#
def assetOwnerSearchForAssets(serverName, serverPlatformName, serverPlatformURL, userId, searchString):
    assetOwnerURL = serverPlatformURL + '/servers/' + serverName + '/open-metadata/access-services/asset-owner/users/' + userId
    getAssetsURL = assetOwnerURL + '/assets/by-search-string?startFrom=0&pageSize=50'
    response = issueDataPost(getAssetsURL, searchString)
    if response:
        assets = response.json().get('assets')
        if assets:
            return assets
        else:
            print ("No assets found")
            processErrorResponse(serverName, serverPlatformName, serverPlatformURL, response)
    else:
        print ("Search Request Failed")    

# Get Governance Zone Members
def getGovernanceZoneMembers(serverName, serverPlatformName, serverPlatformURL, userId, zoneName):
    commonServicesURL = serverPlatformURL + '/servers/' + serverName + '/open-metadata/access-services/governance-program/users/' + userId 
    getZonesURL = commonServicesURL + '/review/governance-zones/' + zoneName + "/members/Asset?startFrom=0&pageSize=0"
    response=issueGet(getZonesURL)
    elements = response.json().get('elements')
    if elements:
        return elements
    else:
        print ("No assets found")
        print (response.json())
        processErrorResponse(serverName, serverPlatformName, serverPlatformURL, response)


#
# Here is an example of calling these functions - note that base_environment.py contains a set of utilities and definitions 
# that are useful for working with Egeria from python.
from base_environment import *

prepareSustainabilityData()
calculateCarbonEquivalence()
recordCalculatedEmissions()

isDebug="False"
serverName="cocoMDS2"
serverPlatformName = "Data Lake Platform"
serverPlatformURL = "https://169.60.147.206:30080"
userID = "erinoverview"
elements = getGovernanceZoneMembers(serverName, serverPlatformName, serverPlatformURL, userID, "sustainability")
print(elements)





