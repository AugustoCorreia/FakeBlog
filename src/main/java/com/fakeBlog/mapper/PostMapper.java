package com.fakeBlog.mapper;

import com.fakeBlog.entity.ComentarioEntity;
import com.fakeBlog.entity.PostEntity;
import com.fakeBlog.model.ComentarioRequest;
import com.fakeBlog.model.PostRequest;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostEntity mapRequestToPost(PostRequest post);

    default PostEntity mapRequestToUpdatePost(PostRequest request, PostEntity post){
        if(!ObjectUtils.isEmpty(request)){
            if (!ObjectUtils.isEmpty(request.getImg())) post.setImg(request.getImg());
            if (!ObjectUtils.isEmpty(request.getLink())) post.setLink(request.getLink());
            if (!ObjectUtils.isEmpty(request.getTitulo())) post.setTitulo(request.getTitulo());
            if (!ObjectUtils.isEmpty(request.getTexto())) post.setTexto(request.getTexto());
        }
        return post;

    }
    default List<ComentarioEntity> getComentarioFromRequest(List<ComentarioRequest> requestList){
       return requestList.stream().map(request -> {
           return new ComentarioEntity().builder()
                   .texto(request.getTexto())
                   .user_id(request.getUser_id())
                   .build();
       }).collect(Collectors.toList());
    }
}
