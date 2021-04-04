package com.fakeBlog.mapper;

import com.fakeBlog.entity.GaleriaEntity;
import com.fakeBlog.model.GaleriaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GaleriaMapper {
    GaleriaMapper INSTANCE = Mappers.getMapper(GaleriaMapper.class);

    GaleriaEntity mapRequestToEntity(GaleriaRequest request);

    default GaleriaEntity mapRequestToUpdateEntity(GaleriaRequest request,GaleriaEntity entity){

        entity.setTitulo(request.getTitulo());

        return entity;

    }
}
