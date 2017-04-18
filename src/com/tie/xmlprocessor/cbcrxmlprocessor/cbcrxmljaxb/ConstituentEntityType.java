//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.05 at 10:41:30 AM EDT 
//


package com.tie.xmlprocessor.cbcrxmlprocessor.cbcrxmljaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConstituentEntity_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConstituentEntity_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConstEntity" type="{urn:oecd:ties:cbc:v1}OrganisationParty_Type"/>
 *         &lt;element name="IncorpCountryCode" type="{urn:oecd:ties:isocbctypes:v1}CountryCode_Type" minOccurs="0"/>
 *         &lt;element name="BizActivities" type="{urn:oecd:ties:cbc:v1}CbcBizActivityType_EnumType" maxOccurs="unbounded"/>
 *         &lt;element name="OtherEntityInfo" type="{urn:oecd:ties:cbc:v1}StringMaxLengthForLongText_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConstituentEntity_Type", propOrder = {
    "constEntity",
    "incorpCountryCode",
    "bizActivities",
    "otherEntityInfo"
})
public class ConstituentEntityType {

    @XmlElement(name = "ConstEntity", required = true)
    protected OrganisationPartyType constEntity;
    @XmlElement(name = "IncorpCountryCode")
    protected CountryCodeType incorpCountryCode;
    @XmlElement(name = "BizActivities", required = true)
    protected List<CbcBizActivityTypeEnumType> bizActivities;
    @XmlElement(name = "OtherEntityInfo")
    protected String otherEntityInfo;

    /**
     * Gets the value of the constEntity property.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationPartyType }
     *     
     */
    public OrganisationPartyType getConstEntity() {
        return constEntity;
    }

    /**
     * Sets the value of the constEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationPartyType }
     *     
     */
    public void setConstEntity(OrganisationPartyType value) {
        this.constEntity = value;
    }

    /**
     * Gets the value of the incorpCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link CountryCodeType }
     *     
     */
    public CountryCodeType getIncorpCountryCode() {
        return incorpCountryCode;
    }

    /**
     * Sets the value of the incorpCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryCodeType }
     *     
     */
    public void setIncorpCountryCode(CountryCodeType value) {
        this.incorpCountryCode = value;
    }

    /**
     * Gets the value of the bizActivities property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bizActivities property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBizActivities().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CbcBizActivityTypeEnumType }
     * 
     * 
     */
    public List<CbcBizActivityTypeEnumType> getBizActivities() {
        if (bizActivities == null) {
            bizActivities = new ArrayList<CbcBizActivityTypeEnumType>();
        }
        return this.bizActivities;
    }

    /**
     * Gets the value of the otherEntityInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherEntityInfo() {
        return otherEntityInfo;
    }

    /**
     * Sets the value of the otherEntityInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherEntityInfo(String value) {
        this.otherEntityInfo = value;
    }

}