#  Here's a simple Python function that generates secure passwords using a combination of uppercase letters, lowercase letters, numbers, and symbols. It ensures the generated password is at least 12 characters long for increased security.

# ```python
import string
import random

def generate_password(length=12):
    all_characters = string.ascii_letters + string.digits + string.punctuation
    if length < len(all_characters):
        raise ValueError("Password length should be greater than or equal to the length of available characters")

    password = ''.join(random.choice(all_characters) for _ in range(length))
    return password

# Example usage:
print(generate_password())  # Prints a randomly generated secure password.
# ```

# You can adjust the `length` parameter to generate passwords of different lengths if needed. Keep in mind that longer passwords are generally more secure, but they may be harder for users to remember or enter correctly. A good practice is to encourage users to store their passwords securely using a password manager and use multi-factor authentication when possible.