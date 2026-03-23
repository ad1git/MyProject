package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtil.info("STARTING TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtil.info("PASSED TEST: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtil.error("FAILED TEST: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LoggerUtil.warn("SKIPPED TEST: " + result.getName());
    }
}