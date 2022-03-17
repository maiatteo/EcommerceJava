package com.objectmethod.ecommerce.mapper;

import com.objectmethod.ecommerce.dto.ProdottoDto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.entity.Prodotto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T16:45:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class ProdottiMapperImpl extends ProdottiMapper {

    @Override
    public ProdottoDto toModel(Prodotto entity) {
        if ( entity == null ) {
            return null;
        }

        ProdottoDto prodottoDto = new ProdottoDto();

        prodottoDto.setIdCarrello( entityCarrelloId( entity ) );
        prodottoDto.setId( entity.getId() );
        prodottoDto.setNome( entity.getNome() );
        prodottoDto.setPeso( entity.getPeso() );
        prodottoDto.setQuantita( entity.getQuantita() );
        prodottoDto.setCodice( entity.getCodice() );
        prodottoDto.setPrezzo( entity.getPrezzo() );

        return prodottoDto;
    }

    @Override
    public Prodotto toModel(ProdottoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Prodotto prodotto = new Prodotto();

        prodotto.setCarrello( prodottoDtoToCarrello( dto ) );
        prodotto.setId( dto.getId() );
        prodotto.setNome( dto.getNome() );
        prodotto.setPeso( dto.getPeso() );
        prodotto.setQuantita( dto.getQuantita() );
        prodotto.setCodice( dto.getCodice() );
        prodotto.setPrezzo( dto.getPrezzo() );

        return prodotto;
    }

    private Long entityCarrelloId(Prodotto prodotto) {
        if ( prodotto == null ) {
            return null;
        }
        Carrello carrello = prodotto.getCarrello();
        if ( carrello == null ) {
            return null;
        }
        Long id = carrello.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Carrello prodottoDtoToCarrello(ProdottoDto prodottoDto) {
        if ( prodottoDto == null ) {
            return null;
        }

        Carrello carrello = new Carrello();

        carrello.setId( prodottoDto.getIdCarrello() );

        return carrello;
    }
}
