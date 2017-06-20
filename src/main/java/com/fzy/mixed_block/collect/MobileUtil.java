package com.fzy.mixed_block.collect;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 手机号工具类
 *
 *  Created by fuzhongyu on 2017/5/25.
 */
public class MobileUtil {
	

	//运营商
	public static final String SMS_ISP_MOBILE ="2";
	public static final String SMS_ISP_UNICOM ="4";
	public static final String SMS_ISP_TELECOM ="3";
	public static final String SMS_ISP_VIRTUAL ="0";
	public static final String SMS_ISP_UNKNOWN ="1";
	
	static class MobileOperatorInfo {
		private String name;
		private String type;
		private String prefix;
		
		MobileOperatorInfo(String name,String type,String prefix){
			this.name = name;
			this.type = type;
			this.prefix = prefix;
		}

		public List<String> getPrefixList() {
			return StringUtils.isBlank(this.prefix) ?new ArrayList<String>() :  Arrays.asList(this.prefix.split(",")) ;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
	}
	
	
	
	private static List<MobileOperatorInfo> mobileOperatorList = new ArrayList<MobileOperatorInfo>();
	static{
		mobileOperatorList.add(new MobileUtil.MobileOperatorInfo("中国移动",SMS_ISP_MOBILE,"134,135,136,137,138,139,147,150,151,152,157,158,159,182,183,184,187,188,178"));
		mobileOperatorList.add(new MobileUtil.MobileOperatorInfo("中国联通",SMS_ISP_UNICOM,"130,131,132,155,156,185,186,145,176"));
		mobileOperatorList.add(new MobileUtil.MobileOperatorInfo("中国电信",SMS_ISP_TELECOM,"133,153,180,189,181,177"));
		mobileOperatorList.add(new MobileUtil.MobileOperatorInfo("虚拟运营商",SMS_ISP_VIRTUAL,"170"));
		mobileOperatorList.add(new MobileUtil.MobileOperatorInfo("未知运营商",SMS_ISP_UNKNOWN,""));
	}

	/**
	 * 根据手机号获取手机运营商
	 * @param phone
	 * @return
	 */
	public static String validatePhoneNumbISP(String phone){ 
		String ispType = "";
		if (phone == null || phone.trim().length() != 11) {
			ispType = "-1";
		} else {
			for (MobileOperatorInfo moinfo : mobileOperatorList) {
				if ((StringUtils.isNotBlank(phone)) && phone.length() > 3) {
					String curPre = phone.substring(0, 3);
					if (moinfo.getPrefixList().contains(curPre)) {
						ispType = moinfo.getType();
						break;
					}
				}
			}
		}
		return ispType;
	}

}
