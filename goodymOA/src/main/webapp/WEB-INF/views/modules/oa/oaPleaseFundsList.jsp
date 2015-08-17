<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>请款记录管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaPleaseFunds/">请款记录列表</a></li>
		<shiro:hasPermission name="oa:oaPleaseFunds:edit"><li><a href="${ctx}/oa/oaPleaseFunds/form">请款记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaPleaseFunds" action="${ctx}/oa/oaPleaseFunds/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>请款编号：</label>
				<form:input path="pleaseNumber" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>归属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaPleaseFunds.office.id}" labelName="office.name" labelValue="${oaPleaseFunds.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>预算科目：</label>
				<form:select path="budgetSubjectId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>请款类型：</label>
				<form:select path="feeSubjectId" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>请款人：</label>
				<sys:treeselect id="pleaseName" name="pleaseName" value="${oaPleaseFunds.pleaseName}" labelName="" labelValue="${oaPleaseFunds.pleaseName}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>付款方式：</label>
				<form:select path="playType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>请款状态：</label>
				<form:select path="playStatus" class="input-medium">
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
				<th>请款编号</th>
				<th>归属部门</th>
				<th>预算科目</th>
				<th>请款类型</th>
				<th>请款日期</th>
				<th>请款人</th>
				<th>付款方式</th>
				<th>付款事由</th>
				<th>支付金额</th>
				<th>收款单位名称</th>
				<th>请款状态</th>
				<th>备注</th>
				<shiro:hasPermission name="oa:oaPleaseFunds:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaPleaseFunds">
			<tr>
				<td><a href="${ctx}/oa/oaPleaseFunds/form?id=${oaPleaseFunds.id}">
					${oaPleaseFunds.pleaseNumber}
				</a></td>
				<td>
					${oaPleaseFunds.office.name}
				</td>
				<td>
					${fns:getDictLabel(oaPleaseFunds.budgetSubjectId, '', '')}
				</td>
				<td>
					${fns:getDictLabel(oaPleaseFunds.feeSubjectId, '', '')}
				</td>
				<td>
					<fmt:formatDate value="${oaPleaseFunds.pleaseDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaPleaseFunds.pleaseName}
				</td>
				<td>
					${fns:getDictLabel(oaPleaseFunds.playType, '', '')}
				</td>
				<td>
					${oaPleaseFunds.playReason}
				</td>
				<td>
					${oaPleaseFunds.playMoney}
				</td>
				<td>
					${oaPleaseFunds.companyName}
				</td>
				<td>
					${fns:getDictLabel(oaPleaseFunds.playStatus, '', '')}
				</td>
				<td>
					${oaPleaseFunds.remarks}
				</td>
				<shiro:hasPermission name="oa:oaPleaseFunds:edit"><td>
    				<a href="${ctx}/oa/oaPleaseFunds/form?id=${oaPleaseFunds.id}">修改</a>
					<a href="${ctx}/oa/oaPleaseFunds/delete?id=${oaPleaseFunds.id}" onclick="return confirmx('确认要删除该请款记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>