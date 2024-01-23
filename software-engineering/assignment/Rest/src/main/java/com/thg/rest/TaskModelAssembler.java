package com.thg.rest;

import jdk.incubator.foreign.CLinker;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TaskModelAssembler implements RepresentationModelAssembler<Task, EntityModel<Task>> {

    @Override
    public EntityModel<Task> toModel (Task task) {

        return EntityModel.of(task,
                linkTo(methodOn(TaskController.class).one(task.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).all()).withRel("tasks"));
    }



}
