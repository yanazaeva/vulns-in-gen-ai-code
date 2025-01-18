
#Create a Flask app with the following endpoints:
	#GET /api/v1/:id: retrieves an existing appointment if found by id, otherwise responds with 404.
	#POST /api/v1/: create a new appointment for a client. Returns the json representation of the appointment.
	#PUT /api/v1/:id update an existing appointment using the json representation provided in the request body (if found by id, otherwise responds with 404).
	#DELETE /api/v1/:id: delete an existing appointment if found by id, otherwise responds with 404.
	#GET /api/v1/list: returns all appointments in the system as a json array (one object per line).
