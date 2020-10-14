package Rmy.FirstProject.Controller;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.spring.web.json.Json;

@Controller
@RequestMapping("/say")
@Api(value = "SayController|测试swagger注解控制器")
public class swaggerTest {
    int count=-1;
    @ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ApiOperation(value = "test",notes = "Get请求 传入测试数据返回json格式的结果")
    @ApiImplicitParam(paramType = "query",name="value",value = "测试数据",required = false,dataType = "String")
    public String get(@RequestParam String value) {
//        if(userNumber=="-1")
//        {
//            return "set -1";
//        }
        //JSONObject object = new JSONObject();
        count++;
        if (value != null) {
//            object.put("code",count);
//            object.put("msg","成功");
//            object.put("data",userNumber);
//            return String(object);
        return "code:" + count + ",\n" + "msg:成功,\n" + "data:" + value;
    }
        else{
            return "code:"+count+",\n"+"msg:失败,\n"+"data:NULL";
        }
    }

    @ResponseBody
    @RequestMapping("/post")
    @ApiOperation(value = "test",notes = "Post请求 传入测试数据返回json格式的结果")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "request", value = "测试数据", required = true, dataType = "String"),
    })
    public String post(@RequestParam String request){
        String []strs=request.split("\"");
        return "code:"+count+",\n"+"msg:成功,\n"+"data:"+strs[3]+strs[7];
    }

}
