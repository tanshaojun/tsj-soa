package com.tsj.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 * 
 * @description  身份证合法性校验、以及处理类
 * 
 * 				身份证前6位【ABCDEF】为行政区划数字代码（简称数字码）说明（参考《GB/T 2260-2007
 *              中华人民共和国行政区划代码》）：
 *              该数字码的编制原则和结构分析，它采用三层六位层次码结构，按层次分别表示我国各省（自治区，直辖市，特别行政区）、
 *              市（地区，自治州，盟）、县（自治县、县级市、旗、自治旗、市辖区、林区、特区）。 数字码码位结构从左至右的含义是：
 *              第一层为AB两位代码表示省、自治区、直辖市、特别行政区；
 *              第二层为CD两位代码表示市、地区、自治州、盟、直辖市所辖市辖区、县汇总码、省（自治区）直辖县级行政区划汇总码，其中：
 *              ——01~20、51~70表示市，01、02还用于表示直辖市所辖市辖区、县汇总码； 
 *              ——21~50表示地区、自治州、盟；
 *              ——90表示省（自治区）直辖县级行政区划汇总码。 第三层为EF两位表示县、自治县、县级市、旗、自治旗、市辖区、林区、特区，其中：
 *              ——01~20表示市辖区、地区（自治州、盟）辖县级市、市辖特区以及省（自治区）直辖县级行政区划中的县级市，01通常表示辖区汇总码
 *              ——21~80表示县、自治县、旗、自治旗、林区、地区辖特区；
 *              ——81~99表示省（自治区）辖县级市。

 *              --15位身份证号码：第7、8位为出生年份(两位数)，第9、10位为出生月份，第11、12位代表出生日期，第15位代表性别，
 *              奇数为男，偶数为女。
 *              --18位身份证号码
 *              ：第7、8、9、10位为出生年份(四位数)，第11、第12位为出生月份，第13、14位代表出生日期
 *              ，第17位代表性别，奇数为男，偶数为女。

 * @ClassName: IdCardUtil
 * @version V1.0
 * @author 赵以宝
 * @Date 2015年12月7日 下午12:21:39 Copyright(c) 2015 www.ehean.com All rights
 *       reserved
 *
 */
public class IdCardUtil {
	String idcard;
	
	/**
	 * 省，直辖市代码表： { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",
	 * 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
	 * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",
	 * 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
	 * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",
	 * 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
	 */
	protected String codeAndCity[][] = { { "11", "北京" }, { "12", "天津" },
			{ "13", "河北" }, { "14", "山西" }, { "15", "内蒙古" }, { "21", "辽宁" },
			{ "22", "吉林" }, { "23", "黑龙江" }, { "31", "上海" }, { "32", "江苏" },
			{ "33", "浙江" }, { "34", "安徽" }, { "35", "福建" }, { "36", "江西" },
			{ "37", "山东" }, { "41", "河南" }, { "42", "湖北" }, { "43", "湖南" },
			{ "44", "广东" }, { "45", "广西" }, { "46", "海南" }, { "50", "重庆" },
			{ "51", "四川" }, { "52", "贵州" }, { "53", "云南" }, { "54", "西藏" },
			{ "61", "陕西" }, { "62", "甘肃" }, { "63", "青海" }, { "64", "宁夏" },
			{ "65", "新疆" }, { "71", "台湾" }, { "81", "香港" }, { "82", "澳门" },
			{ "91", "国外" } };

	private String cityCode[] = { "11", "12", "13", "14", "15", "21", "22",
			"23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
			"44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63",
			"64", "65", "71", "81", "82", "91" };

	// 每位加权因子
	private int power[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	// 第18位校检码
	private String verifyCode[] = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };

	
	public IdCardUtil(String idc) {
		idcard = idc;
		boolean validatedIdCard = isValidatedIdCard();
	}
	/**
	 * 验证所有的身份证的合法性
	 * 
	 * @return
	 */
	public boolean isValidatedIdCard() {
		if (idcard.length() == 15) {
			idcard = this.convert15To18Idcard(idcard);
		}
		return this.isValidate18IdCard();
	}

