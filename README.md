# Instruções de execução do Projeto Spring-Leilao

Este projeto foi desenvolvido para a disciplina de Linguagem de Programação II, ministrada pelo professor Lucas Nadalete na Fatec Prof. Jansen Vidas, em São José dos Campos. 
Trata-se de uma aplicação Spring Boot que utiliza o banco de dados H2 para armazenamento de dados.

O objetivo do projeto é atender aos requisitos de um leilão conforme as diretrizes solicitadas.
Link de acesso as diretrizes:Link para <a href="(https://github.com/Amandavannuccic/SPRING-LEILAO/blob/main/Diretiz%20de%20projeto%20-%20Spring-Leilao%202024.pdf)">Visualização</a>.

Pré-requisitos
Antes de começar, certifique-se de ter os seguintes itens instalados:

JDK 21 ou superior
Link para <a href="[https://spring.io/projects/spring-boot](https://www.oracle.com/br/java/technologies/downloads/)">Download</a>.

Maven 3.9.9 ou superior
Link para <a href="https://maven.apache.org/download.cgi?.">Download</a>.

IDE de sua escolha (IntelliJ, Eclipse, VS Code, etc.)
O que é uma <a href="https://programae.org.br/cursoprogramacao/glossario/o-que-e-ide-em-programacao/">IDE</a>.

Configuração do Ambiente

Para ter acesso ao projeto é necessário realizar um clone do repositório em que o projeto se encontra.

Sugestão de como realizar o clone em seu computador:
 - Acesse a pasta onde gostaria de guardar o projeto.
 - Clique na barra de endereços desta pagina e escreva cmd.
 - No prompt de comando que abrir, escreva <b>git clone https://github.com/Amandavannuccic/SPRING-LEILAO.git</b>
 - Abra o projeto na IDE de sua preferência.
 - Compile o projeto usando o comando mvn clean install.
 - Execute a aplicação usando o comando mvn spring-boot:run

Configuração do Banco de Dados H2
O banco de dados H2 é configurado no arquivo application.properties localizado em src/main/resources. 

Acesso ao Console H2
Com a aplicação em execução o console H2 pode ser acessado através do seguinte URL:
http://localhost:8080/h2-console

Use as seguintes credenciais para login no Banco H2:

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=password

Endpoints da API
A aplicação expõe os seguintes endpoints:

GET /clientes - Retorna todas as entidades Cliente
GET /clientes/{id} - Retorna uma entidade Cliente pelo ID
POST /clientes - Cria uma nova entidade Cliente
PUT /clientes/{id} - Atualiza uma entidade Cliente existente
DELETE /clientes/{id} - Deleta uma entidade Cliente

GET /api/dispositivos-informatica - Retorna todas as entidades DispositivoInformatica
GET /api/dispositivos-informatica/{id} - Retorna uma entidade DispositivoInformatica pelo ID
POST /api/dispositivos-informatica - Cria uma nova entidade DispositivoInformatica
PUT /api/dispositivos-informatica/{id} - Atualiza uma entidade DispositivoInformatica existente
DELETE /api/dispositivos-informatica/{id} - Deleta uma entidade DispositivoInformatica

GET /instituicoesFinanceiras - Retorna todas as entidades InstituicaoFinanceira
GET /instituicoesFinanceiras/{id} - Retorna uma entidade InstituicaoFinanceira pelo ID
POST /instituicoesFinanceiras - Cria uma nova entidade InstituicaoFinanceira
PUT /instituicoesFinanceiras/{id} - Atualiza uma entidade InstituicaoFinanceira existente
DELETE /instituicoesFinanceiras/{id} - Deleta uma entidade InstituicaoFinanceira

GET /lances - Retorna todas as entidades Lance
GET /lances/{id} - Retorna uma entidade Lance pelo ID
POST /lances - Cria uma nova entidade Lance
PUT /lances/{id} - Atualiza uma entidade Lance existente
DELETE /lances/{id} - Deleta uma entidade Lance

GET /leiloes - Retorna todas as entidades Leilao
GET /leiloes/{id} - Retorna uma entidade Leilao pelo ID
GET /leiloes/date - Retorna todas as entidades Leilao ordenadas por data
GET /leiloes/exportar/{id} - Exporta uma entidade Leilao para um arquivo
POST /leiloes - Cria uma nova entidade Leilao
PUT /leiloes/{id} - Atualiza uma entidade Leilao existente
DELETE /leiloes/{id} - Deleta uma entidade Leilao

GET /produtos - Retorna todas as entidades Produto
GET /produtos/{id} - Retorna uma entidade Produto pelo ID
POST /produtos - Cria uma nova entidade Produto
PUT /produtos/{id} - Atualiza uma entidade Produto existente
DELETE /produtos/{id} - Deleta uma entidade Produto

Conclusão
Este documento fornece uma visão geral de como configurar e executar o projeto Spring-Leilao. Seguindo estas instruções, você poderá configurar o ambiente, clonar o repositório, compilar e executar a aplicação, além de acessar e interagir com os diversos endpoints da API. Para mais detalhes, consulte a documentação oficial do Spring Boot e H2. Se tiver alguma dúvida ou precisar de ajuda, sinta-se à vontade para entrar em contato comigo.
