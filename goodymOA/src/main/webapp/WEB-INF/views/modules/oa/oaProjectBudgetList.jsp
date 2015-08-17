<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目预算记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaProjectBudget/">项目预算记录列表</a></li>
		<shiro:hasPermission name="oa:oaProjectBudget:edit"><li><a href="${ctx}/oa/oaProjectBudget/form">项目预算记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaProjectBudget" action="${ctx}/oa/oaProjectBudget/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>所属项目：</label>
				<form:select path="projectId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>预算科目：</label>
				<form:select path="budgetSubjectId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>年份：</label>
				<input name="years" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${oaProjectBudget.years}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>所属项目</th>
				<th>预算科目</th>
				<th>预算金额</th>
				<th>年份</th>
				<th>录入人</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaProjectBudget:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaProjectBudget">
			<tr>
				<td><a href="${ctx}/oa/oaProjectBudget/form?id=${oaProjectBudget.id}">
					${fns:getDictLabel(oaProjectBudget.projectId, '', '')}
				</a></td>
				<td>
					${fns:getDictLabel(oaProjectBudget.budgetSubjectId, '', '')}
				</td>
				<td>
					${oaProjectBudget.money}
				</td>
				<td>
					<fmt:formatDate value="${oaProjectBudget.years}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaProjectBudget.createBy.id}
				</td>
				<td>
					${oaProjectBudget.remarks}
				</td>
				<shiro:hasPermission name="oa:oaProjectBudget:edit"><td>
    				<a href="${ctx}/oa/oaProjectBudget/form?id=${oaProjectBudget.id}">修改</a>
					<a href="${ctx}/oa/oaProjectBudget/delete?id=${oaProjectBudget.id}" onclick="return confirmx('确认要删除该项目预算记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>