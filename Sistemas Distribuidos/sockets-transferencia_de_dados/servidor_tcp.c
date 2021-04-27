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

void write_file(int socket_fd)
{
	int aux;
	FILE *mensagem;
	char *filename = "file-s.txt";
	char buffer[MAX_MSG];

	mensagem = fopen(filename, "w");
	if (socket_fd == -1){
		printf("Nao foi possivel criar socket\n");
		exit(1);	
	}
	while(1)
	{
		aux = recv(socket_fd, buffer, MAX_MSG, 0);
		if (aux <= 0)
		{
			break;
			return;
		}
		fprintf(mensagem, "%s", buffer);
		bzero(buffer, MAX_MSG);
	}
}

int main(void){
	char *ipservidor = "127.0.0.1";
	int aux;	
	int socket_fd, new_socket;
	struct sockaddr_in server, client;
	socklen_t addr_size;
	char buffer[MAX_MSG];

	socket_fd = socket(AF_INET , SOCK_STREAM , 0);
	
	if (socket_fd == -1) {
		printf("Nao foi possivel criar o socket\n");
		return -1;
	}
	printf("Conexao socket servidor criada.");
	server.sin_family = AF_INET; // AF_INET = ARPA INTERNET PROTOCOLS
	server.sin_addr.s_addr = INADDR_ANY; // Obtem IP do S.O.
	server.sin_port = htons(PORTA);

	if( bind(socket_fd,(struct sockaddr *)&server , sizeof(server)) < 0){
		puts("Erro ao fazer bind!!! \n");
	}
	puts("Bind efetuado com sucesso!!! \n");

	aux = listen(socket_fd, 10);
    if(aux == 0)
    {
        printf("Ouvindo...\n");
    }
    else 
    {
        printf("Erro ao fazer bind!!! \n");
        exit(1);
    }

	addr_size = sizeof(client);
    new_socket = accept(socket_fd,(struct sockaddr*)&client, &addr_size);

	write_file(new_socket);
	printf("Dados transferidos para o arquivo no servidor.\n");
	printf("Servidor finalizado...\n");
	return 0;
}
