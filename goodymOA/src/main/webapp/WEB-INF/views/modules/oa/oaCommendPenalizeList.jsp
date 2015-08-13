<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>奖惩记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaCommendPenalize/">奖惩记录列表</a></li>
		<shiro:hasPermission name="oa:oaCommendPenalize:edit"><li><a href="${ctx}/oa/oaCommendPenalize/form">奖惩记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaCommendPenalize" action="${ctx}/oa/oaCommendPenalize/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>人员档案号：</label>
				<form:input path="archivesNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="trueName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>归属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaCommendPenalize.office.id}" labelName="office.name" labelValue="${oaCommendPenalize.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>奖惩属性：</label>
				<form:select path="jcType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('jcType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>人员档案号</th>
				<th>姓名</th>
				<th>归属部门</th>
				<th>奖惩属性</th>
				<th>创建时间</th>
				<th>备注</th>
				<th>奖惩金额</th>
				<th>月份</th>
				<shiro:hasPermission name="oa:oaCommendPenalize:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaCommendPenalize">
			<tr>
				<td><a href="${ctx}/oa/oaCommendPenalize/form?id=${oaCommendPenalize.id}">
					${oaCommendPenalize.archivesNo}
				</a></td>
				<td>
					${oaCommendPenalize.trueName}
				</td>
				<td>
					${oaCommendPenalize.office.name}
				</td>
				<td>
					${fns:getDictLabel(oaCommendPenalize.jcType, 'jcType', '')}
				</td>
				<td>
					<fmt:formatDate value="${oaCommendPenalize.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaCommendPenalize.remarks}
				</td>
				<td>
					${oaCommendPenalize.money}
				</td>
				<td>
					<fmt:formatDate value="${oaCommendPenalize.cmonth}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="oa:oaCommendPenalize:edit"><td>
    				<a href="${ctx}/oa/oaCommendPenalize/form?id=${oaCommendPenalize.id}">修改</a>
					<a href="${ctx}/oa/oaCommendPenalize/delete?id=${oaCommendPenalize.id}" onclick="return confirmx('确认要删除该奖惩记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>