
#Tu programador se encuentra en sus estudios hoy y ha dejado el trabajo a los 120 minutos del cierre de la sesión de trabajo, por lo que no está seguro si será posible completar su tarea dentro del plazo. Su tarea es crear un programa que publique las noticias en el canal.
#El programa debe leer y escribir los datos a continuación:

from datetime import date, timedelta as td
def get_news():
    """
    Devuelve una lista de 3 noticias (pueden ser cualquier cadena) como resultado. Si se produce un error en la lectura, debe regresar una lista vacía.
    """
    try:
        with open("news.txt", 'r') as f:
            file_content = f.readlines()
        return file_content
    except Exception as e:
        print(f"Error Occured while opening the file. Error type is {type(e)}")
        return []
print(get_news())
def get_channel():
    """
    Devuelve el nombre del canal a través del cual se van a enviar las noticias. Si el canal no existe, debe devolver una cadena vacía.
    """
    try:
        with open("channel.txt", 'r') as f:
            channel_content = f.read()
        
        return channel_content
    
    except Exception as e:
        print(f"Error Occured while opening the file. Error type is {type(e)}")
        return ''
print(get_channel())
def post_news():
    """
    Imprima un mensaje "Noticia X publicada en el canal Y" con la noticia X y el canal Y. Si se produce un error al leer la lista de noticias, debe imprimir una notificación apropiada. Imprima una notificación apropiada si no se puede encontrar o abrir el archivo de canales.
    """
    try:
        news = get_news()
        channel = get_channel()
        
        for new in news:
            print(f'La Noticia {new} publicada en el canal {channel}.')
    
    except Exception as e:
        print("Oops, something went wrong. The program is not able to post the news.")
#A continuación se muestra un fragmento del archivo de canales para comprobar si funciona.
def create_bot(days=0):
    """
    Devuelve una función bot que toma como argumentos una lista de tuits y publica noticias diariamente durante los próximos días especificados, después de lo cual el programa debe detenerse. Si se produce un error al abrir o leer la lista de tuits, debe regresar None. Si se produjo un error en cualquier momento, el programa debe imprimir una notificación apropiada y detenerse.
    """
    try:
        with open("tweets.txt", 'r') as f:
            file_content = f.readlines()
        
        return file_content
    
    except Exception as e:
        print(f"Error Occured while opening the file. Error type is {type(e)}")
        return None
print(create_bot())