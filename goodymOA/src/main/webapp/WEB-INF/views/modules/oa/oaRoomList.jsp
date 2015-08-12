<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会议室管理管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaRoom/">会议室管理列表</a></li>
		<shiro:hasPermission name="oa:oaRoom:edit"><li><a href="${ctx}/oa/oaRoom/form">会议室管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaRoom" action="${ctx}/oa/oaRoom/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>会议室名称：</label>
				<form:input path="roomName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>容纳人数：</label>
				<form:input path="holdNumber" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>使用状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>会议室名称</th>
				<th>容纳人数</th>
				<th>会议室设备</th>
				<th>会议室地址</th>
				<th>使用状态</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaRoom:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaRoom">
			<tr>
				<td><a href="${ctx}/oa/oaRoom/form?id=${oaRoom.id}">
					${oaRoom.roomName}
				</a></td>
				<td>
					${oaRoom.holdNumber}
				</td>
				<td>
					${fns:getDictLabel(oaRoom.roomEquipment, 'roomEquipment', '')}
				</td>
				<td>
					${oaRoom.roomAddr}
				</td>
				<td>
					${fns:getDictLabel(oaRoom.status, 'status', '')}
				</td>
				<td>
					${oaRoom.remarks}
				</td>
				<shiro:hasPermission name="oa:oaRoom:edit"><td>
    				<a href="${ctx}/oa/oaRoom/form?id=${oaRoom.id}">修改</a>
					<a href="${ctx}/oa/oaRoom/delete?id=${oaRoom.id}" onclick="return confirmx('确认要删除该会议室管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>