package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ven_factura database table.
 * 
 */
@Entity
@Table(name="ven_factura")
@NamedQuery(name="VenFactura.findAll", query="SELECT v FROM VenFactura v")
public class VenFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_factura", unique=true, nullable=false, length=15)
	private String idFactura;

	@Column(name="base_cero", nullable=false, precision=16, scale=2)
	private BigDecimal baseCero;

	@Column(name="base_imponible", nullable=false, precision=16, scale=2)
	private BigDecimal baseImponible;

	@Column(nullable=false, length=7)
	private String estado;

	@Column(nullable=false)
	private Boolean estadopagado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_emicion", nullable=false)
	private Date fechaEmicion;

	@Column(nullable=false, precision=16, scale=2)
	private BigDecimal subtotal;

	@Column(nullable=false, precision=16, scale=2)
	private BigDecimal total;

	//bi-directional many-to-one association to VenCredito
	@OneToMany(mappedBy="venFactura")
	private List<VenCredito> venCreditos;

	//bi-directional many-to-one association to VenDetalle
	@OneToMany(mappedBy="venFactura")
	private List<VenDetalle> venDetalles;

	//bi-directional many-to-one association to SegPersona
	@ManyToOne
	@JoinColumn(name="id_persona", nullable=false)
	private SegPersona segPersona;

	//bi-directional many-to-one association to VenEmisor
	@ManyToOne
	@JoinColumn(name="id_emisor")
	private VenEmisor venEmisor;

	//bi-directional many-to-one association to VenTipopago
	@ManyToOne
	@JoinColumn(name="id_tipopago", nullable=false)
	private VenTipopago venTipopago;

	public VenFactura() {
	}

	public String getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}

	public BigDecimal getBaseCero() {
		return this.baseCero;
	}

	public void setBaseCero(BigDecimal baseCero) {
		this.baseCero = baseCero;
	}

	public BigDecimal getBaseImponible() {
		return this.baseImponible;
	}

	public void setBaseImponible(BigDecimal baseImponible) {
		this.baseImponible = baseImponible;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getEstadopagado() {
		return this.estadopagado;
	}

	public void setEstadopagado(Boolean estadopagado) {
		this.estadopagado = estadopagado;
	}

	public Date getFechaEmicion() {
		return this.fechaEmicion;
	}

	public void setFechaEmicion(Date fechaEmicion) {
		this.fechaEmicion = fechaEmicion;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<VenCredito> getVenCreditos() {
		return this.venCreditos;
	}

	public void setVenCreditos(List<VenCredito> venCreditos) {
		this.venCreditos = venCreditos;
	}

	public VenCredito addVenCredito(VenCredito venCredito) {
		getVenCreditos().add(venCredito);
		venCredito.setVenFactura(this);

		return venCredito;
	}

	public VenCredito removeVenCredito(VenCredito venCredito) {
		getVenCreditos().remove(venCredito);
		venCredito.setVenFactura(null);

		return venCredito;
	}

	public List<VenDetalle> getVenDetalles() {
		return this.venDetalles;
	}

	public void setVenDetalles(List<VenDetalle> venDetalles) {
		this.venDetalles = venDetalles;
	}

	public VenDetalle addVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().add(venDetalle);
		venDetalle.setVenFactura(this);

		return venDetalle;
	}

	public VenDetalle removeVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().remove(venDetalle);
		venDetalle.setVenFactura(null);

		return venDetalle;
	}

	public SegPersona getSegPersona() {
		return this.segPersona;
	}

	public void setSegPersona(SegPersona segPersona) {
		this.segPersona = segPersona;
	}

	public VenEmisor getVenEmisor() {
		return this.venEmisor;
	}

	public void setVenEmisor(VenEmisor venEmisor) {
		this.venEmisor = venEmisor;
	}

	public VenTipopago getVenTipopago() {
		return this.venTipopago;
	}

	public void setVenTipopago(VenTipopago venTipopago) {
		this.venTipopago = venTipopago;
	}

}