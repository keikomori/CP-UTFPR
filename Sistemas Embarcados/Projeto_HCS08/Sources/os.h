#ifndef os_h
#define os_h

//inclui pois eh necessario conhecer o tipo 'cpu_t'
#include "port.h" 

typedef void (* task_t) (void);
void installTask(task_t task, cpu_t * stk, int stk_size, cpu_t prio);

typedef struct tcb_t_
{
	cpu_t prio;
	cpu_t * stk;
	cpu_t ready;
	long long timeout;//para nao ter que tratar overflow em menos de 20 anos ou mais
	
}tcb_t;

extern volatile tcb_t tcb[10];

extern volatile int ct;

extern volatile int it;

cpu_t scheduler(void);

void delay(long long time);

extern long long Os_time;

cpu_t verificaTarefasProntas(void);//tem que retorna 0 ou 1 dependendo se a tarefa esta pronta ou nao: vai ficar incementado e verificamdo se a tarefa

#endif