package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */
        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */
        for (int i = 0; i < width - 1; ++i) {
            for (int j = 0; j < width - 1; ++j) {
                grid[i][j] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */
        /* if (isValidSquare(row,col) && !isSquareMarked(row,col) then grid[row][col] = players mark */
        boolean result = false;
        if (xTurn && isValidSquare(row,col) && !isSquareMarked(row,col)) {
            grid[row][col] = Mark.X;
            result = true;
        }
        else if (!xTurn && isValidSquare(row,col) && !isSquareMarked(row,col)) {
            grid[row][col] = Mark.O;
            result = true;
        }

        return result;
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */
        boolean result = false;
        /* if (row is between 0 and width && col is between 0 and width) return true*/
        if (row >= 0 && row < width && col >=0 && col < width) {
            result = true;
        }
         /* remove this line! */
        return result;
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */
        boolean result = false;
        
        /* if (grid[row][col] != EMPTY) then return true*/
        if (grid[row][col] != Mark.EMPTY) {
            result = true;
        }
         /* remove this line! */  
        return result;
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */
        Mark mark = grid[row][col];
        
        return mark;
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
        Result result;
        
        if (isMarkWin(Mark.X)) {
            
            result = Result.X;
        }
        
        else if (isMarkWin(Mark.O)) {
            
            result = Result.O;
        }
        
        else if (isTie()) {
            
            result = Result.TIE;
        }
        
        else {
            
            result = Result.NONE;
        }

        return result; 

    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        /* INSERT YOUR CODE HERE */
        boolean win = false;
        
        /* check rows for win */
        for (int r = 0; r < width; ++r) {
            
            if (grid[r][0] == mark) {
                
                int c;
                
                for (c = 1; c < width; ++c) {
                    
                    if (grid[r][c] != mark) {
                        
                        break;
                    }
                    
                }
                
                if (c == width) {
                    
                    win = true;
                }
            }
                    
        }
        
        /* check columns for win*/
        for (int c = 0; c < width; ++c) {
            
            if (grid[0][c] == mark) {
                
                int r;
                
                for (r = 1; r < width; ++r) {
                    
                    if (grid[c][r] != mark) {
                        
                        break;
                    }
                    
                }
                
                if (r == width) {
                    
                    win = true;
                    
                }
                
            }
            
        }
        
        /* check diagonals for win */
        int i;
        
        for (i = 0; i < width; ++i) {
            
            if (grid[i][i] != mark) {
                
                break;
            }
            
        }
        if (i == width) {
            
            win = true;
            
        }
        
        for (i = 0; i < width; ++i) {
            
            if (grid[i][(width - 1) - i] != mark) {
            
                break;
            
            }
        }
        
        if (i == width) {
            
            win = true;
            
        }

        return win;

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        boolean tie = false;
        
        for (int i = 0; i < width; ++i) {
            
            for (int j = 0; j < width; ++j) {
                
                if (grid[i][j] != Mark.EMPTY) {
                    
                    tie = true;
                }
                
                else {
                    
                    tie = false;
                    
                    break;
                }
            }
        }

        return tie;
        
    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}