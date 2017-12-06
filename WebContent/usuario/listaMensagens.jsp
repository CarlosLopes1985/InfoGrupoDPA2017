<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<jsp:useBean class="br.com.projetofinal.manager.ManagerBean" id="mb"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width-device-width,initial-scale=1.0"/>
  <title> TCC </title>
  
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
  
  <link rel="stylesheet" href="css/materialize.css"/>
    
<script type="text/javascript" src="../usuario/js/filtraRolesPlataformas.js">

</script>
  
</head>
<body style="background-color:#78909c;">

  
  <div class="navbar">
    <nav class="#263238 blue-grey darken-5">
      <div class="nav-wrapper container">
        <a href="#!" class="brand-logo">Logo</a>
        
          <a data-activates="menu-mobile" class="button-collapse left">
        <i class="material-icons">menu</i> </a>


          <ul id="nav-mobile" class="right hide-on-med-and-down"></ul>




            
            <div class="row">
              <ul id="slide-out" class="side-nav fixed">
                <li><div class="user-view">
          <div class="background" style="background-color:#263238;">
            
          </div>
          <a href=""><img class="circle" src="${pessoa.foto}"></a>
          <a><span class="white-text name"> ${pessoa.nomeUsuario}</span></a>
          <br>
          <!--  <a href="#!name"><i class="material-icons">star</i></a>-->
          
        </div></li>
                <li><a href="profile.jsp"><i class="material-icons">person</i>Perfil</a></li>
                <li><a href="logadoUsuario.jsp"><i class="material-icons">search</i>Busca de Jogadores</a></li>
                <li><a href="escolherJogos.jsp"><i class="material-icons">videogame_asset</i>Escolher jogos</a></li>
                <li><a href="jogosCadastrados.jsp"><i class="material-icons">videogame_asset</i>Jogos Cadastrados</a></li>
                <li><a class="subheader green-text"><i class="material-icons green-text">chat</i>Mensagens</a></li>
                <li><a href="logout.jsp"><i class="material-icons">exit_to_app</i>Sair</a></li>

    
  </ul>
</div>
</div>
</nav>
    

</div>






<div>
<div class="row">

  <div class="input-field col s9">
    <div class="card hoverable col s12 offset-s4">
      <div class="card-content black-text">
  		<span class="card-title">Lista de Conversas</span>

                            <table class="responsive-table highlight">
                                <thead>
                                <tr>
                                    
                                    <th>Nome</th>
                                    <th>Chat</th>
                                    <th></th>
                                    
                                </tr>
                                </thead>
                                <tbody id="corpoTabela">
                                </tbody>
   
                            </table>
      </div>

    </div>


  </div>
</div>

</div>
<br><br><br><br><br><br><br>
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
            <li><a id="resultado" class="grey-text text-lighten-3" href="#!">Novidades</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Dicas</a></li>
            <li><a class="grey-text text-lighten-3" href="#!">Lojas</a></li>
            <li><a class="grey-text text-lighten-3" href="doacao.jsp">Ajude a Manter o Site</a></li>
            <li><a class="grey-text text-lighten-3">Contato:dontplayalonegroup@gmail.com</a></li>
        </ul>
      </div>
      <div id="respostaerro">
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="row">
    <a class="grey-text text-lighten-4 center">© 2017 Todos os direitos reservados</a>
           
        
    </div>
  </div>
</footer>
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

<script>
formReset.find('select.initialized').each(function () {
    var reset_text = formReset.find('option[selected]').text();
    formReset.siblings('input.select-dropdown').val(reset_text);
  });
</script>

<script>

var tempoAtualizacao = 2000;
var start = new Date;

setInterval(function() {
	var dado = {cmd : "verificaStatusMsg"};
	$.ajax({
		type : "POST",
		url : "../Controle",
		data : dado,
		dataType : "json",
		success : function(data) {
			if (data.resposta == "sim") {
				
				html = '';
				
				for (i in data.chats) {
					html += '<tr>';
					
					html += '<th>' + data.chats[i].sala.nomeSala + '</th>';
					html += '<th><a class="waves-effect waves-red white-btn" href="messages.jsp?idSala=' + data.chats[i].sala.idSala + '"><i class="small material-icons blue-text alterar" >chat</i></a>';
					/* html += '<th>'; */
					if (data.chats[i].statusMsg) {
						html += '<span class="new badge red">';
					}
					html+= '</th>'
					html += '</tr>';
				}
				
				$("#corpoTabela").html(html);
				
			} else {
				alert("nada");
			}
		},error: function (XMLHttpRequest, textStatus, errorThrown) {
		    html = '<h3>XMLHttpRequest</h3>';
		    for (i in XMLHttpRequest) {
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
}, tempoAtualizacao);

	function abrirChat(idPessoa, nomeUsuario) {

		var dados = {
			cmd : "criarSala",
			idPessoa : idPessoa,
			nomeUsuario : nomeUsuario
		};

		$.ajax({
			type : "POST",
			url : "../Controle",
			data : dados,
			dataType : "json",
			success : function(data) {
				alert(data.idSala + '-' + data.nomeSala);
			}
		});
	}
</script>


</body>
</html>