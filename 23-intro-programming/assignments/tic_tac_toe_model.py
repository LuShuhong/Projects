#to introduce order of who plays first
#player wins print twice



import random

class Game:
    game_count = 1

    def __init__(self,p1 = "Player " ,p2 = "the Computer"):
        self.p1 = p1
        self.p2 = p2
        self.board = [0] * 9
        
        print(f"{self.p1} has started a game with {self.p2}")
       
       #print(self.board)

    def game_board(self):
        symbol = {0: '   ', 1: " X ", 2: " O "}
        board_symbol = [symbol[val] for val in self.board]

        game_board = f"{board_symbol[0]}|{board_symbol[1]}|{board_symbol[2]}\n-----------\n{board_symbol[3]}|{board_symbol[4]}|{board_symbol[5]}\n-----------\n{board_symbol[6]}|{board_symbol[7]}|{board_symbol[8]} "

        print (game_board)
        return game_board
        

    #what if user input invalid row and column(e.g, row 4, column4, or a space that has already been filled)
    # def user_play(self):
    #     row = int(input('Enter the row:  '))
    #     column = int(input('Enter the column:  '))
    #     list_position = (row - 1)*3 + column -1
    #     while self.board[list_position] != 0:
    #         print("The space has already been taken")
    #         row = int(input('Enter the row:  '))
    #         column = int(input('Enter the column:  '))
    #         list_position = (row - 1)*3 + column -1
    #     self.board[list_position] = 1
    #     return self.board

    def user_play(self):
        user_play = True
        while user_play:
            try:
                row = int(input('Enter the row:  '))
                column = int(input('Enter the column:  '))
                list_position = (row - 1)*3 + column -1
                if row <= 3 and column <= 3 and self.board[list_position] == 0:
                    user_play = False
                else: 
                    print("Not a valid cell")
            except ValueError as e:
                print("Please enter valid number")

           
            
            # try:
            #     self.board[list_position]
            # except IndexError as e:
            #         user_play = False
            #         print("Not an valid cell")
        
        self.board[list_position] = 1
        # return self.board

    # this part need changing cause it is calculating random number continiously until found an empty space, a better way will be to have another method which returns empty spaces
    # def computer_play(self):
    #     if self.has_empty_space() and not self.has_winner():
    #         computer_position =  random.randint(0,8)
    #         while self.board[computer_position] != 0:
    #             computer_position =  random.randint(0,8)
    #         self.board[computer_position] = 2
    #         print(f"Computer plays on {computer_position}")
            
    def computer_play(self):
        if self.has_empty_space() and not self.has_winner():
            empty_positions = [i for i,x in enumerate(self.board) if x == 0]
            computer_position = random.choice(empty_positions)
            self.board[computer_position] =2
            print(f'\n\nComputer plays on the below\n')
    
    def has_empty_space(self):
        try:
            x = self.board.index(0)
            return True
        except ValueError:
            return False

    #logic needs to improve
    # def has_winner(self):
    #     if self.board[0] == self.board[1] == self.board[2]==1 or self.board[3] == self.board[4] == self.board[5]==1 or self.board[6] == self.board[7] == self.board[8] == 1:
    #         print("Player has completed a row, Player wins!")
    #         return True

    #     elif self.board[0] == self.board[1] == self.board[2]==2 or self.board[3] == self.board[4] == self.board[5]==2 or self.board[6] == self.board[7] == self.board[8] == 2:
    #         print("Computer has completed a row, Player loses :(")
    #         return True

    #     elif self.board[0] == self.board[3] == self.board[6]==1 or self.board[1] == self.board[4] == self.board[7]==1 or self.board[2] == self.board[5] == self.board[8] == 1:
    #         print("Player has completed a column, Player wins!")
    #         return True

    #     elif self.board[0] == self.board[3] == self.board[6]==2 or self.board[1] == self.board[4] == self.board[7]==2 or self.board[2] == self.board[5] == self.board[8] == 2:
    #         print("Computer has completed a column, Player loses :(")
    #         return True

    #     elif self.board[0] == self.board[4] == self.board[8]==1 or self.board[2] == self.board[4] == self.board[6]==1:
    #         print("Player has completed a diagonal, Player wins!")
    #         return True

    #     elif self.board[0] == self.board[4] == self.board[8]==2 or self.board[2] == self.board[4] == self.board[6] == 2:
    #         print("Computer has completed a diagonal, Player loses :(")
    #         return True

    #     elif not self.has_empty_space():
    #         print("It is a draw")
    #         return True

    #     return False
    
    def has_winner(self):
        win_combination = [(0,1,2),(3,4,5),(6,7,8),(0,3,6),(1,4,7),(2,5,8),(0,4,8),(2,4,6)]

        for combo in win_combination:
            if self.board[combo[0]] == self.board[combo[1]] ==self.board[combo[2]] and self.board[combo[0]] != 0:
                if self.board[combo[0]] == 1:
                    print ("\nPlayer Wins")
                else:
                    print("\nComputer Wins")
                return True
        
        if not self.has_empty_space():
            print("It's a draw")
            return True
        
        return False
    
    def play(self):
        while not self.has_winner() and  self.has_empty_space():
            self.user_play()
            self.game_board()
            self.computer_play()
            self.game_board()
        self.end()

    def end(self):
        continue_game = input("Enter any key to continue another game. Press Enter to quit  ")
        if bool(continue_game):
            another_game = Game()
            another_game.play()
        else:
            print("Thanks for playing")

#this class has not been used   
class IllegalMoveError(Exception):
    pass

if __name__ ==  "__main__":
    game1 = Game()
    game1.play()
