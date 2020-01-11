package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_persona database table.
 * 
 */
@Entity
@Table(name="seg_persona")
@NamedQuery(name="SegPersona.findAll", query="SELECT s FROM SegPersona s")
public class SegPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona", unique=true, nullable=false)
	private Integer idPersona;

	@Column(nullable=false, length=60)
	private String apellidos;

	@Column(name="cedula_ruc", nullable=false, length=18)
	private String cedulaRuc;

	@Column(length=60)
	private String email;

	@Column(nullable=false, length=60)
	private String nombres;

	@Column(nullable=false, length=10)
	private String sexo;

	@Column(length=10)
	private String telefono;

	//bi-directional many-to-one association to ProProveedor
	@OneToMany(mappedBy="segPersona")
	private List<ProProveedor> proProveedors;

	//bi-directional many-to-one association to SegColaborador
	@OneToMany(mappedBy="segPersona")
	private List<SegColaborador> segColaboradors;

	//bi-directional many-to-one association to VenFactura
	@OneToMany(mappedBy="segPersona")
	private List<VenFactura> venFacturas;

	public SegPersona() {
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedulaRuc() {
		return this.cedulaRuc;
	}

	public void setCedulaRuc(String cedulaRuc) {
		this.cedulaRuc = cedulaRuc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<ProProveedor> getProProveedors() {
		return this.proProveedors;
	}

	public void setProProveedors(List<ProProveedor> proProveedors) {
		this.proProveedors = proProveedors;
	}

	public ProProveedor addProProveedor(ProProveedor proProveedor) {
		getProProveedors().add(proProveedor);
		proProveedor.setSegPersona(this);

		return proProveedor;
	}

	public ProProveedor removeProProveedor(ProProveedor proProveedor) {
		getProProveedors().remove(proProveedor);
		proProveedor.setSegPersona(null);

		return proProveedor;
	}

	public List<SegColaborador> getSegColaboradors() {
		return this.segColaboradors;
	}

	public void setSegColaboradors(List<SegColaborador> segColaboradors) {
		this.segColaboradors = segColaboradors;
	}

	public SegColaborador addSegColaborador(SegColaborador segColaborador) {
		getSegColaboradors().add(segColaborador);
		segColaborador.setSegPersona(this);

		return segColaborador;
	}

	public SegColaborador removeSegColaborador(SegColaborador segColaborador) {
		getSegColaboradors().remove(segColaborador);
		segColaborador.setSegPersona(null);

		return segColaborador;
	}

	public List<VenFactura> getVenFacturas() {
		return this.venFacturas;
	}

	public void setVenFacturas(List<VenFactura> venFacturas) {
		this.venFacturas = venFacturas;
	}

	public VenFactura addVenFactura(VenFactura venFactura) {
		getVenFacturas().add(venFactura);
		venFactura.setSegPersona(this);

		return venFactura;
	}

	public VenFactura removeVenFactura(VenFactura venFactura) {
		getVenFacturas().remove(venFactura);
		venFactura.setSegPersona(null);

		return venFactura;
	}

}