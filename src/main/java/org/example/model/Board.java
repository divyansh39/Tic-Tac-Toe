package org.example.model;

import java.util.List;

import java.util.ArrayList;

public class Board {

    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
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

    public List<Cell> getFreeCells() {

        List<Cell> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (board[i][j] == null) {
                    freeCells.add(new Cell(i, j));
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {

        System.out.println();

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                if (board[i][j] != null) {
                    System.out.print(" " + board[i][j].pieceType.name() + " ");
                } else {
                    System.out.print("   ");
                }

                if (j != size - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();

            if (i != size - 1) {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }

}
