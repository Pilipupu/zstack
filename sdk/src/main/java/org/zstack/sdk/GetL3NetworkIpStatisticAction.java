package org.zstack.sdk;

import java.util.HashMap;
import java.util.Map;
import org.zstack.sdk.*;

public class GetL3NetworkIpStatisticAction extends AbstractAction {

    private static final HashMap<String, Parameter> parameterMap = new HashMap<>();

    private static final HashMap<String, Parameter> nonAPIParameterMap = new HashMap<>();

    public static class Result {
        public ErrorCode error;
        public org.zstack.sdk.GetL3NetworkIpStatisticResult value;

        public Result throwExceptionIfError() {
            if (error != null) {
                throw new ApiException(
                    String.format("error[code: %s, description: %s, details: %s]", error.code, error.description, error.details)
                );
            }
            
            return this;
        }
    }

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String l3NetworkUuid;

    @Param(required = false, validValues = {"All","Vip","VM"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String resourceType = "All";

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String ip;

    @Param(required = false, validValues = {"Ip","CreateDate"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String sortBy = "Ip";

    @Param(required = false, validValues = {"asc","desc"}, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String sortDirection = "asc";

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, numberRange = {0L,2147483647L}, noTrim = false)
    public java.lang.Integer start = 0;

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, numberRange = {0L,2147483647L}, noTrim = false)
    public java.lang.Integer limit = 20;

    @Param(required = false, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public boolean replyWithCount = false;

    @Param(required = false)
    public java.util.List systemTags;

    @Param(required = false)
    public java.util.List userTags;

    @Param(required = false)
    public String sessionId;

    @Param(required = false)
    public String accessKeyId;

    @Param(required = false)
    public String accessKeySecret;

    @Param(required = false)
    public String requestIp;


    private Result makeResult(ApiResult res) {
        Result ret = new Result();
        if (res.error != null) {
            ret.error = res.error;
            return ret;
        }
        
        org.zstack.sdk.GetL3NetworkIpStatisticResult value = res.getResult(org.zstack.sdk.GetL3NetworkIpStatisticResult.class);
        ret.value = value == null ? new org.zstack.sdk.GetL3NetworkIpStatisticResult() : value; 

        return ret;
    }

    public Result call() {
        ApiResult res = ZSClient.call(this);
        return makeResult(res);
    }

    public void call(final Completion<Result> completion) {
        ZSClient.call(this, new InternalCompletion() {
            @Override
            public void complete(ApiResult res) {
                completion.complete(makeResult(res));
            }
        });
    }

    protected Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    protected Map<String, Parameter> getNonAPIParameterMap() {
        return nonAPIParameterMap;
    }

    protected RestInfo getRestInfo() {
        RestInfo info = new RestInfo();
        info.httpMethod = "GET";
        info.path = "/l3-networks/{l3NetworkUuid}/ip-statistic";
        info.needSession = true;
        info.needPoll = false;
        info.parameterName = "";
        return info;
    }

}