	/**
	 * @description  <p> 判断18位身份证的合法性</p>
	 * 根据〖中华人民共和国国家标准GB11643-1999〗中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。
	 * 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
	 * <p>
	 * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
	 * </p>
	 * <p>
	 * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码；
	 * 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
	 * 6.第17位数字表示性别：奇数表示男性，偶数表示女性；
	 * 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
	 * </p>
	 * <p>
	 * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4
	 * 2 1 6 3 7 9 10 5 8 4 2
	 * </p>
	 * <p>
	 * 2.将这17位数字和系数相乘的结果相加。
	 * </p>
	 * <p>
	 * 3.用加出来和除以11，看余数是多少？
	 * </p>
	 * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3
	 * 2。
	 * <p>
	 * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
	 * </p>
	 * @return boolean    返回类型 
	 * @author 赵以宝
	 * @date 2015年12月7日 下午12:56:33
	 */
	public boolean isValidate18IdCard() {
		// 非18位为假
		if (idcard.length() != 18) {
			return false;
		}
		// 获取前17位
		String idcard17 = idcard.substring(0, 17);
		// 获取第18位
		String idcard18Code = idcard.substring(17, 18);
		// 是否都为数字
		if (!isDigital(idcard17)) {
			return false;
		}

		char c[] = idcard17.toCharArray();
//		if (c == null) {
//			return false;
//		}

		int bit[];
		bit = converCharToInt(c);
		int sum17 = getPowerSum(bit);

		// 将和值与11取模得到余数进行校验码判断
		String checkCode = getCheckCodeBySum(sum17);
		if (null == checkCode) {
			return false;
		}

		// 将身份证的第18位与算出来的校码进行匹配，不相等就为假
		if (!idcard18Code.equalsIgnoreCase(checkCode)) {
			return false;
		}
		
		return true;
	}

