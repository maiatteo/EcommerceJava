package com.objectmethod.ecommerce.mapper;

import com.objectmethod.ecommerce.dto.CarrelloDto;
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
public class CarrelloMapperImpl extends CarrelloMapper {

    @Override
    public CarrelloDto toDto(Carrello entity) {
        if ( entity == null ) {
            return null;
        }

        CarrelloDto carrelloDto = new CarrelloDto();

        carrelloDto.setIdUtente( entityUtenteId( entity ) );
        carrelloDto.setId( entity.getId() );

        return carrelloDto;
    }

    @Override
    public Carrello toModel(CarrelloDto dto) {
        if ( dto == null ) {
            return null;
        }

        Carrello carrello = new Carrello();

        carrello.setUtente( carrelloDtoToUtente( dto ) );
        carrello.setId( dto.getId() );

        return carrello;
    }

    private Long entityUtenteId(Carrello carrello) {
        if ( carrello == null ) {
            return null;
        }
        Utente utente = carrello.getUtente();
        if ( utente == null ) {
            return null;
        }
        Long id = utente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Utente carrelloDtoToUtente(CarrelloDto carrelloDto) {
        if ( carrelloDto == null ) {
            return null;
        }

        Utente utente = new Utente();

        utente.setId( carrelloDto.getIdUtente() );

        return utente;
    }
}
