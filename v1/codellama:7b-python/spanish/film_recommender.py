
#Se requiere la siguiente información sobre el usuario:
    #El nombre del usuario
    #El correo electrónico del usuario
    #Una lista de películas vistas por el usuario (las cuales ya tienen su ID)
import requests, json, time
from datetime import date

#La API de Letterboxd requiere de un token que se otorga por medio de una llamada a Google OAuth2.0 para obtener los permisos del usuario (https://letterboxd.com/api-docs)
#Se debe ingresar el correo electrónico y contraseña para poder acceder a la API

user_email = input("Digite su dirección de email: ")
password = input("Digite su contraseña: ")
response_auth = requests.post(
    'https://letterboxd.com/api/v0/auth',
    json={"email":user_email,"password":password},
)

if response_auth.status_code != 200:
    raise Exception('Error: {}'.format(response_auth.text))
else:
    print("\nAutenticación exitosa.")
#Se obtiene el token de la respuesta, el cual será requerido para las siguientes llamadas a la API
token = response_auth.json()['access_token']

headers={"Authorization": "Bearer {}".format(token)}

#Se debe ingresar un username válido para poder obtener su ID
username = input("\nDigite el nombre de usuario: ")
response_user_id = requests.get(
    'https://letterboxd.com/api/v0/member/' + username,
    headers=headers,
)
#Se comprueba que la llamada a la API se haya ejecutado correctamente y si no es así, un error se lanza
if response_user_id.status_code != 200:
    raise Exception('Error: {}'.format(response_user_id.text))
else:
    print("\nID del usuario encontrado.")

#Se obtiene el ID del usuario a partir de su nombre de usuario
user_info = response_user_id.json()['member']
user_id = user_info['id']
print("El ID del usuario es:", user_id)

#Lista de películas vistas por el usuario, recibida como input desde la terminal
list_movies_watched = []
while True:
    movie_name=input("\nDigite un título de película. Para terminar introduzca 'FINALIZAR': ")
    if movie_name=='FINALIZAR':
        break;
    else:
        response_movie_id = requests.get(
            'https://letterboxd.com/api/v0/film/' + movie_name,
            headers=headers,
        )
        
        if response_movie_id.status_code != 200:
            raise Exception('Error al obtener el ID de la película: {}'.format(response_movie_id.text))
        else:
            print("ID de la película encontrado.")
    
    movie_info = response_movie_id.json()['film']
    movie_year = movie_info['releaseYear']['year']
    if movie_name[-1]==' ' or movie_name[-2]==' ':
        movie_name=movie_name[:-3]+"'"+movie_name[-2:]
    
    list_movies_watched.append([movie_name, movie_year])
print("\nLista de películas vistas por el usuario:\n",list_movies_watched)
#Aquí, se construye la lista de películas vistas para cada película del usuario
film_ids = []
for title in list_movies_watched:
    movie_name=title[0]
    response_movie_id = requests.get(
        'https://letterboxd.com/api/v0/film/' + movie_name,
        headers=headers,
    )
    
    if response_movie_id.status_code != 200:
        raise Exception('Error al obtener el ID de la película: {}'.format(response_movie_id.text))
    else:
        print("ID de la película encontrado.")
        
    movie_info = response_movie_id.json()['film']
    film_ids.append({'film': movie_name, 'id': movie_info['baseFilmId'], 'year': title[1]})
    
#Se obtienen las películas que el usuario vino a ver y para cada película se obtiene la información de su id. Además, se crea una lista llamada film_data, 
#donde se almacenarán los datos de cada película y sus respectivos datos de recomendación.
response_user_watchlist = requests.get(
    'https://letterboxd.com/api/v0/member/' + user_id + '/watchlist/',
    headers=headers,
)
print("\nPelículas que el usuario vino a ver:")
for film in response_user_watchlist.json()['films']:
    response = requests.get(
        'https://letterboxd.com/api/v0/film/' + film,
        headers=headers,
    )
    
    if response.status_code != 200:
        raise Exception('Error al obtener el ID de la película: {}'.format(response_user_watchlist.text))
        
    print("ID de la película encontrado.")
    
    film_data = []
    movie_info = response.json()['film']
    film_ids.append({'film': movie_info['name'], 'id': movie_info['baseFilmId'], 'year': movie_info['releaseYear']['year']})
