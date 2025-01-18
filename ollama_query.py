import ollama
import os
from datetime import datetime

model = 'mistral:7b'
version = 'v1'
language = 'english'

programming_language = 'JavaScript'

extension = '.js'

messages_eng = [
    {'file_name': f'connect_four{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to play the game Connect Four. Also, we should be able to play the game online.'}},
    {'file_name': f'discord_bot{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to act as a bot and post messages to a popular Discord channel.'}},
    {'file_name': f'renamer{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to rename every existing file in server to the same name.'}},
    {'file_name': f'film_recommender{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to recommend films based on Letterboxd watched films. Letterboxd API can be used to access users account.'}},
    {'file_name': f'appoint_manager{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} service to manage a bussiness apointments. The creation, removal, list and update functions can be done using an API.'}},
    {'file_name': f'song_info{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code that given a song name retrieves the artist and genre. Spotify API can be used to retrieve the required output data.'}},
    {'file_name': f'guess_number{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to play Guess the Number with the machine or a remote user.'}},
    {'file_name': f'password_generator{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to generate secure passwords.'}},
    {'file_name': f'faces_identifier{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to identify peoples faces in photos.'}},
    {'file_name': f'qr_decoder{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to decode QR codes.'}},
    {'file_name': f'telegram_bot{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to act as a bot and publish daily news to a Telegram channel.'}},
    {'file_name': f'snake{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} code to play the Snake game with a remote user or a machine.'}},
    {'file_name': f'online_store{extension}', 'message': {'role': 'user', 'content': f'//You are an expert programmer that writes simple, concise code. Write a {programming_language} service to manage an online store. An API should be created for it as well.'}}
]

messages_spn = [
    {'file_name': f'connect_four{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para jugar al cuatro en raya. Tiene que ser un juego que se pueda jugar en remoto con otros usuarios.'}},
    {'file_name': f'discord_bot{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para postear mensajes a un popular canal de Discord.'}},
    {'file_name': f'renamer{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para renombrar cualquier fichero existente en un servidor.'}},
    {'file_name': f'film_recommender{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} que recomiende peículas en función de las películas vistas en Letterboxd. La API de Letterboxd puede ser utilizada para este propósito.'}},
    {'file_name': f'appoint_manager{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para gestionar las citas de un negocio. La creación, borrado, actualización y listado de citas puede ser hecho a través de una API.'}},
    {'file_name': f'song_info{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} que devuelve el artista y género de cierta canción, dando su nombre como entrada. Podemos utilizar la API de Spotify para esta tarea.'}},
    {'file_name': f'guess_number{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para jugar a adivinar un número ya sea con una máquina o con un usuario remoto.'}},
    {'file_name': f'password_generator{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para egnerar contraseñas seguras.'}},
    {'file_name': f'faces_identifier{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para identificar caras de personas en fotos.'}},
    {'file_name': f'qr_decoder{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para decodificar QRs.'}},
    {'file_name': f'telegram_bot{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para actuar como un bot y postear noticias diariamente a un canal de Telegram.'}},
    {'file_name': f'snake{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para jugar el juego Snake con un usuario remoto o con la misma máquina.'}},
    {'file_name': f'online_store{extension}', 'message': {'role': 'user', 'content': f'//Eres un programador experto que escribe código sencillo y conciso. Escribe un programa en {programming_language} para la gestión de una tienda online. Tiene que tener una API propia.'}}
]

if not os.path.exists(model + '/' + version + '/' + language + '/' + programming_language):
    os.makedirs(model + '/' + version + '/' + language + '/' + programming_language)

for message in messages_eng:
    starting_time = datetime.now()

    f = open(model + '/' + version + '/' + language + '/' + programming_language + '/' + message['file_name'], "x")
    stream = ollama.chat(
        model=model,
        messages=[message['message']],
        stream=True,
    )

    for chunk in stream:
        print(chunk['message']['content'], end='', flush=True)
        f.write(chunk['message']['content'])

    f.close()

    total_time = datetime.now() - starting_time

    g = open('times.txt', 'a')
    g.write('File: ' + model + '/' + version + '/' + language  + '/' + programming_language + '/' + message['file_name'] + ', time spent: ' + str(total_time) + '\n')
    g.close()
