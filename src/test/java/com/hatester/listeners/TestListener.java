package com.hatester.listeners;

import com.hatester.helpers.CaptureHelper;
import com.hatester.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("Setup môi trường onStart: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("Kết thúc bộ test: " + result.getEndDate());
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Bắt đầu chạy test case: " + result.getName());

        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");
        LogUtils.info("==> Status: " + result.getStatus());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        LogUtils.error("==> Reason: " + result.getThrowable().getMessage());

        CaptureHelper.takeScreenshot(result.getName());
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is skipped.");

        CaptureHelper.stopRecord();
    }


    //onTestFailedButWithinSuccessPercentage() chỉ được gọi khi:
    //Có successPercentage
    //Có invocationCount > 1
    //Có ít nhất 1 lần FAIL
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LogUtils.warn("Tên của testcase failed nhưng có phần trăm passed là " + result.getName());
    }
}
