package com.fakeBlog.mapper;

import com.fakeBlog.entity.ComentarioEntity;
import com.fakeBlog.model.ComentarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComentarioMapper {
    ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);

    ComentarioEntity mapRequestToEntity(ComentarioRequest request);

   default ComentarioEntity mapRequestToUpdateEntity(ComentarioRequest request, ComentarioEntity record){

      record.setTexto(request.getTexto());

       return record;

    }
}
