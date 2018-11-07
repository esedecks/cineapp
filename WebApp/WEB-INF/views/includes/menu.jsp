<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/" var="urlRoot"/>
 <!-- Fixed navbar -->
 <nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<!-- Anonymous -->
		<sec:authorize access="isAnonymous()">
			<jsp:include page="roleMenus/anonymous.jsp"/>
	     </sec:authorize>
	     <!-- editor -->
	     <sec:authorize access="hasAnyAuthority('EDITOR')">
	     	<jsp:include page="roleMenus/editor.jsp"/>
	     </sec:authorize>
	     <!-- gerente -->
	     <sec:authorize access="hasAnyAuthority('GERENTE')">
		     <jsp:include page="roleMenus/gerente.jsp"/>
	     </sec:authorize>   
   </div>
 </nav>