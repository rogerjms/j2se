package proxy;
/*
 * 代理主题
 */
public class ProxyUserManager implements UserManager {
	private UserManager userManager;
	/*
	 * 传递进来真实主题对象
	 */
	public ProxyUserManager(UserManager userManager){
		this.userManager=userManager;
	}

	@Override
	public String findUsser() {
		// TODO Auto-generated method stub
		return userManager.findUsser();
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		checksecutrity();
		 userManager.deleteUser(id);
	}

	@Override
	public void updateUser(String name, String psw) {
		// TODO Auto-generated method stub
		userManager.updateUser(name, psw);
	}

	@Override
	public void saveUser(String name, String psw) {
		// TODO Auto-generated method stub
		userManager.saveUser(name, psw);
	}
	public void checksecutrity(){
		System.out.println("anquanjiancha");
	}
	
}
