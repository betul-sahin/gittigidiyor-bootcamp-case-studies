package com.betulsahin.schoolmanagementsystem.services;

import com.betulsahin.schoolmanagementsystem.dto.CourseDto;
import com.betulsahin.schoolmanagementsystem.entities.Course;
import com.betulsahin.schoolmanagementsystem.exceptions.CourseIsAlreadyExistException;
import com.betulsahin.schoolmanagementsystem.exceptions.CourseNotFoundException;
import com.betulsahin.schoolmanagementsystem.mappers.CourseMapper;
import com.betulsahin.schoolmanagementsystem.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.betulsahin.schoolmanagementsystem.utils.ErrorMessageConstants.COURSE_NOT_FOUND;
import static com.betulsahin.schoolmanagementsystem.utils.ErrorMessageConstants.FOUND_COURSE;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    /**
     * creates a course to database.
     *
     * @param request the request object of course
     * @return saved course object as Optional
     */
    @Transactional
    public Optional<Course> create(CourseDto request) {
        boolean courseExist = courseRepository.findByCode(request.getCode()).
                isPresent();

        if(courseExist){
            throw new CourseIsAlreadyExistException(
                    String.format(FOUND_COURSE, request.getCode()));
        }

        Course savedCourse = courseRepository.save(
                courseMapper.map(request));

        return Optional.of(savedCourse);
    }

    /**
     * finds course object by id.
     *
     * @param id the identity of the course
     * @return the found course
     */
    @Transactional(readOnly = true)
    public Course findById(long id){
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(
                String.format(COURSE_NOT_FOUND, id)));
    }
}