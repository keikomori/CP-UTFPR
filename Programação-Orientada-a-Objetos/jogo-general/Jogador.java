public class Jogador{
    private String nome;
    private JogoGeneral jogoG ;//pra testar mudar para publico 
    private int pontosTotal;

    public Jogador(String nome){
        this.nome = nome;
        this.jogoG= new JogoGeneral();
        this.pontosTotal=0;
    }
    public void jogarDados(){
         jogoG.rolarDados();
    }

    //função que reinicia todas as jogadas do jogador, e zera os pontos 
    public void reiniciarCampeonato(){
        jogoG.reiniciarJogadas();
        pontosTotal();
    }
    //funcao que recebe os pontos da rodada do jogador em i, 
    public void reiniciarCampeonato(String recebeJogada, int i){

        jogoG.reiniciarJogadas(Integer.parseInt(recebeJogada),i);
    }
    //pontos total no inicio
    public void pontosTotal(){
        this.pontosTotal = 0;
    }

    //pontos total, que vai somando a cada rodada
    public void pontosTotal(int escolha){ //sobrecarga do metotodo total
        this.pontosTotal+=jogoG.getJogadas(escolha-1);
    }

    //pontos total, recebido do arquivo
    public void pontosTotal(String dadosJogador ){ //sobrecarga do metotodo total

        this.pontosTotal= Integer.parseInt(dadosJogador);
    }  
    //funcao que  retorna os dados jogados na rodada
    public String mostrarDados(){
      return  jogoG.toString();
    }
    //retorna total
    public int retornaTotal(){
       return pontosTotal;
    }
    //escolhe a jogada, verifica se é valida, e faz os retornos
    public int escolherJogada(int jogada){
        if ((jogada>13 || jogada<1)  )//se é uma jogada invalida, mandar jogar novamente ,falta nao deixar entrar string
            return 0;
        else if(jogoG.verificaJogadaUsada(jogada) == false){//verifica se a jogada foi usada
            if(jogoG.validarJogada(jogada) == true){//verifica se a jogada é valida
                jogoG.pontuarJogada(jogada);//atendeu a tudo pontua normal
                return 2;
            }
            else{
                jogoG.pontuarJodadaErrada(jogada);//pontua 0 na jogada errada
                return 3;
            }
        }
        else// entra aqui se já pontuou na jogada escolhida,mandar jogar novamente
            return 1;  
    }
    //retorna string de jogadas realizadas
    public String mostraJogadasExecutadas(){
        String indice = "1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S+) 11(S-) 12(G)  13(X)\n";
        String imprimejogadas= "";
        //String imprimeValores= "";
        for(int i=0; i < 13; i++){
           // imprimeValores += jogoG.getJogadas(i)+" ";
            if(jogoG.getJogadas(i)>-1 && i<6)
                imprimejogadas += "x ";
            else if(jogoG.getJogadas(i)>-1 && i > 5 && i<9)
                imprimejogadas += "x    ";
            else if(jogoG.getJogadas(i)>-1 && i==12)
                imprimejogadas += "X";
            else if(jogoG.getJogadas(i)>-1 && i>8 && i<12)
                imprimejogadas += "x      ";
            else if(i<6)
                imprimejogadas += "- ";
            else if(i>5 && i<9)
                imprimejogadas += "-    ";
            else if(i<12)
                imprimejogadas += "-      "; 
            else
                imprimejogadas += "-";  
            if(i==5 || i==8)
                imprimejogadas += " "; 
        }
       // imprimeValores += "\n";
        
        return indice + imprimejogadas ;    
    }

    //Funcao string que recebe tudo de um jogador: nome,jogadas,pontuação total,e retorna num indice
    public String imprimeJogador(int elemento){
        String[] guardaDados= new String[16];
        guardaDados[0]=nome;
        for(int x=0; x < 13; x++){
            guardaDados[x+1]=Integer.toString(jogoG.getJogadas(x));
        }
        guardaDados[14]="-----";
        guardaDados[15]=Integer.toString(retornaTotal());
        
        return guardaDados[elemento];
    }

    //retorna pontuaçao da rodada
    public int getPontuacaoRodada(int R){//manda pontuacao da rodada do jogador no indice
        return jogoG.getJogadas(R);
    }
    public String toString(){
        return nome;
    }

}