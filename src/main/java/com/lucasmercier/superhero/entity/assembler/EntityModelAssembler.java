package com.lucasmercier.superhero.entity.assembler;

import com.lucasmercier.superhero.entity.BaseEntity;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class EntityModelAssembler<T extends BaseEntity> implements RepresentationModelAssembler<T, EntityModel<T>> {

    @SneakyThrows
    @NotNull
    @Override
    public EntityModel<T> toModel(T entity) {
        ControllerLink controllerLink = entity.getClass().getAnnotation(ControllerLink.class);
        return EntityModel.of(
                entity,
                linkTo(controllerLink.controller().getMethod("get", int.class), entity.getId()).withSelfRel(),
                linkTo(controllerLink.controller()).withRel("all")
        );
    }

    @NotNull
    @Override
    public CollectionModel<EntityModel<T>> toCollectionModel(@NotNull Iterable<? extends T> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
