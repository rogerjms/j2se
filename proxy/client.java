package proxy;

public class client {
    public static void main(String[] args){
    	//������ʵ�������
    	UserManager userManagerImpl= new UserManagerImpl();
    	//���������������
    	ProxyUserManager proxyUserManager= new ProxyUserManager(userManagerImpl);
    	proxyUserManager.deleteUser("1");
    }
}
