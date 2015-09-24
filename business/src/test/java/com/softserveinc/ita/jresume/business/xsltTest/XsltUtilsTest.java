package com.softserveinc.ita.jresume.business.xsltTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.transform.TransformerException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserveinc.ita.jresume.business.xslt.XsltUtils;

/**
 * Tests for class {@link com.test.XsltUtils;}.
 * 
 * @author Golovii Sergii
 */
public class XsltUtilsTest {
    
    /**
     * Stands for file, which not exists in file system.
     */
    private File notExistingFile;
    
    /**
     * Stands for file, which cannot be created. (Starting from Windows 7 you
     * need to have administrator access to create files in root of system disk)
     */
    private File uncreatableFile;
    
    /**
     * Stands for file, which can be transformed in right way.
     */
    private File successFile;
    
    /**
     * Stands for existing output file.
     */
    private File output;
    
    /**
     * Stands for not existing output file.
     */
    private File notExistingOutput;
    
    /**
     * Stands for file with expected structure.
     */
    private File normalOutput;
    
    /**
     * Stands for file with incorrect extension.
     */
    private File incorrect;
    
    /**
     * Stands for xslt schema file.
     */
    private File xslt;
    
    /**
     * Method which initializes test files.
     */
    @Before
    public final void init() {
        notExistingFile = new File(
                "src/test/resources/testFiles/xsltTestFiles"
                        + "/sayHelloToMyLittleFriend.txt");
        uncreatableFile = new File("C:\\1.txt");
        successFile = new File(
                "src/test/resources/testFiles/xsltTestFiles/input.xml");
        output = new File(
                "src/test/resources/testFiles/xsltTestFiles/output.html");
        notExistingOutput = new File(
                "src/test/resources/testFiles/xsltTestFiles/testFile.html");
        normalOutput = new File(
                "src/test/resources/testFiles/xsltTestFiles/normalOut.html");
        incorrect = new File(
                "src/test/resources/testFiles/xsltTestFiles/normalOut.html");
        xslt = new File(
                "src/test/resources/testFiles/xsltTestFiles/schema.xslt");
    }
    
    /**
     * Test, which runs {@link com.test.XsltUtils#transform} with not existing
     * input file. FileNotFoundException expected.
     * 
     * @throws NullPointerException
     *             in case of not initialized files
     * @throws FileNotFoundException
     *             in case of not founded files input or schema files
     * @throws IOException
     *             in case of wrong file extensions or during creating output
     *             file
     * @throws TransformerException
     *             in case of transformation error
     */
    @Test(expected = FileNotFoundException.class)
    public final void tesNotExistingFile()
            throws TransformerException, FileNotFoundException, IOException {
        XsltUtils.transform(notExistingFile, xslt, output);
    }
    
    /**
     * Test, which runs {@link com.test.XsltUtils#transform} with output file,
     * that cannot be created. IOException expected.
     * 
     * @throws NullPointerException
     *             in case of not initialized files
     * @throws FileNotFoundException
     *             in case of not founded files input or schema files
     * @throws IOException
     *             in case of wrong file extensions or during creating output
     *             file
     * @throws TransformerException
     *             in case of transformation error
     */
    @Test(expected = IOException.class)
    public final void testUncreatableFile()
            throws TransformerException, FileNotFoundException, IOException {
        XsltUtils.transform(successFile, xslt, uncreatableFile);
    }
    
    /**
     * Test, which runs {@link com.test.XsltUtils#transform} with not existing
     * output file, method should create file.
     * 
     * @throws NullPointerException
     *             in case of not initialized files
     * @throws FileNotFoundException
     *             in case of not founded files input or schema files
     * @throws IOException
     *             in case of wrong file extensions or during creating output
     *             file
     * @throws TransformerException
     *             in case of transformation error
     */
    @Test
    public final void testNotExistingOutput()
            throws TransformerException, FileNotFoundException, IOException {
        XsltUtils.transform(successFile, xslt, notExistingOutput);
        Assert.assertTrue(notExistingOutput.exists());
    }
    
    /**
     * Test, which runs {@link com.test.XsltUtils#transform} with incorrect
     * input file. IOException expected.
     * 
     * @throws NullPointerException
     *             in case of not initialized files
     * @throws FileNotFoundException
     *             in case of not founded files input or schema files
     * @throws IOException
     *             in case of wrong file extensions or during creating output
     *             file
     * @throws TransformerException
     *             in case of transformation error
     */
    @Test(expected = IOException.class)
    public final void testIncorrectExtension()
            throws TransformerException, FileNotFoundException, IOException {
        XsltUtils.transform(incorrect, incorrect, notExistingOutput);
    }
    
    /**
     * Test, which checks transformation process.
     * 
     * @throws NullPointerException
     *             in case of not initialized files
     * @throws FileNotFoundException
     *             in case of not founded files input or schema files
     * @throws IOException
     *             in case of wrong file extensions or during creating output
     *             file
     * @throws TransformerException
     *             in case of transformation error
     */
    @Test
    public final void testTranformation()
            throws TransformerException, FileNotFoundException, IOException {
        XsltUtils.transform(successFile, xslt, output);
        byte[] expecteds =
                Files.readAllBytes(Paths.get(normalOutput.getAbsolutePath()));
        byte[] actuals =
                Files.readAllBytes(Paths.get(output.getAbsolutePath()));
        Assert.assertArrayEquals(expecteds, actuals);
    }
    
    /**
     * Remove temporary files after tests.
     */
    @After
    public final void close() {
        notExistingOutput.delete();
        
    }
}
