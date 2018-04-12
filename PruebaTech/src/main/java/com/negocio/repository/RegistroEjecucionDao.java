package com.negocio.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.negocio.entity.RegistroEjecucion;

/**
 * @author HABUR

 */
@Transactional
@Repository
public interface RegistroEjecucionDao extends CrudRepository<RegistroEjecucion, Long> {


}