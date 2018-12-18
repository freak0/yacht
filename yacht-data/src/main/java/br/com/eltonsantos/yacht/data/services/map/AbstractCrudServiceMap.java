package br.com.eltonsantos.yacht.data.services.map;

import br.com.eltonsantos.yacht.data.model.BaseEntity;

import java.util.*;

public abstract class AbstractCrudServiceMap<T extends BaseEntity, ID extends Long> {

    private final Map<Long, T> map = new HashMap<>();

    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
        }
        this.map.put(object.getId(), object);
        return object;
    }

    public Set<T> findAll() {
        return new HashSet<>(this.map.values());
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(this.map.get(id));
    }

    public void deleteById(ID id) {
        this.map.remove(id);
    }

    public void delete(T object) {
        this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        if (this.map.size() == 0) {
            return 1L;
        }

        return Collections.max(this.map.keySet()) + 1;
    }

}
