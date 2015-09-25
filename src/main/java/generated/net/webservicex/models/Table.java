package generated.net.webservicex.models;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="Table")
public class Table {
	
	@XmlElement(name = "Country")
	private String Country;

	@XmlElement(name = "City")
	private String City;

	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String City) {
		this.City = City;
	}

	@Override
	public String toString() {
		return "[Country = " + Country + ", City = " + City + "]";
	}
}