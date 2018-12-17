package br.com.eltonsantos.yacht.data.services;

import br.com.eltonsantos.yacht.data.model.BaseEntity;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface CrudService<T extends BaseEntity, ID extends Serializable> {

    T save(T object);

    Optional<T> findById(ID id);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);

}
