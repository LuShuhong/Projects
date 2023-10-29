from tic_tac_toe_model import Game
from io import StringIO
import pytest
from unittest.mock import Mock
import random

#if user input a letter/ number greater than 4, exception is raised
#if board empty, user needs to re-enter
#win-condition met, then prompt and end 

@pytest.fixture
def game():
    new_game = Game()
    return new_game


@pytest.fixture
def mocked_boards():
    class game_board():
        def empty_board(self):
            return [0]*9
        def user_win_first_row(self):
            return [1,1,1,0,0,0,0,0,0]
        def computer_win_board(self):
            return [0,2,0,0,2,0,0,2,0]
        def draw_board(self):
            return [1,2,1,2,1,2,2,1,2]
    return game_board
        



def test_input_not_number_then_exception(game,monkeypatch):
    letter_input = StringIO('x')
    monkeypatch.setattr('sys.stdin',letter_input)
    with pytest.raises(Exception):
        game.user_play()

def test_valid_input(game,monkeypatch):
    letter_input = StringIO('1\n1')
    monkeypatch.setattr('sys.stdin',letter_input)
    game.user_play()
    assert game.board[0] == 1


def test_number_input_greater_than_three(game,monkeypatch):
    letter_input = StringIO('4\n3')
    monkeypatch.setattr('sys.stdin',letter_input)
    with pytest.raises(Exception):
        game.user_play()

def test_has_winner(game,mocked_boards):
    game.board = mocked_boards().user_win_first_row()
    assert game.has_winner() is True

    game.board = mocked_boards().empty_board()
    assert game.has_winner() is False

    game.board = mocked_boards().computer_win_board()
    assert game.has_winner() is True


def test_game_board(game, mocked_boards):
    game.board = mocked_boards().user_win_first_row()
    
    result = game.game_board()
    assert result == f" X | X | X \n-----------\n   |   |   \n-----------\n   |   |    "


def test_no_empty_space(game,mocked_boards):
    game.board = mocked_boards().draw_board()
    assert game.has_empty_space() is False


def test_computer_play(game,mocked_boards,monkeypatch):
    game.board = mocked_boards().empty_board()
    monkeypatch.setattr(random, "choice", lambda x: 3)
    game.computer_play()
    assert game.board[3] ==2
