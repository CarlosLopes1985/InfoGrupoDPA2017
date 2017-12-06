<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!--><title th:text="${codigo == null ? 'Cadastro de cliente' : 'EdiÃ§Ã£o de cliente'}">Cadastro de cliente</title>
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


  
  <div class="card-panel">
    <div class="row">
      <form class="form-horizontal" name="formCadastro" method="post" action="Controle?cmd=lembrarSenha">
    

        <div class="row">
          <div class="input-field col s4">
            <input id="email" type="email" class="validate"  name="email" required >
            <label for="lembrarSenha" data-error="Email Inválido" data-success="Email Válido">Email</label>
            ${ msg}
          </div>

</div>

        <div class="input-field col s4">
          <br>

          <button class="btn waves-effect #263238 blue-grey darken-5" type="submit" name="action">Enviar E-Mail
          <i class="material-icons right">send</i></button>
          </div>
        </form>
      </div>
      <br><br><br><br>
    
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




</body>
</html>