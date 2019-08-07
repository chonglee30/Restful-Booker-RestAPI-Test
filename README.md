# RestAPI-Practice-Test
Restful-Booker Application: RestAPI Test Project
The main purpose of thi project is to enhance my API test automation skill. Practice make perfect! 

A. Folders:
a. For Get Request: Get Request
   a) Code: com.restful.zippo.exercise
   b) Data: com.restful.zippo.data

b. For Update Request: Post, Put, Patch, Delete Requests
   a) Code: com.restful.jsonserver.exercise folder
   b) Data: com.restful.jsonserver.data folder


B. Code Details:
a) com.restful.zippo.exercise
1. GetZippoBasicFeaturesExercise.java: basic get functions
2. GetZippoOptimizingExercise.java:
1) requestSpec: specify commonly requested URL
2) responseSpec specify commonly used response

3. GetZippoParameterizingExercise.java
- use data provider to obtain data

4. GetZippoSerializationObjectsExercise.java
- ObjectSerialization

b) com.restful.jsonserver.exercise
1. GetJsonServerBasicExercise.java
   1) return all responses & specific response
   2) return response time

2. PostJsonServerBasicExercise.java
   1) Check the contents of body
   2) Use Specific ID to check after post
   3) Through object creation

3. PostJsonServerComplexExercise.java
   1) Post with an object and 
   2) Post with an array of objects

4. UpdateJsonServerBasicExercise.java
   1) Put 
   2) Patch 
   3) Delete 

Note: Due to update restrictions in the public apis, I use jsonserver to 
practice update apis.
http://localhost:3000/
http://localhost:3000/posts/1

Troubleshooting Tips:
Cannot bind to the port 3000.
Please specify another port number either through --port argument or through the json-server.json configuration file

a. json-server --port 3001 --watch db_InfoAdvanced.json

b. or kill the PID
Steps:
1. lsof -i :3000

check status of the reported PID :
ps ax | grep <PID>

2. kill -9 <PID>
Ex: kill -9 97438
kill -QUIT <PID>
