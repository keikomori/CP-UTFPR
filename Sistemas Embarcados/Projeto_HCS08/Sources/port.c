
#include"os.h"
#include "derivative.h" /* include peripheral declarations */

cpu_t * stk_tmp;

cpu_t * prepareStack(void * task, cpu_t * stk)// (void *, unsigned char *)
{	
	*stk -- = (cpu_t) (task);//salvando o PC parte baixa primeiramente, e decrementa depois uma posicao... (PCL)
	*stk -- = (cpu_t) ((int)task >> 8);//salvando o PC parte alta, e decrementa novamente a posicao.. (PCH)
	*stk -- = 0;//armazenando o registrador HX e inicializando com 0 (index X)
	*stk -- = 0;//acumulador (ACC)
	*stk -- = 0;//registrador de condicoes (CCR)
	*stk = 0;//registrador H
	return stk;
}


interrupt void SWI (void)// interrupcao de software: responsavel por efetivar a desistencia do processador por uma tarefa
{						 // o contexto da tarefa corrente eh salvo e a proxima tarefa eh carregada
	savepc();
	tcb[ct].stk = stk_tmp;
	
	ct = scheduler(); // obtem o id da próxima tarefa 

	stk_tmp = tcb[ct].stk;

	restoresp();
}

void OS_init_timer(void) // inicializa e configura o time
{	
	TPM1SC = 0;
	TPM1MOD = 19999;//quantidade de contagem que da 1 ms
	TPM1SC = 0x48;// inicializa o timer
}

interrupt void TIMER_INT (void)// interrupção de timer: eh ativada quando ocorre um estouro do contador do timer 
{
	Os_time++; // soma o tempo do sistema
	TPM1SC_TOF = 0; //Limpa a flag de condicao de estouro do temporizador	
	
	if(verificaTarefasProntas()){// se tem tarefa pronta com maior prioridade -> troca o contexto
		savepc();
		tcb[ct].stk = stk_tmp;
		
		ct = scheduler();//obtem a tarefa pronta com maior prioridade

		stk_tmp = tcb[ct].stk;

		restoresp();	
	}
	
}

