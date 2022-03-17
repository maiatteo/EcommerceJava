package com.objectmethod.ecommerce.mapper;

import com.objectmethod.ecommerce.dto.IndirizzoDto;
import com.objectmethod.ecommerce.entity.Indirizzo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T16:45:10+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class IndirizzoMapperImpl extends IndirizzoMapper {

    @Override
    public IndirizzoDto toDto(Indirizzo entity) {
        if ( entity == null ) {
            return null;
        }

        IndirizzoDto indirizzoDto = new IndirizzoDto();

        indirizzoDto.setId( entity.getId() );
        indirizzoDto.setVia( entity.getVia() );
        indirizzoDto.setCitta( entity.getCitta() );
        indirizzoDto.setProvincia( entity.getProvincia() );
        indirizzoDto.setRegione( entity.getRegione() );

        return indirizzoDto;
    }

    @Override
    public Indirizzo toModel(IndirizzoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Indirizzo indirizzo = new Indirizzo();

        indirizzo.setId( dto.getId() );
        indirizzo.setVia( dto.getVia() );
        indirizzo.setCitta( dto.getCitta() );
        indirizzo.setProvincia( dto.getProvincia() );
        indirizzo.setRegione( dto.getRegione() );

        return indirizzo;
    }
}
