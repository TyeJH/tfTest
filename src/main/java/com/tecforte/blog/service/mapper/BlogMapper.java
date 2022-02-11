package com.tecforte.blog.service.mapper;

import com.tecforte.blog.domain.*;
import com.tecforte.blog.service.dto.BlogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Blog} and its DTO {@link BlogDTO}.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface BlogMapper extends EntityMapper<BlogDTO, Blog> {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.login", target = "userLogin")
    @Mapping(target = "entryCount", expression = "java(blog.getEntries().size())")
    @Mapping(target = "entryDTO", expression = "java(blog.getEntries())" )
    BlogDTO toDto(Blog blog);

    @Mapping(target = "removeEntry", ignore = true)
    @Mapping(source = "userId", target = "user")
    @Mapping(target = "entries", expression = "java(blogDTO.getEntryDTO())")
    Blog toEntity(BlogDTO blogDTO);

    default Blog fromId(Long id) {
        if (id == null) {
            return null;
        }
        Blog blog = new Blog();
        blog.setId(id);
        return blog;
    }
}
