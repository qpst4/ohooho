package defpackage;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gr0 {
    public final String a;
    public final jj b;
    public final ArrayList c;

    public gr0(JSONObject jSONObject) throws JSONException {
        jSONObject.optString("basePlanId");
        jSONObject.optString("offerId").getClass();
        this.a = jSONObject.getString("offerIdToken");
        this.b = new jj(jSONObject.getJSONArray("pricingPhases"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("installmentPlanDetails");
        if (jSONObjectOptJSONObject != null) {
            jSONObjectOptJSONObject.getInt("commitmentPaymentsCount");
            jSONObjectOptJSONObject.optInt("subsequentCommitmentPaymentsCount");
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("transitionPlanDetails");
        if (jSONObjectOptJSONObject2 != null) {
            jSONObjectOptJSONObject2.getString("productId");
            jSONObjectOptJSONObject2.optString("title");
            jSONObjectOptJSONObject2.optString("name");
            jSONObjectOptJSONObject2.optString("description");
            jSONObjectOptJSONObject2.optString("basePlanId");
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("pricingPhase");
            if (jSONObjectOptJSONObject3 != null) {
                jSONObjectOptJSONObject3.optString("billingPeriod");
                jSONObjectOptJSONObject3.optString("priceCurrencyCode");
                jSONObjectOptJSONObject3.optString("formattedPrice");
                jSONObjectOptJSONObject3.optLong("priceAmountMicros");
                jSONObjectOptJSONObject3.optInt("recurrenceMode");
                jSONObjectOptJSONObject3.optInt("billingCycleCount");
            }
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("offerTags");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        this.c = arrayList;
    }
}
