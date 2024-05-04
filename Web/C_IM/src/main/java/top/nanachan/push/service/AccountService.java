package top.nanachan.push.service;

import top.nanachan.push.bean.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author leon_ccc
 * @date 2024/5/4 20:23
 */
// localhost/api/account/...
@Path("/account")
public class AccountService {

    // GET localhost/api/account/login
    @GET
    @Path("/login")
    public String get() {
        return "Login successfully.";
    }

    // POST localhost/api/account/login
    @POST
    @Path("/login")
    // 指定请求与返回的响应体为JSON
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User post() {
        User user = new User();
        user.setName("菜菜酱");
        user.setSex(2);
        return user;
    }
}
