package generated.net.webservicex.models;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="NewDataSet")
public class NewDataSet {
	
	@XmlElement(name = "Table")
	private Table[] Table;

	public Table[] getTable() {
		return Table;
	}

	public void setTable(Table[] Table) {
		this.Table = Table;
	}

	@Override
	public String toString() {
		return "[Table = " + Table + "]";
	}
}