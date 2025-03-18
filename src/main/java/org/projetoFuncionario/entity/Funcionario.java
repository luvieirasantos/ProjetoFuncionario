package org.projetoFuncionario.entity;

import javax.persistence.*;

@Entity // Define que esta classe será mapeada para uma tabela no banco de dados
@Table(name = "TAB_FUNCIONARIO") // Nome da tabela no banco
@Inheritance(strategy = InheritanceType.JOINED) // Estratégia JOINED: cada subclasse terá sua própria tabela, mas compartilham a chave primária
@DiscriminatorColumn(name = "tipo_funcionario", discriminatorType = DiscriminatorType.STRING) // Coluna que diferencia os tipos de funcionários
public class Funcionario {

    @Id // Define que este campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID será gerado automaticamente pelo banco de dados
    @Column(name = "id_funcionario") // Nome da coluna no banco de dados
    private Long id;

    @Column(name = "nome", nullable = false) // Define a coluna 'nome', que não pode ser nula
    private String nome;

    @Column(name = "horas_trabalhadas") // Define a coluna para armazenar as horas trabalhadas
    private int horasTrabalhadas;

    @Column(name = "valor_por_hora") // Define a coluna para armazenar o valor pago por hora trabalhada
    private double valorPorHora;

    // Construtor padrão necessário para JPA
    public Funcionario() {}

    // Construtor para inicializar os dados do funcionário
    public Funcionario(String nome, int horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getHorasTrabalhadas() { return horasTrabalhadas; }
    public void setHorasTrabalhadas(int horasTrabalhadas) { this.horasTrabalhadas = horasTrabalhadas; }

    public double getValorPorHora() { return valorPorHora; }
    public void setValorPorHora(double valorPorHora) { this.valorPorHora = valorPorHora; }

    // Método que calcula o salário do funcionário
    public double calcularSalario() {
        return horasTrabalhadas * valorPorHora;
    }

    // Método para imprimir informações do funcionário
    public void imprimirInformacao() {
        System.out.println("Nome: " + nome);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por Hora: R$ " + valorPorHora);
        System.out.println("Salário Final: R$ " + calcularSalario());
    }
}
