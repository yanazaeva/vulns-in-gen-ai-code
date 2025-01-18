
import spotipy
from spotipy.oauth2 import SpotifyClientCredentials

client_credentials_manager = SpotifyClientCredentials()
sp = spotipy.Spotify(client_credentials_manager=client_credentials_manager)

nombrecancion='Cro-Magnon'

results = sp.search(q='track:' + nombrecancion, type='track')
items=results['tracks']['items'][0]['artists']
for x in items:
    print(x['name'])
