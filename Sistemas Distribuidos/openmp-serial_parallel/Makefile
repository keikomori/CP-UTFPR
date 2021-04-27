all: parallel serial 

parallel:

	gcc -fopenmp parallel.c -o parallel -lm


serial:

	gcc serial.c -o serial -lm

clean:

	rm -rf parallel serial       

run_parallel: 

	./parallel

run_serial: 

	./serial