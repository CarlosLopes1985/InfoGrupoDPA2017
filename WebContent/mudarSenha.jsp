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
      <form class="form-horizontal" name="formCadastro" method="post" action="Controle?cmd=mudarSenha">
        

        <div class="row">
          <div class="input-field col s4">
            <input id="password" type="password" class="validate"  name="senha" required >
            <label for="mudarSenha">Senha</label>
          </div>

</div>
<div class="row">
          <div class="input-field col s4">
            <input id="confirm_password" type="password" class="validate"  name="email" required >
            <label for="mudarSenha">Confirmar Senha</label>
          </div>

</div>
<div class="row">
          <div class="input-field col s4">
            <input id="lembrarSenha" type="text" class="validate"  name="chave" required >
            <label for="mudarSenha">Digite a palavra chave</label>
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
        <h5 class="white-text">Footer Content</h5>
        <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
      </div>
      <div class="col l4 offset-l2 s12">
        <h5 class="white-text">Links</h5>
        <ul>
          <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
          <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
          <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
          <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="footer-copyright">
    <div class="container">
      Â© 2017 Todos os direitos reservados.
      <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
    </div>
  </div>
</footer>
<!--Footer-->

<!-- Modal Structure -->
<div id="modal1" class="modal">

    <div class="modal-content">

      <div id="login-page" class="row">
    <div class="col s12 z-depth-4 class=card hoverable small">
      <form class="login-form">
        
        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-social-person-outline prefix"></i>
            <input id="username" type="email">
            <label for="username" class="center-align">E-mail</label>
          </div>
        </div>

        <div class="row margin">
          <div class="input-field col s12">
            <i class="mdi-action-lock-outline prefix"></i>
            <input id="password" type="password">
            <label for="password">Senha</label>
          </div>
        </div>
        <div class="container">          
        <input type="checkbox" class="filled-in" id="lembrar" checked="checked" />
            <label for="lembrar">Lembrar</label>
            </div>

        <div class="row">
          <div class="input-field col s12">
            <a href="logadocomprofileteste.html" class="btn waves-effect waves-light col s12">Login</a>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6 m6 l6">
            <p class="margin medium-small"><a href="cadastro.html">Cadastre-se Agora!</a></p>
          </div>
          <div class="input-field col s6 m6 l6">
              <p class="margin right-align medium-small"><a href="forgotpassword.html">Esqueceu a senha?</a></p>
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

<script>
var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("A senha n�o combina");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>




</body>
</html>