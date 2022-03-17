package com.objectmethod.ecommerce.mapper;

import com.objectmethod.ecommerce.dto.UtenteDto;
import com.objectmethod.ecommerce.entity.Carrello;
import com.objectmethod.ecommerce.entity.Indirizzo;
import com.objectmethod.ecommerce.entity.Utente;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T16:45:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class UtenteMapperImpl extends UtenteMapper {

    @Override
    public UtenteDto toDto(Utente entity) {
        if ( entity == null ) {
            return null;
        }

        UtenteDto utenteDto = new UtenteDto();

        utenteDto.setIdCarrello( entityCarrelloId( entity ) );
        utenteDto.setIdIndirizzo( entityIndirizzoUteId( entity ) );
        utenteDto.setId( entity.getId() );
        utenteDto.setNome( entity.getNome() );
        utenteDto.setCognome( entity.getCognome() );
        utenteDto.setEmail( entity.getEmail() );
        utenteDto.setUsername( entity.getUsername() );
        utenteDto.setPassword( entity.getPassword() );
        utenteDto.setAmministratore( entity.getAmministratore() );

        return utenteDto;
    }

    @Override
    public Utente toModel(UtenteDto dto) {
        if ( dto == null ) {
            return null;
        }

        Utente utente = new Utente();

        utente.setCarrello( utenteDtoToCarrello( dto ) );
        utente.setIndirizzoUte( utenteDtoToIndirizzo( dto ) );
        utente.setId( dto.getId() );
        utente.setNome( dto.getNome() );
        utente.setCognome( dto.getCognome() );
        utente.setEmail( dto.getEmail() );
        utente.setUsername( dto.getUsername() );
        utente.setPassword( dto.getPassword() );
        utente.setAmministratore( dto.getAmministratore() );

        return utente;
    }

    private Long entityCarrelloId(Utente utente) {
        if ( utente == null ) {
            return null;
        }
        Carrello carrello = utente.getCarrello();
        if ( carrello == null ) {
            return null;
        }
        Long id = carrello.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityIndirizzoUteId(Utente utente) {
        if ( utente == null ) {
            return null;
        }
        Indirizzo indirizzoUte = utente.getIndirizzoUte();
        if ( indirizzoUte == null ) {
            return null;
        }
        Long id = indirizzoUte.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Carrello utenteDtoToCarrello(UtenteDto utenteDto) {
        if ( utenteDto == null ) {
            return null;
        }

        Carrello carrello = new Carrello();

        carrello.setId( utenteDto.getIdCarrello() );

        return carrello;
    }

    protected Indirizzo utenteDtoToIndirizzo(UtenteDto utenteDto) {
        if ( utenteDto == null ) {
            return null;
        }

        Indirizzo indirizzo = new Indirizzo();

        indirizzo.setId( utenteDto.getIdIndirizzo() );

        return indirizzo;
    }
}
