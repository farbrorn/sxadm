//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.06 at 06:07:59 em CEST 
//


package sfti.documents.basicinvoice._1._0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import sfti.commonaggregatecomponents._1._0.SFTIDocumentReferenceType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sfti.documents.basicinvoice._1._0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LineItemCountNumeric_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "LineItemCountNumeric");
    private final static QName _Invoice_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "Invoice");
    private final static QName _TaxPointDate_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "TaxPointDate");
    private final static QName _DespatchDocumentReference_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "DespatchDocumentReference");
    private final static QName _InitialInvoiceDocumentReference_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "InitialInvoiceDocumentReference");
    private final static QName _ReceiptDocumentReference_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "ReceiptDocumentReference");
    private final static QName _RequisitionistDocumentReference_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "RequisitionistDocumentReference");
    private final static QName _AdditionalDocumentReference_QNAME = new QName("urn:sfti:documents:BasicInvoice:1:0", "AdditionalDocumentReference");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sfti.documents.basicinvoice._1._0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SFTIInvoiceType }
     * 
     */
    public SFTIInvoiceType createSFTIInvoiceType() {
        return new SFTIInvoiceType();
    }

    /**
     * Create an instance of {@link LineItemCountNumericType }
     * 
     */
    public LineItemCountNumericType createLineItemCountNumericType() {
        return new LineItemCountNumericType();
    }

    /**
     * Create an instance of {@link TaxPointDateType }
     * 
     */
    public TaxPointDateType createTaxPointDateType() {
        return new TaxPointDateType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineItemCountNumericType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "LineItemCountNumeric")
    public JAXBElement<LineItemCountNumericType> createLineItemCountNumeric(LineItemCountNumericType value) {
        return new JAXBElement<LineItemCountNumericType>(_LineItemCountNumeric_QNAME, LineItemCountNumericType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SFTIInvoiceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "Invoice")
    public JAXBElement<SFTIInvoiceType> createInvoice(SFTIInvoiceType value) {
        return new JAXBElement<SFTIInvoiceType>(_Invoice_QNAME, SFTIInvoiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TaxPointDateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "TaxPointDate")
    public JAXBElement<TaxPointDateType> createTaxPointDate(TaxPointDateType value) {
        return new JAXBElement<TaxPointDateType>(_TaxPointDate_QNAME, TaxPointDateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SFTIDocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "DespatchDocumentReference")
    public JAXBElement<SFTIDocumentReferenceType> createDespatchDocumentReference(SFTIDocumentReferenceType value) {
        return new JAXBElement<SFTIDocumentReferenceType>(_DespatchDocumentReference_QNAME, SFTIDocumentReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SFTIDocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "InitialInvoiceDocumentReference")
    public JAXBElement<SFTIDocumentReferenceType> createInitialInvoiceDocumentReference(SFTIDocumentReferenceType value) {
        return new JAXBElement<SFTIDocumentReferenceType>(_InitialInvoiceDocumentReference_QNAME, SFTIDocumentReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SFTIDocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "ReceiptDocumentReference")
    public JAXBElement<SFTIDocumentReferenceType> createReceiptDocumentReference(SFTIDocumentReferenceType value) {
        return new JAXBElement<SFTIDocumentReferenceType>(_ReceiptDocumentReference_QNAME, SFTIDocumentReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SFTIDocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "RequisitionistDocumentReference")
    public JAXBElement<SFTIDocumentReferenceType> createRequisitionistDocumentReference(SFTIDocumentReferenceType value) {
        return new JAXBElement<SFTIDocumentReferenceType>(_RequisitionistDocumentReference_QNAME, SFTIDocumentReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SFTIDocumentReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:sfti:documents:BasicInvoice:1:0", name = "AdditionalDocumentReference")
    public JAXBElement<SFTIDocumentReferenceType> createAdditionalDocumentReference(SFTIDocumentReferenceType value) {
        return new JAXBElement<SFTIDocumentReferenceType>(_AdditionalDocumentReference_QNAME, SFTIDocumentReferenceType.class, null, value);
    }

}