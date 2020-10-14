package Rmy.FirstProject.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.*;

@Controller
@RequestMapping("/jdbctest01")
@Api(value = "SayController|测试swagger注解控制器")
public class JdbcTest {
    public static ResultSet rs=null;
    public static Connection connection=null;
    public static PreparedStatement pstmt=null;
    @ResponseBody
    @RequestMapping(value = "/jdbc", method = RequestMethod.GET)
    @ApiOperation(value = "test", notes = "Get登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "passWord", value = "密码", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户名", required = false, dataType = "String")
    })
    public String get(@RequestParam String userId, @RequestParam String passWord) throws Exception {
        if(userId==null){
            return "请输入id";
        }
        if(passWord==null){
            return "请输入密码";
        }
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/db1?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            connection= DriverManager.getConnection(url,"root","root");
            String sql="select * from user where username= ? and password= ?";
            pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,userId);
            pstmt.setString(2,passWord);
            rs=pstmt.executeQuery();
            if(rs.next()){
                pstmt.close();
                rs.close();
                connection.close();
                return "用户名:"+userId+"   "+"密码:"+passWord;
            }
            else {
                pstmt.close();
                rs.close();
                connection.close();
                return "用户名与密码错误";
            }
    }
}

