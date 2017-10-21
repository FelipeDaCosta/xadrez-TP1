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

public class ChessTable extends ChessBoard {

    private int numPlayers=0;
    private int whoseTurn=1;
    private Player player1;
    private Player player2;
    private ChessLogic chessLogic = new ChessLogic();
    

    public Player join(){
        if(numPlayers==0) {
            player1 = new Player(1);
            for(int i=0; i < player1.getPieces().size(); i++){
                super.getSquareByPosition(player1.getPieces().get(i).getPosition()).putPiece(player1.getPieces().get(i));
            }
            player1.setTurn(true);
            numPlayers++;
            return player1;
        }
        if(numPlayers==1){
            player2 = new Player(2);
            for(int i=0; i < player2.getPieces().size(); i++){
                super.getSquareByPosition(player2.getPieces().get(i).getPosition().toInverted()).putPiece(player2.getPieces().get(i));
            }
            player2.setTurn(false);
            player1.setEnemy(player2);
            player2.setEnemy(player1);
            numPlayers++;
            return player2;
        }else{
            System.out.println("Mesa ocupada");
            return null;
        }
    }

    public boolean requestMove(Player p, Position source, Position dest){
        Piece enemyPiece = null;
        if(super.getSquareByPosition(source).isEmpty()){
            System.out.println("Não há peça na casa de origem do movimento");
            return false;
        }

        //manda a jogada para análise da classe chessLogic
        if(!chessLogic.moveAnalisys(this, p, super.getSquareByPosition(source).getPiece(),dest)) {
            System.out.println("Jogada não consentida.");
            return false;
        }
        if(super.getSquareByPosition(dest).hasPiece()){
            enemyPiece = getSquareByPosition(dest).getPiece();
            enemyPiece.kill();
        }
        super.move(source, dest);
        if(chessLogic.isKingInDanger(this,p)) {
            unmove(source, dest);
            if (enemyPiece != null){
                enemyPiece.revive();
                this.getSquareByPosition(dest).putPiece(enemyPiece);
            }
            System.out.println("Movimento negado por ser suicidio do Rei.");
            return false;
        }
        p.enemy.refresh();
        if(chessLogic.isKingInDanger(this, p.enemy)){
            if(chessLogic.isCheckMate(this,  p.enemy)){

            }
        }
        changeTurn();
        return true;
    }

    public void changeTurn(){
        if(whoseTurn==1) whoseTurn = 2;
        else whoseTurn=1;
        player1.setTurn(!player1.getTurn());
        player2.setTurn(!player2.getTurn());
    }

    public int getWhoseTurn(){
        return whoseTurn;
    }
    
}
