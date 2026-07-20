package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hr extends ir {
    public final int h0;
    public final gr i0 = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: gr
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.a.m0(sharedPreferences, str);
        }
    };

    /* JADX WARN: Type inference failed for: r1v1, types: [gr] */
    public hr(int i) {
        this.h0 = i;
    }

    @Override // defpackage.j30
    public void P() {
        this.F = true;
        n0();
    }

    @Override // defpackage.j30
    public void R() {
        this.F = true;
        l0();
    }

    @Override // defpackage.gq0
    public void i0(String str, Bundle bundle) {
        lq0 lq0Var = this.Z;
        lq0Var.f = "temp";
        lq0Var.c = null;
        lq0Var.b().edit().clear().commit();
        Context contextU = u();
        int i = this.h0;
        lq0.d(contextU, i);
        SharedPreferences.Editor editorEdit = this.Z.b().edit();
        o0(editorEdit);
        editorEdit.commit();
        k0(null, i);
    }

    public final void l0() {
        this.Z.b().registerOnSharedPreferenceChangeListener(this.i0);
    }

    public abstract void m0(SharedPreferences sharedPreferences, String str);

    public final void n0() {
        this.Z.b().unregisterOnSharedPreferenceChangeListener(this.i0);
    }

    public abstract void o0(SharedPreferences.Editor editor);
}
