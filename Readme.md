Document Watermarking Service

Implemented as dummy implementation to perform watermarking operation on the document. 

To start the service run main method of the "com.springer.WatermarkApplication.java" class. 
It will start the Spring Boot server.

Following assumption are taken while implementing the functionality : 
1) Added three documents with id 1,2, and 3
   Document 1 and 2 are Book Object, while 3rd is the Journal object
   
2) Adding the watermark to an object is following call : 
        localhost:8080/add/1 or localhost:8080/add/2
	
	Output of above command for example can looks like following:
		"fdb2853a-7d16-49c8-96f1-e8fdfa99926a"
		
   The above call will return ticket in the form of an UUID object. 
   This ticket can be used to retrieve the document or check the status of wartermarking process
   
3) To logically implement the processing time, every time at add watermarking request is sent, the first 10 seconds are the request is
   the processing time of the request. The status can be checked by following command: 
        localhost:8080/checkStatus/<ticket>
		
	Output of above command for example can looks like following:
		"Watermarking process is complete"  or "Watermarking in process"
		
5) Finally the document can be retrieved by using following command:
		localhost:8080/retrieveDocument/<ticket>
		
	Output of above command for example can looks like following: 
	{"id":1,"title":"The Dark Code","author":"Bruce Wayne","watermark":{"content":"book","title":"The Dark Code","author":"Bruce Wayne","topic":"SCIENCE"},
	"type":"book","ticketID":"fdb2853a-7d16-49c8-96f1-e8fdfa99926a","topic":"SCIENCE","content":null}
