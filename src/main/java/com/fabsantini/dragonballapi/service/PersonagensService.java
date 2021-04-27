package com.fabsantini.dragonballapi.service;

import com.fabsantini.dragonballapi.document.Personagens;
import com.fabsantini.dragonballapi.repository.PersonagensRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonagensService {

    private final PersonagensRepository personagensRepository;

    public PersonagensService(PersonagensRepository personagensRepository) {
        this.personagensRepository = personagensRepository;
    }

    public Flux<Personagens> findAll(){
        return Flux.fromIterable(this.personagensRepository.findAll());
    }

    public  Mono<Personagens> findByIdHero(String id){
        return  Mono.justOrEmpty(this.personagensRepository.findById(id));
    }

    public Mono<Personagens> save(Personagens personagens){
        return  Mono.justOrEmpty(this.personagensRepository.save(personagens));
    }

    public Mono<Boolean> deletebyIDHero(String id) {
        personagensRepository.deleteById(id);
        return Mono.just(true);
    }
}