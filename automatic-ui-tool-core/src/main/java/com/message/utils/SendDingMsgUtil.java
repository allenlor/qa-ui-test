package com.message.utils;

import org.testng.ITestResult;
import org.testng.Reporter;
public class SendDingMsgUtil {
	public static int failSize = 0;
	public static int skipSize = 0;
	public static int successSize = 0;

	public static void sendMsg(String res) {
		
		
		ITestResult it = Reporter.getCurrentTestResult();
		successSize = it.getTestContext().getPassedTests().size();
		failSize = it.getTestContext().getFailedTests().size();
		
		System.out.println("执行失败个数"+failSize);
		skipSize = it.getTestContext().getSkippedTests().size();
		if (failSize > 0 || skipSize > 0) {
			
			System.out.println("执行钉钉消息");
			/*String body = HttpRequest.post(
					"https://oapi.dingtalk.com/robot/send?access_token=a5bcbbe8bbd2214161b9105395ee3b962416daacd40fb479faeea69c4042d7b8")
					.header("content-type", "application/json").data("{\r\n" + "    \"msgtype\": \"text\",\r\n" + "    \"text\": {\r\n"
							+ "        \"content\": \"线上登录告警，存在异常\\n执行开始时间：" + DateUtil.getCurrentTime()
							+ "\\n执行成功个数："+successSize+"\\n执行失败个数："+failSize+"\\n执行skip个数："+skipSize+"\\n报告地址：https://flow.aliyun.com/pipelines/2054758/current\"\r\n"
							+ "    }\r\n" + "\r\n" + "}")
					.send().body();*/
//			System.out.println(body);
			}
	}

}
