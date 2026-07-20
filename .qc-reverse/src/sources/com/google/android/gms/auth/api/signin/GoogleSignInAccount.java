package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.ip0;
import defpackage.tk0;
import defpackage.v;
import defpackage.zy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends v implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new ip0(13);
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Uri g;
    public String h;
    public final long i;
    public final String j;
    public final List k;
    public final String l;
    public final String m;
    public final HashSet n = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = uri;
        this.h = str5;
        this.i = j;
        this.j = str6;
        this.k = arrayList;
        this.l = str7;
        this.m = str8;
    }

    public static GoogleSignInAccount a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i), 1));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (TextUtils.isEmpty(string)) {
            zy.n("Given String is empty or null");
            return null;
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.h = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.j.equals(this.j)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.k);
        hashSet.addAll(googleSignInAccount.n);
        HashSet hashSet2 = new HashSet(this.k);
        hashSet2.addAll(this.n);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = this.j.hashCode() + 527;
        HashSet hashSet = new HashSet(this.k);
        hashSet.addAll(this.n);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        tk0.N(parcel, 2, this.c);
        tk0.N(parcel, 3, this.d);
        tk0.N(parcel, 4, this.e);
        tk0.N(parcel, 5, this.f);
        tk0.M(parcel, 6, this.g, i);
        tk0.N(parcel, 7, this.h);
        tk0.V(parcel, 8, 8);
        parcel.writeLong(this.i);
        tk0.N(parcel, 9, this.j);
        tk0.P(parcel, 10, this.k);
        tk0.N(parcel, 11, this.l);
        tk0.N(parcel, 12, this.m);
        tk0.U(parcel, iR);
    }
}
