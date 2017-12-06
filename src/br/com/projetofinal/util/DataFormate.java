package br.com.projetofinal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormate {


	public Date converte ( String data  ) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date Data = sdf.parse( data ); 
		
		return Data;
	}
}
