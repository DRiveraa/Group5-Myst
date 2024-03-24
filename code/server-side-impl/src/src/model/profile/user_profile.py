'''
Created on Mar 24, 2024

@author: Jeffrey
'''

from src.model.games.gamelibrary import GameLibrary


class User_Profile:

    def __init__(self, username, password):
        if username is None:
            raise Exception("username is none")
        if password is None:
            raise Exception("password is none")
        self.username = username
        self.password = password
        self.allOwnedGames = GameLibrary()
        self.allLikedGames = GameLibrary()
        self.allDislikedGames = GameLibrary()
        self.preferredGenres = []


    def get_username(self):
        return self.username
    
    def set_username(self, new_username):
        if new_username is None:
            raise Exception("new_username is none")
        self.username = new_username
    
    def get_password(self):
        return self.password
    
    def set_password(self, new_password):
        if new_password is None:
            raise Exception("new_password is none")
        self.password = new_password

    def get_all_owned_games_game_library(self):
        return self.allOwnedGames
    
    def get_all_liked_games_game_library(self):
        return self.allLikedGames
    
    def get_all_disliked_games_game_library(self):
        return self.allDislikedGames
    
    def get_preferred_genres(self):
        return self.preferredGenres