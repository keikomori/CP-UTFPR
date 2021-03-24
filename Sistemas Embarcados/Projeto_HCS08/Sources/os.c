#include "os.h"
/*
	Para instalar uma funcao e necessario saber onde esta a funcao, para isso tem-se o ponteiro para onde comeca a mesma.
*/

volatile tcb_t tcb[10];
volatile int ct = 0;//tarefa corrente
volatile int it = 0;//numero de tarefas instalada
volatile long long Os_time = 0;

void installTask(task_t task, cpu_t * stk, int stk_size, cpu_t prio){ // instala tarefa
	stk = (cpu_t *) ((int)stk + stk_size - sizeof(cpu_t));//volta uma unidade de posicao na memoria. Unidade esta que tem o tamanho de 'cpu_t'
	// (void *, unsigned char *)
	stk_tmp = prepareStack(task , stk);//funcao que retorna o ponteiro da Stack ja preparada, ou seja, com os devidos registradores armazenados

	tcb[it].stk = stk_tmp;
	tcb[it].ready = 1;
	tcb[it].timeout = 0;
	tcb[it].prio = prio;
	

	it++;		//contém o numero de tarefas instaladas no sistema

}

cpu_t scheduler(void){ //seleciona a proxima tarefa a ser executada
	cpu_t i;// contador
	cpu_t maior_prio = 0;//inicialmente zero, pois zero é a menor prioridade(prioridade da tarefa idle)
	cpu_t id_maior_prio = 0;//posicao/indice do vetor da tarefa mais prioritaria
	for(i=0; i<it; i++){
		if(tcb[i].ready){// verifica se a a terefa i está pronta para executar
			if(tcb[i].prio>maior_prio){// verifica se a prioridade da tarefa é a de maior prioridade
				id_maior_prio = i;// salva o indice desta tarefa
				maior_prio = tcb[i].prio;//salva a maior prioridade até o momento				
			}
		}
	}
	
	return id_maior_prio;// retorna a posicao (do vetor de tcb) da tarefa de maior prioridade 
}

void delay(long long time){
	tcb[ct].ready = 0;// muda o estado da tarefa atual de pronta para não pronta
	tcb[ct].timeout = time+Os_time;// adiciona quando a tarefa quer o procesador de volta
	yield();//salva o contexto atual e despacha a proxima tarefa pronta. pode ser a tarefa idle caso nao exista
	
}

cpu_t verificaTarefasProntas(void){//varre o tcb comparando o timeout com o Os_time atual. caso o timeout seja menor ou 
	cpu_t i;						// igual ao tempo do sistema atual, a tarefa tem seu estado alterado de nao pronta
	cpu_t tarefa_pronta = 0;		// para pronta.
	for(i=0 ;i<it;i++){
		if(tcb[i].timeout<=Os_time && tcb[i].ready==0){ // a prioridade 0 é a prioridade da tarefa idle
			tcb[i].ready = 1;								
			tarefa_pronta = 1;//flag que retorna 1 para indicar que exite tarefa pronta
		}
	}
	return tarefa_pronta; // retorna a exixtencia ou nao de uma tarefa pronta.
}

