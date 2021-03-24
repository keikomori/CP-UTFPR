/*
Universidade Tecnológica Federal do Paraná CAMPUS Pato Branco
	~Disciplina: Sistemas Operacionais
	~Acadêmica: Tatiany Keiko Mori

	Trabalho 3:
	Sequencia de pi = sqrt(12)* somatorio{(-1)^i / (2*i+1)*pow(3, i)}
	
 1  thread = 3.14159265258979539269836023240856093252659775316715
 2  thread = 3.14159265258979414760058535005526891836780123412609
 4  thread = 3.14159265258979510907107191020060099617694504559040
 8  thread = 3.14159265258979446332025797783416010133805684745312
 16 thread = 3.14159265258979388825942569152260830378509126603603
*/
#include <signal.h>
#include <pthread.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <math.h>
#define NUM_THREAD 4
#define BILHAO 1000000000
double long parc[8 * NUM_THREAD];
void *calculo(void *i) {
	long int tid = (long)i;
	long int termos = BILHAO/NUM_THREAD;
	long int inicio = tid*termos;
	long int fim = (tid*termos) + termos;
  
	for (int i=inicio; i<fim; i++){
		parc[8*tid] += 4*(pow(i+1, 2)) / 4*(pow(i+1, 2))-1;
	}
}
int main(void){
	pthread_t thead[NUM_THREAD];
	double long result = 0;
	for (int i=0; i<NUM_THREAD; i++){
		parc[8 * i] = 0;
	}
	for (int i=0; i<NUM_THREAD; i++){
		pthread_create(&thead[i], NULL, calculo, (void *)(intptr_t)i);
	}
	for (int i=0; i<NUM_THREAD; i++){
		pthread_join(thead[i], NULL);
		printf("Final: %.50Lf\n", parc[8*i]);
		result += parc[8 * i];
	}
	printf("Final: %.50Lf\n", (result*4));
	pthread_exit(0);
}