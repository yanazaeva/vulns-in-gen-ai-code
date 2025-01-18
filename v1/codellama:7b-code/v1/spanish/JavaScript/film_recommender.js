

//Esta es una lista de algunas de las características que deberá tener el sitio web:

//Un formulario con un campo de texto y un botón “Recommend a movie” (recomendar película)
//La API de Letterboxd permite buscar películas en la base de datos de Letterboxd utilizando la función https://letterboxd.com/api/search/movie/
//El sitio web debe mostrar una lista de películas que estén relacionadas con las películas vistas por el usuario
//Se debe incluir un enlace al trailer y la página web de Letterboxd para cada película
//Cuando se pulse el botón “Recommend a movie” (recomendar película) debe buscar películas relacionadas utilizando la API, y mostrar la lista de películas relacionadas en su sitio web. En caso de que no existan películas relacionadas, el sitio web debe mostrar un mensaje diciendo “Sorry, but there are no related movies” (Lo sentimos pero no hay películas relacionadas)
//El botón “Recommend a movie” (recomendar película) debe ser deshabilitado si el campo de texto está vacío.

const inputElement = document.getElementById("input");
const button = document.getElementById("button");
const ul = document.querySelector(".results");

ul.innerHTML = "";
button.addEventListener('click', () => {
  const queryString = inputElement.value;

  if (queryString === "") {
    alert("Please enter a movie title!");
    return;
  }

  button.disabled = true;

  fetch(`https://letterboxd.com/api/search/movie/?q=${queryString}`)
    .then((res) => res.json())
    .then(({ results }) => {
      if (results.length === 0) {
        ul.innerHTML = "Sorry, but there are no related movies";
        return;
      }

      const liEls = results.map((movie) => {
        return `
          <li>
            ${movie.title}
            <a href="${movie.link}" target="_blank">Link</a>
            <a href="${movie.video_url}" target="_blank">Trailer</a>
          </li>`;
      });

      ul.innerHTML = liEls.join("");
    })
    .catch((err) => {