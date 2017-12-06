<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <jsp:useBean class="br.com.projetofinal.manager.ManagerBean" id="mb"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width-device-width,initial-scale=1.0">
  <title> TCC </title>
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <!-- Materialize CSS-->
  <link rel="stylesheet" href="css/materialize.css">
  <script type="text/javascript" src="../usuario/js/filtraRolesPlataformasEscolherJogos.js">
</script>
<script type="text/javascript" src="../usuario/js/verificaMsg.js"></script> 

</head>
<body style="background-color:#78909c;">

  <!--Header-->
  <div class="navbar">
    <nav class="#263238 blue-grey darken-5">
      <div class="nav-wrapper container">
        <a href="#!" class="brand-logo">Logo</a>
        <a href='#!' data-activates="menu-mobile" class="button-collapse right">
          <i class="material-icons">menu</i> </a>

          <ul id="nav-mobile" class="right hide-on-med-and-down">



            
            <!--Header-->
            <div class="row">
              <ul id="slide-out" class="side-nav fixed">
                <li><div class="user-view">
          <div class="background" style="background-color:#263238;">
            
          </div>
          <a href="#!user"><img class="circle" src="${pessoa.foto}"></a>
          <a href="#!name"><span class="white-text name"> ${pessoa.nomeUsuario}</span></a>
          <br>
        </div></li>
                <li><a href="profile.jsp"><i class="material-icons">person</i>Perfil</a></li>
                <li><a href="logadoUsuario.jsp"><i class="material-icons">search</i>Busca de Jogadores</a></li>
                <li><a class="subheader green-text"><i class="material-icons green-text">videogame_asset</i>Escolher jogos</a></li>
                <li><a href="jogosCadastrados.jsp"><i class="material-icons">videogame_asset</i>Jogos Cadastrados</a></li>
                <li><a href="listaMensagens.jsp"><i class="material-icons">chat</i>Mensagens <span id="newMsg" class=""></span></a></li>
                <li><a href="logout.jsp"><i class="material-icons">exit_to_app</i>Sair</a></li>
                
    <!--Subheader-><li><div class="divider"></div></li>
    <li><a class="subheader">Subheader</a></li>
    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
    <!---->
  </ul>

</div>
</ul>

<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>
</div>

<!-- Dropdown Trigger -->


<!-- Dropdown Structure -->
<div>
  <ul id='dropdown1' class='dropdown-content'>
    <li><a href="#!">Perfil</a></li>

    <li><a href="#">Escolher Jogos</a></li>
    <li><a href="index.html">Sair</a></li>
    <li class="divider"></li>
  </ul>
</div>

</nav>
</div>
<!-- MEnu Mobile-->
<ul id="menu-mobile" class="side-nav">

</ul>

<div class="row">
  <div class="input-field col s4">
    <div class="card hoverable col s9 offset-s9">
      <div class="card-content black-text">

        <span class="card-title">Escolher jogos</span>

        <form id="busca" name="form1" method="post" action="../Controle?cmd=alocarPessoaPlatRoles">
       
          <div class="row">
            <div class="input-field col s12">
              <select id="jogo" onchange="filtraRolesPlataformas(this.value, this.id)" class="validate" name="jogo">
                <option value="" disabled="disabled" selected="selected">Selecione o Jogo</option>
                <c:forEach items="${mb.listajogos}" var="linha">
  
          <option value="${linha.idJogos}"> ${linha.nomeJogos} </option>
        </c:forEach>
              </select>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <select id="funcao" class="validate" name="funcao">
                <option disabled="disabled" value="0" disabled selected>Selecione sua Função</option>
                
              </select>
            </div>
          </div>

          <div class="row">
            <div class="row">
              <div class="input-field col s12">
                <select id="plataforma" name="plataforma">
           
                    <option value="0" disabled="disabled" selected="selected">Plataforma</option>
	             </select>
              </div>
              
            </div>
          </div>


          <br/><br/>
          <button class="btn waves-effect green" type="submit" name="action">Cadastrar
            <i class="material-icons right">save</i>
          </button>
        </form>
      </div>
    </div>
  </div>

  </div>












<!--Footer-->

<footer class="page-footer #263238 blue-grey darken-5">
  <div class="container">
    <div class="row">
      <div class="col l4 offset-l2 s12">
        <h5 class="white-text"></h5>
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
            <li><a class="grey-text text-lighten-3">Contato:dontplayalonegroup@gmail.com</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="row">
    <a class="grey-text text-lighten-4 center">© 2017 Todos os direitos reservados</a>
           
        
    </div>
  </div>
</footer>
<!--Footer-->





<!--Jquery-->
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<!-- Materialize JS-->
<script src="js/materialize.js"></script>
<script>
 $(document).ready(function() {

	 	jQuery('#busca').submit(function (e) {
	         

	         if (!validaCombos()) {
	        	 e.preventDefault();
	        	 return;
	         }
         alert("Cadastrado");
         //Materialize.toast('dasdasdasda!', 6000)    
	     });
	 });
 
function validaCombos() {
	
	if ($("#jogo").val() == null) {
		Materialize.toast('Não selecionou o jogo!', 4000)
		//alert("Não selecionou a função!");
		return false;
	}
    
	if ($("#funcao").val() == null) {
		Materialize.toast('Não selecionou a função!', 4000)
		//alert("Não selecionou a função!");
		return false;
	}
	
	if ($("#plataforma").val() == null) {
		Materialize.toast('Não selecionou a plataforma!', 4000)
		//alert("Não selecionou a plataforma!");
		return false;
	}
	
	return true;
}

</script>
<script>
//menu mobile
$(".button-collapse").sideNav();
</script>

<script>
 $(document).ready(function() {
  $('select').material_select();
});
</script>



</body>
</html>