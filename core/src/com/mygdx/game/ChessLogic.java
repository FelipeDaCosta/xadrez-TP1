package com.mygdx.game;

import com.mygdx.pieces.*;

/*
* Esta é uma classe auxiliar que analisa os movimentos,
*
* O que JÁ está implementado:
* Era a vez do jogador?
* Ele está movimentando sua própria peça?
* Essa peça pode ir pra onde ele quer? (baseado na lista canGo de cada peça)
*
* O que FALTA implementar:
* Essa jogada deixa o rei vulnerável?
* O jogador estava em cheque?
* Essa jogada é um cheque-mate?
*
* */

public class ChessLogic {

    public ChessLogic(){

    }

    public boolean moveAnalisys(ChessBoard cb, Player p, Piece piece, Position dest){
        PositionList list = new PositionList();
        if(!isTurn(p)){
            System.out.println("Aguarde a jogada do seu oponente");
            return false;
        }

        if(!isMovingHisOwnPiece(p, piece, cb)){
            System.out.println("Você só pode mover suas proprias peças..");
            return false;
        }

        list = piece.canGo(cb);
        //list.printListPositions(piece.getPieceCode()+""+piece.getPlayer().getNumber()+" can go to:");
        //list.printListPieces("", cb);
        if(isOnTheList(list, dest)){
            //System.out.println("Posição foi encontrada dentro da lista canGo!");
            list.clear();
            return true;
        }else {
           //System.out.println("Posição não foi encontrada dentro da lista canGo!");
        }
        list.clear();
        return false;
    }

    private boolean isOnTheList(PositionList list, Position p){
        int size = list.size();
        for(int i=0; i<size; i++){
            if(list.get(i).getX()==p.getX() && list.get(i).getY()==p.getY()){
                return true;
            }
        }
        return false;
    }

    public boolean isTurn(Player p){
        return p.getTurn();
    }

    public boolean isMovingHisOwnPiece(Player p, Piece piece, ChessBoard cb){
        return (piece.getNumPlayer()==p.getNumber());
    }


}
