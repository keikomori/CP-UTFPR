#include"os.h"
void task1 (void)
{
	int i = 0;

	while(1)
	{
		i++;
		//yield();
		delay(15);//libera o processador por 15 unidade de tempos do sistema
	}
}
void task2 (void)
{
	int i = 0;

	while(1)
	{
		i++;
		//yield();
		delay(5);//libera o processador por 12 unidade de tempos do sistema
	}
}
void task3 (void)
{
	int i = 0;

	while(1)
	{
		i++;
		//yield();
		delay(10);//libera o processador por 9 unidade de tempos do sistema
	}
}

void idle(void){  //oscioso
  for(;;){

  }
}