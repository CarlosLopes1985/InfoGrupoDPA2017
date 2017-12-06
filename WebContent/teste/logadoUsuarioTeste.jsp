<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:useBean class="br.com.projetofinal.manager.ManagerBean" id="mb"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>

</head>
<body>
		<c:if test="${not empty pessoas}">
			<pre>${pessoas}</pre>
		</c:if>
		
		<br />
		<h3>-----------</h3>
		<br />
		
		
	<script>
	    $(document).ready(function() {
	
		    var list = ${pessoas};
		    $.each(list, function( index, value ) {
			alert( index + ": " + value.idPessoa + " - " + value.nomeUsuario );
		    });
	
		});
	</script>

</body>
</html>