/*
Universidade Tecnológica Federal do Paraná CAMPUS Pato Branco
	~Disciplina: Sistemas Operacionais
	~Acadêmica: Tatiany Keiko Mori

	Trabalho 4:
	Grafo de Dependência
*/
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <stdint.h>
#include <semaphore.h>

#define NUM_THREADS 2

sem_t a, b, c, d, e, f, g, h;
double x=1, y=1, z=2;
double u=0, hl=0, j=0;

void proc_e()
{
  sem_wait(&e);
  y=y+2.0;
  sem_post(&d);
  sem_post(&h);
}
void proc_f()
{
  sem_wait(&f);
  u=hl+(j/3.0);
  sem_post(&a);
}
void proc_c()
{
  sem_wait(&c);
  x=x+1.0;
  sem_post(&d);
}
void proc_d()
{
  sem_wait(&d);
  hl=y+x;
  sem_post(&f);
}
void proc_h()
{
  sem_wait(&h);
  j=z+y-4.0;
  sem_post(&f);
}
void proc_g()
{
  sem_wait(&g);
  z=z/2.0;
  sem_post(&h);
}
void proc_b()
{
  sem_wait(&b);
  x=x*2.0;
  sem_post(&c);
}
void* p1(void* v)
{
  //P1:begin A; E; F; end
  proc_e();
  proc_f();
}
void* p2(void* v)
{
  //P2: begin B; C; D; end;
  proc_b();
  proc_c();
  proc_d();
}
void* p3(void* v)
{
  //P3: begin G; H; end;
  proc_g();
  proc_h();
}
int main(void)
{
  pthread_t thread[NUM_THREADS];
  sem_init(&a, 0, 0); 
  sem_init(&b, 0, 1); //begin
  sem_init(&c, 0, 0);
  sem_init(&d, 0, 0);
  sem_init(&e, 0, 1); //begin
  sem_init(&f, 0, 0);
  sem_init(&g, 0, 1); //begin
  sem_init(&h, 0, 0);

  pthread_create(&thread[0], NULL, &p1, NULL);
  pthread_create(&thread[1], NULL, &p2, NULL);
  pthread_create(&thread[2], NULL, &p3, NULL);

  sem_wait(&a);
  printf("Valor de U = %.2f\n", u);

  
}