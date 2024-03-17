package com.uli.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uli.dto.Attendance;
import com.uli.dto.Employee;
@Component
public class AttendanceDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public Attendance saveAttendance(Attendance attendance) {
		entityTransaction.begin();
		entityManager.persist(attendance);
		entityTransaction.commit();
		return attendance;
	}
	
	public Attendance updateAttendance(Attendance attendance) {
		entityTransaction.begin();
		entityManager.merge(attendance);
		entityTransaction.commit();
		return attendance;
	}
	

}
