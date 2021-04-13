package analisador;

import java.util.ArrayList;

public class Sintatico {
    private ArrayList<String> tokens = new ArrayList<String>();
    private String entrada = "";
    private String pilha = "";
    private String palavra;

        
    String tabela[][] = { //conferido
        {"BX", "BX", "BX", "BX", "BX"},                                   //A
        {"sBX", "&", "&", "&", "&"},                                      //X
        {"aHbAd", "eAfH", "gtH", "hg", "iH"},                             //B
        {"IZ", "IZ", "IZ"},                                               //H
        {"&", "&", "&", "&", "&", "JIZ", "JIZ", "&", "&"},                //Z
        {"j", "k"},                                                       //J
        {"LW", "LW", "LW"},                                               //I
        {"&", "&", "&", "&", "&", "&", "&", "KLW", "KLW", "&"},           //W
        {"l", "m"},                                                       //K
        {"NR", "NR", "NR"},                                               //L
        {"&", "&", "&", "&", "&", "&", "&", "&", "&", "MNR", "MNR", "&"}, //R
        {"n", "o"},                                                       //M
        {"g", "r", "pHq"}                                                 //N
    };
    
    public Sintatico(String palavra){
        this.palavra = palavra;
    }
        
    public void setEntrada(){
        int i = 0;
        String fpalavra = "";

        while (i < palavra.length()) {
            if (palavra.charAt(i) == ' ') {
                tokens.add(fpalavra);
                fpalavra = "";
            } else {
                fpalavra += palavra.charAt(i);
            }
            i++;
        }
        tokens.add(fpalavra);
    }
    /**
     * Substitui os tokens por letras para simplificar a insersao na tabela
     * sintatica que 
     */    
    public void Substitui(){
        setEntrada(); //recebe a String contendo todos os tokens
        int posicao = 0; //primeira posicao do ArrayList
        while(posicao < tokens.size()){
            if ("<IF>".equals(tokens.get(posicao))) {
                entrada += "a";
            } else if ("<THEN>".equals(tokens.get(posicao))) {
                entrada += "b";
            } else if ("<ELSE>".equals(tokens.get(posicao))) {
                entrada += "c";
            } else if ("<END>".equals(tokens.get(posicao))) {
                entrada += "d";
            } else if ("<REPEAT>".equals(tokens.get(posicao))) {
                entrada += "e";
            } else if ("<UNTIL>".equals(tokens.get(posicao))) {
                entrada += "f";
            } else if ("<ID>".equals(tokens.get(posicao))) {
                entrada += "g";
            } else if ("<READ>".equals(tokens.get(posicao))) {
                entrada += "h";
            } else if ("<WRITE>".equals(tokens.get(posicao))) {
                entrada += "i";
            } else if ("<LESS>".equals(tokens.get(posicao))) {
                entrada += "j";
            } else if ("<EQUAL>".equals(tokens.get(posicao))) {
                entrada += "k";
            } else if ("<PLUS>".equals(tokens.get(posicao))) {
                entrada += "l";
            } else if ("<MINUS>".equals(tokens.get(posicao))) {
                entrada += "m";
            } else if ("<TIMES>".equals(tokens.get(posicao))) {
                entrada += "n";
            } else if ("<DIV>".equals(tokens.get(posicao))) {
                entrada += "o";
            } else if ("<LBRACKET>".equals(tokens.get(posicao))) {
                entrada += "p";
            } else if ("<RBRACKET>".equals(tokens.get(posicao))) {
                entrada += "q";
            } else if ("<NUM>".equals(tokens.get(posicao))) {
                entrada += "r";
            } else if ("<DOTCOMA>".equals(tokens.get(posicao))) {
                entrada += "s";
            } else if ("<ATRIB>".equals(tokens.get(posicao))) {
                entrada += "t";
            } else if ("$".equals(tokens.get(posicao))) {
                entrada += "$";
            }
            posicao++;
        }
    }

    public void Imprime(){
//        if (Erro.getErro().isEmpty()){
//        }
        Substitui();
        
        percorrePilha();
    }
    
