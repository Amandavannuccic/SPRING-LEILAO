<h1>Instruções de Execução do Projeto Spring-Leilao</h1>

<p>Este projeto foi desenvolvido para a disciplina de Linguagem de Programação II, ministrada pelo professor Lucas Nadalete na Fatec Prof. Janssen Vidal, em São José dos Campos. Trata-se de uma aplicação Spring Boot que utiliza o banco de dados H2 para armazenamento de dados.</p>

<p>O objetivo do projeto é atender aos requisitos de um leilão conforme as diretrizes solicitadas. <a href="https://github.com/Amandavannuccic/SPRING-LEILAO/blob/main/Diretiz%20de%20projeto%20-%20Spring-Leilao%202024.pdf">Link de acesso às diretrizes</a>.</p>

<h2>Pré-requisitos</h2>

<p>Antes de começar, certifique-se de ter os seguintes itens instalados:</p>
<ul>
  <li><strong>JDK 21 ou superior</strong>: <a href="https://www.oracle.com/br/java/technologies/downloads/">Download</a></li>
  <li><strong>Maven 3.9.9 ou superior</strong>: <a href="https://maven.apache.org/download.cgi">Download</a></li>
  <li><strong>IDE de sua escolha</strong> (IntelliJ, Eclipse, VS Code, etc.): <a href="https://programae.org.br/cursoprogramacao/glossario/o-que-e-ide-em-programacao/">O que é uma IDE?</a></li>
</ul>

<h2>Configuração do Ambiente</h2>

<p>Para ter acesso ao projeto, é necessário realizar um clone do repositório onde o projeto se encontra.</p>

<h3>Sugestão de como realizar o clone em seu computador:</h3>
<ol>
  <li><strong>Acesse a pasta</strong> onde gostaria de guardar o projeto.</li>
  <li><strong>Clique na barra de endereços</strong> dessa pasta e escreva <code>cmd</code>.</li>
  <li>No <strong>prompt de comando</strong> que abrir, escreva:
    <pre><code>git clone https://github.com/Amandavannuccic/SPRING-LEILAO.git</code></pre>
  </li>
  <li><strong>Abra o projeto</strong> na IDE de sua preferência.</li>
  <li><strong>Compile o projeto</strong> usando o comando:
    <pre><code>mvn clean install</code></pre>
  </li>
  <li><strong>Execute a aplicação</strong> usando o comando:
    <pre><code>mvn spring-boot:run</code></pre>
  </li>
</ol>

<h2>Configuração do Banco de Dados H2</h2>

<p>O banco de dados H2 é configurado no arquivo <code>application.properties</code> localizado em <code>src/main/resources</code>.</p>

<h3>Acesso ao Console H2</h3>

<p>Com a aplicação em execução, o console H2 pode ser acessado através do seguinte URL:</p>
<p><a href="http://localhost:8080/h2-console">http://localhost:8080/h2-console</a></p>

<p>Use as seguintes credenciais para login no Banco H2:</p>
<ul>
  <li><strong>URL JDBC:</strong> <code>jdbc:h2:mem:testdb</code></li>
  <li><strong>Usuário:</strong> <code>sa</code></li>
  <li><strong>Senha:</strong> <code>password</code></li>
</ul>

<h2>Endpoints da API</h2>

<p>A aplicação expõe os seguintes endpoints:</p>

<h3>Clientes</h3>
<ul>
  <li><strong>GET /clientes</strong> - Retorna todas as entidades <code>Cliente</code></li>
  <li><strong>GET /clientes/{id}</strong> - Retorna uma entidade <code>Cliente</code> pelo ID</li>
  <li><strong>POST /clientes</strong> - Cria uma nova entidade <code>Cliente</code></li>
  <li><strong>PUT /clientes/{id}</strong> - Atualiza uma entidade <code>Cliente</code> existente</li>
  <li><strong>DELETE /clientes/{id}</strong> - Deleta uma entidade <code>Cliente</code></li>
</ul>

