<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Agendar</title>
	    <meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<script type="text/javascript" src="js/materialize.min.js"></script>
  		<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="js/materialize.min.js"></script> 
		
		<script type="text/javascript">
			
			function add() {
				$.post( "agenda.jsp", $( "#testform" ).serialize() );


			}
			
		</script>
		         
	   </head>
<body>
<jsp:include page="index.jsp"/>
	<div class="container">
		<div class="row">
	
			<form class="col s12" method="post" id="testform">
				
				<div class="row">
					<div class="input-field col s6">
						<select name="paciente" id="paciente" required="required">
					      <option></option>
						    <c:forEach var="paciente" items="${pacientes}">  
						       <option value="${paciente.idpaciente}">${paciente.nome}</option>
						    </c:forEach>
					    </select>
					    <label>Paciente</label>
					</div>
					
					<div class="input-field col s6">
						<select name="procedimento" id="cliente" required="required">
						   <option value=""></option>
							<c:forEach var="p" items="${procedimentos}">
						     	 <option value="${p.idprocedimento}">${p.descricao}</option>
						      </c:forEach>
					    </select>
					  	<label>Procedimento</label>
					</div>
					
				</div>
				
				<div class="row">
										
					<div class="input-field col s6">
						<input name="data" required="required"  type="date" id="data" class="datepicker"> <label for="data">Data</label>
					</div>
					<div class="input-field col s6">
						<input name="horario" id="horario" type="text" class="timepicker" required="required"> <label for="horario">Hora</label>
					</div>
					
				</div>
					
				
				<div class="row">
					<div class="input-field col s12">
						<button  id="submit" class="btn waves-effect waves-light" type="submit" name="action" onclick="add()">
							Registrar
						</button>
					   
					   <button class="btn waves-effect waves-light" type="reset" name="action" onclick="Materialize.toast('Ups! Agenda Cancelada', 1000)">
							Cancelar
					  </button>
						
					</div>
				</div>
						
			</form>
		</div>

		<div class="fixed-action-btn" style="bottom: 125px; right: 150 px;">
			<a href="./agenda" class="btn-floating btn-large waves-effect waves-light"><i class="material-icons">+</i></a>
		</div>
		
	</div>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('select').material_select();
		});	
	</script>
 	
	 	
	<script type="text/javascript">
	$('.datepicker').pickadate({
	    selectMonths: true,
	    selectYears: 15, 
	    today: 'Hoje',
	    clear: 'Cancelar',
	    close: 'Ok',
	    format: 'dd-mm-yyyy',
	    closeOnSelect: false 
	  });
     </script>
     
    <script type="text/javascript">
	     $('.timepicker').pickatime({
	     default: 'now',  
	     fromnow: 0,      
	     twelvehour: false, 
	     donetext: 'OK',  
	     cleartext: 'Clear',  
	     canceltext: 'Cancel',  
	     autoclose: false,  
	     ampmclickable: true,  
	     aftershow: function(){} 
	   });
     </script>

</body>
</html>
