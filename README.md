# final-project-weather-informer
***Our Design***

A weather informer that takes current weather info from the web and send SMS to the user.

**Workflow** <br />
• Ask the user to enter a city name for which he/she wants weather information. (Weather information provided will be based on the historical data and current weather information.)<br />
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
•Use an available  email API (https://www.mailjet.com/email-api/) / SMS text messaging API(https://www.twilio.com/docs/sms/quickstart/java) to send the information to the user.<br />

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
