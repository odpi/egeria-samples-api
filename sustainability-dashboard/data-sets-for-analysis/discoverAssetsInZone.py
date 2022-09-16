# 
#  Zones in Egeria allow us to organize our assets into different collections based on use, community and visibility.
#  A digital asset can be a member of a single zone or multiple zones. In this issue we are exploring how to discover
#  what datasets are available in the zone called "sustainability". 
# 
#  This file contains a python function that can be called to return the assets within a zone.
#  The objective of this issue is to run this function with the right parameters and return the assets discovered.
#  You can use the "getGovernanceZoneMembers" function below to invoke the Egeria API that returns this
#  information.  Note that base_environment.py contains a set of utilities and definitions 
#  that are useful for working with Egeria from python.



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
#
#  Update the code here...
#
#
from base_environment import *
isDebug="False"
serverName="mds1"                                   # replace this value
serverPlatformName = "a platform"                   # replace this value
serverPlatformURL = "add platformURLRoot"           # replace this value
userID = "add user name"                            # replace this value
zoneName = "zone name"                              # replace this value

elements = getGovernanceZoneMembers(serverName, serverPlatformName, serverPlatformURL, userID, zoneName)

# Print out the values you discover (in a nice way, please)




