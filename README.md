Task
Write code for Lab 2

MedicalProfession. Implement a hierarchy of performances that can take place in a medical profession
Draw a UML class diagram
Use java code convention
CLasses must be distributed in packages
Work with console must be minimal
Code must contain only that classes that are described in the diagram
Sorting must use java built-in methods
Sorting must be implemented in separate method
No static methods/attributes are allowed (the only exception is a main method)
You must use an Enum
Code must be in a separate branch with PR
Comparison must be implemented using lambdas
Instead of getters/setters you should use @Data annotation from lombok
Use maven and Jococo(in build section), FindBugs, PMD, CheckStyle plugins(reporting section)
Run mvn site and fix errors reported by checkstyle, pmd and findbugs

To run:

git clone
mvn install
run target.performances-1.0-SNAPSHOT.jar
mvn compile
mvn checkstyle:check
mvn findbugs:gui
mvn pmd:pmd