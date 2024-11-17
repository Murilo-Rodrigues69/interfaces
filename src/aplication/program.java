package aplication;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

public class program {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	DateTimeFormatter fmt =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	System.out.println("Entre os dados do contrato:");	
	System.out.print("Numero: ");
	int number = sc.nextInt();
	System.out.print("Data (dd/MM/yyyy):");
	LocalDate date = LocalDate.parse(sc.next(), fmt);
	System.out.print("Valor do contrato: ");	
	Double value = sc.nextDouble();
	Contract obj= new Contract(number,date,value);
	
	System.out.print("Entre com o numero de parcelas:");
	int n = sc.nextInt();
	ContractService service = new ContractService(new PayPalService());
	service.processContract(obj, n);
	System.out.println("Parcelas:");
	for(Installment installment : obj.getInstallments()) {
		System.out.println(installment.toString());
	}
sc.close();
	}

}
