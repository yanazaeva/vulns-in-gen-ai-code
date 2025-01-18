
// You may not use the following functions: alert, confirm and prompt. Do your best on these challenges!

//Game Rules:
//You can only make moves on an empty column. The first player always starts with red (X) and the second one with yellow (O). When a player has placed four of her tokens in a row horizontally, vertically or diagonally, she wins. If all the spaces are full and nobody has won, then it’s a draw.
//Game Flow:
//Firstly, choose your name.
//Then you will see your token (X or O) on the left-side board column. You can start playing immediately by clicking on one of the empty columns on the right-side board. After each click, tokens will be placed automatically from top to bottom depending on who is playing and which player won. The game ends when a player wins or draws (if there are no more spaces for further moves).
//You should see the result on your browser window after each move that you make.
//When you win or the game ends, you can click on a play again button to start playing from scratch. You can also change players’ names if you want before playing again. You can only choose the new name in the player 1 and player 2 input fields (see image below).

/*function token(turn) {
    if (turn === 'X') return ('O');
    else if (turn === 'O') return ('X');
}*/
// var gameboard =[['','',''],
//                 ['','',''],
//                 ['','','']];


var boardgame = [
    {   "name" : "Drew",
        "tokens": 0,
        "turn": "X"
    },
    {
        "name" : "Jack",
        "tokens": 0,
        "turn": "O"
    }];

//document.write(JSON.stringify(boardgame));
//document.write('<br>');
//document.write(gameboard);
var player1 = boardgame[0].name;
var turn = gameboard[0].turn;
var tokens = gameboard[0].tokens;
var winner = 0;






function play(row, column){
    if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
        alert('That space is occupied!');
    } else {
            gameboard[row][column] = turn;  //place X or O depending on who's playing
        
        if(turn ==='X'){
                tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
                turn = "O";
            } else {
                tokens++;
                turn = "X";
            }
    }
    
        draw();
}

function draw(){
    document.write(JSON.stringify(gameboard));
}

//function play(row, column){
//  if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
//     return alert('That space is occupied!');
//  } else {
//    gameboard[row][column] = turn; //place X or O depending on who's playing
//  if(turn ==='X'){
//      tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
//      turn = "O";
//  } else {
//      tokens++;
//      turn = "X";
//  }
//}
// document.write(JSON.stringify(gameboard));


function win(){ //look for a win
    var row;
    var column;

    if (check_row() || check_column() || check_diagonal()) {
        winner = 1;
    } else if (tokens === 42) {
        winner = 2;
    }
    
    //display win message
}

function check_row(){
    
    for(var i=0; i<gameboard.length; i++){
        var row = gameboard[i];
        if(row === 'X'){
            return true; 
        } else {
            return false; 
        }
        
    }
}
function check_column(){
    
    for(var i=0; i<gameboard.length; i++){
        var column = gameboard[i];
        if(column === 'X'){
            return true; 
        } else {
            return false; 
        }
        
    }
}
function check_diagonal(){
    
    for(var i=0; i<gameboard.length; i++){
        var diagonal = gameboard[i];
        if(diagonal === 'X'){
            return true; 
        } else {
            return false; 
        }
        
    }
}

//function play(row, column){
//    if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
//       return alert('That space is occupied!');
//    } else {
//        gameboard[row][column] = turn; //place X or O depending on who's playing
//      if(turn ==='X'){
//          tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
//          turn = "O";
//      } else {
//          tokens++;
//          turn = "X";
//      }
//    }
//     document.write(JSON.stringify(gameboard));

// function win(){ //look for a win
//   var row;
//   var column;

//   if (check_row() || check_column() || check_diagonal()) {
//       winner = 1;
//   } else if (tokens === 42) {
//       winner = 2;
//   }
    
//   //display win message
// }

// function check_row(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var row = gameboard[i];
//       if(row === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_column(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var column = gameboard[i];
//       if(column === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_diagonal(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var diagonal = gameboard[i];
//       if(diagonal === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }

