# final-project-weather-informer

***A weather informer that takes current weather info from the web and send SMS to the user.***


***How to run our program*** <br />

Steps to make it work at your end, see below

1. Create a new Maven Project
![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/1.png)

2. Make sure to select 'Create a simple project'
![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/2.png)

3. Write 'finalproject' as Group Id and Artifact Id
![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/3.png)

4. In src/main/java, create a package named 'finalproject'.

5. In pom.xml file add the dependencies below
```
<dependencies>
		<dependency>
			<groupId>com.mailjet</groupId>
			<artifactId>mailjet-client</artifactId>
			<version>4.2.0</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.6</version>
		</dependency>
	</dependencies>
```
Your pom.xml file should look like this
![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/4.png)

6. If you tun the WeatherInformerRunner, you should get output in this form and email will be sent to the address entered by you.

![](https://github.com/UPenn-CIT599/final-project-weather-informer/blob/master/images/5.png)

***Our Design***

**Workflow** <br />
• Ask the user to enter a city name for which he/she wants the weather information. (Weather information provided will be based on the historical data and current weather information.)<br />
• Use it to query a freely available weather API (https://openweathermap.org/current) on the internet to retrieve current weather information.<br />
• Format data received. (Data from weather API will be in JSON format and historical data is in CSV format). Extract necessary information to display it on the user console<br />
• Historical weather data is retrieved from CSV file (obtained from https://rp5.ru/Weather_in_the_world)
• The weather information will address following queries-<br />
1. Clothing recommendation based on current weather<br />
2. Current temperature > x% days in 2018<br />
3. Difference between high and low > y% days in 2018<br />
4. Current humidity > z% days in 2018<br />
5. Current cloud cover < k% days in 2018<br />
6. Find the date/city with the most similar weather (by temp, humidity, cloud cover)<br />
7. What was the highest temperature experienced in the city in 2018? <br />
8. What was the lowest temperature experienced in the city in 2018? <br />
9. Standard deviation of the temperature in 2018.<br />
•Display it on console<br />
•Ask the user if they want information to be sent to them over an email (and maybe just the Clothing recommendation on a text (SMS) message)<br />
•Ask them to enter a phone number/email address. (phone no. restricted to the US numbers)<br />
•Use an available  email API (https://www.mailjet.com/email-api/) to send the information to the user.<br />

**We are planning to make the following classes to perform the tasks listed above:**<br />
(A: Attributes, M: Methods, CC: Coupled Classes)<br />
•	**WeatherInformerRunner**<br />
A: UserInteractor<br />
M: run(), main()<br />
CC: UserInteractor<br />

•	**UserInteractor**<br />
A: WeatherAPIClient, SMSAPIClient<br />
M: getZipcodeFromUser(), getPhoneNumFromUser()<br />
CC: WeatherAPIClient, SMSAPIClient<br />

•	**WeatherResponseFormatter**<br />
A: WeatherAPIClient<br />
M: convertToFahrenheit(), convertToCelsius()<br />
CC: WeatherAPIClient<br />

•	**WeatherAPIClient**<br />
A: WeatherResponse<br />
M: getWeatherFromAPI(), connectToWeatherAPI()<br />
CC: webWeatherAPI<br />

•	**SMSAPIClient**<br />
A: SMSMessage, phoneNum <br />
M: sendSMS(), connectToSMSAPI()<br />
CC: webSMSAPI<br />
