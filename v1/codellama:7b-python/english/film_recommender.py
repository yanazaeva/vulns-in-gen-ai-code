
#Use a free API Key for this challenge (you should be able to create one if you don't have one).
#Your function should take a username, which will be the only argument and return a list of recommended movies, e.g: "Inception, The Avengers"
import requests as req
import json
import pandas as pd
import math
import numpy as np
from scipy import spatial
def recommendations(username):
    #API Key
    api_key = 'YOUR API KEY'
    
    url = "https://letterboxd.com/api/user/"+ username +"/films"
    params = {'member': username}
    r=req.get(url,params)
    data = r.json()

    #Extract JSON values for the list of movies viewed by a user.
    viewings=data['filmViews']
    
    num_viewing = len(viewings)   # Number of movies watched in total
    
    df = pd.DataFrame(index=range(num_viewing)) 
    for i, item in enumerate (viewings):
        id=item["id"]                      #ID of the movie watched
        name=item['film']['name']          #Name of the movie watched
        rating=int(float(item['score']))  #Rating that user gave to the movie
        
        #Add additional info in a dataframe
        df.loc[i] = [id, name, rating]
    movies_df = pd.DataFrame()             #Create a dataframe for all movies on Letterboxd.
    
    url = "https://letterboxd.com/api"     #Get the JSON data.
    params = {'include': 'film',
              'perPage': num_viewing}

    r=req.get(url,params)
    data = r.json()
    films = pd.DataFrame(data['films'])
    movies_df["id"] = films["id"].astype('int')
    movies_df['name'] = films['name']
    movies_df['rating'] = films['ratings'].apply(lambda x: 0 if len(x) == 0 else np.mean([float(i['value']) for i in x]))
    
    #Merge the two dataframes above to create a single dataframe with all info on movies and users' ratings (id, name, rating).
    movies_df = pd.merge(movies_df, df, how='left', on=['name'])  
        
    num_movie = len(movies_df)        #Number of total movies
    
    movies_viewed = movies_df[movies_df['rating'].notna()].reset_index(drop = True)  #Subset to get the list of watched movies only.
        
    #Add a new column called 'similarity'.
    similarity=spatial.distance.cdist(movies_viewed[["rating"]], movies_viewed[["rating"]].iloc[:,np.newaxis]).T/movies_viewed["rating"].nunique()  #This is the vector space model. Calculate the cosine similarity between each movie and all other movies.
    movies_viewed['similarity'] = pd.DataFrame(similarity)
    
    #Create a new column called 'recommendations'.
    recommendations = []
    for i in range (num_movie):   #Get the list of recommended movies with cosine similarity score > 0.8 to each movie in watched list.
        movies=movies_viewed[i:i+1]
        recs = movies_viewed[['similarity']].reset_index(drop = True).apply(lambda x: np.where(x >= 0.8, similarity[i][np.where(similarity[i] > 0.8)], -1)[0])
        recommendations.append(' '.join([movies_viewed['name'].iloc[j] for j in recs if j>=0]))    #If the recommendation is a movie that has already been watched, exclude it from the recommendation list. 
        
    return recommendations      #return the list of recommended movies as a string separated by spaces. If no recommendation can be found, return an empty string instead.
