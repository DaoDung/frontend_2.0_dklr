//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.11 at 04:36:03 PM ICT 
//


package com.fds.vr.filterconfig.xmlmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VRConditionModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VRConditionModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="filterModuleCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filterTableField" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filterTableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificationDisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificationDataCollectionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequenceNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="specificationBasicUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificationStandard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specificationGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modifyDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="syncDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VRConditionModel", propOrder = {
    "id",
    "filterModuleCode",
    "filterTableField",
    "filterTableName",
    "specificationCode",
    "specificationDisplayName",
    "specificationDataCollectionId",
    "sequenceNo",
    "specificationBasicUnit",
    "specificationStandard",
    "specificationGroup",
    "modifyDate",
    "syncDate"
})
public class VRConditionModel {

    protected Long id;
    protected String filterModuleCode;
    protected String filterTableField;
    protected String filterTableName;
    protected String specificationCode;
    protected String specificationDisplayName;
    protected String specificationDataCollectionId;
    protected Long sequenceNo;
    protected String specificationBasicUnit;
    protected String specificationStandard;
    protected String specificationGroup;
    protected String modifyDate;
    protected String syncDate;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the filterModuleCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterModuleCode() {
        return filterModuleCode;
    }

    /**
     * Sets the value of the filterModuleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterModuleCode(String value) {
        this.filterModuleCode = value;
    }

    /**
     * Gets the value of the filterTableField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterTableField() {
        return filterTableField;
    }

    /**
     * Sets the value of the filterTableField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterTableField(String value) {
        this.filterTableField = value;
    }

    /**
     * Gets the value of the filterTableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilterTableName() {
        return filterTableName;
    }

    /**
     * Sets the value of the filterTableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilterTableName(String value) {
        this.filterTableName = value;
    }

    /**
     * Gets the value of the specificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificationCode() {
        return specificationCode;
    }

    /**
     * Sets the value of the specificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificationCode(String value) {
        this.specificationCode = value;
    }

    /**
     * Gets the value of the specificationDisplayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificationDisplayName() {
        return specificationDisplayName;
    }

    /**
     * Sets the value of the specificationDisplayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificationDisplayName(String value) {
        this.specificationDisplayName = value;
    }

    /**
     * Gets the value of the specificationDataCollectionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificationDataCollectionId() {
        return specificationDataCollectionId;
    }

    /**
     * Sets the value of the specificationDataCollectionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificationDataCollectionId(String value) {
        this.specificationDataCollectionId = value;
    }

    /**
     * Gets the value of the sequenceNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSequenceNo() {
        return sequenceNo;
    }

    /**
     * Sets the value of the sequenceNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSequenceNo(Long value) {
        this.sequenceNo = value;
    }

    /**
     * Gets the value of the specificationBasicUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificationBasicUnit() {
        return specificationBasicUnit;
    }

    /**
     * Sets the value of the specificationBasicUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificationBasicUnit(String value) {
        this.specificationBasicUnit = value;
    }

    /**
     * Gets the value of the specificationStandard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificationStandard() {
        return specificationStandard;
    }

    /**
     * Sets the value of the specificationStandard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificationStandard(String value) {
        this.specificationStandard = value;
    }

    /**
     * Gets the value of the specificationGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificationGroup() {
        return specificationGroup;
    }

    /**
     * Sets the value of the specificationGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificationGroup(String value) {
        this.specificationGroup = value;
    }

    /**
     * Gets the value of the modifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModifyDate() {
        return modifyDate;
    }

    /**
     * Sets the value of the modifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModifyDate(String value) {
        this.modifyDate = value;
    }

    /**
     * Gets the value of the syncDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncDate() {
        return syncDate;
    }

    /**
     * Sets the value of the syncDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncDate(String value) {
        this.syncDate = value;
    }

}
