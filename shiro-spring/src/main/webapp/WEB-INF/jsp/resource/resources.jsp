<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="box box-danger">
                <div class="box-header">
                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <button id="addSite" class="btn btn-success btn-sm" data-toggle="tooltip" title="" data-original-title="添加资源">
                            <i class="fa fa-plus"></i> 添加资源</button>
<!--                         <button id="siteBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="" data-original-title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button> -->
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">资源管理</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <table id="resource-treetable" class="table table-hover table-bordered table-striped">
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
												<a href="javascript:V5Util.pageRedirct('content','<c:url value="/resource/${res.id}"></c:url>')">添加子节点</a>
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
                </div>
                <!-- /.box-body -->
            </div>

<script type="text/javascript">
	$("#resource-treetable").treetable({ expandable: true }).treetable("expandNode", 1);
</script>