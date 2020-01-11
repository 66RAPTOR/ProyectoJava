package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_modelo database table.
 * 
 */
@Entity
@Table(name="inv_modelo")
@NamedQuery(name="InvModelo.findAll", query="SELECT i FROM InvModelo i")
public class InvModelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modelo", unique=true, nullable=false)
	private Integer idModelo;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to InvMarca
	@ManyToOne
	@JoinColumn(name="id_marca", nullable=false)
	private InvMarca invMarca;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="invModelo")
	private List<InvProducto> invProductos;

	public InvModelo() {
	}

	public Integer getIdModelo() {
		return this.idModelo;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public InvMarca getInvMarca() {
		return this.invMarca;
	}

	public void setInvMarca(InvMarca invMarca) {
		this.invMarca = invMarca;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setInvModelo(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setInvModelo(null);

		return invProducto;
	}

}