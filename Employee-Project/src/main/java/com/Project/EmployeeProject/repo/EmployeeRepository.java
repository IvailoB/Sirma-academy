package com.Project.EmployeeProject.repo;

import com.Project.EmployeeProject.models.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query (
//        "SELECT\n" +
//                "    ep1.employee_id AS employee1_id,\n" +
//                "    ep2.employee_id AS employee2_id,\n" +
//                "    ep1.project_id,\n" +
//                "    SUM(GREATEST(d1.end_date, d2.end_date) - LEAST(d1.start_date, d2.start_date)) AS total_overlapping_days\n" +
//                "FROM\n" +
//                "    employee_project ep1\n" +
//                "JOIN\n" +
//                "    employee_project ep2 ON ep1.project_id = ep2.project_id AND ep1.employee_id < ep2.employee_id\n" +
//                "JOIN\n" +
//                "    employees_dates ed1 ON ep1.employee_id = ed1.employee_id\n" +
//                "JOIN\n" +
//                "    employees_dates ed2 ON ep2.employee_id = ed2.employee_id\n" +
//                "JOIN\n" +
//                "    date d1 ON ed1.dates_id = d1.id\n" +
//                "JOIN\n" +
//                "    date d2 ON ed2.dates_id = d2.id\n" +
//                "WHERE\n" +
//                "    GREATEST(d1.end_date, d2.end_date) >= LEAST(d1.start_date, d2.start_date) \n" +
//                "GROUP BY\n" +
//                "    employee1_id, employee2_id, ep1.project_id \n" +
//                "HAVING\n" +
//                "    SUM(GREATEST(d1.end_date, d2.end_date) - LEAST(d1.start_date, d2.start_date)) > 0\n" +
//                "ORDER BY\n" +
//                "    employee1_id, employee2_id, ep1.project_id, total_overlapping_days DESC;\n"
//    )
//    List<Employee> findEmployeesWhoWorkSameProject();
}
