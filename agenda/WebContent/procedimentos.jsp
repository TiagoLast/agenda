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
				<th>DESCRICAO</th>
				<th>VALOR</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="p" items="${procedimentos}">
			<tr>
				<td>${p.descricao}</td>
				<td><fmt:formatNumber value="${p.valor}" minFractionDigits="2" type="currency"/></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>
