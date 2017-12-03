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


import com.mygdx.pieces.Piece;
import com.mygdx.web.Web;

public class ChessTable extends ChessBoard {
    public boolean EndOfTheGame = false;
    public boolean onLine;
    public Player whoseTurn;
    public Player winner;
    public boolean needPromotion = false;
    public Piece pawnToPromote;
    public Player Me;
    public Player Enemy;
    public int myNumber;
    public ChessLogic chessLogic = new ChessLogic();

    public ChessTable(int myNumber, String myName, String enemyName, boolean onLine) {
        this.onLine = onLine;
        this.myNumber = myNumber;
        if (myNumber == 1) {
            Me = new Player(true, false);
            Enemy = new Player(false, true);
            Me.setTurn(true);
            Enemy.setTurn(false);
            whoseTurn = Me;
        }else if (myNumber == 2) {
            Me = new Player(false, false);
            Enemy = new Player(true, true);
            Me.setTurn(false);
            Enemy.setTurn(true);
            whoseTurn=Enemy;
        }

        Me.setName(myName);
        Enemy.setName(enemyName);

        Me.setEnemy(Enemy);
        Enemy.setEnemy(Me);

        super.placePieces(Me.getPieces());
        super.placePieces(Enemy.getPieces());


    }

    public boolean requestMove(Player p, Position source, Position dest, boolean me) {

        //manda a jogada para análise da classe chessLogic
        if (!chessLogic.moveAnalisys(this, p, source, dest)) {
            return false;
        }
        this.move(source, dest);

        if( me && onLine ) Web.sendMove(myNumber, source, dest);

        if (chessLogic.isPawnPromotion(this.getSquareByPosition(dest).getPiece())) {
            pawnToPromote = this.getSquareByPosition(dest).getPiece();
            needPromotion = true;
            return true;
        }

        afterMoveAdjustements(p);
        return true;
    }

    public void afterMoveAdjustements(Player p) {
        p.refresh();
        p.enemy.refresh();

        if (chessLogic.isUnderCheckMate(this, p.enemy)) {
            System.out.println("Check Mate! " + p.getName() + " venceu!");
            Me.setTurn(false);
            Enemy.setTurn(false);
            winner = p;
            EndOfTheGame = true;
            //Aqui faz alguma coisa pra acabar o jogo.
        }

        changeTurn();

        if (chessLogic.isKingInDanger(this, p.enemy)) {
            p.enemy.setUnderCheck(true);
            System.out.println(p.enemy.getName() + " está em Cheque!");
        } else {
            p.enemy.setUnderCheck(false);
        }

    }

    public void procceedPromotion(int choice) {
        pawnToPromote.promotePawn(choice, this);
        needPromotion = false;
        afterMoveAdjustements(pawnToPromote.getPlayer());
    }


    public void changeTurn() {
        if(whoseTurn==Me)whoseTurn=Enemy;
        else if(whoseTurn==Enemy)whoseTurn=Me;
        Me.setTurn(!Me.getTurn());
        Enemy.setTurn(!Enemy.getTurn());
    }

    public boolean verifyEnemyMove() {

        if (Me.getTurn()) return false;

        int expected = -1;
        if (myNumber==1) expected=2;
        if(myNumber==2) expected=1;

        int pl;
        String lastMove = Web.getMove();
        pl = (int) lastMove.charAt(0) - 48;

        if(pl!= expected) return false;

        System.out.println("move: " + lastMove + " ");

        Position source = new Position((int) lastMove.charAt(1) - 65, (int) lastMove.charAt(2) - 49);
        Position dest = new Position((int) lastMove.charAt(3) - 65, (int) lastMove.charAt(4) - 49);
        source.invert();
        dest.invert();

        requestMove(Enemy, source, dest, false);
        if(this.needPromotion){
            // funcão web que recebe a promoção do adversario
            // chama this.proceedPromotion(choice) com a escolha do usuario
        }

        return true;

    }
}


