package com.mygdx.game;

import com.mygdx.pieces.*;

public class ChessLogic {

    public ChessLogic(){

    }

    public boolean moveAnalisys(ChessBoard cb, Player p, Position source, Position dest){
        Piece piece;
        if(!isTurn(p)){
            System.out.println("Aguarde a jogada do seu oponente");
            return false;
        }

        if(!isThereSomePiece(cb,source)){
            System.out.println("Não há peça na casa de origem do movimento");
            return false;
        }

        piece = cb.getSquareByPosition(source).getPiece();

        if(!isMovingHisOwnPiece(p, piece)){
            System.out.println("Você só pode mover suas proprias peças..");
            return false;
        }

        if(!pieceCanGo(cb, piece, dest)){
            System.out.println("Peça não pode ir para o destino selecionado.");
            return false;
        }

        if(!willKingSurviveMove(cb,p,source,dest)) {
            System.out.println("Movimento negado por ser suicidio do Rei.");
            return false;
        }

        return true;
    }


    public boolean isKingInDanger(ChessBoard cb, Player p){
        PieceList enemyPieces = p.enemy.getPieces();
        PositionList allCanGo = new PositionList();

        for(int i=0; i< enemyPieces.size(); i++){
           if(enemyPieces.get(i).isOnTheGame())
                allCanGo.addAll(enemyPieces.get(i).canGo(cb));
        }

        if(isOnTheList(allCanGo,p.getKingPosition()))
            return true;

        return false;
    }

    private boolean pieceCanGo(ChessBoard cb, Piece piece, Position dest){
        PositionList list;
        list = piece.canGo(cb);
        if(isOnTheList(list, dest)){
            list.clear();
            return true;
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

    public boolean isMovingHisOwnPiece(Player p, Piece piece){
        return (piece.getNumPlayer()==p.getNumber());
    }

    public boolean isUnderCheckMate(ChessBoard cb, Player pl){
        PieceList pieces;
        Piece piece;
        PositionList positions;
        Position position;

        if(isKingInDanger(cb, pl)){
            pieces = pl.getPieces();


            for(int i=0; i<pieces.size(); i++){
                piece = pieces.get(i);
                positions = piece.canGo(cb);
                for(int j=0; j<positions.size(); j++){
                    position = positions.get(j);
                    if(willKingSurviveMove(cb, pl, piece.getPosition(), position)){
                        pieces = null;
                        positions = null;
                        return false;
                    }
                }
            }
            pieces = null;
            positions = null;
            return true;
        }

        return false;
    }

    public boolean willKingSurviveMove(ChessBoard cb, Player pl, Position source, Position dest){
        Piece enemyPiece = null;
        boolean resp = true;

        cb.move(source, dest);
        pl.refresh();
        pl.enemy.refresh();

        if(isKingInDanger(cb,pl)){
            resp = false;
        }

        cb.unmove();
        pl.refresh();
        pl.enemy.refresh();

        return resp;
    }


    public boolean isThereSomePiece(ChessBoard cb, Position position){
        return !cb.getSquareByPosition(position).isEmpty();
    }

}
