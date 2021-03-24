/*
Universidade Tecnológica Federal do Paraná CAMPUS Pato Branco
	~Disciplina: Sistemas Operacionais
	~Acadêmica: Tatiany Keiko Mori

	Trabalho 1:
	Uso das chamadas de sistema:
		fork(), wait(), exit(), getpid() e getppid()
 
 - Gerando a seguinte árvore:
			T
		   _|_
          |   |
	      A   Y
          |
	      I
	      |
	      N
*/

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int main(void){
	int status;
    pid_t pid;
    printf("proc-T, pid %d, ppid %d, acaba de ser criado\n", getpid(), getppid());
    pid = fork();
	if (pid == 0){    
    printf("proc-A, pid %d, ppid %d, acaba de ser criado\n", getpid(), getppid());
    pid=fork();	
		if (pid == 0){
      printf("proc-I, pid %d, ppid %d, acaba de ser criado\n", getpid(), getppid());
			pid=fork();			
			if (pid == 0){
				printf("proc-N, pid %d, ppid %d, acaba de ser criado\n", getpid(), getppid());
				printf("proc-N, pid %d, morreu\n", getpid());
			}
			else{
				wait(pid,&status,0);
				printf("proc-I, pid %d, morreu\n", getpid());
			}
		}
		else {
			wait(pid,&status,0);
			printf("proc-A, pid %d, morreu\n", getpid());
		}
	}
	else{
		wait(pid,&status,0);
		pid=fork();
		if (pid == 0) {
			printf("proc-Y, pid %d, ppid %d, acaba de ser criado\n", getpid(), getppid());
			printf("proc-Y, pid %d, morreu\n", getpid());
		}
		else{
			wait(pid,&status,0);
			printf("proc-T, pid %d, morreu\n", getpid());
		}		
	}
	return 0;
}
