//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.21 at 11:46:15 PM CET 
//


package soap;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserRoleEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UserRoleEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ADMIN"/>
 *     &lt;enumeration value="CASUAL_USER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UserRoleEnum", namespace = "https://www.praca_magister/soap_vs_rest/users.com")
@XmlEnum
public enum UserRoleEnum {

    ADMIN,
    CASUAL_USER;

    public String value() {
        return name();
    }

    public static UserRoleEnum fromValue(String v) {
        return valueOf(v);
    }

}
