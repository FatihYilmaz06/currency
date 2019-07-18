
package fthylmz.currently;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Rates {

    @SerializedName("GBP")
    private Double mGBP;
    @SerializedName("TRY")
    private Double mTRY;
    @SerializedName("USD")
    private Double mUSD;

    public Double getGBP() {
        return mGBP;
    }

    public void setGBP(Double gBP) {
        mGBP = gBP;
    }

    public Double getTRY() {
        return mTRY;
    }

    public void setTRY(Double tRY) {
        mTRY = tRY;
    }

    public Double getUSD() {
        return mUSD;
    }

    public void setUSD(Double uSD) {
        mUSD = uSD;
    }

}
