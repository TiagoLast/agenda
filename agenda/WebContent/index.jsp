<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Inicio</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">  
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	  <link rel="stylesheet" href="css/materialize.min.css">
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
   	  <script src="js/materialize.min.js"></script>
</head>
<body>
	<nav>
	
	    <div class="nav-wrapper">
	
	      <a href="index.jsp" class="brand-logo">Logo</a>
	      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
	
		      <ul id="nav-mobile" class="right hide-on-med-and-down">
		        <li><a href="./agendas-nao-finalizada">Hoje</a></li>
		        <li><a href="./agenda">Agendar</a></li>
		        <li><a href="./agendas">Agendas</a></li>
		        <li><a href="./procedimentos">Procedimentos</a></li>
		        <li><a href="telefones.jsp">Contatos</a></li>
		      	<li><a href="./pacientes">Pacientes</a></li>
		      </ul>
	             
	      <ul class="side-nav" style="width: 180px" id="mobile-demo">
	        
	           <li><a href="./agendas-nao-finalizada">Hoje</a></li>
		        <li><a href="./agenda">Agendar</a></li>
		        <li><a href="./agendas">Agendas</a></li>
		        <li><a href="./procedimentos">Procedimentos</a></li>
		        <li><a href="telefones.jsp">Telefones</a></li>
		      	<li><a href="./pacientes">Pacientes</a></li>
		    
	      </ul>
	             
	   </div>
    </nav><br/><br/>
   
  <script type="text/javascript">
	  $(document).ready(function(){
		$(".button-collapse").sideNav();
	  });
	  
	  $(document).ready(function(){
			 $(".dropdown-button").dropdown();
		});
  </script>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
