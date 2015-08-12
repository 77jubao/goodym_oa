<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>档案管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaArchives/">档案列表</a></li>
		<shiro:hasPermission name="oa:oaArchives:edit"><li><a href="${ctx}/oa/oaArchives/form">档案添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaArchives" action="${ctx}/oa/oaArchives/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>档案号：</label>
				<form:input path="archivesNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>真实姓名：</label>
				<form:input path="trueName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>归属公司：</label>
				<form:input path="company" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>归属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaArchives.office.id}" labelName="office.name" labelValue="${oaArchives.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
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
				<th>性别</th>
				<th>入职日期</th>
				<th>状态</th>
				<th>归属公司</th>
				<th>归属部门</th>
				<th>职务</th>
				<th>身份证</th>
				<th>出生日期</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaArchives:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaArchives">
			<tr>
				<td><a href="${ctx}/oa/oaArchives/form?id=${oaArchives.id}">
					${oaArchives.archivesNo}
				</a></td>
				<td>
					${oaArchives.trueName}
				</td>
				<td>
					${fns:getDictLabel(oaArchives.sex, 'sex', '')}
				</td>
				<td>
					<fmt:formatDate value="${oaArchives.entryDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(oaArchives.status, 'status', '')}
				</td>
				<td>
					${oaArchives.company}
				</td>
				<td>
					${oaArchives.office.name}
				</td>
				<td>
					${oaArchives.position}
				</td>
				<td>
					${oaArchives.idCard}
				</td>
				<td>
					<fmt:formatDate value="${oaArchives.birthDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaArchives.remarks}
				</td>
				<shiro:hasPermission name="oa:oaArchives:edit"><td>
    				<a href="${ctx}/oa/oaArchives/form?id=${oaArchives.id}">修改</a>
					<a href="${ctx}/oa/oaArchives/delete?id=${oaArchives.id}" onclick="return confirmx('确认要删除该档案吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>