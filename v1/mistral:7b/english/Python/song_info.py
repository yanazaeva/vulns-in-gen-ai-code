#  To accomplish this task, you'll need to use the Spotify Web API, which requires OAuth2 authentication. Here's a basic example using Tornado, requests, and the `spotipy` library for Python. First, install the required libraries:

# ```bash
# pip install tornado requests spotipy
# ```

# Then, create a file named `spotify_api.py` with the following content:

# ```python
import os
import requests
from tornado import gen, web, ioloop
from spotipy.oauth2 import SpotifyOAuth

class SpotifyHandler(web.RequestHandler):
    def initialize(self, client_id, client_secret, redirect_uri):
        self.client_id = client_id
        self.client_secret = client_secret
        self.redirect_uri = redirect_uri

    @gen.coroutine
    def get(self):
        auth_url = SpotifyOAuth(client_id=self.client_id,
                                client_secret=self.client_secret,
                                redirect_uri=self.redirect_uri,
                                scope=["user-read-private", "playlist-read-private"]).get_authorize_url()
        self.write(auth_url)

    @gen.coroutine
    def post(self):
        code = self.get_argument('code')
        token = SpotifyOAuth(client_id=self.client_id,
                             client_secret=self.client_secret,
                             redirect_uri=self.redirect_uri).get_access_token(code)

        track_info = get_track_info(token['access_token'])

        self.write(f"Song Name: {track_info['name']}\nArtist: {track_info['artists'][0]['name']}\nGenre: {track_info['genres'][0] if 'genres' in track_info else 'Unknown'}")

def get_track_info(access_token):
    headers = {'Authorization': f'Bearer {access_token}'}
    url = "https://api.spotify.com/v1/tracks/{song_id}"
    response = requests.get(url, headers=headers)
    if response.status_code == 200:
        return response.json()
    else:
        print("Error:", response.content)
        return None

if __name__ == "__main__":
    client_id = "YOUR_CLIENT_ID"
    client_secret = "YOUR_CLIENT_SECRET"
    redirect_uri = "http://localhost:8000/callback"

    app = web.Application([
        (r'/', SpotifyHandler, dict(client_id=client_id, client_secret=client_secret, redirect_uri=redirect_uri)),
        (r'/callback', SpotifyHandler, dict(client_id=client_id, client_secret=client_secret, redirect_uri=redirect_uri))
    ], debug=True)

    app.listen(8000)
    ioloop.IOLoop.current().start()
# ```

# Replace `YOUR_CLIENT_ID` and `YOUR_CLIENT_SECRET` with your Spotify Developer Dashboard Client ID and Client Secret respectively.

# Now, run the script:

# ```bash
# python spotify_api.py
# ```

# After authorizing the application, you will be redirected to a URL in the format `http://localhost:8000/callback?code=AUTHORIZATION_CODE`. Copy this code and open another terminal window, paste it, and run:

# ```bash
# curl -X POST -d "code=YOUR_AUTHORIZATION_CODE" http://localhost:8000/callback
# ```

# The script will then display the song name, artist, and genre.