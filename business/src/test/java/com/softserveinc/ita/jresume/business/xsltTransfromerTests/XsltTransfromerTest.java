package com.softserveinc.ita.jresume.business.xsltTransfromerTests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
     * Initialize test data.
     */
    @Before
    public final void init() {
        schema = new File(
                "src/test/resources/testFiles/xsltTestFiles/testSchema.xsl");
        xsltTransformer = new XsltTransformer();
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
     *             in case of wrong input file format
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
     *             in case of wrong input file format
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
     *             in case of wrong input file format
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
     * 709 is output file length in case of using Unix way line endings (\n,
     * github using this). In case of Windows way(\n\r) value should be bigger.
     */
    private final int normalTestFileSize = 709;
    
    /**
     * Runs {@link com.softserveinc.ita.jresume.business.xslt.
     * 
     * XsltTransformer#transform} with valid parameters.
     * 
     * @throws XstlTransformerException
     *             in case of wrong input parameters or during transformation
     *             process.
     * @throws IOException
     *             in case of wrong input file format
     */
    @Test
    public final void testTransformation()
            throws XstlTransformerException, IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        xsltTransformer.transform(new FileInputStream(
                "src/test/resources/testFiles/xsltTestFiles/input.xml"), schema,
                out);
        byte[] arr = out.toByteArray();
        Assert.assertTrue(arr.length >= normalTestFileSize);
    }
    
}
