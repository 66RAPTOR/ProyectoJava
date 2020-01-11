package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ven_tipopago database table.
 * 
 */
@Entity
@Table(name="ven_tipopago")
@NamedQuery(name="VenTipopago.findAll", query="SELECT v FROM VenTipopago v")
public class VenTipopago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipopago", unique=true, nullable=false)
	private Integer idTipopago;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to VenFactura
	@OneToMany(mappedBy="venTipopago")
	private List<VenFactura> venFacturas;

	public VenTipopago() {
	}

	public Integer getIdTipopago() {
		return this.idTipopago;
	}

	public void setIdTipopago(Integer idTipopago) {
		this.idTipopago = idTipopago;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<VenFactura> getVenFacturas() {
		return this.venFacturas;
	}

	public void setVenFacturas(List<VenFactura> venFacturas) {
		this.venFacturas = venFacturas;
	}

	public VenFactura addVenFactura(VenFactura venFactura) {
		getVenFacturas().add(venFactura);
		venFactura.setVenTipopago(this);

		return venFactura;
	}

	public VenFactura removeVenFactura(VenFactura venFactura) {
		getVenFacturas().remove(venFactura);
		venFactura.setVenTipopago(null);

		return venFactura;
	}

}