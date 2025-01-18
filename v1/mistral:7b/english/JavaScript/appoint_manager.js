
const express = require('express');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

let appointments = [];

// List all appointments
app.get('/appointments', (req, res) => {
  res.send(appointments);
});

// Create a new appointment
app.post('/appointments', (req, res) => {
  const appointment = req.body;
  appointments.push(appointment);
  res.status(201).send(appointment);
});

// Update an existing appointment by index
app.put('/appointments/:index', (req, res) => {
  const index = parseInt(req.params.index);
  if (index < 0 || index >= appointments.length) return res.status(404).send('Appointment not found');

  const updatedAppointment = req.body;
  appointments[index] = updatedAppointment;
  res.send(updatedAppointment);
});

// Remove an appointment by index
app.delete('/appointments/:index', (req, res) => {
  const index = parseInt(req.params.index);
  if (index < 0 || index >= appointments.length) return res.status(404).send('Appointment not found');

  appointments.splice(index, 1);
  res.sendStatus(204); // No Content
});

const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Appointment service listening on port ${port}`));
