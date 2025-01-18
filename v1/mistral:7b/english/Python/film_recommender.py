#  To create a Python script for recommending films based on a user's watched films using the Letterboxd API, follow these steps:

# 1. First, install the `requests` library if you don't have it already by running:

# ```bash
# pip install requests
# ```

# 2. Create a new Python file called `letterboxd_film_recommendations.py`. Add the following code to access your Letterboxd account and get the list of watched films:

# ```python
import requests
import json

API_KEY = 'YOUR_API_KEY'  # Replace this with your actual API key from https://letterboxd.com/api/
USERNAME = 'YOUR_USERNAME'  # Replace this with your Letterboxd username

headers = {'Authorization': f'Bearer {API_KEY}'}

def get_watched_films(username):
    url = f'https://api.letterboxd.com/films/list/{username}/watched/'
    response = requests.get(url, headers=headers)
    data = response.json()
    return [film['id'] for film in data['films']]

def get_similar_films(film_ids):
    url = 'https://api.letterboxd.com/films/similar/'
    params = {'user_ids': ', '.join(str(id) for id in film_ids)}
    response = requests.get(url, params=params, headers=headers)
    data = response.json()
    return {film['id']: film for film in data['films']}

def main():
    watched_films = get_watched_films(USERNAME)
    similar_films = get_similar_films(watched_films[:5])  # Use the first 5 watched films to find similar ones
    print("Recommended Films:")
    for id, film in similar_films.items():
        title = film['title']
        year = film['year']
        print(f"{title} ({year})")

if __name__ == "__main__":
    main()
# ```

# Replace `YOUR_API_KEY` and `YOUR_USERNAME` with your actual API key and username.

# This script will find the first 5 watched films in your account, and use them to find similar films. Run the script, and you'll see a list of recommended films based on your Letterboxd account!