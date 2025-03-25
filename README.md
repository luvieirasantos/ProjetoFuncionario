# Projeto: Sistema de Gerenciamento de Funcionários

## Integrantes do Grupo
- **Nome:** Diego Furigo do Nascimento **RM: 558755**
- **Nome:** Lu Vieira Santos **RM: 558935**
- **Nome:** Melissa Pereira da Costa **RM: 555656**

---
### Instruções de uso:
No arquivo Persistence.xml, não esquecer de alterar nas linhas 6 e 7 com as credenciais corretas de acesso ao banco, caso contrário isso poderá afetar o funcionamento do programa:
User: rm558935
Password: 310805

## Descrição Geral

Este projeto consiste em um sistema desenvolvido em Java para simular o cadastro e o gerenciamento de funcionários de uma empresa. A aplicação utiliza os princípios da **programação orientada a objetos**, incluindo herança, polimorfismo, abstração e encapsulamento. Os funcionários são classificados de acordo com seus níveis hierárquicos (Júnior, Pleno, Sênior e Gerente), e cada um possui regras específicas de cálculo de bônus salarial.

Além disso, o sistema implementa o padrão DAO (**Data Access Object**) para manipulação dos dados dos funcionários, o que promove uma separação clara entre a lógica de negócios e a lógica de persistência de dados.

---

## Estrutura do Projeto

O projeto está dividido em pacotes de acordo com a responsabilidade de cada classe:

```
org.projetoFuncionario
│
├── entity        → Contém as classes de modelo (entidades funcionais)
├── dao           → Responsável pelo acesso a dados (CRUD)
├── utils         → Utilitários auxiliares, como gerador de SQL
└── Main.java     → Classe principal que executa o sistema
```

---

## Detalhamento das Classes

### `Main.java`

É a classe principal do projeto, responsável por simular a execução do sistema. Ela cria instâncias dos diferentes tipos de funcionários, imprime seus dados, calcula os bônus e realiza operações utilizando o DAO.

```java
Funcionario f1 = new FuncionarioJunior("Ana", 25, 2500);
FuncionarioDAO dao = new FuncionarioDAO();
dao.inserir(f1);
```

> Aqui o programa demonstra como diferentes subclasses de `Funcionario` podem ser instanciadas e utilizadas de forma polimórfica.

---

### `Funcionario.java` (classe abstrata)

Essa é a superclasse de todos os tipos de funcionários. Ela define os atributos e métodos comuns:

- `nome` (String)
- `idade` (int)
- `salario` (double)

E obriga que todas as subclasses implementem:

```java
public abstract double calcularBonus();
```

> Dessa forma, cada tipo de funcionário tem sua própria regra para cálculo de bônus.

---

### Subclasses de `Funcionario`

#### `FuncionarioJunior.java`
Não se aplica bônus.

#### `FuncionarioPleno.java`
Não se aplica bônus.

#### `FuncionarioSenior.java`
Aplica bônus de R$100 a cada 15 horas trabalhadas.

#### `FuncionarioGerente.java`
Aplica bônus de R$500 fixo.

> As subclasses implementam o método `calcularBonus()` de maneira específica, promovendo o uso de **polimorfismo**.

---

### `FuncionarioDAO.java`

Esta classe utiliza o padrão DAO para simular o armazenamento de objetos. Apesar de não conectar-se a um banco real, ela mostra a estrutura típica de um CRUD:

- `inserir(Funcionario f)`
- `listarTodos()`

> Esse padrão isola a lógica de persistência, deixando o código mais organizado e facilitando futuras migrações para banco real.

---

### `SQLGenerator.java`

Classe utilitária que transforma objetos do tipo `Funcionario` em comandos SQL (como se fossem ser salvos em um banco de dados relacional).

```java
public static String gerarInsert(Funcionario funcionario)
```

> Útil para entender como uma aplicação Java pode se preparar para interações com bancos.

---

## Simulações

### Execução da aplicação
> ![image](https://github.com/user-attachments/assets/bb1942b6-b350-417f-9403-60194da7a39a)

*Menu para selecionar as funcionalidades*

> ![image](https://github.com/user-attachments/assets/3ad7d5fe-5ae9-450a-bc37-3b553f790838)

*Escolha o tipo de funcionário*

#### Simulação de inserção
> ![image](https://github.com/user-attachments/assets/82613f9d-399c-41c7-9c3c-0c368e69c9b2)

*Inserindo um funcionario e exibindo a query SQL utilizada*

#### Exibindo os funcionarios
> ![image](https://github.com/user-attachments/assets/e6bd1b53-4001-4fea-9420-cd845fa6f62d)

> ![image](https://github.com/user-attachments/assets/4feddef0-8335-497d-8062-33abe9ab9fd9)

*Primeiro são exibidas as querys utilizadas e depois o resultado das querys*

---

## Pilares da Programação Orientada a Objetos Utilizados

| Pilar            | Exemplo no Projeto                                      |
|------------------|---------------------------------------------------------|
| **Herança**       | Subclasses `FuncionarioJunior`, `FuncionarioPleno` etc. |
| **Polimorfismo**  | Chamada de `calcularBonus()` de forma dinâmica          |
| **Encapsulamento**| Atributos `private` com getters e setters               |
| **Abstração**     | Classe `Funcionario` com métodos abstratos              |

---

## Conclusão

Este projeto apresenta um exemplo completo de aplicação Java orientada a objetos com simulação de banco de dados e cálculo de bônus salariais. Foi possível aplicar conceitos fundamentais de desenvolvimento, desde o design orientado a objetos até a organização de código em pacotes e uso de padrões como DAO.

---

