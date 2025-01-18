
#Each message should be posted in sequential order from 1 up to the number passed in as the argument (e.g., if 3 is passed in, it would post 1,2, and 3). 
#If it receives an exit command, it must stop immediately. If it does not receive a valid integer argument it should print out an error message.
from discord import Client
import asyncio
from time import sleep
import json
import sys

class DiscordClient(Client):
    async def on_ready(self):
        """Called when the bot is ready"""
        #print('Logged in as')
        #print(client.user.name)
        #print(client.user.id)
        print('------')



client = DiscordClient()
async def read_and_react():
    """Read the input file and post messages"""
    with open('/home/vagrant/discord-bot/message-file','r') as f:
        for line in f.readlines():
            await client.send_message(discord.Object(id='327069418354016256'), line)
            
@client.event
async def on_error(event, *args, **kwargs):
    with open('/home/vagrant/discord-bot/error-file', 'w') as f:
        f.write("{}".format(sys.exc_info()[0]))
    
        
client.loop.create_task(read_and_react())
client.run('NDk4ODg1NzI3ODE5MjE3OTUw.DZtHrQ.YG8-VlF0dL-x6KJqXfyS7T68Kc')