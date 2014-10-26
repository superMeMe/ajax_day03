<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>级联菜单</title>
		<script type="text/javascript" src="./xmFile.js"> </script>
	</head>
	<body>
     <select id="province" name="province">
       <option value="">请选择....</option>
     </select>
	 <select id="city" name="city">
	 	<option value="">请选择.....</option>
	 </select>
	 <script type="text/javascript">


         //注册事件触发
         window.onload = function(){
             var xhr = createXmlHttpRequest();
             xhr.onreadystatechange=function(){
                 alert(xhr.readyState);
                        if(xhr.readyState==4){

                            if(xhr.status==200||xhr.status==304){
                                var data = xhr.responseText;
                                var provinceJson = eval("("+data+")");

                                for(var i=0;i<provinceJson.length;i++){
                                    var optionElement = document.createElement("option");
                                    optionElement.setAttribute("value",provinceJson[i].name);
                                    var textNode = document.createTextNode(provinceJson[i].name);
                                    optionElement.appendChild(textNode);
                                    document.getElementById("province").appendChild(optionElement);
                                }
                            }
                        }
             }
             xhr.open("GET","/Servlet/Demo_1?time="+new Date().getTime());
             xhr.send(null);
         }
	 	    //a 创建XmlHttpRequest对象，固定写法
            function createXmlHttpRequest(){
                var xmlHttp;
                try{    //Firefox, Opera 8.0+, Safari
                    xmlHttp=new XMLHttpRequest();
                }catch (e){
                    try{    //Internet Explorer
                        xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                    }catch (e){
                        try{
                            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                        }catch (e){}
                    }
                }
                return xmlHttp;
            }
	 </script>
  </body>
</html>

