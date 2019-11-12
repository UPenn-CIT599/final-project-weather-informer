# final-project-weather-informer
***Our Design***

A weather informer that takes current weather info from the web and send SMS to the user.

**Workflow** <br />
•	Ask the user to enter a zip code or city name.<br />
•	Use it to query a freely available weather API (https://openweathermap.org/current) on the internet to retrieve current weather information. <br />
•	Format data received. (Data from weather API will be in JSON format). Extract necessary information to display it on the user console. <br />
•	Ask the user if they want it to be sent to them over a text (SMS) message/email. <br />
•	If they say yes to either or both, ask them to enter a phone number/email address. (phone no. restricted to the US numbers) <br />
•	Use an available SMS text messaging API(https://www.twilio.com/docs/sms/quickstart/java) / email API (https://www.mailjet.com/email-api/) to send the information to the user. <br />

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
