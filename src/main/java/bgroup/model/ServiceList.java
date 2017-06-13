package bgroup.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Created by VSB on 11.02.2017.
 * MiS
 */


@Entity
@Table(name = "SERVICE_LIST")
public class ServiceList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "DATE_CREATE", nullable = false)
    @Type(type = "org.hibernate.type.TimestampType")
    private Timestamp dateCreate;

    @NotEmpty
    @Column(name = "DATE_DONE", nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.hibernate.type.TimestampType")
    private Timestamp dateDone;

    @NotEmpty
    @Column(name = "PARTNER_ID", nullable = false)
    private Integer partnerId;

    @NotEmpty
    @Column(name = "PARTNER_FIO", nullable = false)
    private String partnerFio;

    @NotEmpty
    @Column(name = "PARTNER_WORK", nullable = false, length = 128)
    private String partnerWork;

    @NotEmpty
    @Column(name = "CLIENT_ID", nullable = false)
    private Integer clientId;

    @NotEmpty
    @Column(name = "CLIENT_FIO", nullable = false, length = 128)
    private String clientFio;

    @NotEmpty
    @Column(name = "ID_MIS", unique = true, nullable = false)
    private Integer idMis;

    @NotEmpty
    @Column(name = "SERVICE_CODE", nullable = false, length = 24)
    private String serviceCode;

    @NotEmpty
    @Column(name = "SERVICE_NAME", nullable = false, length = 512)
    private String serviceName;

    @NotEmpty
    @Column(name = "SUM_PAY_CLIENT", nullable = false)
    private Double sumPayClient;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "PAID", columnDefinition = "BIT default 0")
    private Boolean paid;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "DELETED", columnDefinition = "BIT default 0")
    private Boolean deleted;

    public String getDateCreateStr() {
        return getDateCreate().toString().split(" ")[0];
    }

    public String getDateDoneStr() {
        return getDateDone().toString().split(" ")[0];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Timestamp getDateDone() {
        return dateDone;
    }

    public void setDateDone(Timestamp dateDone) {
        this.dateDone = dateDone;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerFio() {
        return partnerFio;
    }

    public void setPartnerFio(String partnerFio) {
        this.partnerFio = partnerFio;
    }

    public String getPartnerWork() {
        return partnerWork;
    }

    public void setPartnerWork(String partnerWork) {
        this.partnerWork = partnerWork;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientFio() {
        return clientFio;
    }

    public void setClientFio(String clientFio) {
        this.clientFio = clientFio;
    }

    public Integer getIdMis() {
        return idMis;
    }

    public void setIdMis(Integer idMis) {
        this.idMis = idMis;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getSumPayClient() {
        return sumPayClient;
    }

    public void setSumPayClient(Double sumPayClient) {
        this.sumPayClient = sumPayClient;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
