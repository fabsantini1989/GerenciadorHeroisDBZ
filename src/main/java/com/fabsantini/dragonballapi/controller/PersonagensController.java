package com.fabsantini.dragonballapi.controller;

import com.fabsantini.dragonballapi.document.Personagens;
import com.fabsantini.dragonballapi.repository.PersonagensRepository;
import com.fabsantini.dragonballapi.service.PersonagensService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.fabsantini.dragonballapi.constans.PersonagensConstant.PERSONAGENS_ENDPOINT_LOCAL;

@RestController
@Slf4j

public class PersonagensController {

    PersonagensService personagensService;
    PersonagensRepository personagensRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(PersonagensController.class);

    public PersonagensController(PersonagensService personagensService, PersonagensRepository personagensRepository) {
        this.personagensService = personagensService;
        this.personagensRepository = personagensRepository;
    }

    @GetMapping(PERSONAGENS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Personagens> getAllItems() {
        log.info("REQUISITANDO A LISTA COMPLETA DOS PERSONAGENS");
        return personagensService.findAll();
    }

    @GetMapping(PERSONAGENS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Personagens>> findByIdHero(@PathVariable String id) {
        log.info("REQUESITANDO HEROI PELO ID {}", id);
        return personagensService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(PERSONAGENS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Personagens> createHero(@RequestBody Personagens personagens) {
        log.info("UM NOVO HERÓI FOI CRIADO");
        return personagensService.save(personagens);

    }

    @DeleteMapping(PERSONAGENS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
        personagensService.deletebyIDHero(id);
        log.info("DELETANDO UM HERÓI COM O ID {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
