package com.betulsahin.schoolmanagementsystemdemov4.services;

import com.betulsahin.schoolmanagementsystemdemov4.dto.CourseRegistrationDto;
import com.betulsahin.schoolmanagementsystemdemov4.entities.CourseRegistration;
import com.betulsahin.schoolmanagementsystemdemov4.exceptions.StudentIsAlreadyRegisteredThisCourseExistException;
import com.betulsahin.schoolmanagementsystemdemov4.exceptions.StudentNumberForOneCourseExceededException;
import com.betulsahin.schoolmanagementsystemdemov4.mappers.CourseRegistrationMapper;
import com.betulsahin.schoolmanagementsystemdemov4.repositories.CourseRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.betulsahin.schoolmanagementsystemdemov4.utils.ErrorMessageConstants.*;

@Service
@RequiredArgsConstructor
public class CourseRegistrationService {
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseRegistrationMapper courseRegistrationMapper;

    /**
     * Creates a course registration for a student.
     *
     * @param request the request object of CourseRegistration
     * @return saved CourseRegistration object as Optional
     */
    public Optional<CourseRegistration> create(CourseRegistrationDto request){
        // Ogrenci bu kursa daha önce kayit olmus mu ?
        boolean registrationExist = courseRegistrationRepository.findByStudentIdAndCourseId(
                request.getStudentId(), request.getCourseId()).
                isPresent();

        if(registrationExist){
            String exceptionMessage = String.format(FOUND_REGISTERED_STUDENT, request.getStudentId());
            throw new StudentIsAlreadyRegisteredThisCourseExistException(exceptionMessage);

        }

        // Bu kursa kayit olan ogrenci sayisi 20'den fazla mi ?
        int studentCountOfRegistered = courseRegistrationRepository.
                findStudentCountByCourse(request.getCourseId());

        if(studentCountOfRegistered > 20){
            throw new StudentNumberForOneCourseExceededException(
                    String.format(COURSE_EXCEEDED, studentCountOfRegistered));
        }

        CourseRegistration savedRegistrations = courseRegistrationRepository.save(
                courseRegistrationMapper.map(request));

        return Optional.of(savedRegistrations);
    }
}