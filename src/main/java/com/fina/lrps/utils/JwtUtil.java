package com.fina.lrps.utils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String TOKEN_SECRET = "f26e587c28064d0e855e72c0a6a0e618";//密钥 用于解密和加密
    private static final long EXPIRE_TIME = 15 * 60 * 1000;//token过期时间 暂不启用

    public static String getToken(String studentId){//生成token
        try{
            Algorithm algorithm =  Algorithm.HMAC256(TOKEN_SECRET);
            Map<String,Object> header = new HashMap<>(2);
            header.put("typ","JWT");
            header.put("alg","HS256");
            return JWT.create()
                    .withHeader(header)
                    .withClaim("studentId",studentId)
                    .sign(algorithm);
        }catch (Exception e){
            return null;
        }
    }

    public static boolean verify(String token){//解密token
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return  true;
        }catch (Exception e){
            return false;
        }
    }

    public static JSONObject getPayLoad(String token){//提取PayLoad
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT verify = verifier.verify(token);
        String payload = verify.getPayload();
        Base64.Decoder decoder = Base64.getDecoder();
        String payloadStr = new String(decoder.decode(payload), StandardCharsets.UTF_8);
        return JSONObject.parseObject(payloadStr);
    }
}
