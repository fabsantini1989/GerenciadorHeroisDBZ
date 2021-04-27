package com.fabsantini.dragonballapi.repository;

import com.fabsantini.dragonballapi.document.Personagens;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan

    //Cria a interface PersonagensRepository extendendo a CrudRepository;
    public interface PersonagensRepository extends CrudRepository<Personagens, String> {
}