    public void percorrePilha() {
        int t = 0;
        char a, b;
        int i=0;
        boolean ativo = true;
        String fa = "";
        pilha += "A"; 
        int tamanhoPilha = pilha.length();
        while (tamanhoPilha != 0) {
            a = pilha.charAt(pilha.length() -1);
            b = entrada.charAt(0);
            if (a == 'A') { 
                if (b == 'a') { // if
                    fa = tabela[0][0];
                    t = fa.length() - 1;
                } else if (b == 'e') { // repeat
                    fa = tabela[0][1];
                    t = fa.length() - 1;
                } else if (b == 'g') { // id
                    fa = tabela[0][2];
                    t = fa.length() - 1;
                } else if (b == 'h') { // read
                    fa = tabela[0][3];
                    t = fa.length() - 1;
                } else if (b == 'i') { // write
                    fa = tabela[0][4];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'X') {
                if (b == 's') { // dotcoma
                    fa = tabela[1][0];
                    t = fa.length() - 1;
                } else if (b == 'f') { // until
                    fa = tabela[1][1];
                    t = fa.length() - 1;
                } else if (b == 'c') { // else
                    fa = tabela[1][2];
                    t = fa.length() - 1;
                } else if (b == 'd') { // end
                    fa = tabela[1][3];
                    t = fa.length() - 1;
                } else if (b == '$') { // $
                    fa = tabela[1][4]; //atrib
                     t = fa.length() - 1;
                } else if (b == 't') {
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'B') {
                if (b == 'g') { // if
                    fa = tabela[2][0];
                    t = fa.length() - 1;
                } else if (b == 'h') { // repeat
                    fa = tabela[2][1];
                    t = fa.length() - 1;
                } else if (b == 'd') { // id
                    fa = tabela[2][2];
                    t = fa.length() - 1;
                } else if (b == 'k') { // read
                    fa = tabela[2][3];
                    t = fa.length() - 1;
                }else if (b == 'k') { // write
                    fa = tabela[2][4];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'H') {
                if (b == 'g') { // id
                    fa = tabela[3][0];
                    t = fa.length() - 1;
                } else if (b == 'r') { // num
                    fa = tabela[3][1];
                    t = fa.length() - 1;
                } else if (b == 'p') { // lbracket
                    fa = tabela[3][2];
                    t = fa.length() - 1;
                } else if (b == 't') { //atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'Z') {
                if (b == 'g') { // dotcoma
                    fa = tabela[4][0];
                    t = fa.length() - 1;
                } else if (b == 'h') { // then
                    fa = tabela[4][1];
                    t = fa.length() - 1;
                } else if (b == 'd') { // until
                    fa = tabela[4][2];
                    t = fa.length() - 1;
                } else if (b == 'k') { // else
                    fa = tabela[4][3];
                    t = fa.length() - 1;
                } else if (b == '$') { // end
                    fa = tabela[4][3];
                    t = fa.length() - 1;
                }else if (b == 'j') { // less
                    fa = tabela[4][4];
                    t = fa.length() - 1;
                }else if (b == 'k') { // equal
                    fa = tabela[4][3];
                    t = fa.length() - 1;
                }else if (b == 'q') { // rbracket
                    fa = tabela[4][3];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'J') {
                if (b == 'j') { //less
                    fa = tabela[5][0];
                    t = fa.length() - 1;
                } else if (b == 'k') { // equal
                    fa = tabela[5][1];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'I') {
                if (b == 'g') { // id
                    fa = tabela[6][0];
                    t = fa.length() - 1;
                } else if (b == 'o') { // div
                    fa = tabela[6][1];
                    t = fa.length() - 1;
                } else if (b == 'p') { //lbracket
                    fa = tabela[6][2];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'W') {
                if (b == 's') { // dotcoma
                    fa = tabela[7][0];
                    t = fa.length() - 1;
                } else if (b == 'b') { // then
                    fa = tabela[7][1];
                    t = fa.length() - 1;
                } else if (b == 'f') { // until
                    fa = tabela[7][2];
                    t = fa.length() - 1;
                } else if (b == 'c') { // else
                    fa = tabela[7][3];
                    t = fa.length() - 1;
                } else if (b == 'd') { // end
                    fa = tabela[7][4];
                    t = fa.length() - 1;
                } else if (b == 'j') { // less
                    fa = tabela[7][5];
                    t = fa.length() - 1;
                } else if (b == 'k') { // equal
                    fa = tabela[7][6];
                    t = fa.length() - 1;
                } else if (b == 'l') { // plus
                    fa = tabela[7][7];
                    t = fa.length() - 1;
                } else if (b == 'm') { // minus
                    fa = tabela[7][8];
                    t = fa.length() - 1;
                } else if (b == '$') { // $
                    fa = tabela[7][9];
                    t = fa.length() - 1;
                } else if (b == 't') { //atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'K') {
                if (b == 'l') { // plus
                    fa = tabela[8][0];
                    t = fa.length() - 1;
                } else if (b == 'm') { // minus
                    fa = tabela[8][1];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'L') {
                if (b == 'g') { // id
                    fa = tabela[9][0];
                    t = fa.length() - 1;
                } else if (b == 'r') { //num
                    fa = tabela[9][1];
                    t = fa.length() - 1;
                } else if (b == 'p') { // lbracket
                    fa = tabela[9][2];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'R') {
                if (b == 's') { // dotcoma
                    fa = tabela[10][0];
                    t = fa.length() - 1;
                } else if (b == 'b') { // then
                    fa = tabela[10][1];
                    t = fa.length() - 1;
                } else if (b == 'f') { // until
                    fa = tabela[10][2];
                    t = fa.length() - 1;
                } else if (b == 'c') { // else
                    fa = tabela[10][3];
                    t = fa.length() - 1;
                } else if (b == 'd') { // end
                    fa = tabela[10][4];
                    t = fa.length() - 1;
                } else if (b == 'j') { // less
                    fa = tabela[10][5];
                    t = fa.length() - 1;
                } else if (b == 'k') { // equal
                    fa = tabela[10][6];
                    t = fa.length() - 1;
                } else if (b == 'l') { // plus
                    fa = tabela[10][7];
                    t = fa.length() - 1;
                } else if (b == 'm') { // minus
                    fa = tabela[10][8];
                    t = fa.length() - 1;
                } else if (b == 'n') { // times
                    fa = tabela[10][9];
                    t = fa.length() - 1;
                } else if (b == 'o') { // div
                    fa = tabela[10][10];
                    t = fa.length() - 1;
                } else if (b == '$') { // $
                    fa = tabela[10][11];
                    t = fa.length() - 1;
                } else if (b == 't') { // atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'M') {
                if (b == 'n') { // times
                    fa = tabela[11][0];
                    t = fa.length() - 1;
                } else if (b == 'o') { // div
                    fa = tabela[11][1];
                    t = fa.length() - 1;
                } else if (b == 't') { //atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == 'N') {
                if (b == 'e') { // id
                    fa = tabela[12][0];
                    t = fa.length() - 1;
                } else if (b == 'g') { // num 
                    fa = tabela[12][1];
                    t = fa.length() - 1;
                } else if (b == 'h') { // lbracket
                    fa = tabela[12][2];
                    t = fa.length() - 1;
                } else if (b == 't') { //atrib
                    fa = "t";
                    t = fa.length() - 1;
                } else {
                    t = -1;
                    tamanhoPilha = 0;
                }
                while (t >= 0) {
                    if (ativo == true) {
                        pilha = pilha.substring(0, pilha.length() - 1);
                        pilha += fa.charAt(t);
                        ativo = !ativo;
                    } else {
                        pilha += fa.charAt(t);
                    }
                    t--;
                }
                ativo = true;
            } else if (a == b) {
                pilha = pilha.substring(0, pilha.length() - 1);
                entrada = entrada.substring(1, entrada.length());
            } else if (a == '&') {
                pilha = pilha.substring(0, pilha.length() - 1);
            } else {
                t = -1;
                tamanhoPilha = 0;
            }
            if (tamanhoPilha != 0) {
                tamanhoPilha = pilha.length();
            }
        }
        if (pilha.length() == 0) {
            if (entrada.charAt(0) == '$') {
                System.out.println("\nAnalise sintatica: ACEITA !\n");
            } else {
                System.out.println("\nAnalise sintatica: REJEITA\n");
                System.out.println("Erro Sintatico.");
            }
        } else {
            System.out.println("\nAnalise sintatica: REJEITA\n");
            System.out.println("Erro Sintatico.");
        }
    }
}
