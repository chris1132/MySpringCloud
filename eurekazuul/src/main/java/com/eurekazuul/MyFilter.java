package com.eurekazuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangchaohui on 2017/9/11.
 */

@Component
public class MyFilter extends ZuulFilter {

    /*
    * pre：路由之前
    * routing：路由之时
    * post： 路由之后
    * error：发送错误调用
    * */
    @Override
    public String filterType(){
        return "pre";
    }

    /*过滤的顺序*/
    @Override
    public int filterOrder(){
        return 0;
    }

    /*这里可以写逻辑判断，是否要过滤，本文true,永远过滤。*/
    @Override
    public boolean shouldFilter(){
        return true;
    }

    /*滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。*/
    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        Object token = req.getParameter("token");
        if(token==null){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            System.out.println("____________________________________________");
            try{
                ctx.getResponse().getWriter().write("token is empty");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
