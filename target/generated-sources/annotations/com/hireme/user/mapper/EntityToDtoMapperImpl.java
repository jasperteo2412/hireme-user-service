package com.hireme.user.mapper;

import com.hireme.user.dto.MessagesDTO;
import com.hireme.user.entity.MessagesEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-15T14:13:03+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class EntityToDtoMapperImpl implements EntityToDtoMapper {

    @Override
    public MessagesDTO convertMessageEntityToDto(MessagesEntity messagesEntity) {
        if ( messagesEntity == null ) {
            return null;
        }

        MessagesDTO messagesDTO = new MessagesDTO();

        messagesDTO.setCommunicationId( messagesEntity.getCommunicationId() );
        messagesDTO.setMessageBody( messagesEntity.getMessageBody() );
        messagesDTO.setSentFrom( messagesEntity.getSentFrom() );
        messagesDTO.setSentTo( messagesEntity.getSentTo() );
        messagesDTO.setSentDateTime( messagesEntity.getSentDateTime() );
        messagesDTO.setReadIndicator( messagesEntity.getReadIndicator() );

        return messagesDTO;
    }

    @Override
    public List<MessagesDTO> convertMessageEntityToDto(List<MessagesEntity> messagesEntityList) {
        if ( messagesEntityList == null ) {
            return null;
        }

        List<MessagesDTO> list = new ArrayList<MessagesDTO>( messagesEntityList.size() );
        for ( MessagesEntity messagesEntity : messagesEntityList ) {
            list.add( convertMessageEntityToDto( messagesEntity ) );
        }

        return list;
    }
}
