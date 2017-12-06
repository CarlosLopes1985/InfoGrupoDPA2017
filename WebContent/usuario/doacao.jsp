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


          <ul id="nav-mobile" class="right hide-on-med-and-down">




            
            <div class="row">
              <ul id="slide-out" class="side-nav fixed">
                <li><div class="user-view">
          <div class="background" style="background-color:#263238;">
            
          </div class="row">
          <a href="#!user"><img class="circle" src="img/eu.jpg"></a>
          <a><span class="white-text name"> ${pessoa.nomeUsuario}</span></a>
          <a href="#!name"><i class="material-icons">star</i></a>
          
        </div></li>
                <li><a href="profile.jsp"><i class="material-icons">person</i>Perfil</a></li>
                <li><a href="escolherJogos.jsp"><i class="material-icons">videogame_asset</i>Escolher jogos</a></li>
                <li><a href="jogosCadastrados.jsp"><i class="material-icons">videogame_asset</i>Jogos Cadastrados</a></li>
                
                <li><a href="logout.jsp"><i class="material-icons">exit_to_app</i>Sair</a></li>

    
  </ul>
</div>

    

</div>


</ul>

</div>
</nav>



<div>


    </div>

  <div class="input-field col s5">
    <div class="card hoverable col s12 m12">
      <h1 align="right">Ajude a manter o site</h1>
       <h2 align="right">E concorra a Brindes</h2>
       
       <h3>Agencia:xxxx</h3>
       <h3>Conta: xxxxx-x</h3>
       <h3>Favorecido: Dont Play alone</h3>
	
    </div>


  </div>


</div>
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
            <li><a class="grey-text text-lighten-3" href="doacao.jsp">Ajude a Manter o Site</a></li>
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

</body>
</html>