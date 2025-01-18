// Create a functioning web page where you can enter the time, location, etc of your appointment. When finished, publish your project to GitHub so others can find it and use your work
//We need to create 3 different things for our app:
//   1. The main service that will manage the appointments (this will be a JavaScript file with an API)
//      - We want this API to be able to get, add, list and delete appointments.
//   2. A simple user interface (web page) where we can enter our appoinment information (this should be a HTML file)
//      - On the web page, the user will be able to enter their appointment time and date, location, notes about the appointment, etc. When they press submit, all of this information is sent to the API and stored in memory so we can see it.
//   3. A second service that will send a notification at the appropriate time for the appointment (this will be a JavaScript file using Node)

const schedule = require("node-schedule"); //Node module to run schedules, like notifications.
// const axios = require("axios") //Module to make AJAX requests (like we did in class).
// const apiKey = "c095dd17d864c34c5b02fdf33a782feb"; //This is the key for our weather API.
// const moment = require("moment") //Module to manipulate dates and times.

//Create a global array that will store all of our appointments:
let appointmentList = [];

//Create an API for our appoinment service. This function should be able to get, add, list and delete items in the appointmentList.
module.exports = {
  getAppointments() {
    return appointmentList;
  },
  addAppointment(appointment) {
    // Add a new appoinment to our global array that we created above:
    appointmentList.push(appointment);
  },
  deleteAppointment(id) {
    // We want to make sure that this id exists in the list so we don't end up removing something from a spot that doesn't exist.
    if (appointmentList[id] !== undefined) {
      appointmentList.splice(id, 1);
    }
  },
};

//Create an API for our web page. This function will handle all of the user interactions on our HTML page and send it to our appoinments service:
module.exports = (request, response) => {
  const queryObject = request.query; //The query object holds everything about a specific URL. This allows us to get information from the URL, like what page they're on or which API function we want.
  let appointment;

  if (queryObject.action === "create") {
    //We will need to create an object and send it to our API so that we can store the new appoinment:
    //Create a time object using MomentJS so we can manipulate dates and times easily:
    const now = moment().format("YYYY/MM/DD HH:mm"); //This will give us today's date. We could also specify the date that we want, like "2018/11/30 4:00".
    appointment = {
      id: queryObject.id || parseInt(Math.random() * 100000), //This will get the id or assign it a random number if there isn't one (when we first run our app).
      location: queryObject.location,
      notes: queryObject.notes,
      date: now, //Now is our time object from momentJS. This allows us to store this appointment for later and update it as necessary.
    };
  } else if (queryObject.action === "remove") {
    //We need to remove an appointment using the id that was passed in the URL query:
    deleteAppointment(parseInt(queryObject.id));
  } else if (queryObject.action === "update") {
    //We will update a specific appoinment by getting its id from the URL query:
    //First, we need to get the appointment object that we want to update:
    appointment = findAppointment(parseInt(queryObject.id));

    if (appointment) {
      appointment.location = queryObject.location;
      appointment.notes = queryObject.notes;
      //Now that it's updated, we will need to send a notification to remind the user about their appoinment. I could do this by sending them an email or text, but what if they don't have those services? Instead, let's just print it out:
      console.log("Notification for " + appointment.location);
    } else {
      //If we can't find the appoinment, then send a message back to the user with an error. This is optional but will help keep our code from breaking if someone tries something malicious.
      response.send("<h1>Error: Appointment not found</h1>");
    }
  } else {
    //When we first load this page, it should just show a list of the appointments that are stored in memory:
    appointmentList.forEach((appointment) => {
      console.log(appointment);
    });
  }
};

function deleteAppointment(id) {
  //We will need to remove an appointment using the id that was passed in the URL query:
  //First, we need to get the appointment object that we want to update:
  const appointment = findAppointment(id);

  if (appointment) {
    //Now that we have it, we can remove it from memory by calling our API function:
    module.exports.deleteAppointment(id);
  } else {
    //If we can't find the appoinment, then send a message back to the user with an error. This is optional but will help keep our code from breaking if someone tries something malicious.
    response.send("<h1>Error: Appointment not found</h1>");
  }
}

function findAppointment(id) {
  //This function will return the appointment object that has an id that matches what we pass in.
  let appointment = null;

  for (let i = 0; i < appointmentList.length; i++) {
    if (appointmentList[i].id === id) {
      //If we found it, then assign it to the appointment variable and break out of our loop:
      appointment = appointmentList[i];
      break;
    }
  }

  return appointment;
}

//Create a scheduled job that will check for appointments once a day at midnight.
schedule.scheduleJob("0 0 * * *", () => {
  //We want to find all of the appointments where the date/time is today:
  const today = moment().format("YYYY/MM/DD");
  console.log("Today's appointments: " + today);

  for (let i = 0; i < appointmentList.length; i++) {
    //If we find one that matches, then log it out and send a notification:
    if (appointmentList[i].date === today) {
      console.log(appointmentList[i]);
      console.log("Notification for " + appointmentList[i].location);
    }
  }
});

//Schedule a job to run every minute. This will be useful later when we create our web page.
schedule.scheduleJob("* * * * *", () => {
  console.log(moment().format()); //This logs the current date/time that