//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.27 at 10:23:47 PM COT 
//


package com.bpm4sb.bpmn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tParticipantAssociation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tParticipantAssociation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tBaseElement">
 *       &lt;sequence>
 *         &lt;element name="innerParticipantRef" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *         &lt;element name="outerParticipantRef" type="{http://www.w3.org/2001/XMLSchema}QName"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tParticipantAssociation", propOrder = {
    "innerParticipantRef",
    "outerParticipantRef"
})
public class TParticipantAssociation
    extends TBaseElement
{

    @XmlElement(required = true)
    protected QName innerParticipantRef;
    @XmlElement(required = true)
    protected QName outerParticipantRef;

    /**
     * Gets the value of the innerParticipantRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getInnerParticipantRef() {
        return innerParticipantRef;
    }

    /**
     * Sets the value of the innerParticipantRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setInnerParticipantRef(QName value) {
        this.innerParticipantRef = value;
    }

    /**
     * Gets the value of the outerParticipantRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getOuterParticipantRef() {
        return outerParticipantRef;
    }

    /**
     * Sets the value of the outerParticipantRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setOuterParticipantRef(QName value) {
        this.outerParticipantRef = value;
    }

}
