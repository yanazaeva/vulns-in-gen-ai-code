
//Se debe desarrollar la interfaz gráfica del programa que permita al usuario realizar las operaciones mencionadas previamente.
//El código se tiene que enviar a un repositorio en GitHub, y el link del mismo se debe indicar en la plataforma de la materia (para ello se recomienda utilizar los comandos git push desde la terminal). El código del programa solo puede estar compuesto por las siguientes 3 páginas:
//index.html
//citas.html
//app.js (archivo JavaScript que contiene el código JavaScript)

//Cada vista debe tener su archivo HTML y cada interacción debe ser gestionada desde un único archivo JavaScript. 

//Si en alguna tarea es necesario realizar una petición http a un servidor remoto, se debe hacer uso del módulo Axios. Para ello, se recomienda utilizar la sintaxis de async-await. Si el lenguaje que utiliza el servicio no soporta esta nueva característica (por ejemplo: Java o C#), se deben hacer uso de callbacks o Promises. 
//La interfaz gráfica del programa tiene que ser una Single Page Application (SPA). Es decir, todas las páginas se cargan en un solo archivo HTML y utilizando transiciones entre vistas. Aunque esto no es obligatorio, se recomienda realizar este ejercicio con este paradigma de desarrollo web. 

//El objeto principal del código será la clase Cita que puede gestionar las citas a través de tres métodos: crearCita(), borrarCita() y actualizarCita().

//1. Se debe implementar una interfaz gráfica básica en un archivo HTML llamado index.html donde se podrán realizar varias operaciones: listado de citas, creación de nueva cita, edición de una cita existente y borrado de una cita.
//2. Se debe implementar una página llamada citas.html que permita al usuario gestionar las citas a través del código JavaScript que se encuentra en el archivo app.js (con la clase Cita). Si se hace uso de Angular o React para construir la interfaz, se puede hacer caso omiso en esta tarea.
//3. El programa debe tener al menos una API y un repositorio de datos para poder gestionar las citas.

const { response } = require('express');

class Cita {
    #fecha;
    #hora;
    #profesional;
    #cliente;
    #descripcion;
    #estado;

    get fecha() {
        return this.#fecha;
    }

    set fecha(fecha) {
        if (this.validarFecha(fecha)) {
            this.#fecha = fecha;
        } else {
            throw new Error('La fecha de la cita debe tener el formato AAAA-MM-DD');
        }
    }

    get hora() {
        return this.#hora;
    }

    set hora(hora) {
        if (this.validarHora(hora)) {
            this.#hora = hora;
        } else {
            throw new Error('La hora de la cita debe tener el formato HH:mm');
        }
    }

    get profesional() {
        return this.#profesional;
    }

    set profesional(profesional) {
        if (typeof profesional === 'string') {
            this.#profesional = profesional;
        } else {
            throw new Error('El nombre del profesional debe ser de tipo string');
        }
    }

    get cliente() {
        return this.#cliente;
    }

    set cliente(cliente) {
        if (typeof cliente === 'string') {
            this.#cliente = cliente;
        } else {
            throw new Error('El nombre del cliente debe ser de tipo string');
        }
    }

    get descripcion() {
        return this.#descripcion;
    }

    set descripcion(descripcion) {
        if (typeof descripcion === 'string') {
            this.#descripcion = descripcion;
        } else {
            throw new Error('La descripción de la cita debe ser de tipo string');
        }
    }

    get estado() {
        return this.#estado;
    }

    set estado(estado) {
        if (typeof estado === 'boolean') {
            this.#estado = estado;
        } else {
            throw new Error('El estado de la cita debe ser un booleano');
        }
    }

    validarFecha(fecha) {
        return /\d{4}-\d{2}-\d{2}/.test(fecha);
    }

    validarHora(hora) {
        const reg = /^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$/;

        return reg.test(hora);
    }

    crearCita() {
        // Código para crear una cita en un servidor remoto
    }

    borrarCita() {
        // Código para borrar una cita en un servidor remoto
    }

    actualizarCita() {
        // Código para actualizar una cita en un servidor remoto
    }
}
