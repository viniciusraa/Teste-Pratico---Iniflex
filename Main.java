import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

// 1
class Pessoa {
    public String nome;
    public LocalDate nascimento;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
// 2
class Funcionario  extends Pessoa{
    public BigDecimal salario;
    public String func;

    public Funcionario(String nome, LocalDate nascimento, BigDecimal salario, String func) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.salario = salario;
        this.func = func;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "Nome: " + nome + " Data de nascimento: " + nascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Salario: " + df.format(salario) + " funcao: " + func;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    // public class NomeComparator implements Comparator<Funcionario> {
    //     @Override
    //     public int compare(Funcionario funcio1, Funcionario funcio2) {
    //         String nomeFuncio1 = funcio1.getNome();
    //         String nomeFuncio2 = funcio2.getNome();
    //         return nomeFuncio1.compareTo(nomeFuncio2);
    //     }
    // }

}
// 3
public class Main {
    public static void main(String[] args) {
        //3.1
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), new BigDecimal(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), new BigDecimal(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 05, 24), new BigDecimal(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 02), new BigDecimal(2799.93), "Gerente"));
        //3.2
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcRemover = funcionarios.get(i);
            
            if (funcRemover.getNome().equals("João")) {
                funcionarios.remove(funcRemover);
                break;
            }
        }
        //3.3
        System.out.println("3.3");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println(funcionarios.get(i));
        }
        //3.4
        for (int i = 0; i < funcionarios.size(); i++) {
            BigDecimal aumento = funcionarios.get(i).getSalario();
            funcionarios.get(i).setSalario(aumento.multiply(new BigDecimal(1.1)));
        }
        //3.5
        Map<String,Funcionario> mapaFuncionarios = new HashMap<String,Funcionario>();
        for (int i = 0; i < funcionarios.size(); i++) {
            mapaFuncionarios.put(funcionarios.get(i).getFunc(), funcionarios.get(i));
        }
        //3.6
        System.out.println("3.6");
        System.out.println(mapaFuncionarios);
        //3.8
        System.out.println("3.8");
        for (int i = 0; i < funcionarios.size(); i++) {
           int mes = funcionarios.get(i).getNascimento().getMonthValue();
           if (mes == 10 || mes == 12) {
            System.out.println(funcionarios.get(i));
           }
        }
        //3.9
        System.out.println("3.9");
        int max = 0;
        Funcionario maisVelho = new Funcionario(null, null, null, null);
        for (int i = 0; i < funcionarios.size(); i++) {
            int ano = funcionarios.get(i).getNascimento().getYear();
            int idade = 2024 - ano;
            if (idade > max) {
                max = idade;
                maisVelho = funcionarios.get(i);
            }
        }
        System.out.println(maisVelho);
        //3.10
        System.out.println("3.10");
        funcionarios.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));
        funcionarios.forEach((Funcionario funcionario) -> {
            System.out.println(funcionario.toString());
        });
        //3.11
        System.err.println("3.11");
        BigDecimal somaSalarios = new BigDecimal(0.00);
        BigDecimal salario = new BigDecimal(0.00);;
        for (int i = 0; i < funcionarios.size(); i++) {
            salario = funcionarios.get(i).getSalario();
            somaSalarios = somaSalarios.add(salario);
        }
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Soma: " + df.format(somaSalarios));
        //3.12
        System.out.println("3.12");
        BigDecimal salarioMinimo = new BigDecimal(1212.00);
        BigDecimal quantos = new BigDecimal(0.00);
        for (int i = 0; i < funcionarios.size(); i++) {
            salario = funcionarios.get(i).getSalario();
            quantos = salario.divide(salarioMinimo, 1, RoundingMode.CEILING);
            System.out.println(funcionarios.get(i).getNome() + " ganha " + quantos + " salários mínimos");
        }
    }
}