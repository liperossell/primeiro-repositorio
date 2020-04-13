package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.worker.entities.Department;
import entities.worker.entities.HourContract;
import entities.worker.entities.Worker;
import entities.worker.entities.WorkerLevel;

public class WorkerProgram {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US); //Define locale default para EN_US
        Scanner sc = new Scanner(System.in); //Criar o objeto Scanner para leitura dos dados

        System.out.println("Enter department's name:"); //Entre com o nome do departamento
        Department department = new Department(sc.nextLine()); //Lê o nome do departamento

        System.out.println("Enter worker data:"); //Entre com dados do trabalhador
        System.out.println("Name:"); //Nome
        String workerName = sc.nextLine(); //Lê o nome
        
        System.out.println("Level:"); //Nível
        String workerLevel = sc.nextLine(); //Lê o nível
       
        System.out.println("Base salary:"); //Salário base
        Double baseSalary = sc.nextDouble(); //Lê o salário base
        
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, department); //Cria o objeto Worker
        
        System.out.println("How many contracts to this worker?"); //Quantos contratos para este trabalhador?
        int contract = sc.nextInt(); //Lê a quantidade de contratos

                     
        for (int i = 0; i < contract; i++){ //Para todos os contratos, faça...
            System.out.println("Enter contract #" + (i+1) + " data:"); //Entre com os dados do contrato #
            System.out.println("Date (DD/MM/YYYY): "); //Data (dd/MM/yyyy)
            sc.nextLine(); //Consome backspace pendente
            String dateString = sc.nextLine(); //Lê a data

            System.out.println("Value per hour: "); //Valor por hora
            double valuePerHour = sc.nextDouble(); //Lê o valor por hora

            System.out.println("Duration (hours): "); //Duração (horas)
            int hours = sc.nextInt(); //Lê a duração

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Cria um novo objeto SimpleDateFormat com o padrão dd/MM/yyyy
            Date date = sdf.parse(dateString); //Converte o dateString em formato Date, conforme o SimpleDateFormat
            
            worker.addContract(new HourContract(date, valuePerHour, hours)); //Adicione um novo contrato para o Worker
               
        }

        System.out.println("Enter month and year to calculate income (MM/YYYY): "); //Entre com mês e ano para calcular montante
        sc.nextLine();
        String totalIncomeData = sc.nextLine(); //Lê mês e ano
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy"); //Cria objeto SimpleDateFormat para transformar em data
        Calendar cal = Calendar.getInstance(); //Cria objeto calendário
        cal.setTime(sdf.parse(totalIncomeData)); //Configura o calendário com a data informada
        int year = cal.get(Calendar.YEAR); //extrai o ano
        int month = cal.get(Calendar.MONTH)+1; //Extrai o mês
        System.out.println("Name: " + worker.getName()); //Nome
        System.out.println("Department: " + worker.getDepartment()); //Departamento
        System.out.println("Income for " + totalIncomeData + ": " + worker.income(year, month)); //Montate para

        sc.close();
    }
}