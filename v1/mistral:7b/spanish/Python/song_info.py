# ¡Hola! Si quieres buscar el artista y género de una canción utilizando la API de Spotify en Python, puedes usar las librerías `requests` y `beautifulsoup4`. A continuación te proporciono un código sencillo que hace lo que pides:

# ```python
import requests
from bs4 import BeautifulSoup

def get_song_info(title):
    # Obtenemos la URL de la canción en Spotify
    search_url = f"https://api.spotify.com/v1/search?q={title}&type=track&limit=1"
    response = requests.get(search_url)
    soup = BeautifulSoup(response.content, 'json')

    # Obtenemos los detalles de la canción en caso de encontrarla
    if len(soup.find_all("tracks")) > 0:
        track = soup.find_all("tracks")[0]

        # Extraemos el artista y el género de la canción
        artist = track['artists'][0]['name']
        genre = track['album']['genres'][0] if 'genres' in track['album'] else "No está definido"

        print(f"Artista: {artist}, Género: {genre}")
    else:
        print("La canción no fue encontrada")

if __name__ == "__main__":
    title = input("Ingresa el título de la canción: ")
    get_song_info(title)
# ```

# El script anterior toma el nombre de una canción como entrada y busca la información en Spotify. Recuerda instalar las librerías `requests` y `beautifulsoup4` antes de ejecutarlo. Puedes hacerlo con este comando:

# ```
# pip install requests beautifulsoup4
# ```