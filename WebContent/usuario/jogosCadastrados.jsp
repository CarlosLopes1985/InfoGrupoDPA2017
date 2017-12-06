<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  
  <title> TCC </title>
  
  <!--Import Google Icon Font-->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  
  <!-- Materialize CSS-->
  <link rel="stylesheet" href="css/materialize.css">
  <link rel="stylesheet" href="css/custom.css">
  
  <!--Jquery-->
  <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
  <script type="text/javascript" src="../usuario/js/verificaMsg.js"></script>  
  <!-- Materialize JS-->
  <script src="js/materialize.js"></script>
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
            
          </div class="row">
          <a href="#!user"><img class="circle" src="${pessoa.foto}"></a>
          <a href="#!name"><span class="white-text name"> ${pessoa.nomeUsuario}</span></a>
          <br>
        </div></li>
        		<li><a href="profile.jsp"><i class="material-icons">person</i>Perfil</a></li>
                <li><a href="logadoUsuario.jsp"><i class="material-icons">search</i>Busca de Jogadores</a></li>
                <li><a href="escolherJogos.jsp"><i class="material-icons">videogame_asset</i>Escolher jogos</a></li>
                <li><a class="subheader green-text"><i class="material-icons green-text">videogame_asset</i>Jogos Cadastrados</a></li>
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

<!--  <div class="row">
                <form class="col s6 offset-s4" method="post" action="../Controle?cmd=buscarJogosCadastrados">
                    <div class="row m12 s12">
                        <div class="card">
                            <div class="row">
                                <div class="card-content black-text">
                                    <div class="input-field col m6 s12 l6">
                                        <i class="material-icons prefix">search</i>
                                        <input type="text" id="autocomplete-input" class="autocomplete">
                                        <label for="autocomplete-input">Informe o jogo</label>
                                    </div>

                                    <div class="input-field s12 col m6">
                                        <select id="jogos" class="validate" name="idJogos">
                                            <option value="disabled" value="" disabled selected>Jogos</option>
                                            
                                        </select>
                                        <label for="selection">Jogos</label>
                                    </div>
                                </div>
                            </div>

                            <div class="card-action">
                                <button class="btn deep-purple darken-4 waves-effect waves-light" type="submit" name="action">Pesquisar
                                    <i class="material-icons right">send</i>
                                </button>
                                
                            </div>
                        </div>
                    </div>
                </form>
            </div>-->
            


<div class="row">
  <div class="container right">
    <div class="card hoverable col s12 m12 l11">
      <div class="card-content black-text">
        <span class="card-title">Jogos Cadastrados</span>

        <table class="responsive-table highlight">
          <thead>
            <tr>
              <th>Jogo</th>
              <th>Role</th>
              <th>Plataforma</th>
              <th>Editar</th>
              <th>Status</th>
              <th>Compartilhar</th>
              
           </tr>
           </thead>
				<tbody id="corpoTabela">
				

                                
                                   
                                       
                               
                                </tbody>
                                
   
                            </table> 
                            
            


         
     
    
  </div>
</div>
</div>
</div>


<div id="modal" class="modal center-align">

    <div class="modal-content">

      <div id="editar" class="row">
    <div class="col s12 z-depth-4" class="card hoverable small">
    <form method="post" action="../Controle?cmd=alterarPlataformaRoles">
      <div class="row">
            <div class="input-field col s6" >
              <h3 id="modalnomejogos"></h3>
             
              
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
              <select id="funcao" name="funcao">
                <option value="" disabled="disabled" selected="selected">Função</option>
              </select>
            </div>
          </div>

          <div class="row">
            
              <div class="input-field col s6">
                <select id="plataforma" name="plataforma">
           <!-- <select> -->
                    <option value="" disabled="disabled" selected="selected">Plataforma</option>
	             </select>
	             <button class="btn deep-orange darken-4 waves-effect" type="submit" name="action">Alterar
                                    <i class="material-icons right">data_edit</i>
                                </button>
                                <input type="hidden" name="jogos" id="modalidjogo" value=""></input>
              </div>
           </div>
            <strong>${msg}</strong>
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
 $(document).ready(function() {
  $('select').material_select();

  $('input.autocomplete').autocomplete({
    data: {
      "Apple": null,
      "Microsoft": null,
      "Google": 'https://placehold.it/250x250'
    },
    limit: 20, // The max amount of results that can be shown at once. Default: Infinity.
    onAutocomplete: function(val) {
      // Callback function when value is autcompleted.
    },
    minLength: 1, // The minimum length of the input for the autocomplete to start. Default: 1.
  });
 });
</script>

<script>
 $(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
 });
</script>



<script type="text/javascript" src="../usuario/js/jogoscadastrados.js"></script>
<script type="text/javascript" src="../usuario/js/filtraRolesPlataformas.js"></script>

</body>
</html>