//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.23 at 03:50:22 PM COT 
//


package com.bpm4sb.bpmn;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tProcessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tProcessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Public"/>
 *     &lt;enumeration value="Private"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tProcessType")
@XmlEnum
public enum TProcessType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Public")
    PUBLIC("Public"),
    @XmlEnumValue("Private")
    PRIVATE("Private");
    private final String value;

    TProcessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TProcessType fromValue(String v) {
        for (TProcessType c: TProcessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
