<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>设备类型记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/oa/oaEquipmentCategory/">设备类型记录列表</a></li>
		<shiro:hasPermission name="oa:oaEquipmentCategory:edit"><li><a href="${ctx}/oa/oaEquipmentCategory/form">设备类型记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaEquipmentCategory" action="${ctx}/oa/oaEquipmentCategory/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>类型名称：</label>
				<form:input path="categoryName" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>类型名称</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaEquipmentCategory:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaEquipmentCategory">
			<tr>
				<td><a href="${ctx}/oa/oaEquipmentCategory/form?id=${oaEquipmentCategory.id}">
					${oaEquipmentCategory.categoryName}
				</a></td>
				<td>
					${oaEquipmentCategory.remarks}
				</td>
				<shiro:hasPermission name="oa:oaEquipmentCategory:edit"><td>
    				<a href="${ctx}/oa/oaEquipmentCategory/form?id=${oaEquipmentCategory.id}">修改</a>
					<a href="${ctx}/oa/oaEquipmentCategory/delete?id=${oaEquipmentCategory.id}" onclick="return confirmx('确认要删除该设备类型记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>