package defpackage;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class er0 {
    public final String a;
    public final String b;
    public final String c;
    public final hm1 d;

    public er0(JSONObject jSONObject) throws JSONException {
        this.a = jSONObject.optString("formattedPrice");
        jSONObject.optLong("priceAmountMicros");
        jSONObject.optString("priceCurrencyCode");
        String strOptString = jSONObject.optString("offerIdToken");
        hm1 hm1Var = null;
        this.b = true == strOptString.isEmpty() ? null : strOptString;
        jSONObject.optString("offerId").getClass();
        jSONObject.optString("purchaseOptionId").getClass();
        jSONObject.optInt("offerType");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        em1.k(arrayList);
        if (jSONObject.has("fullPriceMicros")) {
            jSONObject.optLong("fullPriceMicros");
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("discountDisplayInfo");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.getInt("percentageDiscount");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("validTimeWindow");
        if (jSONObjectOptJSONObject2 != null) {
            jSONObjectOptJSONObject2.getLong("startTimeMillis");
            jSONObjectOptJSONObject2.getLong("endTimeMillis");
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("limitedQuantityInfo");
        if (jSONObjectOptJSONObject3 != null) {
            jSONObjectOptJSONObject3.getInt("maximumQuantity");
            jSONObjectOptJSONObject3.getInt("remainingQuantity");
        }
        this.c = jSONObject.optString("serializedDocid");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("preorderDetails");
        if (jSONObjectOptJSONObject4 != null) {
            jSONObjectOptJSONObject4.getLong("preorderReleaseTimeMillis");
            jSONObjectOptJSONObject4.getLong("preorderPresaleEndTimeMillis");
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("rentalDetails");
        if (jSONObjectOptJSONObject5 != null) {
            jSONObjectOptJSONObject5.getString("rentalPeriod");
            jSONObjectOptJSONObject5.optString("rentalExpirationPeriod").getClass();
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("autoPayDetails");
        if (jSONObjectOptJSONObject6 != null) {
            hm1Var = new hm1();
            jSONObjectOptJSONObject6.getString("type");
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject6.optJSONArray("balanceThresholds");
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i2)));
                }
            }
            JSONArray jSONArray = jSONObjectOptJSONObject6.getJSONArray("pricingPhases");
            ArrayList arrayList3 = new ArrayList();
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject7 = jSONArray.optJSONObject(i3);
                    if (jSONObjectOptJSONObject7 != null) {
                        arrayList3.add(new fr0(jSONObjectOptJSONObject7));
                    }
                }
            }
        }
        this.d = hm1Var;
    }
}
