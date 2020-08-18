package com.barros.pugliese.votacao.model;

import com.barros.pugliese.votacao.dto.PautaDto;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "pauta", schema = "dbc")
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    public static Pauta of(PautaDto pautaDto) {
        Pauta pauta = new Pauta();
        pauta.setDescricao(pautaDto.getDescricao());

        return pauta;
    }
}
