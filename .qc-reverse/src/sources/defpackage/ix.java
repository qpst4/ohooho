package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.quickcursor.R;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ix implements ol0, xr0, kz, kr0, xk {
    public static final ix c = new ix(1);
    public static final ix d = new ix(2);
    public static final ix e = new ix(3);
    public static final ix f = new ix(5);
    public static final ix g = new ix(6);
    public static ix h;
    public static ix i;
    public final /* synthetic */ int b;

    public ix(je0 je0Var) throws GeneralSecurityException {
        this.b = 24;
        String str = je0Var.d;
        if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                return;
            } catch (ic0 e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
        if (!str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(str));
        }
        try {
            h5 h5Var = (h5) w50.i(h5.f, je0Var.e);
            if (h5Var.d == null) {
                v5 v5Var = v5.f;
            }
            if (h5Var.e == null) {
                k80 k80Var = k80.f;
            }
        } catch (ic0 e3) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
        }
    }

    public static ix b(Context context, int i2) {
        f01.g("Cannot create a CalendarItemStyle with a styleResId of 0", i2 != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i2, ys0.q);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        yb0.i(context, typedArrayObtainStyledAttributes, 4);
        yb0.i(context, typedArrayObtainStyledAttributes, 9);
        yb0.i(context, typedArrayObtainStyledAttributes, 7);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        mz0.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new h(0.0f)).a();
        typedArrayObtainStyledAttributes.recycle();
        ix ixVar = new ix(10);
        f01.h(rect.left);
        f01.h(rect.top);
        f01.h(rect.right);
        f01.h(rect.bottom);
        return ixVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0066 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.Locale g(android.content.Context r5) {
        /*
            r5.getClass()
            java.lang.String r0 = "pref_language"
            r1 = 0
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r0, r1)
            java.lang.String r0 = "key_default_language"
            r2 = 0
            java.lang.String r5 = r5.getString(r0, r2)
            if (r5 == 0) goto L67
            java.lang.String r0 = "_"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            java.util.List r5 = defpackage.e31.h0(r5, r0)
            int r0 = r5.size()
            r2 = 1
            if (r0 == r2) goto L58
            r3 = 2
            if (r0 == r3) goto L46
            r4 = 3
            if (r0 == r4) goto L2d
            java.util.Locale r5 = java.util.Locale.ENGLISH
            goto L64
        L2d:
            java.util.Locale r0 = new java.util.Locale
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r5.get(r3)
            java.lang.String r5 = (java.lang.String) r5
            r0.<init>(r1, r2, r5)
        L44:
            r5 = r0
            goto L64
        L46:
            java.util.Locale r0 = new java.util.Locale
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            r0.<init>(r1, r5)
            goto L44
        L58:
            java.util.Locale r0 = new java.util.Locale
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = (java.lang.String) r5
            r0.<init>(r5)
            goto L44
        L64:
            if (r5 == 0) goto L67
            return r5
        L67:
            java.util.Locale r5 = java.util.Locale.ENGLISH
            r5.getClass()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ix.g(android.content.Context):java.util.Locale");
    }

    public static final Locale h(Context context) {
        context.getClass();
        String string = context.getSharedPreferences("pref_language", 0).getString("key_language", null);
        if (string != null) {
            List listH0 = e31.h0(string, new String[]{"_"});
            int size = listH0.size();
            Locale locale = size != 1 ? size != 2 ? size != 3 ? null : new Locale((String) listH0.get(0), (String) listH0.get(1), (String) listH0.get(2)) : new Locale((String) listH0.get(0), (String) listH0.get(1)) : new Locale((String) listH0.get(0));
            if (locale != null) {
                return locale;
            }
        }
        return null;
    }

    public static final void k(Context context, Locale locale) {
        context.getClass();
        Locale.setDefault(locale);
        String string = locale.toString();
        string.getClass();
        context.getSharedPreferences("pref_language", 0).edit().putString("key_language", string).apply();
    }

    @Override // defpackage.kz
    public Object c(String str, Provider provider) {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }

    @Override // defpackage.xk
    public long d() {
        return System.currentTimeMillis();
    }

    @Override // defpackage.kr0
    public void e() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // defpackage.kr0
    public void f(int i2, Object obj) {
        String str;
        switch (i2) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i2 == 6 || i2 == 7 || i2 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    public boolean i(CharSequence charSequence) {
        return false;
    }

    public CharSequence j(Preference preference) {
        switch (this.b) {
            case 13:
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                return TextUtils.isEmpty(editTextPreference.U) ? editTextPreference.b.getString(R.string.not_set) : editTextPreference.U;
            default:
                ListPreference listPreference = (ListPreference) preference;
                return TextUtils.isEmpty(listPreference.L()) ? listPreference.b.getString(R.string.not_set) : listPreference.L();
        }
    }

    @Override // defpackage.ol0
    public boolean s(zk0 zk0Var) {
        return false;
    }

    public /* synthetic */ ix(int i2) {
        this.b = i2;
    }

    public ix(View view) {
        this.b = 26;
    }

    @Override // defpackage.ol0
    public void a(zk0 zk0Var, boolean z) {
    }
}
