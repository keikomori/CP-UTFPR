#include <hidef.h> /* for EnableInterrupts macro */
#include "derivative.h" /* include peripheral declarations */

#include "os.h"
#include "tarefas.h"

#ifdef __cplusplus
 extern "C"
#endif

void MCU_init(void); /* Device initialization function declaration */

//declaraçao das stacks das tarefas
cpu_t stk1[128];//pilha da tarefa 1
cpu_t stk2[128];//pilha da tarefa 2
cpu_t stk3[128];//pilha da tarefa 3
cpu_t stk_idle[128];//pilha da tarefa idle


void main(void) {
  MCU_init(); /* call Device Initialization */

  /* include your code here *///---------------------------------------------------------------
  installTask(idle, stk_idle, 128, 0);
  installTask(task1, stk1, 128, 1);
  installTask(task2, stk2, 128, 2);
  installTask(task3, stk3, 128, 3);//mais prioritaria 

  ct = scheduler();//obtem a tarefa de maior prioridade
  stk_tmp = tcb[ct].stk;
  
  OS_init_timer();// incializa o time
  
  dispatcher();// 

  //-------------------------------------------------------------------------------------------
  for(;;)
  {
    /* __RESET_WATCHDOG(); by default, COP is disabled with device init. When enabling, also reset the watchdog. */
  } /* loop forever */
  /* please make sure that you never leave main */
}
