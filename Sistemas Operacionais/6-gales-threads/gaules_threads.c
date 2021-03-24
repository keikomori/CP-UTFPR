/*
Universidade Tecnológica Federal do Paraná CAMPUS Pato Branco
	~Disciplina: Sistemas Operacionais
	~Acadêmica: Tatiany Keiko Mori

	Trabalho 6:
	Jantar de Gauleses - Threads
*/
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <stdint.h>
#include <semaphore.h>

#define NUM_GAULESES 7
#define NUM_JAVALIS 11

sem_t mutex, servido, prox;

char nome[8] = {'T', 'A', 't', 'i', 'a', 'n', 'y'};
int i, javali; 
int javalis = NUM_JAVALIS;

void ComeJavali(void* gaules, int javali)
{
  sem_wait(&mutex);
  printf("%c (%d): comendo o javali:%d\n", (char)gaules, (int)gaules, javali);
  sem_post(&mutex);
}
int ColocaJavalis()
{
  sem_wait(&servido);
  javalis = NUM_JAVALIS;
  sem_post(&prox);
  return javalis;
}
int RetiraJavali(void* gaules)
{
  sem_wait(&mutex);
  if(javalis == 0 )
  {
    sem_post(&servido);
    printf("%c (%d): acordou o cozinheiro\n", (char)gaules, (int)gaules);
    sem_wait(&prox);
  }
  javalis --;
  sem_post(&mutex);
  return (javalis + 1);
}
void Gaules(void* gaules)
{
  while(1)
  {
    javali = RetiraJavali(gaules);
    ComeJavali(gaules, javali);
    sleep(1);
  }
}
void Cozinheiro()
{
  while(1)
  {  
    ColocaJavalis();
  }
}
int main(void)
{
  pthread_t gauleses[NUM_GAULESES];
  pthread_t cozinheiro;
  sem_init(&mutex, 0, 1);
  sem_init(&servido, 0, 0);
  sem_init(&prox, 0, 0);
  
  pthread_create(&cozinheiro, NULL, (void *)Cozinheiro, NULL);
  
  for(i=0; i<NUM_GAULESES; i++)
  {
    pthread_create(&gauleses[i], NULL, (void *)Gaules, nome[i]);
  }
  sleep(11);
  exit(0);
}