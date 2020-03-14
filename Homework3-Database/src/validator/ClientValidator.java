package validator;
import model.Client;

public class ClientValidator implements Validator<Client> {
	private static final int MIN_AGE = 8;
	private static final int MAX_AGE = 80;

	@Override
	public void validate(Client c) {
		// TODO Auto-generated method stub
		if (c.getAge() < MIN_AGE || c.getAge() > MAX_AGE) {  
			throw new IllegalArgumentException("The Client Age limit is not respected!");
		}
	}

}
