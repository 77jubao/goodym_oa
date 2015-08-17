<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>借款还款管理管理</title>
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
		<li class="active"><a href="${ctx}/oa/oaLoanRepayment/">借款还款管理列表</a></li>
		<shiro:hasPermission name="oa:oaLoanRepayment:edit"><li><a href="${ctx}/oa/oaLoanRepayment/form">借款还款管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oaLoanRepayment" action="${ctx}/oa/oaLoanRepayment/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>借款单编号：</label>
				<form:input path="loanNo" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>借款人：</label>
				<sys:treeselect id="loanName" name="loanName" value="${oaLoanRepayment.loanName}" labelName="" labelValue="${oaLoanRepayment.loanName}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>所属部门：</label>
				<sys:treeselect id="office" name="office.id" value="${oaLoanRepayment.office.id}" labelName="office.name" labelValue="${oaLoanRepayment.office.name}"
					title="部门" url="/sys/office/treeData?type=2" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>借款状态：</label>
				<form:select path="loanStatus" class="input-medium">
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
				<th>借款单编号</th>
				<th>借款人</th>
				<th>借款日期</th>
				<th>所属部门</th>
				<th>借款事由</th>
				<th>借款金额</th>
				<th>已还金额</th>
				<th>报销冲抵</th>
				<th>剩余金额</th>
				<th>借款状态</th>
				
				<shiro:hasPermission name="oa:oaLoanRepayment:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oaLoanRepayment">
			<tr>
				<td><a href="${ctx}/oa/oaLoanRepayment/form?id=${oaLoanRepayment.id}">
					${oaLoanRepayment.loanNo}
				</a></td>
				<td>
					${oaLoanRepayment.loanName}
				</td>
				<td>
					<fmt:formatDate value="${oaLoanRepayment.loanDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${oaLoanRepayment.office.name}
				</td>
				<td>
					${oaLoanRepayment.loanReason}
				</td>
				<td>
					${oaLoanRepayment.money}
				</td>
				<td>
					${oaLoanRepayment.hasAlsoMoney}
				</td>
				<td>
					${oaLoanRepayment.reimbursementOffset}
				</td>
				<td>
					${oaLoanRepayment.remainingAmount}
				</td>
				<td>
					${fns:getDictLabel(oaLoanRepayment.loanStatus, '', '')}
				</td>
				
				<shiro:hasPermission name="oa:oaLoanRepayment:edit"><td>
    				<a href="${ctx}/oa/oaLoanRepayment/form?id=${oaLoanRepayment.id}">修改</a>
					<a href="${ctx}/oa/oaLoanRepayment/delete?id=${oaLoanRepayment.id}" onclick="return confirmx('确认要删除该借款还款管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>