
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const MongoClient = require('mongodb').MongoClient;

const app = express();
app.use(bodyParser.json());
app.use(cors());

// Variable para la conexión de MongoDB
let db;

const mongoUrl = 'url_de_tu_base_de_datos';
MongoClient.connect(mongoUrl, { useNewUrlParser: true }, (err, client) => {
  if (err) return console.error(err);
  console.log('Conectado a MongoDB');
  db = client.db('app_citations');
});

// Endpoint para crear una cita
app.post('/api/citations', (req, res) => {
  const newCitation = req.body;
  db.collection('citas').insertOne(newCitation, (err, result) => {
    if (err) return console.error(err);
    res.status(201).send(result.ops[0]);
  });
});

// Endpoint para listar todas las citas
app.get('/api/citations', (req, res) => {
  db.collection('citas').find({}).toArray((err, citations) => {
    if (err) return console.error(err);
    res.send(citations);
  });
});

// Endpoint para actualizar una cita
app.put('/api/citations/:id', (req, res) => {
  const id = req.params.id;
  const updatedCitation = req.body;
  db.collection('citas').updateOne(
    { _id: new MongoObjectID(id) },
    { $set: updatedCitation },
    (err, result) => {
      if (err) return console.error(err);
      res.send(result.value);
    }
  );
});

// Endpoint para borrar una cita
app.delete('/api/citations/:id', (req, res) => {
  const id = req.params.id;
  db.collection('citas').deleteOne({ _id: new MongoObjectID(id) }, (err, result) => {
    if (err) return console.error(err);
    res.send(result.result);
  });
});

const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Escuchando en puerto ${port}`));
