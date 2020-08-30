## :notebook: Exercício utilizando as chamadas de sistema:
* fork(), wait(), exit(), getpid() e getppid()

#### Gerando a seguinte árvore:
        T
       _|_
      |   |
      A   Y
      |
      I
      |
      N

#### Chamadas de sistema

Em computação, uma chamada de sistema (system call) é o mecanismo programático pelo qual um programa de computador solicita um serviço do núcleo do sistema operacional sobre o qual ele está sendo executado. Isto pode incluir serviços relacionados ao hardware (por exemplo, acessar uma unidade de disco rígido), criação e execução de novos processos e comunicação com serviços do núcleo de maneira integral como escalonamento do processador. Chamadas do sistema fornecem uma interface essencial entre um processo e o sistema operacional.
###### [referência: chamadas de sistema](https://pt.wikipedia.org/wiki/Chamada_de_sistema)

#### Função fork()
A função fork é uma função que duplica o processo atual dentro do sistema operacional. O processo que inicialmente chamou a função fork é chamado de processo pai. O novo processo criado pela função fork é chamado de processo filho. Todas as áreas do processo são duplicadas dentro do sistema operacional (código, dados, pilha, memória dinâmica).

A função fork é chamada uma única vez (no pai) e retorna duas vezes (uma no processo pai e outra no processo filho). O processo filho herda informações do processo pai:
* Usuários (user id) Real, efetivo.
* Grupos (group id) Real, efetivo.
* Variáveis de ambiente.
* Descritores de arquivos.
* Prioridade
* Todos os segmentos de memória compartilhada assinalados.
* Diretório corrente de trabalho.
* Diretório Raiz.
* Máscara de criação de arquivos.
O processo filho possui as seguinte informações diferente do processo pai:
* PID único dentro do sistema.
* Um PPID diferente. (O PPID do processo filho é o PID do processo pai que inicialmente ativou a função fork).
* O conjunto de sinais pendentes para o processo é inicializado como estando vazio.
* Locks de processo, código e dados não são herdados pelo processo filho.
* Os valores da contabilização do processo obtida pela função time são inicializados com zero.
* Todos os sinais de tempo são desligados.

Caso a função fork retorne 0 (zero), está se executando o processo filho. Caso a função retorne um valor diferente de 0 (zero), mas positivo, o processo pai está sendo executado. O valor retornado representa o PID do processo filho criado. A função retorna -1 em caso de erro (provavelmente devido a se ter atingido o limite máximo de processos por usuário configurado no sistema).
###### [referência: função fork()](http://www.br-c.org/doku.php?id=fork)

#### Função wait()
O processo pai pode esperar o término de um processo filho através da chamada da função wait. A função wait devolverá o status de retorno de qualquer processo filho que termine. O processo que chamar a função apresentará um dos seguintes comportamentos:
* Bloquear a sua execução até o término de algum processo filho.
* Retornar imediatamente com o status de término de um processo filho caso o filho tenha já terminado (zumbi) e esteja esperando o processo pai receber o seu status. Quando um filho termina, o sistema operacional enviar um sinal SIGCHLD para o pai.
* Retornar imediatamente com um erro caso não se tenha nenhum processo filho rodando.
A função retornará, além do status de término no parâmetro, o PID do processo filho que terminou. Desta forma é possível controlar os múltiplos filhos criados.
###### [referência: função wait()](http://www.br-c.org/doku.php?id=wait)

#### Função exit()
A função exit deve ser usada quando se quer terminar a execução do programa, retornando para o sistema operacional um indicativo. Tanto em Unix/Linux como em Windows/DOS existem maneiras de se obter o número retornado.

O retorno 0 (zero) indica para o sistema operacional que o programa terminou corretamente, um retorno diferente de 0 (zero) indica um erro.
###### [referência: função exit()](http://www.br-c.org/doku.php?id=exit)

#### Função getppid()
Retorna o ID do processo do pai do processo de chamada. Se o processo de chamada foi criado pela função fork() e o processo pai ainda existir no momento da chamada de função getppid, essa função retorna o ID do processo do processo pai. Caso contrário, esta função retorna um valor de 1 que é o processo id para o processo init.
###### [referência: função getppid()](https://www.geeksforgeeks.org/getppid-getpid-linux/)

#### Função getpid()
Retorna o ID do processo do processo de chamada. Isso é frequentemente usado por rotinas que geram nomes de arquivos temporários exclusivos.
###### [referência: função getpid()](https://www.geeksforgeeks.org/getppid-getpid-linux/)
 
### 	:page_facing_up: License

MIT [LICENSE](https://github.com/keikomori/)

