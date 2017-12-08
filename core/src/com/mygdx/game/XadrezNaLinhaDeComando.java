package com.mygdx.game;

import com.mygdx.pieces.*;
import com.mygdx.web.Web;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class XadrezNaLinhaDeComando {
/*
* Essa classe foi criada para testar o jogo pela linha de comando (sem interface gráfica).
*
* Mantive ela pois acredito que facilitará os testes em rede.
* */


    public static void main(String[] args) throws InterruptedException {

        ChessTable chessTable = null;
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        int myNumber=0;
        String line, myname = "Me";
        String enemy_name = "Enemy";


        printMenu();
        do {
            System.out.print("Choice: ");
            line = keyboard.nextLine();
        } while (line.charAt(0) != '1' && line.charAt(0) != '2');
        switch (line.charAt(0)) {
            case ('1'):
                System.out.print("Your name: ");
                myname = keyboard.nextLine();
                String resp = Web.findGame(myname);
                System.out.println(resp);
                if(resp.equals("ok/1")) myNumber = 1;
                else if(resp.equals("ok/2")) myNumber = 2;
                else{
                    System.out.println("Não foi possível encontrar um jogo");
                    Web.finishGame();
                    System.exit(0);
                    return;
                }

                if(!Web.gotGame().startsWith("yes")) System.out.println("Aguardando oponente...");

                while(Web.gotGame().charAt(0)!='y')
                    TimeUnit.SECONDS.sleep(3);

                System.out.println("Jogo encontrado! Você é o player "+myNumber);

                String names = Web.gotGame();

                String[] names_parts = names.split("/");
                if(!names.equals("no")) {
                    if(myNumber == 1) {
                        enemy_name = names_parts[2];
                    }
                    else {
                        enemy_name = names_parts[1];
                    }
                    System.out.println("Voce esta jogando contra " + enemy_name);

                }

                break;
            case ('2'):
                System.exit(0);
                break;
        }

        chessTable = new ChessTable(myNumber, true);
        chessTable.Me.setName(myname);
        chessTable.Enemy.setName(enemy_name);

        while (true) {
            System.out.println();
            printBoard(chessTable);
            System.out.println();
            char Xs=0;
            char Ys=0;
            char Xd=0;
            char Yd=0;

            if(chessTable.EndOfTheGame){
                System.out.println("Check Mate! "+ chessTable.winner.getName()+" venceu! ");
                Web.finishGame();
                System.exit(0);
                return;
            }

            if(!chessTable.Me.getTurn()){
                System.out.println("Aguarde a jogada do seu oponente...");
                while(!chessTable.Me.getTurn())
                    while(!chessTable.verifyEnemyMove());

            } else {
                while (true) {



                    System.out.println("Sua jogada: ");
                    line = keyboard.nextLine();
                    if (line.length() == 4) {
                        Xs = line.charAt(0);
                        Ys = line.charAt(1);
                        Xd = line.charAt(2);
                        Yd = line.charAt(3);

                        if (Xs >= (int) 'A' && Xs <= (int) 'H' && Xd >= (int) 'A' && Xd <= (int) 'H' && Ys > 48 && Ys < 57 && Yd > 48 && Yd < 57)
                            break;

                    } else if (line.equals("listar")) {
                        chessTable.Me.getPieces().printListPositions(chessTable.Me.getName());
                        chessTable.Me.getPieces().printListPieces("");
                        System.out.println();
                        chessTable.Enemy.getPieces().printListPositions(chessTable.Enemy.getName());
                        chessTable.Enemy.getPieces().printListPieces("");
                    } else if (line.equals("sair")) {
                        Web.finishGame();
                        System.exit(0);
                        return;
                    }else
                    System.out.println("Comando não reconhecido. Tente Novamente");
                }

                chessTable.requestMove(chessTable.Me, new Position(Xs, (int) Ys - 48), new Position(Xd, (int) Yd - 48), true);

                if (chessTable.needPromotion) {
                    int choice = getPromoChoice();
                    chessTable.procceedPromotion(choice);
                }
            }

        }
    }



    public static int getPromoChoice(){
        int choice;
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.print("1- Queen\n2- Rook\n3- Knight\n4- Bishop\nChoice: ");
            choice = keyboard.nextInt();
        }while(choice != 1 && choice!= 2 && choice != 3 && choice != 4);
        return choice;
    }

    /*Este método imprime o MENU na linha de comando*/
    public static void printMenu(){
        System.out.println(" -------------------------");
        System.out.println("|                         |");
        System.out.println("| (1)Procurar uma Partida |");
        System.out.println("|                         |");
        System.out.println("| (2)Sair                 |");
        System.out.println("|                         |");
        System.out.println(" -------------------------");
        System.out.println();
    }



    /*Este método imprime o tabuleiro na linha de comando num formato "bonitinho"*/
    public static void printBoard(ChessBoard cb){
        for(int j=7; j>-1; j--){
            System.out.println();
            System.out.print(" "+(j+1)+" ");
            for(int i=0; i<8; i++){
                if(cb.getBoard()[i][j].isEmpty()){
                    System.out.print("  X   ");
                }else{
                    System.out.print(" " + cb.getBoard()[i][j].getPiece().getPieceCode()
                            + cb.getBoard()[i][j].getPiece().getPlayerNumber()+ " ");
                }
            }
            System.out.println();

        }
        System.out.print("   ");
        for( int i=0; i<8; i++){
            System.out.print("  "+(char)(65 + i) +"   ");
        }
        System.out.println();
    }
}