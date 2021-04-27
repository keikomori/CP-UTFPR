// Tatiany Keiko Mori
//aproximação de pi = sqrt(12) * somatorio { (-1)^i / (2*i+1)*pow(3, i) }
 
#include <stdio.h>
#include "math.h"

#define COUNTER 1000000000
int main(int argc, char *argv[])
{
    long i;
    double pi = 0;
    for (i = 0; i < COUNTER; i++)
    {
        pi += pow(-1, i) / (((2*i)+1)*pow(3,i));
    }
    pi = pi * sqrt(12);
    printf("Pi = %lf\n", pi);
    return 0;
}