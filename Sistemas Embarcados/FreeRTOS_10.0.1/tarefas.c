#include "tarefas.h"
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

//INCLUDES UART E OUTROS
#include "uart.h"


void exec(void *param)
{
    leds_t *led = (leds_t *)param;
    SysCtlPeripheralEnable(led->clock_port);
    GPIOPadConfigSet(led->port_base, led->pin, GPIO_STRENGTH_8MA_SC, GPIO_PIN_TYPE_STD);
    GPIOPinTypeGPIOOutput(led->port_base, led->pin);

    while(1)
    {
        GPIOPinWrite(led->port_base, led->pin, 0);
        vTaskDelay(led->timeout);
        GPIOPinWrite(led->port_base, led->pin, led->pin);
        vTaskDelay(led->timeout);
    }
}

void execUart(void *param)
{
    uint8_t data;
    vUartInit(param);
    UART_Send(UART0_BASE,(uint8_t*)"\033[2J\033[H",sizeof("\033[2J\033[H"));
    UART_Send(UART0_BASE,(uint8_t*)"FreeRTOS started!\n\r",sizeof("FreeRTOS started!\n\r"));

    while(1)
    {
        UART_Receive(&data,sizeof(data));
        //UART_Send(UART0_BASE,(uint8_t*)"Foi inserida a tecla ",sizeof("Foi inserida a tecla "));
        //if((char)data=='\r')
           //  UART_Send(UART0_BASE,(uint8_t*)"r",sizeof("r"));
        if((char)data=='\n')
            UART_Send(UART0_BASE,(uint8_t*)"n",sizeof("n"));
        if((char)data=='\b')
            UART_Send(UART0_BASE,(uint8_t*)"b",sizeof("b"));
        //UART_Send(UART0_BASE,&data,sizeof(data));
        //UART_Send(UART0_BASE,(uint8_t*)"!\n\r",sizeof("!\n\r"));
    }
}
