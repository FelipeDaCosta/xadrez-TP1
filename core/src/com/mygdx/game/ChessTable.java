package com.mygdx.game;

import com.mygdx.pieces.*;
import java.util.Scanner;

public class ChessTable {



    public static void main(String[] args){
        Player p1;
        Player p2;
        ChessBoard chessBoard = new ChessBoard();

        p1 = chessBoard.join();
        p2 = chessBoard.join();
        Scanner keyboard = new Scanner(System.in);


        while(true) {
            System.out.println();
            chessBoard.printBoard();
            System.out.println();
            char Xs;
            char Ys;
            char Xd ;
            char Yd;
            while(true){
                System.out.println("Jogada do Player "+chessBoard.getWhoseTurn()+": ");
                String line = keyboard.nextLine();
                if(line.length()==4){
                    Xs = line.charAt(0);
                    Ys = line.charAt(1);
                    Xd = line.charAt(2);
                    Yd = line.charAt(3);

                    if(Xs >= (int)'A' && Xs <= (int)'H' && Xd >= (int)'A' && Xd <= (int)'H' && Ys > 48 && Ys<57 && Yd > 48 && Yd<57)
                        break;

                }else if(line.equals("listar")){
                    p1.getPieces().printListPositions(p1.getName());
                    p1.getPieces().printListPieces("");
                    System.out.println();
                    p2.getPieces().printListPositions(p2.getName());
                    p2.getPieces().printListPieces("");
                }else
                System.out.println("Comando não reconhecido. Tente Novamente");
            }

            System.out.println();
            System.out.println(Xs + "" + Ys + " -> " + Xd + "" + Yd);
            if ((chessBoard.getWhoseTurn() == 1)){
                chessBoard.requestMove(p1, new Position(Xs, (int) Ys - 48), new Position(Xd, (int) Yd - 48));
            }
            if (chessBoard.getWhoseTurn() == 2) {
                chessBoard.requestMove(p2, new Position(Xs, (int) Ys - 48), new Position(Xd, (int) Yd - 48));
            }
        }

    }

    public static void printListPositions(String head, PieceList list){
        int size = list.size();
        char X; int Y;
        System.out.println(head);
        for(int i=0; i<size; i++){
            X = (char) (list.get(i).getPosition().getX()+65);
            Y = list.get(i).getPosition().getY()+1;
            System.out.print("("+X+","+Y+") ");
        }
        System.out.println();
    }
    public static void printListPieces(String head, PieceList list){
        int size = list.size();
        char X; int Y;
        System.out.print(head);
        for(int i=0; i<size; i++){
            System.out.print(" "+list.get(i).getPieceCode()+"  ");
        }
        System.out.println();
    }


}
