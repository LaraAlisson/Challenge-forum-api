# Alisson Lara

![Perfil](https://avatars.githubusercontent.com/u/149639259?v=4&size=64) <!-- Adicione uma imagem sua ou do projeto -->

## Sobre Mim

- 🤖 Apaixonado por tecnologia e automação industrial.
- 🤔 Explorando novas tecnologias e desenvolvendo soluções de software.
- 🎓 Estudando lógica de programação no grupo 8 da Alura/ONE.
- 💼 Trabalhando como projetista de sistemas de automação industrial na Videplast.
- 🌱 "Aprendendo mais sobre C/C++, HTML, CSS e JavaScript.

## Minhas Skills

**Aplicações e Dados**

![C++](https://img.shields.io/badge/C++-00599C?style=flat-square&logo=cplusplus)
![JavaScript](https://img.shields.io/badge/-JavaScript-333333?style=flat&logo=javascript)
![HTML5](https://img.shields.io/badge/-HTML5-333333?style=flat&logo=HTML5)
![CSS](https://img.shields.io/badge/-CSS-333333?style=flat&logo=CSS3&logoColor=1572B6)
![MySQL](https://img.shields.io/badge/-MySQL-333333?style=flat&logo=mysql)
![Java](https://img.shields.io/badge/-Java-333333?style=flat&logo=java&logoColor=white)


**Utilidades**

![Postman](https://img.shields.io/badge/-Postman-333333?style=flat&logo=postman)

**DevOps**

![Git](https://img.shields.io/badge/-Git-333333?style=flat&logo=git)
![GitHub](https://img.shields.io/badge/-GitHub-333333?style=flat&logo=github)

**Ferramentas de Desenvolvimento**

![Visual Studio Code](https://img.shields.io/badge/-Visual_Studio_Code-333333?style=flat&logo=visual-studio-code&logoColor=007ACC)
![Trello](https://img.shields.io/badge/-Trello-333333?style=flat&logo=trello&logoColor=007ACC)
![IntelliJ IDEA](https://img.shields.io/badge/-IntelliJ_IDEA-333333?style=flat&logo=intellij-idea&logoColor=white)


<br/>

Com certeza\! Vamos refazer o README completo, focando na qualidade visual e adicionando uma finalização aprimorada com seus links de redes sociais.

-----

# `Challenge.forum.api`

-----

## 📝 Descrição do Projeto

O `Challenge.forum.api` é uma **API REST** robusta, desenvolvida em **Java 21** e **Spring Boot**, que simula o backend de um fórum de discussão. Esta aplicação oferece funcionalidades essenciais para a **gestão de tópicos**, incluindo operações de **CRUD** (criar, ler, atualizar e deletar), além de um sistema completo de **autenticação** e **controle de permissões** para usuários.

-----

## 🔹 Principais Funcionalidades

### 1\. Cadastro de Tópicos

  * **`POST /topicos`**
  * Cria um novo tópico, registrando automaticamente a data de criação e o usuário logado.
  * Retorna os dados completos do tópico recém-cadastrado.

### 2\. Listagem de Tópicos

  * **`GET /topicos`**
  * Suporta **paginação** e **ordenação** através dos parâmetros `page`, `size` e `sort`.
  * **Exemplo:** `GET /topicos?page=0&size=5&sort=titulo,asc`

### 3\. Busca por ID

  * **`GET /topicos/{id}`**
  * Retorna os detalhes de um tópico específico utilizando seu ID.

### 4\. Atualização de Tópicos

  * **`PUT /topicos/{id}`**
  * Permite a alteração apenas do **título** e da **mensagem** do tópico.
  * **Apenas o autor** do tópico pode realizar a atualização.
  * Fornece mensagens de erro personalizadas para usuários sem permissão ou não autenticados.

### 5\. Exclusão de Tópicos

  * **`DELETE /topicos/{id}`**
  * Exclui um tópico existente.
  * **Somente o proprietário** do tópico tem permissão para excluí-lo.
  * Retorna mensagens personalizadas para erros (como 401, 403, 404).

-----

## ✅ Resumo das Rotas

| Método   | Endpoint         | Descrição                            | Autenticação |
| :------- | :--------------- | :----------------------------------- | :----------- |
| `POST`   | `/topicos`       | Cadastrar novo tópico                | Sim          |
| `GET`    | `/topicos`       | Listar todos os tópicos (paginado)   | Sim          |
| `GET`    | `/topicos/{id}`  | Buscar tópico por ID                 | Sim          |
| `PUT`    | `/topicos/{id}`  | Atualizar tópico (somente o autor)   | Sim          |
| `DELETE` | `/topicos/{id}`  | Deletar tópico (somente o autor)     | Sim          |

-----

## 🚀 Tecnologias Utilizadas

Este projeto foi construído utilizando um conjunto robusto de tecnologias para garantir performance, segurança e escalabilidade:

  * **Java 21**: Linguagem de programação principal.
  * **Spring Boot**: Framework líder para o desenvolvimento ágil de APIs RESTful.
  * **Spring Security**: Módulo essencial para controle de autenticação e autorização, garantindo a segurança da aplicação.
  * **Lombok**: Biblioteca que reduz o código boilerplate com anotações como `@Getter`, `@Setter` e `@AllArgsConstructor`.
  * **JPA / Hibernate**: Para persistência de dados e mapeamento objeto-relacional.
  * **Flyway**: Ferramenta para gerenciar e versionar migrações de banco de dados de forma automatizada.
  * **MySQL**: Banco de dados relacional robusto.
  * **Maven**: Gerenciador de dependências e automação de builds.
  * **Swagger/OpenAPI**: Para documentação interativa da API, facilitando testes e entendimento dos endpoints.
  * **Postman**: Ferramenta utilizada para testar e validar os endpoints da API durante o desenvolvimento.

-----

## 📦 Como Executar o Projeto

Siga estes passos simples para colocar o projeto em funcionamento em sua máquina local:

1.  **Clonar o repositório:**

    ```bash
    git clone https://github.com/seu-usuario/Challenge.forum.api.git
    cd Challenge.forum.api
    ```

2.  **Configurar o banco de dados MySQL:**

      * Crie um banco de dados com o nome `forum_api`.
      * Configure as credenciais de acesso no arquivo `src/main/resources/application.properties`:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/forum_api
        spring.datasource.username=seu_usuario
        spring.datasource.password=sua_senha
        ```

3.  **Executar a aplicação Spring Boot:**

      * As migrações do Flyway serão executadas automaticamente ao iniciar a aplicação.

    <!-- end list -->

    ```bash
    ./mvnw spring-boot:run
    ```

4.  **Testar as rotas com Postman (ou Swagger):**

      * Com a aplicação rodando, você pode usar o Postman (ou acessar a documentação Swagger em `/swagger-ui.html`) para interagir com os endpoints:
          * `POST /topicos`
          * `GET /topicos`
          * `GET /topicos/{id}`
          * `PUT /topicos/{id}`
          * `DELETE /topicos/{id}`

-----

## 📚 Objetivo do Projeto

Este projeto foi desenvolvido com o propósito de aprofundar e praticar os seguintes conceitos e tecnologias fundamentais para o desenvolvimento backend:

  * Implementação de operações **CRUD** com Spring Boot.
  * Configuração e uso de **autenticação e autorização** com Spring Security.
  * Gerenciamento de **migrações de banco de dados** com Flyway.
  * Aplicação de **boas práticas de design** para API REST.
  * Implementação de **paginação e ordenação** utilizando Spring Data JPA.
  * Realização de **testes de integração** com Postman.

-----

## ✨ Conclusão

Este projeto demonstra a construção de uma API REST robusta e segura, abordando desafios comuns do desenvolvimento backend. Sinta-se à vontade para explorar o código, enviar sugestões ou usar como base para seus próprios estudos. Se tiver alguma dúvida, ficarei feliz em ajudar\!

-----

### Conecte-se comigo\!

  * **GitHub**: [https://github.com/LaraAlisson](https://github.com/LaraAlisson)
  * **LinkedIn**: [www.linkedin.com/in/alisson-lara-eng-comp](https://www.google.com/search?q=https://www.linkedin.com/in/alisson-lara-eng-comp)
