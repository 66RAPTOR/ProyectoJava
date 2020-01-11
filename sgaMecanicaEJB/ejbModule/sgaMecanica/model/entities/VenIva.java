package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ven_iva database table.
 * 
 */
@Entity
@Table(name="ven_iva")
@NamedQuery(name="VenIva.findAll", query="SELECT v FROM VenIva v")
public class VenIva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_iva", unique=true, nullable=false)
	private Integer idIva;

	@Column(nullable=false, precision=5, scale=2)
	private BigDecimal porcentaje;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="venIva")
	private List<InvProducto> invProductos;

	public VenIva() {
	}

	public Integer getIdIva() {
		return this.idIva;
	}

	public void setIdIva(Integer idIva) {
		this.idIva = idIva;
	}

	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setVenIva(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setVenIva(null);

		return invProducto;
	}

}