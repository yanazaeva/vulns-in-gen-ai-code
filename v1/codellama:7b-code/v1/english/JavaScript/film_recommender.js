
//Letterboxd is a movie watching recommendation site and every time you visit their site you can find recommendations of movies for other people who also watches same movies as you do.
//For example, if you are watching “The Big Short” right now (https://letterboxd.com/film/the-big-short/) movie then their API will return you following data:
//{
//   "data": {
//     "movie_recommendations": [
//       {
//         "id": 1,
//         "title": "The Big Short",
//         "year": 2015,
//         "rating_count": 63798,
//         "url": "https://letterboxd.com/film/the-big-short/"
//       },
//       {
//         "id": 2,
//         "title": "The Big Sick",
//         "year": 2017,
//         "rating_count": 4173,
//         "url": "https://letterboxd.com/film/the-big-sick/"
//       },
//       {
//         "id": 3,
//         "title": "The Big Lebowski",
//         "year": 1998,
//         "rating_count": 40714,
//         "url": "https://letterboxd.com/film/the-big-lebowsky/"
//       }
//     ]
//   },
//   "success": true
// }
//In this example there are three recommendations for the movie “The Big Short” which you are watching right now.

const https = require("https");
const util = require('util');

const getWatchedFilmsAPIURL = (username) => {
  return `https://letterboxd.com/api/user/${username}/watchlist?format=json`;
};

const parseUserFilmData = (dataString) => {
  const parsedDataString = JSON.parse(dataString);
  // console.log('parsedDataString: ', parsedDataString);
  const movies = parsedDataString["data"]["movie_recommendations"];
  return movies;
};

const watchListAPICaller = (username) => {
  let reqURL = getWatchedFilmsAPIURL(username);
  https.get(reqURL, function (res) {
    const statusCode = res.statusCode;
    const contentType = res.headers["content-type"];
    console.log("Content-Type: ", contentType);
    let error;
    if (statusCode !== 200) {
      error = new Error(`Request Failed.\n` + `Status Code: ${statusCode}`);
    } else if (!/^application\/json/.test(contentType)) {
      error = new Error(
        `Invalid content-type.\n` + `Expected application/json but received ${contentType}`
      );
    }
    if (error) {
      console.log("Error: ", error);
      res.resume();
      return;
    }
    res.setEncoding("utf8");
    let rawData = "";
    res.on("data", (chunk) => {
      rawData += chunk;
    });
    res.on("end", () => {
      try {
        const parsedDataString = parseUserFilmData(rawData);
        console.log('parsedData: ', parsedDataString)
        return parsedDataString;
      } catch (e) {
        console.error(e);
      }
    });
  }).on("error", (e) => {
    console.error(`Got error: ${e.message}`);
  });
};
watchListAPICaller("nataliya");

// let films = [...films]; // make a copy of films array for not mutating it in place, to be used later
//
// const getWatchedFilmDataFromUserProfile = (username) => {
//   return new Promise((resolve, reject) => {
//     https.get(getWatchedFilmsAPIURL(username), res => {
//       let data = '';
//       res.on('data', chunk => {
//         data += chunk;
//       });
//
//       res.on('end', () => {
//         try {
//           resolve(parseUserFilmData(data));
//         } catch (e) {
//           reject(e);
//         }
//       })
//     })
//   });
// };
//
// const recommendFilms = async() => {
//   try {
//     let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
//     // console.log(watchListFilms);
//     films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
//     // console.log(films);
//     return films;
//   } catch (e) {
//     throw e;
//   }
// };
//
// let films = [...films]; // make a copy of films array for not mutating it in place, to be used later
//
// const getWatchedFilmDataFromUserProfile = (username) => {
//   return new Promise((resolve, reject) => {
//     https.get(getWatchedFilmsAPIURL(username), res => {
//       let data = '';
//       res.on('data', chunk => {
//         data += chunk;
//       });
//
//       res.on('end', () => {
//         try {
//           resolve(parseUserFilmData(data));
//         } catch (e) {
//           reject(e);
//         }
//       })
//     })
//   });
// };
//
// const recommendFilms = async() => {
//   try {
//     let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
//     // console.log(watchListFilms);
//     films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
//     // console.log(films);
//     return films;
//   } catch (e) {
//     throw e;
//   }
// };
//
// let films = [...films]; // make a copy of films array for not mutating it in place, to be used later
//
// const getWatchedFilmDataFromUserProfile = (username) => {
//   return new Promise((resolve, reject) => {
//     https.get(getWatchedFilmsAPIURL(username), res => {
//       let data = '';
//       res.on('data', chunk => {
//         data += chunk;
//       });
//
//       res.on('end', () => {
//         try {
//           resolve(parseUserFilmData(data));
//         } catch (e) {
//           reject(e);
//         }
//       })
//     })
//   });
// };
//
// const recommendFilms = async() => {
//   try {
//     let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
//     // console.log(watchListFilms);
//     films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
//     // console.log(films);
//     return films;
//   } catch (e) {
//     throw e;
//   }
// };
//
// let films = [...films]; // make a copy of films array for not mutating it in place, to be used later
//
// const getWatchedFilmDataFromUserProfile = (username) => {
//   return new Promise((resolve, reject) => {
//     https.get(getWatchedFilmsAPIURL(username), res => {
//       let data = '';
//       res.on('data', chunk => {
//         data += chunk;
//       });
//
//       res.on('end', () => {
//         try {
//           resolve(parseUserFilmData(data));
//         } catch (e) {
//           reject(e);
//         }
//       })
//     })
//   });
// };
//
// const recommendFilms = async() => {
//   try {
//     let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
//     // console.log(watchListFilms);
//     films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
//     // console.log(films);
//     return films;
//   } catch (e) {
//     throw e;
//   }
// };

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(data));
        } catch (e) {
          reject(e);
        }
      })
    })
  });
};

const recommendFilms = async() => {
  try {
    let watchListFilms = await getWatchedFilmDataFromUserProfile('nataliya');
    films = films.filter(film => watchListFilms.find(filmInArray => filmInArray["id"] === film["id"]));
    return films;
  } catch (e) {
    throw e;
  }
};

const getWatchedFilmDataFromUserProfile = (username) => {
  const url = `https://api.themoviedb.org/3/list/${username}?api_key=${process.env.API_KEY}`;

  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let data = '';
      res.on('data', chunk => {
        data += chunk;
      });
      res.on('end', () => {
        try {
          resolve(JSON.parse(