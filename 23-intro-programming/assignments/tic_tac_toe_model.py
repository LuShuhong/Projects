#to introduce order of who plays first

import random

class Game:
    def __init__(self,p1 = "Player 1" ,p2 = "the Computer"):
        self.p1 = p1
        self.p2 = p2
        self.board = [0] * 9
        
        print(f"{self.p1} has started a game with {self.p2}")
       
       #print(self.board)

    def state(self):
        pass

    #what if user input invalid row and column(e.g, row 4, column4, or a space that has already been filled)
    def user_play(self,row,column):
        list_position = (row - 1)*3 + column -1
        self.board[list_position] = 1
        return self.board

    # this part need changing cause it is calculating random number continiously until found an empty space, a better way will be to have another method which returns empty spaces
    def computer_play(self):
        if self.has_empty_space() and not self.has_winner():
            computer_position =  random.randint(0,8)
            while self.board[computer_position] != 0:
                computer_position =  random.randint(0,8)
            self.board[computer_position] = 2
            print(f"Computer plays on {computer_position}")
            
    
    def has_empty_space(self):
        try:
            x = self.board.index(0)
            return True
        except ValueError:
            return False

    #logic needs to improve
    def has_winner(self):
        if self.board[0] == self.board[1] == self.board[2]==1 or self.board[3] == self.board[4] == self.board[5]==1 or self.board[6] == self.board[7] == self.board[8] == 1:
            print("Player has completed a row, Player wins!")
            return True

        elif self.board[0] == self.board[1] == self.board[2]==2 or self.board[3] == self.board[4] == self.board[5]==2 or self.board[6] == self.board[7] == self.board[8] == 2:
            print("Computer has completed a row, Player loses :(")
            return True

        elif self.board[0] == self.board[3] == self.board[6]==1 or self.board[1] == self.board[4] == self.board[7]==1 or self.board[2] == self.board[5] == self.board[8] == 1:
            print("Player has completed a column, Player wins!")
            return True

        elif self.board[0] == self.board[3] == self.board[6]==2 or self.board[1] == self.board[4] == self.board[7]==2 or self.board[2] == self.board[5] == self.board[8] == 2:
            print("Computer has completed a column, Player loses :(")
            return True

        elif self.board[0] == self.board[4] == self.board[8]==1 or self.board[2] == self.board[4] == self.board[6]==1:
            print("Player has completed a diagonal, Player wins!")
            return True

        elif self.board[0] == self.board[4] == self.board[8]==2 or self.board[2] == self.board[4] == self.board[6] == 2:
            print("Computer has completed a diagonal, Player loses :(")
            return True

        elif not self.has_empty_space():
            print("It is a draw")
            return True

        return False
        
    
    def play(self):
        while not self.has_winner() and  self.has_empty_space():
            row = int(input('Enter the row:  '))
            column = int(input('Enter the column:  '))
            self.user_play(row,column)
            self.computer_play()

        continue_game = input("Enter any key to continue another game. Press Enter to quit")
        if bool(continue_game):
            self.board = [0] * 9
            self.play()

if __name__ ==  "__main__":
    game1 = Game()
    game1.play()
