package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

/**
 * This class describes Education entity which stores the developer's university
 * degrees, department and schools information.
 * 
 * This Education entity has a many to one relationship with the UserInformation
 * entity
 * 
 * @author Andriy Luchko
 */
@Entity
@Table(name = "education")
public class Education extends Base {
    
    /**
     * Describes the university in which the developer studied.
     */
    @Column(name = "university")
    private String university;
    
    /**
     * Describes the degree which was gained.
     */
    @Column(name = "degreeReceived")
    private String degreeReceived;
    
    /**
     * Describes the name of a school.
     */
    @Column(name = "schoolName")
    private String schoolName;
    
    /**
     * Describes the name of a department.
     */
    @Column(name = "department")
    private String department;
    
    /**
     * Describes the year of graduation.
     */
    @Column(name = "graduatedInYear")
    private Long graduatedInYear;
    
    /**
     * Education associates with UserInformation. Many to one relationship,
     * references to usetInformation table
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "usetInformationId")
    private UserInformation usetInformation;
    
    /**
     * public constructor.
     */
    public Education() {
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
     * Sets the year when developer got a degree to graduatedInYear field.
     * 
     * @param newGraduatedInYear
     *            a year when developer got a degree.
     */
    public final void setGraduatedInYear(final Long newGraduatedInYear) {
        graduatedInYear = newGraduatedInYear;
    }
    
    /**
     * Changes information about user associated with these educational
     * characteristics.
     * 
     * @param newUsetInformation
     *            information about user.
     */
    public final void setUsetInformation(
            final UserInformation newUsetInformation) {
        usetInformation = newUsetInformation;
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
     * Get value of field graduatedInYear.
     * 
     * @return the year where developer was graduated
     */
    public final Long getGraduatedInYear() {
        return graduatedInYear;
    }
    
    /**
     * Gets information about user associated with these educational properties.
     * 
     * @return information about user associated with these educational
     *         properties.
     */
    public final UserInformation getUsetInformation() {
        return usetInformation;
    }
    
}
