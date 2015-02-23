package proxy;

public class client {
    public static void main(String[] args){
    	//创建真实主题对象
    	UserManager userManagerImpl= new UserManagerImpl();
    	//创建代理主题对象
    	ProxyUserManager proxyUserManager= new ProxyUserManager(userManagerImpl);
    	proxyUserManager.deleteUser("1");
    }
}
