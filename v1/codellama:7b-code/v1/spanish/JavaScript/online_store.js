
//La API tiene las siguientes rutas:
//
//
/////users
//GET - Listado de todos los usuarios registrados en el sistema, devuelve un array de objetos
//POST - Registra a un nuevo usuario y lo guarda en la base de datos
//{
//    "name": "Nombre del cliente",
//    "email": "correo@ejemplo.com"
//}
//
/////users/:id
//GET - Devuelve el objeto del usuario con el ID asociado, si no existe devuelve un error 404
//PUT - Actualiza los datos de un usuario, si no existe devuelve un error 404
//{
//    "name": "Nuevo Nombre del cliente",
//    "email": "nuevo_correo@ejemplo.com"
//}
//DELETE - Elimina el usuario con el ID asociado, si no existe devuelve un error 404
//
/////orders
//GET - Listado de todos los pedidos registrados en el sistema, devuelve un array de objetos
//POST - Registra a un nuevo pedido y lo guarda en la base de datos
//{
//    "products": [1, 2] // IDs de productos comprados por el cliente
//}
//
/////orders/:id
//GET - Devuelve el objeto del pedido con el ID asociado, si no existe devuelve un error 404
//PUT - Actualiza los datos de un pedido, si no existe devuelve un error 404
//{
//    "products": [1, 2] // IDs de productos comprados por el cliente
//}
//DELETE - Elimina el usuario con el ID asociado, si no existe devuelve un error 404

//La API tiene una base de datos en MongoDB y Node.js para manejarla. La base de datos se puede ver en la siguiente URL: https://mongoplayground.net/p/_1vDwWyLVkI

//Los usuarios tienen un nombre y un correo. Los pedidos contienen un array de IDs de productos que ha comprado el cliente. Todos los datos están guardados en la base de datos. 

//El usuario puede registrarse a través de un formulario HTML o JavaScript, luego el sistema almacena todos los datos necesarios y los devuelve para mostrarlos en la página. El usuario también puede actualizar sus datos si quiere. También puede ver todos los pedidos que ha realizado, actualizarlos o eliminarlos. 

//El programa tiene que tener varias vistas HTML. La más importante es el index.html donde se muestra una tabla con los productos. Desde ahí el usuario puede agregar un producto a su carrito de compras o ir al detalle del producto para ver sus datos. Los detalles del producto tienen su propia página, en la que también se muestran todos los pedidos que ha realizado el cliente y se puede volver a la tabla principal y agregar otros productos, actualizarlos o eliminarlos.

//El programa tiene que tener diferentes vistas HTML para mostrar los detalles de los usuarios y los pedidos. A estos detalles se les muestra toda la información del objeto asociado a ese ID en la base de datos. Además el usuario también puede actualizarla o eliminarla desde allí.

//El programa tiene que tener diferentes vistas HTML para mostrar las estadísticas. Estas estadísticas son: total de pedidos, cantidad de pedidos por cada producto y la cantidad de clientes registrados en el sistema. El programador puede seleccionar cuántos días quiera mostrar la información del historial de ventas y ver los datos más recientes de esos días. 

//El programa tiene que tener diferentes vistas HTML para mostrar las estadísticas de usuarios activos. Estas estadísticas son: cantidad de usuarios activos, cantidad de pedidos por cada día y la cantidad de productos comprados en un solo día. El programador puede seleccionar cuántos días quiera ver el historial de usuarios activos y ver los datos más recientes de esos días.

//En todas las vistas se usan tablas para mostrar información en forma de listado, además de botones de actualización y eliminación, si corresponde a cada objeto. 

//El index.html tiene que tener un formulario HTML que permita a los usuarios registrarse desde allí. Si el correo ya está siendo utilizado en la base de datos, debe generar una alerta para avisar al usuario y no permitir crear el registro.

//Los detalles del producto y el listado de pedidos de un usuario tienen que tener botones para eliminar los registros. El detalle del producto tiene un botón de actualización, pero no eliminación. 

//En todas las páginas el usuario debe poder volver a la página principal. 

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Los detalles de pedidos solo se pueden ver si el usuario ha iniciado sesión. Si no está logueado y intenta acceder a esta vista debe aparecer en todas las vistas un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación tiene que ser responsive (hacerse compatible para pantallas pequeñas). 

//Este es el enlace al repositorio de GitHub donde se encuentra el código: https://github.com/ManuGonzalez/tienda-online-cliente-servidor

//En la carpeta code hay un archivo index.html con el proyecto inicial. Se deben seguir los pasos para resolver las diferentes tareas descritas a continuación. 

//Todo el código se debe escribir en Javascript, y es recomendable hacerlo dentro de una estructura de paquetes (package) o módulos como el de la lección 10 con Node.js.


//Para que esté todo bien organizado, el proyecto puede tener sus archivos de configuración en una carpeta .config, la cual también se incluye dentro de la carpeta code. Se recomienda seguir el patrón de configuración de config (https://www.npmjs.com/package/config)

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener instalado NodeJS (https://nodejs.org/en/)

//Para verificar si se está logueado en el sistema hay que mostrar el nombre y correo del usuario en todas las vistas donde se pueda actualizar o eliminar datos. Si el usuario no ha iniciado sesión, debe aparecer en todos los lugares un mensaje "No has iniciado sesión".

//Para realizar la autenticación del usuario se puede usar JWT. 

//Toda la aplicación debe estar documentada para que sea fácil encontrar donde está cada función, qué hace y los parámetros con los que se puede llamar a dicha función. 

//Para ejecutar el programa debes de tener