package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ven_detalle database table.
 * 
 */
@Entity
@Table(name="ven_detalle")
@NamedQuery(name="VenDetalle.findAll", query="SELECT v FROM VenDetalle v")
public class VenDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ven_detalle", unique=true, nullable=false)
	private Integer idVenDetalle;

	@Column(nullable=false)
	private Integer cantidad;

	@Column(nullable=false, length=200)
	private String detalle;

	@Column(name="iva_vendido", nullable=false, precision=5, scale=2)
	private BigDecimal ivaVendido;

	@Column(name="precio_subtotal", nullable=false, precision=16, scale=2)
	private BigDecimal precioSubtotal;

	@Column(name="precio_unitario", nullable=false, precision=10, scale=2)
	private BigDecimal precioUnitario;

	//bi-directional many-to-one association to InvProducto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private InvProducto invProducto;

	//bi-directional many-to-one association to VenFactura
	@ManyToOne
	@JoinColumn(name="id_factura", nullable=false)
	private VenFactura venFactura;

	public VenDetalle() {
	}

	public Integer getIdVenDetalle() {
		return this.idVenDetalle;
	}

	public void setIdVenDetalle(Integer idVenDetalle) {
		this.idVenDetalle = idVenDetalle;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public BigDecimal getIvaVendido() {
		return this.ivaVendido;
	}

	public void setIvaVendido(BigDecimal ivaVendido) {
		this.ivaVendido = ivaVendido;
	}

	public BigDecimal getPrecioSubtotal() {
		return this.precioSubtotal;
	}

	public void setPrecioSubtotal(BigDecimal precioSubtotal) {
		this.precioSubtotal = precioSubtotal;
	}

	public BigDecimal getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public InvProducto getInvProducto() {
		return this.invProducto;
	}

	public void setInvProducto(InvProducto invProducto) {
		this.invProducto = invProducto;
	}

	public VenFactura getVenFactura() {
		return this.venFactura;
	}

	public void setVenFactura(VenFactura venFactura) {
		this.venFactura = venFactura;
	}

}