package com.android.billingclient.api;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class PurchaseHistoryRecord {
    public final String a;
    public final String b;
    public final JSONObject c;

    public PurchaseHistoryRecord(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = new JSONObject(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.a, purchaseHistoryRecord.a) && TextUtils.equals(this.b, purchaseHistoryRecord.b);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "PurchaseHistoryRecord. Json: ".concat(String.valueOf(this.a));
    }
}
