<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<table id="resource-treetable">
	<thead>
		<tr>
			<th>名称</th>
			<th>类型</th>
			<th>URL</th>
			<th>权限字符串</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="res" items="${ress}">
			<tr data-tt-id="${res.id }" <c:if test="${res.parent_Id ne 0 }">data-tt-parent-id="${res.parent_Id }"</c:if>>
				<td>${res.name }</td>
				<td>${res.type }</td>
				<td>${res.url }</td>
				<td>${res.permission }</td>
				<td>
					<shiro:hasPermission name="resource:create">
						<c:if test="${res.type ne 'button' }">
							<a href='<c:url value="/resource/${res.id}/appendChild"></c:url>'>添加子节点</a>
						</c:if>
					</shiro:hasPermission>
					<shiro:hasPermission name="resource:update">
						<a href='<c:url value="/resource/${res.id}/update"></c:url>'>修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="resource:delete">
						<a href='<c:url value="/resource/${res.id}/delete"></c:url>'>删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
	$("#resource-treetable").treetable({ expandable: true });
</script>