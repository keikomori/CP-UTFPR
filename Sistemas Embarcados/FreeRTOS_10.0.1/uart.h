#ifndef UART_H_
#define UART_H_


//includes c
#include <stdint.h>
#include <stdio.h>
#include <stdbool.h>

//includes FreeRTOS
#include "FreeRTOS.h"
#include "task.h"
#include "queue.h"
#include "list.h"
#include "semphr.h"


//includes tiva
#include "inc/hw_ints.h"
#include "inc/hw_memmap.h"
#include "inc/hw_types.h"
#include "inc/hw_uart.h"
#include "driverlib/rom.h"
#include "driverlib/rom_map.h"
#include "driverlib/fpu.h"
#include "driverlib/sysctl.h"
#include "driverlib/timer.h"
#include "driverlib/gpio.h"
#include "driverlib/interrupt.h"
#include "driverlib/uart.h"
#include "driverlib/pin_map.h"
#include "tarefas.h"

extern void UART_IRQHandler(void *param);
void vUartInit(void *param);
void UART_Send(uint32_t ui32Base, uint8_t *string, const size_t xBytes);
void UART_Receive(uint8_t *pui8Data, uint32_t ui32Size);

#endif /* UART_H_ */
