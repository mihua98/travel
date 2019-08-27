package com.hm.travel.config;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
/**
 * @author jlz
 * @date 2019/8/27 11:40
 */
public class MD5Config {

        public static String getMD5Code(String content){
            return Hashing.md5().newHasher().putString(content, Charsets.UTF_8).hash().toString();
        }

}
