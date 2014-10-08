<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<div class="box box-danger">
                <div class="box-header">
                    <!-- tools box -->
                    <div class="pull-right box-tools">
                        <button id="addSite" class="btn btn-success btn-sm" data-toggle="tooltip" title="" data-original-title="返回">
                            <i class="fa fa-plus"></i> 返回</button>
<!--                         <button id="siteBatchDelete" class="btn btn-warning btn-sm" data-toggle="tooltip" title="" data-original-title="批量删除">
                            <i class="fa fa-trash-o"></i> 批量删除</button> -->
                    </div><!-- /. tools -->
                    <i class="fa fa-table"></i>
                    <h3 class="box-title">资源管理</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive">
                    <form id="res_form" class="form-horizontal" role="form" method="post" action='<c:url value="/resource"></c:url>'>
                    	<input type="hidden" name="id" value="${resource.id }">
                    	<input type="hidden" name="parent_Id" value="${resource.parent_Id }">
                    	<input type="hidden" name="parent_Ids" value="${resource.parent_Ids }">
                      <c:if test="${not empty parent }">
	                      <div class="form-group">
						    <label for="parentName" class="col-sm-2 control-label">父节点名称</label>
						    <div class="col-sm-10">
						      	<label>${parent.name }</label>
						    </div>
						  </div>
					  </c:if>
					  <div class="form-group">
					    <label for="name" class="col-sm-2 control-label">名称</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="name" name="name" placeholder="名称">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="type" class="col-sm-2 control-label">类型</label>
					    <div class="col-sm-10">
					      <select id="type" name="type" class="form-control">
					      	<option value="menu" selected>菜单</option>
					      	<option value="button">按钮</option>
					      </select>
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="url" class="col-sm-2 control-label">URL</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="url" name="url" placeholder="URL">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="permission" class="col-sm-2 control-label">权限字符串</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" id="permission" name="permission" placeholder="权限字符串">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button type="submit" class="btn btn-default">${op }</button>
					    </div>
					  </div>
					</form>
                </div>
                <!-- /.box-body -->
            </div>

<script type="text/javascript">
	$(function(){
		$("#res_form").ajaxForm({
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	})
</script>