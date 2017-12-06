function filtraRolesPlataformas(idJogoExp, nomeJogoExp) {
	
	var dados = {cmd: "consultaJogo", idJogo: idJogoExp};
	$bool = null;	
	
	if (idJogoExp != null) {
		$.ajax({
			type: "POST",
			url: "../Controle",
			data: dados,
			dataType: "json",
            success: function (data) {
            
            	if (data.resposta == "true") {
	               	
            		$('#funcao').material_select('destroy');
            		
            		$('#funcao').removeAttr('disabled');
	                $('#funcao').empty().append('<option value="0" disabled="disabled" selected="selected">Fun&ccedil;&atilde;o a ser encontrada</option>');
	                
	                for (i in data.listaJR) {
	                	
	                    $('#funcao').append('<option value="' + data.listaJR[i].idRoles + '">' + data.listaJR[i].nome + '</option>');
	                }
	                
	                $('#funcao').material_select();
	                $('#plataforma').material_select('destroy');
	                
	               	$('#plataforma').removeAttr('disabled');
	                $('#plataforma').empty().append('<option value="0" disabled="disabled" selected="selected">Plataforma</option>');
	                
	                for (i in data.listaJP) {
	                    $('#plataforma').append('<option value="' + data.listaJP[i].idPlataforma + '">' + data.listaJP[i].nomePlataforma + '</option>');
	                }
	                
	                $('#plataforma').material_select();
	                $('#modalnomejogos').text(nomeJogoExp);
	               	$('#modalidjogo').val(idJogoExp);
	                $('#modal').modal('open');
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

