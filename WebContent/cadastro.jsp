<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!--><title th:text="${codigo == null ? 'Cadastro de cliente' : 'Edição de cliente'}">Cadastro de cliente</title>
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Materialize CSS-->
  <link rel="stylesheet" href="css/materialize.css">
   
 
</head>
<body>

  <!--Header-->
  <div class="navbar-fixed">
    <nav class="#263238 blue-grey darken-5">
      <div class="nav-wrapper container">
        <a href="#" class="brand-logo">Logo</a>
        <a href='#' data-activates="menu-mobile" class="button-collapse right">
          <i class="material-icons">menu</i> </a>

          <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="index.html">Home</a></li>
            <li><button data-target="modal1" class="btn modal-trigger">Entrar</button></li>
            
          </ul>
        </div>

      </nav>
    </div>
    <!-- MEnu Mobile-->
    <ul id="menu-mobile" class="side-nav">
      <li><a href="index.html">Home</a></li>
      <li><button data-target="modal1" class="btn modal-trigger">Entrar</button></li>
      
    </ul>

    <!--Header
    <h4 th:text="${codigo == null ? 'Cadastro de cliente' : 'EdiÃ§Ã£o de cliente'}">Cadastro de Cliente</h4>
  -->
  <!---->
  
  <div class="card-panel">
    <div class="row">
    
      <form id="formcadastro" class="col s12" name="formCadastro" method="post" action="Controle?cmd=gravar">
     
        <div class="row">
          <div class="input-field col s4">
            <input id="nomeUsuario" type="text"  name="nomeUsuario" class="validate" required>
            <label for="usuario">Usuário</label>
          </div>
          <label class="input-field col s4 offset-s1">Data de Nascimento</label>
          <div class="input-field col s4 offset-s1">
          
            
            <input type="date" name="dataNascimento" id="dataNascimento" min="1900-01-01" max="2017-01-01" required>

          </div>
        </div>

        <div class="row">
          <div class="input-field col s4">
            <input id="password" type="password" class="form-control" name="senha" id="password" required>
            <label for="password">Senha</label>
          </div>

         <div class="input-field col s4 offset-s1">
            <input id="confirm_password" type="password" class="validate" required>
            <label for="confirm_password" data-error="Senha não combina" data-success="Senha correta!">Confirmar Senha</label>
          </div>
        </div>

        <div class="row">
          <div class="input-field col s4">
            <input id="email" type="email" class="validate"  name="email" required >
            <label for="email">Email</label>
          </div>




          <div class="input-field col s4 offset-s1">
            <select  name="sexo" id="Sexo" required>
              <option value="" disabled selected>Selecione o Sexo</option>
              <option value="Masculino">Masculino</option>
              <option value="Feminino">Feminino</option>
            </select>
          </div>
        </div>

        <div class="input-field col s4 offset-s6">
          <br>

          <button class="btn waves-effect #263238 blue-grey darken-5" id="btn1" type="submit" name="action">Enviar
          <i class="material-icons right">send</i></button>
      
          </div>
        </form>
      </div>
    
    </div>

<!--Footer-->



<footer class="page-footer #263238 blue-grey darken-5">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
         <h5 class="white-text">Diversão e Entreteinemento em um só lugar </h5>
          <p class="grey-text text-lighten-4">Monte suas equipes e organize batalhas com maior iteratividade com seus companheiros.</p>
        </div>
        <div class="col l4 offset-l2 s12">
          <h5 class="white-text">Links</h5>
          <ul>
            <li><a class="grey-text text-lighten-3" href="#!">Novidades</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Dicas</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Lojas</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Promoções</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
        © 2017 Copyright Text
        <a class="grey-text text-lighten-4 right">dontplayalonegroup@gmail.com</a>
      </div>
    </div>
  </footer>
<!--Footer-->

