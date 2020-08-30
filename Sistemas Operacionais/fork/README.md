# 	:family_man_boy: Fork()

É uma chamada de sistema utilizada para a criação de processos. O objetivo do fork é criar um novo processo similar ao seu, um "filho" (clone). Simplificando seu funcionamento, partimos de um processo pai que será duplicado e gerará um processo filho. E ambos executarão a próxima instrução quando feita a chamada de sistema fork. Para distinguir estes processos, pai e filho, eles recebem um ID de processo.

#### Exercício utilizando as chamadas de sistema:
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

### 	:page_facing_up: License

MIT [LICENSE](https://github.com/keikomori/)

