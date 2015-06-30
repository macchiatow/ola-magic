
<%@ page import="com.olamagic.Number" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'number.label', default: 'Number')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-number" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-number" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list number">
			
				<g:if test="${numberInstance?.call}">
				<li class="fieldcontain">
					<span id="call-label" class="property-label"><g:message code="number.call.label" default="Call" /></span>
					
						<g:each in="${numberInstance.call}" var="c">
						<span class="property-value" aria-labelledby="call-label"><g:link controller="call" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${numberInstance?.upid}">
				<li class="fieldcontain">
					<span id="upid-label" class="property-label"><g:message code="number.upid.label" default="Upid" /></span>
					
						<span class="property-value" aria-labelledby="upid-label"><g:fieldValue bean="${numberInstance}" field="upid"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:numberInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${numberInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>