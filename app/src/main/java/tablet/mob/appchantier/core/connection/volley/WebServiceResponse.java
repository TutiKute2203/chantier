package tablet.mob.appchantier.core.connection.volley;

import java.util.List;
import java.util.Map;

import tablet.mob.appchantier.core.base.BaseResponse;

public class WebServiceResponse extends BaseResponse {

    public WebServiceResponse(byte[] content, Map<String, String> headers, Map<String, List<String>> rawHeaders) {
        super(content, headers, rawHeaders);
    }

}
