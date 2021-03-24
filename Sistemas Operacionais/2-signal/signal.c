/*
Universidade Tecnológica Federal do Paraná CAMPUS Pato Branco
	~Disciplina: Sistemas Operacionais
	~Acadêmica: Tatiany Keiko Mori

	Trabalho 2:
	Signal
*/
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdlib.h>
int count_ctrlc = 0;
void ver_SIGTSTP(){
	printf("\nCTRL-C foi pressionado %d vez(es)\n", count_ctrlc);
}
void count_SIGINT(int signum){
    count_ctrlc++;
    if(count_ctrlc>=10){
        char c;
        printf("\nMe matará? Y ou N\n");
        scanf(" %c",&c);
        if(c == 89 || c == 121){
        	raise(SIGKILL); // mata o processo
        }
        if(c == 78 || c == 110){
        	count_ctrlc=0;
        }        
    }   
}
void exit_SIGALRM(){
	printf("Adeus, morri\n");
	raise(SIGKILL); // mata o processo
}
int main(void){
	signal(SIGINT,count_SIGINT);
	signal(SIGTSTP,ver_SIGTSTP);
	signal(SIGALRM, exit_SIGALRM);
	for (;;){}
    return 0;
}