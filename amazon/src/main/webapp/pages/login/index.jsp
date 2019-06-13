<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:s="/struts-tags" version="2.0">
	<jsp:directive.page language="java"
		contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
	<jsp:text>
		<![CDATA[ <?xml version="1.0" encoding="UTF-8" ?> ]]>
	</jsp:text>
	<jsp:text>
		<![CDATA[ <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> ]]>
	</jsp:text>
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Manage User</title>
</head>
<body>



	<s:actionerror />
	<s:form id="frmLogin"
		action="%{#pageContext.request.contextPath}/login" method="post"
		theme="simple">

		<div class="form-group">
			<div class="col-md-4">
				<label for="">User</label>
			</div>
			<div class="col-md-8">
				<s:textfield id="tx_login" name="model.login"
					cssClass="form-control" cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.login" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-4">
				<label for="">Password</label>
			</div>
			<div class="col-md-8">
				<s:password id="tx_password" name="model.password"
					cssClass="form-control" cssErrorClass="is-invalid" />
				<s:fielderror fieldName="model.password" />
			</div>
		</div>

		<div class="row">
			<a href="${pageContext.request.contextPath}/login">Cancel</a>
			<s:submit value="Confirm" />
		</div>
		<div class="row">
			<a href="${pageContext.request.contextPath}/user/new">Create account</a>
		</div>
	</s:form>

</body>
	</html>
</jsp:root>