

import random
def print_board(board):  # Prints board
    print(" " + board[0] + " |" + " " + board[1] + " |" + " " + board[2])
    print("-" * 9)
    print(" " + board[3] + " |" + " " + board[4] + " |" + " " + board[5])
    print("-" * 9)
    print(" " + board[6] + " |" + " " + board[7] + " |" + " " + board[8])
    print()


def check_winner(board):  # Checks whether someone won the game
    return ((board[0] == board[1] == board[2]) or (board[3] == board[4] == board[5]) or (board[6] == board[7] == board[8]) or
            (board[0] == board[3] == board[6]) or (board[1] == board[4] == board[7]) or (board[2] == board[5] == board[8]) or
            (board[0] == board[4] == board[8]) or (board[2] == board[4] == board[6]))


def check_full(board):  # Checks whether the game is full and no one won
    return not any(' ' in s for s in board)


def insert_token(x, token, board):  # Inserts a token into specific column
    open_row = next((i for i, mark in enumerate(board[x]) if mark == ' '), None)
    if open_row is not None:
        board[x][open_row] = token


def select_column(board):  # Selects a column where to insert the token, returns it's number
    while True:
        try:
            col = int(input("What column do you want to choose? (0-8)"))
            if 0 <= col < len(board):
                return col
            else:
                print("Invalid input")
        except ValueError:
            print("Invalid input")


def create_board():  # Creates a board, returns it as list of lists
    board = []
    for i in range(8):
        board.append([])
        for j in range(8):
            board[i].append(' ')
    return board

# Game Loop:
def main():  # Main program loop
    turn = 0
    board = create_board()
    while not check_winner(board) and not check_full(board):
        print("Player " + str(turn % 2 + 1) + "'s Turn")
        print_board(board)
        if turn % 2 == 0:
            col = input('Type 1-8 to insert your token into that column or type "exit" to exit the game ')
            while not (col in '1 2 3 4 5 6 7 8'.split()):
                print("Invalid Input!")
                col = input('Type 1-8 to insert your token into that column ')
        else:
            col = random.choice(range(9))
        insert_token(int(col), 'X', board)
        if check_winner(board):
            print("Player " + str((turn - 1) % 2 + 1) + " wins!")
            break
        turn += 1
        if turn == 43:
            print('No one won, the game ended in a tie.')
            break
    play_again = input("Play again? (y/n)")
    if play_again == "yes" or play_again == "y":
        main()

main()