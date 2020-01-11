package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ven_emisor database table.
 * 
 */
@Entity
@Table(name="ven_emisor")
@NamedQuery(name="VenEmisor.findAll", query="SELECT v FROM VenEmisor v")
public class VenEmisor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_emisor", unique=true, nullable=false)
	private Integer idEmisor;

	@Column(name="codigo_estableciemitno", nullable=false, length=3)
	private String codigoEstableciemitno;

	@Column(name="codigo_puntoemicion", nullable=false, length=3)
	private String codigoPuntoemicion;

	@Column(name="direccion_establecimiento", nullable=false, length=100)
	private String direccionEstablecimiento;

	@Column(name="direccion_matriz", nullable=false, length=100)
	private String direccionMatriz;

	@Column(nullable=false, length=50)
	private String nombre;

	@Column(name="nombre_comercial", nullable=false, length=100)
	private String nombreComercial;

	@Column(name="num_autori_sri", nullable=false, length=10)
	private String numAutoriSri;

	@Column(nullable=false, length=13)
	private String ruc;

	//bi-directional many-to-one association to VenFactura
	@OneToMany(mappedBy="venEmisor")
	private List<VenFactura> venFacturas;

	public VenEmisor() {
	}

	public Integer getIdEmisor() {
		return this.idEmisor;
	}

	public void setIdEmisor(Integer idEmisor) {
		this.idEmisor = idEmisor;
	}

	public String getCodigoEstableciemitno() {
		return this.codigoEstableciemitno;
	}

	public void setCodigoEstableciemitno(String codigoEstableciemitno) {
		this.codigoEstableciemitno = codigoEstableciemitno;
	}

	public String getCodigoPuntoemicion() {
		return this.codigoPuntoemicion;
	}

	public void setCodigoPuntoemicion(String codigoPuntoemicion) {
		this.codigoPuntoemicion = codigoPuntoemicion;
	}

	public String getDireccionEstablecimiento() {
		return this.direccionEstablecimiento;
	}

	public void setDireccionEstablecimiento(String direccionEstablecimiento) {
		this.direccionEstablecimiento = direccionEstablecimiento;
	}

	public String getDireccionMatriz() {
		return this.direccionMatriz;
	}

	public void setDireccionMatriz(String direccionMatriz) {
		this.direccionMatriz = direccionMatriz;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getNumAutoriSri() {
		return this.numAutoriSri;
	}

	public void setNumAutoriSri(String numAutoriSri) {
		this.numAutoriSri = numAutoriSri;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public List<VenFactura> getVenFacturas() {
		return this.venFacturas;
	}

	public void setVenFacturas(List<VenFactura> venFacturas) {
		this.venFacturas = venFacturas;
	}

	public VenFactura addVenFactura(VenFactura venFactura) {
		getVenFacturas().add(venFactura);
		venFactura.setVenEmisor(this);

		return venFactura;
	}

	public VenFactura removeVenFactura(VenFactura venFactura) {
		getVenFacturas().remove(venFactura);
		venFactura.setVenEmisor(null);

		return venFactura;
	}

}