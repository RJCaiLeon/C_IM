package top.nanachan.push;

public class UserService implements IUserService {
    @Override
    public String search(int hashCode) {
        return "User:" + hashCode;
    }
}

