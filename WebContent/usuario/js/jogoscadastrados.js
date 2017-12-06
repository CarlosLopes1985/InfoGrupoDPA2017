function updateStatusJogoUsuario(idJogo,status) {
		
		var dados = {cmd: "updateJogoUsuario", idNumero: idJogo, situacao: status};
		$bool = null;	
		
		if (idJogo != null) {
			$.ajax({
				type: "POST",
				url: "../Controle",
				data: dados,
				dataType: "json",
	            success: function (data) {
	            	if (data.resposta == "sucesso") {
	            		if (status == "true") {
		               		
		               		$("#olho" + idJogo).removeClass("green-text");
		               		$("#olho" + idJogo).addClass("red-text");
		               		$("#olho" + idJogo).text("visibility_off");
		               		$("#aolho" + idJogo).attr("onclick", "updateStatusJogoUsuario(" + idJogo +",'false')");
		               	}
	            		
	            		if (status == "false") {
		               		
		               		$("#olho" + idJogo).removeClass("red-text");
		               		$("#olho" + idJogo).addClass("green-text");
		               		$("#olho" + idJogo).text("visibility");
		               		$("#aolho" + idJogo).attr("onclick", "updateStatusJogoUsuario(" + idJogo +",'true')");
		               	}
	            	}
	            	
	            },
		    	error: function (XMLHttpRequest, textStatus, errorThrown) {
		            
		    		html = '<h3>XMLHttpRequest</h3>';
		            for (i in XMLHttpRequest) {
		                if (i != "channel")
		                    html += i + " : " + XMLHttpRequest[i] + "<br>";
		            }
		
		            html += '<h3>textStatus</h3>';
		            html += textStatus;
		
		            html += '<h3>errorThrown</h3>';
		            html += errorThrown;
		            $("#respostaerro").html("<pre>" + html + "</pre>");
		
		        }
			});
		}
		
	}
      

$(document).ready(function(){
	  
	  var dados = {cmd: "montarTabelaJgCadastrados"};
	  $.ajax({
			 type:"POST",
			 url:"../Controle",
			 data:dados,
			 dataType: "json",
			 success:function(data){
				 html = "";
				 	
				 	$('#jogos').empty().append('<option value="0" disabled="disabled" selected="selected">Selecionar Jogos</option>');
				 	for (i in data.listaJogosCadastrados ) {
	            	//alert(data.listaJogosCadastrados);
	            	        
				 			$('#jogos').append('<option value="' + data.listaJogosCadastrados[i].idJogos + '">' + data.listaJogosCadastrados[i].nomeJogos + '</option>');
		                    
	            			html += '<tr>';
	            		    html += '<td id="' + data.listaJogosCadastrados[i].idJogos + '">' + data.listaJogosCadastrados[i].nomeJogos + '</td>';
	            			html += '<td>' + data.listaJogosCadastrados[i].roles[0].nome +'</td>';
	            		    html += '<td>' + data.listaJogosCadastrados[i].plataformas[0].nomePlataforma + '</td>';
	            		    html += '<td><a onclick="filtraRolesPlataformas(' + data.listaJogosCadastrados[i].idJogos + ',\'' + data.listaJogosCadastrados[i].nomeJogos + '\')" class="waves-effect waves-red white-btn"><i class="small material-icons orange-text alterar">mode_edit</i></a></td>';
	            		    if(data.listaJogosCadastrados[i].status == true){
	            		    html += '<td><a id="aolho' + data.listaJogosCadastrados[i].idJogos + '" onclick="updateStatusJogoUsuario(' + data.listaJogosCadastrados[i].idJogos + ',\'' + data.listaJogosCadastrados[i].status + '\')" class="waves-effect waves-red white-btn"><i id="olho' + data.listaJogosCadastrados[i].idJogos + '" class="small material-icons green-text" >visibility</i></a></td>';
	            		    }else{
	            		    	html += '<td><a id="aolho' + data.listaJogosCadastrados[i].idJogos + '" onclick="updateStatusJogoUsuario(' + data.listaJogosCadastrados[i].idJogos + ',\'' + data.listaJogosCadastrados[i].status + '\')" class="waves-effect waves-red white-btn"><i id="olho' + data.listaJogosCadastrados[i].idJogos + '" class="small material-icons red-text" >visibility_off</i></a></td>';	
	            		    }
	            		    html += '<td><a class="waves-effect waves-red white-btn"><i class="small material-icons blue-text share">share</i></a></td>';
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
