# When the game starts you generate a random number between 1 and 10 (both inclusive). You can continue playing as long as you want.
#The program will stop when you enter a number out of range (<1 || >10) or if you decide to quit by entering "q". For every guess, your friend will give you the feedback whether the guess is too high or too low. For every correct guess, she’ll give you a “Good job” and for each wrong one, an “Ouch” (for the first wrong guess), and then afterwards a “Phew…close one”.
#Keep the number of wrong tries in mind and only show this message if it is your last try. Your program should end with a winning or losing message. Example:
#Enter number between 1 and 10 (or enter q to quit): 7
#Too high
#Enter number between 1 and 10 (or enter q to quit): 5
#Ouch…close one
#Enter number between 1 and 10 (or enter q to quit): 3
#Good job!
#Enter number between 1 and 10 (or enter q to quit): 6
#Too high
#Enter number between 1 and 10 (or enter q to quit): q
#Game over. You lose. The number was 7.

def main():
	import random, string

	guess_number = -1
	range_min, range_max = 1, 10
	numbers = list(string.digits)
	numbers.extend(['-', '+'])
	while True:
		computer_random_number = random.randint(range_min, range_max)
		for _ in xrange(3):
			print "Enter number between %s and %s (or enter q to quit): " %(range_min, range_max),
			guess_number = raw_input()
			if guess_number.lower().startswith('q'):
				return
			elif not guess_number.isdigit():
				print "Invalid input."
				continue
			guess_number = int(guess_number)
			if guess_number < range_min or guess_number > range_max:
				print "Enter number between %s and %s (or enter q to quit): " %(range_min, range_max),
			elif guess_number == computer_random_number:
				print 'Good job!'
				break
		else:
			return
main()