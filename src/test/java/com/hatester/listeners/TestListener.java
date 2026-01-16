package com.hatester.listeners;

import com.hatester.helpers.CaptureHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext result) {
        System.out.println("Setup môi trường onStart: " + result.getStartDate());
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Kết thúc bộ test: " + result.getEndDate());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Bắt đầu chạy test case: " + result.getName());

        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case " + result.getName() + " is passed.");
        System.out.println("==> Status: " + result.getStatus());

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case " + result.getName() + " is failed.");
        System.out.println("==> Status: " + result.getStatus());
        System.out.println("==> Reason: " + result.getThrowable().getMessage());

        CaptureHelper.takeScreenshot(result.getName());
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case " + result.getName() + " is skipped.");
        System.out.println("==> Status: " + result.getStatus());

        CaptureHelper.stopRecord();
    }


    //onTestFailedButWithinSuccessPercentage() chỉ được gọi khi:
        //Có successPercentage
        //Có invocationCount > 1
        //Có ít nhất 1 lần FAIL
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Tên của testcase failed nhưng có phần trăm passed là " + result.getName());
    }
}
