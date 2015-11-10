package com.softserveinc.ita.jresume.business.generatorTests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.softserveinc.ita.jresume.business.converter.XMLConverter;
import com.softserveinc.ita.jresume.business.generator.ResumeGenerator;
import com.softserveinc.ita.jresume.business.generator.ResumeGeneratorException;
import com.softserveinc.ita.jresume.business.xslt.XsltTransformer;
import com.softserveinc.ita.jresume.common.dto.TemplateDTO;
import com.softserveinc.ita.jresume.common.entity.Education;
import com.softserveinc.ita.jresume.common.entity.Project;
import com.softserveinc.ita.jresume.common.entity.Template;
import com.softserveinc.ita.jresume.common.entity.UserInformation;

/**
 * Tests for {@link com.softserveinc.ita.jresume.business.xslt.XsltTransformer}.
 * 
 * @author Andriy Zykhor
 */
public class ResumeGeneratorTest {
    
    /**
     * {@link com.softserveinc.ita.jresume.business.generator.ResumeGenerator}
     * instance.
     */
    private ResumeGenerator resumeGenerator;
    
    /**
     * {@link com.softserveinc.ita.jresume.common.entity.UserInformation}
     * instance.
     */
    private UserInformation userInformation;
    
    /**
     * {@link com.softserveinc.ita.jresume.common.entity.Template} instance.
     */
    private TemplateDTO template;
    
    /**
     * Stands for output file.
     */
    private File output;
    
    /**
     * Initialize test data.
     */
    @Before
    public final void init() {
        output = new File(
                "src/test/resources/testFiles/generatorTestFiles/output.html");
        
        resumeGenerator = new ResumeGenerator();
        ReflectionTestUtils.setField(resumeGenerator, "xsltTransformer",
                new XsltTransformer());
        ReflectionTestUtils.setField(resumeGenerator, "xmlConverter",
                new XMLConverter());
        ReflectionTestUtils.setField(resumeGenerator, "uploadPath",
                "src/test/resources/testFiles/generatorTestFiles");
                
        template = new TemplateDTO();
        template.setName("testTemplate");
        
        userInformation = new UserInformation();
        
        // Set test data
        userInformation.setFirstName("Gordon");
        userInformation.setLastName("Freeman");
        userInformation.setPosition("Some position...");
        userInformation.setSummary(
                "Describe your professional background and skills relevant...");
        
        List<Education> educations = new ArrayList<>();
        Education edu = new Education();
        edu.setDegreeReceived("Some degree");
        edu.setSchoolName("School 123");
        edu.setDepartment("Departement 123");
        edu.setUserInformation(userInformation);
        educations.add(edu);
        
        List<Project> projects = new ArrayList<>();
        Project project = new Project();
        project.setRole("Team leader");
        project.setDescription("Some description.");
        project.setCustomer("Some firm");
        project.setUserInformation(userInformation);
        projects.add(project);
        
        project = new Project();
        project.setRole("Developer");
        project.setDescription("Another description.");
        project.setCustomer("Another firm");
        project.setUserInformation(userInformation);
        projects.add(project);
        
        userInformation.setEducation(educations);
        userInformation.setProjects(projects);
    }
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.generator.
     * 
     * ResumeGenerator#generate} with incorrect parameters.
     * ResumeGeneratorException expected.
     * 
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process.
     */
    @Test(expected = ResumeGeneratorException.class)
    public final void testNullPointer() throws ResumeGeneratorException {
        resumeGenerator.generate(userInformation, null);
        resumeGenerator.generate(null, template);
        resumeGenerator.generate(null, null);
    }
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.generator.
     * 
     * ResumeGenerator#generate} with not correct schema file.
     * ResumeGeneratorException expected.
     * 
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process.
     */
    @Test(expected = ResumeGeneratorException.class)
    public final void testTemplate() throws ResumeGeneratorException {
        TemplateDTO wrongTemplate = new TemplateDTO();
        wrongTemplate.setName("wrongName");
        resumeGenerator.generate(userInformation, wrongTemplate);
    }
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.xslt.
     * 
     * XsltTransformer#transform} with valid parameters.
     * 
     * @throws ResumeGeneratorException
     *             in case of wrong input parameters or during generation
     *             process.
     * @throws IOException
     *             in case of IO errors
     */
    @Test
    public final void testGeneration() throws ResumeGeneratorException,
            IOException {
        ByteArrayOutputStream os = (ByteArrayOutputStream) resumeGenerator
                .generate(userInformation, template);
        os.writeTo(new FileOutputStream(output));
        
        File expectedOutputWin = new File("src/test/resources/testFiles"
                + "/generatorTestFiles/outputWin.html");
        File expectedOutputUnix = new File("src/test/resources/testFiles/"
                + "generatorTestFiles/outputUnix.html");
        byte[] expectedWin = Files.readAllBytes(expectedOutputWin.toPath());
        byte[] exectedUnix = Files.readAllBytes(expectedOutputUnix.toPath());
        byte[] actual = Files.readAllBytes(output.toPath());
        Assert.assertTrue(Arrays.equals(expectedWin, actual) || Arrays.equals(
                exectedUnix, actual));
    }
    
    /**
     * Clean test directory after all tests.
     */
    @After
    public final void cleanUp() {
        output.delete();
    }
    
}
