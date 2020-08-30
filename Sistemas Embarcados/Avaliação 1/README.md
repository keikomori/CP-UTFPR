# 	:bookmark_tabs: Sistemas Embarcados - Resumo da Avaliação 1

#### Comparativo entre a memória eeprom e memória flash:

Usamos a memória eeprom ao invés da flash pois a memória flash apaga somente em blocos, enquanto que a eeprom permite apagar byte a byte. É possível simular uma memória eeprom usando uma memória flash usando uma máquina de estados no processador, reservando um espaço da memória flash para tal.

#### Mutex e Semáforo

Uma das grandes diferenças do Mutex para um semáforo binário é que, quando um Mutex é adquirido por uma tarefa, somente esta tarefa pode liberá-lo (propriedade de posse). Já um semáforo pode ser liberado por outra tarefa.
Como resolver o problema de tarefas não re-entrantes (thread safe) em sistemas: 
* preemptivos: é necessário utilizar o Mutex
* cooperativos: definir bem os níveis de prioridade das tarefas e o tempo de execução de cada uma para garantir que não será interrompida por uma interrupção

#### Principais componentes de um sistema ARM:

* Unidade de decodificação de instruções e controle lógico: decodifica as instruções ARM e Thumb e organiza a sequência de exceções e outros eventos irregulares 
* Registrador de endereço de memória: associado ao incrementador de endereço, mantém o controle da posição de PC • Registradores de memória de dados: controlam o fluxo de entrada e saída 
* ULA (Unidade Lógica Aritmética): Realiza as operações lógicas e aritméticas requisitadas

#### Instruções/Carregamento da Memória:

Há duas instruções principais para acesso à memória: 
* LDR (register load): carrega em um registrador o conteúdo de uma posição de memória
* STR (register store): coloca o conteúdo de um registrador em uma determinada posição de memória

#### Tarefas

Uma tarefa tem como atribuição executar uma ação por meio de uma sequência de instruções, podendo realizar funções do sistema (gerenciamento de driver de periféricos, por exemplo) ou funções definidas pelo usuário/desenvolvedor. É uma entidade que o sistema operacional pode executar concorrentemente, recebendo para si uma pilha individual, sendo usada para armazenar informações de retorno das funções e interrupções executadas, e o contexto da tarefa quando interrompida. O contexto da tarefa são os dados contidos nos registradores de propósito geral  bem como de seus registradores especiais, como o contador de programa e o registrador de estado do processador. 

#### Diferenças das arquiteturas RISC e CISC

RISC: Menor número de instruções; previsibilidade que trás desempenho para o Pipeline. Pode-se obter maior desempenho se cada instrução ocupar um espaço na memória, o que reduz a complexidade e o número de instruções na CPU, e todos operandos de instruções aritméticas e lógicas devem estar nos registradores do processador. Com uma variação mínima entre as instruções existe uma facilidade para a unidade de controle prever a quantidade de ciclos necessários para execução. E essa previsibilidade tem benefícios diretos em relação ao ganho de desempenho com o Pipeline. Como se tem a informação da quantidade de ciclos necessários para a execução da instrução e unidade de controle tem a insformação de quando será possível iniciar o estágio da proxima instrução, a instrução específica, a operação a ser executada e os operandos envolvidos.

CISC: Sem um número fixo de instruções é mais difícil de a utilização de instruções indexadas. Se utilizam de mais memória principal e cache enquanto os processadores RISC utilizam um maior número de registradores. Isso se dá por que CISC trabalha com mais instruções e dados no mesmo instante de tempo. E devido a elevada quantidade de dados estes dados não poderiam ser armazenados em registradores, assim ficam armazenados na memória cache. Enquanto RISC por trabalhar com menor número de instruções e dados por vez temos a utilização predominante de registradores.

#### Estratégias no RISC para diminuir a densidade de código:

Todas as arquiteturas modernas de 32 bits tem alguma forma de otimização de densidade de código. O ARM implementou o THUM-2, tendo subgrupos de instruções de 16 bits, outros processadores utilizaram-se de técnicas avançadas de endereçamento, de mesclagem de arquiteturas RISC e CISC,  de múltiplos modos de endereçamento, e da otimização de operações de acesso e armazenamento (load e store).

#### O que é Big-End e Little-End:

Na forma  “Little Endian”, as instruções da linguagem assembly para selecionar um número de bytes de 1, 2, 4 ou mais procedem exatamente da mesma maneira para todos os formatos: primeiro escolha o byte de ordem mais baixa no deslocamento 0. Além disso, devido ao 1: 1 entre o deslocamento do endereço e o número do byte (o deslocamento 0 é o byte 0), várias rotinas matemáticas de precisão são correspondentemente fáceis de escrever.

No formato "Big Endian", com o byte de alta ordem em primeiro lugar, você sempre pode testar se o número é positivo ou negativo observando o byte no deslocamento zero. Você não precisa saber quanto tempo o número é, nem precisa pular nenhum bytes para encontrar o byte que contém as informações do sinal. Os números também são armazenados na ordem em que são impressos; portanto, as rotinas binárias e decimais são particularmente eficientes.

###### Ainda faltam materiais a serem colocados
















