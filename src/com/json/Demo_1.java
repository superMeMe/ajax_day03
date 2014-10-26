package com.json;


import com.domain.Province;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by etund on 2014/9/21.
 */

@SuppressWarnings("all")
@WebServlet("/Servlet/Demo_1")
public class Demo_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Province> ps = new ArrayList<Province>();
        ps.add(new Province("安徽省","001"));
        ps.add(new Province("广东省","002"));
        ps.add(new Province("香港","003"));

        response.setContentType("test/html;charset=UTF-8");
        PrintWriter out  = response.getWriter();

        JsonConfig cfg = new JsonConfig();
        cfg.setExcludes(new String[]{"zipcode"});

        JSONArray jsonArr = JSONArray.fromObject(ps,cfg);
        System.out.println(jsonArr.toString());
        out.write(jsonArr.toString());
    }
}
