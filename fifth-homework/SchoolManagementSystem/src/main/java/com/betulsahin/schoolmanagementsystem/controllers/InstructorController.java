package com.betulsahin.schoolmanagementsystem.controllers;

import com.betulsahin.schoolmanagementsystem.dtos.InstructorDto;
import com.betulsahin.schoolmanagementsystem.models.InstructorServiceTransactionLogger;
import com.betulsahin.schoolmanagementsystem.models.abstracts.Instructor;
import com.betulsahin.schoolmanagementsystem.models.enums.SalaryUpdateType;
import com.betulsahin.schoolmanagementsystem.services.InstructorService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody InstructorDto request){
        Optional<Instructor> instructorOptional = instructorService.create(request);

        if(!instructorOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(instructorOptional.get(), HttpStatus.CREATED);
    }

    @GetMapping("/get-transactions-by-date")
    public ResponseEntity<Page<List<InstructorServiceTransactionLogger>>> getAllTransactionsWithDate(
            @ApiParam(value = "transaction query for salary update operations", example = "05/07/2021", required = true)
            @RequestParam String requestDate,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @PageableDefault(page=0, size=10)Pageable pageable){
        return new ResponseEntity<>(this.instructorService.getAllTransactionsWithDate(requestDate, pageNumber, pageSize, pageable), HttpStatus.OK);
    }

    @GetMapping("/get-transactions-by-instructor-id")
    public ResponseEntity<Page<List<InstructorServiceTransactionLogger>>> getAllTransactionsWithInstructorId(
            @RequestParam long instructorId,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize,
            @PageableDefault(page=0, size=10)Pageable pageable){
        return new ResponseEntity<>(this.instructorService.getAllTransactionsWithInstructorId(instructorId, pageNumber, pageSize, pageable), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDto>> getAll(){
        final List<InstructorDto> instructors = instructorService.findAll();

        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<InstructorDto> get(@PathVariable long id){
        final InstructorDto instructor = instructorService.findById(id);

        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Instructor> update(@RequestBody InstructorDto request){
        Optional<Instructor> instructorOptional = instructorService.update(request);

        if(!instructorOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(instructorOptional.get(), HttpStatus.OK);
    }

    @PutMapping("{id}/{salaryPercentage}/{salaryUpdateType}")
    public ResponseEntity<Instructor> updateSalary(@PathVariable long id,
                                                   @PathVariable double salaryPercentage,
                                                   @PathVariable SalaryUpdateType salaryUpdateType){
        Optional<Instructor> instructorOptional = instructorService.updateSalary(id, salaryPercentage, salaryUpdateType);

        if(!instructorOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(instructorOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        instructorService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
