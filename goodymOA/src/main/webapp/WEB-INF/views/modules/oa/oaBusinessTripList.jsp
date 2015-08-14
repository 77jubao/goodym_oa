<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>出差记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaBusinessTrip/">出差记录列表</a></li>
		<shiro:hasPermission name="oa:oaBusinessTrip:edit"><li><a href="${ctx}/oa/oaBusinessTrip/form">出差记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaBusinessTrip" action="${ctx}/oa/oaBusinessTrip/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="trueName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>所属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaBusinessTrip.office.id}" labelName="office.name" labelValue="${oaBusinessTrip.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>转换类型：</label>
				<form:select path="changeType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>是否有效：</label>
				<form:select path="businessStatus" class="input-medium">
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
				<th>出差类型</th>
				<th>出差日期</th>
				<th>起始时间</th>
				<th>结束时间</th>
				<th>小时数</th>
				<th>转换类型</th>
				<th>转换小时数</th>
				<th>过期时间</th>
				<th>是否有效</th>
				<th>失效原因</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaBusinessTrip:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaBusinessTrip">
			<tr>
				<td><a href="${ctx}/oa/oaBusinessTrip/form?id=${oaBusinessTrip.id}">
					${oaBusinessTrip.trueName}
				</a></td>
				<td>
					${oaBusinessTrip.office.name}
				</td>
				<td>
					${oaBusinessTrip.businessType}
				</td>
				<td>
					<fmt:formatDate value="${oaBusinessTrip.businessDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaBusinessTrip.startTime}
				</td>
				<td>
					${oaBusinessTrip.endTime}
				</td>
				<td>
					${oaBusinessTrip.hourTotal}
				</td>
				<td>
					${fns:getDictLabel(oaBusinessTrip.changeType, '', '')}
				</td>
				<td>
					${oaBusinessTrip.changeHour}
				</td>
				<td>
					<fmt:formatDate value="${oaBusinessTrip.expiredDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(oaBusinessTrip.businessStatus, '', '')}
				</td>
				<td>
					${oaBusinessTrip.reason}
				</td>
				<td>
					${oaBusinessTrip.remarks}
				</td>
				<shiro:hasPermission name="oa:oaBusinessTrip:edit"><td>
    				<a href="${ctx}/oa/oaBusinessTrip/form?id=${oaBusinessTrip.id}">修改</a>
					<a href="${ctx}/oa/oaBusinessTrip/delete?id=${oaBusinessTrip.id}" onclick="return confirmx('确认要删除该出差记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>