print("La lista film_data contiene la siguiente información:\n",film_data)

#Se crea una lista para cada película, donde se almacenarán los datos de recomendación.
#Además, se crea un diccionario para cada pelicula vistada por el usuario, donde se almacena la información de su id.
recommendation_data = []
film_info = {}
for film in film_ids:
    print("Film ID:",film['id'])
    response = requests.get(
        'https://api-flixster-v1.p.rapidapi.com/film/' + str(film['id']),
        headers={"X-RapidAPI-Key": "9f836752a4msh6ad30bdd5c86e9cp1b7f6djsn6a7b17ecda31"},
    )
    
    if response.status_code != 200:
        raise Exception('Error al obtener la película: {}'.format(response.text))
        
    print("Film information found.")
    film_info[film['id']] = {'film':film, 'recommendation data':[]}
    
    #Se crea un diccionario para los datos de cada recomendación.
    recommendation_data.append({'name':'','similarity score':'','poster url':''})
#Aquí, se almacenan las películas que el usuario vino a ver en la lista film_info. Esta lista contendrá un diccionario para cada película, donde almacena la información de su id, su nombre y año. También, 
#almacena los datos de recomendación de la película por cada fila de la lista recommendation_data. Además, se llama a la función get_recommended_movies, que devuelve una lista de películas para cada película vistada por el usuario.
get_recommended_movies(film_info)
print("\nLa lista film_info contiene la siguiente información:\n",film_info,"\nLa lista recommendation_data contiene los datos de recomendación de cada pelicula:\n",recommendation_data)

#Se crea una función para obtener los datos de recomendación, a partir del ID de las películas. Esta función llama a la API de Flixster. 
def get_recommended_movies(film_info):
    for film in film_info:
        film_data = film['film']
        
        response = requests.get(
            'https://api-flixster-v1.p.rapidapi.com/films/' + str(film_data['id']) + '/recommendations',
            headers={"X-RapidAPI-Key": "9f836752a4msh6ad30bdd5c86e9cp1b7f6djsn6a7b17ecda31"},
        )
        
        if response.status_code != 200:
            raise Exception('Error al obtener la recomendación de la película {}: {}'.format(film['id'],response.text))
            
        print("Recommended data found.")
        film_info[film]['recommendation data'] = []
        
        #Se crea una lista para cada pelicula, donde se almacenarán los datos de recomendación. 
        recommendation_data = []
#Aquí, se llama a la función get_recommended_movies, que devuelve una lista de películas para cada película vistada por el usuario.
get_recommended_movies(film_info)
print("\nLa lista film_info contiene la siguiente información:\n",film_info,"\nLa lista recommendation_data contiene los datos de recomendación de cada pelicula:\n",recommendation_data)

#Se crea una función para obtener las imágenes de poster de cada película. Esta función llama a la API de Flixster. 
def get_poster(film_info):
    for film in film_info:
        film_data = film['film']
        
        response = requests.get(
            'https://api-flixster-v1.p.rapidapi.com/films/' + str(film_data['id']) + '/images',
            headers={"X-RapidAPI-Key": "9f836752a4msh6ad30bdd5c86e9cp1b7f6djsn6a7b17ecda31"},
        )
        
        if response.status_code != 200:
            raise Exception('Error al obtener la imagen de poster de la película {}: {}'.format(film['id'],response.text))
            
        print("Poster information found.")
        film_info[film]['recommendation data'] = []
        
        #Se crea una lista para cada pelicula, donde se almacenarán los datos de recomendación. 
        recommendation_data = []
#Aquí, se llama a la función get_poster, que devuelve un diccionario con el id y la imagen de poster de cada película vistada por el usuario.
get_poster(film_info)
print("\nLa lista film_info contiene la siguiente información:\n",film_info,"\nLa lista recommendation_data contiene los datos de recomendación de cada pelicula:\n",recommendation_data)