	/**
	 * 验证15位身份证的合法性,该方法验证不准确，最好是将15转为18位后再判断，该类中已提供。
	 * 
	 * @param idcard
	 * @return
	 */
	/**
	 * 
	 * @description 描述该函数完成什么功能
	 * @param @return   
	 * @return boolean    返回类型 
	 * @throws 
	 * @author 赵以宝
	 * @date 2015年12月7日 下午12:55:59
	 */
	public boolean isValidate15Idcard() {
		// 非15位为假
		if (idcard.length() != 15) {
			return false;
		}

		// 是否全都为数字
		if (!isDigital(idcard)) {
			return false;
		}
		
		String provinceid = idcard.substring(0, 2);
		String birthday = idcard.substring(6, 12);
		int year = Integer.parseInt(idcard.substring(6, 8));
		int month = Integer.parseInt(idcard.substring(8, 10));
		int day = Integer.parseInt(idcard.substring(10, 12));

		// 判断是否为合法的省份
		boolean flag = false;
		for (String id : cityCode) {
			if (id.equals(provinceid)) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			return false;
		}

		// 该身份证生出日期在当前日期之后时为假
		Date birthdate = null;
		try {
			birthdate = new SimpleDateFormat("yyMMdd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (birthdate == null || new Date().before(birthdate)) {
			return false;
		}

		// 判断是否为合法的年份
		GregorianCalendar curDay = new GregorianCalendar();
		int curYear = curDay.get(Calendar.YEAR);
		int year2bit = Integer.parseInt(String.valueOf(curYear).substring(2));

		// 判断该年份的两位表示法，小于50的和大于当前年份的，为假
		if ((year < 15 && year > year2bit)) {
			return false;
		}

		// 判断是否为合法的月份
		if (month < 1 || month > 12) {
			return false;
		}

		// 判断是否为合法的日期
		boolean mflag = false;
		curDay.setTime(birthdate); // 将该身份证的出生日期赋于对象curDay
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			mflag = (day >= 1 && day <= 31);
			break;
		case 2: // 公历的2月非闰年有28天,闰年的2月是29天。
			if (curDay.isLeapYear(curDay.get(Calendar.YEAR))) {
				mflag = (day >= 1 && day <= 29);
			} else {
				mflag = (day >= 1 && day <= 28);
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			mflag = (day >= 1 && day <= 30);
			break;
		default:
		}
		if (!mflag) {
			return false;
		}
		return true;
	}

	/**
	 * 将15位的身份证转成18位身份证
	 * 
	 * @param idcard
	 * @return
	 */
	public String convert15To18Idcard(String idcard) {
		String idcard17 = null;
		// 非15位身份证
		if (idcard.length() != 15) {
			return null;
		}

		if (!isDigital(idcard)) {
			return null;
		}

		// 获取出生年月日
		String birthday = idcard.substring(6, 12);
		Date birthdate = null;
		try {
			birthdate = new SimpleDateFormat("yyMMdd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		Calendar cday = Calendar.getInstance();
		cday.setTime(birthdate);
		String year = String.valueOf(cday.get(Calendar.YEAR));

		idcard17 = idcard.substring(0, 6) + year + idcard.substring(8);

		char c[] = idcard17.toCharArray();
		if (null == c) {
			return null;
		}

		int bit[];

		// 将字符数组转为整型数组
		bit = converCharToInt(c);
		int sum17 = getPowerSum(bit);

		// 获取和值与11取模得到余数进行校验码
		String checkCode = getCheckCodeBySum(sum17);
		// 获取不到校验位
		if (null == checkCode) {
			return null;
		}

		// 将前17位与第18位校验码拼接
		idcard17 += checkCode;
		return idcard17;
	}

	/**
	 * 15位和18位身份证号码的基本数字和位数验校
	 * 
	 * @param idcard
	 * @return
	 */
	public boolean isIdcard(String idcard) {
		return idcard == null || "".equals(idcard) ? false : Pattern.matches(
				"(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)", idcard);
	}

	/**
	 * 15位身份证号码的基本数字和位数验校
	 * 
	 * @param idcard
	 * @return
	 */
	public boolean is15Idcard(String idcard) {
		return idcard == null || "".equals(idcard) ? false : Pattern.matches(
				"^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$",
				idcard);
	}

	/**
	 * 18位身份证号码的基本数字和位数验校
	 * 
	 * @param idcard
	 * @return
	 */
	public boolean is18Idcard(String idcard) {
		return Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$",idcard);
	}

	
	// 获取省份
	public String getProvince() {
		String provinceId = idcard.substring(0, 2);
		for (int i =0; i<codeAndCity.length; i++) {
			if (codeAndCity[i][0].equals(provinceId)) {
				return codeAndCity[i][1];
			}
		}
		return null;
	}
	// 获取性别
	public String getGendar(){
		String id17 = idcard.substring(16, 17);
		if (Integer.parseInt(id17) % 2 != 0) {
			return "男";
		} else {
			return "女";
		}
	}
	//年龄
	public int getAgeByIdCard() {
		int iAge = 0;
		Calendar cal = Calendar.getInstance();
		String year = idcard.substring(6, 10);
		int iCurrYear = cal.get(Calendar.YEAR);
		iAge = iCurrYear - Integer.valueOf(year);
		return iAge;
	}
	// 获取出生日期
	public String getBirth(){
		String bdy = idcard.substring(6, 10);
		String bdm = idcard.substring(10, 12);
		String bdd = idcard.substring(12, 14);
		String birthdate=bdy+"年"+bdm+"月"+bdd+"日";
		return birthdate;
	}
	// 获取出生日期
	public Date getBirthday(){
		String bdstr = idcard.substring(6, 14);
		Date birthdate = null;
		try {
			birthdate = new SimpleDateFormat("yyyyMMdd").parse(bdstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return birthdate;
	}
	
	/**
	 * 数字验证
	 * 
	 * @param str
	 * @return
	 */
	private boolean isDigital(String str) {
		return str == null || "".equals(str) ? false : str.matches("^[0-9]*$");
	}

	/**
	 * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
	 * 
	 * @param bit
	 * @return
	 */
	private int getPowerSum(int[] bit) {

		int sum = 0;

		if (power.length != bit.length) {
			return sum;
		}

		for (int i = 0; i < bit.length; i++) {
			for (int j = 0; j < power.length; j++) {
				if (i == j) {
					sum = sum + bit[i] * power[j];
				}
			}
		}
		return sum;
	}

	/**
	 * 将和值与11取模得到余数进行校验码判断
	 * 
	 * @param sum17
	 * @return 校验位
	 */
	private String getCheckCodeBySum(int sum17) {
		return verifyCode[sum17 % 11];
	}

	/**
	 * 将字符数组转为整型数组
	 * 
	 * @param c
	 * @return
	 * @throws NumberFormatException
	 */
	private int[] converCharToInt(char[] c) throws NumberFormatException {
		int[] a = new int[c.length];
		int k = 0;
		for (char temp : c) {
			a[k++] = Integer.parseInt(String.valueOf(temp));
		}
		return a;
	}



	public static void main(String[] args) throws Exception {

		/*String idcard18 = "130625920614041";// 18位
		IdCardUtil iv = new IdCardUtil(idcard18);
		System.out.println(iv.isValidatedIdCard());
		System.out.println("省="+iv.getProvince() +",性别=" +iv.getGendar() + ", 年龄=" + iv.getBirthday().toString());*/
		String idcard15 = "130625920614041";// 15位
		String idcard18 = "130625199206140413";// 15位
		IdCardUtil iv = new IdCardUtil(idcard18);

		System.out.println("年龄="+iv.getAgeByIdCard() +",性别=" +iv.getGendar() + ", 生日=" + iv.getBirth());

	}

}
