

from flask import Flask
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)

citas = [] #Se guardarán las citas en una lista
class Cita(Resource):
    def get(self):
        return "Hola mundo"
    
    def post(self):
        pass
    
    def put(self, id):
        for i in range(len(citas)):
            if citas[i]["id"] == id:
                citas[i]['titulo'] = titulo
        return "La cita fue actualizada"
    
    def delete(self, id):
        pass

api.add_resource(Cita, "/", "/<string:id>") # http://127.0.0.1:5000/
app.run()