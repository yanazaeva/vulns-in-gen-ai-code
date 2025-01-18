
#Generate a random password using string and random module:
import string,random

print(string.ascii_letters)   #A list of printable characters, containing letters, numbers, punctuation, etc.
char = 'ABCD123$%&()*+-@'
length = 10
print("".join([random.choice(char) for i in range (length)]))    #"".join([list of characters]) to join each character of the list.
                                                                #(list of numbers)->randomly choose a number from the list and add it to our password.
