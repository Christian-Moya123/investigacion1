package com.uce.edu.demo.repositori;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
		
	}

	@Override
	public void borrarCitaMedica(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarCitaMedica(id));
		
	}

	@Override
	public CitaMedica buscarCitaMedicaPorNumeroDeCita(Integer numero) {
		// TODO Auto-generated method stub
		String sql = "SELECT c FROM CitaMedica c WHERE c.numeroCita = :datoNumeroCita";
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery(sql, CitaMedica.class);
		myQuery.setParameter("datoNumeroCita", numero);
		
		return myQuery.getSingleResult();
	}

	@Override
	public List<CitaMedica> citasMedicasPendientes(String cedula) {
		// TODO Auto-generated method stub
		String sql ="SELECT c FROM CitaMedica c";
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery(sql, CitaMedica.class);
		
		return myQuery.getResultList();
	}

}
