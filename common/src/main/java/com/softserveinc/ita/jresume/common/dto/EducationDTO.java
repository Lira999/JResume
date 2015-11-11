package com.softserveinc.ita.jresume.common.dto;

/**
 * Data Transfer Object for Education entity.
 * 
 * @author Bohdan Khudoba.
 * 
 */
public class EducationDTO extends BaseDTO {
    
    /**
     * Education Id.
     */
    private Long id;
    
    /**
     * Describes the university in which the developer studied.
     */
    private String university;
    
    /**
     * Describes the degree which was gained.
     */
    private String degreeReceived;
    
    /**
     * Describes the name of a school.
     */
    private String schoolName;
    
    /**
     * Describes the name of a department.
     */
    private String department;
    
    /**
     * Describes the year of graduation.
     */
    private Short graduationYear;
    
    /**
     * Id associated with UserInformation.
     */
    private Long userInformationId;
    
    /**
     * Gets userInformationId.
     * 
     * @return userInformationId.
     */
    public final Long getUserInformationId() {
        return userInformationId;
    }
    
    /**
     * Changes userInformationId.
     * 
     * @param newUserInformationId
     *            new userInformationId.
     */
    public final void setUserInformationId(final Long newUserInformationId) {
        userInformationId = newUserInformationId;
    }
    
    /**
     * Sets the university name.
     * 
     * @param newUniversity
     *            a name of a university in which the developer studied.
     */
    public final void setUniversity(final String newUniversity) {
        university = newUniversity;
    }
    
    /**
     * Sets the received degree.
     * 
     * @param newDegreeReceived
     *            a year when developer got a degree
     */
    public final void setDegreeReceived(final String newDegreeReceived) {
        degreeReceived = newDegreeReceived;
    }
    
    /**
     * Sets the name of a school to schoolName field.
     * 
     * @param newSchoolName
     *            a name or brief description of a school in which the developer
     *            studied.
     */
    public final void setSchoolName(final String newSchoolName) {
        schoolName = newSchoolName;
    }
    
    /**
     * Sets the name of department to department field.
     * 
     * @param newDepartment
     *            a name or brief description of a department in which the
     *            developer studied.
     */
    public final void setDepartment(final String newDepartment) {
        department = newDepartment;
    }
    
    /**
     * Sets the year when developer got a degree to graduationYear field.
     * 
     * @param newgraduationYear
     *            a year when developer got a degree.
     */
    public final void setGraduationYear(final Short newgraduationYear) {
        graduationYear = newgraduationYear;
    }
    
    /**
     * Get value of field university.
     * 
     * @return the name of a university
     */
    public final String getUniversity() {
        return university;
    }
    
    /**
     * Get value of field degreeReceived.
     * 
     * @return the degree which was gained by developer
     */
    public final String getDegreeReceived() {
        return degreeReceived;
    }
    
    /**
     * Get value of field schoolName.
     * 
     * @return the name and brief description of a school which was finished by
     *         developer
     */
    public final String getSchoolName() {
        return schoolName;
    }
    
    /**
     * Get value of field department.
     * 
     * @return the name and brief description of a department which was finished
     *         by developer in university
     */
    public final String getDepartment() {
        return department;
    }
    
    /**
     * Get value of field graduationYear.
     * 
     * @return the year where developer was graduated
     */
    public final Short getGraduationYear() {
        return graduationYear;
    }
    
    /**
     * Get value of id.
     * 
     * @return id of this Education.
     */
    public final Long getId() {
        return id;
    }
    
    /**
     * Change value of this id.
     * 
     * @param newId
     *            id of this Education to be changed.
     */
    public final void setId(final Long newId) {
        id = newId;
    }
    
}
