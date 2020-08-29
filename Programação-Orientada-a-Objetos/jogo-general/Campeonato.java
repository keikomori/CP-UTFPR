import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Campeonato{
    
    public static void main(String[] args){
        //criando um vetor de jogador que pode conter ate 5 pessoas
        Scanner teclado = new Scanner (System.in);
        Jogador[] jogadores = new Jogador[5];
        int[][] cartela = new  int[13][5];
        int quantJogadores=0;
        boolean iniciouCampeonato = false;
        String opcao;
        do{
            System.out.println("..:: Menu interativo ::..");
            System.out.println("a - Incluir jogador:");
            System.out.println("b - Remover jogador");
            System.out.println("c - Iniciar/reiniciar campeonato");
            System.out.println("d - Mostrar cartela");
            System.out.println("e - Gravar em arquivo");
            System.out.println("f - Ler do arquivo");
            System.out.println("g - Sair");

            System.out.print("Entre com uma opcao: ");
            opcao = teclado.nextLine() ;
            switch(opcao){
                //falta posicionar cada nome inserido
                case "a": 
                    quantJogadores=inserirJogador(jogadores, quantJogadores, teclado); 
                break;
                case "b": //comparar a string nome inserido para retirar 
                    quantJogadores=removejogador(jogadores,quantJogadores,teclado);
            
                    break ;
                case "c": //
                    iniciouCampeonato = rodaCampeonato(jogadores,quantJogadores,teclado,iniciouCampeonato);
                    break;
                case "d": //seguir modelo apresentado com o numero da linha, nome, e pontuacao
                    montaCartela(jogadores,quantJogadores,cartela);
                    clearScreen(); 
                    System.out.println(imprimeCartela(jogadores,cartela,quantJogadores));
                    break;
                case "e": 
                    String conteudo = "";
                    //cria o arquivo
                    File file = new File("campGeneral.txt");
                    try {
                        for(int i=0; i<quantJogadores;i++){
                            for(int j=0;j<16;j++){
                                if(j!=14){
                                    conteudo += jogadores[i].imprimeJogador(j)+" ";
       
                                }
                                   
                             }
                        }
                        // Se o arquivo nao existir, ele gera
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        // Prepara para escrever no arquivo
                        FileWriter fw = new FileWriter(file.getAbsoluteFile());
                        BufferedWriter bw = new BufferedWriter(fw);
                    
                        // Escreve e fecha arquivo
                        bw.write(conteudo);
                        bw.close();

                        // Imprime confirmacao
                        clearScreen(); 
                        System.out.println("\nGravacao efetuada com sucesso\n");
                        

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "f": 
                    System.out.println("\nLeitura do arquivo...");
                    try {                        
                        // Le o arquivo
                        FileReader ler = new FileReader("campGeneral.txt");
                        BufferedReader reader = new BufferedReader(ler);  
                        String linhaInteira= "";
                        String linha= "";
                        
                        clearScreen(); 
                        while( (linhaInteira = reader.readLine()) != null ){
                           linha+=linhaInteira;     
                        }
                        String vetorLinha[] = linha.split(" ");
                        quantJogadores = backupJogadores(jogadores, vetorLinha, quantJogadores);

                        montaCartela(jogadores,quantJogadores,cartela);
                        clearScreen(); 
                        System.out.println("\nLido com sucesso.\n");

                        System.out.println(imprimeCartela(jogadores,cartela,quantJogadores));
                        
                        // Imprime confirmacao
                        
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
            }
                    break;
                case "g":
                    System.out.println("\nSaindo\n");
                    System.exit(0);
                default:
                System.out.println("\nOpcao invalida. Tente novamente\n");
            }
        }while (opcao != null) ;

        teclado.close();
    }

    //função de inserir jogador , já recendo o nome lido
    public static int inserirJogador (Jogador[] jogadores,int quantJogadores,Scanner teclado){
        if(quantJogadores<5) {               
            //le a linha do nome
            boolean inseriu =false;
            do{
                System.out.printf("\nJogador:>");
                String nome  = teclado.nextLine();//armazena o nome do jogador em cada posicao do jogador
                if(!nome.isEmpty()){//verifica se o nome esta em branco
                    jogadores[quantJogadores] = new Jogador(nome);
                    clearScreen(); 
                    System.out.println("\nJogador(a): "+jogadores[quantJogadores]+" incluido(a) com sucesso.\n");
                    quantJogadores++;
                    inseriu =true;
                }
                else if(inseriu == false){
                    System.out.println("\nVocê deve escrever o nome do jogador!");

                }
            }
            while (inseriu == false);  
        }
        else{
            clearScreen();
            System.out.println("\nJá foram incluidos todos jogadores.\n");
        }   
        return(quantJogadores);
    }
    //função roda campeonado, já puxando as validacoes
    public static  boolean rodaCampeonato(Jogador[] jogadores,int quantJogadores,Scanner teclado,boolean iniciouCampeonato){
        if(iniciouCampeonato==true && quantJogadores>1){
            System.out.println("\nCampeonato Reiniciado\n");//só vai mostrar a mensagem se reiniciar o campeonato com os dois mesmos jogadores   
            iniciouCampeonato=false;
            rodaCampeonato(jogadores, quantJogadores, teclado, iniciouCampeonato);
        }
        else if(quantJogadores<2){
            clearScreen();
            System.out.println("\nO jogo só inicia com 2 ou mais jogadores.\n");
            return false;
        }
        else{
            for(int i=0;i<quantJogadores;i++){
                jogadores[i].reiniciarCampeonato();
            }
            for(int rodada = 0;rodada<13;rodada++){
                for(int jogador=0;jogador<quantJogadores;jogador++){
                    System.out.println("Rolando dados para: " + jogadores[jogador]+"...");
                    jogadores[jogador].jogarDados();
                    System.out.println("Valores obtidos: "+ jogadores[jogador].mostrarDados());
                    System.out.println("Para qual jogada deseja marcar: [1 - 13] " + jogadores[jogador] + "?");
                    System.out.println(jogadores[jogador].mostraJogadasExecutadas()); 
                    System.out.printf(">");
                    int escolha = converteStringInt(teclado);
                    int retorno = jogadores[jogador].escolherJogada(escolha);

                    if(retorno == 2 || retorno == 3 ){
                        imprimeMensagem(retorno);
                        jogadores[jogador].pontosTotal(escolha);
                    }
                    else{
                        while(retorno < 2){
                            if(retorno == 0){
                                System.out.println("\njogada invalida,jogar novamente!");
                                System.out.printf("\n>");
    
                                escolha = converteStringInt(teclado);
                                retorno = jogadores[jogador].escolherJogada(escolha); 
                            }
                            else if(retorno == 1){//caso jogada ja pontuada
                                System.out.println("\njogada já pontuada,jogar novamente!");
                                System.out.printf("\n>");
                                escolha = converteStringInt(teclado);
                                retorno = jogadores[jogador].escolherJogada(escolha); 
                            }
                        }
                        imprimeMensagem(retorno);
                    }   
                    System.out.println();            
                }
            }
            clearScreen();
            return true;
        }
        return false;
        
    }
    //funcao que restaura da string recebida do arquivo, os jogadores salvos
    public static int backupJogadores(Jogador[]jogadores,String[] vetorLinha,int quantJogadores){
        if(quantJogadores>0){
            while(quantJogadores>0){
                Remover(jogadores, 0);
                quantJogadores--;
            }
        }
        for(int i=0;i<vetorLinha.length;i++){
            System.out.print(vetorLinha[i]+" ");  
        } 
       
        int quantJogadoresBackup = vetorLinha.length/15;
        System.out.println(quantJogadoresBackup); 
        int i=0;
        int j=0;
        while(i<quantJogadoresBackup){
            jogadores[quantJogadores] = new Jogador(vetorLinha[j]);
            j++;
            System.out.println(jogadores[quantJogadores].toString());
            for(int x = 0; x<13; x++){
                jogadores[quantJogadores].reiniciarCampeonato(vetorLinha[j],x);
                j++;
            }
            jogadores[quantJogadores].pontosTotal(vetorLinha[j]);
            j++;
            quantJogadores++;
            i++;
        }
        return quantJogadores;
    }
    //mensagens de pontuaçao das rodadas
    public static  void imprimeMensagem(int retorno){
        if(retorno == 3){
            System.out.println("seus valores não cumprem o requisito para esta jogada!\n");
        }
        else{
            System.out.println("Pontuou normal");
        }
    }
    //monta cartela
    public static void montaCartela(Jogador[]jogadores,int quantJogadores,int[][]cartela){
        for(int jogador=0;jogador<quantJogadores;jogador++){
            for(int rodada = 0;rodada<13;rodada++){
                cartela[rodada][jogador]=jogadores[jogador].getPontuacaoRodada(rodada);//manda pra cartela a pontuacao do jogador na rodada
            }
        }
       
    }
    //imprime a cartela 
    public static String  imprimeCartela (Jogador[]jogadores,int Cartela [][],int quantJogadores){
        String saidaCartela ="--- Cartela de Resultados ---\n";
        String saidaJogadas[] ={" ","1","2","3","4","5","6","7(T)","8(Q)","9(F)","10(S+)","11(S-)","12(G)","13(X)","------","Total"};
        for (int y = 0; y < 16; y++){
            saidaCartela +=saidaJogadas[y]+"\t"; 
            for(int x=0;x<quantJogadores;x++){
                if(y==0||y>13) 
                    saidaCartela+=jogadores[x].imprimeJogador(y)+"\t";
                    else
                    saidaCartela+=Integer.toString(Cartela[y-1][x])+"\t"; 
            }
            saidaCartela +="\n"; //muda de linha   
        }
        return saidaCartela;
    }
    //sub menu remover jogadores
    public static int removejogador (Jogador[] jogadores,int quantJogadores,Scanner teclado){
        if(quantJogadores==0){
            clearScreen();
            System.out.println("Não há nenhum jogador!\n");
        }
        else if(quantJogadores>1){
            System.out.println("\nQual Jogador de [1 - "+quantJogadores+"] deseja remover? [ -1 para voltar ao menu]\n");
            for(int i=0; i< quantJogadores;i++){
                System.out.print((i+1)+": "+jogadores[i]+"\t\n");
            }
            int escolha;
            boolean excluiu = false;
            do{
                System.out.printf("\n\n>");
                escolha = converteStringInt(teclado);
                if(escolha == -1){
                    clearScreen();
                    System.out.println("\n Nenhum Jogador removido\n");
                }
                else if(escolha == quantJogadores){
                    clearScreen(); 
                    System.out.println("\nJogador(a): "+jogadores[quantJogadores-1]+" Removido(a) com sucesso.\n");
                    Remover(jogadores,quantJogadores-1);
                    excluiu=true;
                    quantJogadores-- ;
                }
                else if(escolha>0 && escolha<quantJogadores){
                    clearScreen(); 
                    System.out.println("\nJogador(a): "+jogadores[escolha-1]+" Removido(a) com sucesso.\n");
                    for(int i=escolha-1;i<quantJogadores-1;i++){
                        jogadores[i]=jogadores[i+1];
                    }
                    Remover(jogadores,quantJogadores-1);
                    excluiu=true;
                    quantJogadores-- ;
                }
                else if(excluiu==false){
                    System.out.println("\nOpcao invalida. Tente novamente");
                }
            }while(escolha!=-1 && (escolha<1 || escolha>quantJogadores) && (excluiu==false));///resolve problemas aquiiii depois
        }
        else{
            String escolha;
            System.out.println("\nDeseja remover jogador(a): "+jogadores[quantJogadores-1]+" [s-n]?");
            System.out.printf("\n>");
            boolean sair= false;
            do{
                escolha=teclado.nextLine();
                switch(escolha){
                     case "s":
                        clearScreen(); 
                        System.out.println("\nJogador(a): "+jogadores[quantJogadores-1]+" Removido(a) com sucesso.\n");
                        Remover(jogadores,quantJogadores-1);
                        quantJogadores-- ;
                        sair = true;
                        break;
                    case "n":
                        clearScreen();
                        System.out.println("\nJogador(a): "+jogadores[quantJogadores-1]+" Não Removido(a).\n");
                        sair=true;
                        break;
                
                    default:
                    System.out.println("\nOpcao invalida. Tente novamente");
                    System.out.printf("\n>");
                }
            }while (sair == false) ; 
        }
        return quantJogadores;
    }
    //limpa a tela
    public static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
    //remove jogador por posicao
    public static void Remover(Jogador[] jogadores,int pos){
       // Jogador guardaJogador = jogadores[pos];
        jogadores[pos] = null;
        //return guardaJogador;
    }
    //verifica se é string
    public static int converteStringInt(final Scanner teclado) {
        for(;;) {
            final String linhaDigitada = teclado.nextLine();
            try {
                final int numeroInteiro = Integer.parseInt(linhaDigitada);
                return numeroInteiro;
            } catch (NumberFormatException e) {
                System.out.println("\nErro! Informe corretamente qual jogador.");
                System.out.printf("\n>");
            }
        }
    }

    
    
}

