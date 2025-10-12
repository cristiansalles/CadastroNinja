# 🥷 Projeto Cadastro de Ninjas — Resumo de Estudo

## 🎯 Objetivo do Projeto

O projeto **Cadastro de Ninjas** é uma aplicação feita com **Spring Boot + JPA + H2**, criada com foco educacional para entender os conceitos de:
- Estrutura de um projeto Spring Boot;
- Mapeamento de entidades com **JPA (Java Persistence API)**;
- Uso de **Lombok** para reduzir código repetitivo;
- Relacionamentos **1:N (OneToMany)** e **N:1 (ManyToOne)**;
- Configuração de banco de dados em memória **H2**.

---

## ⚙️ Estrutura do Projeto

```
CadastroNinjas/
 ├── src/main/java/cris/Spring10x/CadastroNinjas/
 │   ├── CadastroNinjasApplication.java        # Classe principal
 │   ├── Ninjas/
 │   │   └── NinjaModel.java                   # Entidade Ninja
 │   └── Missoes/
 │       └── MissoesModel.java                 # Entidade Missões
 ├── src/main/resources/
 │   └── application.properties                # Configuração do banco e app
 └── pom.xml                                   # Dependências Maven
```

---

## 🚀 1. Classe principal — `CadastroNinjasApplication`

```java
@SpringBootApplication
public class CadastroNinjasApplication {
    public static void main(String[] args) {
        SpringApplication.run(CadastroNinjasApplication.class, args);
    }
}
```

### 📘 Explicação
- `@SpringBootApplication` → habilita o **Spring Boot** e ativa o **component scan**, **autoconfiguração** e **injeção de dependências**.
- O método `main` inicializa todo o contexto da aplicação Spring.

🧠 Conceitos estudados aqui:
- Ponto de entrada de uma aplicação Spring Boot.
- Funcionamento automático da inicialização (embutindo Tomcat e configurando o contexto).

---

## 🧩 2. Entidade Ninja — `NinjaModel.java`

```java
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "tb_missoes_id") 
    private MissoesModel missoes;
}
```

### 🧠 Tópicos estudados:

| Conceito | Explicação |
|-----------|------------|
| `@Entity` | Transforma a classe em uma **tabela no banco de dados** |
| `@Table(name = "...")` | Define o **nome da tabela** manualmente |
| `@Id` + `@GeneratedValue` | Define a **chave primária** e o **auto incremento** |
| `@Column(unique = true)` | Impede emails repetidos (restrição no banco) |
| `@ManyToOne` | Define a relação **vários ninjas → uma missão** |
| `@JoinColumn` | Cria a **chave estrangeira** (`tb_missoes_id`) |
| `Lombok (@Getter/@Setter)` | Cria automaticamente getters e setters |
| `@NoArgsConstructor / @AllArgsConstructor` | Construtores gerados automaticamente |

📘 **Resumo conceitual:**
Essa classe representa a **tabela de ninjas** e contém uma **chave estrangeira** para `tb_missoes`.  
Ou seja, cada ninja pertence a uma missão específica.

---

## 🎯 3. Entidade Missões — `MissoesModel.java`

```java
@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeMissao;
    private String hanck;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;
}
```

### 🧠 Tópicos estudados:

| Conceito | Explicação |
|-----------|------------|
| `@Entity` / `@Table` | Cria uma **tabela de missões** no banco |
| `@OneToMany(mappedBy = "missoes")` | Define que **uma missão pode ter vários ninjas** |
| `mappedBy` | Liga o relacionamento ao atributo `missoes` na classe `NinjaModel` |
| `List<NinjaModel>` | Representa a lista de todos os ninjas daquela missão |
| `Lombok` | Evita código repetido, criando getters/setters e construtores |

📘 **Resumo conceitual:**
Essa classe representa a **tabela de missões** e mostra o outro lado do relacionamento:
- Uma missão → vários ninjas.
- Relacionamento bidirecional entre `MissoesModel` e `NinjaModel`.

---

## 🧱 4. Relacionamento entre tabelas

**Tipo de relacionamento:**  
> Uma missão pode ter vários ninjas (1:N).  
> Cada ninja pertence a uma missão (N:1).

📊 No banco H2, o resultado seria:

| tb_missoes | tb_cadastro_de_ninjas |
|-------------|-----------------------|
| id | nomeMissao | hanck | id | nome | email | idade | tb_missoes_id |
| 1 | Missão A | Chuunin | 1 | Naruto | naruto@konoha.com | 17 | 1 |
| 2 | Missão B | Genin | 2 | Sasuke | sasuke@konoha.com | 17 | 2 |

---

## 💾 5. Configuração do banco H2 — `application.properties`

```properties
spring.application.name=CadastroNinjas
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true

spring.datasource.url=jdbc:h2:~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=cadastro_db
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

### 🧠 Tópicos estudados:

| Propriedade | Explicação |
|--------------|------------|
| `spring.h2.console.enabled=true` | Ativa o console visual do H2 (`/h2-console`) |
| `spring.datasource.url` | Caminho do banco em memória |
| `DB_CLOSE_DELAY=-1` | Mantém o banco aberto enquanto a aplicação estiver rodando |
| `spring.jpa.show-sql=true` | Mostra os comandos SQL no console |
| `spring.jpa.hibernate.ddl-auto=update` | Atualiza o esquema do banco automaticamente |
| `H2Dialect` | Define o dialeto SQL usado pelo Hibernate |

💡 **Acesso ao console:**  
http://localhost:8080/h2-console  
- JDBC URL: `jdbc:h2:~/test`  
- Username: `cadastro_db`

---

## 🧠 Revisão Final

| Tema | Conceito Principal | Onde aparece |
|------|--------------------|---------------|
| Entidades JPA | Transformam classes em tabelas | `NinjaModel`, `MissoesModel` |
| Relacionamentos | Conectam tabelas (1:N / N:1) | `@OneToMany`, `@ManyToOne` |
| Lombok | Automatiza getters, setters e construtores | Ambas as classes |
| Banco H2 | Banco em memória para testes | `application.properties` |
| Spring Boot | Estrutura e inicialização do projeto | `CadastroNinjasApplication` |

---
