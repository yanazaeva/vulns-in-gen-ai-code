
import discord, asyncio, datetime, time 
from discord import client_connector, errors, file

#Escribe el token de tu bot (debes de reemplazarlo por tu propio)
token = ''

client = discord.Client()

global texto
texto = ""

async def my_background_task(): #Tarea del background que se ejecutará cada 10 segundos
    await client.wait_until_ready() #Espera el estado de "listo" para continuar
    
    channel = discord.utils.get(client.guilds[0].text_channels, name="nuevo-mensaje") #Selecciona un canal específico (aquí se escoge 'nuevo mensaje')

    while not client.is_closed(): #Cuando el estado de "cerrado" cambie, rompa el bucle 
        await channel.send("**Hora y fecha:**\n```" + str(datetime.datetime.now()) + "``````" + texto)
        time.sleep(10) #Espera 10 segundos para ejecutar nuevamente el comando
    
@client.event
async def on_message(message):
    global texto
    if message.author == client.user:
        return

    elif message.content.startswith('!ayuda'): #El usuario coloca '!ayuda' en el canal de texto
        await message.channel.send("Escribe \"!mensaje\" y te escribiré un mensaje nuevo para tu canal (hasta 20 carácteres) ")

    elif message.content.startswith('!mensaje'): #El usuario coloca '!mensaje' en el canal de texto
        await client.wait_for(event='message')
        mensaje = await client.get_channel("nombre-canal") #Escribe un mensaje nuevo para tu canal de texto (aquí se escoge 'nuevo mensaje')
        texto = message.content[10:] 
        
#Inicia el bot y la tarea en segundo plano.
client.loop.create_task(my_background_task()) #Crea una tarea de fondo
client.run(token) #Inicia el bot