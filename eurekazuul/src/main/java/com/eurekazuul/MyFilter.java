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
    * pre��·��֮ǰ
    * routing��·��֮ʱ
    * post�� ·��֮��
    * error�����ʹ������
    * */
    @Override
    public String filterType(){
        return "pre";
    }

    /*���˵�˳��*/
    @Override
    public int filterOrder(){
        return 0;
    }

    /*�������д�߼��жϣ��Ƿ�Ҫ���ˣ�����true,��Զ���ˡ�*/
    @Override
    public boolean shouldFilter(){
        return true;
    }

    /*�����ľ����߼������úܸ��ӣ�������sql��nosqlȥ�жϸ����󵽵���û��Ȩ�޷��ʡ�*/
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
