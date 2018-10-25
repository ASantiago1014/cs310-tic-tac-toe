# Introduction
This program was designed and created during my CS 310 class, and is a simulation of the classic game that everyone has played at one point in their life: Tic-Tac-Toe. Tic-Tac-Toe is a game played by two players, where one person uses X's and the other uses O's to try and get three in a row while blocking any attempt by the opponent to do the same. This program is a simulation of that game, where a Model-View-Controller is organized within a GUI, and allows players to play the game on their own computer without having to waste any paper. 

# How It Works
As previously stated, this program is organized as a Model-View-Controller GUI application. The way the program works after start-up is that the person who has chosen to be X's goes first. The player will choose a square by clicking where they want their mark placed, and the program will place the mark accordingly within the square. Each player will take turns choosing squares to place their mark until one player wins or a tie occurs, in which case the program will declare the outcome: if X wins, the game will state "X!"; if O wins, the game will state "O!"; and if a tie occurs, the game will state "TIE!". After an outcome has been declared, the game denies any option to choose additional squares by disabling the board, and gives the option to exit on close. 

# Classes

## TicTacToeModel
This class is the model for the game, and handles all of the data and variables. It is within this class where the marks and the results, represented as enumerations, are initialized. The grid for the board, represented as a 2D array of marks, is also initialized, as well as a boolean called "xTurn" that determines if it is X's or O's turn. Finally, the width is stated and determines the size of the game. The constructor creates the grid and fills each square with empty marks based on the size of the board. The model has methods for placing each player's marks in valid squares based on if the square is empty, checking squares to see if they are valid or marked, and checking to see if the mark is a win or a tie. The game checks for a win by checking the rows, columns, and diagonals to see if there are three of the same marks in a row. If the last mark isn't a winning mark, and if all the squares in the board are occupied, then the program declares a tie. It also declares getters for the width of the board, the xTurn boolean, the result, and the mark.

## TicTacToeView
This class is the view for the game, and combines the view and controller into one class. It accepts the model in order to display the board to the console. This class extends the ActionListener and initializes the board as a 2D array of JButtons with a result label set at the bottom. This class creates and displays the board after populating it with squares. It also contains methods for handling button clicks, updating the squares after a mark is placed, and showing the result of the game. This class handles button clicks by extracting the row and column values from the name of the button chosen, such as "Square11", which is the middle square. Then it calls the model's makeMark() method to place the mark at the specified row and column and uses the method that updates the squares to display the new board.

## Main File - TicTacToe
This is the main file that extends the JPanel. This file creates the Model-View-Controller objects and is how the game is displayed for use. It has an option to set a new width from the command line, however it initializes a default width of 3. 

# Conclusion
This program combines the format of an M-V-C and the usability of a GUI to form one fun and easy-to-use game for anybody to play. Each class works together to handle the data, handle input and output, and display the board to the console. 