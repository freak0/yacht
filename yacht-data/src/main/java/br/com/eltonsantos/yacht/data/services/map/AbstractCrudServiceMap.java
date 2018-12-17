package br.com.eltonsantos.yacht.data.services.map;

import br.com.eltonsantos.yacht.data.model.BaseEntity;

import java.io.Serializable;
import java.util.*;

public abstract class AbstractCrudServiceMap<T extends BaseEntity, ID extends Serializable> {

    private final Map<ID, T> map = new HashMap<>();

    protected T save(ID id, T object) {
        this.map.put(id, object);
        return object;
    }

    public Set<T> findAll() {
        return new HashSet<>(this.map.values());
    }

    public Optional<T> findById(ID id) {
        return Optional.of(this.map.get(id));
    }

    public void deleteById(ID id) {
        this.map.remove(id);
    }

    public void delete(T object) {
        this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

}
