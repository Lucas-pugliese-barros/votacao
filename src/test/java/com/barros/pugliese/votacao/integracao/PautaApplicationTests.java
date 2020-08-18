package com.barros.pugliese.votacao.integracao;

import com.barros.pugliese.votacao.dto.PautaDto;
import com.barros.pugliese.votacao.model.Pauta;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
class PautaApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void deveriaSalvarPauta() {
        PautaDto pautaDto = new PautaDto("descricaoDaPauta");

        EntityExchangeResult<Pauta> pautaResult = webTestClient.post()
                .uri("/pauta")
                .body(BodyInserters.fromValue(pautaDto))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Pauta.class)
                .returnResult();

        Pauta pautaSalva = pautaResult.getResponseBody();

        assertThat(pautaSalva).isNotNull();
        assertThat(pautaSalva.getId()).isNotNull();
        assertThat(pautaSalva.getDescricao()).isEqualTo(pautaDto.getDescricao());
   }
}
