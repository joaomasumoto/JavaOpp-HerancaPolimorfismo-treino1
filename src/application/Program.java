package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o número de funcionários: ");
		int n = sc.nextInt();
		
		List<Employee> lista = new ArrayList<>();
		
		for (int i=1; i<=n ;i++) {
			System.out.println("Funcionario #" + i + " data:");
			System.out.print("Terceirizado (s/n)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas:  ");
			int horas = sc.nextInt();
			
			double valorHora = sc.nextDouble();
			
			if (ch == 's') {
				System.out.print("Taxa adicional: ");
				double taxaAdicional = sc.nextDouble();
				lista.add(new OutsourcedEmployee(nome, horas, valorHora, taxaAdicional));
			} else {
				lista.add(new Employee(nome, horas, valorHora));
			}	
		}
		
		System.out.println();
		System.out.println("PAGAMENTOS:");
		
		for (Employee func : lista) {
			System.out.println(func.getName() + " - $" + String.format("%.2f", func.payment()));
		}
		
		sc.close();

	}

}
