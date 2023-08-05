package com.uce.edu.demo.repositori;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	  @PersistenceContext
	  private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
		
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void borrarPaciente(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPaciente(id));
	}

	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		String sql = "SELECT p FROM Paciente p WHERE p.cedula =:datoCedula";
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery(sql, Paciente.class);
		myQuery.setParameter("datoCedula", cedula);
		
		return myQuery.getSingleResult();
	}
	
	@Override
    public Paciente insertarPacienteNuevoH(Paciente paciente) {
        this.entityManager.persist(paciente);
        return paciente;
    }
	  
	  
}
