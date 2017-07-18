package net.willxlwei.utilities.impl;

import net.willxlwei.utilities.interfaces.MessageDigestService;
import org.apache.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by will on 2017/7/13.
 */
@Path("encryption")
public class MessageDigestServiceImpl implements MessageDigestService {
    private static Logger logger = Logger.getLogger("net.willxlwei");

    /**
     * @author will
     * @Date 2017-07-13 16:32
     * @Param plain text string
     * @Return MD5 32 UPPERCASE
     */
    @POST
    @Path("md5")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    @Override
    public String getMD5(String plainText) {
        logger.debug("Plaintext for message digest: " + plainText);
        String cipherText = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] cipherTextData = md.digest( plainText.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();
            for (int offset = 0; offset < cipherTextData.length; offset++) {
                if( cipherTextData[offset] < 0)
                    sb.append( Integer.toHexString( cipherTextData[offset] + 256));
                else if( cipherTextData[offset] < 16)
                    sb.append("0");
                else
                    sb.append( Integer.toHexString( cipherTextData[offset]));
            }
            cipherText = sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }

        logger.debug("CipherText after message digest: " + cipherText.toString());
        return cipherText;
    }
}
