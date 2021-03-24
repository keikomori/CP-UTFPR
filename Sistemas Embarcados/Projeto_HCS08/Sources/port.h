
#ifndef port_h
#define port_h



/*
	O dispatcher retirar os valores da pilha da terefa e os coloca dentro do processador, ou seja, inicializa os registradores	
	asm("LDHX stk_tmp")	//carrega o HX na variavel stk_tmp
	asm("TXS")	//transfere do registrador X para o S
	asm("PULH")	// tira H da memoria, coloca no registrado e atualiza o SP
	asm("RTI")	//desempilha o resto dos valores
*/

#define dispatcher()\
asm("LDHX stk_tmp");\
asm("TXS");\
asm("PULH");\
asm("RTI")

#define yield() asm("SWI")

#define savepc()\
asm("TSX");\
asm("STHX stk_tmp")

#define restoresp()\
asm("LDHX stk_tmp");\
asm("TXS")

typedef unsigned char cpu_t;

cpu_t * prepareStack(void * task, cpu_t * stk);

extern cpu_t *stk_tmp;

void OS_init_timer(void);


#endif