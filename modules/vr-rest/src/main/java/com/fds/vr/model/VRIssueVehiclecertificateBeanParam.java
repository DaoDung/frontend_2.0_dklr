package com.fds.vr.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "mtcore", "issueid", "dossierid", "certificateid", "vehicleprice",
		"totalquantity", "unitprice", "totalproduct", "certificaterecordno", "productionexamreportno", "modifydate",
		"syncdate", "keyword", "start", "end", "order_asc", "order_desc" })
@XmlRootElement(name = "VRIssueVehiclecertificateBeanParam")
public class VRIssueVehiclecertificateBeanParam {
	@QueryParam(value = "keyword")
	protected String keyword;
	@DefaultValue("0")
	@QueryParam(value = "start")
	protected int start;
	@DefaultValue("20")
	@QueryParam(value = "end")
	protected int end;
	@QueryParam(value = "order_asc")
	protected String order_asc;
	@QueryParam(value = "order_desc")
	protected String order_desc;
	@QueryParam(value = "id")
	protected Long id;
	@QueryParam(value = "mtcore")
	protected Long mtCore;
	@QueryParam(value = "issueid")
	protected Long issueId;
	@QueryParam(value = "dossierid")
	protected Long dossierId;
	@QueryParam(value = "certificateid")
	protected Long certificateId;
	@QueryParam(value = "vehicleprice")
	protected Long vehiclePrice;
	@QueryParam(value = "totalquantity")
	protected Long totalQuantity;
	@QueryParam(value = "unitprice")
	protected Long unitPrice;
	@QueryParam(value = "totalproduct")
	protected Integer totalProduct;
	@QueryParam(value = "certificaterecordno")
	protected String certificaterecordno;
	@QueryParam(value = "productionexamreportno")
	protected String productionexamreportno;
	@QueryParam(value = "modifydate")
	protected String modifyDate;
	@QueryParam(value = "syncdate")
	protected String syncDate;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getOrder_asc() {
		return order_asc;
	}

	public void setOrder_asc(String order_asc) {
		this.order_asc = order_asc;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMtCore() {
		return mtCore;
	}

	public void setMtCore(Long mtCore) {
		this.mtCore = mtCore;
	}

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public Long getDossierId() {
		return dossierId;
	}

	public void setDossierId(Long dossierId) {
		this.dossierId = dossierId;
	}

	public Long getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(Long certificateId) {
		this.certificateId = certificateId;
	}

	public Long getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(Long vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getTotalProduct() {
		return totalProduct;
	}

	public void setTotalProduct(Integer totalProduct) {
		this.totalProduct = totalProduct;
	}

	public String getCertificaterecordno() {
		return certificaterecordno;
	}

	public void setCertificaterecordno(String certificaterecordno) {
		this.certificaterecordno = certificaterecordno;
	}

	public String getProductionexamreportno() {
		return productionexamreportno;
	}

	public void setProductionexamreportno(String productionexamreportno) {
		this.productionexamreportno = productionexamreportno;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getSyncDate() {
		return syncDate;
	}

	public void setSyncDate(String syncDate) {
		this.syncDate = syncDate;
	}

}
