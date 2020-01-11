package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_categoria database table.
 * 
 */
@Entity
@Table(name="inv_categoria")
@NamedQuery(name="InvCategoria.findAll", query="SELECT i FROM InvCategoria i")
public class InvCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria", unique=true, nullable=false)
	private Integer idCategoria;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="invCategoria")
	private List<InvProducto> invProductos;

	public InvCategoria() {
	}

	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setInvCategoria(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setInvCategoria(null);

		return invProducto;
	}

}