
	$(document).ready(function(){
		  
		  var dados = {cmd: "consultaJogadoresSistema"};
		  $.ajax({
				 type:"POST",
				 url:"../ControleAdministrador",
				 data:dados,
				 dataType: "json",
				 success:function(data){
					 html = "";
					 	
					 	$('#jogos').empty().append('<option value="0" disabled="disabled" selected="selected">Selecionar Jogos</option>');
					 	for (i in data.pessoasLogin ) {
		            	//alert(data.listaJogosCadastrados);
		            	        
					 			$('#pessoa').append('<option value="' + data.pessoasLogin[i].idPessoa + '">' + data.pessoasLogin[i].nomePessoa + '</option>');
			                    
		            			html += '<tr>';
		            		    html += '<td id="' + data.pessoasLogin[i].idPessoa   +    '">' + data.pessoasLogin[i].nomeUsuario + '</td>';
		            			html += '<td>' + data.pessoasLogin[i].login[0].email + '</td>';
		            		    html += '<td>' + data.pessoasLogin[i].sexo           + '</td>';
		            		    html += '<td>' + data.pessoasLogin[i].dataNascimento + '</td>';
		            		    html += '<td>' + data.pessoasLogin[i].dataCadastro   + ' </td>';
		            		    html += '<td>' + data.pessoasLogin[i].login[0].status+ '</td>';
		            		    
		            		    html += '<td><a onclick="filtraRolesPlataformas(' + data.listaJogosCadastrados[i].idJogos + ',\'' + data.listaJogosCadastrados[i].nomeJogos + '\')" class="waves-effect waves-red white-btn"><i class="small material-icons orange-text alterar">mode_edit</i></a></td>';
		            		    html += '</tr>';
		            	 }
					 	
					 		$('#jogos').material_select();
		            	    $("#corpoTabela").html(html);
		            		//alert(html);
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


