<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>证件记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaCredentials/">证件记录列表</a></li>
		<shiro:hasPermission name="oa:oaCredentials:edit"><li><a href="${ctx}/oa/oaCredentials/form">证件记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaCredentials" action="${ctx}/oa/oaCredentials/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>人员姓名：</label>
				<sys:treeselect id="trueName" name="trueName" value="${oaCredentials.trueName}" labelName="" labelValue="${oaCredentials.trueName}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>证件名称：</label>
				<form:input path="credentialsName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>证件类型：</label>
				<form:select path="credType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
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
				<th>人员姓名</th>
				<th>证件名称</th>
				<th>证件号码</th>
				<th>发证机构</th>
				<th>发证日期</th>
				<th>有效起始日期</th>
				<th>有效结束日期</th>
				<th>证件类型</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaCredentials:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaCredentials">
			<tr>
				<td><a href="${ctx}/oa/oaCredentials/form?id=${oaCredentials.id}">
					${oaCredentials.archivesNo}
				</a></td>
				<td>
					${oaCredentials.trueName}
				</td>
				<td>
					${oaCredentials.credentialsName}
				</td>
				<td>
					${oaCredentials.credentialsNo}
				</td>
				<td>
					${oaCredentials.issuingInstitution}
				</td>
				<td>
					<fmt:formatDate value="${oaCredentials.issueDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oaCredentials.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oaCredentials.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(oaCredentials.credType, '', '')}
				</td>
				<td>
					${oaCredentials.remarks}
				</td>
				<shiro:hasPermission name="oa:oaCredentials:edit"><td>
    				<a href="${ctx}/oa/oaCredentials/form?id=${oaCredentials.id}">修改</a>
					<a href="${ctx}/oa/oaCredentials/delete?id=${oaCredentials.id}" onclick="return confirmx('确认要删除该证件记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>