package com.betulsahin.schoolmanagementsystem.mappers;

import com.betulsahin.schoolmanagementsystem.dto.LogDto;
import com.betulsahin.schoolmanagementsystem.entities.Log;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogMapper {
    LogDto mapToDto(Log log);
}
