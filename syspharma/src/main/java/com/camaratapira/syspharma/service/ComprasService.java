package com.camaratapira.syspharma.service;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.camaratapira.syspharma.repositories.ComprasRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import com.camaratapira.syspharma.entity.Compras;


@Service
public class ComprasService {
	
	@Autowired
	ComprasRepository comprasRepository;
	@Autowired
	EntityManager entityManager;
	
	public void comprar(Compras compras) {
		
		StoredProcedureQuery storedProcedure = entityManager
				.createStoredProcedureQuery("realiza_compra", void.class)
				.registerStoredProcedureParameter("sp_idcompra", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idfarmacia", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_idservidor", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_iddependente", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_valorcompra", double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("sp_datacompra", Timestamp.class, ParameterMode.IN)
				.setParameter("sp_idcompra", compras.getIdcompras())
				.setParameter("sp_idfarmacia", compras.getFarmacia())
				.setParameter("sp_idservidor", compras.getServidor())
				.setParameter("sp_iddependente", compras.getDependentes())
				.setParameter("sp_valorcompra", compras.getValorcompra())
				.setParameter("sp_datacompra", compras.getDatacompra());
		
		storedProcedure.execute();		
	}
	
}
