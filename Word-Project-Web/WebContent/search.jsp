<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文档内容查询</title>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 项目</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    

</head>

<body class="gray-bg">
<form action="${pageContext.request.contextPath}/servlet/searchServlet" method="post">
 
    <div class="wrapper wrapper-content animated fadeInUp">
        <div class="row">
            <div class="col-sm-12">

                <div class="ibox">
                    <div class="ibox-title">
                        <h5>所有项目</h5>
                       
                    </div>
                    <div class="ibox-content">
                        <div class="row m-b-sm m-t-sm">
                            <div class="col-md-1">
                                <button type="button" id="loading-example-btn" class="btn btn-white btn-sm"><i class="fa fa-refresh"></i> 刷新</button>
                            </div>
                            <div class="col-md-11">
                                <div class="input-group">
                                    <input type="text" placeholder="请输入查询内容" class="input-sm form-control" name="title"> <span class="input-group-btn">
                                        <button type="submit" class="btn btn-sm btn-primary"> 搜索</button> </span>
                                </div>
                            </div>
                        </div>

                        <div class="project-list">
                      	  <table class="table table-hover">
                      	  	<tr >
						
								 <td colspan="2" align="center" style="">文档信息</td>
							    </tr>
							 	 <c:forEach items="${sessionScope.information}" var="pro">
							    <tr>
							    	<td style="text-align: center;">篇节</td>
							    	<td  align="center" >${pro.pianjie} </td>
							    </tr>
							    <tr>
									<td style="text-align: center;">章节</td>	
									<td  align="center" >${pro.zhangjie} </td>
							    <tr>
							    	<td style="text-align: center;">标题</td>
							    	<td  align="center" >${pro.title} </td>
							    </tr>
							    <tr>
							    	<td style="text-align: center;">关键字</td>
							    	<td  align="center" >${pro.keyword} </td>
							    </tr>
							    <tr>
							    	<td style="text-align: center;" width="20%">查重比例</td>
							    	<td  align="center" >${pro.similar*100}% </td>
							    </tr>
							    <tr>
							    	<td style="text-align: center;" width="20%">内容</td>
							    	<td  align="center" >${pro.content} </td>
							    </tr>
							    <div class="ibox-tools">
                     				  <a href="${pageContext.request.contextPath}/serverLet/outputServlet?title=${pro.title}&content=${pro.content}" class="btn btn-primary btn-xs">预览报告</a>
                      			</div>
							   </c:forEach>
							  	
                      	  </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script>
       $(document).ready(function(){$("#loading-example-btn").click(function(){btn=$(this);simpleLoad(btn,true);simpleLoad(btn,false)})});function simpleLoad(btn,state){if(state){btn.children().addClass("fa-spin");btn.contents().last().replaceWith(" Loading")}else{setTimeout(function(){btn.children().removeClass("fa-spin");btn.contents().last().replaceWith(" Refresh")},2000)}};
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
  
    </body>

<!-- Mirrored from www.zi-han.net/theme/hplus/projects.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:44 GMT -->
</html>
