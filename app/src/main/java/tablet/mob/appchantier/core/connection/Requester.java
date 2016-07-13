package tablet.mob.appchantier.core.connection;

import tablet.mob.appchantier.core.base.BaseApplication;
import tablet.mob.appchantier.core.base.BaseProperties;
import tablet.mob.appchantier.core.base.Param;
import tablet.mob.appchantier.core.connection.WebServiceRequester.WebServiceResultHandler;
import tablet.mob.appchantier.core.connection.queue.QueueElement;
import tablet.mob.appchantier.core.connection.request.BackgroundServiceRequest;
import tablet.mob.appchantier.core.connection.request.ParallelServiceRequest;
import tablet.mob.appchantier.core.connection.request.QueueServiceRequest;
import tablet.mob.appchantier.core.connection.request.WebServiceRequest;
import tablet.mob.appchantier.core.util.Constant;
import tablet.mob.appchantier.core.util.Constant.RequestMethod;
import tablet.mob.appchantier.core.util.Constant.RequestTarget;
import tablet.mob.appchantier.core.util.Constant.RequestType;
import tablet.mob.appchantier.core.util.DLog;

@SuppressWarnings({"BooleanMethodIsAlwaysInverted", "unused"})
public class Requester {
    private static final String TAG = "Requester";

    public static boolean startWSRequest(String tag, RequestTarget target,
                                         String[] extras, Param content, WebServiceResultHandler handler) {

        try {
            WebServiceRequest request;
            if (BaseProperties.wsRequester == null)
                BaseProperties.wsRequester = WebServiceRequester
                        .getInstance(BaseApplication.getContext());
            switch (target) {
                case WEBSERVICE_REQUEST:
                    request = new WebServiceRequest(tag, RequestType.HTTP,
                            RequestMethod.POST, Constant.SERVER_URL, target,
                            RequestTarget.build(target, extras), content,
                            BaseProperties.wsRequester, handler);
                    break;
                default:
                    throw new Exception(
                            "Requester: No request target found");
            }
            BaseProperties.wsRequester.startRequest(request);
            DLog.d(TAG, request.getRequestMethod().name().toUpperCase()
                    + " >> " + request.getUrl());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            DLog.d(TAG, "Request canceled!");
            return false;
        }
    }

    public static boolean startBackgroundRequest(String tag,
                                                 RequestTarget target, String[] extras, Param content) {
        try {
            BackgroundServiceRequest request;
            if (BaseProperties.bgRequester == null)
                BaseProperties.bgRequester = BackgroundServiceRequester
                        .getInstance(BaseApplication.getContext());
            switch (target) {
                case BACKGROUND_REQUEST:
                    request = new BackgroundServiceRequest(tag, RequestType.HTTP,
                            RequestMethod.GET, Constant.SERVER_URL, target,
                            RequestTarget.build(target, extras), content,
                            BaseProperties.bgRequester);
                    break;
                default:
                    throw new Exception(
                            "Requester: No request target found");
            }

            BaseProperties.bgRequester.startRequest(request);
            DLog.d(TAG, request.getRequestMethod().name().toUpperCase()
                    + " >> " + request.getUrl());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            DLog.d(TAG, "Background request canceled!");
            return false;
        }
    }

    public static boolean startQueueRequest(String tag, RequestTarget target,
                                            String[] extras, QueueElement.Type type, Param content) {
        try {
            QueueServiceRequest request;
            if (BaseProperties.queueRequester == null)
                BaseProperties.queueRequester = QueueServiceRequester
                        .getInstance(BaseApplication.getContext());
            switch (target) {
                case WEBSERVICE_REQUEST:
                    request = new QueueServiceRequest(tag, RequestType.HTTP,
                            RequestMethod.POST, Constant.SERVER_URL, target,
                            RequestTarget.build(target, extras), content,
                            BaseProperties.queueRequester);
                    break;
                default:
                    throw new Exception(
                            "Requester: No request target found");
            }
            BaseProperties.queueRequester.addQueueRequest(new QueueElement(
                    request, type));
            DLog.d(TAG, request.getRequestMethod().name().toUpperCase()
                    + " >> " + request.toString());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            DLog.d(TAG, "Queue request canceled!");
            return false;
        }
    }

    public static boolean startParallelRequest(String tag, RequestTarget target,
                                               String[] extras, Param content) {
        try {
            ParallelServiceRequest request;
            if (BaseProperties.parallelRequester == null)
                BaseProperties.parallelRequester = ParallelServiceRequester
                        .getInstance(BaseApplication.getContext());
            switch (target) {
                case WEBSERVICE_REQUEST:
                    request = new ParallelServiceRequest(tag, RequestType.HTTP,
                            RequestMethod.POST, Constant.SERVER_URL, target,
                            RequestTarget.build(target, extras), content,
                            BaseProperties.parallelRequester);
                    break;
                default:
                    throw new Exception(
                            "Requester: No request target found");
            }
            ParallelServiceRequester.addRequest(request);
            DLog.d(TAG, request.getRequestMethod().name().toUpperCase()
                    + " >> " + request.toString());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            DLog.d(TAG, "Parallel request canceled!");
            return false;
        }
    }
}
