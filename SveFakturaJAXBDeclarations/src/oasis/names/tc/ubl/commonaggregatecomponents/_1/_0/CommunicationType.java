//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.06 at 06:07:59 em CEST 
//


package oasis.names.tc.ubl.commonaggregatecomponents._1._0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.ubl.codelist.channelcode._1._0.ChannelCodeType;
import oasis.names.tc.ubl.commonbasiccomponents._1._0.ValueType;


/**
 * 
 *         
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:oasis:names:tc:ubl:CoreComponentParameters:1:0" xmlns="urn:oasis:names:tc:ubl:CommonAggregateComponents:1:0" xmlns:cbc="urn:oasis:names:tc:ubl:CommonBasicComponents:1:0" xmlns:chc="urn:oasis:names:tc:ubl:codelist:ChipCode:1:0" xmlns:chn="urn:oasis:names:tc:ubl:codelist:ChannelCode:1:0" xmlns:cnt="urn:oasis:names:tc:ubl:codelist:CountryIdentificationCode:1:0" xmlns:cur="urn:oasis:names:tc:ubl:codelist:CurrencyCode:1:0" xmlns:lat="urn:oasis:names:tc:ubl:codelist:LatitudeDirectionCode:1:0" xmlns:lon="urn:oasis:names:tc:ubl:codelist:LongitudeDirectionCode:1:0" xmlns:lstat="urn:oasis:names:tc:ubl:codelist:LineStatusCode:1:0" xmlns:pty="urn:oasis:names:tc:ubl:codelist:PaymentMeansCode:1:0" xmlns:rsn="urn:oasis:names:tc:ubl:codelist:AllowanceChargeReasonCode:1:0" xmlns:sdt="urn:oasis:names:tc:ubl:SpecializedDatatypes:1:0" xmlns:sst="urn:oasis:names:tc:ubl:codelist:SubstitutionStatusCode:1:0" xmlns:stat="urn:oasis:names:tc:ubl:codelist:DocumentStatusCode:1:0" xmlns:udt="urn:oasis:names:tc:ubl:UnspecializedDatatypes:1:0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Communication. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;information that identifies a means of communicating&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Communication&lt;/ccts:ObjectClass&gt;
 *         &lt;/ccts:Component&gt;
 * </pre>
 * 
 *       
 * 
 * <p>Java class for CommunicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChannelCode" type="{urn:oasis:names:tc:ubl:codelist:ChannelCode:1:0}ChannelCodeType"/>
 *         &lt;element ref="{urn:oasis:names:tc:ubl:CommonBasicComponents:1:0}Value" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationType", propOrder = {
    "channelCode",
    "value"
})
public class CommunicationType {

    @XmlElement(name = "ChannelCode", required = true)
    protected ChannelCodeType channelCode;
    @XmlElement(name = "Value", namespace = "urn:oasis:names:tc:ubl:CommonBasicComponents:1:0")
    protected ValueType value;

    /**
     * Gets the value of the channelCode property.
     * 
     * @return
     *     possible object is
     *     {@link ChannelCodeType }
     *     
     */
    public ChannelCodeType getChannelCode() {
        return channelCode;
    }

    /**
     * Sets the value of the channelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChannelCodeType }
     *     
     */
    public void setChannelCode(ChannelCodeType value) {
        this.channelCode = value;
    }

    /**
     * 
     *             
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:oasis:names:tc:ubl:CoreComponentParameters:1:0" xmlns="urn:oasis:names:tc:ubl:CommonAggregateComponents:1:0" xmlns:cbc="urn:oasis:names:tc:ubl:CommonBasicComponents:1:0" xmlns:chc="urn:oasis:names:tc:ubl:codelist:ChipCode:1:0" xmlns:chn="urn:oasis:names:tc:ubl:codelist:ChannelCode:1:0" xmlns:cnt="urn:oasis:names:tc:ubl:codelist:CountryIdentificationCode:1:0" xmlns:cur="urn:oasis:names:tc:ubl:codelist:CurrencyCode:1:0" xmlns:lat="urn:oasis:names:tc:ubl:codelist:LatitudeDirectionCode:1:0" xmlns:lon="urn:oasis:names:tc:ubl:codelist:LongitudeDirectionCode:1:0" xmlns:lstat="urn:oasis:names:tc:ubl:codelist:LineStatusCode:1:0" xmlns:pty="urn:oasis:names:tc:ubl:codelist:PaymentMeansCode:1:0" xmlns:rsn="urn:oasis:names:tc:ubl:codelist:AllowanceChargeReasonCode:1:0" xmlns:sdt="urn:oasis:names:tc:ubl:SpecializedDatatypes:1:0" xmlns:sst="urn:oasis:names:tc:ubl:codelist:SubstitutionStatusCode:1:0" xmlns:stat="urn:oasis:names:tc:ubl:codelist:DocumentStatusCode:1:0" xmlns:udt="urn:oasis:names:tc:ubl:UnspecializedDatatypes:1:0" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Communication. Value. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;the value of the communication channel (e.g. phone number, email address,etc.)&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Communication&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Value&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;"+44 1 2345 6789" "president@whitehouse.com"&lt;/ccts:Examples&gt;
     *             &lt;/ccts:Component&gt;
     * </pre>
     * 
     *           
     * 
     * @return
     *     possible object is
     *     {@link ValueType }
     *     
     */
    public ValueType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueType }
     *     
     */
    public void setValue(ValueType value) {
        this.value = value;
    }

}