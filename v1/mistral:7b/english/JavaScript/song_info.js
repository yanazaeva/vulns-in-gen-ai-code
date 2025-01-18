
const SpotifyWebApi = require('spotify-web-api-node');

// Initialize Spotify API instance with your client ID and secret from Spotify Developer Dashboard
const spotifyApi = new SpotifyWebApi({
  id: 'YOUR_CLIENT_ID',
  secret: 'YOUR_SECRET'
});

async function getSongDetails(songName) {
  try {
    // Fetch the access token using client credentials flow
    await spotifyApi.clientCredentials();

    // Search for the song by name
    const results = await spotifyApi.searchTracks(songName);

    if (results.tracks.items.length > 0) {
      // Get the first track found and retrieve artist and genre data
      const track = results.tracks.items[0];
      const artist = track.artists[0].name;
      const album = track.album.name;

      // Fetch album details to get the genre of the song (assuming the album belongs to a single genre)
      const albumData = await spotifyApi.getAlbum(track.album.id);
      const genre = albumData.album.genres[0];

      console.log(`Song Name: ${track.name}`);
      console.log(`Artist: ${artist}`);
      console.log(`Genre: ${genre}`);
    } else {
      console.error('No song found with the given name');
    }
  } catch (err) {
    console.error(err);
  }
}

// Call the function with a song name
getSongDetails('Bohemian Rhapsody');
