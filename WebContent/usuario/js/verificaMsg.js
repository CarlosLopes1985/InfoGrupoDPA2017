var tempoAtualizacao = 5000;
	var start = new Date;
	
	setInterval(function() {
		var dado = {cmd : "ativaBadge"};
		$.ajax({
			type : "POST",
			url : "../Controle",
			data : dado,
			dataType : "json",
			success : function(data) {
				if (data.resposta == "sim") {
					$("#newMsg").removeClass("new badge red");
					$("#newMsg").addClass("new badge red");
				} else {
					$("#newMsg").removeClass("new badge red");
				}
			}
		});
	}, tempoAtualizacao);