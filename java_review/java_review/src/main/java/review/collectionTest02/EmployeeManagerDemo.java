package review.collectionTest02;

import java.util.HashSet;
import java.util.Objects;

class Employee {
    String name, code, department;

    public Employee(String name, String code, String department) {
        this.name = name;
        this.code = code;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(code, employee.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}

class EmployeeManager {
    private HashSet<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee){
       if (employees.add(employee)){
        System.out.println("회원 추가 성공 :" + employee.toString());
       }else{
           System.out.println("이미 존재하는 사원입니다.: " + employee);

       }

    }

    public void findEmployee(String code) {
        for (Employee employee : employees) {
            if (employee.code.equals(code)) {
                System.out.println("사원 검색: " + employee);
                return;
            }
        }
        System.out.println("해당 사원을 찾을 수 없습니다.");
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
        System.out.println("회원 삭제 성공: " + employee.toString());
    }
}

public class EmployeeManagerDemo {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.addEmployee(new Employee("홍길동", "E01", "HR"));
        manager.addEmployee(new Employee("김철수", "E02", "Marketing"));
        manager.addEmployee(new Employee("홍길동", "E01", "HR")); // 중복 추가 시도

        manager.findEmployee("E01");
        manager.removeEmployee(new Employee("홍길동", "E01", "HR"));
        manager.findEmployee("E01");
    }
}
