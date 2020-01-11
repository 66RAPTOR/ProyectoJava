package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_marcaproducto database table.
 * 
 */
@Entity
@Table(name="inv_marcaproducto")
@NamedQuery(name="InvMarcaproducto.findAll", query="SELECT i FROM InvMarcaproducto i")
public class InvMarcaproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marcaproducto", unique=true, nullable=false)
	private Integer idMarcaproducto;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="invMarcaproducto")
	private List<InvProducto> invProductos;

	public InvMarcaproducto() {
	}

	public Integer getIdMarcaproducto() {
		return this.idMarcaproducto;
	}

	public void setIdMarcaproducto(Integer idMarcaproducto) {
		this.idMarcaproducto = idMarcaproducto;
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
		invProducto.setInvMarcaproducto(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setInvMarcaproducto(null);

		return invProducto;
	}

}