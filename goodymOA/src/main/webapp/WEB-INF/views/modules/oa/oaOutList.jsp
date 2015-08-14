<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>外出记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaOut/">外出记录列表</a></li>
		<shiro:hasPermission name="oa:oaOut:edit"><li><a href="${ctx}/oa/oaOut/form">外出记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaOut" action="${ctx}/oa/oaOut/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="trueName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>所属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaOut.office.id}" labelName="office.name" labelValue="${oaOut.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>是否有效：</label>
				<form:select path="outStatus" class="input-medium">
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
				<th>姓名</th>
				<th>所属部门</th>
				<th>外出类型</th>
				<th>外出日期</th>
				<th>起始时间</th>
				<th>结束时间</th>
				<th>小时数</th>
				<th>是否有效</th>
				<th>失效原因</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaOut:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaOut">
			<tr>
				<td><a href="${ctx}/oa/oaOut/form?id=${oaOut.id}">
					${oaOut.trueName}
				</a></td>
				<td>
					${oaOut.office.name}
				</td>
				<td>
					${fns:getDictLabel(oaOut.outType, '', '')}
				</td>
				<td>
					<fmt:formatDate value="${oaOut.outDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaOut.startTime}
				</td>
				<td>
					${oaOut.endTime}
				</td>
				<td>
					${oaOut.hourTotal}
				</td>
				<td>
					${fns:getDictLabel(oaOut.outStatus, '', '')}
				</td>
				<td>
					${oaOut.reason}
				</td>
				<td>
					${oaOut.remarks}
				</td>
				<shiro:hasPermission name="oa:oaOut:edit"><td>
    				<a href="${ctx}/oa/oaOut/form?id=${oaOut.id}">修改</a>
					<a href="${ctx}/oa/oaOut/delete?id=${oaOut.id}" onclick="return confirmx('确认要删除该外出记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>