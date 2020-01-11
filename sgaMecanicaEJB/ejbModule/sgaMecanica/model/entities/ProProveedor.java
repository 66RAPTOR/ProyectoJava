package sgaMecanica.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pro_proveedor database table.
 * 
 */
@Entity
@Table(name="pro_proveedor")
@NamedQuery(name="ProProveedor.findAll", query="SELECT p FROM ProProveedor p")
public class ProProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_proveedor", unique=true, nullable=false)
	private Integer idProveedor;

	@Column(length=60)
	private String correo;

	@Column(length=200)
	private String direccion;

	@Column(name="nombre_empresa", nullable=false, length=200)
	private String nombreEmpresa;

	@Column(nullable=false, length=13)
	private String ruc;

	@Column(length=10)
	private String telefono;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="proProveedor")
	private List<InvProducto> invProductos;

	//bi-directional many-to-one association to SegPersona
	@ManyToOne
	@JoinColumn(name="id_persona", nullable=false)
	private SegPersona segPersona;

	public ProProveedor() {
	}

	public Integer getIdProveedor() {
		return this.idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setProProveedor(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setProProveedor(null);

		return invProducto;
	}

	public SegPersona getSegPersona() {
		return this.segPersona;
	}

	public void setSegPersona(SegPersona segPersona) {
		this.segPersona = segPersona;
	}

}