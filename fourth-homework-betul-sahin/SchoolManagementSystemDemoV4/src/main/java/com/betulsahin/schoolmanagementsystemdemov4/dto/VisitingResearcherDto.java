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
@JsonTypeName("visitingResearcherDtoInput")
public class VisitingResearcherDto extends InstructorDto {

    @NotEmpty
   // @ApiModelProperty(example = "80")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int monthlyWorkingHours;

    @NotEmpty
   // @ApiModelProperty(example = "250.0")
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double hourlyRate;
}
