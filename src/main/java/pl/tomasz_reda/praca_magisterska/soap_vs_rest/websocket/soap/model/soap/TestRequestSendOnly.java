//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.23 at 01:49:41 PM CET 
//


package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="testObjectMain" type="{https://www.praca_magister/soap_vs_rest/test.com}TestObjectMain"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "testObjectMain"
})
@XmlRootElement(name = "TestRequestSendOnly", namespace = "https://www.praca_magister/soap_vs_rest/test.com")
public class TestRequestSendOnly {

    @XmlElement(namespace = "https://www.praca_magister/soap_vs_rest/test.com", required = true)
    protected TestObjectMain testObjectMain;

    /**
     * Gets the value of the testObjectMain property.
     * 
     * @return
     *     possible object is
     *     {@link TestObjectMain }
     *     
     */
    public TestObjectMain getTestObjectMain() {
        return testObjectMain;
    }

    /**
     * Sets the value of the testObjectMain property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestObjectMain }
     *     
     */
    public void setTestObjectMain(TestObjectMain value) {
        this.testObjectMain = value;
    }

}
