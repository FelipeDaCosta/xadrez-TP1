package com.mygdx.game;


/*
* Essa Classe implementa uma mesa de xadrez, na prática, implementa uma partida de xadrez.
* Ela estende de ChessBoard porque a mesa tem todos os atributos e métodos de um tabuleiro de xadrez.
*
* A forma como a partida se dá foi pensada para funcionar em Rede.
* Esta classe deve ser instanciada apenas UMA vez no servidor. Então, os jogadores remotamente chamam
* o método join, que retorna um objeto do tipo Player ou uma mensagem de "mesa ocupada".
*
* Durante a partida, toda a movimentação de peças será feita através do método requestMove
* */


import com.mygdx.web.Web;

public class ChessTable extends ChessBoard {
<<<<<<< HEAD
    public int cMate = 0;
    public boolean myTurn;
    public int whoseTurn = 1;
    public int promotion = 0;
    public int linhaDeComando = 1;
    public  Player Me;
    public Player Enemy;
    private ChessLogic chessLogic = new ChessLogic();
=======
    private int numPlayers=0;
    public int cMate=0;
    public int whoseTurn=1;
    public int promotion=0;
    public int linhaDeComando = 0;
    public Player player1;
    public Player player2;
    public ChessLogic chessLogic = new ChessLogic();
    public int gphchoice = 10;
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095


    public ChessTable(int myNumber, String myName, String enemyName) {
        if (myNumber == 1) {
            myTurn = true;
            Me = new Player(1, false);
            Enemy = new Player(2, true);
            Me.setTurn(true);
            Enemy.setTurn(false);
        } else if (myNumber == 2) {
            myTurn = false;
            Me = new Player(2, false);
            Enemy = new Player(1, true);
            Me.setTurn(false);
            Enemy.setTurn(true);
        }

        Me.setName(myName);
        Enemy.setName(enemyName);

        Me.setEnemy(Enemy);
        Enemy.setEnemy(Me);

        super.placePieces(Me.getPieces());
        super.placePieces(Enemy.getPieces());


    }
<<<<<<< HEAD


=======
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095
    public boolean requestMove(Player p, Position source, Position dest) {

        //manda a jogada para análise da classe chessLogic
        if (!chessLogic.moveAnalisys(this, p, source, dest)) {
            return false;
        }
        this.move(source, dest);
<<<<<<< HEAD
        Web.sendMove(p.getNumber(), source, dest);

        if (chessLogic.pawnPromotion(this, dest)) {
=======
        if(chessLogic.pawnPromotion(this, dest)) {
            promotion = 1;
        }
        if(linhaDeComando == 1 || promotion == 0)
            moveIntricacies(p, source, dest);
        return true;
    }
    public boolean moveIntricacies(Player p, Position source, Position dest){
        if(chessLogic.pawnPromotion(this, dest)) {
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095
            this.getSquareByPosition(dest).getPiece().kill();
            this.getSquareByPosition(dest).setEmpty();
            System.out.println("Promotion");
            int choice;
            if (linhaDeComando == 1) {
                choice = this.promoChoice();
                switch (choice) {
                    case (1):
                        p.queenProms++;
                        break;
                    case (2):
                        p.rookProms++;
                        break;
                    case (3):
                        p.knightProms++;
                        break;
                    case (4):
                        p.bishopProms++;
                        break;
                }
                p.promotedPieces(dest, this, choice, this.getSquareByPosition(dest).getPiece());
<<<<<<< HEAD
            } else {
                promotion = 1;
            }
=======
            }else
                p.promotedPieces(dest, this, gphchoice, this.getSquareByPosition(dest).getPiece());
>>>>>>> 85db6f5db11354d09f7d6c6cb9a1b0d39b045095
        }
        gphchoice = 10;
        p.refresh();
        p.enemy.refresh();

        if (chessLogic.isUnderCheckMate(this, p.enemy)) {
            System.out.println("Check Mate! " + p.getName() + " venceu!");
            Me.setTurn(false);
            Enemy.setTurn(false);
            cMate = 1;
            //Aqui faz alguma coisa pra acabar o jogo.
        }

        changeTurn();
        if (chessLogic.isKingInDanger(this, p.enemy)) {
            p.enemy.setUnderCheck(true);
            System.out.println(p.enemy.getName() + " está em Cheque!");
        } else {
            p.enemy.setUnderCheck(false);
        }
        return true;
    }

    public void changeTurn() {
        myTurn=!myTurn;
        Me.setTurn(!Me.getTurn());
        Enemy.setTurn(!Enemy.getTurn());
        if (whoseTurn == 1) whoseTurn = 2;
        if (whoseTurn == 2) whoseTurn = 1;
    }

    public boolean getMyTurn() {
        return myTurn;
    }

    public int getWhoseTurn() {
        return whoseTurn;
    }

    public boolean verifyEnemyMove(){

        if(myTurn) return false;

        int pl;

        String lastMove = Web.getMove();
        pl = (int) lastMove.charAt(0)-48;
        System.out.println("move: "+ lastMove + " " );
        if(pl==Enemy.getNumber()){
            Position source =  new Position((int)lastMove.charAt(1)-65,(int)lastMove.charAt(2)-49);
            Position dest = new Position((int)lastMove.charAt(3)-65,(int)lastMove.charAt(4)-49);
            source.invert();
            dest.invert();

            move(source, dest);

            // Falta implementar a promocao do inimigo


            Me.refresh();
            Enemy.refresh();

            if (chessLogic.isUnderCheckMate(this, Enemy)) {
                System.out.println("Check Mate! " + Me.getName() + " venceu!");
                Me.setTurn(false);
                Enemy.setTurn(false);
                cMate = 1;
                //Aqui faz alguma coisa pra acabar o jogo.
            }

            changeTurn();

            if (chessLogic.isKingInDanger(this, Enemy)) {
                Enemy.setUnderCheck(true);
                System.out.println(Enemy.getName() + " está em Cheque!");
            } else {
                Enemy.setUnderCheck(false);
            }
            return true;
        }
        return false;
    }

}