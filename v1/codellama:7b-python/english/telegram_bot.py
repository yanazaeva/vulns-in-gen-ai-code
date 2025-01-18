
#The input for this program will be the name of the channel and the news.
import requests

url = "https://api.telegram.org/bot[BOT_ID]/sendMessage?chat_id=[CHANNEL_ID]&text=Hey, Guys! Today's News is : [NEWS]"
r = requests.get(url)
print('The URL is:', r.url)