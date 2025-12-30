package com.skillnext2;

import java.util.List;
import java.util.Scanner;

public class AppMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {
            System.out.println("\n==== EMPLOYEE MANAGEMENT ====");
            System.out.println("1. Insert Employee");
            System.out.println("2. View Employee By ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    dao.saveEmployee(new Employee(name, sal));
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    Employee e = dao.getEmployee(id);
                    if (e != null)
                        System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
                    else
                        System.out.println("Employee Not Found!");
                    break;

                case 3:
                    List<Employee> list = dao.getAllEmployees();
                    list.forEach(emp ->
                            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary())
                    );
                    break;

                case 4:
                    System.out.print("Enter Employee ID: ");
                    int uid = sc.nextInt();
                    Employee ue = dao.getEmployee(uid);
                    if (ue != null) {
                        System.out.print("Enter New Salary: ");
                        double ns = sc.nextDouble();
                        ue.setSalary(ns);
                        dao.updateEmployee(ue);
                    } else {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;

                case 6:
                    HibernateUtil.getSessionFactory().close();
                    sc.close();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
