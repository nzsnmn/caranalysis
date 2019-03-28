package com.bolink.util.tencentai;

import com.alibaba.fastjson.JSONObject;
import com.bolink.vo.TxCarAiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TencentAiClient {
    private static Logger logger = LoggerFactory.getLogger(TencentAiClient.class);
	// appid, secretid secretkey请到http://open.youtu.qq.com/获取
	// 请正确填写把下面的APP_ID、SECRET_ID和SECRET_KEY
	public static final String APP_ID = "10168070";
	public static final String SECRET_ID = "AKIDHTEsgg0bnpxunDes0xyDZmoeKk3PiEaq";
	public static final String SECRET_KEY = "EWKzSwmdNxVaEnKdpx6Xr4KQXVUdeyES";
	public static final String USER_ID = "295475674"; //qq号

	public static TxCarAiResult carAnalysis(String picUrl) {

		try {
			Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT,USER_ID);
			JSONObject response;
			response = faceYoutu.CarClassifyUrl(picUrl);
			//get respose
			logger.info(response.toJSONString());
			TxCarAiResult txCarAiResult = response.toJavaObject(TxCarAiResult.class);
			return txCarAiResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
