package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;


import org.apache.logging.log4j.LogManager;




import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.BeansGE1.FacturaBean;


@Controller
public class FacturaController {
	
	final static Logger logger = LogManager.getLogger(ge_Controller.class.getName());
	
	//@Autowired
	//FacturaBean factura;
	
	
	
	@GetMapping("/factura")
	public static String checkinEnviar(Model model) throws Exception {
		
		FacturaBean factura= new FacturaBean("pdf de factura");
		model.addAttribute("prueba",factura.toString());
		System.out.print(model.toString());
		
		
		return "facturacion";
		
	}

}
