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
  <!--Jquery-->
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<!-- Materialize JS-->
<script src="js/materialize.js"></script>
<script src="../usuario/js/socket.io-1.2.0.js"></script>
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
                <li><a href="escolherJogos.jsp"><i class="material-icons">videogame_asset</i>Escolher jogos</a></li>
                <li><a href="jogosCadastrados.jsp"><i class="material-icons">videogame_asset</i>Jogos Cadastrados</a></li>
                <li><a href="listaMensagens.jsp"  class="green-text"><i class="material-icons green-text">chat</i>Mensagens <span id="newMsg" class=""></span></a></li>
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
<div class="input-field col s9">
    <div id="chat" style="min-height : 300px;" class="card col s12 offset-s4">
    </div>
    </div>
    

  <div class="input-field col s9">
    <div class="card col s12 offset-s4">
      <div class="card-content black-text">

        
        
        <div class="input-field col s12">
          <input type="text" maxlength="200" id="msginput" onkeypress="return runChat(event)" placeholder="Digite aqui sua mensagem" class="sizeinput form-control">
        </div>
        
        <br/><br/>
          <button id="enviar" class="btn waves-effect green" name="action">Enviar
            <i class="material-icons right">send</i>
          </button>
        
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
            <li><a id="resultado" class="grey-text text-lighten-3" href="#!">teste</a></li>
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

function runChat(event) {
    if (event.which == 13 || event.keyCode == 13) {
        $('#enviar').click();
        return false;
    }
};

	var $socket = io('http://localhost:3000/');

	$(document).ready(function(){
		
		$idSala = 0;
		
    	var getUrlParameter = function getUrlParameter(sParam) {
    	    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
    	        sURLVariables = sPageURL.split('&'),
    	        sParameterName,
    	        i;

    	    for (i = 0; i < sURLVariables.length; i++) {
    	        sParameterName = sURLVariables[i].split('=');

    	        if (sParameterName[0] === sParam) {
    	            return sParameterName[1] === undefined ? true : sParameterName[1];
    	        }
    	    }
    	};
    	
    	var idPessoa = getUrlParameter('idPessoa');
    	var nomeUsuario = getUrlParameter('nomeUsuario');
    	
    	if (!(typeof idPessoa == "undefined") && !(typeof nomeUsuario == "undefined")) {

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

					$('#enviar').attr("onclick", "cadastrarMensagens(" + data.idSala + ")");
    				$idSala = data.idSala;
    				
    				room = 'room' + $idSala;
    		    	mensagem = $("#msginput").val();

					$socket.emit('create', room);
    		    	    
    		    	$socket.on('chat message', function(msg, room){
    		    	  $('#chat').append('<li>' + msg + '</li>');
    		    	});
    			}
    		});
    	}
    	
    	var idSala = getUrlParameter('idSala');
    	
    	
    	if (!(typeof idSala == "undefined")) {
    		$idSala = idSala;
    		var dados = {
    			cmd : "carregaMensagens",
    			idSala : idSala
    		};

    		$.ajax({
    			type : "POST",
    			url : "../Controle",
    			data : dados,
    			dataType : "json",
    			success : function(data) {
    				//alert(data.mensagens[0].mensagem);
    				for (i in data.mensagens) {
    					$("#chat").append('<li>'+ data.mensagens[i].pessoa.nomeUsuario + " diz: " + data.mensagens[i].mensagem + '</li>');
    				}
    				$('#enviar').attr("onclick", "cadastrarMensagens(" + idSala + ")");
    				
    				room = 'room' + $idSala;
    		    	mensagem = $("#msginput").val();

					$socket.emit('create', room);
    		    	    
    		    	$socket.on('chat message', function(msg, room){
    		    	  $('#chat').append('<li>' + msg + '</li>');
    		    	});
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
    	}
    	/*
    	room = 'room' + $idSala;
    	mensagem = $("#msginput").val();
		alert($idSala);
    	socket.emit('create', room);
    	    
    	socket.on('chat message', function(msg, room){
    	  $('#chat').append('<li>' + msg + '</li>');
    	});
    	*/
    });

	//############################
	//############################
	//############################
	
	//var socket = io('http://localhost:3000/');
	/*
	$(function () {
	    mensagem = $("#msginput").val();

		socket.on('chat message', function(msg){
	      $('#chat').append('<li>Eu diz: ' + msg + '</li>');
	    });
	  });
	*/
	
	/*
    REPLACE THE IO HTTP URL BELLOW, TO YOUR OWN SERVER EX: LOCALHOST OR HTTP://YOURSERVER.COM
    
    var socket_connect = function (idSala) {
        //return io('http://chat.local:3000', {
		return io('http://localhost:3000/', {
            query: 'r_var='+idSala
        });
    }

    // socket connect: var is the room id
    // THE ROOM ID IS UP TO YOUR APP OR SESSION
    var socket = socket_connect(idSala);

    socket.on('chat message', function(msg){
	    $('#chat').append($('<li>').text(msg));
	});
	*/
	//############################
	//############################
	//############################
	
    function cadastrarMensagens(idSala) {
		
    	mensagem = $("#msginput").val();
		
    	if( mensagem ==''){
    		return false;	
    	}
    	
		var dados = {
			cmd : "cadastrarMensagem",
			texto : mensagem,
			idSala : idSala
		};

		$.ajax({
			type : "POST",
			url : "../Controle",
			data : dados,
			dataType : "json",
			success : function(data) {

				if (data.resposta == "sucesso") {
					  room = 'room' + $idSala;
					  $socket.emit('chat message', mensagem, room, data.respostaNomeUsuario );
				    
					  $('#msginput').val('');
				      return false;
				
					$("#chat").append(mensagem);
				} else {
					alert("Não enviada");
				}
			}
		});

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