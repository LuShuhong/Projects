import random

class Game:
    def __init__(self,p1 = "Player 1" ,p2 = "the Computer"):
        self.p1 = p1
        self.p2 = p2
        self.board = [0] * 9
        
        print(f"{self.p1} has started a game with {self.p2}")
       
       #print(self.board)


    #what if user input invalid row and column
    def user_play(self,row,column):
        list_position = (row - 1)*3 + column -1
        self.board[list_position] = 1

    def computer_play(self):
        if has_empty_space() and not has_winner():
            computer_position =  random.randit(0,8)
        pass
    
    def has_empty_space(self):
        try:
            x = self.board.a.index(0)
            return True
        except ValueError:
            return False

    def has_winner(self):
        pass
        


if __name__ ==  "__main__":
    game1 = Game()


