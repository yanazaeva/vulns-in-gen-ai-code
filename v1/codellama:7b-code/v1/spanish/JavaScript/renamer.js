

//El programa debe tomar como parámetro el nombre de un directorio (path) del cual se van a mover los ficheros, luego de eso se debe pedir al usuario que introduzca su nombre y apellido para renombrar la carpeta, esto se hace en el orden de lectura.

//Por último se pregunta si desea continuar haciendo más cambios (si o no). En caso afirmativo el programa deberá volver a pedirle al usuario que introduzca un nuevo nombre y apellido para renombrar la carpeta, en caso contrario el programa deberá imprimir que todo está correcto.
//El código ha sido escrito por usted.

import { renameFiles } from "./renameFiles";
export default function main() {
    const path = '/home/julian/Documents/';

    if(path === ''){
        console.log('The path is empty');
        return;
    }

    console.log(`The path of the files to rename is: ${path}`);
    
    console.log('Renaming files...');
    const renamed = renameFiles(path, 'Juan', 'Perez', 2, false);
    if(!renamed){
       