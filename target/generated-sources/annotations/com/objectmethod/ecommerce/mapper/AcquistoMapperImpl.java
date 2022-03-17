package com.objectmethod.ecommerce.mapper;

import com.objectmethod.ecommerce.dto.AcquistoDto;
import com.objectmethod.ecommerce.entity.Acquisto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.entity.Utente;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T16:45:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class AcquistoMapperImpl extends AcquistoMapper {

    @Override
    public AcquistoDto toDto(Acquisto entity) {
        if ( entity == null ) {
            return null;
        }

        AcquistoDto acquistoDto = new AcquistoDto();

        acquistoDto.setIdCarrello( entityCarrelloId( entity ) );
        acquistoDto.setIdUtente( entityUtenteId( entity ) );
        acquistoDto.setId( entity.getId() );
        acquistoDto.setData( entity.getData() );

        return acquistoDto;
    }

    @Override
    public Acquisto toModel(AcquistoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Acquisto acquisto = new Acquisto();

        acquisto.setCarrello( acquistoDtoToCarrello( dto ) );
        acquisto.setUtente( acquistoDtoToUtente( dto ) );
        acquisto.setId( dto.getId() );
        acquisto.setData( dto.getData() );

        return acquisto;
    }

    private Long entityCarrelloId(Acquisto acquisto) {
        if ( acquisto == null ) {
            return null;
        }
        Carrello carrello = acquisto.getCarrello();
        if ( carrello == null ) {
            return null;
        }
        Long id = carrello.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityUtenteId(Acquisto acquisto) {
        if ( acquisto == null ) {
            return null;
        }
        Utente utente = acquisto.getUtente();
        if ( utente == null ) {
            return null;
        }
        Long id = utente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Carrello acquistoDtoToCarrello(AcquistoDto acquistoDto) {
        if ( acquistoDto == null ) {
            return null;
        }

        Carrello carrello = new Carrello();

        carrello.setId( acquistoDto.getIdCarrello() );

        return carrello;
    }

    protected Utente acquistoDtoToUtente(AcquistoDto acquistoDto) {
        if ( acquistoDto == null ) {
            return null;
        }

        Utente utente = new Utente();

        utente.setId( acquistoDto.getIdUtente() );

        return utente;
    }
}
