public class JogoGeneral{

    private Dado[] dados = new Dado[5]; //pra testar mudar para publico 
    private int[] jogadas = new int[13];
    private int[] contdados = new int[6];

    public JogoGeneral(){
        for(int i = 0; i< dados.length;i++)
            this.dados[i] = new Dado();
        for(int i = 0; i< jogadas.length;i++)
            this.jogadas[i] = -1;
    }
    public void rolarDados(){
        for(int i = 0; i< dados.length;i++)
            dados[i].rolar();   
    }
    public void reiniciarJogadas(){
        for(int i = 0; i< jogadas.length;i++)
            jogadas[i] = -1;
    }

    public void reiniciarJogadas(int recebeJogada,int i){//sobrecarga, função usada para recuperar as jogadas
        jogadas[i] = recebeJogada; 
    }

    public int getJogadas(int i){
        return jogadas[i];
    }  

    //função que monta o vetor de contdados
    public void contDados(){
        for(int i = 0; i< contdados.length;i++){
              this.contdados[i] = 0;
        }
        for(int i = 0; i< dados.length;i++){
            if(dados[i].getLadoCima()== 1)
                contdados[0]++;
            else if(dados[i].getLadoCima()== 2)
                contdados[1]++;
            else if(dados[i].getLadoCima()== 3)
                contdados[2]++;
            else if(dados[i].getLadoCima()== 4)
                contdados[3]++;
            else if(dados[i].getLadoCima()== 5)
                contdados[4]++;
            else 
                contdados[5]++;  
        }
    }

    //verifica se jogada escolhida E, não foi usada
    public boolean verificaJogadaUsada(int E){
        if(jogadas[E-1] == -1)//verifica se a jogada ja foi usada
            return false;
        else    
            return true;
    }

    //valida todas as jogadas, a partir da funcao que conta os dados
    public boolean validarJogada(int E ){ //E:  escolha de jogada 
            contDados();
            if(E == 1 && contdados[0]!=0)
                return true; //se jogada é igual a 1, e tenho algum dado marcando 1   
            else if(E == 2 && contdados[1]!=0)
                return true;
            else if(E == 3 && contdados[2]!=0)
                return true;
            else if(E == 4 && contdados[3]!=0)
                return true;
            else if(E == 5 && contdados[4]!=0)
                return true;
            else if (E == 6 && contdados[5]!=0)
                return true;
            else{
                if(E == 7){
                    int i=0;
                    while(i < contdados.length && contdados[i] < 3)//se encontrar um contador marcando 3 ja valida
                        i++;
                    if(i == contdados.length)
                        return false;
                    else
                        return true;
                }
                else if(E == 8) {
                    int i=0;
                    while(i < contdados.length && contdados[i]< 4)
                        i++;
                    if(i == contdados.length)
                        return false;
                    else
                        return true;
                }
                else if( E == 9){
                    int cont2=0;
                    int cont3=0;
                    for(int j= 0;j< contdados.length;j++){
                        if(contdados[j] == 2 )
                            cont2++;
                        else if(contdados[j] == 3)
                            cont3++;
                    }
                    if(cont3 == 1 && cont2 == 1)
                        return true;     
                    else
                        return false; 
                }
                else if(E == 10 && contdados[0] == 0 ){
                    int i=1;
                    while(i < contdados.length && contdados[i] == 1)
                         i++;
                    if(i == contdados.length)
                        return true;
                    else
                        return false;
                }
                else if(E == 11 && contdados[5] == 0 ){
                    int i=0;
                    while(i < contdados.length-1 && contdados[i] == 1)
                        i++;
                    if(i == 5)
                        return true;
                    else
                        return false;
                }
                else if (E == 12) {
                    int i=0;
                    while(i < contdados.length && contdados[i] != 5)
                        i++;
                    if(i == contdados.length)
                        return false;
                    else
                        return true;
                }
                else if(E==13) /*jogada 13*/
                    return true;            
                else 
                    return false;
            }  
    }
    //pontua 0, para que não possa repetir a jogada
    public void pontuarJodadaErrada(int E){
        jogadas[E-1]=0;
    } 
    
    //pontua jogada correta
    public void pontuarJogada(int E){ //E: pontuar jogada escolhida  
        if (E==13){
           for(int k=0;k<contdados.length;k++)
               if(contdados[k]!=0)
                  jogadas[E-1]+=contdados[k]*(k+1); //jogada aleatoria soma tudo
        }
        else if(E==1)
            jogadas[E-1]=contdados[0];
        else if(E== 2)
            jogadas[E-1]=contdados[1]*E;
        else if(E== 3)
            jogadas[E-1]=contdados[2]*E;
        else if(E== 4)
            jogadas[E-1]=contdados[3]*E;
        else if(E== 5)
            jogadas[E-1]=contdados[4]*E;
        else if(E== 6)
            jogadas[E-1]=contdados[5]*E;
        else if(E== 7){
            for(int i=0;i<contdados.length;i++)
                if(contdados[i]!=0)
                    jogadas[E-1]+=contdados[i]*(i+1);//trinca soma tudo
        }
        else if(E==8){
            for(int j=0;j<contdados.length;j++)
                 if(contdados[j]!=0)
                    jogadas[E-1]+=contdados[j]*(j+1);//quadra soma tudo 
        }
        else if(E== 9)
            jogadas[E-1]= 25; //fullhouse
        else if(E== 10)
            jogadas[E-1]= 30;//sequecia alta
        else if(E== 11)
            jogadas[E-1]= 40;//sequecia baixa
        else
            jogadas[E-1]= 50; //general
    }
    public String toString() {
        String imprimedados= "";
        for(int i=0; i < 4; i++)
            imprimedados += dados[i].toString()+"-";
        imprimedados += dados[4].toString();
        return imprimedados ;
    }
  //funcao foi usada nos testes para imprimir os valores da matriz que conta os dados
    public String imprimecontdados() {
        String imprime = "";   
        for(int i=0; i < contdados.length; i++)
            imprime += contdados[i]+ " ";
        return imprime;
        
    } 

}
