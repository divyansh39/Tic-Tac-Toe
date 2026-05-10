package org.example;

import org.example.model.GameStatus;

import static org.example.model.GameStatus.DRAW;
import static org.example.model.GameStatus.WIN;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("\n----------TIC TAC TOE------------\n");
        TicTacToeGame game=new TicTacToeGame();
        game.initializeGame();
        GameStatus status=game.startGame();
        System.out.println("\n-----------GAME OVER-------------");
        switch (status){
            case WIN:
                System.out.println(game.winner.name+" won the game");
                break;
            case DRAW:
                System.out.println("Its a Draw!!");
                break;
            default:
                System.out.println("Game Ends ");
                break;
        }

    }
}