//function play(row, column){
//    if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
//       alert('That space is occupied!');
//    } else {
//        gameboard[row][column] = turn; //place X or O depending on who's playing
//      if(turn ==='X'){
//          tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
//          turn = "O";
//      } else {
//          tokens++;
//          turn = "X";
//      }
//    }
//     document.write(JSON.stringify(gameboard));

// function win(){ //look for a win
//   var row;
//   var column;

//   if (check_row() || check_column() || check_diagonal()) {
//       winner = 1;
//   } else if (tokens === 42) {
//       winner = 2;
//   }
    
//   //display win message
// }

// function check_row(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var row = gameboard[i];
//       if(row === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_column(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var column = gameboard[i];
//       if(column === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_diagonal(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var diagonal = gameboard[i];
//       if(diagonal === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }

// function play(row, column){
//    if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
//       alert('That space is occupied!');
//    } else {
//        gameboard[row][column] = turn; //place X or O depending on who's playing
//      if(turn ==='X'){
//          tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
//          turn = "O";
//      } else {
//          tokens++;
//          turn = "X";
//      }
//    }
//     document.write(JSON.stringify(gameboard));

// function win(){ //look for a win
//   var row;
//   var column;

//   if (check_row() || check_column() || check_diagonal()) {
//       winner = 1;
//   } else if (tokens === 42) {
//       winner = 2;
//   }
    
//   //display win message
// }

// function check_row(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var row = gameboard[i];
//       if(row === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_column(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var column = gameboard[i];
//       if(column === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_diagonal(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var diagonal = gameboard[i];
//       if(diagonal === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }

// function play(row, column){
//    if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
//       alert('That space is occupied!');
//    } else {
//        gameboard[row][column] = turn; //place X or O depending on who's playing
//      if(turn ==='X'){
//          tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
//          turn = "O";
//      } else {
//          tokens++;
//          turn = "X";
//      }
//    }
//     document.write(JSON.stringify(gameboard));

// function win(){ //look for a win
//   var row;
//   var column;

//   if (check_row() || check_column() || check_diagonal()) {
//       winner = 1;
//   } else if (tokens === 42) {
//       winner = 2;
//   }
    
//   //display win message
// }

// function check_row(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var row = gameboard[i];
//       if(row === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_column(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var column = gameboard[i];
//       if(column === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_diagonal(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var diagonal = gameboard[i];
//       if(diagonal === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }

// function play(row, column){
//    if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
//       alert('That space is occupied!');
//    } else {
//        gameboard[row][column] = turn; //place X or O depending on who's playing
//      if(turn ==='X'){
//          tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
//          turn = "O";
//      } else {
//          tokens++;
//          turn = "X";
//      }
//    }
//     document.write(JSON.stringify(gameboard));

// function win(){ //look for a win
//   var row;
//   var column;

//   if (check_row() || check_column() || check_diagonal()) {
//       winner = 1;
//   } else if (tokens === 42) {
//       winner = 2;
//   }
    
//   //display win message
// }

// function check_row(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var row = gameboard[i];
//       if(row === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_column(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var column = gameboard[i];
//       if(column === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_diagonal(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var diagonal = gameboard[i];
//       if(diagonal === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }

// function play(row, column){
//    if (gameboard[row][column] === "X" || gameboard[row][column] === "O") {
//       alert('That space is occupied!');
//    } else {
//        gameboard[row][column] = turn; //place X or O depending on who's playing
//      if(turn ==='X'){
//          tokens++;   //change turn to O and update the tokens (keep track of which player is currently playing)
//          turn = "O";
//      } else {
//          tokens++;
//          turn = "X";
//      }
//    }
//     document.write(JSON.stringify(gameboard));

// function win(){ //look for a win
//   var row;
//   var column;

//   if (check_row() || check_column() || check_diagonal()) {
//       winner = 1;
//   } else if (tokens === 42) {
//       winner = 2;
//   }
    
//   //display win message
// }

// function check_row(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var row = gameboard[i];
//       if(row === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
// }
// function check_column(){
    
//   for(var i=0; i<gameboard.length; i++){
//       var column = gameboard[i];
//       if(column === 'X'){
//           return true; 
//       } else {
//           return false; 
//       }
        
//   }
//