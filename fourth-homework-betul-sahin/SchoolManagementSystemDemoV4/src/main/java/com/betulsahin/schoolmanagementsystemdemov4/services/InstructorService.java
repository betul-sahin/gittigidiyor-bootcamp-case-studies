package com.betulsahin.schoolmanagementsystemdemov4.services;

import com.betulsahin.schoolmanagementsystemdemov4.dto.InstructorDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.Instructor;
import com.betulsahin.schoolmanagementsystemdemov4.exceptions.InstructorIsAlreadyExistException;
import com.betulsahin.schoolmanagementsystemdemov4.mappers.InstructorMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repositories.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.betulsahin.schoolmanagementsystemdemov4.utils.ErrorMessageConstants.FOUND_INSTRUCTOR;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    /**
     * creates an instructor to database.
     *
     * @param request the request object of instructor
     * @return saved instructor as optional
     */
    @Transactional
    public Optional<Instructor> create(InstructorDto request) {
        boolean instructorExist = instructorRepository.
                findByPhoneNumber(request.getPhoneNumber()).
                isPresent();

        if (instructorExist) {
            throw new InstructorIsAlreadyExistException(
                    String.format(FOUND_INSTRUCTOR, request.getPhoneNumber()));
        }

        Instructor savedInstructor = instructorRepository.save(
                instructorMapper.map(request));

        return Optional.of(savedInstructor);
    }

    /**
     * gets all instructor from database.
     *
     * @return a list of instructor
     */
    @Transactional(readOnly = true)
    public List<InstructorDto> findAll() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::mapToDto)
                .collect(Collectors.toList());
    }
}

