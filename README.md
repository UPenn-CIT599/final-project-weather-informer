# final-project-weather-informer

***A weather informer that takes current weather info from the web and sends meaningful data analysis report to the user.*** </br>



__How to run our program__</br>


**Step 1:** Create a new Maven Project

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/1.png)

**Step 2:** Make sure to select 'Create a simple project'

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/2.png)

**Step 3:** Write 'finalproject' as Group Id and Artifact Id

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/3.png)

**Step 4:** Create a new java package in the Maven folder you just created and name it 'finalproject.finalproject'

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/step_4.png)

**Step 5:** Make sure that all the files from GitHub are copied in the package 'finalproject.finalproject' (including the csv files!)

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/step_5.png)

**Step 6:** Open the reference_pom.xml file in the package and copy the highlighted dependencies.

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/step_6.png)

```
<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version> <!-- Or whatever JUnit you're using. -->
		</dependency>
		<dependency>
			<groupId>com.mailjet</groupId>
			<artifactId>mailjet-client</artifactId>
			<version>4.2.0</version>
		</dependency>
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.5</version>
		</dependency>
	</dependencies>
```

**Step 7:** Open the pom.xml file created in Maven java project.

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/step_7.png)

**Step 8:** Paste dependencies copied from reference_pom.xml to pom.xml file. Your pom.xml file should look as shown below.

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/step_8.png)

**Step 9:** Once you SAVE the pom.xml file, your code will compile.

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/step_9.png)

**Step 10:** Open WeatherInformerRunner class and run the program! Weather Informer is now all ready to help you! :)

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/step_10.png)
