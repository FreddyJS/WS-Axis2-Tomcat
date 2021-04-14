package movie;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.addressing.EndpointReference;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMAbstractFactory;

public class MovieService {
    
    public String read_movie(String movie) throws AxisFault{
        movie = movie.replace(" ", "%20");
        Movie data = MovieReader.get_movie(movie);

        if (data == null) {
            return "The movie not exists";
        }

		ServiceClient service = null;

		try {
			service = new ServiceClient();
		} catch (Exception e) {}

        Options options = new Options();
        options.setTo(new EndpointReference("http://localhost:8080/axis2/services/Noticia"));

        service.setOptions(options);

        OMElement res;
        options.setAction("urn:setTitular");
        service.sendRobust(createRequest("setTitular", "titular", data.getTitle()));

        options.setAction("urn:setDescripcion");
        service.sendRobust(createRequest("setDescripcion", "descripcion", data.getDescription()));

        options.setAction("urn:setUrl");
        service.sendRobust(createRequest("setUrl", "url", data.getUrl()));
                
        return data.toString();
    }

	public static OMElement createRequest(String operacion, String param, String data) {
		OMFactory fac = OMAbstractFactory.getOMFactory();
		OMNamespace omNs = fac.createOMNamespace("http://Noticia", "ns1");
		OMElement method = fac.createOMElement(operacion, omNs);
		if (!data.isEmpty()) {
			OMElement val = fac.createOMElement(param, omNs);
			val.setText(data);
			method.addChild(val);
		}

		return method;
	}
}