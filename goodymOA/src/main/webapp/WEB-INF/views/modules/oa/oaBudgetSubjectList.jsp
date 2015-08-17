<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>预算科目管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaBudgetSubject/">预算科目列表</a></li>
		<shiro:hasPermission name="oa:oaBudgetSubject:edit"><li><a href="${ctx}/oa/oaBudgetSubject/form">预算科目添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaBudgetSubject" action="${ctx}/oa/oaBudgetSubject/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>科目编码：</label>
				<form:input path="subjectCode" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>科目名称：</label>
				<form:input path="subjectName" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>预算科目编码</th>
				<th>预算科目名称</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaBudgetSubject:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaBudgetSubject">
			<tr>
				<td><a href="${ctx}/oa/oaBudgetSubject/form?id=${oaBudgetSubject.id}">
					${oaBudgetSubject.subjectCode}
				</a></td>
				<td>
					${oaBudgetSubject.subjectName}
				</td>
				<td>
					${oaBudgetSubject.remarks}
				</td>
				<shiro:hasPermission name="oa:oaBudgetSubject:edit"><td>
    				<a href="${ctx}/oa/oaBudgetSubject/form?id=${oaBudgetSubject.id}">修改</a>
					<a href="${ctx}/oa/oaBudgetSubject/delete?id=${oaBudgetSubject.id}" onclick="return confirmx('确认要删除该预算科目记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>