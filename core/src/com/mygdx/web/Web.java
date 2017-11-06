package com.mygdx.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
    public static String findGame() {
        return getMethod("findGame");
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
    public static String getMove()  {
        return getMethod("getMove");
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

