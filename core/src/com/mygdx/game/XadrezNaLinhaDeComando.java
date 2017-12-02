package com.mygdx.game;

import com.mygdx.pieces.*;
import java.util.Scanner;

public class XadrezNaLinhaDeComando {
/*
* Essa classe foi criada para testar o jogo pela linha de comando (sem interface gráfica).
*
* Mantive ela pois acredito que facilitará os testes em rede.
* */


    public static void main(String[] args) {
        /*
        *
        * FUNCIONAMENTO DA PARTIDA:
        *
        * A idéia aqui é que o objeto chessTable seja instanciado apenas uma vez (no servidor, na versão final)
        * Os players pedem pra entrar no jogo através da função join.
        * A função retorna um objeto do tipo player instanciado ou a mensagem "tabuleiro lotado"
        *
        * O objeto chessTable escolhe quem fica com as peças pretas e brancas, e quem
        * joga na parte de cima ou de baixo do tabuleiro.
        *
        * */

        Player p1;
        Player p2;
        ChessTable chessTable = new ChessTable(1, "alex", "jorge");
        p1 = chessTable.Me;
        p2 = chessTable.Enemy;
        boolean firstTurn = true;
        String player1 = "XXX", player2 = "YYY";
        // chessTable.linhaDeComando = 1;



        /*
        *
        * Como jogar na linha de comando?
        * Basicamente, na jogada você escreve uma string do tipo "A2A3"
        * "A2A3" = peça que está na casa A2 para a casa A3
        *
        * */


        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.println();
            if (firstTurn) {
                chessTable.printMenu();
                String line;
                do {
                    System.out.print("Choice: ");
                    line = keyboard.nextLine();
                } while (line.charAt(0) != '1' && line.charAt(0) != '2');
                switch (line.charAt(0)) {
                    case ('1'):
                        System.out.print("Player 1 name: ");
                        player1 = keyboard.nextLine();
                        System.out.print("Player 2 name: ");
                        player2 = keyboard.nextLine();
                        break;
                    case ('2'):
                        System.exit(0);
                        break;
                }
                firstTurn = false;
            }
            System.out.println();
            chessTable.printBoard();
            System.out.println();
            char Xs;
            char Ys;
            char Xd;
            char Yd;
            while (true) {
                /*if(chessTable.getWhoseTurn() == 1)
                    System.out.println("Jogada do Player "+player1+": ");
                else
                    System.out.println("Jogada do Player "+player2+": ");
                //System.out.println("Jogada do Player "+chessTable.getWhoseTurn()+": "); // getWhoseTurn é quem tem a vez.
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

            /*Aqui um hackzinho para que você sempre jogue como se fosse o jogador que tem a vez*/
           /* if ((chessTable.getWhoseTurn() == 1)){
                chessTable.requestMove(p1, new Position(Xs, (int) Ys - 48), new Position(Xd, (int) Yd - 48));
            }
            if (chessTable.getWhoseTurn() == 2) {
                chessTable.requestMove(p2, new Position(Xs, (int) Ys - 48), new Position(Xd, (int) Yd - 48));
            }
            */

            }

        }
    }}