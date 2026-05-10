package org.example.model;

public class Board {

    int size;
    PlayingPiece[][] board;

    public Board(int size,PlayingPiece[][] board){
        this.size=size;
        this.board=new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece){
        if(board[row][column]!=null){
            return false;
        }
        board[row][column]=playingPiece;
        return true;
    }

}
