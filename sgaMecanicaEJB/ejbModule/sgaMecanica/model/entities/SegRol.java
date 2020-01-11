package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_rol database table.
 * 
 */
@Entity
@Table(name="seg_rol")
@NamedQuery(name="SegRol.findAll", query="SELECT s FROM SegRol s")
public class SegRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol", unique=true, nullable=false)
	private Integer idRol;

	@Column(nullable=false, length=20)
	private String nombre;

	//bi-directional many-to-one association to SegColaborador
	@OneToMany(mappedBy="segRol")
	private List<SegColaborador> segColaboradors;

	public SegRol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SegColaborador> getSegColaboradors() {
		return this.segColaboradors;
	}

	public void setSegColaboradors(List<SegColaborador> segColaboradors) {
		this.segColaboradors = segColaboradors;
	}

	public SegColaborador addSegColaborador(SegColaborador segColaborador) {
		getSegColaboradors().add(segColaborador);
		segColaborador.setSegRol(this);

		return segColaborador;
	}

	public SegColaborador removeSegColaborador(SegColaborador segColaborador) {
		getSegColaboradors().remove(segColaborador);
		segColaborador.setSegRol(null);

		return segColaborador;
	}

}