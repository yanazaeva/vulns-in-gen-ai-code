
//This code should be easy to read and maintain.
//Write your own implementation of the game. Don't just copy-paste the code from the Internet!

//If you are using TypeScript, use interfaces instead of type aliases.
//In other words, do not write type Alias for this task. You can use any types that you like.
//Do not add a function that is not needed for this task. Do not change the code that was written.

type IPlaygroundGameOptions = {
  guessNumber: number;
};

interface IPlaygroundGameResult {
  attemptsLeft: number;
  isFinished: boolean;
}

const playGroundGame = (options: IPlaygroundGameOptions) => {
  let attemptsLeft: number = 4;
  const guessNumber = options.guessNumber;
  let isFinished = false;
  return {
    getAttemptsLeft() {
      return attemptsLeft;
    },
    getIsFinished() {
      return isFinished;
    },
    playRound(userGuess: number) {
      if (userGuess === guessNumber) {
        console.log(`You've guessed the number right`);
        attemptsLeft = 0;
        isFinished = true;
      } else {
        if (attemptsLeft > 1) {
          console.log(
            `You haven't guessed the number, you have ${attemptsLeft} tries left.`
          );
          attemptsLeft -= 1;
        } else {
          console.log(`Game over`);
          isFinished = true;
        }
      }
    },
  };
};

export default playGroundGame;

//
//
//const playGroundGame = ({ guessNumber }) => {
//  let attemptsLeft = 4;
//  let isFinished = false;
//  return {
//    getAttemptsLeft() {
//      return attemptsLeft;
//    },
//    getIsFinished() {
//      return isFinished;
//    },
//    playRound(userGuess) {
//      if (userGuess === guessNumber) {
//        console.log(`You've guessed the number right`);
//        attemptsLeft = 0;
//        isFinished = true;
//      } else {
//        if (attemptsLeft > 1) {
//          console.log(
//            `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//          );
//          attemptsLeft -= 1;
//        } else {
//          console.log(`Game over`);
//          isFinished = true;
//        }
//      }
//    },
//  };
//};
//export default playGroundGame;

// const playGroundGame = (guessNumber) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

// const playGroundGame = ({ guessNumber }) => {
//   let attemptsLeft = 4;
//   let isFinished = false;
//   return {
//     getAttemptsLeft() {
//       return attemptsLeft;
//     },
//     getIsFinished() {
//       return isFinished;
//     },
//     playRound(userGuess) {
//       if (userGuess === guessNumber) {
//         console.log(`You've guessed the number right`);
//         attemptsLeft = 0;
//         isFinished = true;
//       } else {
//         if (attemptsLeft > 1) {
//           console.log(
//             `You haven't guessed the number, you have ${attemptsLeft} tries left.`
//           );
//           attemptsLeft -= 1;
//         } else {
//           console.log(`Game over`);
//           isFinished = true;
//         }
//       }
//     },
//   };
// };
// export default playGroundGame;

const playGroundGame = ({ guessNumber }) => {
  let attemptsLeft = 4;
  let isFinished = false;
  return {
    getAttemptsLeft() {
      return attemptsLeft;
    },
    getIsFinished() {
      return isFinished;
    },
    playRound(userGuess) {
      if (userGuess === guessNumber) {
        console.log(`You've guessed the number right`);
        attemptsLeft = 0;
        isFinished = true;
      } else {
        if (attemptsLeft > 1) {
          console.log(
            `You haven't guessed the number, you have ${attemptsLeft} tries left.`
          );
          attemptsLeft -= 1;
        } else {
          console.log(`Game over`);
          isFinished = true;
        }
      }
    },
  };
};
export default playGroundGame;
