import java.io.Serializable;

public class CarriageBolt extends Bolt implements Serializable{
	private static final long serialVersionUID = 1181646945813279233L;

	public CarriageBolt(double length, String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener {
		super(length, diameterThreadSize, material, finish, unitPrice, numberPerUnit);
	} // end CarriageBolt constructor
}
