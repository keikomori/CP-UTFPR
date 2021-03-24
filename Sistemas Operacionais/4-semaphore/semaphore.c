/*
Universidade Tecnológica Federal do Paraná CAMPUS Pato Branco
	~Disciplina: Sistemas Operacionais
	~Acadêmica: Tatiany Keiko Mori

	Trabalho 4:
	Semaphore
*/
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <stdint.h>
#include <semaphore.h>

#define NUM_THREADS 4
#define TIME        2

sem_t a, b, c, d, e, z;

void* task_a(void* v){
  sem_wait(&a);
  printf("Iniciando A\n");
  sleep(TIME);
  printf("Finalizado A\n");
  sem_post(&c);
}
void* task_b(void* v){
  sem_wait(&b);
  printf("Iniciando B\n");
  sleep(TIME);
  printf("Finalizado B\n");
  sem_post(&c);
}
void* task_c(void* v){
  sem_wait(&c);
  printf("Iniciando C\n");
  sleep(TIME);
  printf("Finalizado C\n");
  sem_post(&d);
  sem_post(&e);
}
void* task_d(void* v){
  sem_wait(&d);
  printf("Iniciando D\n");
  sleep(TIME);
  printf("Finalizado D\n");
  sem_post(&z);
}
void* task_e(void* v){
  sem_wait(&e);
  printf("Iniciando E\n");
  sleep(TIME);
  printf("Finalizado E\n");
  sem_wait(&z);
}
int main(void){
  pthread_t thread[NUM_THREADS];
  sem_init(&a, 0, 1); // inicia livre para começar
  sem_init(&b, 0, 1); // inicia livre para começar
  sem_init(&c, 0, 0);
  sem_init(&d, 0, 0);
  sem_init(&e, 0, 0);
  sem_init(&z, 0, 0);

  pthread_create(&thread[0], NULL, &task_a, NULL);
  pthread_create(&thread[1], NULL, &task_b, NULL);
  pthread_create(&thread[2], NULL, &task_c, NULL);
  pthread_create(&thread[3], NULL, &task_d, NULL);
  pthread_create(&thread[4], NULL, &task_e, NULL);

  sem_wait(&z);
  sem_wait(&z);
  exit(0);
}