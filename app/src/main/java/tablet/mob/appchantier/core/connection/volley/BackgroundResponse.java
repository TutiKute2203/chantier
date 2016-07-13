package tablet.mob.appchantier.core.connection.volley;

import java.util.List;
import java.util.Map;

import tablet.mob.appchantier.core.base.BaseResponse;
import tablet.mob.appchantier.core.util.Constant.RequestTarget;


@SuppressWarnings("unused")
public class BackgroundResponse extends BaseResponse {

    private final RequestTarget target;

    public BackgroundResponse(byte[] content, Map<String, String> headers, Map<String, List<String>> rawHeaders,
                              RequestTarget target) {
        super(content, headers, rawHeaders);
        this.target = target;
    }

    /**
     * @return the target
     */
    public RequestTarget getRequestTarget() {
        return target;
    }
}
