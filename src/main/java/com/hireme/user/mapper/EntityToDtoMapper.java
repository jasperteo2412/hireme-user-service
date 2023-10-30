package com.hireme.user.mapper;

import com.hireme.user.dto.MessagesDTO;
import com.hireme.user.dto.UserDTO;
import com.hireme.user.entity.MessagesEntity;
import com.hireme.user.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityToDtoMapper {

    MessagesDTO convertMessageEntityToDto(MessagesEntity messagesEntity);
    List<MessagesDTO> convertMessageEntityToDto(List<MessagesEntity> messagesEntityList);
    List<UserDTO> convertUserEntityToDto(List<UserEntity> userEntityList);
}
