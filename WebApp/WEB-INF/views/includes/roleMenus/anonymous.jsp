<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="urlRoot"/>
<div class="navbar-header">
	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
  		<span class="sr-only">Toggle navigation</span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	  	<span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="${urlRoot}">My CineSite</a>
</div>
<div id="navbar" class="navbar-collapse collapse">
	<ul class="nav navbar-nav">    
		<li><a href="${urlRoot}about">Acerca</a></li>
		<li><a href="${urlRoot}formLogin">Login</a></li>     
	</ul>
</div>