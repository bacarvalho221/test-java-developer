# SpringBoot Shop Cart Web App

# About / Sobre

This is a demo project for skills test in Java with Spring. The idea was to build some basic shopping cart web app.

It was made using **Spring Boot**, **Thymeleaf**, **Spring Data JPA**, **Spring Data REST**. 
Database is in memory **H2**.

Users can shop for products. Each user has his own shopping cart (session functionality).
Checkout is transactional.

Esta é uma demonstração de projeto para teste de habilidade em JAVA com Spring. A ideia é desenvolver um carrinho de compras básico para web app

Utilizando as tecnologias **Spring Boot**, **Thymeleaf**, **Spring Data JPA**, **Spring Data REST**. 
Banco de Dados em memória **H2**.

Usuários podem comprar mais de um produtos(Sessão).
Checkout é uma transação(example).

# NOTE / NOTA

ENDPOINT -> /products
CRUD for Products

## How to run / Como Usar

Using STS IDE  or other IDE
Once the app starts, go to the web browser and visit `http://localhost:8080/home`

Usando STS IDE ou outra IDE
Quando iniciar a aplicação, vá no navegador no endereço `http://localhost:8080/home`

## Helper Tools / Ferramentas

### HAL REST Browser

Go to the web browser and visit `http://localhost:8080/`

Abrir no navegador no endereço `http://localhost:8080/`

PS** Check the app is run

Obs** Checar se aplicação está rodando sem erros

### H2 Database web interface / Banco de dados WEB interface

Go to the web browser and visit `http://localhost:8080/h2-console`

Abrir o navegador no endereço `http://localhost:8080/h2-console`

In field **JDBC URL** put 
```
jdbc:h2:mem:shopping_cart_db
```
In `/src/main/resources/application.properties` file it is possible to change both
web interface url path, as well as the datasource url.

No `/src/main/resources/application.properties` é possível alterar o arquivo, o mesmo da web interface.

#CONTACT/CONTATO

thiagosts.br@gmail.com

Thank you!
