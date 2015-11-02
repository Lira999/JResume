package com.softserveinc.ita.jresume.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Describe SoftServeUserInformation entity class.
 * 
 * @author Bohdan Khudoba
 */
@XmlRootElement(name = "userInformation")
@Entity
@Table(name = "softServeUserInformation")
public class SoftServeUserInformation extends UserInformation {
    
    /** Column for programmingLanguages. */
    @XmlElement
    @Column(name = "programmingLanguages")
    private String programmingLanguages;
    
    /** Column for technologies. */
    @XmlElement
    @Column(name = "technologies")
    private String technologies;
    
    /** Column for rdbms. */
    @XmlElement
    @Column(name = "rdbms")
    private String rdbms;
    
    /** Column for methodologies. */
    @XmlElement
    @Column(name = "methodologies")
    private String methodologies;
    
    /** Column for frameworks. */
    @XmlElement
    @Column(name = "frameworks")
    private String frameworks;
    
    /** Column for webServers. */
    @XmlElement
    @Column(name = "webServers")
    private String webServers;
    
    /** Column for tools. */
    @XmlElement
    @Column(name = "tools")
    private String tools;
    
    /** Column for testingTools. */
    @XmlElement
    @Column(name = "testingTools")
    private String testingTools;
    
    /** Column for operatingSystems. */
    @XmlElement
    @Column(name = "operatingSystems")
    private String operatingSystems;
    
    /** Column for hardware. */
    @XmlElement
    @Column(name = "hardware")
    private String hardware;
    
    /** Column for userInformation. */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userInformation")
    private UserInformation userInformation;
    
    /**
     * Constructor for SoftServeUserInformation.
     */
    public SoftServeUserInformation() {
        userInformation = super.getInstance();
    }
    
    /**
     * Get value of column programmingLanguages.
     * 
     * @return the programmingLanguages
     */
    public final String getProgrammingLanguages() {
        return programmingLanguages;
    }
    
    /**
     * Changes programmingLanguages value of this Programming Languages.
     * 
     * @param newProgrammingLanguages
     *            this programming languages new value
     */
    public final void setProgrammingLanguages(
            final String newProgrammingLanguages) {
        programmingLanguages = newProgrammingLanguages;
    }
    
    /**
     * Get value of column technologies.
     * 
     * @return the technologies
     */
    public final String getTechnologies() {
        return technologies;
    }
    
    /**
     * Changes technologies value of this Technologies.
     * 
     * @param newTechnologies
     *            this technologies new value
     */
    public final void setTechnologies(final String newTechnologies) {
        technologies = newTechnologies;
    }
    
    /**
     * Get value of column rdbms.
     * 
     * @return the rdbms
     */
    public final String getRdbms() {
        return rdbms;
    }
    
    /**
     * Changes rdbms value of this rdbms.
     * 
     * @param newRdbms
     *            this RDBMS new value
     */
    public final void setRdbms(final String newRdbms) {
        rdbms = newRdbms;
    }
    
    /**
     * Get value of column methodologies.
     * 
     * @return the methodologies
     */
    public final String getMethodologies() {
        return methodologies;
    }
    
    /**
     * Changes methodologies value of this Methodologies.
     * 
     * @param newMethodologies
     *            this methodologies new value
     */
    public final void setMethodologies(final String newMethodologies) {
        methodologies = newMethodologies;
    }
    
    /**
     * Get value of column frameworks.
     * 
     * @return the frameworks
     */
    public final String getFrameworks() {
        return frameworks;
    }
    
    /**
     * Changes frameworks value of this Frameworks.
     * 
     * @param newFrameworks
     *            this frameworks new value
     */
    public final void setFrameworks(final String newFrameworks) {
        frameworks = newFrameworks;
    }
    
    /**
     * Get value of column webServers.
     * 
     * @return the webServers
     */
    public final String getWebServers() {
        return webServers;
    }
    
    /**
     * Changes webServers value of this Web Servers.
     * 
     * @param newWebServers
     *            this web servers new value
     */
    public final void setWebServers(final String newWebServers) {
        webServers = newWebServers;
    }
    
    /**
     * Get value of column tools.
     * 
     * @return the tools
     */
    public final String getTools() {
        return tools;
    }
    
    /**
     * Changes tools value of this Tools.
     * 
     * @param newTools
     *            this tools new value
     */
    public final void setTools(final String newTools) {
        tools = newTools;
    }
    
    /**
     * Get value of column testingTools.
     * 
     * @return the testingTools
     */
    public final String getTestingTools() {
        return testingTools;
    }
    
    /**
     * Changes testingTools value of this Testing Tools.
     * 
     * @param newTestingTools
     *            this testing tools new value
     */
    public final void setTestingTools(final String newTestingTools) {
        testingTools = newTestingTools;
    }
    
    /**
     * Get value of column operatingSystems.
     * 
     * @return the operatingSystems
     */
    public final String getOperatingSystems() {
        return operatingSystems;
    }
    
    /**
     * Changes operatingSystems value of this Operating Systems.
     * 
     * @param newOperatingSystems
     *            this operating systems new value
     */
    public final void setOperatingSystems(final String newOperatingSystems) {
        operatingSystems = newOperatingSystems;
    }
    
    /**
     * Get value of column hardware.
     * 
     * @return the hardware
     */
    public final String getHardware() {
        return hardware;
    }
    
    /**
     * Changes hardware value of this Hardware.
     * 
     * @param newHardware
     *            this hardware new value
     */
    public final void setHardware(final String newHardware) {
        hardware = newHardware;
    }
    
    /**
     * Get value of column userInformation.
     * 
     * @return the userInformation
     */
    public final UserInformation getUserInformation() {
        return userInformation;
    }
    
    /**
     * Changes userInformation value of this User Information.
     * 
     * @param newUserInformation
     *            this userInformation new value
     */
    public final void setUserInformation(
            final UserInformation newUserInformation) {
        userInformation = newUserInformation;
    }
    
}
