package com.mygdx.web;

import com.mygdx.game.Position;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by felipecosta on 11/6/17. ver 1.0
 *
 * Nessa versao apenas 1 jogo pode acontecer por vez
 *
 * O primeiro PC chama findGame e dps fica chamando gotGame
 * quando o segundo PC chamar findGame, gotGame passa a retornar yes e os dois entram no jogo
 */
public class Web {
    private final static String BASE_URL = "https://xadrez-web.herokuapp.com/api/";

    /**
     * Faz um GET request para o servidor de algum metodo.
     *
     * @param method Metodo que vai ser chamado
     * @return Retorno da chamada HTTP
     */
    private static String getMethod(String method) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(BASE_URL + method);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            return result.toString();
        } catch(Exception e) {
            return "Error method: " + method;
        }
    }

    /**
     * Chama o metodo findGame que acha um novo jogo
     *
     * @return String ok para achar um jogo e full caso nao haja vagas
     */
    public static String findGame(String name) {
        return getMethod("findGame/" + name);
    }

    /**
     * Chama o metodo gotGame que diz se ja achou um jogo ou nao
     *
     * @return String no ou yes
     */
    public static String gotGame()  {
        return getMethod("gotGame");
    }

    /**
     * Chama o metodo move que recebe um movimento e passa para o servidor
     *
     * @return ok/<move>
     */
    public static String move(String move)  {
        return getMethod("move/"+move);
    }

    /**
     * Chama o metodo getMove que retorna o ultimo movimento
     *
     * @return <lastMove>
     */

    public static void sendMove(int pl, Position source, Position dest){
        String move = ""+pl + source.getCharX()+source.getCharY()+dest.getCharX()+dest.getCharY();
        Web.move(move);

    }

    public static String getMove()  {
        return getMethod("getMove");
    }

    /**
     *
     * @param pieceCode Codigo da peca que o peao vai virar.
     *                  1 - Rainha, 2 - Bispo, 3 - Cavalo, 4 - Torre
     * @return "no game" em caso de falha e "ok/pieceCoce" em sucesso
     */
    public static String promote(int pieceCode) {
        if(pieceCode >= 1 && pieceCode <= 4)
            return getMethod("promote/"+pieceCode);
        else
            return "no";
    }

    /**
     * Retorna a peca promovida
     *
     * @return Peca promovida e "no game" em caso de falha
     */
    public static String getPromotion() {
        return getMethod("getPromotion/");
    }


    /**
     * Chama o metodo finishGame que termina o jogo atual
     *
     * @return ok
     */
    public static String finishGame()  {
        return getMethod("finishGame");
    }

    public static void main(String[] args) {
        System.out.println(getMove());
    }

}

