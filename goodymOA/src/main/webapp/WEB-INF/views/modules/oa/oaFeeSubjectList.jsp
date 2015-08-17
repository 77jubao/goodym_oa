<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>费用科目管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaFeeSubject/">费用科目列表</a></li>
		<shiro:hasPermission name="oa:oaFeeSubject:edit"><li><a href="${ctx}/oa/oaFeeSubject/form">费用科目添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaFeeSubject" action="${ctx}/oa/oaFeeSubject/" method="post" class="breadcrumb form-search">
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
				<th>费用科目编码</th>
				<th>费用科目名称</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaFeeSubject:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaFeeSubject">
			<tr>
				<td><a href="${ctx}/oa/oaFeeSubject/form?id=${oaFeeSubject.id}">
					${oaFeeSubject.subjectCode}
				</a></td>
				<td>
					${oaFeeSubject.subjectName}
				</td>
				<td>
					${oaFeeSubject.remarks}
				</td>
				<shiro:hasPermission name="oa:oaFeeSubject:edit"><td>
    				<a href="${ctx}/oa/oaFeeSubject/form?id=${oaFeeSubject.id}">修改</a>
					<a href="${ctx}/oa/oaFeeSubject/delete?id=${oaFeeSubject.id}" onclick="return confirmx('确认要删除该费用科目记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>