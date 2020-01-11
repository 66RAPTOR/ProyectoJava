package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ven_credito database table.
 * 
 */
@Entity
@Table(name="ven_credito")
@NamedQuery(name="VenCredito.findAll", query="SELECT v FROM VenCredito v")
public class VenCredito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_credito", unique=true, nullable=false)
	private Integer idCredito;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Column(nullable=false, precision=16, scale=2)
	private BigDecimal monto;

	@Column(nullable=false, precision=16, scale=2)
	private BigDecimal total;

	//bi-directional many-to-one association to VenFactura
	@ManyToOne
	@JoinColumn(name="id_factura", nullable=false)
	private VenFactura venFactura;

	public VenCredito() {
	}

	public Integer getIdCredito() {
		return this.idCredito;
	}

	public void setIdCredito(Integer idCredito) {
		this.idCredito = idCredito;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public VenFactura getVenFactura() {
		return this.venFactura;
	}

	public void setVenFactura(VenFactura venFactura) {
		this.venFactura = venFactura;
	}

}