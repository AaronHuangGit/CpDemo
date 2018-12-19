package com.android.demos.data.remote.http.result.base;

import com.android.demos.data.remote.http.RequestCode;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

import api.HttpResult;
import api.IResult;

/**
 * Created on 16/11/29.
 *
 * @author aaron.huang
 * @version 1.0.0
 */

public class BaseResult implements IResult {
    @SerializedName("code")
    private int mCode;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("time")
    private long mTime;

    @Nullable
    @Override
    public Integer getCode() {
        return mCode;
    }

    @Nullable
    @Override
    public String getErrorMessage() {
        return mMessage;
    }

    @Override
    public void setCode(Integer integer) {

    }

    @Override
    public void setErrorMessage(String s) {

    }

    @Nullable
    @Override
    public HttpResult getHttpResult() {
        return null;
    }

    @Override
    public void setHttpResult(HttpResult httpResult) {

    }

    @Override
    public boolean isSuccess() {
        return mCode == RequestCode.INSTANCE.getSUCCESS();
    }
}
