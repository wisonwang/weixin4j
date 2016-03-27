package com.foxinmy.weixin4j.payment.mch;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.annotation.JSONField;
import com.foxinmy.weixin4j.payment.PayPackage;
import com.foxinmy.weixin4j.type.TradeType;

/**
 * 支付订单详情
 * 
 * @className MchPayPackage
 * @author jy
 * @date 2014年10月21日
 * @since JDK 1.6
 * @see
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MchPayPackage extends PayPackage {

	private static final long serialVersionUID = 8944928173669656177L;

	/**
	 * 交易类型JSAPI、NATIVE、APP 必须
	 */
	@XmlElement(name = "trade_type")
	@JSONField(name = "trade_type")
	private String tradeType;
	/**
	 * 用户在商户 appid 下的唯一 标识, trade_type 为 JSAPI 时,此参数必传
	 */
	@XmlElement(name = "openid")
	@JSONField(name = "openid")
	private String openId;

	/**
	 * 只在 trade_type 为 NATIVE 且【模式一】 时需要填写 非必须
	 */
	@XmlElement(name = "product_id")
	@JSONField(name = "product_id")
	private String productId;

	/**
	 * 扫码支付授权码 ,设备读取用户微信中的条码或者二维码信息
	 */
	@XmlElement(name = "auth_code")
	@JSONField(name = "auth_code")
	private String authCode;
	/**
	 * 指定支付方式:no_credit--指定不能使用信用卡支付
	 */
	@XmlElement(name = "limit_pay")
	@JSONField(name = "limit_pay")
	private String limitPay;
	/**
	 * 服务商下的用户子标识 非必须
	 */
	@XmlElement(name = "sub_openid")
	@JSONField(name = "sub_openid")
	private String subOpenId;

	protected MchPayPackage() {
		// jaxb required
	}

	/**
	 * 微信支付
	 * 
	 * @param body
	 *            支付详情 必填
	 * @param outTradeNo
	 *            商户侧订单号 必填
	 * @param totalFee
	 *            支付金额(单位元) 必填
	 * @param notifyUrl
	 *            支付回调URL 必填
	 * @param createIp
	 *            发起支付的IP地址 必填
	 * @param tradeType
	 *            支付类型 必填
	 * @param openId
	 *            用户唯一标识 公众号JSAPI支付必填
	 * @param authCode
	 *            支付授权码 刷卡MICROPAY支付必填
	 * @param productId
	 *            商品ID 扫码NATIVE支付必填
	 * @param attach
	 *            支付时附加信息 非必填
	 */
	public MchPayPackage(String body, String outTradeNo, double totalFee,
			String notifyUrl, String createIp, TradeType tradeType,
			String openId, String authCode, String productId, String attach) {
		this(body, null, outTradeNo, totalFee, notifyUrl, createIp, tradeType,
				openId, authCode, productId, attach, null, null, null, null,
				null);
	}

	/**
	 * 完整参数
	 * 
	 * @param body
	 *            支付详情 必填
	 * @param detail
	 *            订单详情 非必填
	 * @param outTradeNo
	 *            商户侧订单号 必填
	 * @param totalFee
	 *            支付金额(单位元) 必填
	 * @param notifyUrl
	 *            支付回调URL 必填
	 * @param createIp
	 *            发起支付的IP地址 必填
	 * @param tradeType
	 *            支付类型 必填
	 * @param openId
	 *            用户唯一标识 公众号JSAPI支付必填
	 * @param authCode
	 *            支付授权码 刷卡MICROPAY支付必填
	 * @param productId
	 *            商品ID 扫码NATIVE支付必填
	 * @param attach
	 *            支付时附加信息 非必填
	 * @param timeStart
	 *            订单生成时间 非必填
	 * @param timeExpire
	 *            订单失效时间 非必填
	 * @param goodsTag
	 *            商品标记 非必填
	 * @param productId
	 *            商品ID native支付必填
	 * @param limitPay
	 *            指定支付方式 非必填
	 * @param subOpenId
	 *            用户在子商户appid下的唯一标识 非必填
	 *            openid和sub_openid可以选传其中之一，如果选择传sub_openid ,则必须传sub_appid
	 */
	public MchPayPackage(String body, String detial, String outTradeNo,
			double totalFee, String notifyUrl, String createIp,
			TradeType tradeType, String openId, String authCode,
			String productId, String attach, Date timeStart, Date timeExpire,
			String goodsTag, String limitPay, String subOpenId) {
		super(body, detial, outTradeNo, totalFee, notifyUrl, createIp, attach,
				timeStart, timeExpire, goodsTag);
		this.tradeType = tradeType.name();
		this.openId = openId;
		this.authCode = authCode;
		this.productId = productId;
		this.limitPay = limitPay;
		this.subOpenId = subOpenId;
	}

	public String getTradeType() {
		return tradeType;
	}

	public String getOpenId() {
		return openId;
	}

	public String getAuthCode() {
		return authCode;
	}

	public String getProductId() {
		return productId;
	}

	public String getLimitPay() {
		return limitPay;
	}

	public void setLimitPay(String limitPay) {
		this.limitPay = limitPay;
	}

	public String getSubOpenId() {
		return subOpenId;
	}

	public void setSubOpenId(String subOpenId) {
		this.subOpenId = subOpenId;
	}

	@Override
	public String toString() {
		return "MchPayPackage [tradeType=" + tradeType + ", openId=" + openId
				+ ", productId=" + productId + ", authCode=" + authCode
				+ ", limitPay=" + limitPay + ", subOpenId=" + subOpenId + ", "
				+ super.toString() + "]";
	}
}
