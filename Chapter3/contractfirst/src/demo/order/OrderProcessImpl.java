
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package demo.order;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.2
 * Mon Oct 19 14:25:48 IST 2009
 * Generated source version: 2.2.2
 * 
 */

@javax.jws.WebService(
                      serviceName = "OrderProcessService",
                      portName = "OrderProcessPort",
                      targetNamespace = "http://order.demo/",
                      wsdlLocation = "file:OrderProcess.wsdl",
                      endpointInterface = "demo.order.OrderProcess")
                      
public class OrderProcessImpl implements OrderProcess {

    private static final Logger LOG = Logger.getLogger(OrderProcessImpl.class.getName());

    /* (non-Javadoc)
     * @see demo.order.OrderProcess#processOrder(demo.order.Order  arg0 )*
     */
    public java.lang.String processOrder(demo.order.Order arg0) { 
        LOG.info("Executing operation processOrder");
        System.out.println(arg0);
        try {
            java.lang.String _return = "ORD1234";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
