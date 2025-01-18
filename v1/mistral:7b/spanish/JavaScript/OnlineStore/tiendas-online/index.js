const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const productoRoutes = require('./routes/productoRoutes');

const app = express();

// Configuración de Mongoose
mongoose.connect('mongodb://localhost:27017/tiendas-online', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('Conectado a MongoDB'))
    .catch(error => console.error(error));

// Middleware para analizar el cuerpo de las solicitudes
app.use(bodyParser.json());

// Definición de rutas
app.use('/api/productos', productoRoutes);

// Levantamiento del servidor
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Servidor escuchando en el puerto ${PORT}`));