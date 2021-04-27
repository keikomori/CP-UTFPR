#include <sys/socket.h>
#include <sys/types.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

#define MAX_MSG 1024
#define PORTA 4321

void send_file(FILE *text, int socket_fd)
{
	char data[MAX_MSG] = {0};
	while(fgets(data, MAX_MSG, text)!=NULL)
    {
        if(send(socket_fd, data, sizeof(data), 0)== -1)
        {
            printf("Erro ao enviar mensagem\n");
            exit(1);
        }
        bzero(data, MAX_MSG);
    }
}

int main(int argc , char *argv[]){
	// variaveis
	char *ipservidor = "127.0.0.1";
	struct sockaddr_in servidor;

	int socket_fd;
	int aux;
	FILE *text;
	char *filename = "file-c.txt";

	socket_fd = socket(AF_INET , SOCK_STREAM , 0);
     
	if (socket_fd == -1){
		printf("Nao foi possivel criar socket\n");
		exit(1);	
	}
	servidor.sin_addr.s_addr = inet_addr(ipservidor);
	servidor.sin_family = AF_INET;
	servidor.sin_port = htons(PORTA);

	//Conectar no servidor
	if (connect(socket_fd , (struct sockaddr *)&servidor , sizeof(servidor)) < 0){
		printf("Nao foi possivel conectar\n");
		exit(1);
	}
	printf("Conectado no servidor!!!\n");

	//Envia arquivo para o servidor

	text = fopen(filename, "r");
    if(text == NULL)
    {
        printf("Erro ao enviar mensagem\n");
        exit(1);
    }
	send_file(text,socket_fd);

    //Encerrar conexão
	close(socket_fd);
	printf("Arquivo enviado com sucesso");

	printf("Cliente finalizado com sucesso!\n");
	exit(0);
}
