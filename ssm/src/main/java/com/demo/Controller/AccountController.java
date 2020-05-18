package com.demo.Controller;

import com.demo.dao.transactionmp;
import com.demo.pojo.transaction;
import com.demo.impl.transactionimpl;
import com.demo.util.mybatisutli;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class AccountController {
    /**
     * transaction表操作
     **/
    //写入跳转//注册
    @RequestMapping("/out")
    public String action(transaction Transaction){
        transactionimpl.insert(Transaction);
        return "home";
    }
    //跳转到注册页面
    @RequestMapping("/registered")
    public String registered(){
        return "registered";
    }
    //跳转到登陆页面
    @RequestMapping("/tologin")
    public void tologin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
    //查询所有用户数据
//    @RequestMapping("/inquiry")
//    public String inquiry(Model model){
//        model.addAttribute("home",transactionimpl.select());
//        return "home";
//    }
    //查询指定数据
    @RequestMapping("/inquiryassign")
    public String inquiryassign(Model model,String Userid,String Productid){
        transaction tr=new transaction();
        tr.setUserid(Userid);
        tr.setProductid(Productid);
        List<transaction> a=mybatisutli.getSqlSession().getMapper(transactionmp.class).selectuser(tr);
        model.addAttribute("msg",a);
        return "home";
    }
    //登陆
    @RequestMapping("/login")
    public String login(String Userid, String Productid){
        transaction tr=new transaction();
        tr.setUserid(Userid);
        tr.setProductid(Productid);
        List<transaction> a=mybatisutli.getSqlSession().getMapper(transactionmp.class).selectuser(tr);
        mybatisutli.close();
        if (a.toString()!="[]"){
            return "home";
        }else{
            return "nologin";
        }
    }
    //前往商品页
    @RequestMapping("/commodity")
    public String commodity(){
        return "commodity";
    }
}
