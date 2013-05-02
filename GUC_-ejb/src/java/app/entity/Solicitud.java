/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naoual Amasri
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "Solicitud.findByFechaHoraEnvio", query = "SELECT s FROM Solicitud s WHERE s.fechaHoraEnvio = :fechaHoraEnvio"),
    @NamedQuery(name = "Solicitud.findByAsunto", query = "SELECT s FROM Solicitud s WHERE s.asunto = :asunto"),
    @NamedQuery(name = "Solicitud.findByDescripcion", query = "SELECT s FROM Solicitud s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Solicitud.findByEstadoActual", query = "SELECT s FROM Solicitud s WHERE s.estadoActual = :estadoActual"),
    @NamedQuery(name = "Solicitud.findByFechaAprobacion", query = "SELECT s FROM Solicitud s WHERE s.fechaAprobacion = :fechaAprobacion"),
    @NamedQuery(name = "Solicitud.findByMotivoRechazo", query = "SELECT s FROM Solicitud s WHERE s.motivoRechazo = :motivoRechazo"),
    @NamedQuery(name = "Solicitud.findByLeida", query = "SELECT s FROM Solicitud s WHERE s.leida = :leida"),
    @NamedQuery(name = "Solicitud.findByBorrado", query = "SELECT s FROM Solicitud s WHERE s.borrado = :borrado")})
public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraEnvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estadoActual")
    private String estadoActual;
    @Column(name = "fechaAprobacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAprobacion;
    @Size(max = 100)
    @Column(name = "motivoRechazo")
    private String motivoRechazo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "leida")
    private boolean leida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @JoinColumn(name = "Usuario_nif", referencedColumnName = "nif")
    @ManyToOne(optional = false)
    private Usuario usuarionif;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, Date fechaHoraEnvio, String asunto, String descripcion, String estadoActual, boolean leida, boolean borrado) {
        this.idSolicitud = idSolicitud;
        this.fechaHoraEnvio = fechaHoraEnvio;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estadoActual = estadoActual;
        this.leida = leida;
        this.borrado = borrado;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public void setFechaHoraEnvio(Date fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public boolean getLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Usuario getUsuarionif() {
        return usuarionif;
    }

    public void setUsuarionif(Usuario usuarionif) {
        this.usuarionif = usuarionif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.entity.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
