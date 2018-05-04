package com.tsj.common.utils;

public class EmailSmsMessageTemplate {

	
	public static String getEmailRegisterVerifyCodeTemplate() {
		StringBuffer sb=new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang=\"zh-CN\">");
		sb.append("<head>");
		sb.append("<meta charset=\"utf-8\">");
		sb.append("<title>[title]</title>");
		sb.append("<meta name=\"robots\" contect=\"all\"/>");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		sb.append("<style>");
		sb.append("body{font-family:微软雅黑;}");
		sb.append(".page{background-color:rgba(0, 221, 0, 0.1);height: 460px;}");
		sb.append(".content{margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.page {background-color:rgba(0, 221, 0, 0.1);height: 550px;} .content {	margin:0px auto;width:400px;}}");
		sb.append(".innblock {padding:10px;background-color:#ffffff;border:2px solid, #d5d9de;border-radius:5px;-moz-border-radius:5px;-webkit-box-shadow:0px 0px 20px #aaaaaa;-moz-box-shadow: 0px 0px 20px #aaaaaa;box-shadow: 0px 0px 20px #aaaaaa;}");
		sb.append(".title {text-align:right;font-size: 30px;margin-top: 20px;color:#008800;}");
		sb.append(".footer {color: gray;font-size: 12px;text-align:center;	margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.footer {color: gray;font-size: 12px;text-align:center;margin:0px auto;width:400px;}}");
		sb.append("p {color: #555555;}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class = \"page\">");
		sb.append("<div class = \"content\">");
		sb.append("</br>");
		sb.append("<p class = \"title\"><img style=\"width:25px; margin-top:10px;\" src=\"[logo]\" />  [title]</p> ");
		sb.append("<div class =\"innblock\">");
		sb.append("<p> 亲爱的用户，您好！ </p>");
		sb.append("<p style=\"margin-left:20px;\">非常感谢您注册[title]，您离注册成功就差一步了，加油呦！下面是您的验证码：</p>");
		sb.append("</br>");
		sb.append("<p style=\"color:red; margin-left:60px;\" >[code]</p>");
		sb.append("</br>");
		sb.append("<p style=\"margin-left:20px;\"> 请将该验证码填写到相应的输入框中，以完成注册过程！</p>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class=\"footer\"> Copyright © 2014 [homeaddress], All rights reserved!</div>");
		sb.append("</body>");
		sb.append("<!-- END BODY -->");
		sb.append("</html>");
		return sb.toString();
	}
	
	public static String getEmailModiVerifyCodeTemplate() {
		StringBuffer sb=new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang=\"zh-CN\">");
		sb.append("<head>");
		sb.append("<meta charset=\"utf-8\">");
		sb.append("<title>[title]</title>");
		sb.append("<meta name=\"robots\" contect=\"all\"/>");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		sb.append("<style>");
		sb.append("body{font-family:微软雅黑;}");
		sb.append(".page{background-color:rgba(0, 221, 0, 0.1);height: 460px;}");
		sb.append(".content{margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.page {background-color:rgba(0, 221, 0, 0.1);height: 550px;} .content {	margin:0px auto;width:400px;}}");
		sb.append(".innblock {padding:10px;background-color:#ffffff;border:2px solid, #d5d9de;border-radius:5px;-moz-border-radius:5px;-webkit-box-shadow:0px 0px 20px #aaaaaa;-moz-box-shadow: 0px 0px 20px #aaaaaa;box-shadow: 0px 0px 20px #aaaaaa;}");
		sb.append(".title {text-align:right;font-size: 30px;margin-top: 20px;color:#008800;}");
		sb.append(".footer {color: gray;font-size: 12px;text-align:center;	margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.footer {color: gray;font-size: 12px;text-align:center;margin:0px auto;width:400px;}}");
		sb.append("p {color: #555555;}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class = \"page\">");
		sb.append("<div class = \"content\">");
		sb.append("</br>");
		sb.append("<p class = \"title\"><img style=\"width:25px; margin-top:10px;\" src=\"[logo]\" />  [title]</p> ");
		sb.append("<div class =\"innblock\">");
		sb.append("<p> 亲爱的用户，您好！ </p>");
		sb.append("<p style=\"margin-left:20px;\">您正在修改[title]的电子邮箱地址，下面是您的验证码：</p>");
		sb.append("</br>");
		sb.append("<p style=\"color:red; margin-left:60px;\" >[code]</p>");
		sb.append("</br>");
		sb.append("<p style=\"margin-left:20px;\"> 如果此操作不是您所为，表明您的账号密码已经泄露，请尽快修改密码！</p>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class=\"footer\"> Copyright © 2014 [homeaddress], All rights reserved!</div>");
		sb.append("</body>");
		sb.append("<!-- END BODY -->");
		sb.append("</html>");
		return sb.toString();
	}
	
	public static String getEmailPasswordVerifyCodeTemplate() {
		StringBuffer sb=new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang=\"zh-CN\">");
		sb.append("<head>");
		sb.append("<meta charset=\"utf-8\">");
		sb.append("<title>[title]</title>");
		sb.append("<meta name=\"robots\" contect=\"all\"/>");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		sb.append("<style>");
		sb.append("body{font-family:微软雅黑;}");
		sb.append(".page{background-color:rgba(0, 221, 0, 0.1);height: 460px;}");
		sb.append(".content{margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.page {background-color:rgba(0, 221, 0, 0.1);height: 550px;} .content {	margin:0px auto;width:400px;}}");
		sb.append(".innblock {padding:10px;background-color:#ffffff;border:2px solid, #d5d9de;border-radius:5px;-moz-border-radius:5px;-webkit-box-shadow:0px 0px 20px #aaaaaa;-moz-box-shadow: 0px 0px 20px #aaaaaa;box-shadow: 0px 0px 20px #aaaaaa;}");
		sb.append(".title {text-align:right;font-size: 30px;margin-top: 20px;color:#008800;}");
		sb.append(".footer {color: gray;font-size: 12px;text-align:center;	margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.footer {color: gray;font-size: 12px;text-align:center;margin:0px auto;width:400px;}}");
		sb.append("p {color: #555555;}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class = \"page\">");
		sb.append("<div class = \"content\">");
		sb.append("</br>");
		sb.append("<p class = \"title\"><img style=\"width:25px; margin-top:10px;\" src=\"[logo]\" />  [title]</p> ");
		sb.append("<div class =\"innblock\">");
		sb.append("<p> 亲爱的用户，您好！ </p>");
		sb.append("<p style=\"margin-left:20px;\">您正在修改[title]的账户的密码，下面是您的验证码：</p>");
		sb.append("</br>");
		sb.append("<p style=\"color:red; margin-left:60px;\" >[code]</p>");
		sb.append("</br>");
		sb.append("<p style=\"margin-left:20px;\"> 如果此操作不是您所为，表明您的账号密码已经泄露，请尽快修改密码！</p>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class=\"footer\"> Copyright © 2014 [homeaddress], All rights reserved!</div>");
		sb.append("</body>");
		sb.append("<!-- END BODY -->");
		sb.append("</html>");
		return sb.toString();
	}
	
	/**
	 * 
	 * @description 生成临时密码邮件模板
	 * @return   
	 * @return String    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2016年11月30日 下午5:37:38
	 */
	public static String getEmailTempPasswordTemplate() {
		StringBuffer sb=new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang=\"zh-CN\">");
		sb.append("<head>");
		sb.append("<meta charset=\"utf-8\">");
		sb.append("<title>[title]</title>");
		sb.append("<meta name=\"robots\" contect=\"all\"/>");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		sb.append("<style>");
		sb.append("body{font-family:微软雅黑;}");
		sb.append(".page{background-color:rgba(0, 221, 0, 0.1);height: 460px;}");
		sb.append(".content{margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.page {background-color:rgba(0, 221, 0, 0.1);height: 550px;} .content {	margin:0px auto;width:400px;}}");
		sb.append(".innblock {padding:10px;background-color:#ffffff;border:2px solid, #d5d9de;border-radius:5px;-moz-border-radius:5px;-webkit-box-shadow:0px 0px 20px #aaaaaa;-moz-box-shadow: 0px 0px 20px #aaaaaa;box-shadow: 0px 0px 20px #aaaaaa;}");
		sb.append(".title {text-align:right;font-size: 30px;margin-top: 20px;color:#008800;}");
		sb.append(".footer {color: gray;font-size: 12px;text-align:center;	margin:0px auto;width:700px;}");
		sb.append("@media screen and (max-width: 768px) {.footer {color: gray;font-size: 12px;text-align:center;margin:0px auto;width:400px;}}");
		sb.append("p {color: #555555;}");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class = \"page\">");
		sb.append("<div class = \"content\">");
		sb.append("</br>");
		sb.append("<p class = \"title\"><img style=\"width:25px; margin-top:10px;\" src=\"[logo]\" />  [title]</p> ");
		sb.append("<div class =\"innblock\">");
		sb.append("<p> 您好！ </p>");
		sb.append("<p style=\"margin-left:20px;\">您正在找回[title]的账户的密码，下面是您的新的密码：</p>");
		sb.append("</br>");
		sb.append("<p style=\"color:red; margin-left:60px;\" >[code]</p>");
		sb.append("</br>");
		sb.append("<p style=\"margin-left:20px;\"> 为了您的账户安全，请尽快登录后修改密码。如非本人操作，请忽略。</p>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<div class=\"footer\"> Copyright © 2014 [homeaddress], All rights reserved!</div>");
		sb.append("</body>");
		sb.append("<!-- END BODY -->");
		sb.append("</html>");
		return sb.toString();
	}
	public static String getMobileRegisterVerifyCodeTemplate() {
		return getMobilePasswordVerifyCodeTemplate();
	}

	public static String getMobileModiVerifyCodeTemplate() {
		return getMobilePasswordVerifyCodeTemplate();
	}

	public static String getMobilePasswordVerifyCodeTemplate() {
		StringBuffer sb=new StringBuffer();
		sb.append("尊敬的用户：您的验证码：[code]，如非本人操作，可能您的账号密码泄露，请尽快修改密码。");
		return sb.toString();
	}
	
	/**
	 * 
	 * @description 生成临时密码短信模板
	 * @return   
	 * @return String    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2016年11月30日 下午5:35:23
	 */
	public static String getMobileTempPasswordTemplate() {
		StringBuffer sb=new StringBuffer();
		sb.append("尊敬的用户：您的新密码是：[code]，为了您的账户安全，请尽快登录后修改密码。如非本人操作，请忽略");
		return sb.toString();
	}
}
