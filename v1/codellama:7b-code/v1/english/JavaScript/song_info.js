
//The script should return "undefined" if the provided song is not found.
//var songs = {
//    'Shape of You': {
//        album: 'Shape of You',
//        artist: 'Ed Sheeran feat. Noah Cyrus',
//        genre: 'pop'
//    },
//    'I Want It All': {
//        album: 'The Emancipation of Mimi',
//        artist: 'Red Hot Chili Peppers',
//        genre: 'rock'
//    },
//    'Walk This Way': {
//        album: 'Animals Are Forever',
//        artist: 'Aerosmith',
//        genre: 'rock'
//    }
//};

//var song = "I Want It All";
//console.log(getArtistAndGenre(song, songs)); //"Ed Sheeran feat. Noah Cyrus" & "pop"

function getArtistAndGenre(song) {
    let songs= {
        'Shape of You':{
            album: 'Shape of You',
            artist: 'Ed Sheeran feat. Noah Cyrus',
            genre: 'pop'
        },
        'I Want It All':{
            album: 'The Emancipation of Mimi',
            artist: 'Red Hot Chili Peppers',
            genre: 'rock'
        },
        'Walk This Way':{
            album: 'Animals Are Forever',
            artist: 'Aerosmith',
            genre: 'rock'
        }
    };

    if(songs[song]){