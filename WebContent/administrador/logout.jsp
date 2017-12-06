<body onload="window.refresh" onunload="window.refresh">
<%
try{
	
	//Invalidando a Sessão
	 session.setAttribute("usuario",null);
	 session.invalidate(); //apaga a sessão
	 
	 //Limpando a Mem
	 response.setHeader("Pragma","no-cache");
	 response.setHeader("Cache-Control","no-cache");
	 response.setDateHeader("Expires",0);
	 response.setDateHeader("max-age",0);
	 out.print("Logout Concluído");

}catch(Exception ex){
	ex.printStackTrace();
}
%>
<a href="../index.html">Voltar</a>
</body>