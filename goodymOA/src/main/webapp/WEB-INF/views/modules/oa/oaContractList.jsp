<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>合同记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaContract/">合同记录列表</a></li>
		<shiro:hasPermission name="oa:oaContract:edit"><li><a href="${ctx}/oa/oaContract/form">合同记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaContract" action="${ctx}/oa/oaContract/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>合同编号：</label>
				<form:input path="contractNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
			<form:input path="trueName" htmlEscape="false" maxlength="255" class="input-medium"/>
				
			</li>
			<li><label>是否试用：</label>
				<form:select path="isTryOut" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否固定：</label>
				<form:select path="isRegular" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否转正：</label>
				<form:select path="isPositive" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否解除：</label>
				<form:select path="isRemove" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>合同编号</th>
				<th>姓名</th>
				<th>试用截止时间</th>
				<th>到期日期</th>
				<th>转正日期</th>
				<th>解除日期</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaContract:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaContract">
			<tr>
				<td><a href="${ctx}/oa/oaContract/form?id=${oaContract.id}">
					${oaContract.contractNo}
				</a></td>
				<td>
					${oaContract.trueName}
				</td>
				<td>
					<fmt:formatDate value="${oaContract.tryOutDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oaContract.regularDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oaContract.positiveDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${oaContract.removeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaContract.remarks}
				</td>
				<shiro:hasPermission name="oa:oaContract:edit"><td>
    				<a href="${ctx}/oa/oaContract/form?id=${oaContract.id}">修改</a>
					<a href="${ctx}/oa/oaContract/delete?id=${oaContract.id}" onclick="return confirmx('确认要删除该合同记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>