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
    public int cMate=0;
    public int whoseTurn=1;
    public int promotion=0;
    public int linhaDeComando = 1;
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

        //manda a jogada para análise da classe chessLogic
        if(!chessLogic.moveAnalisys(this, p, source, dest)) {
            return false;
        }
        this.move(source, dest);

        if(chessLogic.pawnPromotion(this, dest)) {
            this.getSquareByPosition(dest).getPiece().kill();
            this.getSquareByPosition(dest).setEmpty();
            System.out.println("Promotion");
            int choice;
            if(linhaDeComando == 1) {
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
            } else {
               promotion = 1;
            }
        }

        p.refresh();
        p.enemy.refresh();

        if(chessLogic.isUnderCheckMate(this,  p.enemy)){
            System.out.println("Check Mate! "+p.getName()+" venceu!");
            player1.setTurn(false);
            player2.setTurn(false);
            cMate=1;
            //Aqui faz alguma coisa pra acabar o jogo.
        }

        changeTurn();
        if(chessLogic.isKingInDanger(this, p.enemy)){
            p.enemy.setUnderCheck(true);
            System.out.println(p.enemy.getName()+" está em Cheque!");
        }else{
            p.enemy.setUnderCheck(false);
        }
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
