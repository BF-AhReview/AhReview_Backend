package com.bulgogifriedrice.backend.domain.store.repository;

import com.bulgogifriedrice.backend.domain.store.entity.Store;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends CrudRepository<Store, String> {

    List<Store> findAll();

}
