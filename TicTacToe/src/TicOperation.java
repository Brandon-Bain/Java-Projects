import java.util.Scanner;

/*
 * Brandon Bain
 * 11/20/2016
 * Tic Tac Toe
 */

public class TicOperation {

    private int player1 = 1;
    private int player2 = 2;
    private int[][] board = new int[3][3];
    private int currentPlayer = 1;
    private int row, column;
    private int winningPlayer;

    public void getUserInput(){
        Scanner scan1 = new Scanner(System.in);

        System.out.println("Player "+currentPlayer+" enter row to play. (1-3)");
        row = scan1.nextInt()-1;
        System.out.println("Player "+currentPlayer+" enter column to play. (1-3)");
        column = scan1.nextInt()-1;
        checkUserInput();
    }

    public void checkUserInput(){
        if (row > 3)
            getUserInput();
        else if (column > 3)
            getUserInput();
    }

    public void setPlayer1(){
        currentPlayer = player1;
    }

    public void setPlayer2(){
        currentPlayer = player2;
    }

    public void makeMove(){
        board[row][column] = currentPlayer;
    }


    public void winCheck(){
        //Check first line across

        if (board[0][0] != 0 && board[0][0] == board[0][1] && board[0][0] == board[0][2])
            winningPlayer = currentPlayer;
            //Check top left to bottom right diagonal
        else if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            winningPlayer = currentPlayer;
            //Check second line across
        else if (board[1][0] != 0 && board[1][0] == board[1][1] && board[1][0] == board[1][2])
            winningPlayer = currentPlayer;
            //Check third line across
        else if (board[2][0] != 0 && board[2][0] == board[2][1] && board[2][0] == board[2][2])
            winningPlayer = currentPlayer;
            //Check first column
        else if (board[0][0] != 0 && board[0][0] == board[1][0] && board[0][0] == board[2][0])
            winningPlayer = currentPlayer;
            //Check second column
        else if (board[0][1] != 0 && board[0][1] == board[1][1] && board[0][1] == board[2][1])
            winningPlayer = currentPlayer;
            //Check third column
        else if (board[0][2] != 0 && board[0][2] == board[1][2] && board[0][2] == board[2][2])
            winningPlayer = currentPlayer;
            //Check top right to bottom left diagonal
        else if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0])
            winningPlayer = currentPlayer;
        else if (board[0][0] != 0 && board[0][1] != 0 && board[0][2] != 0 && board[1][0] != 0 && board[1][1] != 0 && board[1][2] != 0 && board[2][0] != 0 && board[2][1] != 0 && board[2][2] != 0)
            winningPlayer = 3;
        else if (currentPlayer == 1)
            setPlayer2();
        else if (currentPlayer == 2)
            setPlayer1();

    }

    public void takeTurn(){

        System.out.println("Current Board (0 means empty):");
        System.out.println(board[0][0]+"\t"+board[0][1]+"\t"+board[0][2]);
        System.out.println(board[1][0]+"\t"+board[1][1]+"\t"+board[1][2]);
        System.out.println(board[2][0]+"\t"+board[2][1]+"\t"+board[2][2]);

        getUserInput();
        makeMove();
        winCheck();
    }

    public void runGame(){
        while (winningPlayer == 0){
            takeTurn();
        }
        if (winningPlayer != 3)
            System.out.println("Player "+currentPlayer+" has won.");
        else if (winningPlayer == 3)
            System.out.println("Game is a draw.");
    }


}
