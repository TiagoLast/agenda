<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
	  <title>?</title>
	  <meta charset="utf-8">
	</head>
<body>
	<jsp:include page="index.jsp"/>	
	
      <form class="col s12" action="telefones" method="get">
    	 <div class="row" style="width: 70%; margin-left: 30%">
			<div class="input-field col s7">
				<div class="row">
        			<div class="input-field col s12">
        				<i class="material-icons prefix">phone</i>
		          		<input type="text" name="pnome" id="autocomplete-input" class="autocomplete">
		          		<label for="autocomplete-input">Digite nome</label>
		        	</div>
	      		</div>
		    </div>
	    </div>
      </form>

	    <table class="centered bordered" style="width: 50%; margin-left: 25%">
			<thead>
				<tr>
					<th>NOME</th>
					<th>TELEFONE</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="t" items="${telefones}">
				<tr>
					<td>${t.nome}</td>
					<td><a href="${t.telefone}">${t.telefone}</a></td>
				</tr>
				</c:forEach>
			</tbody>
			
		</table>
</body>
</html>