<!-- Modal Structure -->
<div id="modal1" class="modal">

    <div class="modal-content">

      <div id="login-page" class="row">
    <div class="col s12 z-depth-4" class="card hoverable small">
      <form class="login-form" id="form1" name="form1" method="post" action="Controle?cmd=logar">
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-social-person-outline prefix"></i>
            <input id="email" name="email" type="email">
            <label for="email" class="center-align">E-mail</label>
          </div>
        </div>

        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password" name="senha" type="password">
            <label for="senha">Senha</label>
          </div>
        </div>
        <div class="container">          
        <input type="checkbox" class="filled-in" id="lembrar" checked="checked" />
            <label for="lembrar">Lembrar</label>
            </div>

        <div class="row">
          <div class="center-align">
            <button class="btn" type="submit" name="action">Login</button>
            
          </div>
        </div>
        <div class="row">
          <div>
            <p class="input-field col s6 m6 l6"><a href="cadastro.jsp">Cadastre-se Agora!</a></p>
          </div>
          <div class="input-field col s6 m6 l6">
              <p class="margin right-align medium-small"><a href="lembrarSenha.jsp">Esqueceu a senha?</a></p>
          </div>          
        </div>

      </form>
    </div>
  </div>
  </div>
  </div>

<!-- <script>

$(document).ready(function(){
	alert("passou aki1");
	  var gnome  = "";
	  var gemail   = "";
	  var gdataNascimento   = "";
	  var gsexo ="";
	  var gsenha="";
	  
     function resgate(){
    	 alert("passou aki2");
   	  gnome = $("#nome").val();
   	  gemail =  $("#email").val();
   	  gdata =    $("#dataNascimento").val();
   	  gsenha =    $("#password").val();
     }
        function limpar(){
       	 $("#nome").val("");
       	 $("#email").val("");
       	 $("#dataNascimento").val("");
       	 $("#password").val("");
        }});
        
        $("#btn1").on('click',function(){
            resgate();
            alert("passou aki!");
            $.ajax({
            	  url: "../Controle?cmd=cadastrarPessoas",
           	      method : "POST",
           	      dataType: "json",
           	      data : {nomeUsuario :  gnome,
           	                  email :   gemail,
           	               dataNascimento :     gdata,
           	                  senha : gsenha
           	                  }            
           	 
            }).done(function(resultado){
           	   $(".resposta").html(resultado);
           	   
            });
                limpar();
         });


</script> -->
        <!--Jquery-->
        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <!-- Materialize JS-->
        <script src="js/materialize.js"></script>

        <script>
//menu mobile
$(".button-collapse").sideNav();
</script>

<script>
 $(document).ready(function() {
  $('select').material_select();
});
</script>
<!--Janela Modal-->
<script>
 $(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });
</script>




<script>



jQuery(document).ready(function () {
	
	
	
	$("#nomeUsuario").bind("focusout", function () {
		if ($("#nomeUsuario").val() != "") {
			validaNomeUsuario($("#nomeUsuario").val());
		}
	});
	
	$("#email").bind("focusout", function () {
		if ($("#email").val() != "") {
			email = $("#email").val();
			validaEmail(email);
		}
	});
	
	function validaNomeUsuario(value) {
		
		var dados = {cmd: "validaNomeUsuario", nomeUsuario: value};
		$bool = null;	
		
		if (value != null) {
			$.ajax({
				type: "POST",
				url: "Controle",
				data: dados,
				dataType: "json",
	            success: function (data) {
	            	
	            	var usuario = document.getElementById("nomeUsuario");
	            	if(data.existe == "sim"){
	            		usuario.setCustomValidity("Usuário inválido ou já cadastrado");
	            	}
	            	else{
	            		usuario.setCustomValidity('');
	            	}
	            	
	            }
			});
		}
		
	}
	
	function validaEmail(value) {
		
		var dados = {cmd: "validaEmail", email: value};
		$bool = null;
		
		if (value != null) {
			$.ajax({
				type: "POST",
				url: "Controle",
				data: dados,
				dataType: "json",
	            success: function (data) {
	            	var email = document.getElementById("email");
	            	if(data.existe == "sim"){
	            		email.setCustomValidity("E-mail inválido ou já cadastrado");
	            	}
	            	else{
	            		email.setCustomValidity('');
	            	}
	            }
			});
		}
		
	}
	

	
});
</script>

<script>
var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("A senha não combina");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>




</body>
</html>