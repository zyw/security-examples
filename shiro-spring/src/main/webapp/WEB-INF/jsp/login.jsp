<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <title>登录</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="<spring:url value="/r/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="<spring:url value="/r/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<spring:url value="/r/css/AdminLTE.css"/>" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
<body class="bg-black">
<%-- <div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username" value="<shiro:principal/>"><br/>
    密码：<input type="password" name="password"><br/>
    自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
    <input type="submit" value="登录">
</form>
 --%>
<div class="form-box" id="login-box">
            <div class="header">登录</div>
            <form action="" method="post">
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="username" value="<shiro:principal/>" class="form-control" placeholder="用户名"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="密码"/>
                    </div>          
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> 自动登录
                    </div>
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-olive btn-block">登&nbsp;录</button>  
                    <p>
                    	<div class="error">${error}</div>
                    </p>
                </div>
            </form>

            <!-- <div class="margin text-center">
                <span>Sign in using social networks</span>
                <br/>
                <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
                <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button>
                <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button>

            </div> -->
        </div>


         <!-- jQuery 2.0.2 -->
        <script src='<spring:url value="/r/js/jquery-2.0.3.min.js"/>'></script>
        <!-- Bootstrap -->
        <script src="<spring:url value="/r/js/bootstrap.min.js"/>" type="text/javascript"></script>  
</body>
</html>