<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>培训记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaTrain/">培训记录列表</a></li>
		<shiro:hasPermission name="oa:oaTrain:edit"><li><a href="${ctx}/oa/oaTrain/form">培训记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaTrain" action="${ctx}/oa/oaTrain/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>档案号：</label>
				<form:input path="archivesNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>真实姓名：</label>
				<form:input path="trueName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>档案号</th>
				<th>真实姓名</th>
				<th>培训费用</th>
				<th>开始日期</th>
				<th>结束日期</th>
				<th>培训机构</th>
				<th>培训地点</th>
				<th>培训内容</th>
				<th>所获证书</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaTrain:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaTrain">
			<tr>
				<td><a href="${ctx}/oa/oaTrain/form?id=${oaTrain.id}">
					${oaTrain.archivesNo}
				</a></td>
				<td>
					${oaTrain.trueName}
				</td>
				<td>
					${oaTrain.money}
				</td>
				<td>
					<fmt:formatDate value="${oaTrain.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oaTrain.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaTrain.trainingInstitutions}
				</td>
				<td>
					${oaTrain.courseLocations}
				</td>
				<td>
					${oaTrain.trainingContent}
				</td>
				<td>
					${oaTrain.certificate}
				</td>
				<td>
					${oaTrain.remarks}
				</td>
				<shiro:hasPermission name="oa:oaTrain:edit"><td>
    				<a href="${ctx}/oa/oaTrain/form?id=${oaTrain.id}">修改</a>
					<a href="${ctx}/oa/oaTrain/delete?id=${oaTrain.id}" onclick="return confirmx('确认要删除该培训记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>