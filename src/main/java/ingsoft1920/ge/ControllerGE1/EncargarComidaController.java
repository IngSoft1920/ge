package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckOutBean;
import ingsoft1920.ge.BeansGE1.EncargarComidaBean;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
@Controller
public class EncargarComidaController {
	
	final static Logger logger = LogManager.getLogger(EncargarComidaController.class.getName());
	

	@Autowired
	EncargarComidaBean encargarComida;
	
	@Autowired
	 SesionBean sesion;
	
	//pedimos los restaurantes disponibles y mas cosas que de monento no usamos
	@GetMapping("/recibirInfo")
	public  String recibirInfo() throws Exception {
		
		HttpGet get= new HttpGet("http://piedrafita.ls.fi.upm.es:7003/infoRest");
		
		HttpClient client= HttpClientBuilder.create().build();
		
		HttpResponse response = client.execute(get);
		
		
		// Leemos la respuesta de la petición
		String respuesta = EntityUtils.toString(response.getEntity());
		
	
			return respuesta;
		
	}
	//damos el restaurante que queremos con el numero de gente que queremos y nos devulven las horas OCUPADAS
	@GetMapping("/pedirFechas")
	public void  fechas() throws Exception {

		JsonObject json = new JsonObject();
		  json.addProperty("rest_nom", "Mama Mia");
		  json.addProperty("capacidad", 2);
		  
				
		HttpPost post = new HttpPost("http://piedrafita.ls.fi.upm.es:7003/checkReservRest");
		  post.addHeader("Content-Type", "application/json");
		  post.addHeader("Accept", "application/json");
		  post.setEntity( new StringEntity(json.toString(),"UTF-8") ); // UTF-8 es importante por tildes y caracteres 'raros'
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(post);
		
		int codigoRespuesta = response.getStatusLine().getStatusCode();
		
		// Si el código de la respuesta es distinto de 200
		// entonces se ha producido un error
		if( codigoRespuesta != 200 ) {
			System.out.println("ERROR con código:"+codigoRespuesta+"\n");
			
		}
		
//		String resp="";
//		if(respCode==200) {
//			  resp=client.getResponseBody();}
//		model.addAttribute("sesionBean", sesion);

		
	}
//	@GetMapping("/encargarComidaEnviar")
//	public String encargar(@Valid @ModelAttribute("encargarComidaBean") EncargarComidaBean encargarComida,
//			Model model) throws Exception {
//
//		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7003/checkReservRest", "GET");
//		
//		client.setRequestBody("");
//		
//		int respCode = client.getResponseCode();
//		
//		String resp="";
//		if(respCode==200) {
//			  resp=client.getResponseBody();}
//        model.addAttribute("sesionBean",sesion);

		//return "";
		
//	}
	
	
	
	
	
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}
	


}
