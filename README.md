# basic_example_selenium_maven
1. install maven:

   sudo apt-get install maven

2. create a new empty project:

mvn archetype:generate -DgroupId=com.example -DartifactId=my-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

3. add selenium dependency to the pom.xml file:

    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>

4. add browsers from internet:

     <dependency>
       	    <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.0.3</version>
    	</dependency>

5. mvn clean package
6. java -jar target/client_selenium-1.0-SNAPSHOT.jar
