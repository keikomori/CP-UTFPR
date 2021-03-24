#ifndef TAREFAS_H_
#define TAREFAS_H_

typedef struct _leds_t_{
        unsigned long clock_port;
        unsigned long pin;
        unsigned long port_base;
        int           timeout;
}leds_t;

void exec(void *param);
void execUart(void *param);

#endif /* TAREFAS_H_ */
