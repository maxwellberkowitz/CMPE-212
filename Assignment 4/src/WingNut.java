import java.io.Serializable;

public class WingNut extends Nut implements Serializable{
	private static final long serialVersionUID = -9122403307618676481L;

	public WingNut(String diameterThreadSize, String material, String finish, double unitPrice, int numberPerUnit) throws IllegalFastener{
		super(diameterThreadSize, material, finish, unitPrice, numberPerUnit);
	}
}