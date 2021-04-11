/**
 * NoticiaSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.9  Built on : Nov 16, 2018 (12:05:37 GMT)
 */
package noticia;

/**
 *  NoticiaSkeleton java skeleton for the axisService
 */
public class NoticiaSkeleton {
    public static String titular = "Titular por defecto!";
    public static String descripcion = "Descripcion por defecto!";
    public static String url = "http://url.com";

    /**
     * Auto generated method signature
     *
     * @param getTitular
     * @return getTitularResponse
     */
    public noticia.GetTitularResponse getTitular(noticia.GetTitular getTitular) {
        noticia.GetTitularResponse resp = new noticia.GetTitularResponse();
        resp.set_return(NoticiaSkeleton.titular);
        return resp;
    }

    /**
     * Auto generated method signature
     *
     * @param setTitular
     * @return
     */
    public void setTitular(noticia.SetTitular setTitular) {
        NoticiaSkeleton.titular = setTitular.getTitular();
    }

    /**
     * Auto generated method signature
     *
     * @param setDescripcion
     * @return
     */
    public void setDescripcion(noticia.SetDescripcion setDescripcion) {
        NoticiaSkeleton.descripcion = setDescripcion.getDescripcion();
    }

    /**
     * Auto generated method signature
     *
     * @param getDescripcion
     * @return getDescripcionResponse
     */
    public noticia.GetDescripcionResponse getDescripcion(
        noticia.GetDescripcion getDescripcion) {
            noticia.GetDescripcionResponse resp = new noticia.GetDescripcionResponse();
            resp.set_return(NoticiaSkeleton.descripcion);
            return resp;
    }

    /**
     * Auto generated method signature
     *
     * @param getUrl
     * @return getUrlResponse
     */
    public noticia.GetUrlResponse getUrl(noticia.GetUrl getUrl) {
        noticia.GetUrlResponse resp = new noticia.GetUrlResponse();
        resp.set_return(url);
        return resp;
    }

    /**
     * Auto generated method signature
     *
     * @param setUrl
     * @return
     */
    public void setUrl(noticia.SetUrl setUrl) {
        NoticiaSkeleton.url = setUrl.getUrl();
    }
}
