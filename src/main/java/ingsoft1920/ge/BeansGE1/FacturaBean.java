package ingsoft1920.ge.BeansGE1;

public class FacturaBean {
	
	@Override
	public String toString() {
		return "FacturaBean [facturaPdf=" + facturaPdf + "]";
	}

	private String facturaPdf;

	public String getFactura() {
		return facturaPdf;
	}

	public void setFactura(String factura) {
		this.facturaPdf = factura;
	}

	public FacturaBean(String factura) {
		super();
		this.facturaPdf = factura;
	}

	public FacturaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
