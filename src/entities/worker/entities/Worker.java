package entities.worker.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker{
    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private List<HourContract> contracts = new ArrayList<>();
    private Department department;

    public Worker(){}

    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    };

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removecontract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double totalIncome = 0.0; //Inicia variável que irá retornar com o valor total
        for (HourContract contract : contracts){ //Para todo contrato, faça;;;
            Calendar cal = Calendar.getInstance(); //Inicia uma instância de calendário
            cal.setTime(contract.getDate()); //Pega a data do contrato e configura no calendário
            if (cal.get(Calendar.YEAR) == year && (cal.get(Calendar.MONTH)+1) == month){ //Se o ano e mês informado for igual ao do contrato, então...
                totalIncome += contract.totalValue(); //Pega o valor total do contrato e soma
            }
        }

        return totalIncome + this.baseSalary; //retorna o valor total
    }

	public String getName() {
		return this.name;
	}

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}