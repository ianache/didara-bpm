//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.28 at 11:39:24 PM COT 
//


package com.bpm4sb.bpmn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tConversationAssociation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tConversationAssociation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tBaseElement">
 *       &lt;attribute name="innerConversationNodeRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="outerConversationNodeRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tConversationAssociation")
public class TConversationAssociation
    extends TBaseElement
{

    @XmlAttribute(name = "innerConversationNodeRef", required = true)
    protected QName innerConversationNodeRef;
    @XmlAttribute(name = "outerConversationNodeRef", required = true)
    protected QName outerConversationNodeRef;

    /**
     * Gets the value of the innerConversationNodeRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getInnerConversationNodeRef() {
        return innerConversationNodeRef;
    }

    /**
     * Sets the value of the innerConversationNodeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setInnerConversationNodeRef(QName value) {
        this.innerConversationNodeRef = value;
    }

    /**
     * Gets the value of the outerConversationNodeRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getOuterConversationNodeRef() {
        return outerConversationNodeRef;
    }

    /**
     * Sets the value of the outerConversationNodeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setOuterConversationNodeRef(QName value) {
        this.outerConversationNodeRef = value;
    }

}