<h3>Dispositivos de Informática</h3>
<ul>
  <li><strong>GET /api/dispositivos-informatica</strong> - Retorna todas as entidades <code>DispositivoInformatica</code></li>
  <li><strong>GET /api/dispositivos-informatica/{id}</strong> - Retorna uma entidade <code>DispositivoInformatica</code> pelo ID</li>
  <li><strong>POST /api/dispositivos-informatica</strong> - Cria uma nova entidade <code>DispositivoInformatica</code></li>
  <li><strong>PUT /api/dispositivos-informatica/{id}</strong> - Atualiza uma entidade <code>DispositivoInformatica</code> existente</li>
  <li><strong>DELETE /api/dispositivos-informatica/{id}</strong> - Deleta uma entidade <code>DispositivoInformatica</code></li>
</ul>

<h3>Instituições Financeiras</h3>
<ul>
  <li><strong>GET /instituicoesFinanceiras</strong> - Retorna todas as entidades <code>InstituicaoFinanceira</code></li>
  <li><strong>GET /instituicoesFinanceiras/{id}</strong> - Retorna uma entidade <code>InstituicaoFinanceira</code> pelo ID</li>
  <li><strong>POST /instituicoesFinanceiras</strong> - Cria uma nova entidade <code>InstituicaoFinanceira</code></li>
  <li><strong>PUT /instituicoesFinanceiras/{id}</strong> - Atualiza uma entidade <code>InstituicaoFinanceira</code> existente</li>
  <li><strong>DELETE /instituicoesFinanceiras/{id}</strong> - Deleta uma entidade <code>InstituicaoFinanceira</code></li>
</ul>

<h3>Lances</h3>
<ul>
  <li><strong>GET /lances</strong> - Retorna todas as entidades <code>Lance</code></li>
  <li><strong>GET /lances/{id}</strong> - Retorna uma entidade <code>Lance</code> pelo ID</li>
  <li><strong>POST /lances</strong> - Cria uma nova entidade <code>Lance</code></li>
  <li><strong>PUT /lances/{id}</strong> - Atualiza uma entidade <code>Lance</code> existente</li>
  <li><strong>DELETE /lances/{id}</strong> - Deleta uma entidade <code>Lance</code></li>
</ul>

<h3>Leilões</h3>
<ul>
  <li><strong>GET /leiloes</strong> - Retorna todas as entidades <code>Leilao</code></li>
  <li><strong>GET /leiloes/{id}</strong> - Retorna uma entidade <code>Leilao</code> pelo ID</li>
  <li><strong>GET /leiloes/date</strong> - Retorna todas as entidades <code>Leilao</code> ordenadas por data</li>
  <li><strong>GET /leiloes/exportar/{id}</strong> - Exporta uma entidade <code>Leilao</code> para um arquivo</li>
  <li><strong>POST /leiloes</strong> - Cria uma nova entidade <code>Leilao</code></li>
  <li><strong>PUT /leiloes/{id}</strong> - Atualiza uma entidade <code>Leilao</code> existente</li>
  <li><strong>DELETE /leiloes/{id}</strong> - Deleta uma entidade <code>Leilao</code></li>
</ul>

<h3>Produtos</h3>
<ul>
  <li><strong>GET /produtos</strong> - Retorna todas as entidades <code>Produto</code></li>
  <li><strong>GET /produtos/{id}</strong> - Retorna uma entidade <code>Produto</code> pelo ID</li>
  <li><strong>POST /produtos</strong> - Cria uma nova entidade <code>Produto</code></li>
  <li><strong>PUT /produtos/{id}</strong> - Atualiza uma entidade <code>Produto</code> existente</li>
  <li><strong>DELETE /produtos/{id}</strong> - Deleta uma entidade <code>Produto</code></li>
</ul>

<h2>Conclusão</h2>

<p>Este documento fornece uma visão geral de como configurar e executar o projeto Spring-Leilao. Seguindo estas instruções, você poderá configurar o ambiente, clonar o repositório, compilar e executar a aplicação, além de acessar e interagir com os diversos endpoints dada API. Para mais detalhes, consulte a documentação oficial do Spring Boot e H2. Se tiver alguma dúvida ou precisar de ajuda, sinta-se à vontade para entrar em contato comigo.</p>
