package com.softserveinc.ita.jresume.business.xsltTransfromerTests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.softserveinc.ita.jresume.business.xslt.XsltTransformer;
import com.softserveinc.ita.jresume.business.xslt.XstlTransformerException;

/**
 * Tests for {@link com.softserveinc.ita.jresume.business.xslt.XsltTransformer}.
 * 
 * @author Golovii Sergii
 */
public class XsltTransfromerTest {
    
    /**
     * {@link com.softserveinc.ita.jresume.business.xslt.XsltTransformer}
     * instance.
     */
    private XsltTransformer xsltTransformer;
    
    /**
     * Stands for file with schema.
     */
    private File schema;
    
    /**
     * Stands for output file.
     */
    private File output;
    
    /**
     * Initialize test data.
     * 
     * @throws IOException
     *             in case of errors during creating test files
     */
    @Before
    public final void init() throws IOException {
        schema = new File(
                "src/test/resources/testFiles/xsltTestFiles/testSchema.xsl");
        xsltTransformer = new XsltTransformer();
        output = new File(
                "src/test/resources/testFiles/xsltTestFiles/output");
        if (!output.exists()) {
            output.createNewFile();
        }
    }
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.xslt.
     * 
     * XsltTransformer#transform} with not correct schema file.
     * XstlTransformerException expected.
     * 
     * @throws XstlTransformerException
     *             in case of wrong input parameters or during transformation
     *             process.
     * @throws IOException
     *             in case of IO errors
     */
    @Test(expected = XstlTransformerException.class)
    public final void testWrongSchema()
            throws XstlTransformerException, IOException {
        xsltTransformer.transform(
                new FileInputStream(
                        "src/test/resources/testFiles/xsltTestFiles/input.xml"),
                new File(
                        "src/test/resources/testFiles/xsltTestFiles/input.xml"),
                new ByteArrayOutputStream());
    }
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.xslt.
     * 
     * XsltTransformer#transform} with not initialized schema file.
     * NullPointerException expected.
     * 
     * @throws XstlTransformerException
     *             in case of wrong input parameters or during transformation
     *             process.
     * @throws IOException
     *             in case of IO errors
     */
    @Test(expected = NullPointerException.class)
    public final void testNullPointer()
            throws XstlTransformerException {
        xsltTransformer.transform(new ByteArrayInputStream(new byte[] {}),
                null, null);
        xsltTransformer.transform(new ByteArrayInputStream(new byte[] {}),
                null, new ByteArrayOutputStream());
        xsltTransformer.transform(null, null, null);
    }
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.xslt.
     * 
     * XsltTransformer#transform} with not valid input/output data.
     * XstlTransformerException expected.
     * 
     * @throws XstlTransformerException
     *             in case of wrong input parameters or during transformation
     *             process.
     * @throws IOException
     *             in case of IO errors
     */
    @Test(expected = XstlTransformerException.class)
    public final void testTransformerException()
            throws XstlTransformerException, IOException {
        xsltTransformer.transform(null, schema, null);
        xsltTransformer.transform(new FileInputStream(
                "src/test/resources/testFiles/xsltTestFiles/input.xml"), schema,
                null);
        xsltTransformer.transform(null, schema, new ByteArrayOutputStream());
    }
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.xslt.
     * 
     * XsltTransformer#transform} with valid parameters.
     * 
     * @throws XstlTransformerException
     *             in case of wrong input parameters or during transformation
     *             process.
     * @throws IOException
     *             in case of IO errors
     */
    @Test
    public final void testTransformation()
            throws XstlTransformerException, IOException {
        xsltTransformer.transform(
                new FileInputStream(
                        "src/test/resources/testFiles/xsltTestFiles/input.xml"),
                schema,
                new FileOutputStream(output));
        File expectedOutputWin = new File(
                "src/test/resources/testFiles/xsltTestFiles/outputWin");
        File expectedOutputUnix = new File(
                "src/test/resources/testFiles/xsltTestFiles/outputUnix");
        byte[] expectedWin = Files.readAllBytes(expectedOutputWin.toPath());
        byte[] exectedUnix = Files.readAllBytes(expectedOutputUnix.toPath());
        byte[] actual = Files.readAllBytes(output.toPath());
        Assert.assertTrue(Arrays.equals(expectedWin, actual)
                || Arrays.equals(exectedUnix, actual));
    }
    
    /**
     * Clean test directory after all tests.
     */
    @After
    public final void cleanUp() {
        output.delete();
    }
    
}
