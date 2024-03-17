package com.uli.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uli.dto.Employee;
@Component
public class EmployeeDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public Employee saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	
	public Employee updateEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		return employee;
		
	}
	public Employee deleteEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.remove(employee);
		entityTransaction.commit();
		return employee;
	}
	public Employee findEmployeeByPhoneNoAndPassword(long phone_no,String password) {
		Query query=entityManager.createQuery("select e from Employee e where e.phone_no=?1 and e.password=?2");
		query.setParameter(1,phone_no);
		query.setParameter(2, password);
		List<Employee> employees=query.getResultList();
		return employees.get(0);
		
	}

}
