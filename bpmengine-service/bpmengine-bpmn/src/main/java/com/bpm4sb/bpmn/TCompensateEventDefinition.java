//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.27 at 10:23:47 PM COT 
//


package com.bpm4sb.bpmn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tCompensateEventDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCompensateEventDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tEventDefinition">
 *       &lt;attribute name="waitForCompletion" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="activityRef" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCompensateEventDefinition")
public class TCompensateEventDefinition
    extends TEventDefinition
{

    @XmlAttribute(name = "waitForCompletion")
    protected Boolean waitForCompletion;
    @XmlAttribute(name = "activityRef")
    protected QName activityRef;

    /**
     * Gets the value of the waitForCompletion property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWaitForCompletion() {
        return waitForCompletion;
    }

    /**
     * Sets the value of the waitForCompletion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWaitForCompletion(Boolean value) {
        this.waitForCompletion = value;
    }

    /**
     * Gets the value of the activityRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getActivityRef() {
        return activityRef;
    }

    /**
     * Sets the value of the activityRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setActivityRef(QName value) {
        this.activityRef = value;
    }

}
