package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_marca database table.
 * 
 */
@Entity
@Table(name="inv_marca")
@NamedQuery(name="InvMarca.findAll", query="SELECT i FROM InvMarca i")
public class InvMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marca", unique=true, nullable=false)
	private Integer idMarca;

	@Column(nullable=false, length=50)
	private String nombre;

	//bi-directional many-to-one association to InvModelo
	@OneToMany(mappedBy="invMarca")
	private List<InvModelo> invModelos;

	public InvMarca() {
	}

	public Integer getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<InvModelo> getInvModelos() {
		return this.invModelos;
	}

	public void setInvModelos(List<InvModelo> invModelos) {
		this.invModelos = invModelos;
	}

	public InvModelo addInvModelo(InvModelo invModelo) {
		getInvModelos().add(invModelo);
		invModelo.setInvMarca(this);

		return invModelo;
	}

	public InvModelo removeInvModelo(InvModelo invModelo) {
		getInvModelos().remove(invModelo);
		invModelo.setInvMarca(null);

		return invModelo;
	}

}