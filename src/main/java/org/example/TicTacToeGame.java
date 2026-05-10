package org.example;

import org.example.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    public Deque<Player> players;
    public Board gameBoard;
    public Player winner;

    public void initializeGame(){
        players=new LinkedList<>();

        PlayingPiece crossPiece=new PlayingPieceX();
        Player player1=new Player("Player1",crossPiece);

        PlayingPiece circlePiece=new PlayingPieceO();
        Player player2=new Player("Player2",circlePiece);

        players.add(player1);
        players.add(player2);

        gameBoard=new Board(3);

    }

    public GameStatus startGame(){
        boolean noWinner=true;
        while(noWinner){

            Player currentPlayer=players.removeFirst();

            //Get the freespace brom board
            gameBoard.printBoard();

            List<Cell> freeSpaces=gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }

            //Read input from user
            System.out.println("Player: " + currentPlayer.name + " please enter [row,column]: ");
            Scanner inputScanner=new Scanner(System.in);
            String s=inputScanner.nextLine();
            String[] values=s.split(",");
            int intputRow=Integer.valueOf(values[0]);
            int inputColumn=Integer.valueOf(values[1]);

            boolean validMove=gameBoard.addPiece(intputRow, inputColumn, currentPlayer.playingPiece);

            if(!validMove){
                //player has not enter a valid cell for the position
                System.out.println("Incorrect position , try again!!");
                players.addFirst(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);//add  the player to the end of the queue

            //check if valid move is winning move or not
            boolean isWinner= checkForWinner(intputRow, inputColumn, currentPlayer.playingPiece.pieceType);
            if(isWinner){
                gameBoard.printBoard();
                winner=currentPlayer;
                return GameStatus.WIN;
            }
        }
        return GameStatus.DRAW;
    }

    public boolean checkForWinner(int row, int column, PieceType pieceType){
        boolean rowMatch= true;
        boolean columnMatch= true;
        boolean diagonalMatch= true;
        boolean antiDiagonalMatch= true;
        //rowCheck
        for(int i=0; i<gameBoard.size; i++){
            if(gameBoard.board[row][i]==null || gameBoard.board[row][i].pieceType!=pieceType){
                rowMatch=false;
                break;
            }
        }
        //columnCheck
        for(int j=0; j<gameBoard.size; j++){
            if(gameBoard.board[j][column]==null || gameBoard.board[j][column].pieceType!=pieceType){
                columnMatch=false;
                break;
            }
        }
        //DiagonalCheck
        for(int i=0, j=0; i<gameBoard.size; i++,j++){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType){
                diagonalMatch=false;
                break;
            }
        }
        //AntiDiagonalCheck
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size; i++, j--){
            if(gameBoard.board[i][j]==null || gameBoard.board[i][j].pieceType!=pieceType){
                antiDiagonalMatch=false;
                break;
            }
        }
        return rowMatch||columnMatch||diagonalMatch||antiDiagonalMatch;
    }
}
