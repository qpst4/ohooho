package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hr0 {
    public final String a;
    public final JSONObject b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final ArrayList i;
    public final ArrayList j;

    public hr0(String str) {
        this.a = str;
        JSONObject jSONObject = new JSONObject(str);
        this.b = jSONObject;
        String strOptString = jSONObject.optString("productId");
        this.c = strOptString;
        String strOptString2 = jSONObject.optString("type");
        this.d = strOptString2;
        if (TextUtils.isEmpty(strOptString)) {
            zy.n("Product id cannot be empty.");
            throw null;
        }
        if (TextUtils.isEmpty(strOptString2)) {
            zy.n("Product type cannot be empty.");
            throw null;
        }
        this.e = jSONObject.optString("title");
        jSONObject.optString("name");
        this.f = jSONObject.optString("description");
        jSONObject.optString("packageDisplayName");
        jSONObject.optString("iconUrl");
        this.g = jSONObject.optString("skuDetailsToken");
        this.h = jSONObject.optString("serializedDocid");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                arrayList.add(new gr0(jSONArrayOptJSONArray.getJSONObject(i)));
            }
            this.i = arrayList;
        } else {
            this.i = (strOptString2.equals("subs") || strOptString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject jSONObjectOptJSONObject = this.b.optJSONObject("oneTimePurchaseOfferDetails");
        JSONArray jSONArrayOptJSONArray2 = this.b.optJSONArray("oneTimePurchaseOfferDetailsList");
        ArrayList arrayList2 = new ArrayList();
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                arrayList2.add(new er0(jSONArrayOptJSONArray2.getJSONObject(i2)));
            }
            this.j = arrayList2;
            return;
        }
        if (jSONObjectOptJSONObject == null) {
            this.j = null;
        } else {
            arrayList2.add(new er0(jSONObjectOptJSONObject));
            this.j = arrayList2;
        }
    }

    public final er0 a() {
        ArrayList arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (er0) arrayList.get(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof hr0) {
            return TextUtils.equals(this.a, ((hr0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ProductDetails{jsonString='" + this.a + "', parsedJson=" + this.b.toString() + ", productId='" + this.c + "', productType='" + this.d + "', title='" + this.e + "', productDetailsToken='" + this.g + "', subscriptionOfferDetails=" + String.valueOf(this.i) + "}";
    }
}
