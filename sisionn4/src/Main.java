import model.User;
import service.ServiceUser;
import service.ServiceUserImpl;

public class Main {
	public static void main(String[] args) throws Exception {
		ServiceUser serviceUser = new ServiceUserImpl();
		User user = new User();
		
		serviceUser.imput(user);
		
		serviceUser.createUser(user);
	}

}
