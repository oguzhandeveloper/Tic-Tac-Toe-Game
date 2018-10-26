/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author OGUZHAN
 */
public class ComputerAI {
public class Move 
{ 
    int row, col; 
}
  
char player = 'x', opponent = 'o'; 

final int PLAYER_ONE = 0;
    final int PLAYER_TWO = 1;
    final int PLAYER_NOONE = -1;

  
// This function returns true if there are moves 
// remaining on the board. It returns false if 
// there are no moves left to play. 
public boolean isMovesLeft(int[][] board) 
{ 
    for (int i = 0; i<3; i++) 
        for (int j = 0; j<3; j++) 
            if (board[i][j]==PLAYER_NOONE) 
                return true; 
    return false; 
} 
  
// This is the evaluation function as discussed 
// in the previous article ( http://goo.gl/sJgv68 ) 
public int evaluate(int[][] board) 
{ 
    // Checking for Rows for X or O victory. 
    for (int row = 0; row<3; row++) 
    { 
        if (board[row][0]==board[row][1] && 
            board[row][1]==board[row][2]) 
        { 
            if (board[row][0]==PLAYER_ONE) 
                return +10; 
            else if (board[row][0]==PLAYER_TWO) 
                return -10; 
        } 
    } 
  
    // Checking for Columns for X or O victory. 
    for (int col = 0; col<3; col++) 
    { 
        if (board[0][col]==board[1][col] && 
            board[1][col]==board[2][col]) 
        { 
            if (board[0][col]==PLAYER_ONE) 
                return +10; 
  
            else if (board[0][col]==PLAYER_TWO) 
                return -10; 
        } 
    } 
  
    // Checking for Diagonals for X or O victory. 
    if (board[0][0]==board[1][1] && board[1][1]==board[2][2]) 
    { 
        if (board[0][0]==PLAYER_ONE) 
            return +10; 
        else if (board[0][0]==PLAYER_TWO) 
            return -10; 
    } 
  
    if (board[0][2]==board[1][1] && board[1][1]==board[2][0]) 
    { 
        if (board[0][2]==PLAYER_ONE) 
            return +10; 
        else if (board[0][2]==PLAYER_TWO) 
            return -10; 
    } 
  
    // Else if none of them have won then return 0 
    return 0; 
} 
 
public int max(int a, int b){
    if(a>b) return a;
    else return b;
}

public int min(int a,int b){
    if(a<b) return a;
    else return b;
}

// This is the minimax function. It considers all 
// the possible ways the game can go and returns 
// the value of the board 
public int minimax(int [][] board, int depth, boolean isMax) 
{ 
    int score = evaluate(board); 
  
    // If Maximizer has won the game return his/her 
    // evaluated score 
    if (score == 10) 
        return score; 
  
    // If Minimizer has won the game return his/her 
    // evaluated score 
    if (score == -10) 
        return score; 
  
    // If there are no more moves and no winner then 
    // it is a tie 
    if (isMovesLeft(board)==false) 
        return 0; 
  
    // If this maximizer's move 
    if (isMax) 
    { 
        int best = -1000; 
  
        // Traverse all cells 
        for (int i = 0; i<3; i++) 
        { 
            for (int j = 0; j<3; j++) 
            { 
                // Check if cell is empty 
                if (board[i][j]==PLAYER_NOONE) 
                { 
                    // Make the move 
                    board[i][j] = PLAYER_ONE; 
  
                    // Call minimax recursively and choose 
                    // the maximum value 
                    best = max( best, 
                        minimax(board, depth+1, !isMax) ); 
  
                    // Undo the move 
                    board[i][j] = PLAYER_NOONE; 
                } 
            } 
        } 
        return best; 
    } 
  
    // If this minimizer's move 
    else
    { 
        int best = 1000; 
  
        // Traverse all cells 
        for (int i = 0; i<3; i++) 
        { 
            for (int j = 0; j<3; j++) 
            { 
                // Check if cell is empty 
                if (board[i][j]==PLAYER_NOONE) 
                { 
                    // Make the move 
                    board[i][j] = PLAYER_TWO; 
  
                    // Call minimax recursively and choose 
                    // the minimum value 
                    best = min(best, 
                           minimax(board, depth+1, !isMax)); 
  
                    // Undo the move 
                    board[i][j] = PLAYER_NOONE; 
                } 
            } 
        } 
        return best; 
    } 
} 
  
// This will return the best possible move for the player 
Move findBestMove(int[][] board) 
{ 
    int bestVal = -1000; 
    Move bestMove = new Move(); 
    bestMove.row = -1; 
    bestMove.col = -1; 
  
    // Traverse all cells, evaluate minimax function for 
    // all empty cells. And return the cell with optimal 
    // value. 
    for (int i = 0; i<3; i++) 
    { 
        for (int j = 0; j<3; j++) 
        { 
            // Check if cell is empty 
            if (board[i][j]==PLAYER_NOONE) 
            { 
                // Make the move 
                board[i][j] = PLAYER_ONE; 
  
                // compute evaluation function for this 
                // move. 
                int moveVal = minimax(board, 0, false); 
  
                // Undo the move 
                board[i][j] = PLAYER_NOONE; 
  
                // If the value of the current move is 
                // more than the best value, then update 
                // best/ 
                if (moveVal > bestVal) 
                { 
                    bestMove.row = i; 
                    bestMove.col = j; 
                    bestVal = moveVal; 
                } 
            } 
        } 
    } 
  
    System.out.println("The value of the best Move is : %d\n\n"+bestVal); 
  
    return bestMove; 
} 
}
