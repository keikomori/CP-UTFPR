# 	:video_game: Jogo General

General é um jogo de dados para dois ou mais jogadores. Para jogar General são necessários cinco dados comuns (hexaédricos) e uma cartela de marcação. O objetivo do jogo é marcar o maior número de pontos, através de algumas combinações de resultados nos dados.

Para este trabalho, as regras do jogo General serão simpliﬁcadas e o campeonato poderá ser realizado desde que exista ao menos um jogador, por exemplo. O jogo consistirá de um certo número de rodadas: em cada uma delas, cada jogador, por sua vez, joga os dados e, conforme o resultado obtido, marca a jogada prevista em sua cartela. Uma vez marcada, aquela jogada não pode ser repetida pelo mesmo jogador até o ﬁnal da partida.

### :straight_ruler: Regras básicas:
1.  Sendo 13 o número de jogadas possíveis e 13 o número de linhas de cada coluna na cartela de marcação (Fig.1), um jogo consiste de 13 rodadas, ou 13 jogadas para cada jogador.
2. Cada jogador, em sua vez, tem apenas uma chance de arremessar os dados.
3. O resultado obtido ao ﬁnal do arremesso deve ser classiﬁcado, pelo próprio jogador, como uma das seguintes 13 possibilidades:

  **Jogada de 1:** um certo nu´mero de dados (de 0 a 5) marcando o número 1; sendo que a jogada vale mais pontos conforme a quantidade de dados que marcarem o número 1. Por exemplo: 1-1-1-4-5 vale 3 pontos. 

  **Jogadas de 2, 3, 4, 5 e 6:** correspondentes à jogada de 1 para os demais números. Por exemplo: 3-3-4-4-5 vale 6 pontos se for considerada uma jogada de 3; ou 8 pontos se for considerada uma jogada de 4; ou ainda 5 pontos se for uma jogada de 5. Trinca (T): três dados marcando o mesmo número. Vale a soma dos 5 dados. Exemplo: 4-4-4-5-6 vale 23 pontos. Quadra (Q): quatro dados marcando o mesmo número. Vale a soma dos 5 dados. Exemplo: 1-5-5-5-5 vale 21 pontos. Full-hand (F) ou Full-house: uma trinca e um par (exemplo: 2-2-2-6-6). Vale 25 pontos para qualquer combinação.
  
  **Sequência alta (S+):** 2-3-4-5-6. Vale 30 pontos. Sequência baixa (S-): 1-2-3-4-5. Vale 40 pontos. General (G): cinco dados marcando o mesmo número (por exemplo: 4-4-4-4-4). Vale 50 pontos. Jogada aleatória (X) : qualquer combinação. Vale a soma dos 5 dados. Por exemplo: 1-4-4-5-6 vale 20 pontos.

|           | Jogador 1 | Jogador 2 | Jogador 3 |
|-----------|-----------|-----------|-----------|
|     1     |           |           |           |
|     2     |           |           |           |
|     3     |           |           |           |
|     4     |           |           |           |
|     5     |           |           |           |
|     6     |           |           |           |
|     T     |           |           |           |
|     Q     |           |           |           |
|     F     |           |           |           |
|     S+    |           |           |           |
|     S-    |           |           |           |
|     G     |           |           |           |
|     X     |           |           |           |
|   Total   |           |           |           |
###### Figura 1

4. O resultado é mostrado na forma de cartela (Fig.1), na coluna do jogador e na linha correspondente à jogada. Aquela linha (e portanto aquela jogada) não poderá mais ser utilizada pelo jogador na mesma partida.

5. Se um determinado resultado não cumprir os requisitos para a jogada escolhida, o jogador zera a respectiva jogada. E ainda, se um determinado resultado não puder ser classiﬁcado como nenhuma das jogadas ainda restantes para aquele jogador, ele deverá escolher qual das jogadas restantes será descartada, marcando 0 (zero) para a jogada correspondente.
(6) Ao ﬁnal de 13 rodadas, com a cartela toda preenchida, somam-se os valores de cada coluna, e o jogador que obtiver mais pontos será considerado o vencedor.

### :scroll: Requisitos do aplicativo

* Menu iterativo que permita ao usuário simular um **Campeonato do Jogo General**
* Deve ser possível incluir até 5 jogadores
* O jogo deve ser executado no terminal do SO.

### :page_with_curl: Detalhamento de itens avaliados atendidos

- [x] Respeitar o princípio do encapsulamento de dados
- [x] Usar modificadores de acesso adequados (private e public)
- [x] Criar getters e setters que forem necessários
- [x] Fazer sobrecarga de pelo menos um método
- [x] Criar associação de classes (Agregação ou Composição)
- [x] O aplicativo não deve travar em tempo de execução
- [x] Seguir o diagrama UML

### :desktop_computer: Desenvolvedores:
* André Lazarini
* Tatiany Keiko Mori



### 	:page_facing_up: License

MIT [LICENSE](https://github.com/keikomori/Jogo-General/blob/master/LICENSE)

