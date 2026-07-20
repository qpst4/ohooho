package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lq0 {
    public final Context a;
    public long b = 0;
    public SharedPreferences c = null;
    public SharedPreferences.Editor d;
    public boolean e;
    public String f;
    public PreferenceScreen g;
    public gq0 h;
    public gq0 i;
    public gq0 j;

    public lq0(Context context) {
        this.a = context;
        this.f = context.getPackageName() + "_preferences";
    }

    public static void d(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("_has_set_default_values", 0);
        lq0 lq0Var = new lq0(context);
        lq0Var.f = "temp";
        lq0Var.c = null;
        lq0Var.c(context, i);
        sharedPreferences.edit().putBoolean("_has_set_default_values", true).apply();
    }

    public final SharedPreferences.Editor a() {
        if (!this.e) {
            return b().edit();
        }
        if (this.d == null) {
            this.d = b().edit();
        }
        return this.d;
    }

    public final SharedPreferences b() {
        if (this.c == null) {
            this.c = this.a.getSharedPreferences(this.f, 0);
        }
        return this.c;
    }

    public final PreferenceScreen c(Context context, int i) {
        this.e = true;
        kq0 kq0Var = new kq0(context, this);
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            PreferenceGroup preferenceGroupC = kq0Var.c(xml);
            xml.close();
            PreferenceScreen preferenceScreen = (PreferenceScreen) preferenceGroupC;
            preferenceScreen.n(this);
            SharedPreferences.Editor editor = this.d;
            if (editor != null) {
                editor.apply();
            }
            this.e = false;
            return preferenceScreen;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
