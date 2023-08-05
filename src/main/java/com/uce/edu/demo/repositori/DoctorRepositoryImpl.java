package com.uce.edu.demo.repositori;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
		
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
		
	}

	@Override
	public void borrarDoctor(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarDoctor(id));
		
	}

	@Override
	public Doctor buscarDoctorPorCedula(String cedula) {
		// TODO Auto-generated method stub
		String sql = "SELECT d FROM Doctor d WHERE d.cedula =:datoCedula";
		TypedQuery<Doctor> myQuery = this.entityManager.createQuery(sql,Doctor.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

}
