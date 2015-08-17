<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>部门预算管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaDepartmentBudget/">部门预算列表</a></li>
		<shiro:hasPermission name="oa:oaDepartmentBudget:edit"><li><a href="${ctx}/oa/oaDepartmentBudget/form">部门预算添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaDepartmentBudget" action="${ctx}/oa/oaDepartmentBudget/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>所属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaDepartmentBudget.office.id}" labelName="office.name" labelValue="${oaDepartmentBudget.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>预算科目：</label>
				<form:select path="budgetSubjectId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>年份：</label>
				<input name="years" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${oaDepartmentBudget.years}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>所属部门</th>
				<th>预算科目</th>
				<th>预算金额</th>
				<th>年份</th>
				<th>录入人</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaDepartmentBudget:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaDepartmentBudget">
			<tr>
				<td><a href="${ctx}/oa/oaDepartmentBudget/form?id=${oaDepartmentBudget.id}">
					${oaDepartmentBudget.office.name}
				</a></td>
				<td>
					${fns:getDictLabel(oaDepartmentBudget.budgetSubjectId, '', '')}
				</td>
				<td>
					${oaDepartmentBudget.money}
				</td>
				<td>
					<fmt:formatDate value="${oaDepartmentBudget.years}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaDepartmentBudget.createBy.id}
				</td>
				<td>
					${oaDepartmentBudget.remarks}
				</td>
				<shiro:hasPermission name="oa:oaDepartmentBudget:edit"><td>
    				<a href="${ctx}/oa/oaDepartmentBudget/form?id=${oaDepartmentBudget.id}">修改</a>
					<a href="${ctx}/oa/oaDepartmentBudget/delete?id=${oaDepartmentBudget.id}" onclick="return confirmx('确认要删除该部门预算吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>