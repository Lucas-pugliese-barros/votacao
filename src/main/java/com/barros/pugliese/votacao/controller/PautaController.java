package com.barros.pugliese.votacao.controller;

import com.barros.pugliese.votacao.dto.PautaDto;
import com.barros.pugliese.votacao.model.Pauta;
import com.barros.pugliese.votacao.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PautaController {

    private PautaRepository pautaRepository;

    @Autowired
    public PautaController(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @PostMapping(value = "/pauta")
    public Mono<Pauta> route(@RequestBody PautaDto pautaDto) {
        final Pauta pauta = pautaRepository.save(Pauta.of(pautaDto));

        return Mono.just(pauta).log();
    }
}
