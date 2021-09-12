package com.betulsahin.schoolmanagementsystemdemov4.mappers;

import com.betulsahin.schoolmanagementsystemdemov4.dto.LogDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Log;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LogMapper {
    LogDto mapToDto(Log log);
}
