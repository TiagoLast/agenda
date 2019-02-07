<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
	  <title>Procedimentos</title>
	  <meta charset="utf-8">
	</head>
<body>
	<jsp:include page="index.jsp"/>
	    <table class="centered bordered" style="width: 50%; margin-left: 24%">
		<thead>
			<tr>
				<th>NOME</th>
				<th>CPF</th>
				<th>TELEFONE</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="p" items="${pacientes}">
			<tr>
				<td>${p.nome}</td>
				<td>${p.cpf}</td>
				<td>${p.telefone}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>
