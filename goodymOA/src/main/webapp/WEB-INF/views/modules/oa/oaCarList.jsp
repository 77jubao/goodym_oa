<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆管理管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaCar/">车辆管理列表</a></li>
		<shiro:hasPermission name="oa:oaCar:edit"><li><a href="${ctx}/oa/oaCar/form">车辆管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaCar" action="${ctx}/oa/oaCar/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车牌号码：</label>
				<form:input path="carNumber" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>品牌型号：</label>
				<form:input path="brandType" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>车辆类型：</label>
				<form:select path="carType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('carType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>车牌号码</th>
				<th>品牌型号</th>
				<th>车辆类型</th>
				<th>车身颜色</th>
				<th>容纳人数</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaCar:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaCar">
			<tr>
				<td><a href="${ctx}/oa/oaCar/form?id=${oaCar.id}">
					${oaCar.carNumber}
				</a></td>
				<td>
					${oaCar.brandType}
				</td>
				<td>
					${fns:getDictLabel(oaCar.carType, 'carType', '')}
				</td>
				<td>
					${fns:getDictLabel(oaCar.carColour, 'carColour', '')}
				</td>
				<td>
					${oaCar.holdNumber}
				</td>
				<td>
					${oaCar.remarks}
				</td>
				<shiro:hasPermission name="oa:oaCar:edit"><td>
    				<a href="${ctx}/oa/oaCar/form?id=${oaCar.id}">修改</a>
					<a href="${ctx}/oa/oaCar/delete?id=${oaCar.id}" onclick="return confirmx('确认要删除该车辆管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>