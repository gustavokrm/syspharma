package com.camaratapira.syspharma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.camaratapira.syspharma.entity.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{
    List<Compras> findByidcompras(int idcompras);    

}
