package com.betulsahin.schoolmanagementsystemdemov4.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("permanentInstructorDto")
public class PermanentInstructorDto extends InstructorDto {

    @NotEmpty
   // @ApiModelProperty(example = "12500.0")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double salary;
}
