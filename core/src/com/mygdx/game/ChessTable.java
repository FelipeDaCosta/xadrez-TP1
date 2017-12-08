package com.mygdx.game;


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

    public ChessTable(int myNumber, boolean onLine) {
        this.onLine = onLine;
        this.myNumber = myNumber;
        if (myNumber == 1) {

            Me = new Player(true, false);
            Enemy = new Player(false, true);
            Me.setTurn(true);
            Enemy.setTurn(false);
            whoseTurn = Me;
            Me.setName("Brancas");
            Enemy.setName("Pretas");
        }else if (myNumber == 2) {

            Me = new Player(false, false);
            Enemy = new Player(true, true);
            Me.setTurn(false);
            Enemy.setTurn(true);
            whoseTurn=Enemy;
            Enemy.setName("Brancas");
            Me.setName("Pretas");
        }

        Me.setEnemy(Enemy);
        Enemy.setEnemy(Me);

        placePieces(Me.getPieces());
        placePieces(Enemy.getPieces());

    }

    public boolean requestMove(Player p, Position source, Position dest, boolean me) {

        if (!chessLogic.preMoveAnalisys(this, p, source, dest)) {
            return false;
        }

        this.move(source, dest);
        if( me && onLine ) Web.sendMove(myNumber, source, dest);

        if (chessLogic.isPawnPromotion(this.getSquareByPosition(dest).getPiece())) {
            pawnToPromote = this.getSquareByPosition(dest).getPiece();
            needPromotion = true;
            return true;
        }

        chessLogic.postMoveAnalisys(p, this );
        changeTurn();

        return true;
    }


    public void procceedPromotion(int choice) {
        Web.promote(choice);
        pawnToPromote.promotePawn(choice, this);
        needPromotion = false;
        chessLogic.postMoveAnalisys(pawnToPromote.getPlayer(), this);
        changeTurn();
    }


    public void changeTurn() {
        if(whoseTurn==Me) {
            whoseTurn=Enemy;
            if(onLine) {
                System.out.println("Vez do(a) " + whoseTurn.getName());
            } else {
                System.out.println("Vez das pretas");
            }
        }
        else if(whoseTurn==Enemy){
            whoseTurn=Me;
            if(onLine) {
                System.out.println("Vez do(a) " + whoseTurn.getName());
            } else {
                System.out.println("Vez das brancas");
            }
        }
        Me.setTurn(!Me.getTurn());
        Enemy.setTurn(!Enemy.getTurn());
    }

    public boolean verifyEnemyMove() {
        int pl, expected;

        if (Me.getTurn()) return false;

        if (myNumber == 1) expected = 2;
        else expected = 1;

        String lastMove = Web.getMove();
        pl = (int) lastMove.charAt(0) - 48;

        if (pl != expected) return false;

        Position source = new Position((int) lastMove.charAt(1) - 65, (int) lastMove.charAt(2) - 49);
        Position dest = new Position((int) lastMove.charAt(3) - 65, (int) lastMove.charAt(4) - 49);

        source.invert();
        dest.invert();

        if (requestMove(Enemy, source, dest, false)){

            if (this.needPromotion) {
                while(Web.getPromotion().startsWith("no")){}
                int choice = Character.getNumericValue(Web.getPromotion().charAt(0));
                System.out.println(choice);
                procceedPromotion(choice);
            }
            return true;
        }

        return false;
    }
}


