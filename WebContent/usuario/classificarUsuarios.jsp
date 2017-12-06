<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  
  <title> TCC </title>
  
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  <!-- Materialize CSS-->
  <link rel="stylesheet" href="css/materialize.css">
  
  <!--Jquery-->
  <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
  
  <!-- Materialize JS-->
  <script src="js/materialize.js"></script>
</head>


<body style="background-color:black;">

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
            
          </div class="row">
          <a href="#!user"><img class="circle" src="img/eu.jpg"></a>
          <a href="#!name"><span class="white-text name"> ${pessoa.nomeUsuario}</span></a>
          <br>
        </div></li>
        		<li><a href="profile.jsp"><i class="material-icons">person</i>Perfil</a></li>
                <li><a href="logadoAdministrador.jsp"><i class="material-icons">videogame_asset</i>Cadastrar Jogos</a></li>
                <li><a href="adminRoles.jsp"><i class="material-icons">videogame_asset</i>Cadastrar Roles</a></li>
                <li><a href="adminPlataformas.jsp"><i class="material-icons">videogame_asset</i>Cadastrar Plataformas</a></li>
                <li><a href="adminJogoxroles.jsp"><i class="material-icons">assignment</i>Consultar Jogos</a></li>
                <li><a class="subheader green-text"><i class="material-icons green-text">assignment</i>Consultar Jogadores</a></li>
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
  <div class="col s12">
    <div class="card hoverable col s9 offset-s3">
      <div class="card-content black-text">
        <span class="card-title">Jogadores</span>

        <table class="responsive-table highlight">
          <thead>
            <tr>
              <th>Nome</th>
              <th>Data Conversa</th>
              <th>Nome Jogo</th>
              <th>Nome Role</th>
              <th>Partida Realizada</th>
              <th>Classificar Usuário</th>
           </tr>
           </thead>
				<tbody id="corpoTabela">
				</tbody>
        </table> 
                            
    </div>
     </div>
   </div>
</div>
<br>
<br>
<br>
<br>

<!--Footer-->

<footer class="page-footer #263238 blue-grey darken-5">
  <div class="container">
    <div class="row">
      <div class="col l4 offset-l2 s12">
        <h5 class="white-text"></h5>
        <h5 class="white-text">Diversão e Entreteinemento em um só lugar </h5>
          <p class="grey-text text-lighten-4">Monte suas equipes e organize batalhas com maior iteratividade com seus companheiros.</p>
      </div>
      <div id="respostaerro">
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

<script>
//menu mobile
$(".button-collapse").sideNav();
</script>


<script>
 $(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
 });
</script>

<script>
$(document).ready(function(){
	  
	  var dados = {cmd: "consultaConversasRealizadas"};
	  $.ajax({
			 type:"POST",
			 url:"../Controle",
			 data:dados,
			 dataType: "json",
			 success:function(data){
				 html = "";
				 	for (i in data.pessoasLogin ) {
	            	alert(data.pessoasLogin);
	            	        
	            			html += '<tr>';
	            		    html += '<td id="' + data.pessoasConversas[i].idPessoa       +    '">' + data.pessoasLogin[i].nomeUsuario + '</td>';
	            			html += '<td>'     + data.pessoasConversas[i].login.email    + '</td>';
	            		    html += '<td>'     + data.pessoasConversas[i].sexo           + '</td>';
	            		    html += '<td>'     + data.pessoasConversas[i].dataNascimento + '</td>';
	            		    html += '<td>'     + data.pessoasConversas[i].dataCadastro   + '</td>';
	            		    html += '<td>'     + data.pessoasConversas[i].login.status+    '</td>';
	            		    
	            		    html += '<td><a onclick="alterarJogador(' + data.pessoasLogin[i].idPessoa + '\')" class="waves-effect waves-red white-btn"><i class="small material-icons orange-text alterar">mode_edit</i></a></td>';
	            		    html += '</tr>';
	            	 }
				 	
	            	    $("#corpoTabela").html(html);
	            		
	            },
	            error: function (XMLHttpRequest, textStatus,  errorThrown) {
	                html = '<h3>XMLHttpRequest</h3>';
	                for(i in XMLHttpRequest) {
	                    if (i != "channel")
	                        html += i + " : " + XMLHttpRequest[i] + "<br>";
	                }
	                
	                html += '<h3>textStatus</h3>';
	                html += textStatus;
	                
	                html += '<h3>errorThrown</h3>';
	                html += errorThrown;
	                $("#resultado").html(html);
	                
	            }
	        });
});


</script>

</body>
</html>