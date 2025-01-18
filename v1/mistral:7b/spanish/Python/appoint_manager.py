# ¡Hola! Aquí hay un ejemplo de cómo podría verse un pequeño programa en Python utilizando el módulo `requests` para gestionar las citas de un negocio. Este programa incluye funciones para crear, borrar, actualizar y listar citas a través de una API REST.

# Primero, instala el módulo `requests` mediante:
# ```
# pip install requests
# ```
# A continuación, aquí tienes un ejemplo del código para gestionar las citas:

# ```python
import requests
import json

API_URL = "http://localhost:8000/api/"
HEADER = {"Content-Type": "application/json"}

def create_appointment(client_id, service_id, date):
    data = {'client_id': client_id, 'service_id': service_id, 'date': date}
    response = requests.post(API_URL + "appointments", headers=HEADER, json=data)
    return json.loads(response.content)

def delete_appointment(appointment_id):
    response = requests.delete(API_URL + f"appointments/{appointment_id}", headers=HEADER)
    return json.loads(response.content)

def update_appointment(appointment_id, client_id=None, service_id=None, date=None):
    data = {}
    if client_id is not None:
        data['client_id'] = client_id
    if service_id is not None:
        data['service_id'] = service_id
    if date is not None:
        data['date'] = date
    response = requests.put(API_URL + f"appointments/{appointment_id}", headers=HEADER, json=data)
    return json.loads(response.content)

def list_appointments():
    response = requests.get(API_URL + "appointments", headers=HEADER)
    return json.loads(response.content)

if __name__ == "__main__":
    # Crea una cita
    appointment = create_appointment(1, 2, "2022-03-15T14:00:00")
    print("Creación exitosa:", appointment)

    # Lista las citas
    appointments = list_appointments()
    print("\nListado de citas:")
    for appointment in appointments:
        print(appointment)

    # Actualiza una cita
    update_appointment(appointment["id"], client_id=3, date="2022-03-16T14:00:00")

    # Lista las citas nuevamente para comprobar el cambio
    appointments = list_appointments()
    print("\nListado de citas actualizado:")
    for appointment in appointments:
        print(appointment)

    # Borra una cita
    delete_appointment(appointment["id"])
# ```

# Recuerda adaptar la URL API según el servicio que utilices. Asegúrate de crear los métodos correspondientes en tu API REST para realizar las acciones de creación, borrado, actualización y listado de citas. También puedes añadir más validaciones y comprobar errores según necesites.

# Espero que este código te sea útil! ¡Buena suerte en tu desarrollo de la API REST!