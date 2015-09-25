package weather.webserviceX_client;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import generated.net.webservicex.GetCitiesByCountry;
import generated.net.webservicex.GetWeather;
import generated.net.webservicex.GetWeatherResponse;
import generated.net.webservicex.GlobalWeather;
import generated.net.webservicex.GlobalWeatherSoap;
import generated.net.webservicex.ObjectFactory;
import generated.net.webservicex.models.CurrentWeather;
import generated.net.webservicex.models.NewDataSet;
import generated.net.webservicex.models.Table;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		try {
			
			GlobalWeather weatherService = new GlobalWeather();
			GlobalWeatherSoap weatherSoap = weatherService.getGlobalWeatherSoap();
	
			String result = weatherSoap.getCitiesByCountry("Romania");

			try {
				JAXBContext jaxbContext = JAXBContext.newInstance(NewDataSet.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				NewDataSet cityOfCountry = (NewDataSet) jaxbUnmarshaller.unmarshal(new StringReader(result));
				
				//Print cities of selected country 
				System.out.println("Cities of Romania:");
				for(Table t : cityOfCountry.getTable()){
					System.out.println(t);
				}
				
			} catch (javax.xml.bind.JAXBException e1) {
				System.out.println(e1);
			}

			String result2 = weatherSoap.getWeather("Bucuresti", "Romania");

			try {
				
				JAXBContext jaxbContext = JAXBContext.newInstance(CurrentWeather.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				CurrentWeather cityWeather = (CurrentWeather) jaxbUnmarshaller
						.unmarshal(new StringReader(result2));
				
				//Print weather of selected city
				System.out.println("Weather for Bucuresti(Romania):");
				System.out.println(cityWeather);
			
			} catch (javax.xml.bind.JAXBException e1) {
				System.out.println(e1);
			}

		} catch (Exception e) {
			// LOGGER.error("An exception occurred, exiting", e);
		}
	}
}
