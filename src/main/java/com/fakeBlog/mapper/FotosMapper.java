package com.fakeBlog.mapper;

import com.fakeBlog.entity.FotosEntity;
import com.fakeBlog.model.FotosRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FotosMapper {

    FotosMapper INSTANCE = Mappers.getMapper(FotosMapper.class);

    FotosEntity mapRequestToEntity(FotosRequest request);

    default FotosEntity mapRequestToUpdateEntity(FotosRequest request, FotosEntity record){

        record.setUrl(request.getUrl());
        if(request.getGaleria_Id() != null)
        record.setGaleria_id(request.getGaleria_Id());

        return record;

    }
}
