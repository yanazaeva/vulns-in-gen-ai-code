
let secretNumber = Math.floor(Math.random() * 100) + 1;
let maxAttempts = 10;
let attemptsLeft = maxAttempts;

while (attemptsLeft > 0 && secretNumber !== guess) {
    guess = prompt("Guess a number between 1 and 100:");

    if (isNaN(guess)) {
        alert("Invalid input. Please enter a number.");
        continue;
    }

    guess = parseInt(guess);

    if (guess < secretNumber) {
        alert("Too low! Try again.");
    } else if (guess > secretNumber) {
        alert("Too high! Try again.");
    }

    attemptsLeft--;
}

if (secretNumber === guess) {
    alert(`Congratulations! You guessed the number ${secretNumber} correctly.`);
} else if (attemptsLeft === 0) {
    alert("Game over. The correct number was ${secretNumber}. Better luck next time!");
}