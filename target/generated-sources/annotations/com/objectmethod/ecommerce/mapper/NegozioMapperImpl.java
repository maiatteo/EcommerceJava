package com.objectmethod.ecommerce.mapper;

import com.objectmethod.ecommerce.dto.NegozioDto;
import com.objectmethod.ecommerce.entity.Indirizzo;
import com.objectmethod.ecommerce.entity.Negozio;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T16:45:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class NegozioMapperImpl extends NegozioMapper {

    @Override
    public NegozioDto toDto(Negozio entity) {
        if ( entity == null ) {
            return null;
        }

        NegozioDto negozioDto = new NegozioDto();

        negozioDto.setIdIndirizzo( entityIndirizzoNegId( entity ) );
        negozioDto.setId( entity.getId() );
        negozioDto.setNome( entity.getNome() );
        negozioDto.setCodice( entity.getCodice() );

        return negozioDto;
    }

    @Override
    public Negozio toModel(NegozioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Negozio negozio = new Negozio();

        negozio.setIndirizzoNeg( negozioDtoToIndirizzo( dto ) );
        negozio.setId( dto.getId() );
        negozio.setNome( dto.getNome() );
        negozio.setCodice( dto.getCodice() );

        return negozio;
    }

    private Long entityIndirizzoNegId(Negozio negozio) {
        if ( negozio == null ) {
            return null;
        }
        Indirizzo indirizzoNeg = negozio.getIndirizzoNeg();
        if ( indirizzoNeg == null ) {
            return null;
        }
        Long id = indirizzoNeg.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Indirizzo negozioDtoToIndirizzo(NegozioDto negozioDto) {
        if ( negozioDto == null ) {
            return null;
        }

        Indirizzo indirizzo = new Indirizzo();

        indirizzo.setId( negozioDto.getIdIndirizzo() );

        return indirizzo;
    }
}
