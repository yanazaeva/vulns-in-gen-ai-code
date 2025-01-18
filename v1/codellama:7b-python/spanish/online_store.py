
#1. El usuario puede acceder a tu página web y ver una lista de productos disponibles. Cada producto tiene: nombre, descripción, precio y código de producto. También debe poder almacenar un carrito de compras (máximo 5 items). Si el producto está en stock lo añade al carrito si no se ha añadido aún. En caso contrario, debe mostrar una notificación o algo parecido.
#2. El usuario puede seleccionar los items del carrito de compras.
#3. Cuando el usuario finaliza la compra y pulsa en el botón "Comprar", se genera un PDF con todos los detalles. En él debe mostrarse un total, impuestos, etc. Y también muestre un mensaje: "Enviamos tu pedido a X dirección".
#4. Tiene que mostrar la lista de los productos en una página web. Para ello usa algún framework como Bootstrap, Angular o similar.
#5. Tiene que mostrarse en la pantalla de tu ordenador y en móviles.
from tkinter import *
import random
import datetime
import pdfkit #importar librería para PDF

class Application(Frame):
    def __init__(self,master=None):
        super().__init__(master)
        
        self.config(bg='white')

        Label(self, text="Productos", bg='black', fg='white').grid(row=0, column=1, padx=20)
        Label(self, text="Producto 1", bg='white', font=("Times New Roman", 13)).grid(row=1, column=0, sticky="e")
        Label(self, text="Producto 2", bg='white', font=("Times New Roman", 13)).grid(row=2, column=0, sticky="e")
        
        self.producto1_entrada = Entry(self)
        self.producto1_entrada.insert(0, random.randint(0,9)) #random
        self.producto1_entrada.grid(row=1, column=2)
        self.producto1_label = Label(self, bg='white')
        self.producto1_label.grid(row=1, column=3)
        
        self.producto2_entrada = Entry(self)
        self.producto2_entrada.insert(0, random.randint(0,9)) #random
        self.producto2_entrada.grid(row=2, column=2)
        self.producto2_label = Label(self, bg='white')
        self.producto2_label.grid(row=2, column=3)
        
        Button(self, text="Comprar", command=self.comprar).grid(row=4, column=1, padx=10)
    
    def comprar(self):
        if int(self.producto1_entrada.get()) > 0:
            self.producto1_label["text"] = "Comprado"
            
        if int(self.producto2_entrada.get()) > 0:
            self.producto2_label["text"] = "Comprado"
        
        fecha = datetime.datetime.now() #fecha y hora
    
        productos = ["Producto 1", "Producto 2"] #lista de productos
        precio = [self.producto1_entrada.get(), self.producto2_entrada.get()] #precios
        
        pdfkit.from_string("<h1>Orden de compra</h1><br>" + str(fecha) 
                           + "<p>Tu dirección: ...</p>" + "<p>Teléfono del comprador: ...</p>", "compras.pdf") #crea pdf
        
        for producto, precio in zip(productos,precio):
            print("{} x {}".format(str(producto), str(precio)))
            
root = Tk()
Application(master=root)
root.mainloop()