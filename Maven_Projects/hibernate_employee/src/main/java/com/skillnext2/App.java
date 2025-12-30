package com.skillnext2;

public class App {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        // INSERT
        Employee e1 = new Employee("Ram", 45000);
        dao.saveEmployee(e1);

        // READ ONE
        Employee emp = dao.getEmployee(e1.getId());
        System.out.println("Fetched Employee: " + emp.getName());

        // UPDATE
        emp.setSalary(55000);
        dao.updateEmployee(emp);

        // READ ALL
        dao.getAllEmployees().forEach(e ->
                System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary())
        );

        // DELETE
        dao.deleteEmployee(emp.getId());

        HibernateUtil.getSessionFactory().close();
    }
}
