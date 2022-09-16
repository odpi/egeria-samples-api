import csv
import time
import os
import urllib3
import requests
import pprint
import json
urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

isDebug = False

#
# This is directory where the sample data from the Egeria distribution has been unpacked in.  The default value
# describes its location in an IntelliJ workspace.  The default value can be overridden using the "egeriaDistributionRoot" 
# environment variable.
#
egeriaSampleDataRoot = os.environ.get('egeriaSampleDataRoot', '.')

#
# Common processing of REST API errors.
#



def printResponse(response):
    prettyResponse = json.dumps(response.json(), indent=4)
    print(" ")
    print("Response: ")
    print(prettyResponse)
    print(" ")
    
def printUnexpectedResponse(serverName, serverPlatformName, serverPlatformURL, response):
    if response.status_code == 200:
        relatedHTTPCode = response.json().get('relatedHTTPCode')
        if relatedHTTPCode == 200:
            print("Unexpected response from server " + serverName)
            printResponse(response)
        else:
            exceptionErrorMessage = response.json().get('exceptionErrorMessage')
            exceptionSystemAction = response.json().get('exceptionSystemAction')
            exceptionUserAction   = response.json().get('exceptionUserAction')
            if exceptionErrorMessage != None:
                print(exceptionErrorMessage)
                print(" * " + exceptionSystemAction)
                print(" * " + exceptionUserAction)
            else:
                print("Unexpected response from server " + serverName)
                printResponse(response)
    else:
        print("Unexpected response from server platform " + serverPlatformName + " at " + serverPlatformURL)
        printResponse(response)

#
# Rest calls, these functions issue rest calls and print debug if required.
# 
def issuePost(url, body):
    if (isDebug):
        printRestRequest("POST " + url)
        printRestRequestBody(body)
    jsonHeader = {'content-type':'application/json'}
    response=requests.post(url, json=body, headers=jsonHeader, verify=False)
    if (isDebug):
        printRestResponse(response) 
    return response

def issueDataPost(url, body):
    if (isDebug):
        printRestRequest("POST " + url)
        printRestRequestBody(body)
    jsonHeader = {'content-type':'text/plain'}
    response=requests.post(url, data=body, verify=False)
    if (isDebug):
        printRestResponse(response) 
    return response

def issuePut(url, body):
    if (isDebug):
        printRestRequest("PUT " + url)
        printRestRequestBody(body)
    jsonHeader = {'content-type':'application/json'}
    response=requests.put(url, json=body, headers=jsonHeader, verify=False)
    if (isDebug):
        printRestResponse(response) 
    return response

def issueGet(url):
    if (isDebug):
        printRestRequest("GET " + url)
    jsonHeader = {'content-type':'application/json'}
    response=requests.get(url, headers=jsonHeader, verify=False)
    if (isDebug):
        printRestResponse(response) 
    return response

def printRestRequest(url):
    print (" ")
    print (url)
    
def printRestRequestBody(body):   
    prettyBody = json.dumps(body, indent=4)
    print (prettyBody)
    print (" ")
    
def printRestResponse(response): 
    print ("Returns:")
    prettyResponse = json.dumps(response.json(), indent=4)
    print (prettyResponse)
    print (" ")

def processErrorResponse(serverName, serverPlatformName, serverPlatformURL, response):
    if response.status_code != 200:
        printUnexpectedResponse(serverName, serverPlatformName, serverPlatformURL, response)
    else:
        relatedHTTPCode = response.json().get('relatedHTTPCode')
        if relatedHTTPCode != 200:
             printUnexpectedResponse(serverName, serverPlatformName, serverPlatformURL, response)
    return []

def postAndPrintResult(url, json=None, headers=None):
    print ("   ...... (POST", url, ")")
    response = requests.post(url, json=json, headers=headers, verify=False)
    print ("   ...... Response: ", response.json())



