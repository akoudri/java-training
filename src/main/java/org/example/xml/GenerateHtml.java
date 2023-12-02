package org.example.xml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.Objects;

public class GenerateHtml {

    public static void main(String[] args) {
        try {
            // Load the XML and XSLT files
            File xmlFile = new File(Objects.requireNonNull(GenerateHtml.class.getResource("/music.xml")).getPath());
            File xsltFile = new File(Objects.requireNonNull(GenerateHtml.class.getResource("/music.xslt")).getPath());

            // Create the TransformerFactory
            TransformerFactory factory = TransformerFactory.newInstance();

            // Create the transformer
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Define the output file
            File outputFile = new File("/tmp/music.html");

            // Perform the transformation
            transformer.transform(new StreamSource(xmlFile), new StreamResult(outputFile));

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

}
