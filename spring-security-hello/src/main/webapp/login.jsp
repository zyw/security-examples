<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/res/css/bootstrap.min.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/res/css/bootstrap-theme.min.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/res/css/style.css"/>">

<script type="text/javascript" src="<c:url value="/res/js/jquery-1.9.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/res/js/bootstrap.min.js"/>"></script>
</head>
<body>
	<div class="panel panel-primary login-panel">
    <div class="panel-heading">
        <h3 class="panel-title">用户登录</h3>
    </div>
    <div class="panel-body">
        <form class="form-horizontal" action="<c:url value="/j_spring_security_check"/>" method="post" role="form">
            <div class="form-group">
                <label for="managerName" class="col-lg-3 control-label">用户名</label>
                <div class="col-lg-9">
                    <input type="text" class="form-control" name="j_username" id="loginName" placeholder="用户名" value="zhangsan">
                </div>
            </div>
            <div class="form-group" style="display: block">
                <label for="managerPwd" class="col-lg-3 control-label">密码</label>
                <div class="col-lg-9">
                    <input type="password" class="form-control" name="j_password" id="loginPwd" placeholder="密码" value="000000">
                </div>
            </div>

            <div class="form-group">
                <label for="managerVcode" class="col-lg-3 control-label">验证码</label>
                <div class="col-lg-5" style="padding-right: 10px;">
                    <input type="text" class="form-control" name="captcha" id="captcha" placeholder="验证码">
                </div>
            <%-- <img id="vcode_img" src="<@spring.url '/admin/manager/captcha'/>" title="点击更换验证码"
                 style="cursor: pointer;width: 80px;height: 35px;"/> --%>
            </div>
			<div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <div class="checkbox">
			        <label>
			          <input type="checkbox" name="_spring_security_remember_me"> 记住我
			        </label>
			      </div>
			    </div>
			  </div>
            <div class="form-group">
                <div class="col-lg-offset-3 col-lg-9">
                    <button type="submit" class="btn btn-primary col-lg-9">
                        <span class="glyphicon glyphicon-log-in"></span>&nbsp;
                        登&nbsp;&nbsp;录
                    </button>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-3 col-lg-9">
                    <label style="color: #ff0000"></label>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>