
package xu.sheng.jiang.web_client.xu.sheng.jiang.operation;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServicePublishService", targetNamespace = "http://operation.jiang.sheng.xu/", wsdlLocation = "http://192.168.1.236:8085/webServece?wsdl")
public class WebServicePublishService
    extends Service
{

    private final static URL WEBSERVICEPUBLISHSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEPUBLISHSERVICE_EXCEPTION;
    private final static QName WEBSERVICEPUBLISHSERVICE_QNAME = new QName("http://operation.jiang.sheng.xu/", "WebServicePublishService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.1.236:8085/webServece?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEPUBLISHSERVICE_WSDL_LOCATION = url;
        WEBSERVICEPUBLISHSERVICE_EXCEPTION = e;
    }

    public WebServicePublishService() {
        super(__getWsdlLocation(), WEBSERVICEPUBLISHSERVICE_QNAME);
    }

    public WebServicePublishService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEPUBLISHSERVICE_QNAME, features);
    }

    public WebServicePublishService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEPUBLISHSERVICE_QNAME);
    }

    public WebServicePublishService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEPUBLISHSERVICE_QNAME, features);
    }

    public WebServicePublishService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicePublishService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServicePublish
     */
    @WebEndpoint(name = "WebServicePublishPort")
    public WebServicePublish getWebServicePublishPort() {
        return super.getPort(new QName("http://operation.jiang.sheng.xu/", "WebServicePublishPort"), WebServicePublish.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServicePublish
     */
    @WebEndpoint(name = "WebServicePublishPort")
    public WebServicePublish getWebServicePublishPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://operation.jiang.sheng.xu/", "WebServicePublishPort"), WebServicePublish.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEPUBLISHSERVICE_EXCEPTION!= null) {
            throw WEBSERVICEPUBLISHSERVICE_EXCEPTION;
        }
        return WEBSERVICEPUBLISHSERVICE_WSDL_LOCATION;
    }

}