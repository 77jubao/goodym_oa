<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>设备信息记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaEquipment/">设备信息记录列表</a></li>
		<shiro:hasPermission name="oa:oaEquipment:edit"><li><a href="${ctx}/oa/oaEquipment/form">设备信息记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaEquipment" action="${ctx}/oa/oaEquipment/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>设备类型：</label>
				<form:select path="categoryId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>设备编号：</label>
				<form:input path="equipmentNo" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>增加方式：</label>
				<form:select path="addWays" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>保管人员：</label>
				<sys:treeselect id="custodian" name="custodian" value="${oaEquipment.custodian}" labelName="" labelValue="${oaEquipment.custodian}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>使用状态：</label>
				<form:select path="useStatus" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>所属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaEquipment.office.id}" labelName="office.name" labelValue="${oaEquipment.office.name}"
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
				<th>设备类型</th>
				<th>设备编号</th>
				<th>规格型号</th>
				<th>增加方式</th>
				<th>保管人员</th>
				<th>安置地点</th>
				<th>使用状态</th>
				<th>所属部门</th>
				<th>生产厂家</th>
				<th>厂家联系方式</th>
				<shiro:hasPermission name="oa:oaEquipment:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaEquipment">
			<tr>
				<td><a href="${ctx}/oa/oaEquipment/form?id=${oaEquipment.id}">
					${fns:getDictLabel(oaEquipment.categoryId, '', '')}
				</a></td>
				<td>
					${oaEquipment.equipmentNo}
				</td>
				<td>
					${oaEquipment.specificationsModel}
				</td>
				<td>
					${fns:getDictLabel(oaEquipment.addWays, '', '')}
				</td>
				<td>
					${oaEquipment.custodian}
				</td>
				<td>
					${oaEquipment.resettlement}
				</td>
				<td>
					${fns:getDictLabel(oaEquipment.useStatus, '', '')}
				</td>
				<td>
					${oaEquipment.office.name}
				</td>
				<td>
					${oaEquipment.manufacturer}
				</td>
				<td>
					${oaEquipment.factoryPhone}
				</td>
				<shiro:hasPermission name="oa:oaEquipment:edit"><td>
    				<a href="${ctx}/oa/oaEquipment/form?id=${oaEquipment.id}">修改</a>
					<a href="${ctx}/oa/oaEquipment/delete?id=${oaEquipment.id}" onclick="return confirmx('确认要删除该设备信息记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>