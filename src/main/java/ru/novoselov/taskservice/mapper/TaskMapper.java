package ru.novoselov.taskservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.novoselov.taskservice.config.DefaultMapperConfig;
import ru.novoselov.taskservice.entity.Task;
import ru.novoselov.taskservice.model.request.CreateTaskRequest;

@Mapper(componentModel = "spring", config = DefaultMapperConfig.class)
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    Task toEntity(CreateTaskRequest taskRequest);
}
