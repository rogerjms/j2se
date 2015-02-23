package proxy;
/**
 * 真实主题角色
 * @author xiaoke
 *
 */
public class UserManagerImpl implements UserManager  {

	@Override
	public String findUsser() {
		// TODO Auto-generated method stub
		checkSecutrity();
		System.out.println("UserManagerImpl findUser ");
		return "demo";
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
//		checkSecutrity();
		System.out.println("UserManagerImpl deleteUser "+id);
		
	}

	@Override
	public void updateUser(String name, String psw) {
		// TODO Auto-generated method stub
		//checkSecutrity();
		System.out.println("UserManagerImpl updateUser "+name+psw);
	}

	@Override
	public void saveUser(String name, String psw) {
		// TODO Auto-generated method stub
//		checkSecutrity();
		System.out.println("UserManagerImpl saveUser "+name+psw);
	}
	public void checkSecutrity(){
		System.out.println("安全检查");
	}

}
