/**
 * NoticiaCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package noticia;


/**
 *  NoticiaCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public class NoticiaCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public NoticiaCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public NoticiaCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for getTitular method
     * override this method for handling normal response from getTitular operation
     */
    public void receiveResultgetTitular(
        noticia.NoticiaStub.GetTitularResponse result) {
            System.out.println("Titular: " + result.get_return());
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getTitular operation
     */
    public void receiveErrorgetTitular(java.lang.Exception e) {
    }

    // No methods generated for meps other than in-out

    // No methods generated for meps other than in-out

    /**
     * auto generated Axis2 call back method for getDescripcion method
     * override this method for handling normal response from getDescripcion operation
     */
    public void receiveResultgetDescripcion(
        noticia.NoticiaStub.GetDescripcionResponse result) {
            System.out.println("Descripcion: " + result.get_return());
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getDescripcion operation
     */
    public void receiveErrorgetDescripcion(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getUrl method
     * override this method for handling normal response from getUrl operation
     */
    public void receiveResultgetUrl(noticia.NoticiaStub.GetUrlResponse result) {
        System.out.println("Url: " + result.get_return());
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getUrl operation
     */
    public void receiveErrorgetUrl(java.lang.Exception e) {
    }

    // No methods generated for meps other than in-out
}
