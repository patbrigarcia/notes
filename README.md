This file describes a short definition on how to deploy and connect to the application.

1. Deploy the application to a server using the Jar file provided.
2. Connect to the API based on the configuration made in the server 
    
    Create a note: POST http://localhost:8080/users
    Get all notes: GET http://localhost:8080/users
    Get a note by ID: GET http://localhost:8080/users/{id}
    Update a note by ID: PUT http://localhost:8080/users/{id}
    Delete a note by ID: DELETE http://localhost:8080/users/{id}
