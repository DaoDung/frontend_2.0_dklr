package com.fds.vr.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "mtcore", "copreportrepositoryid", "copreportno", "sequenceno", "docname",
		"docno", "remarks", "modifydate", "syncdate", "keyword", "start", "end", "order_asc", "order_desc" })
@XmlRootElement(name = "VRCOPReportAttachBeanParam")
public class VRCOPReportAttachBeanParam {
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
	@QueryParam(value = "copreportrepositoryid")
	protected Long copReportRepositoryID;
	@QueryParam(value = "copreportno")
	protected String copReportNo;
	@QueryParam(value = "sequenceno")
	protected Long sequenceNo;
	@QueryParam(value = "docname")
	protected String docName;
	@QueryParam(value = "docno")
	protected String docNo;
	@QueryParam(value = "remarks")
	protected String remarks;
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

	public Long getCopReportRepositoryID() {
		return copReportRepositoryID;
	}

	public void setCopReportRepositoryID(Long copReportRepositoryID) {
		this.copReportRepositoryID = copReportRepositoryID;
	}

	public String getCopReportNo() {
		return copReportNo;
	}

	public void setCopReportNo(String copReportNo) {
		this.copReportNo = copReportNo;
	}

	public Long getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(Long sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
