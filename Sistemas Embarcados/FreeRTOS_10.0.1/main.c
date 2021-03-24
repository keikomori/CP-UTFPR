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
#include "driverlib/rom.h"
#include "driverlib/rom_map.h"
#include "driverlib/fpu.h"
#include "driverlib/sysctl.h"
#include "driverlib/timer.h"
#include "driverlib/gpio.h"
#include "driverlib/interrupt.h"
#include "driverlib/uart.h"
#include "driverlib/pin_map.h"

//our tasks
#include "tarefas.h"
#include "uart.h"
/**
 * main.c
 */

leds_t LD1,LD2;

int main(void)
{
    // Make sure the main oscillator is enabled because this is required by
    // the PHY.  The system must have a 25MHz crystal attached to the OSC
    // pins. The SYSCTL_MOSC_HIGHFREQ parameter is used when the crystal
    // frequency is 10MHz or higher.
    MAP_SysCtlMOSCConfigSet(SYSCTL_MOSC_HIGHFREQ);

    // Run from the PLL at 120 MHz.
    (void)MAP_SysCtlClockFreqSet((SYSCTL_XTAL_25MHZ |
                SYSCTL_OSC_MAIN |
                SYSCTL_USE_PLL |
                SYSCTL_CFG_VCO_480), 120000000);

    // Enable stacking for interrupt handlers.  This allows floating-point
    // instructions to be used within interrupt handlers, but at the expense of
    // extra stack usage.
    MAP_FPUEnable();
    MAP_FPULazyStackingEnable();

    /*
    LD1.clock_port = SYSCTL_PERIPH_GPION;
    LD1.pin = GPIO_PIN_1;
    LD1.port_base = GPIO_PORTN_BASE;
    LD1.timeout = 400;
    xTaskCreate(exec, "Teste LED 01", 256, (void *)&LD1, 13, NULL);
    */
    LD2.clock_port = SYSCTL_PERIPH_GPION;
    LD2.pin = GPIO_PIN_0;
    LD2.port_base = GPIO_PORTN_BASE;
    LD2.timeout = 200;
    xTaskCreate(exec, "Teste LED 00", 256, (void *)&LD2, 12, NULL);
    //xTaskCreate(execUart, "Teste LED 00", 256, (void *)&LD2, 12, NULL);

    vTaskStartScheduler();

    return 0;
}

