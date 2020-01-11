package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_colaborador database table.
 * 
 */
@Entity
@Table(name="seg_colaborador")
@NamedQuery(name="SegColaborador.findAll", query="SELECT s FROM SegColaborador s")
public class SegColaborador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colaborador", unique=true, nullable=false)
	private Integer idColaborador;

	@Column(nullable=false)
	private Boolean activo;

	@Column(nullable=false, length=32)
	private String clave;

	//bi-directional many-to-one association to SegPersona
	@ManyToOne
	@JoinColumn(name="id_persona", nullable=false)
	private SegPersona segPersona;

	//bi-directional many-to-one association to SegRol
	@ManyToOne
	@JoinColumn(name="id_rol", nullable=false)
	private SegRol segRol;

	public SegColaborador() {
	}

	public Integer getIdColaborador() {
		return this.idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public SegPersona getSegPersona() {
		return this.segPersona;
	}

	public void setSegPersona(SegPersona segPersona) {
		this.segPersona = segPersona;
	}

	public SegRol getSegRol() {
		return this.segRol;
	}

	public void setSegRol(SegRol segRol) {
		this.segRol = segRol;
	}

}