package com.appsdeveloperblogs.app.ws.model.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class BaseResponse implements Serializable {

    @NonNull
    private int responseCode;
    @NonNull
    private String responseMsg;
    @NonNull
    private String apiResTime;
    private Object data;
}
