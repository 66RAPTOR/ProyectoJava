package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the inv_producto database table.
 * 
 */
@Entity
@Table(name="inv_producto")
@NamedQuery(name="InvProducto.findAll", query="SELECT i FROM InvProducto i")
public class InvProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_producto", unique=true, nullable=false, length=25)
	private String idProducto;

	private Integer cantidad;

	@Column(length=200)
	private String descripcion;

	private Integer maximo;

	private Integer minimo;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(name="precio_coste", nullable=false, precision=10, scale=2)
	private BigDecimal precioCoste;

	@Column(name="precio_venta", nullable=false, precision=10, scale=2)
	private BigDecimal precioVenta;

	//bi-directional many-to-one association to InvCategoria
	@ManyToOne
	@JoinColumn(name="id_categoria", nullable=false)
	private InvCategoria invCategoria;

	//bi-directional many-to-one association to InvMarcaproducto
	@ManyToOne
	@JoinColumn(name="id_marcaproducto")
	private InvMarcaproducto invMarcaproducto;

	//bi-directional many-to-one association to InvModelo
	@ManyToOne
	@JoinColumn(name="id_modelo")
	private InvModelo invModelo;

	//bi-directional many-to-one association to ProProveedor
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private ProProveedor proProveedor;

	//bi-directional many-to-one association to VenIva
	@ManyToOne
	@JoinColumn(name="id_iva", nullable=false)
	private VenIva venIva;

	//bi-directional many-to-one association to VenDetalle
	@OneToMany(mappedBy="invProducto")
	private List<VenDetalle> venDetalles;

	public InvProducto() {
	}

	public String getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMaximo() {
		return this.maximo;
	}

	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public Integer getMinimo() {
		return this.minimo;
	}

	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioCoste() {
		return this.precioCoste;
	}

	public void setPrecioCoste(BigDecimal precioCoste) {
		this.precioCoste = precioCoste;
	}

	public BigDecimal getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public InvCategoria getInvCategoria() {
		return this.invCategoria;
	}

	public void setInvCategoria(InvCategoria invCategoria) {
		this.invCategoria = invCategoria;
	}

	public InvMarcaproducto getInvMarcaproducto() {
		return this.invMarcaproducto;
	}

	public void setInvMarcaproducto(InvMarcaproducto invMarcaproducto) {
		this.invMarcaproducto = invMarcaproducto;
	}

	public InvModelo getInvModelo() {
		return this.invModelo;
	}

	public void setInvModelo(InvModelo invModelo) {
		this.invModelo = invModelo;
	}

	public ProProveedor getProProveedor() {
		return this.proProveedor;
	}

	public void setProProveedor(ProProveedor proProveedor) {
		this.proProveedor = proProveedor;
	}

	public VenIva getVenIva() {
		return this.venIva;
	}

	public void setVenIva(VenIva venIva) {
		this.venIva = venIva;
	}

	public List<VenDetalle> getVenDetalles() {
		return this.venDetalles;
	}

	public void setVenDetalles(List<VenDetalle> venDetalles) {
		this.venDetalles = venDetalles;
	}

	public VenDetalle addVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().add(venDetalle);
		venDetalle.setInvProducto(this);

		return venDetalle;
	}

	public VenDetalle removeVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().remove(venDetalle);
		venDetalle.setInvProducto(null);

		return venDetalle;
	}

}