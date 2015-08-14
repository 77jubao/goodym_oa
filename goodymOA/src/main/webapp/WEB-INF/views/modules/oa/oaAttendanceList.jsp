<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>出勤记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaAttendance/">出勤记录列表</a></li>
		<shiro:hasPermission name="oa:oaAttendance:edit"><li><a href="${ctx}/oa/oaAttendance/form">出勤记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaAttendance" action="${ctx}/oa/oaAttendance/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>签到人：</label>
				<form:input path="trueName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>归属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaAttendance.office.id}" labelName="office.name" labelValue="${oaAttendance.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>签到类型：</label>
				<form:select path="signType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>签到状态：</label>
				<form:select path="signStatus" class="input-medium">
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
				<th>签到人</th>
				<th>归属部门</th>
				<th>签到日期</th>
				<th>考勤时间</th>
				<th>签到类型</th>
				<th>签到状态</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaAttendance:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaAttendance">
			<tr>
				<td><a href="${ctx}/oa/oaAttendance/form?id=${oaAttendance.id}">
					${oaAttendance.trueName}
				</a></td>
				<td>
					${oaAttendance.office.name}
				</td>
				<td>
					<fmt:formatDate value="${oaAttendance.signDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaAttendance.attendanceTime}
				</td>
				<td>
					${fns:getDictLabel(oaAttendance.signType, '', '')}
				</td>
				<td>
					${fns:getDictLabel(oaAttendance.signStatus, '', '')}
				</td>
				<td>
					${oaAttendance.remarks}
				</td>
				<shiro:hasPermission name="oa:oaAttendance:edit"><td>
    				<a href="${ctx}/oa/oaAttendance/form?id=${oaAttendance.id}">修改</a>
					<a href="${ctx}/oa/oaAttendance/delete?id=${oaAttendance.id}" onclick="return confirmx('确认要删除该出勤记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>