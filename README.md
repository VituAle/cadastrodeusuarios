# 🧾 API de Cadastro de Usuários (Quarkus + MySQL + Flyway)

Aplicação **RESTful API** desenvolvida em **Java com Quarkus**, que realiza operações de **CRUD** (Criar, Ler, Atualizar e Deletar) de usuários.  
Utiliza **MySQL** como banco de dados relacional e **Flyway** para controle de migrações.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Quarkus 3.28.3**
- **Hibernate ORM com Panache**
- **Jakarta REST (JAX-RS)**
- **Flyway (versionamento do banco de dados)**
- **MySQL 8.0**
- **Docker & Docker Compose**
- **Maven**

---

## 📁 Estrutura do Projeto

src/
├── main/
│ ├── java/
│ │ └── quarkus/
│ │ ├── controller/ → Controladores REST (endpoints HTTP)
│ │ ├── domain/ → Entidades (modelo de dados)
│ │ └── service/ → Regras de negócio e operações de dados
│ └── resources/
│ ├── application.properties → Configurações do Quarkus
│ └── db/migration/ → Scripts SQL do Flyway
└── test/
└── java/ → Testes unitários e de integração


---

## ⚙️ Configuração

### `src/main/resources/application.properties`
```properties
# Datasource
quarkus.datasource.db-kind=mysql
quarkus.datasource.username=quarkus
quarkus.datasource.password=quarkus
quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/quarkusdb

# Hibernate ORM
quarkus.hibernate-orm.log.sql=true
quarkus.hibernate-orm.packages=quarkus.domain

# Flyway
quarkus.flyway.migrate-at-start=true
quarkus.flyway.locations=db/migration
