<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>?</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  </head>
<body>
<jsp:include page="index.jsp"/>
	<br/>
	<table class="centered bordered" style="width: 70%; margin-left: 15%">
		<thead>
			<tr>
				<th>DATA</th>
				<th>HORARIO</th>
				<th>PACIENTE</th>
				<th>PROCEDIMENTO</th>
				<th>FINALIZAR</th>
								
			</tr>
			</thead>
			<tbody>
			<c:forEach var="a" items="${agendasnaofinalizadas}">
			<tr>
				<td><fmt:formatDate value="${a.data}"/></td>
				<td><fmt:formatDate value="${a.horario}" pattern="HH:mm"/></td>
				<td>${a.pacientes.nome}</td>
				<td>${a.procedimento.descricao}</td>
				<td><a href="<c:url value="/finaliza-agenda?id=${a.idagenda}"/>" onclick="return confirm('DESEJA FINALIZAR O PROCEDIMENTO DA ${a.pacientes.nome}')"><i class="material-icons">mode_edit</i></a></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>
