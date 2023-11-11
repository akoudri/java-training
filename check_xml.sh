#! /bin/bash

# xmllint --loaddtd src/main/resources/persons2.xml

xmllint --dtdvalid src/main/resources/persons.dtd src/main/resources/persons2.xml