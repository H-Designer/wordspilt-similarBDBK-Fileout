<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page contentType="application/vnd.ms-word;charset=UTF-8"%> --%>
<%@ page import="java.net.URLEncoder"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查重报告文档</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> 
<!--     <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet"> -->
<!--     <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet"> -->

<!--     <link href="css/animate.min.css" rel="stylesheet"> -->
<!--     <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet"> -->

</head>

<body class="gray-bg">
<% 
	String name = session.getAttribute("title").toString();
    String fileName = name+".doc";
   	//byte[] bt = fileName.getBytes("UTF-8");  
    //String unicoStr = new String(bt, "UTF-8");
    //response.setHeader("Content-disposition","attachment; filename=" +unicoStr);  
    response.setHeader("Content-Disposition","attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
%>
<% 
	String BKcontent = session.getAttribute("BKcontent").toString(); 
	String YWcontent = session.getAttribute("YWcontent").toString(); 
	String date = session.getAttribute("date").toString();

%>
    <div class="wrapper wrapper-content animated fadeInRight">
		<c:forEach items="${sessionScope.information}" var="pro">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox-content p-xl">
                    <div class="row">
                        <div class="col-sm-6">
                            <address>
                                        <strong>IT技术热词在线查重</strong>
                                        <br>河北省石家庄铁道大学<br>
                                        <abbr title="Phone">电话：</abbr> 8888888
                                    </address>
                        </div>
                        <div class="col-sm-6 text-right">
                            <h4>查重标题：</h4>
                            <h4 class="text-navy">${pro.title}</h4>
                            <address>
                                        <strong>石家庄铁道大学</strong>
                                        <br>信息科学与技术学院软件工程系信1605-3赵春辉<br>
                                        <abbr title="Phone">总机：</abbr> 8888888
                                    </address>
                            <p>
                                <span><strong>日期：</strong><%=date %></span>
                            </p>
                        </div>
                    </div>
                    <div class="project-list">
                        <table class="table table-hover">
                                <tr>
                                    <td style="text-align: center;">查重原文</td>
                                    <td align="center"><%=YWcontent %></td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">百度文库原文</td>
                                    <td align="center"><%=BKcontent %></td>
                                </tr>
                        </table>
                    </div>
                    <!-- /table-responsive -->
                    <table class="table invoice-total">
                        <tbody>
                            <tr>
                                <td><strong>相似度：</strong>
                                </td>
                                <td>${pro.similar*100}% </td>
                            </tr>
                          
                        </tbody>
                        
                    </table>
<!--                     <div class="text-right"> -->
<!--                         <button class="btn btn-primary"><i class="fa fa-dollar"></i>生成报告文档</button> -->
<!--                     </div> -->
                    <div class="well m-t" align="center"><strong>注意：</strong> 本报告存在一定的偶然性，如有不适，请联系作者。
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>