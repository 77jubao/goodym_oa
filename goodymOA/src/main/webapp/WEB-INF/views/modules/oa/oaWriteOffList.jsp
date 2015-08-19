<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>报销记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaWriteOff/">报销记录列表</a></li>
		<shiro:hasPermission name="oa:oaWriteOff:edit"><li><a href="${ctx}/oa/oaWriteOff/form">报销记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaWriteOff" action="${ctx}/oa/oaWriteOff/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>报销单号：</label>
				<form:input path="writeOffNo" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>报销类型：</label>
				<form:select path="writeOffType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>报销人：</label>
				<sys:treeselect id="name" name="name" value="${oaWriteOff.name}" labelName="" labelValue="${oaWriteOff.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>归属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaWriteOff.office.id}" labelName="office.name" labelValue="${oaWriteOff.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>报销状态：</label>
				<form:select path="writeOffStatus" class="input-medium">
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
				<th>报销单号</th>
				<th>报销类型</th>
				<th>报销人</th>
				<th>报销日期</th>
				<th>报销事由</th>
				<th>归属部门</th>
				<th>报销金额</th>
				<th>报销状态</th>
				<th>借款单编号</th>
				<th>借款单金额</th>
				<th>预算科目</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaWriteOff:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaWriteOff">
			<tr>
				<td><a href="${ctx}/oa/oaWriteOff/form?id=${oaWriteOff.id}">
					${oaWriteOff.writeOffNo}
				</a></td>
				<td>
					${fns:getDictLabel(oaWriteOff.writeOffType, '', '')}
				</td>
				<td>
					${oaWriteOff.name}
				</td>
				<td>
					<fmt:formatDate value="${oaWriteOff.writeOffDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaWriteOff.writeOffReason}
				</td>
				<td>
					${oaWriteOff.office.name}
				</td>
				<td>
					${oaWriteOff.writeOffMoney}
				</td>
				<td>
					${fns:getDictLabel(oaWriteOff.writeOffStatus, '', '')}
				</td>
				<td>
					${oaWriteOff.loanNo}
				</td>
				<td>
					${oaWriteOff.loanMoney}
				</td>
				<td>
					${fns:getDictLabel(oaWriteOff.subjectName, '', '')}
				</td>
				<td>
					${oaWriteOff.remarks}
				</td>
				<shiro:hasPermission name="oa:oaWriteOff:edit"><td>
    				<a href="${ctx}/oa/oaWriteOff/form?id=${oaWriteOff.id}">修改</a>
					<a href="${ctx}/oa/oaWriteOff/delete?id=${oaWriteOff.id}" onclick="return confirmx('确认要删除该报销记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>