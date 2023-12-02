package org.example.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Objects;

public class Music {

    public static void main(String[] args) {
        try {
            // Initialize the XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(Objects.requireNonNull(Music.class.getResource("/music.xml")).getPath());

            // Extract the 'band' elements
            NodeList bandNodes = doc.getElementsByTagName("band");

            for (int i = 0; i < bandNodes.getLength(); i++) {
                Element band = (Element) bandNodes.item(i);

                // Check if the band's name is 'The DOORS'
                if ("The DOORS".equals(band.getAttribute("name"))) {
                    // Extract the 'artist' elements
                    NodeList artistNodes = band.getElementsByTagName("artist");

                    for (int j = 0; j < artistNodes.getLength(); j++) {
                        Element artist = (Element) artistNodes.item(j);
                        String firstName = artist.getAttribute("firstName");
                        String lastName = artist.getAttribute("lastName");

                        // Print the concatenated name with a newline
                        System.out.println(firstName + " " + lastName + "\n");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
