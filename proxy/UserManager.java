package proxy;
//抽象主题角色
public interface UserManager {
    public String findUsser();
    public void deleteUser(String id);
    public void updateUser(String name,String psw);
    public void saveUser(String name,String psw);
}
