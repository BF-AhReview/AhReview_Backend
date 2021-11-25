package com.bulgogifriedrice.backend.domain.store.repository;

import com.bulgogifriedrice.backend.domain.store.entity.Store;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, String> {
}
