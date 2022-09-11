# FindMyRecycling

---

Design Document

Matthew Caudill
Matthew Dupont
Samuel Gehrlich
Christian Grothaus
Gabe Phan

## Introduction

Do you want to recycle, but don’t know where to take it? Have harsh chemicals that you can’t put in the trash? FindMyRecycling can help you:

-	Search for recycling centers near you
-	Save centers for easy access
-	Add centers near you

Users can interact with FindMyRecycling using either a set of RESTful service endpoints, a simple UI, or both.  

## [Storyboard](https://projects.invisionapp.com/prototype/cl7x0sb6b000am501n3cni6cn/play)  

![storyboard1](https://user-images.githubusercontent.com/82420942/189517173-75542ec1-e141-4572-a6b0-243d04a5ff99.png)
![storyboard2](https://user-images.githubusercontent.com/82420942/189517177-f17d447f-3a39-4579-8bb6-4c3f65687047.png)

## Functional Requirements

1.	As a college student, I want to be able to find recycling centers near me that recycle glass, so that I will be able to recycle.  
**given**: A feed of facility data are available  
**when**: The user/service specifies the recyclable material as Glass  
**when**: The user/service specifies the location as 45236  
**then**: Blue Ash Recreational Center should be in the set of results  

2.	As a user, I want to be able to add a facility that is not already in the database  
**given**: A user is logged in, and internet connection is available  
**when**: The user fills out all required fields  
**then**: The data are saved to the database  

3.	As a college student, I want to be able to find recycling centers near me, **but** I want to see what materials   facilities can recycle near me, so that I will be able to recycle.  
**given**: A feed of facility data are available  
**when**: The user/service specifies the location as 45236  
**then**: A list of facilities in Blue Ash, OH  

## Class Diagram

![FindMyRecyclingClassDiagram](https://user-images.githubusercontent.com/82420942/189517489-235ab46c-3bcc-47cf-88d3-48c73023a28f.jpg)

### Class Diagram Description

**EnterpriseApplication** - Starts up our SpringBoot application  
**RecyclingCenterFinderController** - Where we interact with the user through endpoints or possibly a webpage.  
**RecyclableMaterial** - Noun class that represents a recyclable material.  
**Facility** - Noun class that represents a recycling facility.  
**Photo** - Noun class that represents a photo.  
**FacilityDAO** - Interface for Facility.  
**RecyclableMaterialDAO** - Interface for RecyclableMaterials.  
**PhotoDAO** - Interface for Photo.  

## Json Schema

    {
     "type": "object",
     "properties" : {
        "materialID" : {
         "type" : "int"
       },
      "facilityID" : {
         "type" : "int"
       },
        "facilityName" : {
         "type" : "string"
       },
      "facilityPhotos" : {
         "type" : "string"
       },
      "facilityDetails" : {
         "type" : "string"
       },
      "facilityAddress" : {
         "type" : "string"
       },
      "facilityCoordinates" : {
         "type" : "decimal"
       },
      }
    }

## Scrum Roles  

UI - Samuel Gehrlich   
Business Logic and Persistence – Matthew Dupont, Christian Grothaus, Gabe Phan  
DevOps/Scrum Master – Matthew Caudill  

## [Github](https://github.com/Smoofington/FindMyRecyclingIntellijIDEA)  

## Weekly Meeting  
Tuesdays @ 9 PM EST & Fridays @ 6 PM EST on Discord
